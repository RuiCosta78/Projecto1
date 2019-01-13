import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;

/**
 * Breve descrição do código
 * 
 * @sid 2001
 * @aid 1.1
 */

public class VCI_TabListaLiv {

	private JFrame frame;
	private VCI_cl_Gestao g;
	private VCI_cl_Livro livroSelecionado;
	private ArrayList<VCI_cl_Livro> listaLiv;

	/**
	 * Create the application.
	 */
	public VCI_TabListaLiv(VCI_cl_Gestao g, ArrayList<VCI_cl_Livro> listaLiv) {
		this.listaLiv = listaLiv;
		this.g = g;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rmmi7\\git\\Projecto1\\VC_Logotipo.jpg"));
		frame.setBounds(100, 100, 800, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("VIEW COMICS INC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label.setBounds(10, 0, 766, 30);
		frame.getContentPane().add(label);

		JLabel lblListagemDeLivros = new JLabel("Listagem de livros selecionados");
		lblListagemDeLivros.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblListagemDeLivros.setBounds(10, 30, 416, 24);
		frame.getContentPane().add(lblListagemDeLivros);

		JFrame caixa = new JFrame();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 766, 136);
		frame.getContentPane().add(scrollPane);
		// Colunas da tabela.
		String[] colunas = { "Título", "Autor", "Editora", "ISBN", "Ano de Ed.", "Preço" };
		DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
		JTable table = new JTable(modeloTabela);
		table.setAutoCreateRowSorter(true); // Reordenamento de colunas.
		// Alinhamento de colunas:
		DefaultTableCellRenderer alinharEsquerda = new DefaultTableCellRenderer();
		DefaultTableCellRenderer alinharCentro = new DefaultTableCellRenderer();
		alinharEsquerda.setHorizontalAlignment(JLabel.LEFT);
		alinharCentro.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(alinharEsquerda);
		table.getColumnModel().getColumn(1).setCellRenderer(alinharEsquerda);
		table.getColumnModel().getColumn(2).setCellRenderer(alinharEsquerda);
		table.getColumnModel().getColumn(3).setCellRenderer(alinharCentro);
		table.getColumnModel().getColumn(4).setCellRenderer(alinharCentro);
		table.getColumnModel().getColumn(5).setCellRenderer(alinharCentro);
		TableColumnModel col = table.getColumnModel();
		col.getColumn(0).setMaxWidth(261);
		col.getColumn(1).setMaxWidth(130);
		col.getColumn(2).setMaxWidth(130);
		col.getColumn(3).setMaxWidth(130);
		col.getColumn(4).setMaxWidth(65);
		col.getColumn(5).setMaxWidth(50);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		for (VCI_cl_Livro l : listaLiv) { // Formação das linhas da tabela.
			String t = l.getTitulo();
			String a = l.getAutor();
			String ed = l.getEditora();
			String isbn = l.getIsbn();
			int ano = l.getAnoEdicao();
			double p = l.getPreco();
			Object[] livro = { t, a, ed, isbn, ano, p + " €" }; // Linha da tabela.
			modeloTabela.addRow(livro); // Adição da linha à tabela.
		}
		scrollPane.setViewportView(table);

		// VOLTAR
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				VCI_ListarLivros window = new VCI_ListarLivros(g);
				window.getFrame();
			}
		});
		button.setBounds(10, 222, 89, 30);
		frame.getContentPane().add(button);

		// SELECIONAR
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(frame, "Selecionar um item da tabela.");
				} else {
					int n = table.convertRowIndexToModel(table.getSelectedRow()); // número da linha selecionada.

					String isbnSel = table.getModel().getValueAt(n, 3).toString(); // isbn da linha selecionada (4.ª
																					// coluna, posição 3).
					for (VCI_cl_Livro l : listaLiv) {
						if (l.getIsbn().equals(isbnSel)) {
							livroSelecionado = l;
						}
					}
					if (VCI_cl_Gestao.utilizador instanceof VCI_cl_Admin
							|| VCI_cl_Gestao.utilizador instanceof VCI_cl_Vendedor) {
						if (livroSelecionado.getQuantidade() == 0) {
							JOptionPane.showMessageDialog(caixa, "De momento o livro encontra-se esgotado.");
						} else {
							JOptionPane.showMessageDialog(caixa, "Estão disponíveis " + livroSelecionado.getQuantidade()
									+ " cópias do livro selecionado.");
						}
					} else {
						if (livroSelecionado.getQuantidade() == 0) {
							JOptionPane.showMessageDialog(caixa, "De momento o livro encontra-se esgotado.");
						} else {
							Object[] opcoes = { "Adicionar", "Cancelar" };
							int opcao = JOptionPane.showOptionDialog(caixa,
									"Pretende adicionar o livro selecionado ao carrinho de compras?",
									"CARRINHO DE COMPRAS", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
									null, opcoes, opcoes[1]);
							if (opcao == 0) { // Adição do livro ao carrinho de compras.
								String nLivros = JOptionPane.showInputDialog(frame,
										"Quantos exemplares pretende adquirir do livro selecionado?");
								if (g.validarInteiro(nLivros) == false) {
									JOptionPane.showMessageDialog(frame,
											"O número de exemplares tem de ser um inteiro, sem espaços.");
								} else {
									int num = Integer.parseInt(nLivros);
									if (num > livroSelecionado.getQuantidade()) {
										JOptionPane.showMessageDialog(frame,
												"Encontram-se disponíveis " + livroSelecionado.getQuantidade()
														+ " exemplares do livro selecionado.");
									} else {
										JOptionPane.showMessageDialog(frame,
												"Adição ao carrinho de compras com sucesso.");
										VCI_cl_Gestao.cliente.getListaCompras().add(livroSelecionado);
										VCI_cl_Gestao.cliente.getQuantLivros().add(num);
									}
								}
							}
						}
					}
				}
			}
		});
		btnSelecionar.setBounds(671, 222, 105, 30);
		frame.getContentPane().add(btnSelecionar);

		JLabel label_1 = new JLabel("Clique nas colunas para reordenar os livros.");
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label_1.setBounds(10, 53, 416, 24);
		frame.getContentPane().add(label_1);
	}

	// CÓDIGO ALTERNATIVO PARA CRIAÇÃO DE TABELA
	/*
	 * String[] colunas = { "Título", "Autor", "Editora", "ISBN", "Ano de Edição",
	 * "Preço" }; Object[][] linhas = new Object[listaLiv.size()][colunas.length];
	 * for (int i = 0; i < listaLiv.size(); i++) { linhas[i][0] =
	 * listaLiv.get(i).getTitulo(); linhas[i][1] = listaLiv.get(i).getAutor();
	 * linhas[i][2] = listaLiv.get(i).getEditora(); linhas[i][3] =
	 * listaLiv.get(i).getIsbn(); linhas[i][4] = listaLiv.get(i).getAnoEdicao();
	 * linhas[i][5] = listaLiv.get(i).getPreco(); } JTable tabela = new
	 * JTable(linhas, colunas); scrollPane.add(tabela);
	 * scrollPane.setViewportView(tabela);
	 */

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public VCI_cl_Gestao getG() {
		return g;
	}

	public void setG(VCI_cl_Gestao g) {
		this.g = g;
	}

	public VCI_cl_Livro getLivroSelecionado() {
		return livroSelecionado;
	}

	public void setLivroSelecionado(VCI_cl_Livro livroSelecionado) {
		this.livroSelecionado = livroSelecionado;
	}

	public ArrayList<VCI_cl_Livro> getListaLiv() {
		return listaLiv;
	}

	public void setListaLiv(ArrayList<VCI_cl_Livro> listaLiv) {
		this.listaLiv = listaLiv;
	}
}
