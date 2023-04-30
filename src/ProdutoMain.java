import java.sql.SQLException;

import javax.swing.JOptionPane;

import view.AlterarProduto;
import view.CadastrarCategoria;
import view.CadastrarProduto;
import view.DeletarProduto;
import view.ListarCategorias;
import view.ListarProdutos;

public class ProdutoMain {

	public static void main(String[] args) throws SQLException {
		
		
		String[] opcoes = {"Listar Produtos", "Cadastrar Produto", "Alterar Produto",
				"Deletar Produto", "Listar Categorias", "Criar Categoria","SAIR"};
		
		int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:","Menu",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE ,null,opcoes,opcoes[0]);
		
		try {
			switch (escolha) {
			case 0:
				ListarProdutos listarProdutos = new ListarProdutos();
				break;
			case 1:
				CadastrarProduto cadastrarProduto = new CadastrarProduto();
				cadastrarProduto.setVisible(true);
				break;
			case 2:
				AlterarProduto alterarProduto = new AlterarProduto();
				alterarProduto.setVisible(true);
				break;
			case 3:
				DeletarProduto deletarProduto = new DeletarProduto();
				deletarProduto.setVisible(true);
				break;
			case 4:
				ListarCategorias listarCategorias = new ListarCategorias();
				listarCategorias.setVisible(true);
				break;
			case 5:
				CadastrarCategoria cadastrarCategoria = new CadastrarCategoria();
				cadastrarCategoria.setVisible(true);
				break;
				
			default:	
				JOptionPane.showMessageDialog(null, "Obrigado por usar o programa");

			}
		}catch(RuntimeException e) {
			throw new RuntimeException(e);
		}
	}
}
