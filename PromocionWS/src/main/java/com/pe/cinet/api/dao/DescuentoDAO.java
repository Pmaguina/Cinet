package com.pe.cinet.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.cinet.api.model.Descuento;
import com.pe.cinet.api.repository.DescuentoRepository;

@Service
public class DescuentoDAO {

	@Autowired
	DescuentoRepository  descuentoRepository;
	
	/*registrar promocion aplicada*/
	public Descuento registrarDescuento (Descuento descuento) {
		return descuentoRepository.save(descuento);
	}
	
	/*listar bonos*/
	
	public List<Descuento> consultarBonos(int id){
		return descuentoRepository.consultarBonos(id);
	}
	
	/*actualiza estado bonos*/
	public void actualizarEstadoBono(int id_usu, String estado, String fecha_vencimiento) {
		descuentoRepository.actualizaEstadoBono(id_usu, estado, fecha_vencimiento);
	}
	
}
