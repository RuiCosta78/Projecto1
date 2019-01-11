import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class Window_JavaBank_RegistarFunc extends JPanel {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JavaBank_Gestao gestao;
	
	

	public Window_JavaBank_RegistarFunc(JavaBank_Gestao gestao) {
		this.gestao = gestao;
		initialize();
	}



	/**
	 * Create the panel.
	 */
	public void initialize() {
		setLayout(null);
		JLabel lblRegistoDeFuncionrio = new JLabel("REGISTO DE FUNCION\u00C1RIO");
		lblRegistoDeFuncionrio.setOpaque(true);
		lblRegistoDeFuncionrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistoDeFuncionrio.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblRegistoDeFuncionrio.setBackground(Color.GRAY);
		lblRegistoDeFuncionrio.setBounds(0, 0, 424, 40);
		add(lblRegistoDeFuncionrio);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNome.setBounds(86, 50, 60, 14);
		add(lblNome);

		textField = new JTextField();
		textField.setBounds(156, 47, 218, 20);
		add(textField);
		textField.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSobrenome.setBounds(48, 75, 98, 14);
		add(lblSobrenome);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(156, 72, 218, 20);
		add(textField_1);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setBounds(86, 102, 60, 14);
		add(lblEmail);

		textField_2 = new JTextField();
		textField_2.setBounds(156, 99, 218, 20);
		add(textField_2);
		textField_2.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setBounds(86, 127, 60, 14);
		add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(156, 124, 218, 20);
		add(passwordField);

		JLabel lblConfirmao = new JLabel("Confirma\u00E7\u00E3o");
		lblConfirmao.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConfirmao.setBounds(86, 152, 60, 14);
		add(lblConfirmao);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(156, 149, 218, 20);
		add(passwordField_1);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEstado.setBounds(100, 177, 46, 14);
		add(lblEstado);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(335, 227, 89, 23);
		add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(0, 227, 89, 23);
		add(btnCancelar);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("---Escolha a opção---");
		comboBox.addItem("Activo");
		comboBox.addItem("Inactivo");
		comboBox.setBounds(156, 174, 130, 20);
		add(comboBox);
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = textField.getText();
				String sobrenome = textField_1.getText();
				String email = textField_2.getText();
				String password = new String(passwordField.getPassword());
				String passwordConfirm = new String(passwordField_1.getPassword());
				String estado = comboBox.getSelectedItem().toString();
				String mensagem = "";
				mensagem = gestao.registar_funcionario(nome, sobrenome, email, password, passwordConfirm, estado);
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

	public JPasswordField getPasswordField_1() {
		return passwordField_1;
	}
}
