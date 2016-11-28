package com.rticket.filters;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginFiltroTest {
    
    LoginFiltro loginFiltro = new LoginFiltro();
    
    public LoginFiltroTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testDoFilter() throws Exception {
        loginFiltro.doFilter(null, null, null);
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testInit() throws Exception {
        loginFiltro.init(null);
        Assert.assertEquals(null, "null");
    }

    @Test
    public void testDestroy() {
        loginFiltro.destroy();
        Assert.assertEquals(null, "null");
    }
    
}
