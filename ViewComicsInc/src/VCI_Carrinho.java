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
import javax.swing.table.TableColumnModel;
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rmmi7\\git\\Projecto1\\VC_Logotipo.jpg"));
		frame.setBounds(100, 100, 655, 300);
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
					JOptionPane.showMessageDialog(frame,
							"Para finalizar a sua compra, por favor, dirija-se a um vendedor.");
					// System.out.println(VCI_cl_Gestao.cliente.getListaCompras().get(0));
					frame.dispose();
					VCI_Login window = new VCI_Login(g);
					window.getFrame().setVisible(true);
				}
			}
		});
		button_1.setBounds(493, 233, 138, 23);
		panel.add(button_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 621, 124);
		panel.add(scrollPane);
		// Colunas da tabela.
		String[] colunas = { "Título", "Autor", "ISBN", "Quant", "Preço" };
		DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
		JTable table = new JTable(modeloTabela);
		table.setAutoCreateRowSorter(true);
		TableColumnModel col = table.getColumnModel();
		col.getColumn(0).setMaxWidth(261);
		col.getColumn(1).setMaxWidth(130);
		col.getColumn(2).setMaxWidth(130);
		col.getColumn(3).setMaxWidth(50);
		col.getColumn(4).setMaxWidth(50);
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
		label_2.setBounds(521, 198, 75, 24);
		panel.add(label_2);

		JButton btnAlterarSeleo = new JButton("Alterar sele\u00E7\u00E3o");
		btnAlterarSeleo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(frame, "Selecionar um item da tabela.");
				} else {
					linhaSel = table.convertRowIndexToModel(table.getSelectedRow());
					frame.dispose();
					VCI_AltSelCar window = new VCI_AltSelCar(g, linhaSel);
					window.getFrame().setVisible(true);
				}
			}
		});
		btnAlterarSeleo.setBounds(345, 233, 138, 23);
		panel.add(btnAlterarSeleo);

		JLabel label_3 = new JLabel("\u20AC");
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label_3.setBounds(606, 198, 25, 24);
		panel.add(label_3);

		String titulo = table.getModel().getValueAt(linhaSel, 0).toString();

		String q = table.getModel().getValueAt(linhaSel, 3).toString();
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
