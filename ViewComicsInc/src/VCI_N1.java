import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
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
	private VCI_cl_Gestao g = new VCI_cl_Gestao();

	public VCI_N1(VCI_cl_Gestao g) {
		this.g = g;
		initialize();
	}
	
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

		// Botão "Acesso ao Sistema"
		JButton btnAcessoSistema = new JButton("ACESSO SISTEMA");
		btnAcessoSistema.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAcessoSistema.addActionListener(new ActionListener() {
			// Adição de ação ao botão:
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose(); // desliga a janela ativa;
				VCI_Login window = new VCI_Login(g);
				window.getFrame(); // Ativa a janela a que o botão dá acesso;
			}
		});
		btnAcessoSistema.setBounds(10, 214, 130, 23);
		panel.add(btnAcessoSistema);
		
		// Botão "Acesso à Loja"
		JButton btnAcessoLoja = new JButton("ACESSO LOJA");
		btnAcessoLoja.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAcessoLoja.addActionListener(new ActionListener() {
			// Adição de ação ao botão:
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose(); // desliga a janela ativa;
				VCI_Cliente_Nome window = new VCI_Cliente_Nome(g);
				window.getFrame(); // Ativa a janela a que o botão dá acesso;
			}
		});
		btnAcessoLoja.setBounds(153, 214, 130, 23);
		panel.add(btnAcessoLoja);

		JLabel lblBenvindoView = new JLabel("BENVINDO \u00C0 VIEW COMICS INC");
		lblBenvindoView.setOpaque(true);
		lblBenvindoView.setBackground(UIManager.getColor("CheckBox.background"));
		lblBenvindoView.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenvindoView.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblBenvindoView.setBounds(10, 11, 416, 26);
		panel.add(lblBenvindoView);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(UIManager.getColor("CheckBox.background"));
		lblNewLabel.setBounds(145, 48, 150, 150);
		// Insertion of image adapted to the size of the jlabel.
		ImageIcon imagem = new ImageIcon(
				"C:\\Users\\rmmi7\\OneDrive\\Documentos\\Acertar o Rumo\\Aulas\\Projeto\\Relat\u00F3rio preliminar\\VC_Logotipo.jpg");
		Image img = imagem.getImage();
		Image img1 = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(img1);
		lblNewLabel.setIcon(i);

		panel.add(lblNewLabel);
		
		// SAIR
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSair.setBounds(296, 214, 130, 23);
		panel.add(btnSair);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
