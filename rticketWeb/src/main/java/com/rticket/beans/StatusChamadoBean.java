package com.rticket.beans;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.StatusChamado;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "statusChamadoBean")
public class StatusChamadoBean {

    private String nome;
    private Collection<StatusChamado> listarStatusChamado;
    private StatusChamado statusChamado;

    IFachada fach = new Fachada();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<StatusChamado> getListarStatusChamado() {

        return fach.listarStatusChamado();
    }

    public void setListarStatusChamado(Collection<StatusChamado> listarStatusChamado) {
        this.listarStatusChamado = listarStatusChamado;
    }

    public StatusChamado getStatusChamado() {
        return statusChamado;
    }

    public void setStatusChamado(StatusChamado statusChamado) {
        this.statusChamado = statusChamado;
    }

    public void inserirStatusChamado() throws FormatoInvalidoException, CampoExistenteException, CampoVazioException {
        StatusChamado sts = new StatusChamado();
        sts.setNome(nome);
        fach.inserirStatusChamado(sts);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("statuschamado.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(StatusChamadoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public StatusChamado buscarStatusChamado(int id) {
        return fach.buscarStatusChamado(id);
    }

    public void alterarStatusChamado(StatusChamado statusChamado) {
        fach.alterarStatusChamado(statusChamado);
    }
}
