package com.springbootrestapiexample.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrestapiexample.model.Usuario;
import com.springbootrestapiexample.repository.UsuarioRepository;

@Service
public class UsuarioDAO {

	@Autowired
	UsuarioRepository  usuarioRepository;
	
	/*crear un usuario*/
	
	public Usuario crearUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	/*buscar todos los usuario*/
	public List<Usuario> buscarTodos(){
		return usuarioRepository.findAll();
	}
	
	/*buscar un usuario*/
	public Usuario buscarUno (Long id) {
		return usuarioRepository.findOne(id);
	}
	
	
	/*borrar un usuario*/
	public void eliminarUsuario (Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
}
