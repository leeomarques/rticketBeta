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
    private Boolean resultado;

    public ControladorPerfil() {
        perfilDAO = DAOFactory.getPerfilDAO();
    }

    //Metodo de Verificar Caracteres Especiais
    public Boolean verificarCaracteres(String nome){

        this.resultado = false;
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        Matcher matcher = pattern.matcher(nome);

        if(matcher.find()){
            this.resultado = true;
        }

        return this.resultado;
    }

    //Metodo para verificar se o nome ja existe no banco
    public Boolean buscarNome(String nome){
        return this.resultado = perfilDAO.buscarNome(nome);
    }

    //Metodo para Inserir Perfil
    public void inserirPerfil(Perfil perfil)
            throws CampoExistenteException, FormatoInvalidoException,
                CampoVazioException{

        if (perfil.getNome() == null){
            throw new CampoVazioException();
        }

        buscarNome(perfil.getNome());

        if (this.resultado == true){
            throw new CampoExistenteException();
        }

        verificarCaracteres(perfil.getNome());

        if(this.resultado == false){
            throw new FormatoInvalidoException();
        }
        else{
            perfilDAO.inserir(perfil);
        }
    }

    //Metodo para Buscar o Perfil pelo ID
    public Perfil buscarPerfil(int id){
        return perfilDAO.buscarPorChave(id);
    }

    //Metodo para Alterar Perfil
    public void alterarPerfil(Perfil perfil){
        perfilDAO.alterar(perfil);
    }

    //Listar todos os Modulos
    public Collection<Perfil> listarPerfil(){
        return perfilDAO.listarColecao();
    }
}
