package com.rticket.negocio;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.excecao.ValidarLoginException;
import com.rticket.model.Chamados;
import com.rticket.model.Perfil;
import com.rticket.model.Prioridade;
import com.rticket.model.StatusChamado;
import com.rticket.model.TipoChamado;
import com.rticket.model.Usuario;

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
	
	@Test
	public void alterarPerfil() {
		Perfil perfil = new Perfil();
		perfil.setNome("perfil");
		
		try {
			fachada.inserirPerfil(perfil);
		} catch (CampoExistenteException e) {
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		}
		
		Perfil perfilBuscado = fachada.buscarPerfil(1);
		String nome = new String(perfilBuscado.getNome());
		
		perfilBuscado.setNome("novoNome");
		fachada.alterarPerfil(perfil);
		
		perfilBuscado = fachada.buscarPerfil(1);
		assertNotEquals(nome, perfilBuscado.getNome());
	}
	
	@Test
	public void efetuarLogin() {
		String senha = "123";
		
		Usuario usuario = new Usuario();
		usuario.setNome("fulanoNome");
		usuario.setLogin("login");
		usuario.setSenha(senha);
		
		try {
			fachada.inserirUsuario(usuario);
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		} catch (CampoExistenteException e) {
			
		} catch (FormatoInvalidoException e) {
			fail();
		}
		
		try {
			 Collection<Usuario> usuarios = fachada.efetuarLogin(usuario.getLogin(), senha);
			 if (usuarios != null && usuarios.size() > 0) {
				 Usuario resultado = (Usuario) usuarios.toArray()[0];		
				 assertEquals(true, usuario.getLogin().equals(resultado.getLogin()));
			 } else {
				 fail("Não existe usuario");
			 }
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (ValidarLoginException e) {
			fail();
		}
	}
	
	@Test
	public void listUsuarios() {
		Usuario usuario = new Usuario();
		usuario.setNome("fulano");
		usuario.setLogin("fulano");
		usuario.setSenha("123");
		
		try {
			fachada.inserirUsuario(usuario);
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		} catch (CampoExistenteException e) {
			
		} catch (FormatoInvalidoException e) {
			fail();
		}
		
		Collection<Usuario> usuarios = fachada.listarUsuario();
		assertEquals(true, usuarios.size() > 0);
	}
	
	@Test
	public void alterarUsuario() {
		Usuario usuario = fachada.buscarUsuario(0);
		if (usuario == null) {
			usuario = new Usuario();
			usuario.setNome("fulano");
			usuario.setLogin("fulano");
			usuario.setSenha("123");
			
			try {
				fachada.inserirUsuario(usuario);
			} catch (NoSuchAlgorithmException e) {
				fail();
			} catch (CampoVazioException e) {
				fail();
			} catch (CampoExistenteException e) {
				
			} catch (FormatoInvalidoException e) {
				fail();
			}
		}
	
		String nome = new String(usuario.getNome());
		usuario.setNome("mudarNome");
		try {
			fachada.alterarUsuario(usuario);
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		}
		
		Usuario usuarioBuscado = fachada.buscarUsuario(usuario.getId());
		assertNotEquals(nome, usuarioBuscado.getNome());
	}
	
	@Test
	public void inserirChamadoNormal() {
//		Chamados chamado = inserirChamado();
//		boolean resultado = false;
//		Collection<Chamados> chamados = fachada.listarChamadosTotal();
//		for (Chamados c : chamados) {
//			if (c.equals(chamado)) {
//				resultado = true;
//			}
//		}
//		assertEquals(true, resultado);
	}
	
	@Test
	public void inserirTipoChamado() {
		TipoChamado tipoChamado = inserirTipoChamada("tipoFachada");
		
		boolean resultado = false;
		Collection<TipoChamado> tipos = fachada.listarTipoChamado();
		for (TipoChamado tipo : tipos) {
			if (tipo == tipoChamado) {
				resultado = true;
			}
		}
		assertEquals(true, resultado);
	}
	
	@Test
	public void alterarTipo() {
		TipoChamado tipoChamado = inserirTipoChamada("tipoFachadaA");
		String nome = new String(tipoChamado.getNome());
		
		tipoChamado.setNome("MudarFachada");
		fachada.alterarTipoChamado(tipoChamado);
		
		TipoChamado tipoBuscado = fachada.buscarTipoChamado(tipoChamado.getId());
		assertNotEquals(nome, tipoBuscado.getNome());
	}
	
	@Test
	public void buscarPorNomeQueExiste() {
		TipoChamado tipoChamado = inserirTipoChamada("tipoD");
		TipoChamado tipoBuscado = fachada.buscarTipoChamadoNome(tipoChamado.getNome());
		
		assertEquals(tipoChamado.getNome(), tipoBuscado.getNome());
	}
	
	@Test
	public void inserirNovaPrioridade() {
		Prioridade prioridade = criarPrioridade("prioridadeFachada");
		
		try {
			fachada.inserirPrioridade(prioridade);
			
			boolean resultado = false;
			Collection<Prioridade> prioridades = fachada.listarPrioridade();
			for (Prioridade p : prioridades) {
				if (p == prioridade) {
					resultado = true;
				}
			}
			assertEquals(true, resultado);
			
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoExistenteException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		}
	}
	
	@Test
	public void alterarPrioridadeQueExiste() {
		Prioridade prioridade = inserirPrioridade("NovaPrioridadeFachada");
		String nome = new String(prioridade.getNome());
		
		prioridade.setNome("FachadaMudar");
		fachada.alterarPrioridade(prioridade);

		assertNotEquals(nome, prioridade.getNome());
	}
	
	@Test
	public void buscarPrioridadePorId() {
		Prioridade prioridade = inserirPrioridade("NovaPrioridadeFachadaPorid");
		Prioridade pBuscadda  = fachada.buscarPrioridade(prioridade.getId());
		
		assertEquals(prioridade.getNome(), pBuscadda.getNome());
	}

	@Test
	public void buscarPrioridadePorNome() {
		Prioridade prioridade = inserirPrioridade("NovaPrioridadeFachadaPorid");
		Prioridade pBuscadda  = fachada.buscarPrioridadeNome(prioridade.getNome());
		
		assertEquals(prioridade.getNome(), pBuscadda.getNome());
	}
	
//	@Test 
//	public void inserirStatusChamado() {
//		try {
//			StatusChamado statusChamado = criarStatusChamado("TesteFachada");
//			boolean resultado = false;
//		     
//			fachada.inserirStatusChamado(statusChamado);
//		     
//			for (StatusChamado s : fachada.listarStatusChamado()) {
//				if (statusChamado == s) {
//					resultado = true;
//				}
//			}
//			assertEquals(true, resultado); 
//		} catch (FormatoInvalidoException ex) {
//			fail();
//		} catch (CampoExistenteException ex) {
//			fail();
//		} catch (CampoVazioException ex) {
//			fail();
//		}    
//	}

	
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
			fachada.inserirTipoChamado(tipoChamado);
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
			fachada.inserirStatusChamado(statusChamado);
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
			fachada.inserirUsuario(user);
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
			fachada.inserirPrioridade(prioridade);
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
			fachada.inserirChamados(chamado);
		} catch (CampoVazioException e) {
			fail();
		}
		
		return chamado;
	}
}

