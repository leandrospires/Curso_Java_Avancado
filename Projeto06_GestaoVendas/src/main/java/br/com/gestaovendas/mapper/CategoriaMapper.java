package br.com.gestaovendas.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.gestaovendas.models.Categoria;

public class CategoriaMapper implements RowMapper<Categoria>{

	@Override
	public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categoria categoria = new Categoria();
		
		categoria.setId(rs.getInt("ID"));
		categoria.setDescricao(rs.getString("DESCRICAO"));
		
		return categoria;
	}

}
