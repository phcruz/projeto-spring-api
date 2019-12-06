package br.com.phcruz.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.phcruz.model.Usuario;
import br.com.phcruz.repository.UsuarioRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		List<Usuario> lista = usuarioRepository.findAll();
		
		if (lista.isEmpty()) {
			this.createUsers("Paulo H", "paulo@gmail.com", "123456");
			this.createUsers("Nonato Romeu", "romeu@hotmail.com", "654123");
			this.createUsers("Joa da Cunha", "joao@yahoo.com", "987456");
		}
	}

	public void createUsers(String name, String email, String password) {
		Usuario u = new Usuario(name, email, password);
		usuarioRepository.save(u);
	}
}
