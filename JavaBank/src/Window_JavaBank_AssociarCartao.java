import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Breve descrição do código
 *
 * @sid 2002
 * @aid 1.1
 */
public class Window_JavaBank_AssociarCartao extends JPanel {

	private JavaBank_Gestao gestao;
	private String titular;
	private String n_cartao;
	private String data_validade;
	private String codigo_verif;
	private int aux;
	private JavaBank_Cartao_Debito cartao;

	public Window_JavaBank_AssociarCartao(String titular, String n_cartao, String data_validade, String codigo_verif,
			int aux, JavaBank_Gestao gestao, JavaBank_Cartao_Debito cartao) {
		this.titular = titular;
		this.n_cartao = n_cartao;
		this.data_validade = data_validade;
		this.codigo_verif = codigo_verif;
		this.aux = aux;
		this.gestao = gestao;
		this.cartao = cartao;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setLayout(null);
		setVisible(true);
		JLabel lblAssociarCartao = new JLabel("ASSOCIAR CARTÃO");
		lblAssociarCartao.setOpaque(true);
		lblAssociarCartao.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssociarCartao.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblAssociarCartao.setBackground(Color.GRAY);
		lblAssociarCartao.setBounds(0, 0, 424, 40);
		add(lblAssociarCartao);

		JLabel lblTitular = new JLabel("Titular:");
		lblTitular.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTitular.setBounds(47, 68, 111, 14);
		add(lblTitular);

		JLabel lblNDoCarto = new JLabel("N\u00BA do cart\u00E3o:");
		lblNDoCarto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNDoCarto.setBounds(47, 93, 111, 14);
		add(lblNDoCarto);

		JLabel lblDataDeValidade = new JLabel("Data de validade:");
		lblDataDeValidade.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDataDeValidade.setBounds(47, 118, 111, 14);
		add(lblDataDeValidade);

		JLabel lblCdigoDeVerificao = new JLabel("C\u00F3digo de verifica\u00E7\u00E3o:");
		lblCdigoDeVerificao.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCdigoDeVerificao.setBounds(47, 143, 111, 14);
		add(lblCdigoDeVerificao);

		JLabel lblNomeTitular = new JLabel(titular);
		lblNomeTitular.setBounds(168, 68, 161, 14);
		add(lblNomeTitular);

		JLabel lblNumero = new JLabel(String.valueOf(n_cartao));
		lblNumero.setBounds(168, 93, 161, 14);
		add(lblNumero);

		JLabel lblData = new JLabel(String.valueOf(data_validade));
		lblData.setBounds(168, 118, 161, 14);
		add(lblData);

		JLabel lblCodigo = new JLabel(String.valueOf(codigo_verif));
		lblCodigo.setBounds(168, 143, 46, 14);
		add(lblCodigo);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(310, 226, 89, 23);
		add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(47, 226, 89, 23);
		add(btnCancelar);

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] partes = titular.split(" ");
				JavaBank_Conta conta = null;
				JavaBank_Utilizador util = null;
				for (JavaBank_Utilizador u : gestao.getUtilizadores()) {
					for (JavaBank_Conta c : gestao.getContas()) {
						if (u instanceof JavaBank_Cliente && u.getPrimeiro_nome().equals(partes[0])
								&& u.getSobrenome().equals(partes[1]) && c instanceof JavaBank_Conta_Ordem
								&& c.getN_conta() == aux) {
							if (((JavaBank_Conta_Ordem) ((JavaBank_Cliente) u).getConta()).getCartao() != null) {
								conta = new JavaBank_Conta_Ordem(aux, c.getData_criacao(), c.getSaldo(), c.getEstado(),
										cartao);
								util = new JavaBank_Cliente(u.getPrimeiro_nome(), u.getSobrenome(),
										u.getData_nascimento(), u.getTipo_id(), u.getN_id(), u.getEndereco(),
										u.getN_contacto(), u.getLogin(), u.getPassword(),
										((JavaBank_Cliente) u).getNif(), conta);
							} else {
								((JavaBank_Conta_Ordem)c).setCartao(cartao);
								((JavaBank_Cliente)u).setConta(c);
							}
						}
					}
				}
				if(util != null) {
					gestao.getUtilizadores().add(util);
				}
				JOptionPane.showMessageDialog(getParent(), "Cartão associado com sucesso.");
				CardLayout card = (CardLayout) getParent().getLayout();
				removeAll();
				initialize();
				card.show(getParent(), "mainf");
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) getParent().getLayout();
				removeAll();
				initialize();
				card.show(getParent(), "mainf");
			}
		});
	}
}
