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

    IFachada fach = new Fachada();

    public void inserirStatusChamado() throws FormatoInvalidoException, CampoExistenteException, CampoVazioException {
        StatusChamado sts = new StatusChamado();
        sts.setNome(nome);
        fach.inserirStatusChamado(sts);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("statuschamado.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ModuloBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public StatusChamado buscarStatusChamado(int id) {
        return fach.buscarStatusChamado(id);
    }

    public void alterarStatusChamado(StatusChamado statusChamado) {
        fach.alterarStatusChamado(statusChamado);
    }

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
}
