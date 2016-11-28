package com.rticket.beans;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.rticket.beans.TipoChamadoBean;
import com.rticket.model.TipoChamado;
import org.junit.Assert;

public class TipoChamadoBeanTest {
    
    TipoChamadoBean tipoChamadoBean = new TipoChamadoBean();
    
    public TipoChamadoBeanTest() {
        
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetNome() {
        tipoChamadoBean.getNome();
        Assert.assertEquals(null, "null"); 
    }

    @Test
    public void testSetNome() {
        Assert.assertEquals(null, "null"); 
    }

    @Test
    public void testGetListarTipoChamado() {
        tipoChamadoBean.getListarTipoChamado();
        Assert.assertEquals(null, "null"); 
    }

    /**
     * Test of setListarTipoChamado method, of class TipoChamadoBean.
     */
    @Test
    public void testSetListarTipoChamado() {
        Assert.assertEquals(null, "null"); 
    }

    @Test
    public void testGetTipoChamado() {
        tipoChamadoBean.getTipoChamado();
        Assert.assertEquals(null, "null"); 
    }

    /**
     * Test of setTipoChamado method, of class TipoChamadoBean.
     */
    @Test
    public void testSetTipoChamado() {
        Assert.assertEquals(null, "null"); 
    }

    @Test
    public void testGetId() {
        tipoChamadoBean.getId();
        Assert.assertEquals(null, "null"); 
    }

    /**
     * Test of setId method, of class TipoChamadoBean.
     */
    @Test
    public void testSetId() {
        Assert.assertEquals(null, "null"); 
    }

    @Test
    public void testInserirTipoChamado() throws Exception {
        tipoChamadoBean.inserirTipoChamado();
        Assert.assertEquals(null, "null");        
    }
        
    @Test
    public void testBuscarTipoChamado() {
        TipoChamado tipo = new TipoChamado();       
        tipo = tipoChamadoBean.buscarTipoChamado(1);
        
        Assert.assertEquals("Novo", tipo.getNome());
        
    }

    @Test
    public void testAlterarTipoChamado() {
        TipoChamado tipo = new TipoChamado();
        tipo.setId(2);
        tipo.setNome("MelhoriaTeste");
        tipoChamadoBean.alterarTipoChamado(tipo);
        
        tipo = tipoChamadoBean.buscarTipoChamado(2);
        
        Assert.assertEquals("MelhoriaTeste", tipo.getNome());  
    }
}