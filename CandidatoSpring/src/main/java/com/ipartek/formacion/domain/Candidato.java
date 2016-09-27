package com.ipartek.formacion.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.ipartek.formacion.validator.Nif;

public class Candidato implements Serializable {

	public java.util.Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(java.util.Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public java.util.Date getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(java.util.Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public java.util.Date getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(java.util.Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	private static final long serialVersionUID = 1L;

	private long id;

	@NotNull
	@Nif
	private String dni;
	@NotEmpty
	@Size(min = 2, max = 50)
	private String nombre;

	java.util.Date fecha_alta;
	java.util.Date fecha_modificacion;
	java.util.Date fecha_baja;

	// java.util.Date fecha_alta = new java.util.Date();
	// java.util.Date fecha_modificacion = new java.util.Date();
	// java.util.Date fecha_baja = new java.util.Date();

	public Candidato() {
		super();
		this.id = 0;
		this.dni = "";
		this.nombre = "";
	}

	// get set
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// es un candidato nuevo?
	public boolean isNew() {
		return (this.id == 0) ? true : false;
	}

	@Override
	public String toString() {
		return "Candidato [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", fecha_alta=" + fecha_alta
				+ ", fecha_modificacion=" + fecha_modificacion + ", fecha_baja=" + fecha_baja + "]";
	}

	// toString

}
