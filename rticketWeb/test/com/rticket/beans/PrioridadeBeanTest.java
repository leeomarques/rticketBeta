package com.rticket.beans;

import com.rticket.model.Prioridade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrioridadeBeanTest {
    
    PrioridadeBean prioridadeBean = new PrioridadeBean();
    
    public PrioridadeBeanTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getNome method, of class PrioridadeBean.
     */
    @Test
    public void testGetNome() {
    }

    /**
     * Test of setNome method, of class PrioridadeBean.
     */
    @Test
    public void testSetNome() {
    }

    /**
     * Test of getListarPrioridade method, of class PrioridadeBean.
     */
    @Test
    public void testGetListarPrioridade() {
    }

    /**
     * Test of setListarPrioridade method, of class PrioridadeBean.
     */
    @Test
    public void testSetListarPrioridade() {
    }

    /**
     * Test of getPrioridade method, of class PrioridadeBean.
     */
    @Test
    public void testGetPrioridade() {
    }

    /**
     * Test of setPrioridade method, of class PrioridadeBean.
     */
    @Test
    public void testSetPrioridade() {
    }

    /**
     * Test of getId method, of class PrioridadeBean.
     */
    @Test
    public void testGetId() {
    }

    /**
     * Test of setId method, of class PrioridadeBean.
     */
    @Test
    public void testSetId() {
    }

    @Test
    public void testInserirPrioridade() throws Exception {
        prioridadeBean.inserirPrioridade();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testBuscarPrioridade() {
        Prioridade prioridade = new Prioridade();   
        prioridade = prioridadeBean.buscarPrioridade(1);
        
        Assert.assertEquals("Alta", prioridade.getNome());
    }

    @Test
    public void testAlterarPrioridade() {
        Prioridade prioridade = new Prioridade();
        prioridade.setId(2);
        prioridade.setNome("NormalTeste");
        prioridadeBean.alterarPrioridade(prioridade);
        
        prioridade = prioridadeBean.buscarPrioridade(2);
        
        Assert.assertEquals("NormalTeste", prioridade.getNome());
    }   
}