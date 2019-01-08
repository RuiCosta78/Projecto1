import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.util.Locale;

/**
 * Breve descrição do código
 *
 * @sid 2002
 * @aid 1.1
 */
public class Window_JavaBank_RegistarCl extends JPanel {

	private JTextField textFieldNome;
	private JTextField textFieldSobrenome;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirm;
	private JavaBank_Gestao gestao = new JavaBank_Gestao();
	private JTextField textFieldId;
	private JTextField textFieldEndereco;
	private JTextField textFieldContacto;
	private JTextField textFieldNif;

	public Window_JavaBank_RegistarCl(JavaBank_Gestao gestao) {
		this.gestao = gestao;
		initialize();
	}

	/**
	 * Create the panel.
	 */
	public void initialize() {
		setLayout(null);
		setSize(450, 345);
		
		JLabel lblRegistoDeFuncionrio = new JLabel("REGISTO DE CLIENTE");
		lblRegistoDeFuncionrio.setOpaque(true);
		lblRegistoDeFuncionrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistoDeFuncionrio.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblRegistoDeFuncionrio.setBackground(Color.GRAY);
		lblRegistoDeFuncionrio.setBounds(0, 0, 450, 40);
		add(lblRegistoDeFuncionrio);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNome.setBounds(86, 50, 60, 14);
		add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(156, 47, 218, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSobrenome.setBounds(48, 75, 98, 14);
		add(lblSobrenome);

		textFieldSobrenome = new JTextField();
		textFieldSobrenome.setColumns(10);
		textFieldSobrenome.setBounds(156, 72, 218, 20);
		add(textFieldSobrenome);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setBounds(86, 237, 60, 14);
		add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(156, 234, 218, 20);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setBounds(86, 262, 60, 14);
		add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(156, 259, 218, 20);
		add(passwordField);

		JLabel lblConfirmao = new JLabel("Confirma\u00E7\u00E3o");
		lblConfirmao.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConfirmao.setBounds(86, 287, 60, 14);
		add(lblConfirmao);

		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setBounds(156, 284, 218, 20);
		add(passwordFieldConfirm);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDataDeNascimento.setBounds(48, 106, 98, 14);
		add(lblDataDeNascimento);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setLocale(new Locale("pt"));
		dateChooser.setBounds(156, 103, 127, 20);
		add(dateChooser);

		JLabel lblNumId = new JLabel("N\u00BA de Identifica\u00E7\u00E3o");
		lblNumId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumId.setBounds(34, 131, 112, 14);
		add(lblNumId);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("---Escolha uma opção---");
		comboBox.addItem("Cartão de Cidadão");
		comboBox.addItem("Bilhete de Identidade");
		comboBox.addItem("Passaporte");
		comboBox.addItem("Outro");
		comboBox.setBounds(156, 128, 99, 20);
		add(comboBox);

		textFieldId = new JTextField();
		textFieldId.setBounds(265, 128, 109, 20);
		add(textFieldId);
		textFieldId.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEndereco.setBounds(101, 159, 45, 14);
		add(lblEndereco);

		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(156, 156, 218, 20);
		add(textFieldEndereco);
		textFieldEndereco.setColumns(10);

		JLabel lblNDeContacto = new JLabel("N\u00BA de Contacto");
		lblNDeContacto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNDeContacto.setBounds(48, 184, 99, 14);
		add(lblNDeContacto);

		textFieldContacto = new JTextField();
		textFieldContacto.setBounds(156, 181, 127, 20);
		add(textFieldContacto);
		textFieldContacto.setColumns(10);

		JLabel lblNDeContribuinte = new JLabel("N\u00BA de Contribuinte Fiscal");
		lblNDeContribuinte.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNDeContribuinte.setBounds(28, 209, 118, 14);
		add(lblNDeContribuinte);

		textFieldNif = new JTextField();
		textFieldNif.setBounds(156, 206, 127, 20);
		add(textFieldNif);
		textFieldNif.setColumns(10);

		JButton btnConfirm = new JButton("Confirmar");
		btnConfirm.setBounds(335, 312, 89, 23);
		add(btnConfirm);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 312, 89, 23);
		add(btnCancelar);

		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = textFieldNome.getText();
				String sobrenome = textFieldSobrenome.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String formatData = sdf.format(dateChooser.getDate());
				String data = formatData.toString();
				String tipoId = comboBox.getSelectedItem().toString();
				int numId = Integer.parseInt(textFieldId.getText());
				String endereco = textFieldEndereco.getText();
				String numContacto = textFieldContacto.getText();
				String nif = textFieldNif.getText();
				String email = textFieldEmail.getText();
				String password = new String(passwordField.getPassword());
				String passwordConfirm = new String(passwordFieldConfirm.getPassword());
				String mensagem = "";
				mensagem = gestao.registar_cliente(nome, sobrenome, data, tipoId, numId, endereco, numContacto, nif,
						email, password, passwordConfirm);
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
