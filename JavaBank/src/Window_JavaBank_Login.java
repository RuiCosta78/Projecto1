import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Breve descrição do código
 *
 * @sid 2002
 * @aid 1.1
 */
public class Window_JavaBank_Login {

	private JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;
	private JavaBank_Gestao gestao = new JavaBank_Gestao();

	/**
	 * Create the application.
	 */

	public Window_JavaBank_Login(JavaBank_Gestao gestao) {
		this.gestao = gestao;
		initialize();
	}

	public Window_JavaBank_Login() throws ClassNotFoundException, IOException {
		gestao.abrirUtilizadores();
		gestao.abrirContas();
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
		btnEntrar.setBounds(164, 227, 89, 23);
		getFrmLogin().getContentPane().add(btnEntrar);

		JLabel lblBenvindoAoJava = new JLabel("BENVINDO AO JAVA BANK");
		lblBenvindoAoJava.setBackground(Color.GRAY);
		lblBenvindoAoJava.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblBenvindoAoJava.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenvindoAoJava.setBounds(10, 11, 414, 40);
		getFrmLogin().getContentPane().add(lblBenvindoAoJava);
		lblBenvindoAoJava.setOpaque(true);

		Action action = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = new String(passwordField.getPassword());
				String mensagem = null;
				mensagem = gestao.login(username, password);

				JOptionPane.showMessageDialog(frmLogin, mensagem);
				if (mensagem.equals("Login de Admin com sucesso")) {
					frmLogin.setVisible(false);
					Window_JavaBank_HomepageAdmin hpadmin = new Window_JavaBank_HomepageAdmin(gestao);
				} else if (mensagem.equals("Login de Funcionário com sucesso")) {
					frmLogin.setVisible(false);
					Window_JavaBank_HomepageFunc hpfunc = new Window_JavaBank_HomepageFunc(gestao);
				} else if (mensagem.equals("Login de Cliente com sucesso")) {
					frmLogin.setVisible(false);
					Window_JavaBank_HomepageCliente hpcli = new Window_JavaBank_HomepageCliente(gestao);
				} else {
					return;
				}
			}
		};

		btnEntrar.addActionListener(action);
		passwordField.addActionListener(action);

	}

	public JFrame getFrmLogin() {
		return frmLogin;
	}

	public void setFrmLogin(JFrame frmLogin) {
		this.frmLogin = frmLogin;
		frmLogin.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				try {
					gestao.gravarUtilizadores();
					gestao.gravarContas();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

}
