package com.rticket.beans;

import com.rticket.model.Perfil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PerfilBeanTest {
    
    PerfilBean perfilBean = new PerfilBean();
    Perfil perfil = new Perfil();
    
    public PerfilBeanTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testBuscarPerfil() {
        perfil = perfilBean.buscarPerfil(1);        
        Assert.assertEquals("Administrador", perfil.getNome());
    }

    @Test
    public void testAlterarPerfil() {
        perfil.setId(1);
        perfil.setNome("Local");
        
        perfilBean.alterarPerfil(perfil);
        perfil = perfilBean.buscarPerfil(1);
        Assert.assertEquals("local", perfil.getNome());
    }

    @Test
    public void testGetListarPerfil() {
        perfilBean.getListarPerfil();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setListarPerfil method, of class PerfilBean.
     */
    @Test
    public void testSetListarPerfil() {
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetNome() {
        perfilBean.getNome();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setNome method, of class PerfilBean.
     */
    @Test
    public void testSetNome() {
        Assert.assertEquals(null, "null");
    }
    @Test
    public void testGetPerfil() {
        perfilBean.getPerfil();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setPerfil method, of class PerfilBean.
     */
    @Test
    public void testSetPerfil() {
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testInserirPerfil() throws Exception {
        perfilBean.inserirPerfil();
        Assert.assertEquals(null, "null");
    }
    
}
