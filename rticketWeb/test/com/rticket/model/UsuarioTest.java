package com.rticket.model;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.excecao.ValidarLoginException;
import com.rticket.negocio.ControladorUsuario;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
    
    private ControladorUsuario controladorUsuario = new ControladorUsuario();
    private Collection<Usuario> colecaoUser = new ArrayList();
    
    public UsuarioTest() {
        
    }
    
    @Before
    public void setUp() {
        
    }
    
    @Test
    public void efetuarLogin(){
        
        try {
            String login = "toinhotony";
            String senha = "1785";
            boolean resultado = false;
        
            colecaoUser = controladorUsuario.efetuarLogin(login, senha);
            if (colecaoUser != null){
                resultado = true;
            }
        
        Assert.assertEquals(true, resultado);
            
        } catch (ValidarLoginException ex) {
            Assert.fail();
        } catch (NoSuchAlgorithmException ex) {
            Assert.fail();
        }       
    }
    
    @Test
    public void efetuarLoginSenhaInvalida(){
        
        try {
            String login = "toinhotonyte";
            String senha = "123456789s";
            
            colecaoUser = controladorUsuario.efetuarLogin(login, senha);
            boolean resultado = true;
            if (colecaoUser.isEmpty()){
                resultado = false;
            }
        
        Assert.assertEquals(false, resultado);
            
        } catch (ValidarLoginException ex) {
            Assert.fail();
        } catch (NoSuchAlgorithmException ex) {
            Assert.fail();
        }       
    }
    
    @Test
    public void efetuarLoginInvalido(){
        
        try {
            String login = "toinho";
            String senha = "1785";
        
            colecaoUser = controladorUsuario.efetuarLogin(login, senha);
            boolean resultado = true;
            if (colecaoUser.isEmpty()){
                resultado = false;
            }
        
        Assert.assertEquals(false, resultado);
            
        } catch (ValidarLoginException ex) {
            Assert.fail();
        } catch (NoSuchAlgorithmException ex) {
            Assert.fail();
        }       
    }
    
    @Test
    public void efetuarLoginESenhaVazio(){
        
        try {
            String login = "";
            String senha = "";
        
            colecaoUser = controladorUsuario.efetuarLogin(login, senha);
            boolean resultado = true;
            if (colecaoUser.isEmpty()){
                resultado = false;
            }
        
        Assert.assertEquals(false, resultado);
            
        } catch (ValidarLoginException ex) {
            Assert.fail();
        } catch (NoSuchAlgorithmException ex) {
            Assert.fail();
        }       
    }
    
    @Test
    public void efetuarLoginSenhaVazio(){
        
        try {
            String login = "toinhotony";
            String senha = "";
        
            colecaoUser = controladorUsuario.efetuarLogin(login, senha);
            boolean resultado = true;
            if (colecaoUser.isEmpty()){
                resultado = false;
            }
        
        Assert.assertEquals(false, resultado);
            
        } catch (ValidarLoginException ex) {
            Assert.fail();
        } catch (NoSuchAlgorithmException ex) {
            Assert.fail();
        }       
    }
    
    @Test
    public void efetuarLoginVazio(){
        
        try {
            String login = "";
            String senha = "1785";
        
            colecaoUser = controladorUsuario.efetuarLogin(login, senha);
            boolean resultado = true;
            if (colecaoUser.isEmpty()){
                resultado = false;
            }
        
        Assert.assertEquals(false, resultado);
            
        } catch (ValidarLoginException ex) {
            Assert.fail();
        } catch (NoSuchAlgorithmException ex) {
            Assert.fail();
        }       
    }
    
    @Test
    public void efetuarLoginSenhaLimiteCaracteres(){
        
        try {
            String login = "toinhotony";
            String senha = "6da6d456as4d56as4d56as4d56as4d564as56d4as56d4a56s4"
                    + "4dad456as4d";
        
            colecaoUser = controladorUsuario.efetuarLogin(login, senha);
            boolean resultado = true;
            if (colecaoUser.isEmpty()){
                resultado = false;
            }
        
        Assert.assertEquals(false, resultado);
            
        } catch (ValidarLoginException ex) {
            Assert.fail();
        } catch (NoSuchAlgorithmException ex) {
            Assert.fail();
        }       
    }
    
    @Test
    public void efetuarLoginLimiteCaracteres(){
        
        try {
            String login = "jfklsdhfljkhjksdhfjklsahfjklhfjkhfjkfhjkhfjkgghfjk"
                    + "shfjksdahfkjasdhfjkasdhfjksdhffjksdhfjkasdhfjksadhfsjkad"
                    + "hfasjkhfsjkadfhasjkdfhsjkadfhsdjkafhsdjkffhssfjkaasfhj";
            String senha = "1785";
        
            colecaoUser = controladorUsuario.efetuarLogin(login, senha);
            boolean resultado = true;
            if (colecaoUser.isEmpty()){
                resultado = false;
            }
        
        Assert.assertEquals(false, resultado);
            
        } catch (ValidarLoginException ex) {
            Assert.fail();
        } catch (NoSuchAlgorithmException ex) {
            Assert.fail();
        }       
    }
    
    @Test
    public void verificarCaracteres(){
        
        boolean resultado = false;
        String nome = "Pedro";

        resultado = controladorUsuario.verificarCaracteres(nome);

        Assert.assertEquals(true, resultado);
    }

    @Test
    public void buscarLogin(){
        
        String login = "toinhotony";
        boolean resultado = false;
        
        resultado = controladorUsuario.buscarLogin(login);
        
        Assert.assertEquals(true, resultado);       
    }
  
    @Test
    public void converterSenhaMD5(){
 
        try {
            String senha = "1234";
            String senhaConvertida = "81dc9bdb52d04dc20036dbd8313ed055";
            String senhaMD5;
            boolean resultado = false;
       
            senhaMD5 = controladorUsuario.converterSenhaMD5(senha);
            
            if (senhaConvertida.equals(senhaMD5)){
                resultado = true;
            }
                    
            Assert.assertEquals(true, resultado);
                    
        } catch (NoSuchAlgorithmException ex) {
            Assert.fail();
        }    
    }

    @Test
    public void inserirUsuario(){
       
        try {
            Usuario user = new Usuario();
            user.setNome("PedroTesteOliver");
            user.setLogin("Pedro");
            user.setSenha("123456789");
            boolean resultado = false;
            
            controladorUsuario.inserirUsuario(user);
            
            resultado = controladorUsuario.buscarLogin(user.getLogin());
            
            Assert.assertEquals(true, resultado);
            
        } catch (CampoVazioException ex) {
             Assert.fail();
        } catch (CampoExistenteException ex) {
             Assert.fail();
        } catch (NoSuchAlgorithmException ex) {
             Assert.fail();
        } catch (FormatoInvalidoException ex) {
             Assert.fail();
        }      
    }

    @Test
    public void buscarUsuario(){
        
        int id = 1;
        boolean resultado = false;
        Usuario user = new Usuario();
        
        user = controladorUsuario.buscarUsuario(id);
        
        if(user != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void alterarUsuario() {
        
        try {
            Usuario user = new Usuario();
            user.setId(1);
            user.setNome("AntonioCorreadeOliveira");
            user.setLogin("TESTEDD");
            user.setSenha("123456789");
            Usuario userResul = new Usuario();
            boolean resultado = false;
              
        
            controladorUsuario.alterarUsuario(user);
            
            userResul = controladorUsuario.buscarUsuario(1);
            
            if(userResul.getNome().equals(user.getNome())){
                resultado = true;
            }
            
            Assert.assertEquals(true, resultado);
            
        } catch (FormatoInvalidoException ex) {
            Logger.getLogger(UsuarioTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioTest.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }

    @Test
    public void listarUsuario(){
        
        boolean resultado = false;
        colecaoUser = controladorUsuario.listarUsuario();
        
        if(colecaoUser != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }
}