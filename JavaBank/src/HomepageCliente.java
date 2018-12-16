import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
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
public class HomepageCliente {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomepageCliente window = new HomepageCliente();
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
	public HomepageCliente() {
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
		
		JLabel lblBenvindonome = new JLabel("BENVINDO (nome)");
		lblBenvindonome.setOpaque(true);
		lblBenvindonome.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenvindonome.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblBenvindonome.setBackground(Color.GRAY);
		lblBenvindonome.setBounds(10, 11, 414, 40);
		frame.getContentPane().add(lblBenvindonome);
		
		JLabel lblEscolhaAOpo = new JLabel("Escolha a op\u00E7\u00E3o");
		lblEscolhaAOpo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEscolhaAOpo.setBounds(10, 79, 92, 14);
		frame.getContentPane().add(lblEscolhaAOpo);
		
		JButton btnNewButton = new JButton("Alterar Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(97, 104, 123, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Ver Conta");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(97, 170, 123, 40);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Pedir Cartão de Débito");
		button_1.setToolTipText("Pedir Cart\u00E3o de D\u00E9bito");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(230, 170, 123, 40);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Transferência Interna");
		button_2.setToolTipText("Transfer\u00EAncia Interna");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(230, 104, 123, 40);
		frame.getContentPane().add(button_2);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogout.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnLogout);
	}

}
