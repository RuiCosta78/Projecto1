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
 * Breve descri��o do c�digo
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

	/**
	 * Create the application.
	 */
	public VCI_TabVendas(VCI_cl_Gestao g, GregorianCalendar di, GregorianCalendar df) {
		this.g = g;
		this.di = di;
		this.df = df;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rmmi7\\git\\Projecto1\\VC_Logotipo.jpg"));
		frame.setBounds(100, 100, 900, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel label = new JLabel("VIEW COMICS INC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label.setBounds(10, 0, 416, 30);
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
				window.setVisible(true); // Ativa a janela a que o bot�o d� acesso;
			}
		});
		button.setBounds(10, 229, 89, 23);
		panel.add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 866, 154);
		panel.add(scrollPane);
		// Colunas da tabela.
		String[] colunas = { "Data", "Livros", "NIF do Cliente", "Valor", "Tipo de Pag." };
		DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
		JTable table = new JTable(modeloTabela);
		table.setAutoCreateRowSorter(true);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		TableColumnModel col = table.getColumnModel();
		col.getColumn(0).setMaxWidth(100);
		col.getColumn(1).setMaxWidth(516);
		col.getColumn(2).setMaxWidth(100);
		col.getColumn(3).setMaxWidth(50);
		col.getColumn(4).setMaxWidth(100);
		for (VCI_cl_Compra c : g.listaCompras) { // Forma��o das linhas da tabela.
			if (c.getData().after(di) && c.getData().before(df)) {
				GregorianCalendar d = c.getData();
				String data = d.get(Calendar.DAY_OF_MONTH) + "/" + (d.get(Calendar.MONTH) + 1) + "/"
						+ d.get(Calendar.YEAR);
				String l = g.obterLivros(c.getCarrinho().getListaCompras(), c.getCarrinho().getQuantLivros());
				int n = c.getNif();
				double v = c.getValor();
				String p = "";
				if (c instanceof VCI_cl_Dinheiro) {
					p = "Dinheiro";
				} else {
					p = "Cart�o";
				}
				Object[] venda = { data, l, n, v, p }; // Linha da tabela.
				modeloTabela.addRow(venda); // Adi��o da linha � tabela.
			}
		}
		scrollPane.setViewportView(table);
		if (table.getRowCount() == 0) {
			JOptionPane.showMessageDialog(frame, "N�o existem vendas para o per�odo selecionado.");
			
		}
			
		JLabel lblCliqueNasColunas = new JLabel("Clique nas colunas para reordenar os livros");
		lblCliqueNasColunas.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCliqueNasColunas.setBounds(10, 47, 416, 24);
		panel.add(lblCliqueNasColunas);
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