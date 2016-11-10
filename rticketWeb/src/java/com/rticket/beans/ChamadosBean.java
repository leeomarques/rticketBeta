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

    private int idChamado;
    private Collection<Chamados> listarChamados;
    private Collection<TipoChamado> listarTipoChamados;
    private Collection<StatusChamado> listarStatusChamados;
    private String tipoChamado;
    private String titulo;
    private String descricao;
    private String statusChamado;
    private String usuarioSolicitante;
    
    IFachada fach = new Fachada();
    
    public int getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(int idChamado) {
        this.idChamado = idChamado;
    }
    
    public Collection<Chamados> getListarChamados() {
                             
        return fach.listarChamados();
    }

    public void setListarChamados(Collection<Chamados> listarChamados) {
        this.listarChamados = listarChamados;
    }
    
    public Collection<TipoChamado> getListarTipoChamados() {
        
        return fach.listarTipoChamado();
    }

    public void setListarTipoChamados(Collection<TipoChamado> listarTipoChamados) {
        this.listarTipoChamados = listarTipoChamados;
    }
    
    public Collection<StatusChamado> getListarStatusChamados() {
        
        return fach.listarStatusChamado();
    }

    public void setListarStatusChamados(Collection<StatusChamado> listarStatusChamados) {
        this.listarStatusChamados = listarStatusChamados;
    }
    
    public String getTipoChamado() {
        return tipoChamado;
    }

    public void setTipoChamado(String tipoChamado) {
        this.tipoChamado = tipoChamado;
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
    
    public String getStatusChamado() {
        return statusChamado;
    }

    public void setStatusChamado(String statusChamado) {
        this.statusChamado = statusChamado;
    }
    
    public String getUsuarioSolicitante() {
        return usuarioSolicitante;
    }

    public void setUsuarioSolicitante(String usuarioSolicitante) {
        this.usuarioSolicitante = usuarioSolicitante;
    }
    
    public void novoChamado(){
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("chamadosNovo.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ChamadosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserirChamados(){
        try {
            Chamados cham = new Chamados();
            Date dt = new Date();
            Usuario user = new Usuario();
                      
            user.setId(1);
            IFachada fachadaTipo = new Fachada();
            int idTipo = Integer.valueOf(tipoChamado);
            
            IFachada fachadaStatus = new Fachada();
            int idStatus = Integer.valueOf(statusChamado);
            
            cham.setDataCriacao(dt);
            cham.setTipoChamado(fachadaTipo.buscarTipoChamado(idTipo));
            cham.setTitulo(titulo);
            cham.setDescricao(descricao);
            cham.setStatusChamado(fachadaStatus.buscarStatusChamado(idStatus));          
            cham.setLoginSolicitante("Login da Sessao");
            cham.setUsuarios(user);//Objeto Usuario da Sessao
                       
            fach.inserirChamados(cham);
  
            FacesContext.getCurrentInstance().getExternalContext().redirect("chamadosList.xhtml");
        } catch (CampoVazioException ex) {
            JOptionPane.showMessageDialog(null, "Favor preencher todos os Campos");
        }catch (IOException ex) {
                Logger.getLogger(ChamadosBean.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}