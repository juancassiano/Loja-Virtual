package controller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

import dao.ProdutoDAO;
import jdbc.ConnectionFactory;
import modelo.Categoria;
import modelo.Produto;

public class ProdutoController {
	private ProdutoDAO produtoDAO;
	
	public ProdutoController() {
		Connection connection = new ConnectionFactory().criarConexao();
		this.produtoDAO = new ProdutoDAO(connection);
	}
	
	public void salvar(Produto produto) {
		this.produtoDAO.salvar(produto);
	}
	
		public List<Produto> listar(){
			return this.produtoDAO.listar();
		}
		
	public void deletar(Integer id) {
		this.produtoDAO.deletarPorId(id);
	}
	
	public void alterar(String nome, String descricao, BigDecimal preco, Integer id) {
		this.produtoDAO.alterar(nome, descricao, preco, id);
	}
	
	public List<Produto> buscarProduto(Categoria categoria) {
		return this.produtoDAO.buscar(categoria);
		
	}
	
	

}
