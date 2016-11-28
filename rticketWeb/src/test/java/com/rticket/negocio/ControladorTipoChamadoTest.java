package com.rticket.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotEquals;

import java.util.Collection;

import org.junit.Test;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.TipoChamado;

public class ControladorTipoChamadoTest {

	ControladorTipoChamado cTipoChamado = new ControladorTipoChamado();
	
	@Test
	public void inserirTipoChamado() {
		TipoChamado tipoChamado = inserirTipoChamada("tipoA");
		
		boolean resultado = false;
		Collection<TipoChamado> tipos = cTipoChamado.listarTipoChamado();
		for (TipoChamado tipo : tipos) {
			if (tipo == tipoChamado) {
				resultado = true;
			}
		}
		assertEquals(true, resultado);
	}
	
	@Test
	public void inserirTipoChamadoNulo() {
		try {
			cTipoChamado.inserirTipoChamado(null);
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			fail();
		} catch (CampoVazioException e) {
			
		}
	}
	
	@Test
	public void inserirTipoChamadoComNomeNulo() {
		TipoChamado tipoChamado = new TipoChamado();
	    tipoChamado.setNome(null);
	    try {
			cTipoChamado.inserirTipoChamado(tipoChamado);
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			fail();
		} catch (CampoVazioException e) {
			
		}
	}
	
	@Test
	public void inserirTipoChamadoComNomeVazio() {
		TipoChamado tipoChamado = new TipoChamado();
	    tipoChamado.setNome("");
	    try {
			cTipoChamado.inserirTipoChamado(tipoChamado);
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			fail();
		} catch (CampoVazioException e) {
			
		}
	}

	@Test
	public void inserirTipoQueExiste() {
		TipoChamado tipoChamado = inserirTipoChamada("tipoB");
		try {
			cTipoChamado.inserirTipoChamado(tipoChamado);
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
		} catch (CampoVazioException e) {
			fail();
		}
	}
	
	@Test
	public void inserirTipoComCaratectesEspeciais() {
		TipoChamado tipoChamado = new TipoChamado();
	    tipoChamado.setNome("#%$");
	    try {
			cTipoChamado.inserirTipoChamado(tipoChamado);
			fail();
		} catch (FormatoInvalidoException e) {
			
		} catch (CampoExistenteException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		}
	}
	
//	@Test
//	public void alterarTipo() {
//		TipoChamado tipoChamado = inserirTipoChamada("tipoC");
//		String nome = new String(tipoChamado.getNome());
//		
//		tipoChamado.setNome("MudarNome");
//		cTipoChamado.alterarTipoChamado(tipoChamado);
//		
//		TipoChamado tipoBuscado = cTipoChamado.buscarTipoChamado(tipoChamado.getId());
//		assertNotEquals(nome, tipoBuscado.getNome());
//	}
//	
//	@Test
//	public void buscarPorNomeQueExiste() {
//		TipoChamado tipoChamado = inserirTipoChamada("tipoD");
//		TipoChamado tipoBuscado = cTipoChamado.buscarTipoChamadoNome(tipoChamado.getNome());
//		
//		assertEquals(tipoChamado.getNome(), tipoBuscado.getNome());
//	}
	
	private TipoChamado inserirTipoChamada(String nome) {
		TipoChamado tipoChamado = new TipoChamado();
	    tipoChamado.setNome(nome);
	    try {
			cTipoChamado.inserirTipoChamado(tipoChamado);
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			fail();
		} catch (CampoVazioException e) {
			
		}
	    return tipoChamado;
	}
}
