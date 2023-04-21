package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.Produto;



public class ProdutoDAO {

	private Connection connection;
	
	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Produto produto) {

		
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO, PRECO) VALUES (?,?,?)";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getDescricao());
			pstm.setBigDecimal(3, produto.getPreco());
//			pstm.setInt(4, produto.getCategoria().getId());
			
			pstm.execute();
			
			try(ResultSet rst = pstm.getGeneratedKeys()){
				while(rst.next()) {
					produto.setId(rst.getInt(1));
				}
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Produto> listar(){
		List<Produto> produtos = new ArrayList<>();
		
		String sql = "SELECT ID, NOME, DESCRICAO, PRECO, CATEGORIA_ID FROM PRODUTO";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql)){
			
			try(ResultSet rst = pstm.getResultSet()){
				pstm.execute();
				
				resultSetEmProduto(produtos, pstm);
			}
			return produtos;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void salvarComCategoria(Produto produto) {
		try {
			String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO, PRECO, CATEGORIA_ID) VALUES (?,?,?,?)";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				pstm.setString(1, produto.getNome());
				pstm.setString(2, produto.getDescricao());
				pstm.setBigDecimal(3, produto.getPreco());
				pstm.setInt(4, produto.getCategoria().getId());
				
				pstm.execute();
				
				try(ResultSet rst = pstm.getGeneratedKeys()){
					while(rst.next()) {
						produto.setId(rst.getInt(1));
					}
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public List<Produto> buscar(Categoria ct){
		List<Produto> produtos = new ArrayList<>();
		try {
		
			String sql = "SELECT ID, NOME, DESCRICAO, PRECO, CATEGORIA_ID FROM PRODUTO WHERE CATEGORIA_ID = ?";
			
			try(PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.setInt(1,ct.getId());
				pstm.execute();
				
				resultSetEmProduto(produtos, pstm);
			}
			return produtos;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public void deletarPorId(Integer id){
		try (PreparedStatement pstm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?")){
			pstm.setInt(1, id);
			pstm.execute();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(String nome, String descricao, BigDecimal preco, Integer id){
		try(PreparedStatement pstm = connection.prepareStatement("UPDATE PRODUTO P SET P.NOME = ?, P.DESCRICAO = ?, P.PRECO = ? WHERE ID = ?"
)){
			pstm.setString(1, nome);
			pstm.setString(2, descricao);
			pstm.setBigDecimal(3, preco);
			pstm.setInt(4, id);
			pstm.execute();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void resultSetEmProduto(List<Produto> produtos, PreparedStatement pstm) throws SQLException{
		try(ResultSet rst = pstm.getResultSet()){
			while(rst.next()) {
				Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getBigDecimal(4));
				
				produtos.add(produto);
			}	
		}
	}
}


