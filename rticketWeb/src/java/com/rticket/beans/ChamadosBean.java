package com.rticket.beans;

import com.rticket.excecao.CampoVazioException;
import com.rticket.model.Chamados;
import com.rticket.model.LogChamado;
import com.rticket.model.Prioridade;
import com.rticket.model.StatusChamado;
import com.rticket.model.TipoChamado;
import com.rticket.model.Usuario;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@ManagedBean(name = "chamadosBean")
public class ChamadosBean {

    private int idChamado;
    
    private Collection<Chamados> listarChamados;
    private Collection<TipoChamado> listarTipoChamados;
    private Collection<StatusChamado> listarStatusChamados;
    private Collection<Usuario> listarUsuariosChamados;
    private Collection<LogChamado> listarLogChamados;
    private Collection<Prioridade> listarPrioridade;
    
    private String titulo;
    private String descricao;
    private String tipoChamado;
    private String statusChamado;
    private String usuarioSolicitante; 
    private String prioridade;
    private Date criadoEm;
    private Date fechadoEm;
    private String usuarioAtendente;
    private String resposta;
    private int avaliacao;
    private String logChamadoHistorico;
    private String logChamadoAcao;    
       
    IFachada fach = new Fachada();

    HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance()
                         .getExternalContext().getSession( true );
    
    String perfil = ((LoginBean) sessao.getAttribute("loginBean")).getUser()
                    .getPerfil().getNome();
    String login  =  ((LoginBean) sessao.getAttribute("loginBean")).getUser()
                    .getLogin();
    int idUsuario = ((LoginBean) sessao.getAttribute("loginBean")).getUser()
                    .getId();
    
    public int getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(int idChamado) {
        this.idChamado = idChamado;       
        
        int id = this.idChamado;
        Chamados cham;
        IFachada fach = new Fachada();
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        
        cham = fach.buscarChamados(id);
        
        setTitulo(cham.getTitulo());
        setTipoChamado(cham.getTipoChamados().getNome());
        setPrioridade(cham.getPrioridade().getNome());
        setStatusChamado(cham.getStatusChamados().getNome());
        setUsuarioSolicitante(cham.getLoginSolicitante());
        setCriadoEm(cham.getDataCriacao());
        if(cham.getDataFechamento() != null){
            setFechadoEm(cham.getDataFechamento());
        }               
        setUsuarioAtendente(cham.getUsuarios().getNome());
        setResposta(cham.getResposta());
        setAvaliacao(cham.getNotaChamado());
        setDescricao(cham.getDescricao());
    }
    
    public Collection<Chamados> getListarChamados() {
        
        Usuario usuarioLogado = new Usuario();
        usuarioLogado.setId(idUsuario);
        
        return fach.listarChamadosTotal();
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
    
    public Collection<Usuario> getListarUsuariosChamados() {
        
        return fach.listarUsuario();
    }

    public void setListarUsuariosChamados(Collection<Usuario> listarUsuariosChamados) {
        this.listarUsuariosChamados = listarUsuariosChamados;
    }
    
    public Collection<LogChamado> getListarLogChamados() {
        
        Chamados cham;
        cham = fach.buscarChamados(idChamado);
        
        return fach.listarLogChamados(cham);
    }

    public void setListarLogChamados(Collection<LogChamado> listarLogChamados) {
        this.listarLogChamados = listarLogChamados;
    }
    
    public Collection<Prioridade> getListarPrioridade() {
        
        return fach.listarPrioridade();
    }

    public void setListarPrioridade(Collection<Prioridade> listarPrioridade) {
        this.listarPrioridade = listarPrioridade;
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
    
    public String getTipoChamado() {
        return tipoChamado;
    }

    public void setTipoChamado(String tipoChamado) {
        this.tipoChamado = tipoChamado;
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
    
    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
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

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    public String getLogChamadoHistorico() {
        return logChamadoHistorico;
    }

    public void setLogChamadoHistorico(String logChamadoHistorico) {
        this.logChamadoHistorico = logChamadoHistorico;
    }
    
    public String getLogChamadoAcao() {
        return logChamadoAcao;
    }

    public void setLogChamadoAcao(String logChamadoAcao) {
        this.logChamadoAcao = logChamadoAcao;
    }
    
    public void novoChamado(){
        try {
            if(perfil.equals("Administrador")){
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("chamadosNovo.xhtml");
            }
            else{
                if(perfil.equals("Suporte")){
                    FacesContext.getCurrentInstance().getExternalContext()
                            .redirect("chamadosNovo.xhtml");
                }
                else{
                   if(perfil.equals("Usuario")){
                        FacesContext.getCurrentInstance().getExternalContext()
                                .redirect("chamadosNovo.xhtml");
                    } 
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ChamadosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserirChamados(){
        try {
            Chamados cham = new Chamados();
            Usuario user = new Usuario();
                      
            IFachada fachadaTipo = new Fachada();
            int idTipo = Integer.valueOf(tipoChamado);
            
            IFachada fachadaPrio = new Fachada();
            int idPrio = Integer.valueOf(prioridade);
            
            IFachada fachadaStatus = new Fachada();
            
            IFachada fachadaUsuario = new Fachada();
           
            cham.setTipoChamado(fachadaTipo.buscarTipoChamado(idTipo));
            cham.setPrioridade(fachadaPrio.buscarPrioridade(idPrio));
            cham.setTitulo(titulo);
            cham.setDescricao(descricao);
            cham.setStatusChamado(fachadaStatus.buscarStatusChamado(1));          
            cham.setLoginSolicitante(login);
            cham.setUsuarios(fachadaUsuario.buscarUsuario(idUsuario));
                       
            fach.inserirChamados(cham);
            
            if(perfil.equals("Administrador")){
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("chamadosList.xhtml");
            }
            else{
                if(perfil.equals("Suporte")){
                    FacesContext.getCurrentInstance().getExternalContext()
                            .redirect("chamadosList.xhtml");
                }
                else{
                   if(perfil.equals("Usuario")){
                        FacesContext.getCurrentInstance().getExternalContext()
                                .redirect("chamadosList.xhtml");
                    } 
                }
            }
        } catch (CampoVazioException ex) {
            JOptionPane.showMessageDialog(null, "Favor preencher todos os Campos");
        }catch (IOException ex) {
                Logger.getLogger(ChamadosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alterarChamados(){
        
        try{
            Chamados chamado = new Chamados();

            TipoChamado tipoCham;
            tipoCham = fach.buscarTipoChamado(Integer.valueOf(tipoChamado));

            StatusChamado statusCham;
            statusCham = fach.buscarStatusChamado(Integer.valueOf(statusChamado));

            Prioridade novoPrioridade;
            novoPrioridade = fach.buscarPrioridade(Integer.valueOf(prioridade));
            
            Usuario user;
            user = fach.buscarUsuario(Integer.valueOf(usuarioAtendente));

            chamado.setId(idChamado);
            chamado.setTitulo(titulo);
            chamado.setDescricao(descricao);
            chamado.setTipoChamado(tipoCham);
            chamado.setPrioridade(novoPrioridade);
            chamado.setStatusChamado(statusCham);
            chamado.setUsuarios(user);
            chamado.setResposta(resposta);
            chamado.setNotaChamado(avaliacao);

            fach.alterarChamados(chamado);

            FacesContext.getCurrentInstance().getExternalContext()
                            .redirect("chamadosList.xhtml");         
        }catch (IOException ex) {
            Logger.getLogger(ChamadosBean.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    public void mensagemErro() {
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Campo "
                        + "Fechado Em só deve ser preenchido se a Situação "
                        + "estiver como Resolvido"));
    }
    
    public void mensagemErroSituacao() {
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Situação"
                        + " marcada como Resolvido, favor informar a "
                        + "data de Fechamento"));
    }
}