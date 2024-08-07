package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;

public class UsuarioEntityMapper {

	public UsuarioEntity toEntity(Usuario usuario){
        return new UsuarioEntity(usuario.getId(), usuario.getCpf(), usuario.getNome(),
        		usuario.getNascimento(), usuario.getEmail());
    }
    
    public Usuario toDomain(UsuarioEntity entity){
    	if(entity.getId() != null) {
    		return new Usuario(entity.getId(), entity.getCpf(), entity.getNome(),
        		entity.getNascimento(), entity.getEmail());
    	}
    	return new Usuario(entity.getCpf(), entity.getNome(),
        		entity.getNascimento(), entity.getEmail());
    }
    
}
