package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProdutoController;
import dao.ProdutoDAO;
import modelo.Categoria;
import modelo.Produto;

public class CadastrarProduto extends JFrame{
	
	private ProdutoController produtoController;

	public CadastrarProduto() {
        setTitle("Cadastro de Produto");

        // Define o tamanho da janela
        setSize(400, 300);

        // Define o comportamento ao clicar no botão de fechar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();

        JLabel nomeProduto = new JLabel("Nome do Produto:");
        painel.add(nomeProduto);
        JTextField textoNome = new JTextField(20);
        painel.add(textoNome);
        JLabel descricaoProduto = new JLabel("Descrição do Produto:");
        painel.add(descricaoProduto);
        JTextField textoDescricao = new JTextField(20);
        painel.add(textoDescricao);
        JLabel precoProduto = new JLabel("Preço do Produto:");
        painel.add(precoProduto);
        JTextField textoPreco = new JTextField(20);
        painel.add(textoPreco);
        JLabel categoriaProduto = new JLabel("Nome da Categoria:");
        painel.add(categoriaProduto);
        JTextField textoCategoriaProduto = new JTextField(20);
        painel.add(textoCategoriaProduto);
 
        JButton botao = new JButton("Enviar");
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textoNome.getText();
                String descricao = textoDescricao.getText();
                String categoriaProduto = textoCategoriaProduto.getText();
                Categoria categoria = new Categoria(categoriaProduto);
                BigDecimal preco;
                try {
                    preco = new BigDecimal(textoPreco.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CadastrarProduto.this, "Preço inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Produto produto = new Produto(nome, descricao, preco,categoria);
                produtoController.salvar(produto);
                JOptionPane.showMessageDialog(CadastrarProduto.this, "Produto " + nome + " criado com sucesso!");
                
            }
        });
        painel.add(botao);

        produtoController = new ProdutoController();
        getContentPane().add(painel);

        setVisible(true);
    }
	
	
    public static void main(String[] args) {

    	CadastrarProduto cadastroProduto = new CadastrarProduto();
    }
    
    
}
