package com.pe.cinet.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.cinet.api.model.Promocion;
import com.pe.cinet.api.repository.PromocionRepository;

@Service
public class PromocionDAO {

	@Autowired
	PromocionRepository  promocionRepository;
	
	/*registrar promocion aplicada*/
	public Promocion registrarPromocion (Promocion promocion) {
		return promocionRepository.save(promocion);
	}
	
	/*validar codigo de promocion*/
	
	public Promocion validarCodigoPromocionalUtilizado (String  codigo_promocional) {
		return promocionRepository.validarCodigoPromocionalUtilizado(codigo_promocional);
	}
	
	/*validar codigo de promocion*/
	
	public int validarCodigoPromocionalUsuario (String  codigo_promocional) {
		return promocionRepository.validarCodigoPromocionalUsuario(codigo_promocional);
	}
}
