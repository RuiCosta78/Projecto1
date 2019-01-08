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

	private JavaBank_Gestao gestao = new JavaBank_Gestao();
	private JTextField textFieldNConta;
	private JTextField textFieldNome;
	private JTextField textFieldSobrenome;
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

		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNome.setBounds(75, 76, 27, 14);
		add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(112, 73, 259, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSobrenome.setBounds(43, 101, 59, 14);
		add(lblSobrenome);

		textFieldSobrenome = new JTextField();
		textFieldSobrenome.setBounds(112, 98, 259, 20);
		add(textFieldSobrenome);
		textFieldSobrenome.setColumns(10);

		JLabel lblDataDeCriao = new JLabel("Data de cria\u00E7\u00E3o");
		lblDataDeCriao.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDataDeCriao.setBounds(27, 126, 75, 14);
		add(lblDataDeCriao);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setLocale(new Locale("pt"));
		dateChooser.setBounds(112, 126, 89, 20);
		add(dateChooser);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEstado.setBounds(211, 129, 46, 14);
		add(lblEstado);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("---Escolha a opção---");
		comboBox.addItem("Activa");
		comboBox.addItem("Inactiva");
		comboBox.setBounds(267, 126, 104, 20);
		add(comboBox);

		JLabel lblDepsitoInicial = new JLabel("Dep\u00F3sito inicial");
		lblDepsitoInicial.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDepsitoInicial.setBounds(27, 155, 75, 14);
		add(lblDepsitoInicial);

		textFieldDeposito = new JTextField();
		textFieldDeposito.setBounds(112, 152, 89, 20);
		add(textFieldDeposito);
		textFieldDeposito.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTipo.setBounds(211, 155, 46, 14);
		add(lblTipo);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.addItem("---Escolha a opção---");
		comboBox_1.addItem("Conta à Ordem");
		comboBox_1.addItem("Conta Poupança");
		comboBox_1.setBounds(267, 152, 104, 20);
		add(comboBox_1);
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = textFieldNome.getText();
				String sobrenome = textFieldSobrenome.getText();
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
