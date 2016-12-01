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

    private int idStatusChamado;

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    String ativo;
    private String nome;
    private Collection<StatusChamado> listarStatusChamado;
    private StatusChamado statusChamado;
    private String finalizaProcesso;

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

    public void excluirStatusChamado() {
        StatusChamado stc = new StatusChamado();

        StatusChamado novoStc;
        novoStc = fach.buscarStatusChamado(idStatusChamado);

        stc.setAtivo(ativo);

        fach.alterarStatusChamado(stc);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("statuschamado.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(PerfilBean.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        sts.setFinaliza(finalizaProcesso);
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

    public void alterarStatusChamado() {

        StatusChamado sc = new StatusChamado();

        StatusChamado stCham;
        stCham = fach.buscarStatusChamado(idStatusChamado);

        sc.setId(idStatusChamado);
        sc.setNome(nome);
        sc.setFinaliza(stCham.getFinaliza());

        fach.alterarStatusChamado(sc);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("statuschamado.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(PerfilBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        fach.alterarStatusChamado(statusChamado);
    }

    public int getIdStatusChamado() {
        return idStatusChamado;
    }

    public void setIdStatusChamado(int idStatusChamado) {
        this.idStatusChamado = idStatusChamado;

        int id = this.idStatusChamado;
        StatusChamado stc;
        IFachada fach = new Fachada();

        stc = fach.buscarStatusChamado(id);

        setNome(stc.getNome());

    }

    public String getFinalizaProcesso() {
        return finalizaProcesso;
    }

    public void setFinalizaProcesso(String finalizaProcesso) {
        this.finalizaProcesso = finalizaProcesso;
    }
}
