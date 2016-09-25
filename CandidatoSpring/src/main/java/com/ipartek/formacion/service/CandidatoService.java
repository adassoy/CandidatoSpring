package com.ipartek.formacion.service;

import java.io.Serializable;
import java.util.List;

import com.ipartek.formacion.domain.Candidato;

public interface CandidatoService extends Serializable {

	public List<Candidato> getCandidatos(String tipoCampo,String valor_buscado);

	Candidato getById(long id);

	Candidato getByDni(String dni);

	boolean eliminar(long id);

	boolean crear(Candidato c);

	boolean modificar(Candidato c);

}
