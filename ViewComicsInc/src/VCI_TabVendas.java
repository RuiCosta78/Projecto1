import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;

/**
 * Breve descrição do código
 * 
 * @sid 2001
 * @aid 1.1
 */

public class VCI_TabVendas {

	private JFrame frame;
	private JTable table;
	private VCI_cl_Gestao g;
	private GregorianCalendar di;
	private GregorianCalendar df;

	public VCI_TabVendas(VCI_cl_Gestao g, GregorianCalendar di, GregorianCalendar df) throws IOException {
		this.g = g;
		this.di = di;
		this.df = df;
		initialize();
	}

	private void initialize() throws IOException {

			frame = new JFrame();
			frame.setIconImage(
					Toolkit.getDefaultToolkit().getImage("../Projecto1/VC_Logotipo.jpg"));
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel panel = new JPanel();
			frame.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JLabel label = new JLabel("VIEW COMICS INC");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
			label.setBounds(10, 0, 422, 30);
			panel.add(label);

			JLabel lblListagemDeVendas = new JLabel("Listagem de vendas");
			lblListagemDeVendas.setHorizontalAlignment(SwingConstants.LEFT);
			lblListagemDeVendas.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
			lblListagemDeVendas.setBounds(10, 21, 416, 30);
			panel.add(lblListagemDeVendas);

			// VOLTAR
			JButton button = new JButton("Voltar");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
					VCI_ADMIN window = null;
					try {
						window = new VCI_ADMIN(g);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					CardLayout card = (CardLayout) window.getContentPane().getLayout();
					card.show(window.getContentPane(), "ListarVendas");
				}
			});
			button.setBounds(10, 222, 89, 30);
			panel.add(button);

			JLabel lblCliqueNasColunas = new JLabel("Clique nas colunas para reordenar os dados");
			lblCliqueNasColunas.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			lblCliqueNasColunas.setBounds(10, 47, 416, 24);
			panel.add(lblCliqueNasColunas);

			ArrayList<VCI_cl_Compra> vendasPeriodo = new ArrayList<>(); // Lista de vendas para estatística
			double vendasTotais = 0.0;
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 74, 414, 119);
			panel.add(scrollPane);
			// Colunas da tabela.
			String[] colunas = { "Data", "Livros", "Valor" };
			DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
			JTable table = new JTable(modeloTabela);
			table.setAutoCreateRowSorter(true); // Reordenamento das colunas.
			// Alinhamento de colunas:
			DefaultTableCellRenderer alinharEsquerda = new DefaultTableCellRenderer();
			DefaultTableCellRenderer alinharCentro = new DefaultTableCellRenderer();
			alinharEsquerda.setHorizontalAlignment(JLabel.LEFT);
			alinharCentro.setHorizontalAlignment(JLabel.CENTER);
			table.getColumnModel().getColumn(0).setCellRenderer(alinharCentro);
			table.getColumnModel().getColumn(1).setCellRenderer(alinharEsquerda);
			table.getColumnModel().getColumn(2).setCellRenderer(alinharCentro);
			table.setShowHorizontalLines(true);
			table.setShowVerticalLines(true);
			TableColumnModel col = table.getColumnModel();
			col.getColumn(0).setMaxWidth(70);
			col.getColumn(1).setMaxWidth(274);
			col.getColumn(2).setMaxWidth(70);
			for (VCI_cl_Compra c : g.listaCompras) { // Formação das linhas da tabela.
				if (c.getData().after(di) && c.getData().before(df)) {
					vendasPeriodo.add(c);
					GregorianCalendar d = c.getData();
					String data = d.get(Calendar.DAY_OF_MONTH) + "/" + (d.get(Calendar.MONTH) + 1) + "/"
							+ d.get(Calendar.YEAR);
					String l = g.obterLivros(c.getCarrinho().getListaCompras(), c.getCarrinho().getQuantLivros());
					double v = c.getValor();
					vendasTotais = vendasTotais + v;
					Object[] venda = { data, l, v + " €" }; // Linha da tabela.
					modeloTabela.addRow(venda); // Adição da linha à tabela.
				}
			}
			scrollPane.setViewportView(table);

			JButton btnVerDetalhes = new JButton("Ver detalhes");
			btnVerDetalhes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (table.getSelectedRowCount() == 0) {
						JOptionPane.showMessageDialog(frame, "Selecionar um item da tabela.");
					} else {
						int n = table.convertRowIndexToModel(table.getSelectedRow());
						VCI_cl_Compra c = g.listaCompras.get(n);
						VCI_VendaDetalhe window = new VCI_VendaDetalhe(g, c);
						window.getFrame().setVisible(true);
					}
				}
			});
			btnVerDetalhes.setBounds(310, 222, 115, 30);
			panel.add(btnVerDetalhes);

			JLabel lblValorTotalDas = new JLabel("Valor total das vendas:");
			lblValorTotalDas.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			lblValorTotalDas.setBounds(10, 194, 214, 24);
			panel.add(lblValorTotalDas);

			JLabel label_1 = new JLabel(String.valueOf(vendasTotais) + " €");
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			label_1.setBounds(340, 194, 70, 24);
			panel.add(label_1);

			JButton btnVerEstatsticaDe = new JButton("Ver estat\u00EDstica de vendas");
			btnVerEstatsticaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VCI_Estat window = new VCI_Estat(g, vendasPeriodo);
					window.getFrame().setVisible(true);
				}
			});
			btnVerEstatsticaDe.setBounds(109, 222, 191, 30);
			panel.add(btnVerEstatsticaDe);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
