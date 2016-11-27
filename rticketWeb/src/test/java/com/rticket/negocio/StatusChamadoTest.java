package com.rticket.negocio;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.StatusChamado;
import com.rticket.negocio.ControladorStatusChamado;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collection;

import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StatusChamadoTest {
    private ControladorStatusChamado cStatusChamado;
    
    public StatusChamadoTest() {
    }
    
    @Before
    public void setUp() {
    	cStatusChamado = new ControladorStatusChamado();
    }
    
    @After
    public void end() {
    	cStatusChamado = null;
    }

    @Test 
    public void inserirStatusChamado() {
    	try {
    		StatusChamado statusChamado = criarStatusChamado("Teste");
    		boolean resultado = false;
		     
    		cStatusChamado.inserirStatusChamado(statusChamado);
		     
    		resultado = cStatusChamado.buscarNome(statusChamado.getNome());
		     
    		assertEquals(true, resultado); 
		} catch (FormatoInvalidoException ex) {
			fail();
		} catch (CampoExistenteException ex) {
			fail();
		} catch (CampoVazioException ex) {
			fail();
		}    
    }

    @Test
    public void inserirComNomeVazio() {
    	try {
    		StatusChamado statusChamado = criarStatusChamado("");
    		cStatusChamado.inserirStatusChamado(statusChamado);
    		fail(); 
		} catch (FormatoInvalidoException ex) {
			fail();
		} catch (CampoExistenteException ex) {
			fail();
		} catch (CampoVazioException ex) {
			
		}   
    }
    
    @Test
    public void inserirComNomeNulo() {
    	try {
    		StatusChamado statusChamado = criarStatusChamado(null);
    		cStatusChamado.inserirStatusChamado(statusChamado);
    		fail(); 
		} catch (FormatoInvalidoException ex) {
			fail();
		} catch (CampoExistenteException ex) {
			fail();
		} catch (CampoVazioException ex) {
			
		}   
    } 
    
    @Test
    public void inserirComNomeCaracteresEspeciais() {
    	try {
    		StatusChamado statusChamado = criarStatusChamado("%$#@#");
    		cStatusChamado.inserirStatusChamado(statusChamado);
    		fail(); 
		} catch (FormatoInvalidoException ex) {
			
		} catch (CampoExistenteException ex) {
			fail();
		} catch (CampoVazioException ex) {
			fail();
		}   
    }
    
    @Test
    public void inserirValorNulo() {
    	try {
    		cStatusChamado.inserirStatusChamado(null);
    		fail(); 
		} catch (FormatoInvalidoException ex) {
			fail();
		} catch (CampoExistenteException ex) {
			fail();
		} catch (CampoVazioException ex) {
			
		}   
    }
    
    @Test
    public void inserirStatusChamadoQueExisteNoDb() {
    	try {
    		StatusChamado statusChamado = obterPrioridadeValidaNoDB();
    		cStatusChamado.inserirStatusChamado(statusChamado);
    		fail(); 
		} catch (FormatoInvalidoException ex) {
			fail();
		} catch (CampoExistenteException ex) {
			
		} catch (CampoVazioException ex) {
			fail();
		}   
    }
    
    @Test
    public void alterarStatusChamadoQueExisteNoDb() {
		StatusChamado statusChamado = obterPrioridadeValidaNoDB();
		String nome = new String(statusChamado.getNome());
		
		statusChamado.setNome("MudarNome");
		
		cStatusChamado.alterarStatusChamado(statusChamado);
		assertNotEquals(nome, statusChamado.getNome());
    }
    
    @Test
	public void buscarStatusChamadoPorIdQueExiste() {
    	StatusChamado statusChamado = obterPrioridadeValidaNoDB();
    	StatusChamado resultado = cStatusChamado.buscarStatusChamado(statusChamado.getId());
		assertEquals(statusChamado.getNome(), resultado.getNome());
	}
    
    @Test
	public void listarPrioridades() {
		inserirStatusChamadoNoDb(criarStatusChamado("statusUm"));
		inserirStatusChamadoNoDb(criarStatusChamado("statusDois"));
		
		Collection<StatusChamado> status = cStatusChamado.listarStatusChamado();
		
		assertEquals(true, status != null && status.size() > 0);
	}
    
    @Test
	public void desativarTodosOsStatus() {
    	inserirStatusChamadoNoDb(criarStatusChamado("statusTres"));
		inserirStatusChamadoNoDb(criarStatusChamado("statusQuatro"));
		
		Collection<StatusChamado> status = cStatusChamado.listarStatusChamado();
		int n = status.size();
		
		for (StatusChamado s : status) {
			s.setAtivo("A");
			cStatusChamado.alterarStatusChamado(s);
		}
		
		Collection<StatusChamado> novaLista = cStatusChamado.listarStatusChamado();
		
		assertEquals(0, novaLista.size());	
	}
    
    
    private StatusChamado obterPrioridadeValidaNoDB() {
    	StatusChamado statusChamado = criarStatusChamado("novastatuschamado");
    	StatusChamado rStatusChamado = buscaStatusChamado(statusChamado.getNome());
		if (rStatusChamado == null) {
				try {
					inserirStatusChamado(statusChamado);
				} catch (FormatoInvalidoException e) {
					fail();
				} catch (CampoExistenteException e) {
					fail();
				} catch (CampoVazioException e) {
					fail();
				}
			
		} else {
			return rStatusChamado;
		}
		
		return statusChamado;
	}
    
    
    private void inserirStatusChamado(StatusChamado statusChamado)
    		throws FormatoInvalidoException, CampoExistenteException, CampoVazioException {
    	cStatusChamado.inserirStatusChamado(statusChamado);
    }
    
    private StatusChamado buscaStatusChamado(String nome) {
    	return cStatusChamado.buscarStatusChamadoNome(nome);
    }
    
    private StatusChamado criarStatusChamado(String nome) {
    	StatusChamado statusChamado = new StatusChamado();
		statusChamado.setNome(nome);
		return statusChamado;
    }
    
    private void inserirStatusChamadoNoDb(StatusChamado statusChamado) {
		try {
			cStatusChamado.inserirStatusChamado(statusChamado);
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			
		} catch (CampoVazioException e) {
			fail();
		}
	}
}