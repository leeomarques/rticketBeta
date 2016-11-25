package com.rticket.negocio;

import com.rticket.dao.DAOFactory;
import com.rticket.dao.dados.PrioridadeDAO;
import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Prioridade;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorPrioridade {
    
    private PrioridadeDAO prioridadeDAO;
    private Boolean resultado;

    public ControladorPrioridade() {
        prioridadeDAO = DAOFactory.getPrioridadeDAO();
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
        return this.resultado = prioridadeDAO.buscarNome(nome);
    }

    //Metodo para Inserir Prioridade
    public void inserirPrioridade(Prioridade prioridade)
            throws FormatoInvalidoException, CampoExistenteException,
                CampoVazioException{

        if (prioridade.getNome() == null){
            throw new CampoVazioException();
        }

        buscarNome(prioridade.getNome());

        if (this.resultado == true){
            throw new CampoExistenteException();
        }

        verificarCaracteres(prioridade.getNome());

        if(this.resultado == false){
            throw new FormatoInvalidoException();
        }
        else{
            prioridadeDAO.inserir(prioridade);
        }
    }

    //Metodo para Buscar o Prioridade pelo ID
    public Prioridade buscarPrioridade(int id){
        return prioridadeDAO.buscarPorChave(id);
    }
    
    public Prioridade buscarPrioridadeNome(String nome){
        return prioridadeDAO.buscarPrioridadeNome(nome);
    }

    //Metodo para Alterar Prioridade
    public void alterarPrioridade(Prioridade prioridade){
        prioridadeDAO.alterar(prioridade);
    }

    //Listar todos os Prioridade
    public Collection<Prioridade> listarPrioridade(){
        return prioridadeDAO.listarPrioridade();
    }
}