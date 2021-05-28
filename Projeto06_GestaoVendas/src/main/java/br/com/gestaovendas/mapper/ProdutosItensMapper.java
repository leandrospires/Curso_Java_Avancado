package br.com.gestaovendas.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.gestaovendas.viewmodels.ProdutosItensVM;

public class ProdutosItensMapper implements RowMapper<ProdutosItensVM>{

	@Override
	public ProdutosItensVM mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProdutosItensVM pi = new ProdutosItensVM();
		
		pi.setIdItens(rs.getInt("idItens"));
		pi.setIdPedido(rs.getInt("idPedido"));
		pi.setDescricao(rs.getString("descricao"));
		pi.setPrecoUnitario(rs.getDouble("precoUnitario"));
		pi.setQuantidade(rs.getDouble("quantidade"));
		pi.setValorTotal(rs.getDouble("valorTotal"));
		
		return pi;
	}

}
