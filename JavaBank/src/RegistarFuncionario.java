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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

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
	private JTextField textField_2;
	private JavaBank_Gestao gestao;

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
	
	public RegistarFuncionario(JavaBank_Gestao gestao) {
		initialize();
		this.gestao = gestao;
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
		
		textField = new JTextField();
		textField.setBounds(137, 79, 218, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSobrenome.setBounds(29, 107, 98, 14);
		frame.getContentPane().add(lblSobrenome);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 104, 218, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setBounds(67, 134, 60, 14);
		frame.getContentPane().add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(137, 131, 218, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setBounds(67, 159, 60, 14);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(137, 156, 218, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblConfirmao = new JLabel("Confirma\u00E7\u00E3o");
		lblConfirmao.setHorizontalAlignment(SwingConstants.TRAILING);
		lblConfirmao.setBounds(67, 184, 60, 14);
		frame.getContentPane().add(lblConfirmao);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(137, 181, 218, 20);
		frame.getContentPane().add(passwordField_1);
		
		JLabel lblActivo = new JLabel("Activo");
		lblActivo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblActivo.setBounds(81, 209, 46, 14);
		frame.getContentPane().add(lblActivo);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(137, 205, 97, 23);
		frame.getContentPane().add(checkBox);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = textField.getText();
				String sobrenome = textField_1.getText();
				String email = textField_2.getText();
				String password = passwordField.getText();
				boolean bool = checkBox.isSelected();
				String estado = "";
				if(bool) {
					estado.equals("Activo");
				} else {
					estado.equals("Inactivo");
				}
				gestao = new JavaBank_Gestao();
				gestao.resgistar_funcionario(nome, sobrenome, email, password, estado);
			}
		});
		btnConfirmar.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnCancelar);	
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPasswordField getPasswordField_1() {
		return passwordField_1;
	}

	public void setPasswordField_1(JPasswordField passwordField_1) {
		this.passwordField_1 = passwordField_1;
	}
}
