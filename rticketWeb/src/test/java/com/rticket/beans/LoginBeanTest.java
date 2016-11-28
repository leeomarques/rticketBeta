package com.rticket.beans;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginBeanTest {
    
    LoginBean loginBean = new LoginBean();
    
    public LoginBeanTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetLogin() {
        loginBean.getLogin();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setLogin method, of class LoginBean.
     */
    @Test
    public void testSetLogin() {
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetSenha() {
        loginBean.getSenha();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setSenha method, of class LoginBean.
     */
    @Test
    public void testSetSenha() {
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetUsuarioLogado() {
        loginBean.getUsuarioLogado();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setUsuarioLogado method, of class LoginBean.
     */
    @Test
    public void testSetUsuarioLogado() {
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetLogout() {
        loginBean.getLogout();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setLogout method, of class LoginBean.
     */
    @Test
    public void testSetLogout() {
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testGetUser() {
        loginBean.getUser();
        Assert.assertEquals(null, "null");
    }

    /**
     * Test of setUser method, of class LoginBean.
     */
    @Test
    public void testSetUser() {
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testMensagemErro() {
        loginBean.mensagemErro();
        Assert.assertEquals(null, "null");    
    }

    @Test
    public void testEfetuarLogin() throws Exception {
        String usuarioLogado;
        usuarioLogado = loginBean.efetuarLogin();
        if(usuarioLogado.isEmpty()){
            testMensagemErro();
        }
        Assert.assertEquals(null, "null");      
    }
}
