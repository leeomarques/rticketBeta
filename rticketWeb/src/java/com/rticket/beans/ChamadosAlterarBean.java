package com.rticket.beans;

import com.rticket.model.Chamados;
import com.rticket.model.StatusChamado;
import com.rticket.model.TipoChamado;
import com.rticket.model.Usuario;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.text.SimpleDateFormat;
import java.util.Collection;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "chamadosAlterarBean")
public class ChamadosAlterarBean {
    
    private String idChamado;
    private String Titulo;
    private String tipo;
    private String prioridade;
    private String status;
    private String criadoEm;
    private String fechadoem;
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
        setFechadoem(String.valueOf(cham.getDataFechamento()));
        if(getFechadoem().equals("")){
            setFechadoem("-");
        }
        setUsuarioAtendente(cham.getUsuarios().getNome());
        setResposta(cham.getResposta());
        setAvaliacao(String.valueOf(cham.getNotaChamado()));
        setDescricao(cham.getDescricao());
    }
    
    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
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

    public String getFechadoem() {
        return fechadoem;
    }

    public void setFechadoem(String fechadoem) {
        this.fechadoem = fechadoem;
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
}