import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Breve descrição do código
 * 
 * @sid 2001
 * @aid 1.1
 */

public class VCI_VENDEDOR {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_2;
	private String nc; // NIF
	private VCI_cl_Gestao g;
	private JTextField textField_3;
	private double pTotal;

	/**
	 * Create the application.
	 */
	public VCI_VENDEDOR(VCI_cl_Gestao g) {
		this.g = g;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("../Projecto1/VC_Logotipo.jpg"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel Opcoes = new JPanel();
		frame.getContentPane().add(Opcoes, "Opcoes");
		Opcoes.setLayout(null);

		JLabel label = new JLabel("VIEW COMICS INC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label.setBounds(10, 0, 416, 30);
		Opcoes.add(label);

		JLabel label_1 = new JLabel("Benvindo!");
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_1.setBounds(10, 52, 111, 24);
		Opcoes.add(label_1);

		JLabel label_2 = new JLabel("Selecione uma op\u00E7\u00E3o:");
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_2.setBounds(10, 85, 196, 24);
		Opcoes.add(label_2);

		// ALTERAR LOGIN
		JButton button = new JButton("Alterar login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose(); // desliga a janela ativa;
				VCI_LoginAlt window = new VCI_LoginAlt(g);
				window.getFrame().setVisible(true);
			}
		});
		button.setBounds(10, 128, 133, 30);
		Opcoes.add(button);

		// LISTAR LIVROS
		JButton btnPesquisarLivros = new JButton("Pesquisar livros");
		btnPesquisarLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose(); // desliga a janela ativa;
				VCI_ListarLivros window = new VCI_ListarLivros(g);
				window.getFrame().setVisible(true);
			}
		});
		btnPesquisarLivros.setBounds(153, 128, 133, 30);
		Opcoes.add(btnPesquisarLivros);

		// CONCLUIR COMPRA
		JButton btnConcluirCompra = new JButton("Concluir compra");
		btnConcluirCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) frame.getContentPane().getLayout();
				card.show(frame.getContentPane(), "Compra");
			}
		});
		btnConcluirCompra.setBounds(293, 128, 133, 30);
		Opcoes.add(btnConcluirCompra);

		// LOGOUT
		JButton button_3 = new JButton("Logout");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] opcoes = { "Abandonar sessão", "Continuar sessão" };
				int opcao = JOptionPane.showOptionDialog(frame, "Pretende abandonar a sessão?", "ABANDONO DE SESSÃO",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[1]);
				if (opcao == 0) {
					frame.dispose(); // desliga a janela ativa;
					VCI_cl_Gestao.utilizador = null;
					VCI_Login window = new VCI_Login(g);
					window.getFrame().setVisible(true);
				}
			}
		});
		button_3.setBounds(293, 222, 133, 30);
		Opcoes.add(button_3);

		JPanel Compra = new JPanel();
		frame.getContentPane().add(Compra, "Compra");
		Compra.setLayout(null);
// FIM OPÇÕES
// INÍCIO COMPRA
		JLabel label_3 = new JLabel("VIEW COMICS INC");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_3.setBounds(10, 0, 416, 30);
		Compra.add(label_3);

		JLabel lblConcluirCompra = new JLabel("Concluir compra");
		lblConcluirCompra.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblConcluirCompra.setBounds(10, 34, 339, 24);
		Compra.add(lblConcluirCompra);

		// VOLTAR em CONCLUIR COMPRA
		JButton button_2 = new JButton("Voltar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) frame.getContentPane().getLayout();
				card.previous(frame.getContentPane());
			}
		});
		button_2.setBounds(10, 222, 133, 30);
		Compra.add(button_2);

		JRadioButton rdbtnADinheiro = new JRadioButton("A dinheiro");
		buttonGroup.add(rdbtnADinheiro);
		rdbtnADinheiro.setBounds(207, 156, 111, 23);
		Compra.add(rdbtnADinheiro);

		JRadioButton rdbtnCartoDeDbito = new JRadioButton("Cart\u00E3o de d\u00E9bito");
		buttonGroup.add(rdbtnCartoDeDbito);
		rdbtnCartoDeDbito.setBounds(207, 184, 154, 23);
		Compra.add(rdbtnCartoDeDbito);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(226, 69, 200, 20);
		Compra.add(textField);

		JLabel lblNifDoCliente = new JLabel("NIF do cliente:");
		lblNifDoCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblNifDoCliente.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblNifDoCliente.setBounds(10, 99, 129, 20);
		Compra.add(lblNifDoCliente);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(226, 101, 200, 20);
		Compra.add(textField_1);

		JLabel lblIdDoCarrinho = new JLabel("Nome de utilizador do cliente:");
		lblIdDoCarrinho.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdDoCarrinho.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblIdDoCarrinho.setBounds(10, 67, 206, 20);
		Compra.add(lblIdDoCarrinho);

		// Cálculo e apresentação do valor total da compra.
		if (VCI_cl_Gestao.cliente != null) {
			for (int j = 0; j < VCI_cl_Gestao.cliente.getListaCompras().size(); j++) {
				pTotal = pTotal + VCI_cl_Gestao.cliente.getListaCompras().get(j).getPreco()
						* VCI_cl_Gestao.cliente.getQuantLivros().get(j);
			}
		}
		DecimalFormat df = new DecimalFormat("#.##");
		String valor = df.format(pTotal);

		JLabel lblMtodoDePagamento = new JLabel("M\u00E9todo de pagamento:");
		lblMtodoDePagamento.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblMtodoDePagamento.setBounds(10, 153, 208, 24);
		Compra.add(lblMtodoDePagamento);

		// CONFIRMAR em COMPRA
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Verificação do nome de utilizador para localizar o cliente.
				boolean nome = false;
				String nomeC = textField.getText().toString();
				if (nomeC.equals("")) {
					JOptionPane.showMessageDialog(frame, "Indicar o nome de utilizador do cliente.");
				} else {
					if (VCI_cl_Gestao.cliente == null) {
						JOptionPane.showMessageDialog(frame, "Não existem compras para pagamento.");
					} else if (nomeC.equals(VCI_cl_Gestao.cliente.getNome())) {
						nome = true;
					} else {
						JOptionPane.showMessageDialog(frame, "Utilizador não encontrado.");
					}
					if (VCI_cl_Gestao.cliente != null) {
						// Validação do NIF:
						nc = textField_1.getText().toString();
						boolean nif = false;
						if (g.validarInteiro(nc) == false) {
							JOptionPane.showMessageDialog(frame,
									"Número de Contribuinte inválido (verificar dígitos, sem espaços).");
						} else {
							if (nc.length() != 9) {
								JOptionPane.showMessageDialog(frame,
										"Número de Contribuinte inválido (introduzir número de 9 dígitos)");
							} else {
								nif = true;
							}
						}
						// Verificação do método de pagamento:
						boolean mPag = false;
						if (buttonGroup.getSelection() == null) {
							JOptionPane.showMessageDialog(frame, "Escolher método de pagamento.");
						} else {
							mPag = true;
						}
						// Confirmação após validação de todos os dados:
						if (nif == true && nome == true && mPag == true) {
							if (rdbtnADinheiro.isSelected()) { // Seleção do pagamento a dinheiro.
								CardLayout card = (CardLayout) frame.getContentPane().getLayout();
								card.show(frame.getContentPane(), "Dinheiro");
							} else if (rdbtnCartoDeDbito.isSelected()) { // Seleção do pagamento com cartão.
								CardLayout card = (CardLayout) frame.getContentPane().getLayout();
								card.show(frame.getContentPane(), "Cartao");
							}
						}
					}
				}
			}
		});
		btnConfirmar.setBounds(293, 222, 133, 30);
		Compra.add(btnConfirmar);

// FIM COMPRA
// INÍCIO DINHEIRO		
		JPanel Dinheiro = new JPanel();
		frame.getContentPane().add(Dinheiro, "Dinheiro");
		Dinheiro.setLayout(null);

		JLabel label_7 = new JLabel("VIEW COMICS INC");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_7.setBounds(10, 0, 416, 30);
		Dinheiro.add(label_7);

		JLabel lblPagamentoADinheiro = new JLabel("Pagamento a dinheiro");
		lblPagamentoADinheiro.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblPagamentoADinheiro.setBounds(10, 34, 339, 24);
		Dinheiro.add(lblPagamentoADinheiro);

		// VOLTAR EM DINHEIRO
		JButton button_1 = new JButton("Voltar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) frame.getContentPane().getLayout();
				card.show(frame.getContentPane(), "Compra");
			}
		});
		button_1.setBounds(10, 222, 133, 30);
		Dinheiro.add(button_1);

		JLabel label_8 = new JLabel("Valor total da sua compra:");
		label_8.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label_8.setBounds(10, 75, 208, 24);
		Dinheiro.add(label_8);

		JLabel lblQuantiaEntreguePelo = new JLabel("Quantia entregue pelo cliente:");
		lblQuantiaEntreguePelo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblQuantiaEntreguePelo.setBounds(10, 117, 225, 24);
		Dinheiro.add(lblQuantiaEntreguePelo);

		// Valor da compra em DINHEIRO
		JLabel label_12 = new JLabel(valor);
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label_12.setBounds(316, 75, 75, 24);
		Dinheiro.add(label_12);

		JLabel label_13 = new JLabel("\u20AC");
		label_13.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label_13.setBounds(401, 75, 25, 24);
		Dinheiro.add(label_13);

		JLabel label_14 = new JLabel("\u20AC");
		label_14.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label_14.setBounds(401, 117, 25, 24);
		Dinheiro.add(label_14);

		// Valor entregue pelo cliente em DINHEIRO.
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setBounds(305, 120, 96, 20);
		Dinheiro.add(textField_2);
		textField_2.setColumns(10);

		// CONFIRMAR em DINHEIRO
		JButton button_4 = new JButton("Confirmar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (g.listaLivros.size() == 0) {
					g.abrirLivros();
				}
				if (g.listaCompras.size() == 0) {
					g.abrirCompras();
				}
				String pag = textField_2.getText();
				if (g.validarDouble(pag)) {
					if (Double.parseDouble(pag) < pTotal) {
						JOptionPane.showMessageDialog(frame, "O valor para pagamento não é suficiente.");
					} else {
						if (Double.parseDouble(pag) == pTotal) {
							JOptionPane.showMessageDialog(frame, "O valor para pagamento está correto.");
						} else {
							String troco = df.format(Double.parseDouble(pag) - pTotal);
							JOptionPane.showMessageDialog(frame, "O cliente tem a receber " + troco + "€ de troco.");
							// Percorre a lista de compras:
							for (int i = 0; i < VCI_cl_Gestao.cliente.getListaCompras().size(); i++) {
								// Percorre a lista de livros:
								for (VCI_cl_Livro l : g.listaLivros) {
									// Encontra cada livro da lista de compras na lista de livros:
									if (VCI_cl_Gestao.cliente.getListaCompras().get(i).getIsbn().equals(l.getIsbn())) {
										int qAt = l.getQuantidade() - VCI_cl_Gestao.cliente.getQuantLivros().get(i);
										l.setQuantidade(qAt); // Atualiza o stock.
									}
								}
							}
							VCI_cl_Compra novaCompra = new VCI_cl_Dinheiro(Integer.parseInt(nc), VCI_cl_Gestao.cliente,
									new GregorianCalendar(), pTotal);
							g.listaCompras.add(novaCompra);
							try {
								g.gravarLivros(); // Grava no ficheiro dos livros
								g.gravarCompras(); // Grava no ficheiro de compras

							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						JOptionPane.showMessageDialog(frame, "Compra efetuada.");
						VCI_cl_Gestao.cliente = null; // Reinicia o cliente.
						label_12.setText("");
						textField_2.setText("");
						CardLayout card = (CardLayout) frame.getContentPane().getLayout();
						card.first(frame.getContentPane());
					}
				} else {
					JOptionPane.showMessageDialog(frame,
							"O valor introduzido não é válido. Verificar algarismos, separador decimal (.) ou casas decimais (máx. de duas).");
				}
			}
		});
		button_4.setBounds(279, 222, 133, 30);
		Dinheiro.add(button_4);

// FIM DINHEIRO
// INÍCIO CARTÃO
		JPanel Cartao = new JPanel();
		frame.getContentPane().add(Cartao, "Cartao");
		Cartao.setLayout(null);

		JLabel label_9 = new JLabel("VIEW COMICS INC");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_9.setBounds(10, 0, 416, 30);
		Cartao.add(label_9);

		JLabel lblPagamentoComCarto = new JLabel("Pagamento com cart\u00E3o de d\u00E9bito");
		lblPagamentoComCarto.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblPagamentoComCarto.setBounds(10, 34, 339, 24);
		Cartao.add(lblPagamentoComCarto);

		// VOLTAR EM CARTÃO
		JButton button_5 = new JButton("Voltar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) frame.getContentPane().getLayout();
				card.show(frame.getContentPane(), "Compra");
			}
		});
		button_5.setBounds(10, 222, 133, 30);
		Cartao.add(button_5);

		JLabel lblNmeroDoCarto = new JLabel("N\u00FAmero do cart\u00E3o de d\u00E9bito:");
		lblNmeroDoCarto.setHorizontalAlignment(SwingConstants.LEFT);
		lblNmeroDoCarto.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblNmeroDoCarto.setBounds(10, 104, 200, 20);
		Cartao.add(lblNmeroDoCarto);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(226, 106, 185, 20);
		Cartao.add(textField_3);

		// CONFIRMAR em CARTÃO
		JButton button_6 = new JButton("Confirmar");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (g.listaLivros.size() == 0) {
					g.abrirLivros();
				}
				if (g.listaCompras.size() == 0) {
					g.abrirCompras();
				}
				String resposta = "";
				// Validação do número do cartão de débito:
				String nCartao = textField_3.getText().toString();
				boolean nC = false;
				if (g.validarInteiro(nCartao) == false) {
					JOptionPane.showMessageDialog(frame,
							"Número de cartão inválido (verificar 4 dígitos, sem espaços).");
				} else {
					if (nCartao.length() != 4) {
						JOptionPane.showMessageDialog(frame,
								"Número de cartão inválido (introduzir número de 4 dígitos)");
					} else {
						nC = true;
					} 
				}
				if (nC) {
					try {
						g.compraCartao(nCartao, pTotal);
					} catch (NumberFormatException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String[] resBanco = null;
					JavaBank_Gestao gestao = new JavaBank_Gestao();
					ArrayList<JavaBank_Conta> contas = new ArrayList<>();
					try {
						contas = gestao.abrirContas();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						resBanco = g.show(contas);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						g.gravarResposta(contas);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					resposta = resBanco[0];
					switch (resposta) {
					case "sem saldo":
						JOptionPane.showMessageDialog(frame, "Compra não efetuada. Saldo insuficiente.");
						break;
					case "errado":
						JOptionPane.showMessageDialog(frame, "Compra não efetuada. Número de cartão inválido.");
						break;
					case "inativo":
						JOptionPane.showMessageDialog(frame, "Compra não efetuada. Cartão inativo.");
						break;
					case "sucesso":
						// Percorre a lista de compras:
						for (int i = 0; i < VCI_cl_Gestao.cliente.getListaCompras().size(); i++) {
							// Percorre a lista de livros:
							for (VCI_cl_Livro l : g.listaLivros) {
								// Encontra cada livro da lista de compras na lista de livros:
								if (VCI_cl_Gestao.cliente.getListaCompras().get(i).getIsbn().equals(l.getIsbn())) {
									int qAt = l.getQuantidade() - VCI_cl_Gestao.cliente.getQuantLivros().get(i);
									l.setQuantidade(qAt); // Atualiza o stock.
								}
							}
						}
						VCI_cl_Compra novaCompra = new VCI_cl_Cartao(Integer.parseInt(nc), VCI_cl_Gestao.cliente,
								new GregorianCalendar(), pTotal, Integer.parseInt(nCartao));
						g.listaCompras.add(novaCompra); // Adiciona a compra à lista de vendas.
						System.out.println(((VCI_cl_Compra) novaCompra).getNif());
						try {
							g.gravarLivros(); // Grava no ficheiro dos livros
							g.gravarCompras(); // Grava no ficheiro de compras
							g.gravarContas(contas);

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						VCI_cl_Gestao.cliente = null; // Reinicia o cliente.
						label_12.setText("");
						textField_2.setText("");
						CardLayout card = (CardLayout) frame.getContentPane().getLayout();
						card.first(frame.getContentPane());
						JOptionPane.showMessageDialog(frame, "Compra efetuada com sucesso.");
						g.apagarFicheiro("resposta");
						g.apagarFicheiro("pedido");
						break;
					}
				}
			}
		});
		button_6.setBounds(293, 222, 133, 30);
		Cartao.add(button_6);

		JLabel label_10 = new JLabel("Valor total da sua compra:");
		label_10.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label_10.setBounds(10, 69, 208, 24);
		Cartao.add(label_10);

		// Valor da compra em CARTÃO
		JLabel label_11 = new JLabel(valor);
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label_11.setBounds(316, 69, 75, 24);
		Cartao.add(label_11);

		JLabel label_17 = new JLabel("\u20AC");
		label_17.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label_17.setBounds(401, 69, 25, 24);
		Cartao.add(label_17);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
