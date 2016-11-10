package com.rticket.beans;

import com.rticket.excecao.CampoVazioException;
import com.rticket.model.Chamados;
import com.rticket.model.StatusChamado;
import com.rticket.model.TipoChamado;
import com.rticket.model.Usuario;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

@ManagedBean(name = "chamadosAlterarBean")
public class ChamadosAlterarBean {
    
    private String idChamado;
    private String titulo;
    private String tipo;
    private String prioridade;
    private String status;
    private String criadoEm;
    private String fechadoEm;
    private String usuarioAtendente;
    private String resposta;
    private String avaliacao;
    private String descricao;
    private Collection<TipoChamado> listarTipoChamados;
    private Collection<StatusChamado> listarStatusChamados;
    private Collection<Usuario> listarUsuariosChamados;

    public String getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(String idChamado) {
        this.idChamado = idChamado;
        
        int id = Integer.valueOf(idChamado);
        Chamados cham = new Chamados();
        IFachada fach = new Fachada();
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        
        cham = fach.buscarChamados(id);
        
        setTitulo(cham.getTitulo());
        setTipo(cham.getTipoChamados().getNome());
        setPrioridade(cham.getPrioridade());
        setStatus(cham.getStatusChamados().getNome());                 
        setCriadoEm(String.valueOf(dt.format(cham.getDataCriacao())));
        setFechadoEm(String.valueOf(cham.getDataFechamento()));
        if(getFechadoEm().equals("")){
            setFechadoEm("-");
        }
        setUsuarioAtendente(cham.getUsuarios().getNome());
        setResposta(cham.getResposta());
        setAvaliacao(String.valueOf(cham.getNotaChamado()));
        setDescricao(cham.getDescricao());
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(String criadoEm) {
        this.criadoEm = criadoEm;
    }

    public String getFechadoEm() {
        return fechadoEm;
    }

    public void setFechadoEm(String fechadoEm) {
        this.fechadoEm = fechadoEm;
    }

    public String getUsuarioAtendente() {
        return usuarioAtendente;
    }

    public void setUsuarioAtendente(String usuarioAtendente) {
        this.usuarioAtendente = usuarioAtendente;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<TipoChamado> getListarTipoChamados() {
        
        IFachada fachTipo = new Fachada();
        return fachTipo.listarTipoChamado();
    }

    public void setListarTipoChamados(Collection<TipoChamado> listarTipoChamados) {
        this.listarTipoChamados = listarTipoChamados;
    }

    public Collection<StatusChamado> getListarStatusChamados() {
        
        IFachada fachStatus = new Fachada();
        return fachStatus.listarStatusChamado();
    }

    public void setListarStatusChamados(Collection<StatusChamado> listarStatusChamados) {
        this.listarStatusChamados = listarStatusChamados;
    }

    public Collection<Usuario> getListarUsuariosChamados() {
        
        IFachada fachUsuario = new Fachada();
        return fachUsuario.listarUsuario();
    }

    public void setListarUsuariosChamados(Collection<Usuario> listarUsuariosChamados) {
        this.listarUsuariosChamados = listarUsuariosChamados;
    }
    
    public void alterarChamados(){
        
        try{
            IFachada fach = new Fachada();
            Chamados chamado = new Chamados();
            //SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
            Date data = new Date();
            Usuario user = new Usuario();

            TipoChamado tipoCham;
            tipoCham = fach.buscarTipoChamado(Integer.valueOf(tipo));

            StatusChamado statusCham;
            statusCham = fach.buscarStatusChamado(Integer.valueOf(status));

            user.setId(1);
            user.setLogin("Toinhotony");
            user.setNome("AntonioCorrea");

            chamado.setId(Integer.valueOf(idChamado));
            chamado.setTitulo(titulo);
            chamado.setTipoChamado(tipoCham);
            chamado.setPrioridade(prioridade);
            chamado.setStatusChamado(statusCham);
            chamado.setDataCriacao(data);
            chamado.setDataFechamento(data);
            chamado.setLoginSolicitante(user.getLogin());
            chamado.setUsuarios(user);
            chamado.setResposta(resposta);
            chamado.setNotaChamado(Integer.valueOf(avaliacao));
            chamado.setDescricao(descricao);

            fach.alterarChamados(chamado);

            FacesContext.getCurrentInstance().getExternalContext().redirect("chamadosList.xhtml");
        }catch (IOException ex) {
                Logger.getLogger(ChamadosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}