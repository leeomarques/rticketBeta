package com.rticket.negocio;

import com.rticket.dao.DAOFactory;
import com.rticket.dao.dados.PrioridadeDAO;
import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Prioridade;
import java.util.Collection;

public class ControladorPrioridade {
    private PrioridadeDAO prioridadeDAO;

    public ControladorPrioridade() {
        prioridadeDAO = DAOFactory.getPrioridadeDAO();
    }
    
    /**
     * Metodo para verificar se o nome ja existe no banco
     * */
    public Boolean buscarNome(String nome){
        return prioridadeDAO.buscarNome(nome);
    }

    /**
     * Metodo para Inserir Prioridade
     * */
    public void inserirPrioridade(Prioridade prioridade)
            throws FormatoInvalidoException, CampoExistenteException,
                CampoVazioException{

    	if (prioridade == null) {
            throw new CampoVazioException();
    	}
    	
        if (prioridade.getNome() == null || prioridade.getNome().length() <= 0) {
            throw new CampoVazioException();
        }

        if (existePrioridadeNoDB(prioridade)){
            throw new CampoExistenteException();
        }

        prioridadeDAO.inserir(prioridade);
    }

    /**
     * Metodo para Buscar o Prioridade pelo ID
     * */
    public Prioridade buscarPrioridade(int id){
        return prioridadeDAO.buscarPorChave(id);
    }
    
    public Prioridade buscarPrioridadeNome(String nome){
        return prioridadeDAO.buscarPrioridadeNome(nome);
    }

    /**
     * Metodo para Alterar Prioridade
     * */
    public void alterarPrioridade(Prioridade prioridade){
        prioridadeDAO.alterar(prioridade);
    }

    /**
     * Listar todos os Prioridade
     * */
    public Collection<Prioridade> listarPrioridade(){
        return prioridadeDAO.listarPrioridade();
    }
    
    public boolean existePrioridadeNoDB(Prioridade prioridade) {
    	return buscarNome(prioridade.getNome());
    }
}