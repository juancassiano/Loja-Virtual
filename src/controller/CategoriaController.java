package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO;
import jdbc.ConnectionFactory;
import modelo.Categoria;

public class CategoriaController {

	private CategoriaDAO categoriaDAO;
	
	public CategoriaController() throws SQLException {
		Connection connection = new ConnectionFactory().criarConexao();
		this.categoriaDAO = new CategoriaDAO(connection);
	}
	
	public List<Categoria> listar(){
		return this.categoriaDAO.listar();
	}
	
	public Categoria buscarPorId(Integer id) {
		return this.categoriaDAO.buscarPorId(id);
	}
	
	public Integer buscarPorNome(String nome) {
		return this.categoriaDAO.buscarPorNome(nome);
	}
	
	public void salvar(Categoria categoria) {
		this.categoriaDAO.salvar(categoria);
	}
}
