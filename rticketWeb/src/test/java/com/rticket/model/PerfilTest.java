package com.rticket.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class PerfilTest {
	@Test 
	public void compararDiferentes() {
		Perfil a = criarPerfil("A");
		Perfil b = criarPerfil("B");
		
		assertNotEquals(true, a.equals(b));
	}
	
	@Test 
	public void compararIguais() {
		Perfil a = criarPerfil("A");
		Perfil b = criarPerfil("A");
		
		assertEquals(true, a.equals(b));
	}
	
	@Test
	public void compararSegundoComValorNulo() {
		Perfil a = criarPerfil("A");
		Perfil b = null;
		
		assertNotEquals(true, a.equals(b));
	}
	
	@Test
	public void compararPrimeiroComValorNulo() {
		Perfil a = criarPerfil(null);
		Perfil b = criarPerfil("");
		
		assertNotEquals(true, a.equals(b));
	}
	
	private Perfil criarPerfil(String nome) {
		Perfil perfil = new Perfil();
		perfil.setNome(nome);
		return perfil;
	}
}
