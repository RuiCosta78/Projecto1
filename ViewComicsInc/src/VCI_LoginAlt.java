import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

/**
 * Breve descrição do código
 * 
 * @sid 2001
 * @aid 1.1
 */

public class VCI_LoginAlt {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	VCI_cl_Gestao g;

	/**
	 * Create the application.
	 */
	public VCI_LoginAlt(VCI_cl_Gestao g) {
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

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel label = new JLabel("VIEW COMICS INC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label.setBounds(10, 0, 416, 30);
		panel.add(label);

		JLabel lblNovoUtilizador = new JLabel("Novo email:");
		lblNovoUtilizador.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNovoUtilizador.setBounds(36, 94, 161, 14);
		panel.add(lblNovoUtilizador);

		JLabel lblRepitaASenha = new JLabel("Repita a senha de acesso:");
		lblRepitaASenha.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRepitaASenha.setBounds(37, 197, 160, 14);
		panel.add(lblRepitaASenha);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(204, 91, 150, 20);
		panel.add(textField);

		passwordField = new JPasswordField();
		passwordField.setBounds(204, 191, 150, 20);
		panel.add(passwordField);

		// VOLTAR
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				if (VCI_cl_Gestao.utilizador instanceof VCI_cl_Admin) {
					VCI_ADMIN window = null;
					try {
						window = new VCI_ADMIN(g);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					window.getFrames(); // Ativa a janela a que o botão dá acesso;
				} else if (VCI_cl_Gestao.utilizador instanceof VCI_cl_Vendedor) {
					VCI_VENDEDOR window = new VCI_VENDEDOR(g);
					window.getFrame(); // Ativa a janela a que o botão dá acesso;
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button.setBounds(100, 222, 89, 30);
		panel.add(button);

		// Botão "Confirmar" para aceitação dos novos dados de login.
		JButton button_1 = new JButton("Confirmar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String u1 = textField.getText(); // lê o utilizador introduzido
				String u2 = textField_1.getText(); // lê o utilizador introduzido
				String utilizador = "";
				boolean ut = false;
				if (u1.equals(u2)) { // Verifica se os dois emails coincidem.
					utilizador = u1;
					if (g.validarEmail(u1)) { // Validação do formato do email.
					ut = true;
					} else {
						JOptionPane.showMessageDialog(frame,
								"Endereço de email inválido (introduzir na forma _@_.com, pt, etc");
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Introduzidos endereços de email diferentes.");
				}
				boolean pw = false;
				String s1 = passwordField.getText(); // lê a senha introduzida
				String s2 = passwordField_1.getText(); // lê a senha introduzida
				String senha = "";
				if (s1.equals(s2)) { // Verifica se as duas senhas são iguais.
					senha = s1;
					if (senha.length() >= 8) { // Verifica se a senha tem o tamanho mínimo.
						pw = true;
					} else {
						JOptionPane.showMessageDialog(frame, "Senha sem o número mínimo de caracteres.");
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Introduzidas senhas de acesso diferentes.");
				}
				if (ut == true && pw == true) { // Caso o email e a senha sejam válidos,
					try {
						g.alterarLogin(utilizador, senha);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// Altera os dados de login
					JOptionPane.showMessageDialog(frame, "Dados de login alterados com sucesso.");
					frame.dispose(); // Desativa a janela em visualização.
					// Retorno à janela das opções do utilizador ativo,
					// identificando na gestão qual o utilizador em sessão (variável pública estabelecida no login):
					if (VCI_cl_Gestao.utilizador instanceof VCI_cl_Admin) {
						VCI_ADMIN window = null;
						try {
							window = new VCI_ADMIN(g);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						window.getFrames(); // Ativa a janela das opções do Admin.
					} else if (VCI_cl_Gestao.utilizador instanceof VCI_cl_Vendedor) {
						VCI_VENDEDOR window = new VCI_VENDEDOR(g);
						window.getFrame(); // Ativa a janela das opções do Vendedor.
					}
				}
			}
		});
		
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_1.setBounds(265, 222, 89, 30);
		panel.add(button_1);

		JLabel lblRepitaUtilizador = new JLabel("Repita o email:");
		lblRepitaUtilizador.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRepitaUtilizador.setBounds(36, 129, 161, 14);
		panel.add(lblRepitaUtilizador);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(204, 126, 150, 20);
		panel.add(textField_1);

		JLabel lblNovaSenhaDe = new JLabel("Nova senha de acesso:");
		lblNovaSenhaDe.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNovaSenhaDe.setBounds(36, 162, 161, 14);
		panel.add(lblNovaSenhaDe);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(203, 158, 150, 20);
		panel.add(passwordField_1);

		JLabel lblIntroduzaOsNovos = new JLabel("Introduza os novos dados:");
		lblIntroduzaOsNovos.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblIntroduzaOsNovos.setBounds(10, 44, 416, 24);
		panel.add(lblIntroduzaOsNovos);

		JLabel label_1 = new JLabel("(m\u00EDnimo 8 caracteres)");
		label_1.setHorizontalAlignment(SwingConstants.TRAILING);
		label_1.setBounds(36, 177, 161, 14);
		panel.add(label_1);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JPasswordField getPasswordField_1() {
		return passwordField_1;
	}

	public void setPasswordField_1(JPasswordField passwordField_1) {
		this.passwordField_1 = passwordField_1;
	}

}
