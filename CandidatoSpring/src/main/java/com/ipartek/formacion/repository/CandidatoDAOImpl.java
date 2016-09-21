package com.ipartek.formacion.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.domain.Candidato;
import com.ipartek.formacion.repository.mapper.CandidatoMapper;

@Repository("CandidatoDaoImpl")
public class CandidatoDAOImpl implements CandidatoDAO {

	
	private static final long serialVersionUID = 1L;
	
	private final Log logger = LogFactory.getLog(getClass());
	
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;

	@Override
	public List<Candidato> getCandidatos() {
		ArrayList<Candidato> lista = new ArrayList<Candidato>();
		final String SQL = "SELECT id, dni, nombre FROM candidatos;";

		try {
			lista = (ArrayList<Candidato>) this.jdbctemplate.query(SQL, new CandidatoMapper());

		} catch (EmptyResultDataAccessException e) {
			this.logger.warn("No existen productos todavia " + SQL);
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}

		return lista;
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
//
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(this.dataSource);
		this.jdbcCall = new SimpleJdbcCall(this.dataSource);
	}

}
