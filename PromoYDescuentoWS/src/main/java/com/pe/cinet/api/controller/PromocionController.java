package com.pe.cinet.api.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.cinet.api.dao.DescuentoDAO;
import com.pe.cinet.api.dao.PromocionDAO;
import com.pe.cinet.api.model.Descuento;
import com.pe.cinet.api.model.Promocion;
import com.pe.cinet.api.model.PromocionResponse;


@RestController
@RequestMapping("/cinet")
public class PromocionController {

	@Autowired
	PromocionDAO promocionDAO;
	
	@Autowired
	DescuentoDAO descuentoDAO;
	
	/*validar codigo Promocional*/
	@GetMapping("/promocion/validarCodigoPromocional/{codigo_promocional}")
	public PromocionResponse validarCodigoPromocional (@PathVariable(value="codigo_promocional") String codigo_promocional) {
		PromocionResponse promocionResponse = new PromocionResponse();
		
		int codigopromocional = promocionDAO.validarCodigoPromocionalUsuario(codigo_promocional);
		
		if(codigopromocional>0) {
			
			Promocion promo = promocionDAO.validarCodigoPromocionalUtilizado(codigo_promocional);
			
			if(promo == null) {
				promocionResponse.setCodigoRespuesta(0);
				promocionResponse.setDescripcionRespuesta("Cupón válido");
				promocionResponse.setCodigoPromocional(codigo_promocional);
				promocionResponse.setDescuento(20.0);
			}else {
				promocionResponse.setCodigoRespuesta(-2);
				promocionResponse.setDescripcionRespuesta("El cupó ya fue utilizado");
			}
			
		}else {
			promocionResponse.setCodigoRespuesta(-1);
			promocionResponse.setDescripcionRespuesta("El cupón no es válido");
		}
		
		return promocionResponse;
	}
	
	/*aplicar bonos a usuarios*/
	@PostMapping("/promocion/aplicarBono")
	public PromocionResponse aplicarBono(@Valid @RequestBody Promocion promocionRequest) {
		
		PromocionResponse promocionResponse = new PromocionResponse();
		
		try {
			
			Promocion promocion = new Promocion();
			
			int id_usu_output = promocionDAO.validarCodigoPromocionalUsuario(promocionRequest.getCodigo_promocional());
			
			promocion.setId_usu_input(promocionRequest.getId_usu_input());
			promocion.setId_usu_output(id_usu_output);
			promocion.setCodigo_promocional(promocionRequest.getCodigo_promocional());
			
			promocionDAO.registrarPromocion(promocion);
				
			Descuento descuento = new Descuento();
			
			descuento.setId_usu(id_usu_output);
			
			/*Monto de descuento por defecto*/
			descuento.setMonto(10.0);
			descuento.setEstado("ACTIVO");
	        descuento.setFecha_vencimiento(calcularFechaVencimiento(30));
	         
			descuentoDAO.registrarDescuento(descuento);
			
			promocionResponse.setCodigoRespuesta(0);
			promocionResponse.setDescripcionRespuesta("Transaccion OK, se grabó la promo");
			promocionResponse.setCodigoPromocional(promocionRequest.getCodigo_promocional());
			promocionResponse.setDescuento(10.0);
		
		}catch(Exception e) {
			promocionResponse.setCodigoRespuesta(-3);
			promocionResponse.setDescripcionRespuesta("Error al registrar la promo, intentelo nuevamente");
			promocionResponse.setCodigoPromocional(promocionRequest.getCodigo_promocional());
		}
		
		return promocionResponse;
	}
	
	public String calcularFechaVencimiento(int dias) {
		Date fecha = Calendar.getInstance().getTime();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, 30);
        
		fecha = calendar.getTime();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String strDate = dateFormat.format(fecha); 
        
        return strDate;
	}
}
