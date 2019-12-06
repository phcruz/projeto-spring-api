package br.com.phcruz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.phcruz.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
