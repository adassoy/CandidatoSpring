package com.ipartek.formacion.repository;

import java.io.Serializable;
import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Candidato;

public interface CandidatoDAO extends Serializable {

	public List<Candidato> getCandidatos();

	Candidato getById(long id);

	boolean eliminar(long id);

	boolean crear(Candidato c);

	boolean modificar(Candidato c);

	void setDataSource(DataSource dataSource);

	// Candidato getByDni(String dni);

}
