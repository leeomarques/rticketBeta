package com.rticket.beans;

import com.rticket.model.StatusChamado;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatusChamadoBeanTest {
    
    StatusChamadoBean statusChamadoBean = new StatusChamadoBean();
    
    public StatusChamadoBeanTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetNome() {
        statusChamadoBean.getNome();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setNome method, of class StatusChamadoBean.
     */
    @Test
    public void testSetNome() {
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetListarStatusChamado() {
        statusChamadoBean.getListarStatusChamado();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setListarStatusChamado method, of class StatusChamadoBean.
     */
    @Test
    public void testSetListarStatusChamado() {
        Assert.assertEquals(null, "null");
    }
    @Test
    public void testGetStatusChamado() {
        statusChamadoBean.getStatusChamado();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setStatusChamado method, of class StatusChamadoBean.
     */
    @Test
    public void testSetStatusChamado() {
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testInserirStatusChamado() throws Exception {
        statusChamadoBean.inserirStatusChamado();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testBuscarStatusChamado() {
        StatusChamado status = new StatusChamado();       
        status = statusChamadoBean.buscarStatusChamado(1);
        
        Assert.assertEquals("Novo", status.getNome());
    }

    @Test
    public void testAlterarStatusChamado() {
        StatusChamado status = new StatusChamado();
        status.setId(2);
        status.setNome("ResolvidoTeste");
        statusChamadoBean.alterarStatusChamado(status);
        
        status = statusChamadoBean.buscarStatusChamado(2);
        
        Assert.assertEquals("ResolvidoTeste", status.getNome());
    }   
}