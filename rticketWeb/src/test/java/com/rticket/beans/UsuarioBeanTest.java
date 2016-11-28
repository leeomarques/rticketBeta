package com.rticket.beans;

import com.rticket.model.Usuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioBeanTest {
    
    UsuarioBean usuarioBean = new UsuarioBean();
    
    public UsuarioBeanTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testInserirUsuario() throws Exception {
        usuarioBean.inserirUsuario();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testBuscarUsuario() {
        Usuario user = new Usuario();
        user = usuarioBean.buscarUsuario(1);
        
        Assert.assertEquals("toinhotony", user.getLogin());
    }

    @Test
    public void testAlterarUsuario() {
        Usuario user = new Usuario();
        user.setId(1);
        user.setNome("Antonio");
        user.setSenha("1234");
        user.setLogin("toinhotony");
        
        usuarioBean.alterarUsuario(user);
        
        Assert.assertEquals("Antonio", user.getNome());
        
    }

    /**
     * Test of listarUsuario method, of class UsuarioBean.
     */
    @Test
    public void testListarUsuario() {
        usuarioBean.listarUsuario();
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetNome() {
        usuarioBean.getNome();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setNome method, of class UsuarioBean.
     */
    @Test
    public void testSetNome() {
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetLogin() {
        usuarioBean.getLogin();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setLogin method, of class UsuarioBean.
     */
    @Test
    public void testSetLogin() {
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetSenha() {
        usuarioBean.getSenha();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setSenha method, of class UsuarioBean.
     */
    @Test
    public void testSetSenha() {
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetListarUsuario() {
        usuarioBean.getListarUsuario();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setListarUsuario method, of class UsuarioBean.
     */
    @Test
    public void testSetListarUsuario() {
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetPerfil() {
        usuarioBean.getPerfil();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setPerfil method, of class UsuarioBean.
     */
    @Test
    public void testSetPerfil() {
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetListarPerfil() {
        usuarioBean.getListarPerfil();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setListarPerfil method, of class UsuarioBean.
     */
    @Test
    public void testSetListarPerfil() {
        Assert.assertEquals(null, "null");
    }
}