package com.rticket.negocio;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.excecao.ValidarLoginException;
import com.rticket.model.Usuario;

public class ControladorUsuarioTest {
	ControladorUsuario cUsuario;
	
	@Before
	public void setup() {
		cUsuario = new ControladorUsuario();
	}
	
	@Test
	public void inserirNovoUsuario() {
		Usuario usuario = criarUsuario("novousuario", "newuser", "123");
		try {
			cUsuario.inserirUsuario(usuario);
			boolean resultado = false;
			
			// Listar todos os usuarios que existe cadastrado e verificar se o usuario novo foi inserido. 
			Collection<Usuario> usuarios = cUsuario.listarUsuario();
			for (Usuario u : usuarios) {
				if (usuario.equals(u)) {
					resultado = true;
				}
			}
			
			assertEquals(true, resultado);
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		} catch (CampoExistenteException e) {
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		}
	}
	
	@Test
	public void inserirNovoUsuarioComNomeNulo() {
		try {
			cUsuario.inserirUsuario(criarUsuario(null, "newuser", "123"));
			fail();
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (CampoVazioException e) {
			
		} catch (CampoExistenteException e) {
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		}
	}

	@Test
	public void inserirNovoUsuarioComNomeVazio() {
		try {
			cUsuario.inserirUsuario(criarUsuario("", "newuser", "123"));
			fail();
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (CampoVazioException e) {
			
		} catch (CampoExistenteException e) {
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		}
	}
	
	@Test
	public void inserirNovoUsuarioComLoginNulo() {
		try {
			cUsuario.inserirUsuario(criarUsuario("novousuario", null, "123"));
			fail();
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (CampoVazioException e) {
			
		} catch (CampoExistenteException e) {
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		}
	}
	
	@Test
	public void inserirNovoUsuarioComLoginVazio() {
		try {
			cUsuario.inserirUsuario(criarUsuario("novousuario", "", "123"));
			fail();
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (CampoVazioException e) {
			
		} catch (CampoExistenteException e) {
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		}
	}
	
	@Test
	public void inserirNovoUsuarioComLoginInvalido() {
		try {
			cUsuario.inserirUsuario(criarUsuario("novousuario", "%$$%$%", "123"));
			fail();
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		} catch (CampoExistenteException e) {
			fail();
		} catch (FormatoInvalidoException e) {
		}
	}
	
	@Test
	public void inserirNovoUsuarioComSenhaNula() {
		try {
			cUsuario.inserirUsuario(criarUsuario("novousuario", "login", null));
			fail();
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (CampoVazioException e) {
			
		} catch (CampoExistenteException e) {
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		}
	}
	
	@Test
	public void inserirNovoUsuarioComSenhaVazia() {
		try {
			cUsuario.inserirUsuario(criarUsuario("novousuario", "login", ""));
			fail();
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (CampoVazioException e) {
			
		} catch (CampoExistenteException e) {
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		}
	}
	
	@Test
	public void inserirNovoUsuarioNulo() {
		try {
			cUsuario.inserirUsuario(null);
			fail();
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (CampoVazioException e) {
			
		} catch (CampoExistenteException e) {
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		}
	}
	
	@Test
	public void inserirUsuarioQueExite() {
		Usuario usuario = criarUsuario("usuarioA", "loginA", "123");
		try {
			cUsuario.inserirUsuario(usuario);
			boolean usuarioInserido = false;
			Collection<Usuario> usuarios = cUsuario.listarUsuario();
			for (Usuario u : usuarios) {
				if (usuario.equals(u)) {
					usuarioInserido = true;
				}
			}
			
			if (usuarioInserido) {
				cUsuario.inserirUsuario(criarUsuario("UsuarioA", "loginA", "123"));
			}
			
			fail();
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		} catch (CampoExistenteException e) {
			
		} catch (FormatoInvalidoException e) {
			fail();
		}
	}
	
	@Test
	public void buscarUsuarioPorId() {
		Usuario usuario = criarUsuario("usuarioB", "loginB", "123");
		try {
			cUsuario.inserirUsuario(usuario);
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		} catch (CampoExistenteException e) {
			
		} catch (FormatoInvalidoException e) {
			fail();
		}
		Usuario usuarioBuscado = cUsuario.buscarUsuario(1);
		
		assertEquals(true, usuarioBuscado != null);
	}
	
	@Test
	public void buscarUsuarioPorLogin() {
		Usuario usuario = criarUsuario("usuarioB", "loginB", "123");
		try {
			cUsuario.inserirUsuario(usuario);
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		} catch (CampoExistenteException e) {
			
		} catch (FormatoInvalidoException e) {
			fail();
		}
		Usuario usuarioBuscado = cUsuario.buscarUsuario(usuario.getLogin());
		
		assertEquals(true, usuarioBuscado != null);
	}
	
	@Test
	public void buscarUsuarioPorLoginQueNaoExiste() {
		Usuario usuarioBuscado = cUsuario.buscarUsuario("naoExiste");
		assertEquals(true, usuarioBuscado == null);
	}
	
	@Test
	public void alterarNomeDoUsuarioQueExiste() {
		Usuario usuario = obterUsuarioNoDB();
		String nome = new String(usuario.getNome());
		
		usuario.setNome("newNome");
		try {
			cUsuario.alterarUsuario(usuario);
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		}
		
		Usuario usuarioDb = cUsuario.buscarUsuario(usuario.getId());
		assertNotEquals(nome, usuarioDb.getNome());
	}
	
	@Test
	public void alterarUsarioSemDuplicar() {
		cadastrarUsuario("usuarioTest", "login", "123");
		
		Usuario usuario = criarUsuario("usuarioTest2", "login", "123");
//		try {
//			cUsuario.alterarUsuario(usuario);
//		} catch (NoSuchAlgorithmException e) {
//			fail();
//		} catch (FormatoInvalidoException e) {
//			fail();
//		} catch (CampoVazioException e) {
//			fail();
//		}
	}
	
	
	@Test
	public void alterarUsuarioComValorNulo() {
		try {
			cUsuario.alterarUsuario(null);
			fail();
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoVazioException e) {
			
		}
	}
	
	@Test
	public void alterarUsuarioQueNaoExiste() {
		Usuario usuario = criarUsuario("usuarioF", "loginF", "123");
		usuario.setNome("usuarioQualquer");
		try {
			cUsuario.alterarUsuario(usuario);
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (FormatoInvalidoException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		}
	}
	
	@Test
	public void alterarUsuarioComLoginInvalido() {
		Usuario usuario = criarUsuario("usuarioB", "loginB", "123");
		try {
			cUsuario.inserirUsuario(usuario);
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		} catch (CampoExistenteException e) {
			
		} catch (FormatoInvalidoException e) {
			fail();
		}
		
		Usuario usuarioBuscado = cUsuario.buscarUsuario(usuario.getLogin());
		usuarioBuscado.setLogin("$$$&&*");
		try {
			cUsuario.alterarUsuario(usuario);
		} catch (NoSuchAlgorithmException e) {
			fail("");
		} catch (FormatoInvalidoException e) {
			
		} catch (CampoVazioException e) {
			fail("Campos vazios");
		}
	}
	
	@Test
	public void alterarUsuarioComNomeNulo() {
		Usuario usuario = criarUsuario("usuarioB", "loginB", "123");
		try {
			cUsuario.inserirUsuario(usuario);
		} catch (NoSuchAlgorithmException e) {
			fail();
		} catch (CampoVazioException e) {
			fail();
		} catch (CampoExistenteException e) {
			
		} catch (FormatoInvalidoException e) {
			fail();
		}
		
		Usuario usuarioBuscado = cUsuario.buscarUsuario(usuario.getLogin());
		usuarioBuscado.setNome(null);
//		
//		
//		
//		Usuario usuario = obterUsuarioNoDB();
//		String nome = new String(usuario.getNome());
//		usuario.setNome(null);
////		

	}
	
	/**
	 * Testes para Efetuar logi
	 * 
	 * */
	 @Test
	 public void efetuarLoginComUsarioQueExiste() {
		 String login = "toinhotony";
		 String senha = "1785";
		
//		 if (!cUsuario.buscarLogin(login)) {
			 try {
				 Usuario usuario = criarUsuario("Antonio", login, senha);
				 cUsuario.inserirUsuario(usuario);
			 } catch (NoSuchAlgorithmException e) {
				 fail();
			 } catch (CampoVazioException e) {
				 fail();
			 } catch (CampoExistenteException e) {
				 
			 } catch (FormatoInvalidoException e) {
				 fail();
			 } 
//		 }
		 
		 try {
			Collection<Usuario> usuarios = cUsuario.efetuarLogin(login, senha);
			if (usuarios != null && usuarios.size() > 0) {
				Usuario usuario = (Usuario) usuarios.toArray()[0];		
				assertEquals(login, usuario.getLogin());
			} else {
				fail("Usuario não existe");
			}
		 } catch (NoSuchAlgorithmException e) {
			 fail();
		 } catch (ValidarLoginException e) {
			 fail();
		 }
	 }
	 
	 @Test
	 public void efetuarLoginComSenhaErrada() {
		 String login = "toinhotony";
		 String senha = "1785";
		 cadastrarUsuario("Antonio", login, senha);
		 
		 String senhaErrada = "12371938";
		 try {
			Collection<Usuario> usuarios = cUsuario.efetuarLogin(login, senhaErrada);
			assertEquals(false, (usuarios != null && usuarios.size() > 0));
		 } catch (NoSuchAlgorithmException e) {
			 fail();
		 } catch (ValidarLoginException e) {
			 fail();
		 }
	 }
	
	 @Test
	 public void efetuarLoginComSenhaVazia() {
		 String login = "toinhotony";
		 String senha = "1785";
		 cadastrarUsuario("Antonio", login, senha);
		 
		 try {
			Collection<Usuario> usuarios = cUsuario.efetuarLogin(login, "");
			assertEquals(false, (usuarios != null && usuarios.size() > 0));
		 } catch (NoSuchAlgorithmException e) {
			 fail();
		 } catch (ValidarLoginException e) {
			 fail();
		 }
	 }
	 
	 @Test
	 public void efetuarLoginComLoginVazio() {
		 String login = "toinhotony";
		 String senha = "1785";
		 cadastrarUsuario("Antonio", login, senha);
		 
		 try {
			Collection<Usuario> usuarios = cUsuario.efetuarLogin("", senha);
			assertEquals(false, (usuarios != null && usuarios.size() > 0));
		 } catch (NoSuchAlgorithmException e) {
			 fail();
		 } catch (ValidarLoginException e) {
			 fail();
		 }
	 }

	 @Test
	 public void efetuarLoginComLoginESenhaVazios() {
		 String login = "toinhotony";
		 String senha = "1785";
		 cadastrarUsuario("Antonio", login, senha);
		 
		 try {
			Collection<Usuario> usuarios = cUsuario.efetuarLogin("", "");
			assertEquals(false, (usuarios != null && usuarios.size() > 0));
		 } catch (NoSuchAlgorithmException e) {
			 fail();
		 } catch (ValidarLoginException e) {
			 fail();
		 }
	 }
	 
	 
	 public void cadastrarUsuario(String nome, String login, String senha) {
		 if (!cUsuario.buscarLogin(login)) {
			 try {
				 cUsuario.inserirUsuario(criarUsuario(nome, login, senha));
			 } catch (NoSuchAlgorithmException e) {
				 fail();
			 } catch (CampoVazioException e) {
				 fail();
			 } catch (CampoExistenteException e) {
				 
			 } catch (FormatoInvalidoException e) {
				 fail();
			 } 
		 } 
	 }
	 
	 private Usuario obterUsuarioNoDB() {
		Usuario usuario = criarUsuario("usuarioE", "loginE", "123");
	
		if (cUsuario.buscarLogin(usuario.getLogin())) {
			return cUsuario.buscarUsuario(usuario.getLogin());
		} else {
			try {
				cUsuario.inserirUsuario(usuario);
			} catch (NoSuchAlgorithmException e) {
				fail();
			} catch (CampoVazioException e) {
				fail();
			} catch (CampoExistenteException e) {
				fail();
			} catch (FormatoInvalidoException e) {
				fail();
			}
			return usuario;
		}
	}
	
	private Usuario criarUsuario(String nome, String login, String senha) {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		return usuario;
	}
	
}
