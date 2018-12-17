import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

/**   
 * Breve descrição do código
 *  
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_Cliente_Nome {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VCI_Cliente_Nome window = new VCI_Cliente_Nome();
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
	public VCI_Cliente_Nome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rmmi7\\OneDrive\\Documentos\\Acertar o Rumo\\Aulas\\Projeto\\Relat\u00F3rio preliminar\\VC_Logotipo.jpg"));
		frame.setBounds(100, 100, 450, 300);
		
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
		label_1.setBounds(20, 41, 111, 24);
		panel.add(label_1);
		
		JLabel lblParaExplorarA = new JLabel("Para explorar a livraria, indique um nome");
		lblParaExplorarA.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblParaExplorarA.setBounds(20, 74, 406, 24);
		panel.add(lblParaExplorarA);
		
		JLabel lblDeUtilizador = new JLabel("de utilizador:");
		lblDeUtilizador.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblDeUtilizador.setBounds(20, 97, 406, 24);
		panel.add(lblDeUtilizador);
		
		textField = new JTextField();
		textField.setBounds(162, 156, 111, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("OK");
		button.setBounds(188, 206, 59, 23);
		panel.add(button);
	}

}
