package com.springbootrestapiexample.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Usuario")
@EntityListeners(AuditingEntityListener.class)

public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id ;
	@NotBlank
	private String nombre;
	@NotBlank
	private String ape_Paterno;
	@NotBlank
	private String ape_Materno;
	@NotBlank
	private String correo;
	@NotBlank
	private String contrasena;
	
	private int tipo_Doc;
	@NotBlank
	private String num_Doc;
	@NotBlank
	private String fec_Nac;
	@NotBlank
	private String num_Cel;
	@NotBlank
	private String departamento;
	@NotBlank
	private String provincia;
	@NotBlank
	private String distrito;
	
	private String cine_Favorito;
	
	@NotBlank
	private String genero;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String codigo_promocional;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe_Paterno() {
		return ape_Paterno;
	}

	public void setApe_Paterno(String ape_Paterno) {
		this.ape_Paterno = ape_Paterno;
	}

	public String getApe_Materno() {
		return ape_Materno;
	}

	public void setApe_Materno(String ape_Materno) {
		this.ape_Materno = ape_Materno;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getTipo_Doc() {
		return tipo_Doc;
	}

	public void setTipo_Doc(int tipo_Doc) {
		this.tipo_Doc = tipo_Doc;
	}

	public String getNum_Doc() {
		return num_Doc;
	}

	public void setNum_Doc(String num_Doc) {
		this.num_Doc = num_Doc;
	}

	public String getFec_Nac() {
		return fec_Nac;
	}

	public void setFec_Nac(String fec_Nac) {
		this.fec_Nac = fec_Nac;
	}

	public String getNum_Cel() {
		return num_Cel;
	}

	public void setNum_Cel(String num_Cel) {
		this.num_Cel = num_Cel;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getCine_Favorito() {
		return cine_Favorito;
	}

	public void setCine_Favorito(String cine_Favorito) {
		this.cine_Favorito = cine_Favorito;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCodigo_promocional() {
		return codigo_promocional;
	}

	public void setCodigo_promocional(String codigo_promocional) {
		this.codigo_promocional = codigo_promocional;
	}

	
}
