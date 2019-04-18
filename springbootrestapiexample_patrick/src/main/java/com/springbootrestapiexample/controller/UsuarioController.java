package com.springbootrestapiexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestapiexample.model.Usuario;
import com.springbootrestapiexample.model.dao.UsuarioDAO;

@RestController
@RequestMapping("/cinet")
public class UsuarioController {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	/*crear un usuario*/
	
	@PostMapping("/usuario")
	public Usuario crearUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioDAO.crearUsuario(usuario);
	}
	
	/*buscar todos los usuario*/
	
	@GetMapping("/usuario")
	public List<Usuario> buscarTodos() {
		return usuarioDAO.buscarTodos();
	}
	
	/*buscar un usuario*/
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> buscarUsuarioPorID(@PathVariable(value="id") Long id){
		
		Usuario usu = usuarioDAO.buscarUno(id);
		if (usu ==null) {
			return ResponseEntity.notFound().build();
			
		}	
		return ResponseEntity.ok().body(usu);
	}
		
	/*actualizar un usuario*/
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> actualizarUsuarioPorID(@PathVariable(value="id") Long id,@Valid @RequestBody Usuario usuario){
		Usuario usu = usuarioDAO.buscarUno(id);
		
		if (usu ==null) {
			return ResponseEntity.notFound().build();
			
		}	
		usu.setNum_Cel(usuario.getNum_Cel());
		
		Usuario actualizarUsu = usuarioDAO.crearUsuario(usu);
		
		return ResponseEntity.ok().body(actualizarUsu);
	}
	
	/*Eliminar un usuario*/
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<Usuario> eliminarUsuario(@PathVariable(value="id") Long id){
		
		Usuario usu = usuarioDAO.buscarUno(id);
		if (usu ==null) {
			return ResponseEntity.notFound().build();
			
		}	
		
		usuarioDAO.eliminarUsuario(usu);
		
		return ResponseEntity.ok().build();
	}
}
