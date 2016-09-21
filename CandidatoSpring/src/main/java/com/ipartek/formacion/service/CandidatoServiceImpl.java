package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Candidato;
import com.ipartek.formacion.repository.CandidatoDAO;


@Service("CandidatoService")
public class CandidatoServiceImpl implements CandidatoService {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CandidatoDAO candidatoDAOImpl;
	
	private List<Candidato> candidatos;

	@Override
	public List<Candidato> getCandidatos() {
		this.candidatos = this.candidatoDAOImpl.getCandidatos();
		
		return this.candidatos;
	}

//	@Override
//	public Candidato getById(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean eliminar(long id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean crear(Candidato c) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean modificar(Candidato c) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
