package com.rticket.beans;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Modulo;
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

    private String nome;
    private Collection<Modulo> listarModulo;
    private Collection<Perfil> listarPerfil;
    private Perfil perfil;
    private Modulo modulo;

    IFachada fach = new Fachada();

    public void inserirPerfil() throws CampoExistenteException, FormatoInvalidoException, CampoVazioException {
        Perfil per = new Perfil();
        per.setNome(nome);
        fach.inserirPerfil(per);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("perfil.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ModuloBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Perfil buscarPerfil(int id) {
        return fach.buscarPerfil(id);
    }

    public void alterarPerfil(Perfil perfil) {
        fach.alterarPerfil(perfil);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Modulo> getListarModulo() {

        return fach.listarModulo();
    }

    public void setListarModulo(Collection<Modulo> listarModulo) {
        this.listarModulo = listarModulo;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public Collection<Perfil> getListarPerfil() {
        return fach.listarPerfil();
    }

    public void setListarPerfil(Collection<Perfil> listarPerfil) {
        this.listarPerfil = listarPerfil;
    }

}
