import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**   
 * Breve descrição do código
 *  
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VCI_Login window = new VCI_Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VCI_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rmmi7\\OneDrive\\Documentos\\Acertar o Rumo\\Aulas\\Projeto\\Relat\u00F3rio preliminar\\VC_Logotipo.jpg"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(190, 96, 150, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(251, 188, 89, 23);
		panel.add(btnOk);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(86, 188, 89, 23);
		panel.add(btnVoltar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 127, 150, 20);
		panel.add(passwordField);
		
		JLabel lblViewComicsInc = new JLabel("VIEW COMICS INC");
		lblViewComicsInc.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblViewComicsInc.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewComicsInc.setBounds(10, 11, 416, 30);
		panel.add(lblViewComicsInc);
		
		JLabel lblUtilizador = new JLabel("Utilizador:");
		lblUtilizador.setBounds(86, 102, 80, 14);
		panel.add(lblUtilizador);
		
		JLabel lblSenhaDeAcesso = new JLabel("Senha de acesso:");
		lblSenhaDeAcesso.setBounds(86, 130, 89, 14);
		panel.add(lblSenhaDeAcesso);
	}
}
