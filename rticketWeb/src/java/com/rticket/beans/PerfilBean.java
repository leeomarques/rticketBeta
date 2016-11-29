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

import org.primefaces.model.DualListModel;


@ManagedBean(name = "perfilBean")
public class PerfilBean {


    private int idPerfil;


    private Collection<Perfil> listarPerfil;
    private String nome;
    private Perfil perfil;
    private String ativo;
    private DualListModel<String> dualListModulo;

    IFachada fach = new Fachada();
    
    public Perfil buscarPerfil(int id) {
        return fach.buscarPerfil(id);
    }

    public void teste() {
        System.err.println("teste");
    }


    public void alterarPerfil() {

        Perfil per = new Perfil();

        Perfil novoPer;
        novoPer = fach.buscarPerfil(idPerfil);

        per.setId(idPerfil);
        per.setNome(nome);

        fach.alterarPerfil(per);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("perfil.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(PerfilBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void excluirPerfil(){
        Perfil per = new Perfil();

        Perfil novoPer;
        novoPer = fach.buscarPerfil(idPerfil);

        per.setAtivo(ativo);

        fach.alterarPerfil(per);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("perfil.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(PerfilBean.class.getName()).log(Level.SEVERE, null, ex);
        }
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


    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;

        int id = this.idPerfil;
        Perfil per;
        IFachada fach = new Fachada();

        per = fach.buscarPerfil(id);

        setNome(per.getNome());

    }

    public DualListModel<String> getDualListModulo() {
        return dualListModulo;
    }

    public void setDualListModulo(DualListModel<String> dualListModulo) {
        this.dualListModulo = dualListModulo;
    }

    public String getAtivo() {
        return ativo;

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

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

}
