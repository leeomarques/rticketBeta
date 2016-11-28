package com.rticket.beans;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Perfil;
import com.rticket.model.Usuario;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "usuarioBean")
public class UsuarioBean {

    private String nome;
    private String login;
    private String senha;
    private Collection<Usuario> listarUsuario;
    private String perfil;
    private Collection<Perfil> listarPerfil;

    IFachada fach = new Fachada();

    public void inserirUsuario() throws CampoVazioException, CampoExistenteException, NoSuchAlgorithmException, FormatoInvalidoException {
        Usuario usr = new Usuario();
        int idPerfil = Integer.valueOf(perfil);

        usr.setNome(nome);
        usr.setLogin(login);
        usr.setSenha(senha);

        usr.setPerfil(fach.buscarPerfil(idPerfil));
        
        
        fach.inserirUsuario(usr);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("usuario.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        } catch (CampoVazioException ex) {
        	Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
		}
    }

    public Collection<Usuario> listarUsuario() {
        return fach.listarUsuario();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Collection<Usuario> getListarUsuario() {
        this.listarUsuario = fach.listarUsuario();
        return this.listarUsuario;
    }

    public void setListarUsuario(Collection<Usuario> listarUsuario) {
        this.listarUsuario = listarUsuario;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Collection<Perfil> getListarPerfil() {
        return fach.listarPerfil();
    }

    public void setListarPerfil(Collection<Perfil> listarPerfil) {
        this.listarPerfil = listarPerfil;
    }

}
