import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

/**   
 * Breve descrição do código
 *  
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_Vendedor_Op {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VCI_Vendedor_Op window = new VCI_Vendedor_Op();
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
	public VCI_Vendedor_Op() {
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
		
		JLabel label = new JLabel("VIEW COMICS INC");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label.setBounds(10, 0, 416, 30);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Benvindo!");
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_1.setBounds(10, 52, 111, 24);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Selecione uma op\u00E7\u00E3o:");
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_2.setBounds(10, 85, 196, 24);
		panel.add(label_2);
		
		JButton button = new JButton("Alterar login");
		button.setBounds(10, 128, 133, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Listar livros");
		button_1.setBounds(153, 128, 133, 23);
		panel.add(button_1);
		
		JButton btnConcluirCompra = new JButton("Concluir compra");
		btnConcluirCompra.setBounds(293, 128, 133, 23);
		panel.add(btnConcluirCompra);
		
		JButton button_3 = new JButton("Logout");
		button_3.setBounds(293, 229, 133, 23);
		panel.add(button_3);
		
		JButton button_4 = new JButton("Pesquisar livros");
		button_4.setBounds(153, 162, 133, 23);
		panel.add(button_4);
	}

}
