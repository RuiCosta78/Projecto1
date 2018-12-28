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
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Dimension;

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
		textField.setBounds(191, 137, 150, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(252, 229, 89, 23);
		panel.add(btnOk);
		
		JButton btnVoltar = new JButton("Voltar");
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
		lblUtilizador.setBounds(87, 143, 80, 14);
		panel.add(lblUtilizador);
		
		JLabel lblSenhaDeAcesso = new JLabel("Senha de acesso:");
		lblSenhaDeAcesso.setBounds(87, 171, 89, 14);
		panel.add(lblSenhaDeAcesso);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(178, 0, 80, 80);
		// Insertion of image adapted to the size of the jlabel (I moved the above line with bounds and dimension from down).
		ImageIcon imagem= new ImageIcon("C:\\Users\\rmmi7\\OneDrive\\Documentos\\Acertar o Rumo\\Aulas\\Projeto\\Relat\u00F3rio preliminar\\VC_Logotipo.jpg");
		Image img = imagem.getImage();
		Image img1 = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(img1);
		lblNewLabel.setIcon(i);
		panel.add(lblNewLabel);
		
	}
}
