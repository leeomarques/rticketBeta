package com.rticket.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Chamados;
import com.rticket.model.Prioridade;
import com.rticket.model.StatusChamado;
import com.rticket.model.TipoChamado;
import com.rticket.model.Usuario;

@FixMethodOrder(MethodSorters.DEFAULT)
public class ControladorChamadasTest {
	ControladorChamados cChamados; 
	ControladorUsuario cUsuario;
	ControladorStatusChamado cStatusChamada;
	ControladorTipoChamado cTipoChamado;
	ControladorPrioridade cPrioridade;
	
	@Before
	public void setup() {
		cChamados = new ControladorChamados();
		cUsuario = new ControladorUsuario();
		cStatusChamada = new ControladorStatusChamado();
		cTipoChamado = new ControladorTipoChamado();
		cPrioridade = new ControladorPrioridade();
	}
	
	@After
	public void destroy() {
		cChamados = null;
		cUsuario = null;
		cStatusChamada = null;
		cTipoChamado = null;
		cPrioridade = null;
	}
	
	/**
	 * Os outros testes depende desse para inserir um chamado.
	 * */
	@Test
	public void inserirChamada() {
		Chamados chamado = inserirChamado();
		boolean resultado = false;
		Collection<Chamados> chamados = cChamados.listarChamadosTotal();
		for (Chamados c : chamados) {
			if (c.equals(chamado)) {
				resultado = true;
			}
		}
		assertEquals(true, resultado);
	}
	
	@Test
	public void inserirChamadaNula() {
		try {
			cChamados.inserirChamados(null);
			fail();
		} catch (CampoVazioException ex) {
		}    
	}
	
	@Test
	public void inserirChamadaDescricaoNula() {
		try {
			Chamados chamado = new Chamados();
			
		    Date dt = new Date();
		    chamado.setDataCriacao(dt);
		    chamado.setTitulo("Chamado Teste");
		    chamado.setDescricao(null);

		    StatusChamado statusChamado = new StatusChamado();
		    statusChamado.setId(1);       
		    chamado.setStatusChamado(statusChamado);

		    TipoChamado tipoChamado = new TipoChamado();
		    tipoChamado.setId(1);
		    chamado.setTipoChamado(tipoChamado);

		    Usuario user = new Usuario();
		    user.setId(1);
		    chamado.setUsuarios(user);
		    chamado.setLoginSolicitante("Teste");
			cChamados.inserirChamados(chamado);
			chamado = cChamados.buscarChamados(chamado.getId());
			assertEquals(false, chamado != null);
			fail();
		} catch (CampoVazioException ex) {
		}    
	}
	
	@Test
	public void inserirChamadaDescricaoVazia() {
		try {
			Chamados chamado = new Chamados();
			
		    Date dt = new Date();
		    chamado.setDataCriacao(dt);
		    chamado.setTitulo("Chamado Teste");
		    chamado.setDescricao("");

		    StatusChamado statusChamado = new StatusChamado();
		    statusChamado.setId(1);       
		    chamado.setStatusChamado(statusChamado);

		    TipoChamado tipoChamado = new TipoChamado();
		    tipoChamado.setId(1);
		    chamado.setTipoChamado(tipoChamado);

		    Usuario user = new Usuario();
		    user.setId(1);
		    chamado.setUsuarios(user);
		    chamado.setLoginSolicitante("Teste");
			cChamados.inserirChamados(chamado);
			chamado = cChamados.buscarChamados(chamado.getId());
			assertEquals(false, chamado != null);
			fail();
		} catch (CampoVazioException ex) {
		}    
	}
	
	@Test
	public void inserirChamadaTituloNulo() {
		try {
			Chamados chamado = new Chamados();
			
		    Date dt = new Date();
		    chamado.setDataCriacao(dt);
		    chamado.setTitulo(null);
		    chamado.setDescricao("descriçao");

			cChamados.inserirChamados(chamado);
			fail();
		} catch (CampoVazioException ex) {
		}    
	}

	@Test
	public void inserirChamadaTituloVazia() {
		try {
			Chamados chamado = new Chamados();
			
		    Date dt = new Date();
		    chamado.setDataCriacao(dt);
		    chamado.setTitulo("");
		    chamado.setDescricao("descriçao");

			cChamados.inserirChamados(chamado);
			fail();
		} catch (CampoVazioException ex) {
		}    
	}
	
	@Test
	public void inserirChamadaVazia() {
		try {
			Chamados chamado = new Chamados();
			cChamados.inserirChamados(chamado);
			fail();
		} catch (CampoVazioException ex) {
		}    
	}
	
	@Test
	public void inserirChamadaStatusChamadaNula() {
		try {
			Chamados chamado = new Chamados();
			Date dt = new Date();
		    chamado.setDataCriacao(dt);
		    chamado.setTitulo("Chamado Teste");
		    chamado.setDescricao("Nao estou conseguindo emitir nota fiscal.");
 
		    chamado.setStatusChamado(null);

		    TipoChamado tipoChamado = new TipoChamado();
		    tipoChamado.setId(1);
		    chamado.setTipoChamado(tipoChamado);

		    Usuario user = new Usuario();
		    user.setId(1);
		    chamado.setUsuarios(user);
		    chamado.setLoginSolicitante("Teste");
			
			cChamados.inserirChamados(chamado);
			fail();
		} catch (CampoVazioException ex) {
		}    
	}
	
	@Test
	public void inserirChamadaComTipoChamadaNula() {
		try {
			Chamados chamado = new Chamados();
			Date dt = new Date();
		    chamado.setDataCriacao(dt);
		    chamado.setTitulo("Chamado Teste");
		    chamado.setDescricao("Nao estou conseguindo emitir nota fiscal.");

		    StatusChamado statusChamado = new StatusChamado();
		    statusChamado.setId(1);       
		    chamado.setStatusChamado(statusChamado);

		    chamado.setTipoChamado(null);

		    Usuario user = new Usuario();
		    user.setId(1);
		    chamado.setUsuarios(user);
		    chamado.setLoginSolicitante("Teste");
		
			
			cChamados.inserirChamados(chamado);
			fail();
		} catch (CampoVazioException ex) {
		}    
	}
	
	@Test
	public void inserirChamadaComUsuarioNulo() {
		try {
			Chamados chamado = new Chamados();
			Date dt = new Date();
		    chamado.setDataCriacao(dt);
		    chamado.setTitulo("Chamado Teste");
		    chamado.setDescricao("Nao estou conseguindo emitir nota fiscal.");

		    StatusChamado statusChamado = new StatusChamado();
		    statusChamado.setId(1);       
		    chamado.setStatusChamado(statusChamado);

		    TipoChamado tipoChamado = new TipoChamado();
		    tipoChamado.setId(1);
		    chamado.setTipoChamado(tipoChamado);

		    chamado.setUsuarios(null);
		    chamado.setLoginSolicitante("Teste");
			
			cChamados.inserirChamados(chamado);
			fail();
		} catch (CampoVazioException ex) {
		}    
	}
	
	@Test
	public void listChamadosPorUsuario() {
		Usuario user = cUsuario.buscarUsuario("user");
		Collection<Chamados> chamados = cChamados.listarChamados(user);
		assertEquals(true, chamados != null && chamados.size() > 0);
	}
	
	@Test
	public void alterarChamado() {
		Chamados chamado = cChamados.buscarChamados(1);
		if (chamado == null) fail("chamado nulo");
		String description = new String(chamado.getDescricao());
		
		
		chamado.setDescricao("mudando a descrição");
		cChamados.alterarChamados(chamado);
		
		Chamados chamdosBuscado = cChamados.buscarChamados(1);
		
		if (chamdosBuscado == null) fail("chamdosBuscado nulo");
		assertNotEquals(description, chamdosBuscado.getDescricao());
	}
	
	@Test
	public void alterarChamadoNulo() {
		cChamados.alterarChamados(null);
	}
	
	@Test
	public void alterarChamadoComDescricaoNula() {
		Chamados chamado = cChamados.buscarChamados(1);
		if (chamado == null) fail("chamado nulo");
		String description = new String(chamado.getDescricao());
		
		chamado.setDescricao("mudando a descrição2");
		cChamados.alterarChamados(chamado);
		
		Chamados chamdosBuscado = cChamados.buscarChamados(1);
		
		if (chamdosBuscado == null) fail("chamdosBuscado nulo");
		assertNotEquals(description, chamdosBuscado.getDescricao());
	}
	
	private StatusChamado criarStatusChamado(String nome) {
    	StatusChamado statusChamado = new StatusChamado();
		statusChamado.setNome(nome);
		return statusChamado;
    }
	
	private Usuario criarUsuario(String nome, String login, String senha) {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		return usuario;
	}
	
	private Prioridade criarPrioridade(String nome) {
		Prioridade prioridade = new Prioridade();
		prioridade.setNome(nome);
		return prioridade;
	}
	
	private TipoChamado inserirTipoChamada(String nome) {
		TipoChamado tipoChamado = new TipoChamado();
	    tipoChamado.setNome(nome);
	    try {
			cTipoChamado.inserirTipoChamado(tipoChamado);
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
		} catch (CampoVazioException e) {
			fail();
		}
	    return tipoChamado;
	}
	
	private StatusChamado inserirStatusChamado(String nome) {
		StatusChamado statusChamado = criarStatusChamado(nome);
	    try {
			cStatusChamada.inserirStatusChamado(statusChamado);
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
		} catch (CampoVazioException e) {
			fail();
		}
	    
	    return statusChamado;
	}
	
	private Usuario inserirUsuario(String nome, String login, String senha) {
		Usuario user = criarUsuario(nome, login, senha);
	    try {
			cUsuario.inserirUsuario(user);
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (CampoExistenteException e) {
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		}
	    return user;
	}
	
	private Prioridade inserirPrioridade(String nome) {
		Prioridade prioridade = criarPrioridade(nome);
	    try {
			cPrioridade.inserirPrioridade(prioridade);
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
		} catch (CampoVazioException e) {
			fail();
		}
	    return prioridade;
	}
	
	private Chamados inserirChamado() {
		Chamados chamado = new Chamados();
		Date dt = new Date();
	    chamado.setDataCriacao(dt);
	    chamado.setTitulo("Chamado Teste");
	    chamado.setDescricao("Nao estou conseguindo emitir nota fiscal.");

	    StatusChamado statusChamado = inserirStatusChamado("statusChamado"); 
	    chamado.setStatusChamado(statusChamado);
	    
	    TipoChamado tipoChamado = inserirTipoChamada("tipoChamado");
	    chamado.setTipoChamado(tipoChamado);
	    
	    Usuario user = inserirUsuario("Usuario", "user", "123");
	    chamado.setUsuarios(user);
	    chamado.setLoginSolicitante("Teste");
	    
	    Prioridade prioridade = inserirPrioridade("prioridade");
	    chamado.setPrioridade(prioridade);
	    
		try {
			cChamados.inserirChamados(chamado);
		} catch (CampoVazioException e) {
			fail();
		}
		
		return chamado;
	}
}
