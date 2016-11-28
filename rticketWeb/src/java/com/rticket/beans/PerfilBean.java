package com.rticket.beans;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Perfil;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "perfilBean")
public class PerfilBean {

    private Collection<Perfil> listarPerfil;
    private String nome;
    private Perfil perfil;

    IFachada fach = new Fachada();
    
    public Perfil buscarPerfil(int id) {
        return fach.buscarPerfil(id);
    }

    public void alterarPerfil(Perfil perfil) {
        fach.alterarPerfil(perfil);
    }

    public Collection<Perfil> getListarPerfil() {
        return fach.listarPerfil();
    }

    public void setListarPerfil(Collection<Perfil> listarPerfil) {
        this.listarPerfil = listarPerfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public void inserirPerfil() throws CampoExistenteException, FormatoInvalidoException, CampoVazioException {
        Perfil per = new Perfil();
        per.setNome(nome);

        fach.inserirPerfil(per);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("perfil.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(PerfilBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
