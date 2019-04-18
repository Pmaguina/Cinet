package com.pe.cinet.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.cinet.api.dao.UsuarioDAO;
import com.pe.cinet.api.model.UsuarioRequest;
import com.pe.cinet.api.model.UsuarioResponse;

@RestController
@RequestMapping("/cinet")
public class UsuarioController {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	/*registro de usuario*/
	@PostMapping("/usuario/registrar")
	public UsuarioResponse crearUsuario (@Valid @RequestBody UsuarioRequest usuario) {
		
		UsuarioResponse response = new UsuarioResponse();
		
		UsuarioRequest usuarioRequest=usuarioDAO.buscarUsuarioPorCodigoPromocional(usuario.getCodigo_promocional());
		
		if(usuarioRequest!=null) {
			
			if(usuario.getCorreo().equals(usuarioRequest.getCorreo())) {
				
				response.setCodigoRespuesta(-1);
				response.setDescripcionRespuesta("El correo ya se encuentra registrado");
				
			}else if (usuario.getNum_Doc().equals(usuarioRequest.getNum_Doc())) {
				response.setCodigoRespuesta(-2);
				response.setDescripcionRespuesta("El documento de identidad ya se encuentra registrado");
				
			}else if (usuario.getNum_Cel().equals(usuarioRequest.getNum_Cel())) {
				response.setCodigoRespuesta(-3);
				response.setDescripcionRespuesta("El número de telefono ya se encuentra registrado");
			}else {
				
				usuarioDAO.registrarUsuario(usuario);
				
				response.setCodigoRespuesta(0);
				response.setDescripcionRespuesta("Transacción OK");
			}
		}else {
			usuarioDAO.registrarUsuario(usuario);
			
			response.setCodigoRespuesta(0);
			response.setDescripcionRespuesta("Transacción OK");
		}
		
		
		return response;
	}
	
	/*buscar por codigo promocional*/
	@GetMapping("/usuario/buscar/{codigo_promocional}")
	public ResponseEntity<UsuarioRequest> buscarUsuarioPorCodigoPromocional(@PathVariable(value="codigo_promocional") String codigo_promocional){
		
		UsuarioRequest usu = usuarioDAO.buscarUsuarioPorCodigoPromocional(codigo_promocional);
		
		if (usu ==null) {
			return ResponseEntity.notFound().build();
			
		}	
		return ResponseEntity.ok().body(usu);
	}
		
	/*actualizar cine creditos del usuario*/
	@PutMapping("/usuario/actualizarCredito/{codigo_promocional}")
	public ResponseEntity<UsuarioRequest> actualizarCredito(@PathVariable(value="codigo_promocional") String codigo_promocional,@Valid @RequestBody UsuarioRequest usuario){
		
		UsuarioRequest usuDao = usuarioDAO.buscarUsuarioPorCodigoPromocional(codigo_promocional);
		
		if (usuDao ==null) {
			return ResponseEntity.notFound().build();
			
		}	
		
		usuDao.setCinet_creditos(usuario.getCinet_creditos());
		
		UsuarioRequest actualizarUsu = usuarioDAO.registrarUsuario(usuDao);
		
		return ResponseEntity.ok().body(actualizarUsu);
	}
	
}
