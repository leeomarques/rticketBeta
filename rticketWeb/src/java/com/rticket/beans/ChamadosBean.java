package com.rticket.beans;

import com.rticket.excecao.CampoVazioException;
import com.rticket.model.Chamados;
import com.rticket.model.StatusChamado;
import com.rticket.model.TipoChamado;
import com.rticket.model.Usuario;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

@ManagedBean(name = "chamadosBean")
public class ChamadosBean {

    private Collection<Chamados> listarChamados;
    private Chamados chamado;
    private String mensagem;
    private String titulo;
    private String descricao;
    private Date criadoEm;
    private Date fechadoEm;
    private String respostaHelp;
    private int notaAtendimento;
    private TipoChamado tipoChamado;
    private StatusChamado statusChamado;
    private Usuario user;
    
    IFachada fach = new Fachada();
    
    public Collection<Chamados> getListarChamados() {
                             
        this.listarChamados = fach.listarChamados();
        return this.listarChamados;
    }

    public void setListarChamados(Collection<Chamados> listarChamados) {
        this.listarChamados = listarChamados;
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
    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Date getFechadoEm() {
        return fechadoEm;
    }

    public void setFechadoEm(Date fechadoEm) {
        this.fechadoEm = fechadoEm;
    }

    public String getRespostaHelp() {
        return respostaHelp;
    }

    public void setRespostaHelp(String respostaHelp) {
        this.respostaHelp = respostaHelp;
    }

    public int getNotaAtendimento() {
        return notaAtendimento;
    }

    public void setNotaAtendimento(int notaAtendimento) {
        this.notaAtendimento = notaAtendimento;
    }

    public TipoChamado getTipoChamado() {
        return tipoChamado;
    }

    public void setTipoChamado(TipoChamado tipoChamado) {
        this.tipoChamado = tipoChamado;
    }

    public StatusChamado getStatusChamado() {
        return statusChamado;
    }

    public void setStatusChamado(StatusChamado statusChamado) {
        this.statusChamado = statusChamado;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    public void inserirChamados(){
        try {
            chamado.setTipoChamado(tipoChamado);
            chamado.setStatusChamado(statusChamado);
            chamado.setTitulo(titulo);
            chamado.setDescricao(descricao);
            chamado.setDataCriacao(criadoEm);
            chamado.setDataFechamento(fechadoEm);
            chamado.setResposta(respostaHelp);
            chamado.setNotaChamado(notaAtendimento);
            chamado.setUsuarios(user);
            
            
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