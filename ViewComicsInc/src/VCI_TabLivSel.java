import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

/**   
 * Breve descrição do código
 *  
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_TabLivSel {

	private JFrame frame;
	private VCI_cl_Gestao g;
	private VCI_cl_Livro livroSelecionado;
	private ArrayList<VCI_cl_Livro> listaLiv;
	private JTable table;

		/**
	 * Create the application.
	 */
	public VCI_TabLivSel(VCI_cl_Gestao g, ArrayList<VCI_cl_Livro> listaLiv) {
		this.g = g;
		this.listaLiv = listaLiv;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rmmi7\\OneDrive\\Documentos\\Acertar o Rumo\\Aulas\\Projeto\\Relat\u00F3rio preliminar\\VC_Logotipo.jpg"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("VIEW COMICS INC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label.setBounds(10, 0, 416, 30);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Listagem de livros selecionados");
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_1.setBounds(10, 30, 416, 24);
		panel.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 416, 147);
		panel.add(scrollPane);
		// Colunas da tabela.
		String[] colunas = { "Título", "Autor", "Editora", "ISBN", "Ano de Edição", "Preço" };
		DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0);
		JTable table = new JTable(modeloTabela);
		//table.setAutoCreateRowSorter(true);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		for (VCI_cl_Livro l : listaLiv) { // Formação das linhas da tabela.
			String t = l.getTitulo();
			String a = l.getAutor();
			String ed = l.getEditora();
			String isbn = l.getIsbn();
			int ano = l.getAnoEdicao();
			double p = l.getPreco();
			Object[] livro = { t, a, ed, isbn, ano, p }; // Linha da tabela.
			modeloTabela.addRow(livro); // Adição da linha à tabela.
		}
		scrollPane.setViewportView(table);
		
		JButton button_1 = new JButton("Selecionar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = table.getSelectedRow(); // número da linha selecionada.
				if (n >= 0) { // isbn da linha selecionada (4.ª coluna, posição 3).
					String isbnSel = table.getModel().getValueAt(n, 3).toString(); 
					for (VCI_cl_Livro l : listaLiv) {
						if (l.getIsbn().equals(isbnSel)) {
							livroSelecionado = l;
						}
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Nenhum livro selecionado.");
				}
				frame.dispose();
				VCI_EdLivro1 window = new VCI_EdLivro1(g, livroSelecionado);
				window.getFrame().setVisible(true);; // Ativa a janela a que o botão
				}
		});
		button_1.setBounds(321, 229, 105, 23);
		panel.add(button_1);
		
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
				card.show(window.getContentPane(), "EdLivro");
			}
		});
		button.setBounds(10, 229, 89, 23);
		panel.add(button);
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

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
}
