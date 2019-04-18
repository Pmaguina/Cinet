package com.pe.cinet.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.cinet.api.model.UsuarioRequest;
import com.pe.cinet.api.repository.UsuarioRepository;

@Service
public class UsuarioDAO {

	@Autowired
	UsuarioRepository  usuarioRepository;
	
	/*crear un usuario*/
	
	public UsuarioRequest registrarUsuario(UsuarioRequest usuario) {
		return usuarioRepository.save(usuario);
	}
	
	/*buscar usuario por ID*/
	public UsuarioRequest obtenerUsuarioPorID (int id) {
		
		return usuarioRepository.findOne(id);
	}
	
	/*buscar usuario por codigoPromocional*/
	public UsuarioRequest buscarUsuarioPorCodigoPromocional (String codigoPromocional) {
		
		return usuarioRepository.buscarUsuarioPorCodigoPromocional(codigoPromocional);
	}

}
