import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

/**
 * Breve descrição do código
 * 
 * @sid 2001
 * @aid 1.1
 */

public class VCI_Carrinho {

	private JFrame frame;
	private double pTotal;
	private int linhaSel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private VCI_cl_Gestao g;

	/**
	 * Create the application.
	 */
	public VCI_Carrinho(VCI_cl_Gestao g) {
		this.g = g;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\rmmi7\\OneDrive\\Documentos\\Acertar o Rumo\\Aulas\\Projeto\\Relat\u00F3rio preliminar\\VC_Logotipo.jpg"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_301780164444062");
		panel.setLayout(null);

		JLabel label = new JLabel("VIEW COMICS INC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label.setBounds(10, 0, 416, 30);
		panel.add(label);

		JLabel lblCarrinhoDeCompras = new JLabel("Carrinho de compras");
		lblCarrinhoDeCompras.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblCarrinhoDeCompras.setBounds(10, 30, 196, 20);
		panel.add(lblCarrinhoDeCompras);

		// VOLTAR
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				VCI_Cliente_Op window = new VCI_Cliente_Op(g);
				window.getFrame().setVisible(true);
			}
		});
		button.setBounds(10, 233, 83, 23);
		panel.add(button);

		// FINALIZAR COMPRA
		JButton button_1 = new JButton("Finalizar compra");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (pTotal == 0) {
					JOptionPane.showMessageDialog(frame, "O carrinho de compras está vazio.");
				} else {
					JOptionPane.showMessageDialog(frame, "Para finalizar a sua compra, por favor, dirija-se a um vendedor.");
				//	System.out.println(VCI_cl_Gestao.cliente.getListaCompras().get(0));
					frame.dispose();
					VCI_Login window = new VCI_Login(g);
					window.getFrame().setVisible(true);
				}
			}
		});
		button_1.setBounds(288, 233, 138, 23);
		panel.add(button_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 416, 124);
		panel.add(scrollPane);
		// Colunas da tabela.
		String[] colunas = { "Título", "Autor", "ISBN", "Quant", "Preço" };
		DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
		JTable table = new JTable(modeloTabela);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		String t = "", a = "", i = "";
		double p = 0.0;
		int n = 0;
		for (int j = 0; j < VCI_cl_Gestao.cliente.getListaCompras().size(); j++) {
			t = VCI_cl_Gestao.cliente.getListaCompras().get(j).getTitulo();
			a = VCI_cl_Gestao.cliente.getListaCompras().get(j).getAutor();
			p = VCI_cl_Gestao.cliente.getListaCompras().get(j).getPreco();
			i = VCI_cl_Gestao.cliente.getListaCompras().get(j).getIsbn();
			n = VCI_cl_Gestao.cliente.getQuantLivros().get(j);
			Object[] livro = { t, a, i, n, p }; // Linha da tabela.
			modeloTabela.addRow(livro); // Adição da linha à tabela.
		}
		scrollPane.setViewportView(table);

		JLabel label_1 = new JLabel("Valor total da sua compra:");
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label_1.setBounds(10, 198, 208, 24);
		panel.add(label_1);

		// Cálculo e apresentação do valor total da compra.
		for (int j = 0; j < VCI_cl_Gestao.cliente.getListaCompras().size(); j++) {
			pTotal = pTotal + VCI_cl_Gestao.cliente.getListaCompras().get(j).getPreco()
					* VCI_cl_Gestao.cliente.getQuantLivros().get(j);
		}
		DecimalFormat df = new DecimalFormat("#.##");
		String valor = df.format(pTotal);
		JLabel label_2 = new JLabel(valor);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label_2.setBounds(316, 198, 75, 24);
		panel.add(label_2);

		JButton btnAlterarSeleo = new JButton("Alterar sele\u00E7\u00E3o");
		btnAlterarSeleo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				linhaSel = table.getSelectedRow();
				if (linhaSel >= 0) {
					CardLayout card = (CardLayout) frame.getContentPane().getLayout();
					card.show(frame.getContentPane(), "AltSel");
				} else {
					JOptionPane.showMessageDialog(frame, "Nenhum livro selecionado.");
				}
			}
		});
		btnAlterarSeleo.setBounds(123, 233, 138, 23);
		panel.add(btnAlterarSeleo);

		JLabel label_3 = new JLabel("\u20AC");
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label_3.setBounds(401, 198, 25, 24);
		panel.add(label_3);

		JPanel AltSel = new JPanel();
		frame.getContentPane().add(AltSel, "AltSel");
		AltSel.setLayout(null);
// FIM CARRINHO
// INÍCIO ALT_SEL
		JLabel label_4 = new JLabel("VIEW COMICS INC");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_4.setBounds(10, 0, 416, 30);
		AltSel.add(label_4);

		JLabel lblAlterarDadosDo = new JLabel("Alterar itens do carrinho");
		lblAlterarDadosDo.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblAlterarDadosDo.setBounds(10, 30, 416, 20);
		AltSel.add(lblAlterarDadosDo);

		JLabel lblPretende = new JLabel("Pretende:");
		lblPretende.setHorizontalAlignment(SwingConstants.LEFT);
		lblPretende.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblPretende.setBounds(10, 160, 117, 23);
		AltSel.add(lblPretende);

		JRadioButton rdbtnEliminarLivroDa = new JRadioButton("Eliminar o livro da lista de compras");
		buttonGroup.add(rdbtnEliminarLivroDa);
		rdbtnEliminarLivroDa.setBounds(116, 162, 230, 23);
		AltSel.add(rdbtnEliminarLivroDa);

		JRadioButton rdbtnModificarAQuantidade = new JRadioButton("Modificar a quantidade");
		buttonGroup.add(rdbtnModificarAQuantidade);
		rdbtnModificarAQuantidade.setBounds(116, 194, 230, 23);
		AltSel.add(rdbtnModificarAQuantidade);

		JLabel lblOLivro = new JLabel("Selecionou o livro");
		lblOLivro.setHorizontalAlignment(SwingConstants.LEFT);
		lblOLivro.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblOLivro.setBounds(10, 61, 242, 23);
		AltSel.add(lblOLivro);

		String titulo = table.getModel().getValueAt(linhaSel, 0).toString();
		JLabel label_5 = new JLabel(titulo);
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		label_5.setBounds(10, 85, 416, 23);
		AltSel.add(label_5);

		// VOLTAR
		JButton button_2 = new JButton("Voltar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) frame.getContentPane().getLayout();
				card.first(frame.getContentPane());
			}
		});
		button_2.setBounds(10, 240, 83, 23);
		AltSel.add(button_2);

		// CONFIRMAR
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnEliminarLivroDa.isSelected()) {
					VCI_cl_Gestao.cliente.getListaCompras().remove(linhaSel);
					VCI_cl_Gestao.cliente.getQuantLivros().remove(linhaSel);
					// initialize();
					CardLayout card = (CardLayout) frame.getContentPane().getLayout();
					card.first(frame.getContentPane());
				} else if (rdbtnModificarAQuantidade.isSelected()) {
					String nLivros = JOptionPane.showInputDialog(frame, "Quantos exemplares pretende adquirir?");
					int num = Integer.parseInt(nLivros);
					if (num != VCI_cl_Gestao.cliente.getQuantLivros().get(linhaSel)) {
						VCI_cl_Gestao.cliente.getQuantLivros().set(linhaSel, num);
						// initialize();
						CardLayout card = (CardLayout) frame.getContentPane().getLayout();
						card.first(frame.getContentPane());
					}
				}
			}
		});
		btnConfirmar.setBounds(288, 240, 138, 23);
		AltSel.add(btnConfirmar);

		JLabel lblParaOQual = new JLabel("Para o qual reservou ");
		lblParaOQual.setHorizontalAlignment(SwingConstants.LEFT);
		lblParaOQual.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblParaOQual.setBounds(10, 108, 138, 23);
		AltSel.add(lblParaOQual);

		String q = table.getModel().getValueAt(linhaSel, 3).toString();
		JLabel label_7 = new JLabel(q);
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		label_7.setBounds(151, 108, 41, 23);
		AltSel.add(label_7);

		JLabel lblExemplares = new JLabel("exemplares.");
		lblExemplares.setHorizontalAlignment(SwingConstants.LEFT);
		lblExemplares.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblExemplares.setBounds(196, 108, 138, 23);
		AltSel.add(lblExemplares);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public double getpTotal() {
		return pTotal;
	}

	public void setpTotal(double pTotal) {
		this.pTotal = pTotal;
	}

	public int getLinhaSel() {
		return linhaSel;
	}

	public void setLinhaSel(int linhaSel) {
		this.linhaSel = linhaSel;
	}

	public VCI_cl_Gestao getG() {
		return g;
	}

	public void setG(VCI_cl_Gestao g) {
		this.g = g;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

}
