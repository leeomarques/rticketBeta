package com.rticket.beans;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Prioridade;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "prioridadeBean")
public class PrioridadeBean {

    private String nome;
    private String ativo;
    private Collection<Prioridade> listarPrioridade;
    private Prioridade prioridade;
    private int id;

    public PrioridadeBean() {

    }

    IFachada fach = new Fachada();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Prioridade> getListarPrioridade() {
        return fach.listarPrioridade();
    }

    public void setListarPrioridade(Collection<Prioridade> listarPrioridade) {
        this.listarPrioridade = listarPrioridade;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void inserirPrioridade() throws FormatoInvalidoException, CampoExistenteException, CampoVazioException {
        Prioridade novoPri = new Prioridade();
        novoPri.setNome(nome);

        fach.inserirPrioridade(novoPri);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("prioridade.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(PrioridadeBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Prioridade buscarPrioridade(int id) {
        return fach.buscarPrioridade(id);
    }

    public void alterarPrioridade(Prioridade prioridade) {
        fach.alterarPrioridade(prioridade);
    }

    public void excluirPrioridade() {
        Prioridade pri = new Prioridade();

        Prioridade novoPri;
        novoPri = fach.buscarPrioridade(id);

        pri.setAtivo(ativo);

        fach.alterarPrioridade(pri);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("prioridade.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(PerfilBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
}
