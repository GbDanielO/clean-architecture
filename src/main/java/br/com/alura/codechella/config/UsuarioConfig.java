package br.com.alura.codechella.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.alura.codechella.application.gateways.UsuarioRepositorio;
import br.com.alura.codechella.application.usecases.UsuarioUseCase;
import br.com.alura.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.infra.gateways.UsuarioRepositorioImpl;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

@Configuration
public class UsuarioConfig {

	@Bean
	UsuarioUseCase criarUsuarioUseCase(UsuarioRepositorio repositorio) {
		return new UsuarioUseCase(repositorio);
	}
	
	@Bean
	UsuarioRepositorio criarUsuarioRepositorio(UsuarioRepository repository, UsuarioEntityMapper mapper) {
		return new UsuarioRepositorioImpl(repository, mapper);
	}
	
	@Bean 
	UsuarioEntityMapper criarUsuarioEntityMapper() {
		return new UsuarioEntityMapper();
	}
}
