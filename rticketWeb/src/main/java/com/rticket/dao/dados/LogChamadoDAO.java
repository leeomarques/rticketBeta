package com.rticket.dao.dados;

import com.rticket.model.LogChamado;
import com.rticket.dao.DAOGenerico;
import com.rticket.model.Chamados;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class LogChamadoDAO extends DAOGenerico<LogChamado>{

    public LogChamadoDAO(EntityManager em) {
	super(em);
    }
    
    public Collection<LogChamado> listarLogChamado(Chamados chamado){
        
        Collection<LogChamado> listaLogChamado;
        String sql;
        sql = ("SELECT l FROM LogChamado l WHERE l.chamados.id = :chamado");
        Query q = getEntityManager().createQuery(sql, LogChamado.class);
        q.setParameter("chamado", chamado.getId());
        listaLogChamado = q.getResultList();
        
        return listaLogChamado;
    }
}
