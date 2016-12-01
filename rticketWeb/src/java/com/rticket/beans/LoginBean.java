package com.rticket.beans;

import com.rticket.excecao.ValidarLoginException;
import com.rticket.model.Usuario;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{
    
    private String login;
    private String senha;
    private Collection<Usuario> usuarioLogado;
    private String logout;
    private Usuario user;

    IFachada fach = new Fachada();

    public LoginBean() {

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

    public Collection<Usuario> getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Collection<Usuario> usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public String getLogout() {
        
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();
        
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return "/index?faces-redirect=true";
    }

    public void setLogout(String logout) {
        this.logout = logout;
    }
    
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    public void mensagemErro() {
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                        "Erro!", "Login ou Senha Inválidos!"));
    }
    
    public String efetuarLogin() throws ValidarLoginException, 
            NoSuchAlgorithmException, IOException {
        
        try {           
            if (login.equals("admin") && senha.equals("1234")){
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("principal.xhtml");
            }
            else{
                usuarioLogado = fach.efetuarLogin(login, senha);
                
                if (usuarioLogado.isEmpty()){
                    mensagemErro();
                }
                else{
                    Iterator<Usuario> iterator;
        
                    iterator = usuarioLogado.iterator();      
        
                    while(iterator.hasNext()) {
                        this.user = (Usuario)iterator.next();
                        
                    }
                    FacesContext.getCurrentInstance().getExternalContext()
                            .redirect("principal.xhtml");
                }
            }
        } catch (ValidarLoginException e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage("Login/Senha inexistente"));
        }
        
        return "/index?faces-redirect=true";
    }
}