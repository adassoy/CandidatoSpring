package com.ipartek.formacion.repository;

import java.io.Serializable;
import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Candidato;

public interface CandidatoDAO extends Serializable {

	public List<Candidato> getCandidatos(String tipoCampo,String valor_buscado);

	Candidato getById(long id);

	Candidato getByDni(String dni);

	boolean eliminar(long id);

	boolean crear(Candidato c);

	boolean modificar(Candidato c);

	void setDataSource(DataSource dataSource);

}
