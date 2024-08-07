package br.com.alura.codechella.infra.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.codechella.application.usecases.UsuarioUseCase;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

	private UsuarioUseCase usuarioUseCase;

	public UsuarioController(UsuarioUseCase usuarioUseCase) {
		this.usuarioUseCase = usuarioUseCase;
	}
	
	/**
	 * No mundo ideal aqui seria passado um UsuarioDTO,
	 * podendo ser criado como um "record".
	 * Mas decidi passar o objeto do próprio dominio.
	 */
	@PostMapping
	public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
		//Se houvesse um UsuarioDTO teria que ter todo o parcer do objeto indo e voltando
		return usuarioUseCase.cadastrarUsuario(usuario);
	}
	
	@PutMapping
	public Usuario atualizarEmail(@RequestBody String cpf, @RequestBody String email) {
		return usuarioUseCase.alteraDadosUsuario(new Usuario(cpf, email));
	}
	
	@GetMapping
	public List<Usuario> buscarTodos(){
		return usuarioUseCase.listarTodos();
	}
	
	@DeleteMapping("/{cpf}")
	public void excluirUsuario(@PathVariable String cpf) {
		usuarioUseCase.excluirUsuario(cpf);
	}
}
