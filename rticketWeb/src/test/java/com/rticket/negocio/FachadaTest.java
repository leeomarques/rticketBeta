package com.rticket.negocio;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Perfil;

import static org.junit.Assert.assertNotEquals;

public class FachadaTest {

	private Fachada fachada = new Fachada();
	
	@Test
	public void inserirPerfil() {
		Perfil perfil = new Perfil();
		perfil.setNome("PerfilTest");
		try {
			this.fachada.inserirPerfil(perfil);
			
			boolean resultado = false;
			for (Perfil p : this.fachada.listarPerfil()) {
				if (p.equals(perfil)) {
					resultado = true;
				}
			}
			
			assertEquals(true, resultado);
		} catch (CampoExistenteException e) {
			
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		}
	}

	@Test
	public void listaPerfils() {
		try {
			Perfil perfil = new Perfil();
			perfil.setNome("PerfilTest");
			this.fachada.inserirPerfil(perfil);
			
			Perfil perfil2 = new Perfil();
			perfil2.setNome("PerfilTestDois");
			this.fachada.inserirPerfil(perfil2);
			
			Collection<Perfil> perfils = this.fachada.listarPerfil();
			assertEquals(true, perfils != null && perfils.size() > 0);
		} catch (CampoExistenteException e) {
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		}
	}
}

