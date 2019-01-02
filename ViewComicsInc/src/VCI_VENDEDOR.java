import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTextField;

/**   
 * Breve descrição do código
 *  
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_VENDEDOR {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the application.
	 */
	public VCI_VENDEDOR() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rmmi7\\OneDrive\\Documentos\\Acertar o Rumo\\Aulas\\Projeto\\Relat\u00F3rio preliminar\\VC_Logotipo.jpg"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel Opcoes = new JPanel();
		frame.getContentPane().add(Opcoes, "Opcoes");
		Opcoes.setLayout(null);
		
		JLabel label = new JLabel("VIEW COMICS INC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label.setBounds(10, 0, 416, 30);
		Opcoes.add(label);
		
		JLabel label_1 = new JLabel("Benvindo!");
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_1.setBounds(10, 52, 111, 24);
		Opcoes.add(label_1);
		
		JLabel label_2 = new JLabel("Selecione uma op\u00E7\u00E3o:");
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_2.setBounds(10, 85, 196, 24);
		Opcoes.add(label_2);
		
		// ALTERAR LOGIN
		JButton button = new JButton("Alterar login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose(); // desliga a janela ativa;
				VCI_LoginAlt window = new VCI_LoginAlt();
				window.getFrame().setVisible(true);
			}
		});
		button.setBounds(10, 128, 133, 23);
		Opcoes.add(button);
		
		//LISTAR LIVROS
		JButton button_1 = new JButton("Listar livros");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose(); // desliga a janela ativa;
				VCI_ListarLivros window = new VCI_ListarLivros();
				window.getFrame().setVisible(true);
			}
		});
		button_1.setBounds(153, 128, 133, 23);
		Opcoes.add(button_1);
		
		// CONCLUIR COMPRA
		JButton btnConcluirCompra = new JButton("Concluir compra");
		btnConcluirCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) frame.getContentPane().getLayout();
				card.show(frame.getContentPane(), "Compra");
			}
		});
		btnConcluirCompra.setBounds(293, 128, 133, 23);
		Opcoes.add(btnConcluirCompra);
		
		// LOGOUT
		JButton button_3 = new JButton("Logout");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose(); // desliga a janela ativa;
				VCI_cl_Gestao.utilizador = null;
				VCI_Login window = new VCI_Login();
				window.getFrame().setVisible(true);
			}
		});
		button_3.setBounds(293, 229, 133, 23);
		Opcoes.add(button_3);
		
		// PESQUISAR LIVROS
		JButton button_4 = new JButton("Pesquisar livros");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose(); // desliga a janela ativa;
				VCI_PesLivro window = new VCI_PesLivro();
				window.getFrame().setVisible(true);
			}
		});
		button_4.setBounds(153, 162, 133, 23);
		Opcoes.add(button_4);
		
		JPanel Compra = new JPanel();
		frame.getContentPane().add(Compra, "Compra");
		Compra.setLayout(null);
		
		JLabel label_3 = new JLabel("VIEW COMICS INC");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_3.setBounds(10, 0, 416, 30);
		Compra.add(label_3);
		
		JLabel lblConcluirCompra = new JLabel("Concluir compra");
		lblConcluirCompra.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblConcluirCompra.setBounds(10, 34, 339, 24);
		Compra.add(lblConcluirCompra);
		
		// VOLTAR em CONCLUIR COMPRA
		JButton button_2 = new JButton("Voltar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) frame.getContentPane().getLayout();
				card.previous(frame.getContentPane());
			}
		});
		button_2.setBounds(10, 229, 133, 23);
		Compra.add(button_2);
		
		JButton button_5 = new JButton("Logout");
		button_5.setBounds(293, 229, 133, 23);
		Compra.add(button_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(201, 69, 200, 20);
		Compra.add(textField);
		
		JLabel lblNifDoCliente = new JLabel("NIF do cliente:");
		lblNifDoCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblNifDoCliente.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblNifDoCliente.setBounds(10, 69, 129, 20);
		Compra.add(lblNifDoCliente);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(201, 101, 200, 20);
		Compra.add(textField_1);
		
		JLabel lblIdDoCarrinho = new JLabel("ID do carrinho do cliente:");
		lblIdDoCarrinho.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdDoCarrinho.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblIdDoCarrinho.setBounds(10, 101, 161, 20);
		Compra.add(lblIdDoCarrinho);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
