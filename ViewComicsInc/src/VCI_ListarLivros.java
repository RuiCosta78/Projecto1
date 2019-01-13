import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import java.awt.Color;

/**
 * Breve descrição do código
 * 
 * @sid 2001
 * @aid 1.1
 */

public class VCI_ListarLivros {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private VCI_cl_Gestao g;
	private ArrayList<VCI_cl_Livro> livrosSel = new ArrayList<>();
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public VCI_ListarLivros(VCI_cl_Gestao g) {
		this.g = g;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rmmi7\\git\\Projecto1\\VC_Logotipo.jpg"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel ListaLivros = new JPanel();
		frame.getContentPane().add(ListaLivros, "ListaLivros");
		ListaLivros.setLayout(null);

		JLabel label = new JLabel("VIEW COMICS INC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label.setBounds(10, 0, 416, 30);
		ListaLivros.add(label);

		JLabel lblListagemDeLivros = new JLabel("Listagem de livros");
		lblListagemDeLivros.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblListagemDeLivros.setBounds(10, 30, 416, 24);
		ListaLivros.add(lblListagemDeLivros);

		JLabel lblListrLivrosPor = new JLabel("Listar livros por:");
		lblListrLivrosPor.setHorizontalAlignment(SwingConstants.LEFT);
		lblListrLivrosPor.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblListrLivrosPor.setBounds(10, 58, 117, 23);
		ListaLivros.add(lblListrLivrosPor);

		if (g.listaLivros.size() == 0) {
			g.abrirLivros();
		}
		// COMBOBOX EM FUNÇÃO DO BOTÃO SELECIONADO
		JComboBox<String> comboBox = new JComboBox<String>();
		// CONJUNTO DE BOTÕES com listagem da COMBOBOX para cada botão
		JRadioButton rdbtnAutor = new JRadioButton("Autor");
		rdbtnAutor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (rdbtnAutor.isSelected()) {
					Set<String> autores = new TreeSet<String>();
					for (VCI_cl_Livro l : g.listaLivros) {
						autores.add(l.getAutor());
					}
					comboBox.removeAllItems();
					for (String a : autores) {
						comboBox.addItem(a);
					}
				}
			}
		});
		buttonGroup.add(rdbtnAutor);
		rdbtnAutor.setBounds(133, 60, 90, 23);
		ListaLivros.add(rdbtnAutor);

		JRadioButton rdbtnEditora = new JRadioButton("Editora");
		rdbtnEditora.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (rdbtnEditora.isSelected()) {
					Set<String> editoras = new TreeSet<String>();
					for (VCI_cl_Livro l : g.listaLivros) {
						editoras.add(l.getEditora());
					}
					comboBox.removeAllItems();
					for (String e : editoras) {
						comboBox.addItem(e);
					}
				}
			}
		});
		buttonGroup.add(rdbtnEditora);
		rdbtnEditora.setBounds(262, 60, 111, 23);
		ListaLivros.add(rdbtnEditora);

		JRadioButton rdbtnAnoDeEdio = new JRadioButton("Ano de edi\u00E7\u00E3o");
		rdbtnAnoDeEdio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (rdbtnAnoDeEdio.isSelected()) {
					Set<Integer> anos = new TreeSet<Integer>();
					for (VCI_cl_Livro l : g.listaLivros) {
						anos.add(l.getAnoEdicao());
					}
					comboBox.removeAllItems();
					for (int ano : anos) {
						comboBox.addItem(String.valueOf(ano));
					}
				}
			}
		});
		buttonGroup.add(rdbtnAnoDeEdio);
		rdbtnAnoDeEdio.setBounds(133, 86, 117, 23);
		ListaLivros.add(rdbtnAnoDeEdio);

		JRadioButton rdbtnPreoMximo = new JRadioButton("Pre\u00E7o m\u00E1ximo");
		rdbtnPreoMximo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				comboBox.removeAllItems();
				if (rdbtnPreoMximo.isSelected()) {
					comboBox.addItem("10 €");
					comboBox.addItem("20 €");
					comboBox.addItem("30 €");
					comboBox.addItem("40 €");
					comboBox.addItem("50 €");
					comboBox.addItem("Superior a 50 €");
				}
			}
		});
		buttonGroup.add(rdbtnPreoMximo);
		rdbtnPreoMximo.setBounds(262, 86, 111, 23);
		ListaLivros.add(rdbtnPreoMximo);

		comboBox.setBounds(10, 117, 416, 22);
		ListaLivros.add(comboBox);

		JRadioButton rdbtnTitulo = new JRadioButton("Titulo");
		buttonGroup.add(rdbtnTitulo);
		rdbtnTitulo.setBounds(143, 168, 90, 23);
		ListaLivros.add(rdbtnTitulo);

		JRadioButton rdbtnIsbn = new JRadioButton("ISBN");
		buttonGroup.add(rdbtnIsbn);
		rdbtnIsbn.setBounds(272, 168, 111, 23);
		ListaLivros.add(rdbtnIsbn);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 191, 416, 20);
		ListaLivros.add(textField);

		// VOLTAR
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				if (VCI_cl_Gestao.utilizador instanceof VCI_cl_Admin) {
					VCI_ADMIN window = null;
					try {
						window = new VCI_ADMIN(g);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					window.getFrames(); // Ativa a janela a que o botão dá acesso;
				} else if (VCI_cl_Gestao.utilizador instanceof VCI_cl_Vendedor) {
					VCI_VENDEDOR window = new VCI_VENDEDOR(g);
					window.getFrame(); // Ativa a janela a que o botão dá acesso;
				} else {
					VCI_Cliente_Op window = new VCI_Cliente_Op(g);
					window.getFrame(); // Ativa a janela a que o botão dá acesso;
				}
			}
		});
		button.setBounds(10, 222, 89, 30);
		ListaLivros.add(button);

		// CONFIRMAR
		JFrame caixa = new JFrame();
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (buttonGroup.getSelection() == null) {
					JOptionPane.showMessageDialog(caixa, "Escolher um critério de seleção.");
				} else {
					// Formação da lista de livros que correespondem ao item selecionado na
					// comboBox, esvaziando a lista de quaisquer seleções prévias:
					livrosSel.clear();
					if (rdbtnAutor.isSelected()) {
						for (VCI_cl_Livro l : g.listaLivros) {
							if ((l.getAutor()).equals(comboBox.getSelectedItem().toString())) {
								livrosSel.add(l);
							}
						}
					} else if (rdbtnEditora.isSelected()) {
						for (VCI_cl_Livro l : g.listaLivros) {
							if ((l.getEditora()).equals(comboBox.getSelectedItem().toString())) {
								livrosSel.add(l);
							}
						}
					} else if (rdbtnAnoDeEdio.isSelected()) {
						for (VCI_cl_Livro l : g.listaLivros) {
							if (String.valueOf(l.getAnoEdicao()).equals(comboBox.getSelectedItem().toString())) {
								livrosSel.add(l);
							}
						}
					} else if (rdbtnPreoMximo.isSelected()) {
						double preco = 0.0;
						if (comboBox.getSelectedItem().toString().equals("10 €")) {
							preco = 10.00;
						} else if (comboBox.getSelectedItem().toString().equals("20 €")) {
							preco = 20.00;
						} else if (comboBox.getSelectedItem().toString().equals("30 €")) {
							preco = 30.00;
						} else if (comboBox.getSelectedItem().toString().equals("40 €")) {
							preco = 40.00;
						} else if (comboBox.getSelectedItem().toString().equals("50 €")) {
							preco = 50.00;
						} else if (comboBox.getSelectedItem().toString().equals("Superior a 50 €")) {
							preco = 51.00;
						}
						if (preco <= 50) {
							for (VCI_cl_Livro l : g.listaLivros) {
								if (l.getPreco() <= preco) {
									livrosSel.add(l);
								}
							}
						} else {
							for (VCI_cl_Livro l : g.listaLivros) {
								if (l.getPreco() > 50.00) {
									livrosSel.add(l);
								}
							}
						}
					} else if (rdbtnTitulo.isSelected()) {
						for (VCI_cl_Livro l : g.listaLivros) {
							if (String.valueOf(l.getTitulo()).equalsIgnoreCase(textField.getText())) {
								livrosSel.add(l);
							}
						}
					} else if (rdbtnIsbn.isSelected()) {
						for (VCI_cl_Livro l : g.listaLivros) {
							if (String.valueOf(l.getIsbn()).equals(textField.getText())) {
								livrosSel.add(l);
							}
						}
					}
					if (livrosSel.size() == 0) {
						JOptionPane.showMessageDialog(caixa,
								"Não foram encontrados livros correspondentes à pesquisa.");
					} else {
						VCI_TabListaLiv window = new VCI_TabListaLiv(g, livrosSel);
						window.getFrame().setVisible(true); // Ativa a janela para exibir a lista de livros.
					}
				}
			}
		});
		btnProcurar.setBounds(321, 222, 105, 30);
		ListaLivros.add(btnProcurar);

		JLabel label_1 = new JLabel("Pesquisar livro por:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		label_1.setBounds(10, 167, 139, 23);
		ListaLivros.add(label_1);

		JLabel lblOu = new JLabel("Ou");
		lblOu.setHorizontalAlignment(SwingConstants.LEFT);
		lblOu.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblOu.setBounds(10, 145, 139, 23);
		ListaLivros.add(lblOu);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
