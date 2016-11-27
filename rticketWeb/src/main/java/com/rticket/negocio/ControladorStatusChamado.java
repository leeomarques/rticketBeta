package com.rticket.negocio;

import com.rticket.model.StatusChamado;
import com.rticket.dao.DAOFactory;
import com.rticket.dao.dados.StatusChamadoDAO;
import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorStatusChamado {

    private StatusChamadoDAO statusChamadoDAO;

    public ControladorStatusChamado() {
        statusChamadoDAO = DAOFactory.getStatusChamadoDAO();
    }

    /**
     * Metodo de Verificar Caracteres Especiais
     * */
    public Boolean verificarCaracteres(String nome) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        Matcher matcher = pattern.matcher(nome);
        return matcher.find();
    }

    /**
     * Metodo para verificar se o nome ja existe no banco
     * */
    public Boolean buscarNome(String nome){
        return statusChamadoDAO.buscarNome(nome);
    }
    
    public StatusChamado buscarStatusChamadoNome(String nome){
        return statusChamadoDAO.buscarStatusChamadoNome(nome);
    }

    /**
     * Metodo para Inserir StatusChamado
     * */
    public void inserirStatusChamado(StatusChamado statusChamado)
            throws FormatoInvalidoException, CampoExistenteException,
                CampoVazioException{

    	if (statusChamado == null || 
    		statusChamado.getNome() == null || 
    		statusChamado.getNome().length() <= 0){
            throw new CampoVazioException();
        }

        if (buscarNome(statusChamado.getNome())){
            throw new CampoExistenteException();
        }

        boolean resultado = verificarCaracteres(statusChamado.getNome());
        if (resultado) {
        	statusChamadoDAO.inserir(statusChamado);
        } else {
        	throw new FormatoInvalidoException();
        }
    }

    /**
     * Metodo para Buscar o StatusChamado pelo ID
     * */
    public StatusChamado buscarStatusChamado(int id){
        return statusChamadoDAO.buscarPorChave(id);
    }

    /**
     * Metodo para Alterar StatusChamado
     * */
    public void alterarStatusChamado(StatusChamado statusChamado){
        statusChamadoDAO.alterar(statusChamado);
    }

    /**
     * Listar todos os StatusChamado
     * */
    public Collection<StatusChamado> listarStatusChamado(){
        return statusChamadoDAO.listarStatusChamado();
    }
}
