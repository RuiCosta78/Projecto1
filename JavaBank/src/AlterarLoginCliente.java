import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class AlterarLoginCliente {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarLoginCliente window = new AlterarLoginCliente();
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
	public AlterarLoginCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Acer\\Desktop\\Acertar o Rumo\\IPJ\\Projeto Final\\JB_Logotipo.jpg"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAlteraoDeLogin = new JLabel("ALTERA\u00C7\u00C3O DE LOGIN");
		lblAlteraoDeLogin.setOpaque(true);
		lblAlteraoDeLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlteraoDeLogin.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblAlteraoDeLogin.setBackground(Color.GRAY);
		lblAlteraoDeLogin.setBounds(10, 11, 414, 40);
		frame.getContentPane().add(lblAlteraoDeLogin);
		
		JLabel lblNovoEmail = new JLabel("Novo Email");
		lblNovoEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNovoEmail.setBounds(20, 80, 96, 14);
		frame.getContentPane().add(lblNovoEmail);
		
		JLabel lblConfirmarEmail = new JLabel("Confirmar Email");
		lblConfirmarEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConfirmarEmail.setBounds(20, 105, 96, 14);
		frame.getContentPane().add(lblConfirmarEmail);
		
		JLabel lblNovaPassword = new JLabel("Nova Password");
		lblNovaPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNovaPassword.setBounds(20, 130, 96, 14);
		frame.getContentPane().add(lblNovaPassword);
		
		JLabel lblConfirmarPassword = new JLabel("Confirmar Password");
		lblConfirmarPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConfirmarPassword.setBounds(20, 155, 96, 14);
		frame.getContentPane().add(lblConfirmarPassword);
		
		textField = new JTextField();
		textField.setBounds(127, 77, 297, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(127, 127, 297, 20);
		frame.getContentPane().add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(127, 102, 297, 20);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(127, 152, 297, 20);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnConfirmar);
		
		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(button);
	}

}
