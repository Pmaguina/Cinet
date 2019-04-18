package com.pe.cinet.api.model;

import java.io.Serializable;

public class UsuarioResponse implements Serializable {

	private int codigoRespuesta;
	private String descripcionRespuesta;
	
	private static final long serialVersionUID = 1L;
	
	public UsuarioResponse() {
		super();
	}
	
	public UsuarioResponse(int codigoRespuesta, String descripcionRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
		this.descripcionRespuesta = descripcionRespuesta;
	}

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

}
