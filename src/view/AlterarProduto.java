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

public class AlterarProduto extends JFrame {

    private ProdutoController produtoController;
    private JTextField textoId;
    private JTextField textoNome;
    private JTextField textoDescricao;
    private JTextField textoPreco;

    public AlterarProduto() {
        setTitle("Alterar Produto");

        // Define o tamanho da janela
        setSize(400, 300);

        // Define o comportamento ao clicar no botão de fechar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();

        JLabel idProduto = new JLabel("ID do Produto:");
        painel.add(idProduto);
        textoId = new JTextField(20);
        painel.add(textoId);

        JLabel nomeProduto = new JLabel("Nome do Produto:");
        painel.add(nomeProduto);
        textoNome = new JTextField(20);
        painel.add(textoNome);

        JLabel descricaoProduto = new JLabel("Descrição do Produto:");
        painel.add(descricaoProduto);
        textoDescricao = new JTextField(20);
        painel.add(textoDescricao);

        JLabel precoProduto = new JLabel("Preço do Produto:");
        painel.add(precoProduto);
        textoPreco = new JTextField(20);
        painel.add(textoPreco);

        JButton botao = new JButton("Salvar");
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id;
                try {
                    id = Integer.parseInt(textoId.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AlterarProduto.this, "ID inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String nome = textoNome.getText();
                String descricao = textoDescricao.getText();
                BigDecimal preco;
                try {
                    preco = new BigDecimal(textoPreco.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AlterarProduto.this, "Preço inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                produtoController.alterar(nome, descricao, preco, id);
                JOptionPane.showMessageDialog(AlterarProduto.this, "Produto alterado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        painel.add(botao);

        produtoController = new ProdutoController();
        getContentPane().add(painel);

        setVisible(true);
    }

    public static void main(String[] args) {
        AlterarProduto alterarProduto = new AlterarProduto();
    }

}
