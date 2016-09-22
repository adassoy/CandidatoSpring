package com.ipartek.formacion.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class Candidato implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	@NotNull
	private String dni;
	@NotNull
	private String nombre;

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

	// toString
	@Override
	public String toString() {
		return "Candidato [id=" + id + ", dni=" + dni + ", nombre=" + nombre + "]";
	}

}
