package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ProdutoController;
import modelo.Produto;

public class ListarProdutos extends JFrame {

	private ProdutoController produtoController;

	public ListarProdutos() {
		super("Lista de Produtos");

		produtoController = new ProdutoController();

		JPanel panel = new JPanel(new BorderLayout());
		DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "id", "Nome", "Descrição", "Preço" });
		JTable table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane, BorderLayout.CENTER);

		List<Produto> produtos = produtoController.listar();

		for (Produto produto : produtos) {
			Object[] row = new Object[] { produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco() };
			tableModel.addRow(row);
		}

		setPreferredSize(new Dimension(500, 300));
		setContentPane(panel);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new ListarProdutos();
	}
}
