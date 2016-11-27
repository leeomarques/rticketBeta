package com.rticket.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Perfil;

public class ControladorPerfilTest {
	ControladorPerfil cPerfil;
	
	@Before
    public void setUp() {
		cPerfil = new ControladorPerfil();
	}
	
	@After
	public void end() {
		cPerfil = null;
	}
	

	
	@Test
	public void inserirNovaPerfil() {
		Perfil Perfil = criarPerfil("NovoPerfil");
		try {
			cPerfil.inserirPerfil(Perfil);
			assertEquals(true, cPerfil.existePerfilNoDB(Perfil));
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		}
	}
	
	@Test
	public void inserirPerfilComCampoVazio() {
		Perfil Perfil = new Perfil();
		try {
			cPerfil.inserirPerfil(Perfil);
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			fail();
		} catch (CampoVazioException e) {
		}
	}
	
	@Test
	public void PerfilQueExisteNoDB() {
		Perfil Perfil = obterPerfilValidaNoDB();
		try {
			cPerfil.inserirPerfil(Perfil);
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			
		} catch (CampoVazioException e) {
			fail();
		}
	}
	
	@Test
	public void buscaNomePerfilQueExiste() {
		Perfil Perfil = obterPerfilValidaNoDB();
		Perfil resultado = cPerfil.buscarPerfilNome(Perfil.getNome());
		assertEquals(true, (Perfil.equals(resultado)));
	}
	
	@Test
	public void buscarPerfilPorIdQueExiste() {
		Perfil Perfil = obterPerfilValidaNoDB();
		Perfil resultado = cPerfil.buscarPerfil(Perfil.getId());
		assertEquals(true, (Perfil.equals(resultado)));
	}
	
	@Test
	public void buscarPerfilQueNaoExiste() {
		Perfil Perfil = criarPerfil("PerfilQualquer");
		Perfil resultado = cPerfil.buscarPerfil(Perfil.getId());
		assertEquals(false, (Perfil.equals(resultado)));
	}
	
	@Test
	public void inserirPerfilNula() {
		try {
			inserirPerfil(null);
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			fail();
		} catch (CampoVazioException e) {
		}
	}
	
	@Test
	public void inserirPerfilComNomeVazio() {
		try {
			inserirPerfil(criarPerfil(""));
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			fail();
		} catch (CampoVazioException e) {
		}
	}
	
	@Test
	public void inserirPerfilComNomeNulo() {
		try {
			inserirPerfil(criarPerfil(null));
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			fail();
		} catch (CampoVazioException e) {
		}
	}
	
	@Test
	public void alterarPerfilQueExiste() {
		Perfil perfil = obterPerfilValidaNoDB();
		String nome = new String(perfil.getNome());
		
		perfil.setNome("MudarNome");
		cPerfil.alterarPerfil(perfil);

		assertNotEquals(nome, perfil.getNome());
	}
	
	@Test
	public void listarPerfils() {
		inserirPerfilNoDb(criarPerfil("PerfilUm"));
		inserirPerfilNoDb(criarPerfil("PerfilDois"));
		
		Collection<Perfil> perfils = cPerfil.listarPerfil();
		
		assertEquals(true, perfils != null && perfils.size() > 0);
	}
	
	@Test
	public void desativarTodasAsPerfils() {
		inserirPerfilNoDb(criarPerfil("PerfilTres"));
		inserirPerfilNoDb(criarPerfil("PerfilQuatro"));
		
		Collection<Perfil> perfils = cPerfil.listarPerfil();
		for (Perfil p : perfils) {
			p.setAtivo("A");
			cPerfil.alterarPerfil(p);
		}
		
		Collection<Perfil> novaLista = cPerfil.listarPerfil();
		
		assertEquals(0, novaLista.size());	
	}
	
	@Test
	public void inserirComNomeCaracteresEspeciais() {
		try {
			Perfil perfil = criarPerfil("%$#@#");
			cPerfil.inserirPerfil(perfil);
			fail(); 
		} catch (FormatoInvalidoException ex) {
			
		} catch (CampoExistenteException ex) {
			fail();
		} catch (CampoVazioException ex) {
			fail();
		}   
	}
	
	private Perfil criarPerfil(String nome) {
		Perfil perfil = new Perfil();
		perfil.setNome(nome);
		perfil.setAtivo(null);
		return perfil;
	}
	
	private Perfil criarPerfil() {
		return criarPerfil("PerfilInserido");
	}
	
	private Perfil obterPerfilValidaNoDB() {
		Perfil perfil = criarPerfil();
		
		Perfil rPerfil = buscarPerfil(perfil.getNome());
		if (rPerfil == null) {
			try {
				inserirPerfil(perfil);
			} catch (Exception e) {
				fail();
			}
		} else {
			return rPerfil;
		}
		
		return perfil;
	}
	
	private void inserirPerfilNoDb(Perfil Perfil) {
		try {
			cPerfil.inserirPerfil(Perfil);
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			
		} catch (CampoVazioException e) {
			fail();
		}
	}
	
	private void inserirPerfil(Perfil Perfil) 
			throws FormatoInvalidoException, CampoExistenteException, CampoVazioException {
		cPerfil.inserirPerfil(Perfil);
	}
	
	private Perfil buscarPerfil(String nome) {
		return cPerfil.buscarPerfilNome(nome);
	}
	
	
}
