import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private VCI_cl_Gestao g;

	/**
	 * Create the application.
	 */
	public VCI_Login(VCI_cl_Gestao g) {
		initialize();
		this.g = g;
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\rmmi7\\OneDrive\\Documentos\\Acertar o Rumo\\Aulas\\Projeto\\Relat\u00F3rio preliminar\\VC_Logotipo.jpg"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(191, 137, 150, 20);
		panel.add(textField);
		textField.setColumns(10);

		// Botão "Confirmar"
		JButton btnOk = new JButton("Confirmar");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnOk.addActionListener(new ActionListener() {
			// Evento associado à seleção do botão:
			public void actionPerformed(ActionEvent arg0) {
				String utilizador = textField.getText(); // lê o utilizador introduzido
				boolean ut = false;
				String senha = passwordField.getText(); // lê a password introduzida
				boolean sn = false;
				if (g.validarEmail(utilizador)) { // Verifica o formato do email.
					ut = true;
				} else {
					JOptionPane.showMessageDialog(frame,
							"Endereço de email inválido (introduzir na forma _@_.com ou _@_.pt");
				}
				if (senha.length() >= 8) {
					sn = true; // Verifica o tamanho mínimo da senha.
				} else {
					JOptionPane.showMessageDialog(frame, "Senha sem o número mínimo de caracteres.");
				}
				if (ut == true && sn == true) {
					String retornoLogin="";
					try {
						retornoLogin = g.login(utilizador, senha);
					} catch (ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} // Faz o login.
					if (retornoLogin.equals("Admin")) { // Se retorno der Admin,
						frame.dispose(); // desliga a janela ativa;
						VCI_ADMIN window = null;
						try {
							window = new VCI_ADMIN(g);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						window.getFrames(); // Ativa a janela a que o botão dá acesso;
					} else if (retornoLogin.equals("Vendedor")) { // Se retorno der Vendedor,
						if (((VCI_cl_Vendedor) VCI_cl_Gestao.utilizador).isEstado() == true) {
							frame.dispose(); // desliga a janela ativa;
							VCI_VENDEDOR window = new VCI_VENDEDOR(g);
							window.getFrame(); // Ativa a janela a que o botão dá acesso;
						} else {
							JOptionPane.showMessageDialog(frame, "Vendedor inativo. Contactar o Administrador.");
							}
					} else { // Dados errados ou utilizador não registado.
						JOptionPane.showMessageDialog(frame, "Utilizador não registado ou dados incorretos.");
					}
				}
			}
		});
		btnOk.setBounds(252, 229, 89, 23);
		panel.add(btnOk);

		// Botão "Voltar"
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnVoltar.addActionListener(new ActionListener() {
			// Adição de ação ao botão:
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose(); // desliga a janela ativa;
				VCI_N1 window = new VCI_N1(g);
				window.getFrame().setVisible(true);
				; // Ativa a janela a que o botão dá acesso;
			}
		});
		btnVoltar.setBounds(87, 229, 89, 23);
		panel.add(btnVoltar);

		passwordField = new JPasswordField();
		passwordField.setBounds(191, 168, 150, 20);
		panel.add(passwordField);

		JLabel lblViewComicsInc = new JLabel("VIEW COMICS INC");
		lblViewComicsInc.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblViewComicsInc.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewComicsInc.setBounds(10, 85, 416, 30);
		panel.add(lblViewComicsInc);

		JLabel lblUtilizador = new JLabel("Utilizador:");
		lblUtilizador.setHorizontalAlignment(SwingConstants.TRAILING);
		lblUtilizador.setBounds(96, 140, 80, 14);
		panel.add(lblUtilizador);

		JLabel lblSenhaDeAcesso = new JLabel("(m\u00EDnimo 8 caracteres)");
		lblSenhaDeAcesso.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSenhaDeAcesso.setBounds(26, 184, 150, 14);
		panel.add(lblSenhaDeAcesso);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(178, 0, 80, 80);

		// Insertion of image adapted to the size of the jlabel (I moved the above line
		// with bounds and dimension from down).
		ImageIcon imagem = new ImageIcon(
				"C:\\Users\\rmmi7\\OneDrive\\Documentos\\Acertar o Rumo\\Aulas\\Projeto\\Relat\u00F3rio preliminar\\VC_Logotipo.jpg");
		Image img = imagem.getImage();
		Image img1 = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(img1);
		lblNewLabel.setIcon(i);
		panel.add(lblNewLabel);

		JLabel label = new JLabel("Senha de acesso:");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		label.setBounds(66, 169, 110, 14);
		panel.add(label);

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
}
