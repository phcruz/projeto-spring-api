package br.com.phcruz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.phcruz.exception.DataException;
import br.com.phcruz.model.Usuario;
import br.com.phcruz.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}
	
	public Usuario buscar(Long id) {
		if (id == null) {
			throw new DataException("É necessário informar o id do usuário.");
		}
		
		Optional<Usuario> op = usuarioRepository.findById(id);
		if (!op.isPresent()) {
			throw new DataException("Nenhum usuário encontrado.");
		}
		return op.get();
	}
	
	public Usuario salvar(Usuario usuario) {
		if(usuario.getId() != null) {
			Optional<Usuario> op = usuarioRepository.findById(usuario.getId());
			
			if (op.isPresent()) {
				throw new DataException("O usuário já existe.");
			}
		}
		return usuarioRepository.save(usuario);
	}
	
	public Usuario atualizar(Usuario usuario) {
		verificarExistencia(usuario);
		return usuarioRepository.save(usuario);
	}
	
	public void verificarExistencia(Usuario usuario) {
		buscar(usuario.getId());
	}
	
	public void deletar(Long id) throws DataException {
		try {
			usuarioRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new DataException("Usuario não encontrado.");
		}
	}
	
}
