import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import controller.CategoriaController;
import controller.ProdutoController;
import modelo.Categoria;
import modelo.Produto;

public class ProdutoMain {

	public static void main(String[] args) throws SQLException {
		CategoriaController categoriaController = new CategoriaController();
		ProdutoController produtoController = new ProdutoController();
		try(Scanner scan = new Scanner(System.in)){;
		
			System.out.println("Digite 1 para listar Produtos | 2 para Cadastrar Produto | 3 para alterar Produto |"
					+ "4 para deletar Produto | 5 para Listar Categorias | 6 para criar Categoria");
			int entrada = scan.nextInt();
			String nome;
			String descricao;
			BigDecimal preco;
			String nomeCategoria;
			Categoria categoria = new Categoria();
			int id;
			
			switch (entrada) {
			case 1: 
				System.out.println(produtoController.listar());
				break;
			
			case 2:
				scan.nextLine();
				System.out.println("Digite o nome do produto:");
				nome = scan.nextLine();
				System.out.println("Digite o preço do produto:");
				preco = scan.nextBigDecimal();
				scan.nextLine();
				System.out.println("Digite a descrição do produto:");
				descricao = scan.nextLine();
				System.out.println("Digite o nome da categoria");
				nomeCategoria = scan.nextLine();

				categoria = new Categoria(nomeCategoria);
				categoriaController.buscarPorNome(nomeCategoria);
				
				Produto produto = new Produto(nome, descricao,preco,categoria);
				produtoController.salvar(produto);
				System.out.println("Produto " + nome + " salvo");
				break;
			
			case 3:
				System.out.println("Digite o id do produto para alterar:");
				id = scan.nextInt();
				System.out.println("Digite o nome do novo produto:");
				nome = scan.nextLine();
				System.out.println("Digite a descrição do produto:");
				descricao = scan.nextLine();
				System.out.println("Digite o novo preço:");
				preco = scan.nextBigDecimal();
			
				produtoController.alterar(nome, descricao, preco,id);
				System.out.println("Produto " + nome + " alterado");

				break;
			
			case 4:
				System.out.println("Digite o id do produto para deletar:");
				id = scan.nextInt();
				produtoController.deletar(id);
				System.out.println("Produto deletado");
				break;
			
			case 5:
				System.out.println(categoriaController.listar());
				break;
				
			case 6:
				System.out.println("Digite o nome da categoria:");
				nome = scan.next();
				categoria = new Categoria(nome);
				categoriaController.salvar(categoria);
				break;
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + entrada);
			}
		
		}
	}
}
