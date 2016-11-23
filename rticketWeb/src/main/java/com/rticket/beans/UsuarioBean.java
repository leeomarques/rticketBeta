package com.rticket.beans;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Usuario;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "usuarioBean")
public class UsuarioBean {

    IFachada fach = new Fachada();
    
    public void inserirUsuario(Usuario usuario)
            throws CampoVazioException, CampoExistenteException,
                NoSuchAlgorithmException, FormatoInvalidoException{
        fach.inserirUsuario(usuario);
    }
    
    public Usuario buscarUsuario(int id) {
        return fach.buscarUsuario(id);
    }

    public void alterarUsuario(Usuario usuario) {
        try {
            fach.alterarUsuario(usuario);
        } catch (FormatoInvalidoException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Collection<Usuario> listarUsuario() {
        return fach.listarUsuario();
    }

}
