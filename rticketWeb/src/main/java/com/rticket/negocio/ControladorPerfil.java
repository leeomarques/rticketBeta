package com.rticket.negocio;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.model.Perfil;
import com.rticket.dao.DAOFactory;
import com.rticket.dao.dados.PerfilDAO;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorPerfil {
    private PerfilDAO perfilDAO;
    
    public ControladorPerfil() {
        perfilDAO = DAOFactory.getPerfilDAO();
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
     * Metodo para verificar se o nome ja existe no banco
     * */
    public Boolean buscarNome(String nome){
        return perfilDAO.buscarNome(nome);
    }

    /**
     * Metodo para Inserir Perfil
     * */
    public void inserirPerfil(Perfil perfil)
            throws CampoExistenteException, FormatoInvalidoException,
                CampoVazioException{
        if (perfil == null || 
        	perfil.getNome() == null ||
        	perfil.getNome().length() <= 0){
            throw new CampoVazioException();
        }

        if (buscarNome(perfil.getNome())){
            throw new CampoExistenteException();
        }

        boolean resultado = verificarCaracteres(perfil.getNome());
        if(resultado){
        	perfilDAO.inserir(perfil);
        } else {
            throw new FormatoInvalidoException();
        }
    }

    /**
     * Metodo para Buscar o Perfil pelo ID
     * */
    public Perfil buscarPerfil(int id){
        return perfilDAO.buscarPorChave(id);
    }

    /**
     * Metodo para Alterar Perfil
     * */
    public void alterarPerfil(Perfil perfil){
        perfilDAO.alterar(perfil);
    }

    /**
     * Listar todos os Modulos
     * */
    public Collection<Perfil> listarPerfil(){
        return perfilDAO.listarPerfils();
    }

	public boolean existePerfilNoDB(Perfil perfil) {
		return buscarNome(perfil.getNome());
	}

	public Perfil buscarPerfilNome(String nome) {
		return perfilDAO.buscarPerfilNome(nome);
	}
}
