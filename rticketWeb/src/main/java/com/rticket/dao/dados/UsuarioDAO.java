package com.rticket.dao.dados;

import com.rticket.dao.DAOFactory;
import com.rticket.model.Prioridade;
import com.rticket.model.Usuario;
import com.rticket.dao.DAOGenerico;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class UsuarioDAO extends DAOGenerico<Usuario>{
    
    Collection<Usuario> user = new ArrayList();
    private Usuario usuario = new Usuario();

    public UsuarioDAO(EntityManager em) {
        
	super(em);
    }

    public Boolean buscarLogin(String login){
        String sql;
        Boolean verificaLogin = true;
        sql = ("SELECT u FROM Usuario u WHERE u.login = :login");
        Query q = getEntityManager().createQuery(sql, Usuario.class);
        q.setParameter("login", login);
        user = q.getResultList();
        if (user.isEmpty()){
            verificaLogin = false;
        }
        return verificaLogin;
    }

    public Collection<Usuario> efetuarLogin(String login, String senha){
        String sql;
        sql = ("SELECT u FROM Usuario u WHERE u.login = :usuarioLogin and u.senha = :usuarioSenha");
        Query q = getEntityManager().createQuery(sql, Usuario.class);
        q.setParameter("usuarioLogin", login);
        q.setParameter("usuarioSenha", senha);
        
        user = q.getResultList();
        return user;
    }

	public Usuario buscarUsuario(String login) {
		String sql;

        sql = ("SELECT p FROM Usuario p WHERE p.login = :login");
        Query q = getEntityManager().createQuery(sql, Usuario.class);
        q.setParameter("login", login);
        
        try {
            return (Usuario) q.getSingleResult();
        } catch (NoResultException e) {
        	return null;
        }
	}
}
