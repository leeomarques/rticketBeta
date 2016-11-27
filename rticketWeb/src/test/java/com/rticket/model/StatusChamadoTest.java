package com.rticket.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class StatusChamadoTest {
	@Test 
	public void compararDuasPrioridades() {
		StatusChamado a = criarStatusChamado("A");
		StatusChamado b = criarStatusChamado("B");
		
		assertNotEquals(true, a.equals(b));
	}
	
	@Test 
	public void compararPrioridadesIguais() {
		StatusChamado a = criarStatusChamado("A");
		StatusChamado b = criarStatusChamado("A");
		
		assertEquals(true, a.equals(b));
	}
	
	@Test
	public void compararSegundoComValorNulo() {
		StatusChamado a = criarStatusChamado("A");
		StatusChamado b = null;
		
		assertNotEquals(true, a.equals(b));
	}
	
	@Test
	public void compararPrimeiroComValorNulo() {
		StatusChamado a = criarStatusChamado(null);
		StatusChamado b = criarStatusChamado("");
		
		assertNotEquals(true, a.equals(b));
	}
	
	private StatusChamado criarStatusChamado(String nome) {
    	StatusChamado statusChamado = new StatusChamado();
		statusChamado.setNome(nome);
		return statusChamado;
    }
}
