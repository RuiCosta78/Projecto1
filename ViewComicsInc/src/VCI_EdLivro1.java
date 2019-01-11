import java.awt.event.*;
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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.Year;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

/**
 * Breve descrição do código
 * 
 * @sid 2001
 * @aid 1.1
 */

public class VCI_EdLivro1 {

	private JFrame frame;
	private VCI_cl_Gestao g;
	private VCI_cl_Livro liv;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the application.
	 */
	public VCI_EdLivro1(VCI_cl_Gestao g, VCI_cl_Livro liv) {
		this.g = g;
		this.liv = liv;
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

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel label = new JLabel("VIEW COMICS INC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label.setBounds(10, 0, 416, 30);
		panel.add(label);

		JLabel label_1 = new JLabel("Editar dados de um livro");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_1.setBounds(10, 31, 416, 20);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Selecionou o livro:");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		label_2.setBounds(10, 55, 136, 20);
		panel.add(label_2);

		JLabel label_3 = new JLabel(liv.getTitulo());
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		label_3.setBounds(128, 55, 298, 20);
		panel.add(label_3);

		JLabel label_4 = new JLabel("Selecione o campo a corrigir/editar:");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		label_4.setBounds(10, 74, 302, 20);
		panel.add(label_4);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 152, 406, 22);
		panel.add(comboBox);

		JRadioButton rdbtnTtulo = new JRadioButton("T\u00EDtulo");
		buttonGroup.add(rdbtnTtulo);
		rdbtnTtulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnTtulo.isSelected()) {
					comboBox.removeAllItems();;
					comboBox.addItem(liv.getTitulo());
				}
			}
		});
		rdbtnTtulo.setBounds(20, 101, 58, 23);
		panel.add(rdbtnTtulo);
	
		JRadioButton rdbtnAutor = new JRadioButton("Autor");
		buttonGroup.add(rdbtnAutor);
		rdbtnAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnAutor.isSelected()) {
					comboBox.removeAllItems();
					comboBox.addItem(liv.getAutor());
				}
			}
		});
		rdbtnAutor.setBounds(81, 101, 65, 23);
		panel.add(rdbtnAutor);

		JRadioButton rdbtnEditora = new JRadioButton("Editora");
		buttonGroup.add(rdbtnEditora);
		rdbtnEditora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnEditora.isSelected()) {
					comboBox.removeAllItems();
					comboBox.addItem(liv.getEditora());
				}
			}
		});
		rdbtnEditora.setBounds(148, 101, 71, 23);
		panel.add(rdbtnEditora);
		
		JRadioButton rdbtnIsbn = new JRadioButton("ISBN");
		buttonGroup.add(rdbtnIsbn);
		rdbtnIsbn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnIsbn.isSelected()) {
					comboBox.removeAllItems();
					comboBox.addItem(liv.getIsbn());
				}
			}
		});
		rdbtnIsbn.setBounds(224, 101, 65, 23);
		panel.add(rdbtnIsbn);
		
		JRadioButton rdbtnAnoDeEdio = new JRadioButton("Ano de Edi\u00E7\u00E3o");
		buttonGroup.add(rdbtnAnoDeEdio);
		rdbtnAnoDeEdio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnAnoDeEdio.isSelected()) {
					comboBox.removeAllItems();
					comboBox.addItem(String.valueOf(liv.getAnoEdicao()));
				}
			}
		});
		rdbtnAnoDeEdio.setBounds(297, 101, 118, 23);
		panel.add(rdbtnAnoDeEdio);
		
		JRadioButton rdbtnPreo = new JRadioButton("Pre\u00E7o");
		buttonGroup.add(rdbtnPreo);
		rdbtnPreo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnPreo.isSelected()) {
					comboBox.removeAllItems();
					comboBox.addItem(String.valueOf(liv.getPreco()));
				}
			}
		});
		rdbtnPreo.setBounds(224, 127, 65, 23);
		panel.add(rdbtnPreo);
		
		JRadioButton rdbtnStock = new JRadioButton("Stock");
		buttonGroup.add(rdbtnStock);
		rdbtnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnStock.isSelected()) {
					comboBox.removeAllItems();
					comboBox.addItem(String.valueOf(liv.getQuantidade()));
				}
			}
		});
		rdbtnStock.setBounds(297, 129, 65, 23);
		panel.add(rdbtnStock);

		JLabel label_5 = new JLabel("Introduza os dados corrigidos:");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		label_5.setBounds(10, 175, 213, 20);
		panel.add(label_5);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 197, 406, 20);
		panel.add(textField);

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

		JButton button_1 = new JButton("Confirmar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem().toString().equals("Título")) {
					for (VCI_cl_Livro l : g.listaLivros) {
						if (l == liv) { // Variável livroSelecionado já definida.
							l.setTitulo(textField.getText());
						}
					}
				} else if (comboBox.getSelectedItem().toString().equals("Autor")) {
					for (VCI_cl_Livro l : g.listaLivros) {
						if (l == liv) { // Variável livroSelecionado já definida.
							l.setAutor(textField.getText());
						}
					}
				} else if (comboBox.getSelectedItem().toString().equals("Editora")) {
					for (VCI_cl_Livro l : g.listaLivros) {
						if (l == liv) { // Variável livroSelecionado já definida.
							l.setEditora(textField.getText());
						}
					}
				} else if (comboBox.getSelectedItem().toString().equals("ISBN")) {
					for (VCI_cl_Livro l : g.listaLivros) {
						if (l == liv) { // Variável livroSelecionado já definida.
							l.setIsbn(textField.getText());
						}
					}
				} else if (comboBox.getSelectedItem().toString().equals("Ano da Edição")) {
					int anoAtual = Year.now().getValue();
					int ano = Integer.parseInt(textField.getText());
					if (ano >= 1900 && ano <= anoAtual) {
						for (VCI_cl_Livro l : g.listaLivros) {
							if (l == liv) { // Variável livroSelecionado já definida.
								l.setanoEdicao(ano);
							}
						}
					} else {
						JOptionPane.showMessageDialog(frame,
								"O ano de edição deverá situar-se entre 1900 e o ano corrente.");
					}
				} else if (comboBox.getSelectedItem().toString().equals("Preço")) {
					double p = Double.parseDouble(textField.getText());
					if (p > 0) {
						for (VCI_cl_Livro l : g.listaLivros) {
							if (l == liv) { // Variável livroSelecionado já definida.
								l.setPreco(p);
							}
						}
					} else {
						JOptionPane.showMessageDialog(frame, "O preço não pode ser nulo ou negativo.");
					}
				} else if (comboBox.getSelectedItem().toString().equals("Quantidade")) {
					int q = Integer.parseInt(textField.getText());
					if (q >= 0) {
						for (VCI_cl_Livro l : g.listaLivros) {
							if (l == liv) { // Variável livroSelecionado já definida.
								l.setQuantidade(q);
							}
						}
					} else {
						JOptionPane.showMessageDialog(frame,
								"A quantidade de livros tem de ser um inteiro não negativo.");
					}
					// Gravação da lista de livros com a alteração
					try {
						g.gravarLivros();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					frame.dispose(); // Troca de janela.
					VCI_ADMIN window = null;
					try {
						window = new VCI_ADMIN(g);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					window.getFrames();
				} else {
					if (textField.getText().equals("")) { // Verificação que foi introduzida correção.
						JOptionPane.showMessageDialog(frame,
								"Introduza a correção correspondente ao campo selecionado.");
					}
				}
			}
		});
		button_1.setBounds(316, 229, 100, 23);
		panel.add(button_1);
		
		
		JLabel lblDadosAtuais = new JLabel("Dados atuais:");
		lblDadosAtuais.setHorizontalAlignment(SwingConstants.LEFT);
		lblDadosAtuais.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblDadosAtuais.setBounds(10, 129, 136, 20);
		panel.add(lblDadosAtuais);
		
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

	public VCI_cl_Livro getLiv() {
		return liv;
	}

	public void setLiv(VCI_cl_Livro liv) {
		this.liv = liv;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
}
