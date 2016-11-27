package com.rticket.dao.dados;

import com.rticket.model.Perfil;
import com.rticket.dao.DAOGenerico;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class PerfilDAO extends DAOGenerico<Perfil>{

    Collection<Perfil> perfil = new ArrayList();

    public PerfilDAO(EntityManager em) {
	super(em);
    }

    public Boolean buscarNome(String nome){
        String sql;
        Boolean verificaNome = true;
        sql = ("SELECT p FROM Perfil p WHERE p.nome = :nome");
        Query q = getEntityManager().createQuery(sql, Perfil.class);
        q.setParameter("nome", nome);
        perfil = q.getResultList();
        if (perfil.isEmpty()){
            verificaNome = false;
        }
        return verificaNome;
    }

	public Perfil buscarPerfilNome(String nome) {
		String sql;

        sql = ("SELECT p FROM Perfil p WHERE p.nome = :nome");
        Query q = getEntityManager().createQuery(sql, Perfil.class);
        q.setParameter("nome", nome);
        
        try {
            return (Perfil) q.getSingleResult();
        } catch (NoResultException e) {
        	return null;
        }
	}
	
	public Collection<Perfil> listarPerfils() {
        Collection<Perfil> colecao = null;
        String sql = "";
        sql = ("SELECT p FROM Perfil p WHERE p.ativo = null");
        Query q = getEntityManager().createQuery(sql, Perfil.class);
        
        colecao = q.getResultList();

        return colecao;
    }
}
