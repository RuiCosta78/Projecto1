import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;

/**   
 * Breve descrição do código
 *  
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_N1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VCI_N1 window = new VCI_N1();
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
	public VCI_N1() {
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
		
		JButton btnAcessoSistema = new JButton("ACESSO SISTEMA");
		btnAcessoSistema.setBounds(67, 179, 130, 23);
		panel.add(btnAcessoSistema);
		
		JButton btnAcessoLoja = new JButton("ACESSO LOJA");
		btnAcessoLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAcessoLoja.setBounds(234, 179, 130, 23);
		panel.add(btnAcessoLoja);
		
		JLabel lblBenvindoView = new JLabel("BENVINDO \u00C0 VIEW COMICS INC");
		lblBenvindoView.setOpaque(true);
		lblBenvindoView.setBackground(UIManager.getColor("CheckBox.background"));
		lblBenvindoView.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenvindoView.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblBenvindoView.setBounds(10, 11, 416, 26);
		panel.add(lblBenvindoView);
	}
}
