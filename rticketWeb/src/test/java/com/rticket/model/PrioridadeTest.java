package com.rticket.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class PrioridadeTest {
	@Test 
	public void compararDuasPrioridades() {
		Prioridade a = criarPrioridade("A");
		Prioridade b = criarPrioridade("B");
		
		assertNotEquals(true, a.equals(b));
	}
	
	@Test 
	public void compararPrioridadesIguais() {
		Prioridade a = criarPrioridade("A");
		Prioridade b = criarPrioridade("A");
		
		assertEquals(true, a.equals(b));
	}
	
	@Test
	public void compararSegundoComValorNulo() {
		Prioridade a = criarPrioridade("A");
		Prioridade b = null;
		
		assertNotEquals(true, a.equals(b));
	}
	
	@Test
	public void compararPrimeiroComValorNulo() {
		Prioridade a = criarPrioridade(null);
		Prioridade b = criarPrioridade("");
		
		assertNotEquals(true, a.equals(b));
	}
	
	private Prioridade criarPrioridade(String nome) {
		Prioridade prioridade = new Prioridade();
		prioridade.setNome(nome);
		return prioridade;
	}
}
