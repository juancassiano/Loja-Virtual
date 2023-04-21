package modelo;

import java.math.BigDecimal;


public class Produto {

	private Integer id;
	private String nome;
	private String descricao;	 
	private BigDecimal preco;
	private Categoria categoria;
	
	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.setPreco(preco);
		this.categoria = categoria;
	}
	
	public Produto(String nome, String descricao, BigDecimal preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.setPreco(preco);
	}
	
	
	public Produto(Integer id, String nome, String descricao, BigDecimal preco, Categoria categoria) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.setPreco(preco);
		this.categoria = categoria;
	}

	public Produto(Integer id, String nome, String descricao, BigDecimal preco) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.setPreco(preco);
	}
	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	@Override
	public String toString() {
		return String.format("O produto de id %d é:  %s, %s, custa %.2f", 
				this.id, this.nome, this.descricao, this.preco);
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
