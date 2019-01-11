import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.util.Locale;

/**
 * Breve descrição do código
 *
 * @sid 2002
 * @aid 1.1
 */
public class Window_JavaBank_AbrirConta extends JPanel {

	private JavaBank_Gestao gestao;
	private JTextField textFieldNConta;
	private JTextField textFieldDeposito;

	/**
	 * Create the panel.
	 */
	public Window_JavaBank_AbrirConta(JavaBank_Gestao gestao) {
		this.gestao = gestao;
		initialize();
		setVisible(true);
	}

	private void initialize() {
		setLayout(null);
		JavaBank_Conta conta = null;

		JLabel lblTitulo = new JLabel("ABERTURA DE CONTA");
		lblTitulo.setOpaque(true);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblTitulo.setBackground(Color.GRAY);
		lblTitulo.setBounds(0, 0, 424, 40);
		add(lblTitulo);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(0, 183, 89, 23);
		add(btnCancelar);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(335, 183, 89, 23);
		add(btnConfirmar);

		JLabel lblNDeConta = new JLabel("N\u00BA de Conta");
		lblNDeConta.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNDeConta.setBounds(43, 51, 59, 14);
		add(lblNDeConta);

		textFieldNConta = new JTextField();
		int n_conta = gestao.getContas().size() + 1;
		textFieldNConta.setText(String.valueOf(n_conta));
		textFieldNConta.setEditable(false);
		textFieldNConta.setBounds(112, 48, 86, 20);
		add(textFieldNConta);
		textFieldNConta.setColumns(10);

		JLabel lblNome = new JLabel("Nome completo");
		lblNome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNome.setBounds(27, 76, 75, 14);
		add(lblNome);

		JLabel lblDataDeCriao = new JLabel("Data de cria\u00E7\u00E3o");
		lblDataDeCriao.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDataDeCriao.setBounds(27, 101, 75, 14);
		add(lblDataDeCriao);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setLocale(new Locale("pt"));
		dateChooser.setBounds(112, 101, 89, 20);
		add(dateChooser);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEstado.setBounds(211, 104, 46, 14);
		add(lblEstado);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("---Escolha a opção---");
		comboBox.addItem("Activa");
		comboBox.addItem("Inactiva");
		comboBox.setBounds(267, 101, 104, 20);
		add(comboBox);

		JLabel lblDepsitoInicial = new JLabel("Dep\u00F3sito inicial");
		lblDepsitoInicial.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepsitoInicial.setBounds(27, 130, 75, 14);
		add(lblDepsitoInicial);

		textFieldDeposito = new JTextField();
		textFieldDeposito.setBounds(112, 127, 89, 20);
		add(textFieldDeposito);
		textFieldDeposito.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTipo.setBounds(211, 130, 46, 14);
		add(lblTipo);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addItem("---Escolha a opção---");
		comboBox_1.addItem("Conta à Ordem");
		comboBox_1.addItem("Conta Poupança");
		comboBox_1.setBounds(267, 127, 104, 20);
		add(comboBox_1);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.addItem("---Escolha o cliente---");
		for(JavaBank_Utilizador u : gestao.getUtilizadores()) {
			if(u instanceof JavaBank_Cliente) {
				String nome = u.getPrimeiro_nome();
				String sobrenome = u.getSobrenome();
				String nome_completo = nome.concat(" ").concat(sobrenome);
				comboBox_2.addItem(nome_completo);
			}
		}
		comboBox_2.setBounds(112, 73, 157, 20);
		add(comboBox_2);
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome_completo = (String) comboBox_2.getSelectedItem();
				String[] nome_partes = nome_completo.split(" ");
				String nome = nome_partes[0];
				String sobrenome = nome_partes[1];
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String formatData = sdf.format(dateChooser.getDate());
				String data = formatData.toString();
				String estado = comboBox.getSelectedItem().toString();
				double deposito = Double.parseDouble(textFieldDeposito.getText());
				String tipo = comboBox_1.getSelectedItem().toString();
				String mensagem = "";
				mensagem = gestao.abrir_nova_conta(n_conta, nome, sobrenome, data, estado, deposito, tipo);
				JOptionPane.showMessageDialog(getParent(), mensagem);
				if (mensagem.equals("Registo concluído com sucesso.")) {
					CardLayout card = (CardLayout) getParent().getLayout();
					removeAll();
					initialize();
					card.show(getParent(), "mainf");
				} else {
					return;
				}
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout card = (CardLayout) getParent().getLayout();
				removeAll();
				initialize();
				card.show(getParent(), "mainf");
			}
		});
	}
}
