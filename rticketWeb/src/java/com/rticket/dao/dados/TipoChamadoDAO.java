package com.rticket.dao.dados;

import com.rticket.model.TipoChamado;
import com.rticket.dao.DAOGenerico;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TipoChamadoDAO extends DAOGenerico<TipoChamado>{

    Collection<TipoChamado> listaTipoChamados = new ArrayList();
    TipoChamado tipoChamado = new TipoChamado();

    public TipoChamadoDAO(EntityManager em) {
	super(em);
    }

    public Boolean buscarNome(String nome){
        String sql;
        Boolean verificaNome = true;
        sql = ("SELECT m FROM TipoChamado m WHERE m.nome = :nome");
        Query q = getEntityManager().createQuery(sql, TipoChamado.class);
        q.setParameter("nome", nome);
        listaTipoChamados = q.getResultList();
        if (listaTipoChamados.isEmpty()){
            verificaNome = false;
        }
        return verificaNome;
    }
    
    //Listar Colecao
    public Collection<TipoChamado> listarTipoChamado(){
        
        Collection<TipoChamado> colecao = null;
        String sql = "";
        sql = ("SELECT m FROM TipoChamado m WHERE m.ativo = null");
        Query q = getEntityManager().createQuery(sql, TipoChamado.class);
        
        colecao = q.getResultList();

        return colecao;
    }
    
    public TipoChamado buscarTipoChamadoNome(String nome){
        String sql;

        sql = ("SELECT m FROM TipoChamado m WHERE m.nome = :nome");
        Query q = getEntityManager().createQuery(sql, TipoChamado.class);
        q.setParameter("nome", nome);
        tipoChamado = (TipoChamado) q.getSingleResult();
        
        return tipoChamado;
    }
}
