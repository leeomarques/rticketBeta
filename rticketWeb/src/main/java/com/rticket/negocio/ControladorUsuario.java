package com.rticket.negocio;

import com.rticket.excecao.ValidarLoginException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.CampoExistenteException;
import com.rticket.model.Usuario;
import com.rticket.dao.DAOFactory;
import com.rticket.dao.dados.UsuarioDAO;
import com.rticket.excecao.FormatoInvalidoException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorUsuario {

    private UsuarioDAO usuarioDAO;
    private Usuario user;

    public ControladorUsuario() {
        usuarioDAO = DAOFactory.getUsuarioDAO();
    }

    /**
     * Metodo de Verificar Caracteres Especiais
     * */
    public Boolean verificarCaracteres(String nome){
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        Matcher matcher = pattern.matcher(nome);
        return matcher.find();
    }

    /**
     * Metodo para EfetuarLogin
     * */
    public Collection<Usuario> efetuarLogin(String login, String senha)
            throws ValidarLoginException, NoSuchAlgorithmException{
        return usuarioDAO.efetuarLogin(login, converterSenhaMD5(senha));
    }

    /**
     * Metodo para verificar se o login ja existe no banco
     * */
    public Boolean buscarLogin(String login){
        return usuarioDAO.buscarLogin(login);
    }

    /**
     * Metodo para Encriptar a Senha do Usuario
     * */
    public static String converterSenhaMD5(String password)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));

        return String.format("%32x", hash);
    }
    
    private boolean isEmpty(String txt) {
    	return txt == null || txt.isEmpty();
    }

    /**
     * Metodo para Inserir Usuario
     * */
    public void inserirUsuario(Usuario usuario)
            throws CampoVazioException, CampoExistenteException,
                NoSuchAlgorithmException, FormatoInvalidoException{

    	validarCamposVazios(usuario);
    	validarUsarioExiste(usuario);
        validarFormatoInvalido(usuario);
        
        usuario.setSenha(converterSenhaMD5(usuario.getSenha())) ;
        usuarioDAO.inserir(usuario);
    }

    /**
     * Metodo para Buscar o Usuario pelo ID
     * */
    public Usuario buscarUsuario(int id){
        return usuarioDAO.buscarPorChave(id);
    }
    
    public Usuario buscarUsuario(String login) {
        return usuarioDAO.buscarUsuario(login);
    }

    /**
     * Metodo para Alterar Usuario
     * */
    public void alterarUsuario(Usuario usuario) throws FormatoInvalidoException,
            NoSuchAlgorithmException, CampoVazioException{
    	validarCamposVazios(usuario);
        validarFormatoInvalido(usuario);
        
        usuario.setSenha(converterSenhaMD5(usuario.getSenha())) ;
        usuarioDAO.alterar(usuario);
    }

    /**
     * Listar todos os Usuarios
     * */
    public Collection<Usuario> listarUsuario(){
        return usuarioDAO.listarColecao();
    }
    
    private void validarUsarioExiste(Usuario usuario) throws CampoExistenteException {
        if (buscarLogin(usuario.getLogin())) {
            throw new CampoExistenteException("Usuario: " + usuario.getNome() + " já existe");
        }
    }
    
    private void validarCamposVazios(Usuario usuario) throws CampoVazioException {
    	if (usuario == null ||
        		isEmpty(usuario.getNome()) ||
        		isEmpty(usuario.getLogin()) || 
        		isEmpty(usuario.getSenha())){
    		throw new CampoVazioException("Alterar usario com informação nula.");
        }
    }
    
    private void validarFormatoInvalido(Usuario usuario) throws FormatoInvalidoException {
    	if (!verificarCaracteres(usuario.getLogin())) {
    		throw new FormatoInvalidoException("Campo nome do usario está com formato errado");
    	}
    }
}
