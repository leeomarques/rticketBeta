package com.rticket.dao.dados;

import com.rticket.model.Chamados;
import com.rticket.dao.DAOGenerico;
import com.rticket.model.LogChamado;
import com.rticket.model.Usuario;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class ChamadosDAO extends DAOGenerico<Chamados>{
    
    public ChamadosDAO(EntityManager em) {
	super(em);
    }
    
    public void inserirChamados(Chamados objeto, LogChamado log) {
       
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            tx.begin();
            
            getEntityManager().persist(objeto);
            getEntityManager().persist(log);
            
            tx.commit();
        } catch (PersistenceException e) {
            JOptionPane.showMessageDialog(null, e);
            tx.rollback();
        }
    }
    
    public void alterarChamados(Chamados chamado, LogChamado logChamado) {
        
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            tx.begin();

            getEntityManager().merge(chamado);
            getEntityManager().persist(logChamado);
        
            tx.commit();
        }catch(PersistenceException e){
            tx.rollback();
        }
    }
    
    public Collection<Chamados> listarChamados(Usuario user){
        
        Collection<Chamados> listarChamado;
        String sql;
        sql = ("SELECT c FROM Chamados c WHERE c.usuarios.id = :usuario");
        Query q = getEntityManager().createQuery(sql, Chamados.class);
        q.setParameter("usuario", user.getId());
        listarChamado = q.getResultList();
        
        return listarChamado;
    }
}
