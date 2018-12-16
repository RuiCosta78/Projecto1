import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;

/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class RegistarFuncionario {

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
					RegistarFuncionario window = new RegistarFuncionario();
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
	public RegistarFuncionario() {
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
		
		JLabel lblRegistoDeFuncionrio = new JLabel("REGISTO DE FUNCION\u00C1RIO");
		lblRegistoDeFuncionrio.setOpaque(true);
		lblRegistoDeFuncionrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistoDeFuncionrio.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblRegistoDeFuncionrio.setBackground(Color.GRAY);
		lblRegistoDeFuncionrio.setBounds(10, 11, 414, 40);
		frame.getContentPane().add(lblRegistoDeFuncionrio);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNome.setBounds(67, 82, 60, 14);
		frame.getContentPane().add(lblNome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setBounds(67, 107, 60, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setBounds(67, 132, 60, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblConfirmao = new JLabel("Confirma\u00E7\u00E3o");
		lblConfirmao.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConfirmao.setBounds(67, 157, 60, 14);
		frame.getContentPane().add(lblConfirmao);
		
		textField = new JTextField();
		textField.setBounds(137, 79, 218, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 104, 218, 20);
		frame.getContentPane().add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(137, 129, 218, 20);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(137, 154, 218, 20);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnCancelar);
	}
}
