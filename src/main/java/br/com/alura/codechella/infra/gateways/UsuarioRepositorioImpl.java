package br.com.alura.codechella.infra.gateways;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.codechella.application.gateways.UsuarioRepositorio;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

public class UsuarioRepositorioImpl implements UsuarioRepositorio {
	
	private final UsuarioRepository repository;
	
	private final UsuarioEntityMapper mapper;

	public UsuarioRepositorioImpl(UsuarioRepository repository, UsuarioEntityMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Usuario cadastrarUsuario(Usuario usuario) {
		UsuarioEntity entity = mapper.toEntity(usuario);
		entity = repository.save(entity);
		return mapper.toDomain(entity);
	}

	@Override
	public Usuario alteraUsuario(String cpf, String email) {
		UsuarioEntity entity = repository.findByCpf(cpf);
		entity.setEmail(email);
		repository.save(entity);
		return mapper.toDomain(entity);
	}
	
	@Override
	public List<Usuario> listarTodos() {
		return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
	}

	@Override
	public void excluirUsuario(String cpf) {
		UsuarioEntity entity = repository.findByCpf(cpf);
		repository.deleteById(entity.getId());
	}

}
