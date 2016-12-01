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

    /**
     * Test of getNome method, of class StatusChamadoBean.
     */
    @Test
    public void testGetNome() {
    }

    /**
     * Test of setNome method, of class StatusChamadoBean.
     */
    @Test
    public void testSetNome() {
    }

    /**
     * Test of getListarStatusChamado method, of class StatusChamadoBean.
     */
    @Test
    public void testGetListarStatusChamado() {
    }

    /**
     * Test of setListarStatusChamado method, of class StatusChamadoBean.
     */
    @Test
    public void testSetListarStatusChamado() {
    }

    /**
     * Test of getStatusChamado method, of class StatusChamadoBean.
     */
    @Test
    public void testGetStatusChamado() {
    }

    /**
     * Test of setStatusChamado method, of class StatusChamadoBean.
     */
    @Test
    public void testSetStatusChamado() {
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
       // statusChamadoBean.alterarStatusChamado(status);
        
        status = statusChamadoBean.buscarStatusChamado(2);
        
        Assert.assertEquals("ResolvidoTeste", status.getNome());
    }   
}