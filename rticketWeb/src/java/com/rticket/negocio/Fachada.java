package com.rticket.negocio;

import com.rticket.excecao.ValidarLoginException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.StatusChamado;
import com.rticket.model.Perfil;
import com.rticket.model.Usuario;
import com.rticket.model.LogChamado;
import com.rticket.model.Chamados;
import com.rticket.model.Prioridade;
import com.rticket.model.TipoChamado;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

public class Fachada implements IFachada {

    private ControladorPerfil novoPerfil;
    private ControladorUsuario novoUsuario;
    private ControladorChamados novoChamado;
    private ControladorLogChamado novoLogChamado;
    private ControladorStatusChamado novoStatusChamado;
    private ControladorTipoChamado novoTipoChamado;
    private ControladorPrioridade novoPrioridade;

    public Fachada() {
        this.novoUsuario = new ControladorUsuario();
        this.novoPerfil = new ControladorPerfil();
        this.novoChamado = new ControladorChamados();
        this.novoLogChamado = new ControladorLogChamado();
        this.novoStatusChamado = new ControladorStatusChamado();
        this.novoTipoChamado = new ControladorTipoChamado();
        this.novoPrioridade = new ControladorPrioridade();
        this.novoTipoChamado = new ControladorTipoChamado();
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos para Perfis">
    public void inserirPerfil(Perfil perfil)
            throws CampoExistenteException, FormatoInvalidoException,
            CampoVazioException {
        this.novoPerfil.inserirPerfil(perfil);
    }

    public Perfil buscarPerfil(int id) {
        return this.novoPerfil.buscarPerfil(id);
    }

    public void alterarPerfil(Perfil perfil) {
        this.novoPerfil.alterarPerfil(perfil);
    }

    public Collection<Perfil> listarPerfil() {
        return novoPerfil.listarPerfil();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos para Usuarios">
    public Collection<Usuario> efetuarLogin(String login, String senha)
            throws ValidarLoginException, NoSuchAlgorithmException {
        return this.novoUsuario.efetuarLogin(login, senha);
    }

    public void inserirUsuario(Usuario usuario)
            throws CampoVazioException, CampoExistenteException,
            NoSuchAlgorithmException, FormatoInvalidoException {
        this.novoUsuario.inserirUsuario(usuario);
    }

    public Usuario buscarUsuario(int id) {
        return this.novoUsuario.buscarUsuario(id);
    }

    public void alterarUsuario(Usuario usuario) throws FormatoInvalidoException,
            NoSuchAlgorithmException {
        this.novoUsuario.alterarUsuario(usuario);
    }

    public Collection<Usuario> listarUsuario() {
        return novoUsuario.listarUsuario();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos para Chamados">
    public void inserirChamados(Chamados chamado) throws CampoVazioException {
        this.novoChamado.inserirChamados(chamado);
    }

    public Chamados buscarChamados(int id) {
        return this.novoChamado.buscarChamados(id);
    }

    public void alterarChamados(Chamados chamado) {
        this.novoChamado.alterarChamados(chamado);
    }

    public Collection<Chamados> listarChamados(Usuario user) {
        return novoChamado.listarChamados(user);
    }

    public Collection<Chamados> listarChamadosTotal() {
        return novoChamado.listarChamadosTotal();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos para LogChamados">
    public LogChamado buscarLogChamados(int id) {
        return this.novoLogChamado.buscarLogChamado(id);
    }

    public Collection<LogChamado> listarLogChamados(Chamados chamado) {
        return novoLogChamado.listarLogChamados(chamado);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos para StatusChamado">
    public void inserirStatusChamado(StatusChamado statusChamado)
            throws FormatoInvalidoException, CampoExistenteException,
            CampoVazioException {
        this.novoStatusChamado.inserirStatusChamado(statusChamado);
    }

    public StatusChamado buscarStatusChamado(int id) {
        return this.novoStatusChamado.buscarStatusChamado(id);
    }

    public void alterarStatusChamado(StatusChamado statusChamado) {
        this.novoStatusChamado.alterarStatusChamado(statusChamado);
    }

    public Collection<StatusChamado> listarStatusChamado() {
        return novoStatusChamado.listarStatusChamado();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos para TipoChamado">
    public void inserirTipoChamado(TipoChamado tipoChamado)
            throws FormatoInvalidoException, CampoExistenteException,
            CampoVazioException {
        this.novoTipoChamado.inserirTipoChamado(tipoChamado);
    }

    public TipoChamado buscarTipoChamado(int id) {
        return this.novoTipoChamado.buscarTipoChamado(id);
    }

    public void alterarTipoChamado(TipoChamado tipoChamado) {
        this.novoTipoChamado.alterarTipoChamado(tipoChamado);
    }

    public Collection<TipoChamado> listarTipoChamado() {
        return novoTipoChamado.listarTipoChamado();
    }

    public TipoChamado buscarTipoChamadoNome(String nome) {
        return this.novoTipoChamado.buscarTipoChamadoNome(nome);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos para Prioridade">
    public void inserirPrioridade(Prioridade tipoChamado)
            throws FormatoInvalidoException, CampoExistenteException,
            CampoVazioException {
        this.novoPrioridade.inserirPrioridade(tipoChamado);
    }

    public Prioridade buscarPrioridade(int id) {
        return this.novoPrioridade.buscarPrioridade(id);
    }

    public void alterarPrioridade(Prioridade prioridade) {
        this.novoPrioridade.alterarPrioridade(prioridade);
    }

    public Collection<Prioridade> listarPrioridade() {
        return novoPrioridade.listarPrioridade();
    }

    public Prioridade buscarPrioridadeNome(String nome) {
        return this.novoPrioridade.buscarPrioridadeNome(nome);
    }
//</editor-fold>
}
