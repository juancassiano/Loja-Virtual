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

import controller.CategoriaController;
import controller.ProdutoController;
import dao.ProdutoDAO;
import modelo.Categoria;
import modelo.Produto;

public class CadastrarCategoria extends JFrame{
	
	private CategoriaController categoriaController;

	public CadastrarCategoria() {
        setTitle("Cadastro de Categoria");

        // Define o tamanho da janela
        setSize(400, 300);

        // Define o comportamento ao clicar no botão de fechar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();

        JLabel nomeCateogira = new JLabel("Nome da Cateogira:");
        painel.add(nomeCateogira);
        JTextField textoNome = new JTextField(20);
        painel.add(textoNome);
 
        JButton botao = new JButton("Enviar");
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textoNome.getText();
                Categoria categoria = new Categoria(nome);
             
                categoriaController.salvar(categoria);
                JOptionPane.showMessageDialog(CadastrarCategoria.this, "Categoria " + nome + " criado com sucesso!");
                
            }
        });
        painel.add(botao);
        getContentPane().add(painel);

        setVisible(true);
    }
	
	
    public static void main(String[] args) {

    	CadastrarCategoria cadastroCategoria = new CadastrarCategoria();
    }
    
    
}
