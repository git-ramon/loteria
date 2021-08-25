package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.UsuarioDAO;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.model.Usuario;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Path("cadastrar")
@Controller
public class CadastrarController {
	
	@Inject EntityManager em;
	@Inject Result result;
	@Inject UsuarioDAO usuarioDao;
	@Inject Validator validador;
	
	@Get("")
	public void cadastrar() {
		
	}
	
	@IncludeParameters
	@Post("salvausuario")
	public void salvaUsuario (@NotNull @Valid Usuario usuario, String ConfirmaSenha) {
		
		//Validar Senha
		boolean SenhaIgual = ConfirmaSenha.equals(usuario.getSenha());
		validador.addIf(!SenhaIgual, new SimpleMessage("ConfirmaSenha", "A Confirmação de senha Difere da Senha cadastrada"));
		validador.onErrorRedirectTo(this).cadastrar();
		
		//Validar Usuario
		validador.onErrorRedirectTo(this).cadastrar();
		
		//Salvar Usuario no Banco
		
		usuarioDao.insertOrUpdate(usuario);
		
		// Direcionar para a Home
		result.redirectTo(HomeController.class).home();
		
	}

}
