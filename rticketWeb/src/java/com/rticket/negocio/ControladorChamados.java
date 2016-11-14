package com.rticket.negocio;

import com.rticket.model.Chamados;
import com.rticket.dao.DAOFactory;
import com.rticket.dao.dados.ChamadosDAO;
import com.rticket.excecao.CampoVazioException;
import com.rticket.model.LogChamado;
import com.rticket.model.Usuario;
import java.util.Collection;
import java.util.Date;

public class ControladorChamados {

    private ChamadosDAO chamadosDAO;

    public ControladorChamados() {
        chamadosDAO = DAOFactory.getChamadosDAO();
    }

    //Metodo para Inserir Chamados
    public void inserirChamados(Chamados chamado)throws CampoVazioException{
        
        Date dt = new Date();
        chamado.setDataCriacao(dt);
        if(chamado.getDataCriacao() == null || chamado.getTitulo().isEmpty() ||
                chamado.getDescricao().isEmpty() || 
                chamado.getStatusChamados() == null || 
                chamado.getTipoChamados() == null || 
                chamado.getUsuarios() == null){
            throw new CampoVazioException();
        }
        
        LogChamado log = new LogChamado();
        
        log.setData(dt);
        log.setAcao("Incluir");
        log.setUsuario(chamado.getUsuarios());
        log.setChamados(chamado);
        log.setHistorico("TIPO: "+chamado.getTipoChamados().getNome()+";"
               +" STATUS: "+chamado.getStatusChamados().getNome()+";"
               +" TITULO: "+chamado.getTitulo()+";"
               +" DESCRICAO: "+chamado.getDescricao()+";");
        
        chamadosDAO.inserirChamados(chamado, log);
    }

    //Metodo para Buscar o Chamados pelo ID
    public Chamados buscarChamados(int id){
        
        return chamadosDAO.buscarPorChave(id);
    }

    //Metodo para Alterar Chamados
    public void alterarChamados(Chamados chamado){
        
        Chamados cham = new Chamados();
        LogChamado logChamado = new LogChamado();
        Date data = new Date();
        String logHistorico = "";
        cham = chamadosDAO.buscarPorChave(chamado.getId());
        
        chamado.setDataCriacao(cham.getDataCriacao());
        chamado.setLoginSolicitante(cham.getLoginSolicitante());
        logChamado.setChamados(chamado);
        logChamado.setUsuario(chamado.getUsuarios());
        
        if(cham.getTipoChamados().getId() != chamado.getTipoChamados().getId()){
            
            logHistorico = ("Tipo: "+chamado.getTipoChamados().getNome());
        }
        
        if(cham.getStatusChamados().getId() != chamado.getStatusChamados().getId()){
            
            logHistorico += ("; Status: "+chamado.getStatusChamados().getNome());
        }

        if(chamado.getStatusChamados().getFinaliza().equals("N")){
            
            logChamado.setAcao("Alterar");
            logChamado.setData(data);          
        }
        else{
            
            logChamado.setAcao("Fechar");
            logChamado.setData(data);
            chamado.setDataFechamento(data);
            logHistorico += ("; Data Fechamento: "+chamado.getDataFechamento());
 
        }
        
        if(cham.getResposta() != chamado.getResposta()){
            
            logHistorico += ("; Resposta: "+chamado.getResposta());
        }
        
        if(cham.getPrioridade() != chamado.getPrioridade()){
            
            logHistorico += ("; Prioridade: "+chamado.getPrioridade());
        }
        
        if(cham.getNotaChamado() != chamado.getNotaChamado()){
            
            logHistorico += ("; Nota_Chamado: "+chamado.getNotaChamado());
        }
        
        logChamado.setHistorico(logHistorico);
        chamadosDAO.alterarChamados(chamado, logChamado);
    }

    //Listar Chamados por Usuario
    public Collection<Chamados> listarChamados(Usuario user){
        return chamadosDAO.listarChamados(user);
    }
    
    //Listar todos os Chamados
    public Collection<Chamados> listarChamadosTotal(){
        return chamadosDAO.listarColecao();
    }
}