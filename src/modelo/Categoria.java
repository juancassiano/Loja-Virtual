package modelo;

public class Categoria {

	private Integer id;
	private String nome;
	
	public Categoria() {
		
	}
	
	public Categoria( String nome) {
		this.nome = nome;
	}

	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String toString() {
		return this.nome;
	}

}
