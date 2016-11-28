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
    }

    @Test
    public void testSetNome() {
    }

    @Test
    public void testGetListarTipoChamado() {
    }

    /**
     * Test of setListarTipoChamado method, of class TipoChamadoBean.
     */
    @Test
    public void testSetListarTipoChamado() {
    }

    /**
     * Test of getTipoChamado method, of class TipoChamadoBean.
     */
    @Test
    public void testGetTipoChamado() {
    }

    /**
     * Test of setTipoChamado method, of class TipoChamadoBean.
     */
    @Test
    public void testSetTipoChamado() {
    }

    /**
     * Test of getId method, of class TipoChamadoBean.
     */
    @Test
    public void testGetId() {
    }

    /**
     * Test of setId method, of class TipoChamadoBean.
     */
    @Test
    public void testSetId() {
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