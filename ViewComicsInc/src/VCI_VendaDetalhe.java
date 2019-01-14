import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

/**
 * Breve descrição do código
 * 
 * @sid 2001
 * @aid 1.1
 */

public class VCI_VendaDetalhe {

	private JFrame frame;
	private VCI_cl_Gestao g;
	private VCI_cl_Compra c;
	private JTable table;

	public VCI_VendaDetalhe(VCI_cl_Gestao g, VCI_cl_Compra c) {
		this.g = g;
		this.c = c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("../Projecto1/VC_Logotipo.jpg"));
		frame.setBounds(100, 100, 656, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel label = new JLabel("VIEW COMICS INC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label.setBounds(0, 0, 642, 30);
		panel.add(label);

		JLabel lblDetalhesDeVenda = new JLabel("Detalhes de venda");
		lblDetalhesDeVenda.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblDetalhesDeVenda.setBounds(10, 30, 264, 24);
		panel.add(lblDetalhesDeVenda);

		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		button.setBounds(10, 222, 89, 30);
		panel.add(button);

		// Altura da tabela em função do número de linhas.
		int nLinhas = c.getCarrinho().getListaCompras().size() + 1;
		int altTab;
		if (nLinhas <= 6) {
			altTab = nLinhas * 18 + 5;
		} else {
			altTab = 131;
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 620, altTab);
		panel.add(scrollPane);
		// Colunas da tabela.
		String[] colunas = { "Data", "Livros", "Quant.", "NIF do Cliente", "Valor", "Tipo de Pag." };
		DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
		JTable table = new JTable(modeloTabela);
		table.setAutoCreateRowSorter(true);
		// Alinhamento de colunas:
		DefaultTableCellRenderer alinharEsquerda = new DefaultTableCellRenderer();
		DefaultTableCellRenderer alinharCentro = new DefaultTableCellRenderer();
		alinharEsquerda.setHorizontalAlignment(JLabel.LEFT);
		alinharCentro.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
			if (i == 1) {
				table.getColumnModel().getColumn(1).setCellRenderer(alinharEsquerda);
			} else {
				table.getColumnModel().getColumn(i).setCellRenderer(alinharCentro);
			}
		}
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		table.setRowHeight(18); // Altura das linhas.
		TableColumnModel col = table.getColumnModel(); // Largura das colunas.
		col.getColumn(0).setMaxWidth(70);
		col.getColumn(1).setMaxWidth(250);
		col.getColumn(2).setMaxWidth(50);
		col.getColumn(3).setMaxWidth(100);
		col.getColumn(4).setMaxWidth(50);
		col.getColumn(5).setMaxWidth(100);
		GregorianCalendar d = c.getData();
		String data = d.get(Calendar.DAY_OF_MONTH) + "/" + (d.get(Calendar.MONTH) + 1) + "/" + d.get(Calendar.YEAR);
		int n = c.getNif();
		double v = c.getValor();
		String pag = "";
		if (c instanceof VCI_cl_Dinheiro) {
			pag = "Dinheiro";
		} else {
			pag = "Cartão";
		}
		int qT = 0;
		for (int i = 0; i < c.getCarrinho().getListaCompras().size(); i++) { // Formação das linhas da tabela.
			String t = c.getCarrinho().getListaCompras().get(i).getTitulo();
			int q = c.getCarrinho().getQuantLivros().get(i);
			double preco = c.getCarrinho().getListaCompras().get(i).getPreco();
			qT = qT + q;
			Object[] item = { "", t, q, "", preco + " €", "" }; // Linha da tabela.
			modeloTabela.addRow(item); // Adição da linha à tabela.
		}
		scrollPane.setViewportView(table);

		int posLabel = 65 + altTab; // Posição das labels a seguir à tabela.
		JLabel label_1 = new JLabel(data);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_1.setBounds(10, posLabel, 70, 24);
		panel.add(label_1);

		DecimalFormat df = new DecimalFormat("#.##");
		JLabel label_2 = new JLabel(df.format(v) + " €");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_2.setBounds(480, posLabel, 50, 24);
		panel.add(label_2);

		JLabel label_3 = new JLabel("Total de livros vendidos");
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_3.setBounds(80, posLabel, 250, 24);
		panel.add(label_3);

		JLabel label_4 = new JLabel(df.format(qT));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_4.setBounds(330, posLabel, 50, 24);
		panel.add(label_4);

		JLabel label_5 = new JLabel(String.valueOf(n));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_5.setBounds(380, posLabel, 100, 24);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel(pag);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_6.setBounds(530, posLabel, 100, 24);
		panel.add(label_6);
	}

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

	public VCI_cl_Compra getC() {
		return c;
	}

	public void setC(VCI_cl_Compra c) {
		this.c = c;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
