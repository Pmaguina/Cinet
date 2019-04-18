package com.pe.cinet.api.model;

import java.util.List;

public class DescuentoResponse {

	private int codigoRespuesta;
	private String descripcionRespuesta;
	private int id_usu;
	private List<Descuento> listaDescuento;
	private double montoTotal;
	
	public int getId_usu() {
		return id_usu;
	}
	public void setId_usu(int id_usu) {
		this.id_usu = id_usu;
	}
	public List<Descuento> getListaDescuento() {
		return listaDescuento;
	}
	public void setListaDescuento(List<Descuento> listaDescuento) {
		this.listaDescuento = listaDescuento;
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
	public double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
}
