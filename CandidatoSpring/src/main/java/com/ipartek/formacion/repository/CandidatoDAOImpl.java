package com.ipartek.formacion.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.domain.Candidato;
import com.ipartek.formacion.repository.mapper.CandidatoMapper;
import com.mysql.jdbc.Statement;

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

	@Override
	public Candidato getById(long id) {
		Candidato c = null;

		final String SQL = "SELECT id, dni, nombre FROM candidatos WHERE id=" + id;
		try {
			c = this.jdbctemplate.queryForObject(SQL, new CandidatoMapper());
		} catch (EmptyResultDataAccessException e) {
			this.logger.warn("No existen candidatos con ID=" + id);
			c = null;
		} catch (Exception e) {
			this.logger.error(e.getMessage());
			c = null;
		}
		return c;
	}

	@Override
	public boolean eliminar(long id) {
		boolean resul = false;

		final String SQL = "DELETE FROM `candidatos` WHERE  `id`=" + id;

		if (1 == this.jdbctemplate.update(SQL)) {
			resul = true;
		}

		return resul;
	}

	@Override
	public boolean crear(final Candidato c) {
		boolean resul = false;
		int affectedRows = -1;
		KeyHolder keyHolder = new GeneratedKeyHolder();

		final String sqlInsert = "INSERT INTO `candidatos` (  `dni`, `nombre`) VALUES ( ? , ?  );";
		affectedRows = this.jdbctemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				final PreparedStatement ps = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, c.getDni());
				ps.setString(2, c.getNombre());
				return ps;
			}
		}, keyHolder);

		if (affectedRows == 1) {
			resul = true;
			c.setId(keyHolder.getKey().longValue());
		}

		return resul;
	}

	@Override
	public boolean modificar(Candidato c) {
		final String SQL = "UPDATE `candidatos` SET `dni`=? , `nombre`=? WHERE  `id`=?;";
		Object[] arguments = { c.getDni(), c.getNombre(), c.getId() };
		int affectedRows = this.jdbctemplate.update(SQL, arguments);
		return (affectedRows == 1) ? true : false;
	}

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(this.dataSource);
		this.jdbcCall = new SimpleJdbcCall(this.dataSource);
	}

}
