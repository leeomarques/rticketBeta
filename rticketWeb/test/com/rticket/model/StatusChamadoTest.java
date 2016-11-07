package com.rticket.model;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.negocio.ControladorStatusChamado;
import java.util.ArrayList;
import java.util.Collection;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class StatusChamadoTest {
    
    private ControladorStatusChamado controladorSChamado = new ControladorStatusChamado();
    private StatusChamado statusChamado = new StatusChamado();
    private Collection<StatusChamado> colecaoSChamado = new ArrayList();
    
    public StatusChamadoTest() {
        
    }
    
    @Before
    public void setUp() {
        
    }

    @Test
    public void verificarCaracteres(){
        
        boolean resultado  = false;
        boolean resultado1 = true;
        boolean resultado2 = true;
        boolean resultado3 = true;
        String nome  = "Novo";
        String nome1 = "Novo123";
        String nome2 = "123Novo";
        String nome3 = "No123vo";

        resultado  = controladorSChamado.verificarCaracteres(nome);
        resultado1 = controladorSChamado.verificarCaracteres(nome1);
        resultado2 = controladorSChamado.verificarCaracteres(nome2);
        resultado3 = controladorSChamado.verificarCaracteres(nome3);

        Assert.assertEquals(true, resultado);
        Assert.assertEquals(false, resultado1);
        Assert.assertEquals(false, resultado2);
        Assert.assertEquals(false, resultado3);
    }

    @Test
    public void buscarNome(){
        
        boolean resultado = false;
        boolean resultado1 = true;
        String nome = "Novo";
        String nome1 = "Nomenaonxiste";
        
        
        resultado = controladorSChamado.buscarNome(nome);
        resultado1 = controladorSChamado.buscarNome(nome1);
        
        Assert.assertEquals(true, resultado);
        Assert.assertEquals(false, resultado1);  
    }

    @Test
    public void inserirStatusChamado(){
         
        try {
            statusChamado.setNome("Teste");
            boolean resultado = false;
            
            controladorSChamado.inserirStatusChamado(statusChamado);
            
            resultado = controladorSChamado.buscarNome(statusChamado.getNome());
            
            Assert.assertEquals(true, resultado);
            
        } catch (FormatoInvalidoException ex) {
            Assert.fail();
        } catch (CampoExistenteException ex) {
            Assert.fail();
        } catch (CampoVazioException ex) {
            Assert.fail();
        }    
    }

    @Test
    public void buscarStatusChamado() {
        
        int id = 1;
        int id1 = 100;
        boolean resultado  = false;
        boolean resultado1 = true;
               
        statusChamado = controladorSChamado.buscarStatusChamado(id1);
        
        if(statusChamado == null){
            resultado1 = false;
        }
        
        Assert.assertEquals(false, resultado1);
        
        statusChamado = controladorSChamado.buscarStatusChamado(id);
        
        if(statusChamado != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void alterarStatusChamado() {

        statusChamado.setId(2);
        statusChamado.setNome("Teste");
        statusChamado.setFinaliza("S");
        StatusChamado statusChamadoResul = new StatusChamado();
        boolean resultado = false;
        
        controladorSChamado.alterarStatusChamado(statusChamado);
        
        statusChamadoResul = controladorSChamado.buscarStatusChamado(2);
        
        if(statusChamadoResul.getNome().equals(statusChamado.getNome())){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void listarStatusChamado() {
        
        boolean resultado = false;
        colecaoSChamado = controladorSChamado.listarStatusChamado();
        
        if(colecaoSChamado != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }
}