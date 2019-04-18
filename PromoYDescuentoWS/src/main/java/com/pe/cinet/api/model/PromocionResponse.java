package com.pe.cinet.api.model;

import java.io.Serializable;

public class PromocionResponse implements Serializable {

	private int codigoRespuesta;
	private String descripcionRespuesta;
	private String codigoPromocional;
	private double descuento;
	
	private static final long serialVersionUID = 1L;

	public int getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(int codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getDescripcionRespuesta() {
		return descripcionRespuesta;
	}

	public void setDescripcionRespuesta(String descripcionRespuesta) {
		this.descripcionRespuesta = descripcionRespuesta;
	}

	public String getCodigoPromocional() {
		return codigoPromocional;
	}

	public void setCodigoPromocional(String codigoPromocional) {
		this.codigoPromocional = codigoPromocional;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
}
