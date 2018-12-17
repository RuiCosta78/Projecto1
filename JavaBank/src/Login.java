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
import javax.swing.SwingConstants;

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
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					System.out.println("fkjfkjfkjf");
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Acer\\Desktop\\Acertar o Rumo\\IPJ\\Projeto Final\\JB_Logotipo.jpg"));
		frmLogin.getContentPane().setBackground(UIManager.getColor("CheckBox.background"));
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(178, 101, 131, 20);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 147, 131, 20);
		frmLogin.getContentPane().add(passwordField);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(164, 227, 89, 23);
		frmLogin.getContentPane().add(btnEntrar);
		
		JLabel lblBenvindoAoJava = new JLabel("BENVINDO AO JAVA BANK");
		lblBenvindoAoJava.setBackground(Color.GRAY);
		lblBenvindoAoJava.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblBenvindoAoJava.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenvindoAoJava.setBounds(10, 11, 414, 40);
		frmLogin.getContentPane().add(lblBenvindoAoJava);
		lblBenvindoAoJava.setOpaque(true);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLogin.setBounds(122, 104, 46, 14);
		frmLogin.getContentPane().add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setBounds(122, 150, 46, 14);
		frmLogin.getContentPane().add(lblPassword);
	}
}
