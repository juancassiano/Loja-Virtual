package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;

public class CategoriaDAO {
	private Connection connection;
	
	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Categoria> listar(){
		try {
			List<Categoria> categorias = new ArrayList<>();
			
			String sql = "SELECT ID, NOME FROM CATEGORIA";
			
			try (PreparedStatement pstm = connection.prepareStatement(sql)){
				pstm.execute();
				
				try(ResultSet rst = pstm.getResultSet()){
					while(rst.next()) {
						Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
						
						categorias.add(categoria);
					}
				}
			}
			return categorias; 
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
}
	
	public Categoria buscarPorId(Integer id) {
		
		String sql = "SELECT ID, NOME FROM CATEGORIA WHERE id = ?";
        Categoria categoria = null;
		try (PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.setInt(1, id);
			
			try(ResultSet rst = pstm.executeQuery()){
				while(rst.next()) {
					int categoriaId = rst.getInt("id");
                    String nome = rst.getString("nome");
                    categoria = new Categoria(categoriaId, nome);
				}
			}
			return categoria;

		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
public Categoria buscarPorNome(String nome) {
		
		String sql = "SELECT ID, NOME FROM CATEGORIA WHERE nome = ?";
        Categoria categoria = null;
		try (PreparedStatement pstm = connection.prepareStatement(sql)){
			pstm.setString(1, nome);
			
			try(ResultSet rst = pstm.executeQuery()){
				while(rst.next()) {
					int categoriaId = rst.getInt("id");
                    String nomeCategoria = rst.getString("nome");
                    categoria = new Categoria(categoriaId, nomeCategoria);
				}
			}
			return categoria;

		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void salvar(Categoria categoria) {
		String sql = "INSERT INTO CATEGORIA (NOME) VALUES (?)";
		try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			pstm.setString(1, categoria.getNome());
			pstm.execute();
			
			try(ResultSet rst = pstm.getGeneratedKeys()){
				while(rst.next()) {
					categoria.setId(rst.getInt(1));
				}
		}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
