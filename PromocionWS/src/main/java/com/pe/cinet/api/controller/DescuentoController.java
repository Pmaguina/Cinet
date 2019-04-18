package com.pe.cinet.api.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.cinet.api.dao.DescuentoDAO;
import com.pe.cinet.api.model.Descuento;
import com.pe.cinet.api.model.DescuentoResponse;

@RestController
@RequestMapping("/cinet")
public class DescuentoController {

	@Autowired
	DescuentoDAO descuentoDAO;
	
	@GetMapping("/descuento/consultarBonos/{id}")
	public DescuentoResponse consultarBonos(@PathVariable(value="id") int id) {
		
		DescuentoResponse descuento = new DescuentoResponse();
		
		List<Descuento> listaDescuento= null;
		
		listaDescuento = descuentoDAO.consultarBonos(id);
		
		if(listaDescuento.size()>0) {
			
			Date date = Calendar.getInstance().getTime();  
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
			String strDate = dateFormat.format(date);  
			
//			descuentoDAO.actualizarEstadoBono(id, "VENCIDO", strDate);
			
			
			descuento.setId_usu(id);
			descuento.setCodigoRespuesta(0);
			descuento.setDescripcionRespuesta("Consulta exitosa");
			
			descuento.setListaDescuento(listaDescuento);
			
			double montoTotal = 0.0;
			
			
			for (int i = 0; i < listaDescuento.size(); i++) {
				
				montoTotal = listaDescuento.get(i).getMonto()+montoTotal;
			
			}
			
			descuento.setMontoTotal(montoTotal);
			
		}else {
			descuento.setCodigoRespuesta(-1);
			descuento.setDescripcionRespuesta("No existe información");
		}
		
		return descuento;
	}
}
