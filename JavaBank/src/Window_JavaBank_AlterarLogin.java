import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class Window_JavaBank_AlterarLogin extends JPanel {
	
	private JavaBank_Gestao gestao = new JavaBank_Gestao();
	private JTextField textFieldUsername;
	private JTextField textFieldUsernameConfirm;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldConfirm;

	public Window_JavaBank_AlterarLogin(JavaBank_Gestao gestao) {
		this.gestao = gestao;
		initialize();
	}

	/**
	 * Create the panel.
	 */
	public void initialize() {
		setLayout(null);
		JLabel lblAlterarDadosDe = new JLabel("ALTERAR DADOS DE LOGIN");
		lblAlterarDadosDe.setOpaque(true);
		lblAlterarDadosDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterarDadosDe.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblAlterarDadosDe.setBackground(Color.GRAY);
		lblAlterarDadosDe.setBounds(0, 0, 424, 40);
		add(lblAlterarDadosDe);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(0, 227, 89, 23);
		add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(335, 227, 89, 23);
		add(btnConfirmar);
		
		JLabel lblNovoUsername = new JLabel("Novo username");
		lblNovoUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNovoUsername.setBounds(47, 84, 89, 14);
		add(lblNovoUsername);
		
		JLabel lblConfirmao = new JLabel("Confirma\u00E7\u00E3o");
		lblConfirmao.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConfirmao.setBounds(47, 109, 89, 14);
		add(lblConfirmao);
		
		JLabel lblNovaPassword = new JLabel("Nova password");
		lblNovaPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNovaPassword.setBounds(47, 134, 89, 14);
		add(lblNovaPassword);
		
		JLabel lblConfirmao_1 = new JLabel("Confirma\u00E7\u00E3o");
		lblConfirmao_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConfirmao_1.setBounds(47, 159, 89, 14);
		add(lblConfirmao_1);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(146, 81, 227, 20);
		add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textFieldUsernameConfirm = new JTextField();
		textFieldUsernameConfirm.setBounds(146, 106, 227, 20);
		add(textFieldUsernameConfirm);
		textFieldUsernameConfirm.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 131, 227, 20);
		add(passwordField);
		
		passwordFieldConfirm = new JPasswordField();
		passwordFieldConfirm.setBounds(146, 156, 227, 20);
		add(passwordFieldConfirm);
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textFieldUsername.getText();
				String userConfirm = textFieldUsernameConfirm.getText();
				String password = new String(passwordField.getPassword());
				String passwordConfirm = new String(passwordFieldConfirm.getPassword());
				String mensagem = gestao.alterar_login(username, userConfirm, password, passwordConfirm);
				JOptionPane.showMessageDialog(getParent(), mensagem);
				if (mensagem.equals("Alteração concluída com sucesso")) {
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

	public JTextField getTextFieldUsernameConfirm() {
		return textFieldUsernameConfirm;
	}

	public JPasswordField getPasswordFieldConfirm() {
		return passwordFieldConfirm;
	}
	
}
