package com.ipartek.formacion.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Candidato;
import com.ipartek.formacion.repository.CandidatoDAO;

@Service("CandidatoService")
public class CandidatoServiceImpl implements CandidatoService {

	private static final long serialVersionUID = 1L;

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private CandidatoDAO candidatoDAOImpl;

	private List<Candidato> candidatos;

	@Override
	public List<Candidato> getCandidatos(String tipoCampo, String valor_buscado) {
		logger.trace("listando candidatos");
		this.candidatos = this.candidatoDAOImpl.getCandidatos(tipoCampo, valor_buscado);

		return this.candidatos;

	}

	@Override
	public Candidato getById(long id) {
		return this.candidatoDAOImpl.getById(id);

	}

	@Override
	public Candidato getByDni(String dni) {
		return this.candidatoDAOImpl.getByDni(dni);
	}

	@Override
	public boolean eliminar(long id) {
		return this.candidatoDAOImpl.eliminar(id);
	}

	@Override
	public boolean crear(Candidato c) {
		return this.candidatoDAOImpl.crear(c);
	}

	@Override
	public boolean modificar(Candidato c) {
		return this.candidatoDAOImpl.modificar(c);
	}

}
