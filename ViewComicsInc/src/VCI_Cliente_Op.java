import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 * Breve descrição do código
 * 
 * @sid 2001
 * @aid 1.1
 */

public class VCI_Cliente_Op {

	private JFrame frame;
	private double pTotal = 0.00;
	private VCI_cl_Gestao g;
	
	/**
	 * Create the application.
	 */
	public VCI_Cliente_Op(VCI_cl_Gestao g) {
		this.g = g;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rmmi7\\git\\Projecto1\\VC_Logotipo.jpg"));
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_224983163152425");
		panel.setLayout(null);

		JLabel label = new JLabel("VIEW COMICS INC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label.setBounds(10, 0, 416, 30);
		panel.add(label);

		JLabel label_1 = new JLabel("Selecione uma op\u00E7\u00E3o:");
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_1.setBounds(10, 57, 196, 24);
		panel.add(label_1);

		// LISTAR LIVROS
		JButton btnListarTodosOs = new JButton("Procurar livros");
		btnListarTodosOs.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnListarTodosOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				VCI_ListarLivros window = new VCI_ListarLivros(g);
				window.getFrame().setVisible(true);
			}
		});
		btnListarTodosOs.setBounds(278, 109, 148, 30);
		panel.add(btnListarTodosOs);

		// VER CARRINHO
		JButton btnPesquisarLivros = new JButton("Ver/modificar carrinho");
		btnPesquisarLivros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPesquisarLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (pTotal == 0) {
					JOptionPane.showMessageDialog(frame, "Ainda não existem compras para exibir.");
				} else {
					frame.dispose();
					VCI_Carrinho window = new VCI_Carrinho(g);
					window.getFrame().setVisible(true);
				}
			}
		});
		btnPesquisarLivros.setBounds(278, 156, 148, 30);
		panel.add(btnPesquisarLivros);

		// VOLTAR
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] opcoes = { "Abandonar", "Continuar compras" };
				int opcao = JOptionPane.showOptionDialog(frame,
						"Perderá os dados do seu carrinho. Pretende abandonar a sessão?", "ABANDONO DE SESSÃO",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[1]);
				if (opcao == 0) { // Adição do livro ao carrinho de compras.
					VCI_cl_Gestao.cliente = null; // Anula o cliente ativo.
					frame.dispose();
					VCI_N1 window = new VCI_N1();
					window.getFrame().setVisible(true);
				}
			}
		});
		btnVoltar.setBounds(10, 222, 83, 30);
		panel.add(btnVoltar);

		// FINALIZAR COMPRA
		JButton btnFinalizarCompra = new JButton("Finalizar compra");
		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (pTotal == 0) {
					JOptionPane.showMessageDialog(frame, "Ainda não existem compras para exibir.");
				} else {
					frame.dispose();
					VCI_Carrinho window = new VCI_Carrinho(g);
					window.getFrame().setVisible(true);
				}
			}			
		});
		btnFinalizarCompra.setBounds(278, 222, 148, 30);
		panel.add(btnFinalizarCompra);
		
		JLabel lblParaComporO = new JLabel("Para adicionar ao carrinho de compras:");
		lblParaComporO.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblParaComporO.setBounds(10, 109, 272, 24);
		panel.add(lblParaComporO);
		
		JLabel lblParaGeriroCarrinho = new JLabel("Para gerir o carrinho de compras:");
		lblParaGeriroCarrinho.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblParaGeriroCarrinho.setBounds(10, 159, 272, 24);
		panel.add(lblParaGeriroCarrinho);
		// Colunas da tabela.
		String[] colunas = { "Título", "Autor", "Preço" };
		DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
		for (VCI_cl_Livro l : VCI_cl_Gestao.cliente.getListaCompras()) { // Formação das linhas da tabela.
			String t = l.getTitulo();
			String a = l.getAutor();
			double p = l.getPreco();
			pTotal = pTotal + p;
			Object[] livro = { t, a, p }; // Linha da tabela.
			modeloTabela.addRow(livro); // Adição da linha à tabela.
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
