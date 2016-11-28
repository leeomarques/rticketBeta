package com.rticket.beans;

import com.rticket.model.Chamados;
import com.rticket.model.LogChamado;
import com.rticket.model.Prioridade;
import com.rticket.model.StatusChamado;
import com.rticket.model.TipoChamado;
import com.rticket.model.Usuario;
import java.util.Collection;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChamadosBeanTest {
    
    ChamadosBean chamadosBean = new ChamadosBean();
    Collection<Chamados> listarChamados;
    Collection<TipoChamado> listarTipoChamados;
    Collection<StatusChamado> listarStatusChamados;
    Collection<Usuario> listarUsuariosChamados;
    Collection<LogChamado> listarLogChamados;
    Collection<Prioridade> listarPrioridade;
    
    public ChamadosBeanTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetIdChamado() {
        chamadosBean.getIdChamado();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetIdChamado() {
        chamadosBean.setIdChamado(1);
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetListarChamados() {
        chamadosBean.getListarChamados();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetListarChamados() {
        chamadosBean.setListarChamados(listarChamados);
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetListarTipoChamados() {
        chamadosBean.getListarTipoChamados();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetListarTipoChamados() {
        chamadosBean.setListarTipoChamados(listarTipoChamados);
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetListarStatusChamados() {
        chamadosBean.getStatusChamado();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetListarStatusChamados() {
        chamadosBean.setListarStatusChamados(listarStatusChamados);
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetListarUsuariosChamados() {
        chamadosBean.getListarUsuariosChamados();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetListarUsuariosChamados() {
        chamadosBean.setListarUsuariosChamados(listarUsuariosChamados);
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetListarLogChamados() {
        chamadosBean.getListarLogChamados();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetListarLogChamados() {
        chamadosBean.setListarLogChamados(listarLogChamados);
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetListarPrioridade() {
        chamadosBean.getListarPrioridade();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetListarPrioridade() {
        chamadosBean.setListarPrioridade(listarPrioridade);
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetTitulo() {
        chamadosBean.getTitulo();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetTitulo() {
        chamadosBean.setTitulo("titulo");
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetDescricao() {
        chamadosBean.getDescricao();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetDescricao() {
        chamadosBean.setDescricao("descricao");
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetTipoChamado() {
        chamadosBean.getTipoChamado();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetTipoChamado() {
        chamadosBean.setTipoChamado("tipo");
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetStatusChamado() {
        chamadosBean.getStatusChamado();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetStatusChamado() {
        chamadosBean.setStatusChamado("status");
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetUsuarioSolicitante() {
        chamadosBean.getUsuarioSolicitante();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetUsuarioSolicitante() {
        chamadosBean.setUsuarioSolicitante("usuarioSolicitante");
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetPrioridade() {
        chamadosBean.getPrioridade();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetPrioridade() {
        chamadosBean.setPrioridade("prioridade");
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetCriadoEm() {
        chamadosBean.getCriadoEm();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetCriadoEm() {
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetFechadoEm() {
        chamadosBean.getFechadoEm();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setFechadoEm method, of class ChamadosBean.
     */
    @Test
    public void testSetFechadoEm() {
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetUsuarioAtendente() {
        chamadosBean.getUsuarioAtendente();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetUsuarioAtendente() {
        chamadosBean.setUsuarioAtendente("Atendente");
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetResposta() {
        chamadosBean.getResposta();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetResposta() {
        chamadosBean.setResposta("resposta");
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetAvaliacao() {
        chamadosBean.getAvaliacao();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetAvaliacao() {
        chamadosBean.setAvaliacao(1);
        Assert.assertEquals(null, "null");
    }


    @Test
    public void testGetLogChamadoHistorico() {
        chamadosBean.getLogChamadoHistorico();
         Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetLogChamadoHistorico() {
        chamadosBean.setLogChamadoHistorico("historico");
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetLogChamadoAcao() {
        chamadosBean.getLogChamadoAcao();
         Assert.assertEquals(null, "null");
    }

    @Test
    public void testSetLogChamadoAcao() {
        chamadosBean.setLogChamadoAcao("acao");
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testNovoChamado() {
        chamadosBean.novoChamado();
         Assert.assertEquals(null, "null");
    }

    @Test
    public void testInserirChamados() {
        chamadosBean.inserirChamados();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testAlterarChamados() {
        chamadosBean.alterarChamados();
        Assert.assertEquals(null, "null");
    }
    
    @Test
    public void testAlterarChamadosFechadoEmVazio() {
        Date fechadoEm = null;
        Chamados chamado = new Chamados();
        chamadosBean.alterarChamados();
        
        if (fechadoEm != null && chamado.getStatusChamados().getId() != 2){
            testMensagemErro();
        }
        else{
            if(fechadoEm == null && chamado.getStatusChamados().getId() == 2){
                    testMensagemErroSituacao();
                }
        }
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testMensagemErro() {
        chamadosBean.mensagemErro();
        Assert.assertEquals(null, "null");
    }
    
    @Test
    public void testMensagemErroSituacao() {
        chamadosBean.mensagemErroSituacao();
        Assert.assertEquals(null, "null");
    }
    
}
