package com.rticket.dao.dados;

import com.rticket.dao.DAOGenerico;
import com.rticket.model.Prioridade;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PrioridadeDAO extends DAOGenerico<Prioridade>{

    Collection<Prioridade> listaPrioridade = new ArrayList();
    Prioridade prioridade = new Prioridade();
    
    public PrioridadeDAO(EntityManager em) {
        super(em);
    }
    
    public Boolean buscarNome(String nome){
        String sql;
        Boolean verificaNome = true;
        sql = ("SELECT p FROM Prioridade p WHERE p.nome = :nome");
        Query q = getEntityManager().createQuery(sql, Prioridade.class);
        q.setParameter("nome", nome);
        listaPrioridade = q.getResultList();
        if (listaPrioridade.isEmpty()){
            verificaNome = false;
        }
        return verificaNome;
    }
    
    //Listar Colecao
    public Collection<Prioridade> listarPrioridade(){
        
        Collection<Prioridade> colecao = null;
        String sql = "";
        sql = ("SELECT p FROM Prioridade p WHERE p.ativo = null");
        Query q = getEntityManager().createQuery(sql, Prioridade.class);
        
        colecao = q.getResultList();

        return colecao;
    }
    
    public Prioridade buscarPrioridadeNome(String nome){
        String sql;

        sql = ("SELECT p FROM Prioridade p WHERE p.nome = :nome");
        Query q = getEntityManager().createQuery(sql, Prioridade.class);
        q.setParameter("nome", nome);
        prioridade = (Prioridade) q.getSingleResult();
        
        return prioridade;
    }
}
