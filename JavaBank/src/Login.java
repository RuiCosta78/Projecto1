import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Breve descrição do código
 *
 * @sid 2002
 * @aid 1.1
 */
public class Login {

	private JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;
	private JavaBank_Gestao gestao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.getFrmLogin().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login(JavaBank_Gestao gestao) {
		initialize();
		this.gestao = gestao;
	}

	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmLogin(new JFrame());
		getFrmLogin().setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Acer\\Desktop\\Acertar o Rumo\\IPJ\\Projeto Final\\JB_Logotipo.jpg"));
		getFrmLogin().getContentPane().setBackground(UIManager.getColor("CheckBox.background"));
		getFrmLogin().setBounds(100, 100, 450, 300);
		getFrmLogin().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmLogin().getContentPane().setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLogin.setBounds(38, 104, 89, 14);
		getFrmLogin().getContentPane().add(lblLogin);

		textField = new JTextField();
		textField.setBounds(137, 101, 216, 20);
		getFrmLogin().getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setBounds(38, 150, 89, 14);
		getFrmLogin().getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(137, 147, 216, 20);
		getFrmLogin().getContentPane().add(passwordField);

		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = passwordField.getText();
				gestao = new JavaBank_Gestao();
				gestao.login(username, password);
			}
		});
		btnEntrar.setBounds(164, 227, 89, 23);
		getFrmLogin().getContentPane().add(btnEntrar);

		JLabel lblBenvindoAoJava = new JLabel("BENVINDO AO JAVA BANK");
		lblBenvindoAoJava.setBackground(Color.GRAY);
		lblBenvindoAoJava.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblBenvindoAoJava.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenvindoAoJava.setBounds(10, 11, 414, 40);
		getFrmLogin().getContentPane().add(lblBenvindoAoJava);
		lblBenvindoAoJava.setOpaque(true);
	}

	public JFrame getFrmLogin() {
		return frmLogin;
	}

	public void setFrmLogin(JFrame frmLogin) {
		this.frmLogin = frmLogin;
	}
}
