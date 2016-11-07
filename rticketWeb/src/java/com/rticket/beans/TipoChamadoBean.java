package com.rticket.beans;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.TipoChamado;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "tipoChamadoBean")
public class TipoChamadoBean {

    private String nome;
    private Collection<TipoChamado> listarTipoChamado;

    IFachada fach = new Fachada();

    public void inserirTipoChamado() throws FormatoInvalidoException, CampoExistenteException, CampoVazioException {
        TipoChamado tpc = new TipoChamado();
        tpc.setNome(nome);

        fach.inserirTipoChamado(tpc);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("tipochamado.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ModuloBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TipoChamado buscarTipoChamado(int id) {
        return fach.buscarTipoChamado(id);
    }

    public void alterarTipoChamado(TipoChamado tipoChamado) {
        fach.alterarTipoChamado(tipoChamado);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<TipoChamado> getListarTipoChamado() {
        return fach.listarTipoChamado();
    }

    public void setListarTipoChamado(Collection<TipoChamado> listarTipoChamado) {
        this.listarTipoChamado = listarTipoChamado;
    }

}
