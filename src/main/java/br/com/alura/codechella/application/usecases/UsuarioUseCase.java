package br.com.alura.codechella.application.usecases;

import java.util.List;

import br.com.alura.codechella.application.gateways.UsuarioRepositorio;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class UsuarioUseCase {
	
	private final UsuarioRepositorio repositorio;

    public UsuarioUseCase(UsuarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    /* Metodos */
    
    public Usuario cadastrarUsuario(Usuario usuario) {
        return repositorio.cadastrarUsuario(usuario);
    }
    
    public Usuario alteraDadosUsuario(Usuario usuario) {
        return repositorio.alteraUsuario(usuario.getCpf(), usuario.getEmail());
    }
    
    public List<Usuario> listarTodos(){
    	return repositorio.listarTodos();
    }

	public void excluirUsuario(String cpf) {
		repositorio.excluirUsuario(cpf);
	}

}
