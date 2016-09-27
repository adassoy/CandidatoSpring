package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Candidato;

public class CandidatoMapper implements RowMapper<Candidato> {

	public Candidato mapRow(ResultSet rs, int rowNum) throws SQLException {
		Candidato c = new Candidato();
		c.setId(rs.getLong("id"));
		c.setDni(rs.getString("dni"));
		c.setNombre(rs.getString("nombre"));
		c.setFecha_alta(rs.getDate("fecha_alta"));
		c.setFecha_modificacion(rs.getDate("fecha_modificacion"));

		return c;

	}

}
