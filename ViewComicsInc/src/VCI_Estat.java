import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Breve descrição do código
 * 
 * @sid 2001
 * @aid 1.1
 */

public class VCI_Estat {

	private JFrame frame;
	private VCI_cl_Gestao g;
	private ArrayList<VCI_cl_Compra> vendasPeriodo;
	private JTable table;

	public VCI_Estat(VCI_cl_Gestao g, ArrayList<VCI_cl_Compra> vendasPeriodo) {
		this.g = g;
		this.vendasPeriodo = vendasPeriodo;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("../Projecto1/VC_Logotipo.jpg"));
		frame.setBounds(100, 100, 496, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel label = new JLabel("VIEW COMICS INC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label.setBounds(10, 0, 416, 30);
		panel.add(label);

		JLabel lblEstatsticasDeVendas = new JLabel("Estat\u00EDsticas de vendas no per\u00EDodo selecionado");
		lblEstatsticasDeVendas.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstatsticasDeVendas.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblEstatsticasDeVendas.setBounds(10, 34, 416, 20);
		panel.add(lblEstatsticasDeVendas);

		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		button.setBounds(10, 222, 89, 30);
		panel.add(button);

		JLabel label_1 = new JLabel("Clique nas colunas para reordenar os dados");
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label_1.setBounds(10, 55, 416, 24);
		panel.add(label_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 460, 116);
		panel.add(scrollPane);
		// Colunas da tabela.
		String[] colunas = { "Livro", "Ex. vendidos", "Receita", "Preço médio" };
		DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
		JTable table = new JTable(modeloTabela);
		table.setAutoCreateRowSorter(true); // Permite reordenação das colunas
		// Alinhamento à direita das colunas 1 a 3:
		DefaultTableCellRenderer rigthRenderer = new DefaultTableCellRenderer();
		rigthRenderer.setHorizontalAlignment( JLabel.RIGHT);
	    for(int i = 1; i < modeloTabela.getColumnCount(); i++){
	    	table.getColumnModel().getColumn(i).setCellRenderer(rigthRenderer);
	    }
	    table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		TableColumnModel col = table.getColumnModel();
		col.getColumn(0).setMaxWidth(240);
		col.getColumn(1).setMaxWidth(75);
		col.getColumn(2).setMaxWidth(70);
		col.getColumn(3).setMaxWidth(75);
		// Conjunto de livros vendidos.
		Set<String> titulos = new TreeSet<String>();
		for (int i = 0; i < vendasPeriodo.size(); i++) {
			for (int j = 0; j < vendasPeriodo.get(i).getCarrinho().getListaCompras().size(); j++) {
				titulos.add(vendasPeriodo.get(i).getCarrinho().getListaCompras().get(j).getTitulo());
			}
		}
		// Cálculo dos exemplares vendidos e receita total para cada livro.
		int qTotal = 0;
		double rTotal = 0.0;
		DecimalFormat df = new DecimalFormat("#.##");
		for (String t : titulos) {
			int cont = 0;
			double recTotal = 0.0;
			for (int i = 0; i < vendasPeriodo.size(); i++) {
				for (int j = 0; j < vendasPeriodo.get(i).getCarrinho().getListaCompras().size(); j++) {
					if (t.equals(vendasPeriodo.get(i).getCarrinho().getListaCompras().get(j).getTitulo())) {
						cont = cont + vendasPeriodo.get(i).getCarrinho().getQuantLivros().get(j);
						recTotal = recTotal
								+ cont * vendasPeriodo.get(i).getCarrinho().getListaCompras().get(j).getPreco();
					}
				}
			}
			qTotal = qTotal + cont;
			rTotal = rTotal + recTotal;
			String recMedia = df.format(recTotal / cont);
			String recT = df.format(recTotal);
			Object[] item = { t, cont, recT + " €", recMedia + " €" }; // Linha da tabela.
			modeloTabela.addRow(item); // Adição da linha à tabela.
		}
		String recMedTotal = df.format(rTotal/qTotal);
		String recTotal = df.format(rTotal);
		scrollPane.setViewportView(table);
		
		JLabel lblTotais = new JLabel("Totais");
		lblTotais.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblTotais.setBounds(10, 195, 153, 24);
		panel.add(lblTotais);
		
		JLabel label_2 = new JLabel(recMedTotal + " €");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_2.setBounds(375, 195, 77, 24);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel(recTotal + " €");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_3.setBounds(298, 195, 77, 24);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel(String.valueOf(qTotal));
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		label_4.setBounds(245, 195, 60, 24);
		panel.add(label_4);
		
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

	public ArrayList<VCI_cl_Compra> getVendasPeriodo() {
		return vendasPeriodo;
	}

	public void setVendasPeriodo(ArrayList<VCI_cl_Compra> vendasPeriodo) {
		this.vendasPeriodo = vendasPeriodo;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
