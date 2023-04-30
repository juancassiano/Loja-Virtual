package view;


import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import controller.CategoriaController;
import modelo.Categoria;

public class ListarCategorias extends JFrame {

	private CategoriaController categoriaController;

	public ListarCategorias() {
		setTitle("Listar Categorias");

		// Define o tamanho da janela
		setSize(400, 300);

		// Define o comportamento ao clicar no botão de fechar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JPanel();

		String[] colunas = {"Nome"};

		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

		JTable tabela = new JTable(modelo);
		
		 DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
	        tabela.setDefaultRenderer(Object.class, centerRenderer);


		JScrollPane painelTabela = new JScrollPane(tabela);

		painel.add(painelTabela);

		getContentPane().add(painel);

		try {
			categoriaController = new CategoriaController();
		} catch (SQLException e) {
			throw new RuntimeException();
		}

		List<Categoria> categorias = categoriaController.listar();

		for (Categoria categoria : categorias) {
			Object[] linha = {categoria.getNome()};
			modelo.addRow(linha);
		}

		setVisible(true);
	}

	public static void main(String[] args) {
		ListarCategorias listarCategorias = new ListarCategorias();
	}
}
