package com.rticket.beans;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.TipoChamado;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "tipoChamadoBean")
public class TipoChamadoBean implements Serializable {

    private int idTipoChamado;

    private String nome;
    private Collection<TipoChamado> listarTipoChamado;
    private TipoChamado tipoChamado;
    private int id;

    public TipoChamadoBean() {

    }

    IFachada fach = new Fachada();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<TipoChamado> getListarTipoChamado() {
        return fach.listarTipoChamado();
    }

    public void setListarTipoChamado(Collection<TipoChamado> listarTipoChamado){
        this.listarTipoChamado = listarTipoChamado;
    }

    public TipoChamado getTipoChamado() {
        return tipoChamado;
    }

    public void setTipoChamado(TipoChamado tipoChamado) {
        this.tipoChamado = tipoChamado;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void inserirTipoChamado() throws FormatoInvalidoException, 
            CampoExistenteException, CampoVazioException {
        
        TipoChamado tpc = new TipoChamado();
        tpc.setNome(nome);

        fach.inserirTipoChamado(tpc);

        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("tipochamado.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(TipoChamadoBean.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    public TipoChamado buscarTipoChamado(int id) {
        return fach.buscarTipoChamado(id);
    }

    public void alterarTipoChamado() {
        TipoChamado tpc = new TipoChamado();

        TipoChamado novoTipo;
        novoTipo = fach.buscarTipoChamado(idTipoChamado);

        tpc.setId(idTipoChamado);
        tpc.setNome(nome);

        fach.alterarTipoChamado(tpc);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("tipochamado.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(PerfilBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getIdTipoChamado() {
        return idTipoChamado;
    }

    public void setIdTipoChamado(int idTipoChamado) {
        this.idTipoChamado = idTipoChamado;

        int id = this.idTipoChamado;
        TipoChamado tipoc;
        IFachada fach = new Fachada();

        tipoc = fach.buscarTipoChamado(id);

        setNome(tipoc.getNome());
    }
}
