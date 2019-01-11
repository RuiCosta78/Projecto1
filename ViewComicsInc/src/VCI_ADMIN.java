import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Color;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Breve descrição do código
 * 
 * @sid 2001
 * @aid 1.1
 */

public class VCI_ADMIN extends JFrame {

	private JPanel main;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_6;
	private JTextField textField_10;
	private VCI_cl_Gestao g;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_11;
	private ArrayList<VCI_cl_Livro> listaSel = new ArrayList<VCI_cl_Livro>();
	private VCI_cl_Livro livroSelecionado = null;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	boolean estAtual;

	public VCI_ADMIN(VCI_cl_Gestao g) throws IOException {
		this.g = g;
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\rmmi7\\OneDrive\\Documentos\\Acertar o Rumo\\Aulas\\Projeto\\Relat\u00F3rio preliminar\\VC_Logotipo.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		main = new JPanel();
		main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(main);
		main.setLayout(new CardLayout(0, 0));

		JFrame caixa = new JFrame();

		JPanel opcoes = new JPanel();
		main.add(opcoes, "Opcoes");
		opcoes.setLayout(null);
		setVisible(true);

		JLabel label = new JLabel("VIEW COMICS INC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label.setBounds(0, 0, 416, 30);
		opcoes.add(label);

		JLabel label_1 = new JLabel("Benvindo!");
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_1.setBounds(10, 30, 111, 24);
		opcoes.add(label_1);

		JLabel label_2 = new JLabel("Selecione uma op\u00E7\u00E3o:");
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_2.setBounds(10, 54, 196, 24);
		opcoes.add(label_2);

		// ALTERAR LOGIN
		JButton button = new JButton("Alterar login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose(); // Desliga a janela atual das opções.
				VCI_LoginAlt window = new VCI_LoginAlt(g);
				window.getFrame(); // Ativa a janela para alterar o login.
			}
		});
		button.setBounds(0, 89, 143, 23);
		opcoes.add(button);

		// REGISTAR VENDEDOR
		JButton button_1 = new JButton("Registar Vendedor");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) main.getLayout();
				card.show(main, "regVendedor");
				// setVisible(true);
			}
		});
		button_1.setBounds(0, 123, 143, 23);
		opcoes.add(button_1);

		// ATUALIZAR VENDEDOR
		JButton button_2 = new JButton("Atualizar Vendedor");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cont = 0;
				for (VCI_cl_Utilizador u : g.listaUtilizadores) {
					if (u instanceof VCI_cl_Vendedor) {
						cont++;
					}
				}
				if (cont == 0) {
					JOptionPane.showMessageDialog(caixa, "Não existem vendedores registados.");
				} else {
					CardLayout card = (CardLayout) main.getLayout();
					card.show(main, "AtVendedor");
				}
			}
		});
		button_2.setBounds(0, 157, 150, 23);
		opcoes.add(button_2);

		// LOGOUT
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose(); // desliga a janela ativa das opções.
				VCI_cl_Gestao.utilizador = null;
				VCI_Login window = new VCI_Login(g);
				window.getFrame().setVisible(true); // Liga a janela do login.
			}
		});
		btnLogout.setBounds(293, 219, 133, 23);
		opcoes.add(btnLogout);

		// ADICIONAR LIVRO
		JButton button_4 = new JButton("Adicionar livro");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) main.getLayout();
				card.show(main, "NovoLivro");
			}
		});
		button_4.setBounds(151, 89, 133, 23);
		opcoes.add(button_4);

		// LISTAR LIVROS
		JButton btnPesquisarLivros = new JButton("Pesquisar livros");
		btnPesquisarLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g.abrirLivros();
				if (g.listaLivros.size() > 0) {
					dispose(); // desliga a janela ativa das opções.
					VCI_ListarLivros window = new VCI_ListarLivros(g);
					window.getFrame().setVisible(true); // Liga a janela ListarLivros.
				} else {
					JOptionPane.showMessageDialog(caixa, "Não existem livros registados.");
				}
			}
		});
		btnPesquisarLivros.setBounds(293, 89, 133, 23);
		opcoes.add(btnPesquisarLivros);

		// EDITAR LIVRO
		JButton button_6 = new JButton("Editar livro");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g.abrirLivros();
				if (g.listaLivros.size() > 0) {
					CardLayout card = (CardLayout) main.getLayout();
					card.show(main, "EdLivro");
				} else {
					JOptionPane.showMessageDialog(caixa, "Não existem livros registados.");
				}
			}
		});
		button_6.setBounds(151, 123, 133, 23);
		opcoes.add(button_6);

		// LISTAR VENDAS
		JButton button_9 = new JButton("Listar vendas");
		button_9.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				if (g.listaCompras.size() == 0) {
					g.abrirCompras();
				}
				if (g.listaCompras.size() > 0) {
					CardLayout card = (CardLayout) main.getLayout();
					card.show(main, "ListarVendas");
				} else {
					JOptionPane.showMessageDialog(caixa, "Não existem registos de vendas.");
				}
			}
		});
		button_9.setBounds(293, 123, 133, 23);
		opcoes.add(button_9);
// FIM DAS OPÇÕES
// INÍCIO_REGISTAR VENDEDOR	(ANT. - OPÇÕES; PRÓX. - AT_VENDEDOR)	
		JPanel regVendedor = new JPanel();
		main.add(regVendedor, "regVendedor");
		regVendedor.setLayout(null);

		JLabel label_3 = new JLabel("VIEW COMICS INC");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_3.setBounds(0, 0, 416, 30);
		regVendedor.add(label_3);

		JLabel label_4 = new JLabel("Registar vendedor");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_4.setBounds(0, 28, 239, 30);
		regVendedor.add(label_4);

		JLabel label_5 = new JLabel("Introduza o nome do novo colaborador:");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		label_5.setBounds(0, 58, 416, 30);
		regVendedor.add(label_5);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(0, 85, 416, 20);
		regVendedor.add(textField);

		JLabel lblColaboradorEmAtividade_1 = new JLabel("Colaborador em atividade:");
		lblColaboradorEmAtividade_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblColaboradorEmAtividade_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblColaboradorEmAtividade_1.setBounds(0, 108, 162, 30);
		regVendedor.add(lblColaboradorEmAtividade_1);

		JLabel label_7 = new JLabel("Correio eletr\u00F3nico para login no sistema:");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		label_7.setBounds(0, 133, 253, 30);
		regVendedor.add(label_7);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(254, 170, 162, 20);
		regVendedor.add(textField_1);

		JLabel label_8 = new JLabel("Senha para login no sistema (m\u00EDn 8 car.):");
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		label_8.setBounds(0, 163, 253, 30);
		regVendedor.add(label_8);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(254, 139, 162, 20);
		regVendedor.add(textField_2);

		JLabel label_9 = new JLabel("O novo colaborador dever\u00E1 alterar os dados de acesso no 1.\u00BA login.");
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		label_9.setBounds(0, 190, 416, 30);
		regVendedor.add(label_9);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addItem("SIM");
		comboBox_1.addItem("NÃO");
		comboBox_1.setBounds(175, 116, 65, 22);
		regVendedor.add(comboBox_1);

		// VOLTAR do REG_ADMIN
		JButton button_11 = new JButton("Voltar");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) main.getLayout();
				card.previous(main);
			}
		});
		button_11.setBounds(0, 230, 89, 23);
		regVendedor.add(button_11);

		// CONFIRMAR em NOVO VENDEDOR
		JButton button_12 = new JButton("Confirmar");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame caixa = new JFrame();
				boolean n = false;
				String nomeNovo = textField.getText(); // lê o utilizador introduzido
				if (nomeNovo.equals("")) {
					JOptionPane.showMessageDialog(caixa, "Nome não introduzido.");
				} else {
					n = true;
				}
				String email = textField_2.getText(); // lê o email introduzido
				boolean e = false;
				String senha = textField_1.getText(); // lê a password introduzida
				boolean sn = false;
				if (g.validarEmail(email)) { // Verifica o formato do email.
					e = true;
				} else {
					JOptionPane.showMessageDialog(caixa,
							"Endereço de email inválido (introduzir na forma _@_.com ou _@_.pt");
				}
				if (senha.length() >= 8) {
					sn = true; // Verifica o tamanho mínimo da senha.
				} else {
					JOptionPane.showMessageDialog(caixa, "Senha sem o número mínimo de caracteres.");
				}
				boolean est = false;
				if (comboBox_1.getSelectedItem().toString().equals("SIM")) {
					est = true;
				}
				if (n == true && e == true && sn == true) {
					try {
						g.registarVendedor(nomeNovo, email, senha, est);
						JOptionPane.showMessageDialog(caixa, "Registado o vendedor " + nomeNovo + ".");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				CardLayout card = (CardLayout) main.getLayout();
				card.first(main);
			}
		});
		button_12.setBounds(316, 230, 100, 23);
		regVendedor.add(button_12);
// FIM_REGISTAR VENDEDOR
// INÍCIO_ ATUALIZAR VENDEDOR
		JPanel AtVendedor = new JPanel();
		main.add(AtVendedor, "AtVendedor");
		AtVendedor.setLayout(null);

		JLabel label_10 = new JLabel("VIEW COMICS INC");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_10.setBounds(10, 0, 416, 30);
		AtVendedor.add(label_10);

		JLabel lblAtualizarDadosDe = new JLabel("Atualizar dados de vendedor");
		lblAtualizarDadosDe.setHorizontalAlignment(SwingConstants.LEFT);
		lblAtualizarDadosDe.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblAtualizarDadosDe.setBounds(10, 24, 310, 30);
		AtVendedor.add(lblAtualizarDadosDe);

		// COMBOBOX com a listagem dos vendedores
		JLabel lblEscolhaOColaborador = new JLabel("Escolha o colaborador:");
		lblEscolhaOColaborador.setHorizontalAlignment(SwingConstants.LEFT);
		lblEscolhaOColaborador.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblEscolhaOColaborador.setBounds(10, 53, 416, 22);
		AtVendedor.add(lblEscolhaOColaborador);
		JComboBox<String> comboBox = new JComboBox<String>();
		for (VCI_cl_Utilizador v : g.listaUtilizadores) {
			if (v instanceof VCI_cl_Vendedor) {
				comboBox.addItem(v.getNome());
			}
		}
		comboBox.setBounds(10, 75, 406, 22);
		AtVendedor.add(comboBox);

		JLabel lblColaboradorEmAtividade = new JLabel("Estado atual:");
		lblColaboradorEmAtividade.setHorizontalAlignment(SwingConstants.LEFT);
		lblColaboradorEmAtividade.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblColaboradorEmAtividade.setBounds(10, 100, 129, 19);
		AtVendedor.add(lblColaboradorEmAtividade);

		// INDICAÇÃO DO ESTADO DO VENDEDOR
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(115, 100, 111, 19);
		AtVendedor.add(lblNewLabel);
		int cont = 0;
		for (VCI_cl_Utilizador u : g.listaUtilizadores) {
			if (u instanceof VCI_cl_Vendedor) {
				cont++;
			}
		}
		if (cont > 0) {
			for (VCI_cl_Utilizador u : g.listaUtilizadores) {
				if (comboBox.getSelectedItem().toString().equals(u.getNome()) && u instanceof VCI_cl_Vendedor) {
					estAtual = ((VCI_cl_Vendedor) u).isEstado();
					if (((VCI_cl_Vendedor) u).isEstado() == true) {
						lblNewLabel.setText("ATIVO");
					} else {
						lblNewLabel.setText("INATIVO");
					}
				}
			}
		}

		JLabel lblAtualizarApenasOs = new JLabel("Atualizar apenas os dados necess\u00E1rios");
		lblAtualizarApenasOs.setHorizontalAlignment(SwingConstants.LEFT);
		lblAtualizarApenasOs.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblAtualizarApenasOs.setBounds(10, 118, 416, 22);
		AtVendedor.add(lblAtualizarApenasOs);

		JLabel lblEditarONome = new JLabel("Editar o nome do colaborador:");
		lblEditarONome.setHorizontalAlignment(SwingConstants.LEFT);
		lblEditarONome.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblEditarONome.setBounds(10, 138, 416, 22);
		AtVendedor.add(lblEditarONome);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 163, 406, 20);
		AtVendedor.add(textField_3);

		JLabel lblEditarOEstado = new JLabel("Alterar o estado do colaborador:");
		lblEditarOEstado.setHorizontalAlignment(SwingConstants.LEFT);
		lblEditarOEstado.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblEditarOEstado.setBounds(10, 176, 416, 30);
		AtVendedor.add(lblEditarOEstado);

		// VOLTAR em AT_VENDEDOR
		JButton button_13 = new JButton("Voltar");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) main.getLayout();
				card.first(main);
			}
		});
		button_13.setBounds(0, 230, 89, 23);
		AtVendedor.add(button_13);

		JRadioButton rdbtnAtivo = new JRadioButton("Ativo");
		buttonGroup_1.add(rdbtnAtivo);
		rdbtnAtivo.setBounds(10, 200, 111, 23);
		AtVendedor.add(rdbtnAtivo);

		JRadioButton rdbtnInativo = new JRadioButton("Inativo");
		buttonGroup_1.add(rdbtnInativo);
		rdbtnInativo.setBounds(131, 200, 111, 23);
		AtVendedor.add(rdbtnInativo);

		// CONFIRMAR PARA ATUALIZAR VENDEDOR
		JButton button_14 = new JButton("Confirmar");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomeSel = comboBox.getSelectedItem().toString();
				boolean novoEst = false;
				if (!buttonGroup_1.isSelected(null)) {
					if (rdbtnAtivo.isSelected()) {
						novoEst = true;
					} else if (rdbtnInativo.isSelected()) {
						novoEst = false;
					}
					try {
						g.alterarEstado(nomeSel, novoEst);
						JOptionPane.showMessageDialog(caixa, "Estado do colaborador alterado.");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				String nomeCorrigido = textField_3.getText();
				if (!nomeCorrigido.equals("")) {
					try {
						g.corrigirNome(nomeSel, nomeCorrigido);
						JOptionPane.showMessageDialog(caixa, "Nome do colaborador atualizado.");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				textField_3.setText("");
				CardLayout card = (CardLayout) main.getLayout();
				card.first(main);
			}
		});
		button_14.setBounds(316, 230, 100, 23);
		AtVendedor.add(button_14);

// FIM_ATUALIZAR VENDEDOR
// INÍCIO_NOVO LIVRO
		JPanel NovoLivro = new JPanel();
		main.add(NovoLivro, "NovoLivro");
		NovoLivro.setLayout(null);

		JLabel label_12 = new JLabel("VIEW COMICS INC");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_12.setBounds(10, 0, 416, 30);
		NovoLivro.add(label_12);

		JLabel lblAdicionarNovoLivro = new JLabel("Adicionar novo livro para venda");
		lblAdicionarNovoLivro.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdicionarNovoLivro.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblAdicionarNovoLivro.setBounds(10, 23, 310, 30);
		NovoLivro.add(lblAdicionarNovoLivro);

		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTtulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblTtulo.setBounds(10, 41, 416, 30);
		NovoLivro.add(lblTtulo);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 68, 406, 20);
		NovoLivro.add(textField_4);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setHorizontalAlignment(SwingConstants.LEFT);
		lblAutor.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblAutor.setBounds(10, 82, 81, 30);
		NovoLivro.add(lblAutor);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(10, 109, 200, 20);
		NovoLivro.add(textField_5);

		JLabel lblEditora = new JLabel("Editora:");
		lblEditora.setHorizontalAlignment(SwingConstants.LEFT);
		lblEditora.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblEditora.setBounds(216, 82, 87, 30);
		NovoLivro.add(lblEditora);

		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setHorizontalAlignment(SwingConstants.LEFT);
		lblIsbn.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblIsbn.setBounds(10, 123, 56, 30);
		NovoLivro.add(lblIsbn);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(10, 150, 200, 20);
		NovoLivro.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(216, 150, 200, 20);
		NovoLivro.add(textField_8);

		JLabel lblAnoDeEdio = new JLabel("Ano de edi\u00E7\u00E3o:");
		lblAnoDeEdio.setHorizontalAlignment(SwingConstants.LEFT);
		lblAnoDeEdio.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblAnoDeEdio.setBounds(220, 123, 180, 30);
		NovoLivro.add(lblAnoDeEdio);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(216, 109, 200, 20);
		NovoLivro.add(textField_9);

		JLabel lblPreoDeVenda = new JLabel("Pre\u00E7o de venda ao p\u00FAblico:");
		lblPreoDeVenda.setHorizontalAlignment(SwingConstants.LEFT);
		lblPreoDeVenda.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblPreoDeVenda.setBounds(10, 164, 180, 30);
		NovoLivro.add(lblPreoDeVenda);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(10, 191, 200, 20);
		NovoLivro.add(textField_6);

		JLabel lblQuantidadeEmStock = new JLabel("Quantidade em stock:");
		lblQuantidadeEmStock.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantidadeEmStock.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblQuantidadeEmStock.setBounds(216, 164, 180, 30);
		NovoLivro.add(lblQuantidadeEmStock);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(216, 191, 200, 20);
		NovoLivro.add(textField_10);

		// VOLTAR do ADICIONAR LIVRO
		JButton button_15 = new JButton("Voltar");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) main.getLayout();
				card.first(main);
			}
		});
		button_15.setBounds(10, 230, 89, 23);
		NovoLivro.add(button_15);

		// CONFIRMAR A ADIÇÃO DE NOVO LIVRO
		JButton button_16 = new JButton("Confirmar");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame caixa = new JFrame();
				String titulo = textField_4.getText(); // Título do livro
				boolean t = false;
				String autor = textField_5.getText(); // Autor do livro
				boolean a = false;
				String editora = textField_9.getText(); // Editora do livro
				boolean e = false;
				String isbn = textField_7.getText(); // ISBN do livro
				boolean i = false;
				int ano = Integer.parseInt(textField_8.getText()); // Ano do livro
				boolean an = false;
				double preco = Double.parseDouble(textField_6.getText()); // Preço do livro
				boolean p = false;
				int quant = Integer.parseInt(textField_10.getText()); // Quantidade de exemplares
				boolean q = false;
				if (!titulo.equals("")) {
					t = true;
				} else {
					JOptionPane.showMessageDialog(caixa, "Título não introduzido.");
				}
				if (!autor.equals("")) {
					a = true;
				} else {
					JOptionPane.showMessageDialog(caixa, "Autor não introduzido.");
				}
				if (!editora.equals("")) {
					e = true;
				} else {
					JOptionPane.showMessageDialog(caixa, "Editora não introduzida.");
				}
				if (!isbn.equals("")) {
					i = true;
				} else {
					JOptionPane.showMessageDialog(caixa, "ISBN não introduzido.");
				}
				int anoAtual = Year.now().getValue();
				if (ano >= 1900 && ano <= anoAtual) {
					an = true;
				} else {
					JOptionPane.showMessageDialog(caixa,
							"O ano de edição deverá situar-se entre 1900 e o ano corrente.");
				}
				if (preco > 0) {
					p = true;
				} else {
					JOptionPane.showMessageDialog(caixa, "O preço não pode ser nulo ou negativo.");
				}
				if (quant >= 0) {
					q = true;
				} else {
					JOptionPane.showMessageDialog(caixa, "A quantidade em stock deve ser um n.º inteiro não negativo.");
				}
				if (t == true && a == true && e == true && i == true && an == true && p == true && q == true) {
					try {
						g.adicionarLivro(titulo, autor, editora, isbn, ano, preco, quant);
						g.criarHistorico(isbn, new GregorianCalendar(), preco);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(caixa, "Novo livro adicionado.");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
				CardLayout card = (CardLayout) main.getLayout();
				card.first(main);
			}
		});
		button_16.setBounds(316, 230, 100, 23);
		NovoLivro.add(button_16);
// FIM_NOVO LIVRO
// INÍCIO_EDITAR LIVRO
		JPanel EdLivro = new JPanel();
		main.add(EdLivro, "EdLivro");
		EdLivro.setLayout(null);

		JLabel label_13 = new JLabel("VIEW COMICS INC");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_13.setBounds(10, 0, 416, 30);
		EdLivro.add(label_13);

		JLabel lblEditarDadosDe = new JLabel("Editar dados de um livro");
		lblEditarDadosDe.setHorizontalAlignment(SwingConstants.LEFT);
		lblEditarDadosDe.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblEditarDadosDe.setBounds(10, 34, 416, 20);
		EdLivro.add(lblEditarDadosDe);

		JLabel lblSelecionarOCampo = new JLabel("Selecione o livro por:");
		lblSelecionarOCampo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelecionarOCampo.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblSelecionarOCampo.setBounds(10, 68, 137, 21);
		EdLivro.add(lblSelecionarOCampo);

		// BOTÕES PARA SELEÇÃO ISBN OU TÍTULO
		JRadioButton rdbtnIsbn = new JRadioButton("ISBN");
		buttonGroup.add(rdbtnIsbn);
		rdbtnIsbn.setBounds(160, 70, 56, 20);
		EdLivro.add(rdbtnIsbn);

		JRadioButton rdbtnTitulo = new JRadioButton("Título");
		buttonGroup.add(rdbtnTitulo);
		rdbtnTitulo.setBounds(235, 70, 79, 20);
		EdLivro.add(rdbtnTitulo);

		// VOLTAR do ED_LIVRO
		JButton button_18 = new JButton("Voltar");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) main.getLayout();
				card.first(main);
			}
		});
		button_18.setBounds(10, 219, 89, 23);
		EdLivro.add(button_18);

		JLabel lblEIntroduzaAqui = new JLabel("Introduza o ISBN ou o t\u00EDtulo do livro a localizar:");
		lblEIntroduzaAqui.setHorizontalAlignment(SwingConstants.LEFT);
		lblEIntroduzaAqui.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblEIntroduzaAqui.setBounds(10, 100, 406, 21);
		EdLivro.add(lblEIntroduzaAqui);

		// ENTER COM ISBN OU TÍTULO DO LIVRO
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(10, 125, 406, 20);
		EdLivro.add(textField_11);

		// CONFIRMAR em EdLivro
		JButton button_17 = new JButton("Confirmar");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TABELA com livros selecioandos por ISBN ou título
				if (g.listaLivros.size() == 0) {
					g.abrirLivros();
				}
				if (rdbtnIsbn.isSelected()) {
					String isbn = textField_11.getText();
					for (VCI_cl_Livro l : g.listaLivros) {
						if (isbn.equals(l.getIsbn())) {
							listaSel.add(l);
						}
					}
				} else if (rdbtnTitulo.isSelected()) {
					String titulo = textField_11.getText();
					for (VCI_cl_Livro l : g.listaLivros) {
						if (titulo.equals(l.getTitulo())) {
							listaSel.add(l);
						}
					}
				} else {
					JOptionPane.showMessageDialog(caixa, "Escolher o tipo de seleção.");
				}
				if (listaSel.size() == 0) {
					JOptionPane.showMessageDialog(caixa, "Livro não encontrado.");
				} else { // Abre tabela com os livros correspondentes à procura:
					dispose();
					VCI_TabLivSel window = new VCI_TabLivSel(g, listaSel);
					window.getFrame().setVisible(true);
					; // Ativa a janela a que o botão
				}
			}
		});
		button_17.setBounds(316, 219, 100, 23);
		EdLivro.add(button_17);

// FIM_EDITAR LIVRO
// INÍCIO_LISTAR_VENDAS
		JPanel ListarVendas = new JPanel();
		main.add(ListarVendas, "ListarVendas");
		ListarVendas.setLayout(null);

		JLabel label_14 = new JLabel("VIEW COMICS INC");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_14.setBounds(10, 0, 416, 30);
		ListarVendas.add(label_14);

		JLabel lblEscolherOIntervalo = new JLabel("Listagem de vendas");
		lblEscolherOIntervalo.setHorizontalAlignment(SwingConstants.LEFT);
		lblEscolherOIntervalo.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblEscolherOIntervalo.setBounds(10, 30, 416, 30);
		ListarVendas.add(lblEscolherOIntervalo);

		JLabel lblEscolherOIntervalo_1 = new JLabel("Escolher as datas:");
		lblEscolherOIntervalo_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEscolherOIntervalo_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblEscolherOIntervalo_1.setBounds(10, 71, 355, 23);
		ListarVendas.add(lblEscolherOIntervalo_1);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(70, 114, 125, 20);
		ListarVendas.add(dateChooser);

		JLabel lblEntre = new JLabel("Entre");
		lblEntre.setBounds(10, 115, 70, 19);
		ListarVendas.add(lblEntre);
		lblEntre.setHorizontalAlignment(SwingConstants.LEFT);
		lblEntre.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));

		JLabel lblE = new JLabel("e");
		lblE.setHorizontalAlignment(SwingConstants.LEFT);
		lblE.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblE.setBounds(220, 114, 22, 19);
		ListarVendas.add(lblE);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(260, 114, 125, 20);
		ListarVendas.add(dateChooser_1);

		JLabel lblOu = new JLabel("Ou");
		lblOu.setHorizontalAlignment(SwingConstants.LEFT);
		lblOu.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblOu.setBounds(10, 161, 70, 19);
		ListarVendas.add(lblOu);

		// TODAS AS VENDAS
		JButton btnTodasAsVendas = new JButton("Todas as vendas");
		btnTodasAsVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GregorianCalendar dI = new GregorianCalendar(1900, 0, 1);
				GregorianCalendar dF = new GregorianCalendar();
				dispose();
				VCI_TabVendas window = new VCI_TabVendas(g, dI, dF);
				window.getFrame().setVisible(true); // Ativa a janela a que o botão dá acesso;
			}
		});
		btnTodasAsVendas.setBounds(70, 161, 150, 23);
		ListarVendas.add(btnTodasAsVendas);

		// VOLTAR em LISTAR_VENDAS
		JButton button_19 = new JButton("Voltar");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) main.getLayout();
				card.first(main);
			}
		});
		button_19.setBounds(10, 230, 89, 23);
		ListarVendas.add(button_19);

		// CONFIRMAR em LISTAR_VENDAS
		JButton button_20 = new JButton("Confirmar");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Formatação para obtenção dos valores do ano, mês e dia em string.
				SimpleDateFormat ano = new SimpleDateFormat("yyyy");
				SimpleDateFormat mes = new SimpleDateFormat("MM");
				SimpleDateFormat dia = new SimpleDateFormat("dd");
				// Parse para int dos ano, mês e dia do dateChooser.
				int dIano = Integer.parseInt(ano.format(dateChooser.getDate()));
				int dImes = Integer.parseInt(mes.format(dateChooser.getDate()));
				int dIdia = Integer.parseInt(dia.format(dateChooser.getDate()));
				int dFano = Integer.parseInt(ano.format(dateChooser_1.getDate()));
				int dFmes = Integer.parseInt(mes.format(dateChooser_1.getDate()));
				int dFdia = Integer.parseInt(dia.format(dateChooser_1.getDate()));
				// Transformação das datas do dateChooser em GregorianCalendar.
				GregorianCalendar dI = new GregorianCalendar(dIano, dImes - 1, dIdia);
				GregorianCalendar dF = new GregorianCalendar(dFano, dFmes - 1, dFdia);
				dispose(); // Troca de janela.
				VCI_TabVendas window = new VCI_TabVendas(g, dI, dF);
				window.getFrame().setVisible(true); // Ativa a janela a que o botão dá acesso.
			}
		});
		button_20.setBounds(316, 230, 100, 23);
		ListarVendas.add(button_20);

		String s = "";
		if (livroSelecionado != null) {
			s = livroSelecionado.getTitulo();
		}

	}

	public VCI_cl_Livro getLivroSelecionado() {
		return livroSelecionado;
	}

	public void setLivroSelecionado(VCI_cl_Livro livroSelecionado) {
		this.livroSelecionado = livroSelecionado;
	}
}
