package br.com.gestaovendas.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.gestaovendas.models.Cliente;

public class ClienteMapper implements RowMapper<Cliente>{

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente cli = new Cliente();
		
		cli.setDocumento(rs.getString("documento"));
		cli.setNome(rs.getString("nome"));
		cli.setEmail(rs.getString("email"));
		cli.setTelefone(rs.getString("telefone"));
		
		return cli;
	}
	
	
	

}
