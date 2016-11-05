package com.rticket.beans;

import com.rticket.excecao.CampoVazioException;
import com.rticket.model.Chamados;
import com.rticket.model.TipoChamado;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

@ManagedBean(name = "chamadosBean")
public class ChamadosBean {

    private Collection<Chamados> listarChamados;
    private Collection<TipoChamado> listarTipoChamado;
    private Chamados chamado;
    private String mensagem;
    
    IFachada fach = new Fachada();
    
    public Collection<Chamados> getListarChamados() {
                             
        this.listarChamados = fach.listarChamados();
        return this.listarChamados;
    }

    public void setListarChamados(Collection<Chamados> listarChamados) {
        this.listarChamados = listarChamados;
    }

    public Collection<TipoChamado> getListarTipoChamado() {
                 
        return this.listarTipoChamado;
    }

    public void setListarTipoChamado(Collection<TipoChamado> listarTipoChamado) {
        this.listarTipoChamado = listarTipoChamado;
    }
    
    public Chamados getChamado() {
        return chamado;
    }

    public void setChamado(Chamados chamado) {
        this.chamado = chamado;
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public void inserirChamados(Chamados chamado){
        try {
            fach.inserirChamados(chamado);
        } catch (CampoVazioException ex) {
            JOptionPane.showMessageDialog(null, "Favor preencher todos os Campos");
        }
    }
    
    public void novoChamado(){
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("chamados.xhtml");
            setMensagem("Usuario ou Senha Invalidos!");
        } catch (IOException ex) {
            Logger.getLogger(ChamadosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscarChamados(int id){
        
        try {
            chamado = fach.buscarChamados(id);
            FacesContext.getCurrentInstance().getExternalContext().redirect("chamados.xhtml");
            
        } catch (IOException ex) {
            Logger.getLogger(ChamadosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}