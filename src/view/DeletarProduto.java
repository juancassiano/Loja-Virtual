package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProdutoController;

public class DeletarProduto extends JFrame{
	
	private ProdutoController produtoController;

	public DeletarProduto() {
        setTitle("Deletar Produto");

        // Define o tamanho da janela
        setSize(400, 200);

        // Define o comportamento ao clicar no botão de fechar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();

        JLabel idProduto = new JLabel("ID do Produto:");
        painel.add(idProduto);
        JTextField textoId = new JTextField(20);
        painel.add(textoId);

        JButton botao = new JButton("Deletar");
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer id;
                try {
                    id = Integer.parseInt(textoId.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(DeletarProduto.this, "ID inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                produtoController.deletar(id);
                JOptionPane.showMessageDialog(DeletarProduto.this, "Produto deletado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        painel.add(botao);

        produtoController = new ProdutoController();
        getContentPane().add(painel);

        setVisible(true);
    }
	
	
    public static void main(String[] args) {

    	DeletarProduto deletarProduto = new DeletarProduto();
    }
    
    
}
