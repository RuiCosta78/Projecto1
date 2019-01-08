import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 * Breve descrição do código
 *
 * @sid 2002
 * @aid 1.1
 */
public class Window_JavaBank_DadosConta extends JPanel {

	private JavaBank_Gestao gestao;
	private int aux;
	private double saldo;
	private static int n_cartao = 1;
	private JLabel lblSaldo = new JLabel();

	public Window_JavaBank_DadosConta(JavaBank_Gestao gestao, int aux, double saldo) {
		this.gestao = gestao;
		this.aux = aux;
		this.saldo = saldo;
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

		JButton btnMudarDados = new JButton("Mudar Dados");
		btnMudarDados.setBounds(287, 47, 121, 23);
		add(btnMudarDados);

		JButton btnAssociarCarto = new JButton("Associar Cart\u00E3o");
		btnAssociarCarto.setBounds(287, 72, 121, 23);
		add(btnAssociarCarto);

		JButton btnFecharConta = new JButton("Fechar Conta");
		btnFecharConta.setBounds(287, 97, 121, 23);
		add(btnFecharConta);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(335, 266, 89, 23);
		add(btnVoltar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 123, 414, 132);
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

				// lblSaldo = new JLabel(String.valueOf(saldo));
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
				if (!montante.equals(null) && montante.length() > 0) {
					gestao.movimento(montante, aux, movimento);
					JOptionPane.showMessageDialog(getParent(), "Operação efectuada com sucesso.");
					initialize();
				}
			}
		});

		btnLevantamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String montante = (String) JOptionPane.showInputDialog(getParent(), "Insira o valor a levantar",
						"LEVANTAMENTO", JOptionPane.QUESTION_MESSAGE, null, null, null);
				String movimento = "Levantamento";
				if (!montante.equals(null) && montante.length() > 0) {
					gestao.movimento(montante, aux, movimento);
					JOptionPane.showMessageDialog(getParent(), "Operação efectuada com sucesso.");
					initialize();
				}
			}
		});

		btnAssociarCarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window_JavaBank_ListarContas list = new Window_JavaBank_ListarContas(gestao);
				String titular = list.getNome_completo();
				for (JavaBank_Conta c : gestao.getContas()) {
					if (c instanceof JavaBank_Conta_Ordem && ((JavaBank_Conta_Ordem) c).getCartao() != null) {
						n_cartao++;
					}
				}
				String n_cartao_string = String.format("%04d", n_cartao);
				JavaBank_Cartao_Debito cartao = new JavaBank_Cartao_Debito(titular, n_cartao_string);
				String data = cartao.getData_vencimento();
				String codigo = cartao.getCodigo_verificacao();
				Window_JavaBank_AssociarCartao associar = new Window_JavaBank_AssociarCartao(titular, n_cartao_string,
						data, codigo, aux);
				getParent().add(associar, "associar");
				CardLayout card = (CardLayout) getParent().getLayout();
				card.show(getParent(), "associar");
			}
		});

		btnTransferncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window_JavaBank_TransferenciaInterna transf = new Window_JavaBank_TransferenciaInterna(gestao, aux);
				initialize();
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
