package com.rticket.negocio;

import org.junit.Test;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Prioridade;
import com.rticket.negocio.ControladorPrioridade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotEquals;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;

public class PrioridadeTest {
	ControladorPrioridade cPrioridade;

	@Before
    public void setUp() {
		cPrioridade = new ControladorPrioridade();
	}
	
	@After
	public void end() {
		cPrioridade = null;
	}
	
	@Test
	public void inserirNovaPrioridade() {
		Prioridade prioridade = criarPrioridade("Nova prioridade");
		
		try {
			cPrioridade.inserirPrioridade(prioridade);
			assertEquals(true, cPrioridade.existePrioridadeNoDB(prioridade));
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		}
	}
	
	@Test
	public void inserirPrioridadeComCampoVazio() {
		Prioridade prioridade = new Prioridade();
		try {
			cPrioridade.inserirPrioridade(prioridade);
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			fail();
		} catch (CampoVazioException e) {
		}
	}
	
	@Test
	public void prioridadeQueExisteNoDB() {
		Prioridade prioridade = obterPrioridadeValidaNoDB();
		try {
			cPrioridade.inserirPrioridade(prioridade);
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			
		} catch (CampoVazioException e) {
			fail();
		}
	}
	
	@Test
	public void buscaNomePrioridadeQueExiste() {
		Prioridade prioridade = obterPrioridadeValidaNoDB();
		Prioridade resultado = cPrioridade.buscarPrioridadeNome(prioridade.getNome());
		assertEquals(true, (prioridade.equals(resultado)));
	}
	
	@Test
	public void buscarPrioridadePorIdQueExiste() {
		Prioridade prioridade = obterPrioridadeValidaNoDB();
		Prioridade resultado = cPrioridade.buscarPrioridade(prioridade.getId());
		assertEquals(true, (prioridade.equals(resultado)));
	}
	
	@Test
	public void buscarPrioridadeQueNaoExiste() {
		Prioridade prioridade = criarPrioridade("Prioridade Qualquer");
		Prioridade resultado = cPrioridade.buscarPrioridade(prioridade.getId());
		assertEquals(false, (prioridade.equals(resultado)));
	}
	
	@Test
	public void inserirPrioridadeNula() {
		try {
			inserirPrioridade(null);
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			fail();
		} catch (CampoVazioException e) {
		}
	}
	
	@Test
	public void inserirPrioridadeComNomeVazio() {
		try {
			inserirPrioridade(criarPrioridade(""));
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			fail();
		} catch (CampoVazioException e) {
		}
	}
	
	@Test
	public void inserirPrioridadeComNomeNulo() {
		try {
			inserirPrioridade(criarPrioridade(null));
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			fail();
		} catch (CampoVazioException e) {
		}
	}
	
	@Test
	public void alterarPrioridadeQueExiste() {
		Prioridade prioridade = obterPrioridadeValidaNoDB();
		String nome = new String(prioridade.getNome());
		
		prioridade.setNome("Mudar nome");
		cPrioridade.alterarPrioridade(prioridade);

		assertNotEquals(nome, prioridade.getNome());
	}
	
	@Test
	public void listarPrioridades() {
		inserirPrioridadeNoDb(criarPrioridade("prioridade 1"));
		inserirPrioridadeNoDb(criarPrioridade("prioridade 2"));
		
		Collection<Prioridade> prioridades = cPrioridade.listarPrioridade();
		
		assertEquals(true, prioridades != null && prioridades.size() > 0);
	}
	
	@Test
	public void desativarTodasAsPrioridades() {
		inserirPrioridadeNoDb(criarPrioridade("prioridade 3"));
		inserirPrioridadeNoDb(criarPrioridade("prioridade 4"));
		
		Collection<Prioridade> prioridades = cPrioridade.listarPrioridade();
		for (Prioridade p : prioridades) {
			p.setAtivo("A");
			cPrioridade.alterarPrioridade(p);
		}
		
		Collection<Prioridade> novaLista = cPrioridade.listarPrioridade();
		
		assertEquals(0, novaLista.size());	
	}
	
	private Prioridade criarPrioridade(String nome) {
		Prioridade prioridade = new Prioridade();
		prioridade.setNome(nome);
		return prioridade;
	}
	
	private Prioridade criarPrioridade() {
		return criarPrioridade("prioridade inserida");
	}
	
	private Prioridade obterPrioridadeValidaNoDB() {
		Prioridade prioridade = criarPrioridade();
		
		Prioridade rPrioridade = buscarPrioridade(prioridade.getNome());
		if (rPrioridade == null) {
			try {
				inserirPrioridade(prioridade);
			} catch (Exception e) {
				fail();
			}
		} else {
			return rPrioridade;
		}
		
		return prioridade;
	}
	
	private void inserirPrioridadeNoDb(Prioridade prioridade) {
		try {
			cPrioridade.inserirPrioridade(prioridade);
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			
		} catch (CampoVazioException e) {
			fail();
		}
	}
	
	private void inserirPrioridade(Prioridade prioridade) 
			throws FormatoInvalidoException, CampoExistenteException, CampoVazioException {
		cPrioridade.inserirPrioridade(prioridade);
	}
	
	private Prioridade buscarPrioridade(String nome) {
		return cPrioridade.buscarPrioridadeNome(nome);
	}
}
