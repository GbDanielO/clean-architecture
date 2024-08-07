package br.com.alura.codechella.application.gateways;

import java.util.List;

import br.com.alura.codechella.domain.entities.usuario.Usuario;

public interface UsuarioRepositorio {
	
	Usuario cadastrarUsuario(Usuario usuario);
	
	Usuario alteraUsuario(String cpf, String email);

    List<Usuario> listarTodos();

	void excluirUsuario(String cpf);

}
