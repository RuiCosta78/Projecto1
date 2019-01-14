import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**JPanel para visualização de dados de conta
 * 
 * @author Rui Costa
 *
 */
public class Window_JavaBank_DadosConta extends JPanel {

	private JavaBank_Gestao gestao;
	private int aux;
	private double saldo;
	private int n_cartao;
	private JLabel lblSaldo = new JLabel();

	public Window_JavaBank_DadosConta(JavaBank_Gestao gestao, int aux, double saldo) {
		this.gestao = gestao;
		this.aux = aux;
		this.saldo = saldo;
		try {
			gestao.abrirContas();
			gestao.abrirUtilizadores();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setLayout(null);
		setVisible(true);
		JLabel lblDadosContas = new JLabel("DADOS DA CONTA");
		lblDadosContas.setOpaque(true);
		lblDadosContas.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosContas.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblDadosContas.setBackground(Color.GRAY);
		lblDadosContas.setBounds(0, 0, 424, 40);
		add(lblDadosContas);

		JLabel lblDataDeCriao = new JLabel("Data de cria\u00E7\u00E3o:");
		lblDataDeCriao.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDataDeCriao.setBounds(10, 51, 79, 14);
		add(lblDataDeCriao);

		JLabel lblSaldoDaConta = new JLabel("Saldo da conta:");
		lblSaldoDaConta.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSaldoDaConta.setBounds(10, 76, 79, 14);
		add(lblSaldoDaConta);

		JLabel lblJuros = new JLabel("Juros(%):");
		lblJuros.setHorizontalAlignment(SwingConstants.TRAILING);
		lblJuros.setBounds(10, 101, 79, 14);
		add(lblJuros);

		JButton btnDepsito = new JButton("Dep\u00F3sito");
		btnDepsito.setBounds(151, 47, 126, 23);
		add(btnDepsito);

		JButton btnLevantamento = new JButton("Levantamento");
		btnLevantamento.setBounds(151, 72, 126, 23);
		add(btnLevantamento);

		JButton btnTransferncia = new JButton("Transfer\u00EAncia");
		btnTransferncia.setBounds(151, 97, 126, 23);
		add(btnTransferncia);

		JButton btnAssociarCarto = new JButton("Associar Cart\u00E3o");
		for (JavaBank_Conta c : gestao.getContas()) {
			if (c.getN_conta() == aux) {
				if (c instanceof JavaBank_Conta_Poupanca
						|| JavaBank_Gestao.utilizador_logado instanceof JavaBank_Cliente) {
					btnAssociarCarto.setEnabled(false);
				} else if (c instanceof JavaBank_Conta_Ordem) {
					btnAssociarCarto.setEnabled(true);
				}
			}
		}
		btnAssociarCarto.setBounds(287, 72, 121, 23);
		add(btnAssociarCarto);

		JButton btnFecharConta = new JButton("Fechar Conta");
		btnFecharConta.setBounds(287, 97, 121, 23);
		add(btnFecharConta);

		if (JavaBank_Gestao.utilizador_logado instanceof JavaBank_Cliente) {
			btnDepsito.setEnabled(false);
			btnLevantamento.setEnabled(false);
			btnFecharConta.setEnabled(false);
		} else {
			btnDepsito.setEnabled(true);
			btnLevantamento.setEnabled(true);
			btnFecharConta.setEnabled(true);
		}

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(287, 123, 121, 23);
		add(btnVoltar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 160, 414, 129);
		add(scrollPane);

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		for (JavaBank_Conta c : gestao.getContas()) {
			if (c.getN_conta() == aux) {
				JLabel lblData = new JLabel(c.getData_criacao());
				lblData.setBounds(95, 51, 70, 14);
				add(lblData);

				lblSaldo.setText(String.valueOf(c.getSaldo()));
				lblSaldo.setBounds(95, 76, 46, 14);
				add(lblSaldo);

				JLabel lblJuros1 = null;
				if (c instanceof JavaBank_Conta_Ordem) {
					lblJuros1 = new JLabel("NA");
				} else if (c instanceof JavaBank_Conta_Poupanca) {
					lblJuros1 = new JLabel(String.valueOf(((JavaBank_Conta_Poupanca) c).getJuros()));
				}

				lblJuros1.setBounds(95, 101, 46, 14);
				add(lblJuros1);
			}
		}

		tabelaMovimentos(scrollPane);

		JButton btnAdicionarTitular = new JButton("Adicionar titular");
		btnAdicionarTitular.setBounds(287, 47, 121, 23);
		add(btnAdicionarTitular);

		JButton btnCartesAssociados = new JButton("Cart\u00F5es associados");
		for (JavaBank_Conta c : gestao.getContas()) {
			if (c.getN_conta() == aux) {
				if (c instanceof JavaBank_Conta_Poupanca
						|| JavaBank_Gestao.utilizador_logado instanceof JavaBank_Cliente) {
					btnCartesAssociados.setEnabled(false);
				} else if (c instanceof JavaBank_Conta_Ordem) {
					btnCartesAssociados.setEnabled(true);
				}
			}
		}
		btnCartesAssociados.setBounds(151, 123, 126, 23);
		add(btnCartesAssociados);

		JComboBox<String> comboBoxTitulares = new JComboBox<String>();
		comboBoxTitulares.setBounds(10, 126, 131, 20);
		comboBoxTitulares.addItem("--Titulares--");
		for (JavaBank_Utilizador u : gestao.getUtilizadores()) {
			if (u instanceof JavaBank_Cliente) {
				for (JavaBank_Conta c : ((JavaBank_Cliente) u).getContas_associadas()) {
					if (c.getN_conta() == aux) {
						String nome_completo = u.getPrimeiro_nome() + " " + u.getSobrenome();
						comboBoxTitulares.addItem(nome_completo);
					}
				}
			}
		}
		add(comboBoxTitulares);

		btnCartesAssociados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					gestao.abrirContas();
					gestao.abrirUtilizadores();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String[] opcoes = { "Voltar" };
				JPanel panel = new JPanel();
				JComboBox<String> combo = new JComboBox<>();
				for (JavaBank_Conta c : gestao.getContas()) {
					if (c.getN_conta() == aux) {
						for (JavaBank_Cartao_Debito car : ((JavaBank_Conta_Ordem) c).getCartoes_associados()) {
							String titular = car.getNome_titular();
							String numero = car.getNumero();
							String data = car.getData_vencimento();
							String codigo = car.getCodigo_verificacao();
							combo.addItem("Titular: " + titular + " | Nº: " + numero + " | Validade: " + data
									+ " | Código " + codigo);
						}
					}
				}
				panel.add(combo);
				if (combo.getItemCount() == 0) {
					JOptionPane.showMessageDialog(getParent(), "Não existem cartões associados para esta conta.");
				} else {
					JOptionPane.showOptionDialog(getParent(), panel, "Cartões associados", JOptionPane.PLAIN_MESSAGE,
							JOptionPane.QUESTION_MESSAGE, null, opcoes, null);
				}
				try {
					gestao.gravarContas();
					gestao.getUtilizadores();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnFecharConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] opcoes = { "Confirmar", "Cancelar" };
				int opcao = JOptionPane.showOptionDialog(getParent(),
						"Tem a certeza que deseja marcar esta conta como fechada?", "FECHO DE CONTA",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[1]);
				if (opcao == 0) {
					for (JavaBank_Conta c : gestao.getContas()) {
						if (c.getN_conta() == aux && c.getEstado().equals("Activa")) {
							c.setEstado("Fechada");
							JOptionPane.showMessageDialog(getParent(), "Conta fechada com sucesso.");
						} else if (c.getN_conta() == aux && c.getEstado().equals("Fechada")) {
							JOptionPane.showMessageDialog(getParent(), "Erro. A conta já se encontra fechada.");
							return;
						}
					}
				}
			}
		});

		btnDepsito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String montante = (String) JOptionPane.showInputDialog(getParent(), "Insira o valor a depositar",
						"DEPÓSITO", JOptionPane.QUESTION_MESSAGE, null, null, null);
				String movimento = "Depósito";
				String mensagem = null;
				try {
					if (!montante.equals(null) && montante.length() > 0) {
						mensagem = gestao.movimento(montante, aux, movimento);
					}
					JOptionPane.showMessageDialog(getParent(), mensagem);
					initialize();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnLevantamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String montante = (String) JOptionPane.showInputDialog(getParent(), "Insira o valor a levantar",
						"LEVANTAMENTO", JOptionPane.QUESTION_MESSAGE, null, null, null);
				String movimento = "Levantamento";
				if (!montante.equals(null) && montante.length() > 0) {
					String mensagem = null;
					try {
						mensagem = gestao.movimento(montante, aux, movimento);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(getParent(), mensagem);
					initialize();
				}
			}
		});

		btnAssociarCarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					gestao.abrirContas();
					gestao.abrirUtilizadores();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Object[] opcoes = { "Confirmar", "Cancelar" };
				JPanel panel = new JPanel();
				panel.add(new JLabel("Nome "));
				JComboBox<String> combo = new JComboBox<>();
				for (JavaBank_Utilizador u : gestao.getUtilizadores()) {
					String nome_completo = u.getPrimeiro_nome() + " " + u.getSobrenome();
					if (u instanceof JavaBank_Cliente) {
						for (JavaBank_Conta c : ((JavaBank_Cliente) u).getContas_associadas()) {
							if (c.getN_conta() == aux) {
								if (((JavaBank_Conta_Ordem) c).getCartoes_associados().isEmpty()) {
									combo.addItem(nome_completo);
								}
								for (JavaBank_Cartao_Debito car : ((JavaBank_Conta_Ordem) c).getCartoes_associados()) {
									if (car.getNome_titular() != nome_completo) {
										combo.addItem(nome_completo);
									}
								}
							}
						}
					}
				}
				panel.add(combo);
				n_cartao = 1;
				int i = JOptionPane.showOptionDialog(getParent(), panel, "Associar cartão de débito",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, null);
				String titular = "";
				if (i == JOptionPane.OK_OPTION) {
					titular = (String) combo.getSelectedItem();
					for (JavaBank_Utilizador u : gestao.getUtilizadores()) {
						if (u instanceof JavaBank_Cliente) {
							for (JavaBank_Conta c : gestao.getContas()) {
								if (c instanceof JavaBank_Conta_Ordem) {
									for (JavaBank_Cartao_Debito car : ((JavaBank_Conta_Ordem) c)
											.getCartoes_associados()) {
										if (c instanceof JavaBank_Conta_Ordem && car != null) {
											n_cartao++;
										}
										if (c.getN_conta() == aux && car.getNome_titular().equals(titular)) {
											JOptionPane.showMessageDialog(getParent(), "O titular " + titular
													+ " já possui cartão de débito associado a esta conta.");
											n_cartao--;
											return;
										}
									}
								}
							}
						}
					}
					String n_cartao_string = String.format("%04d", n_cartao);
					JavaBank_Cartao_Debito cartao = new JavaBank_Cartao_Debito(titular, n_cartao_string);
					String data = cartao.getData_vencimento();
					String codigo = cartao.getCodigo_verificacao();
					Window_JavaBank_AssociarCartao associar = new Window_JavaBank_AssociarCartao(titular,
							n_cartao_string, data, codigo, aux, gestao, cartao);
					getParent().add(associar, "associar");
					CardLayout card = (CardLayout) getParent().getLayout();
					card.show(getParent(), "associar");
				}
				try {
					gestao.gravarContas();
					gestao.gravarUtilizadores();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnTransferncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window_JavaBank_TransferenciaInterna transf = new Window_JavaBank_TransferenciaInterna(gestao, aux);
				initialize();
			}
		});

		btnAdicionarTitular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] opcoes = { "Confirmar", "Cancelar" };
				JPanel panel = new JPanel();
				panel.add(new JLabel("Nome "));
				JComboBox<String> combo = new JComboBox<>();
				boolean bool = true;
				for (JavaBank_Utilizador u : gestao.getUtilizadores()) {
					if (u instanceof JavaBank_Cliente) {
						for (JavaBank_Conta c : ((JavaBank_Cliente) u).getContas_associadas()) {
							if (bool && c.getN_conta() == aux) {
								bool = false;
							}
						}
						if (!bool) {
							String nome_completo = u.getPrimeiro_nome() + " " + u.getSobrenome();
							combo.addItem(nome_completo);
						}
					}
				}
				panel.add(combo);
				int i = JOptionPane.showOptionDialog(getParent(), panel, "Adicionar titular",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, null);
				String titular = (String) combo.getSelectedItem();
				if (i == JOptionPane.OK_OPTION) {
					String[] partes = titular.split(" ");
					for (JavaBank_Utilizador u : gestao.getUtilizadores()) {
						if (u instanceof JavaBank_Cliente) {
							for (JavaBank_Conta c : gestao.getContas()) {
								if (u.getPrimeiro_nome().equals(partes[0]) && u.getSobrenome().equals(partes[1])
										&& c.getN_conta() == aux) {
									((JavaBank_Cliente) u).getContas_associadas().add(c);
								}
							}
						}
					}
					JOptionPane.showMessageDialog(getParent(), "Operação efectuada com sucesso");
				}
			}
		});
	}

	public void tabelaMovimentos(JScrollPane scrollPane) {
		String col[] = { "Data", "Tipo", "Montante(€)", "Saldo(€)" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable table = new JTable(tableModel);

		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);

		double montante = 0.0;
		for (JavaBank_Conta c : gestao.getContas()) {
			if (c.getN_conta() == aux) {
				for (JavaBank_Movimento m : c.getHistorico_movimentos()) {
					String data = m.getData_movimento();
					String tipo = m.getTipo_movimento();
					montante = m.getQuantia();
					saldo = m.getSaldoInst();
					Object dados[] = { data, tipo, montante, saldo };
					tableModel.addRow(dados);
				}
			}
		}
		scrollPane.setViewportView(table);
	}
}
