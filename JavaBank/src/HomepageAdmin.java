import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Toolkit;

/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class HomepageAdmin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomepageAdmin window = new HomepageAdmin();
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
	public HomepageAdmin() {
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
		
		JLabel label = new JLabel("BENVINDO (nome)");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial Black", Font.PLAIN, 17));
		label.setBackground(Color.GRAY);
		label.setBounds(10, 11, 414, 40);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Escolha a op\u00E7\u00E3o");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(10, 79, 92, 14);
		frame.getContentPane().add(label_1);
		
		JButton button = new JButton("Alterar Login");
		button.setBounds(97, 104, 123, 40);
		frame.getContentPane().add(button);
		
		JButton btnRegistarFuncionrio = new JButton("Registar Funcion\u00E1rio");
		btnRegistarFuncionrio.setToolTipText("Registar Funcion\u00E1rio");
		btnRegistarFuncionrio.setBounds(97, 170, 123, 40);
		frame.getContentPane().add(btnRegistarFuncionrio);
		
		JButton btnListarClientes = new JButton("Listar Clientes");
		btnListarClientes.setToolTipText("");
		btnListarClientes.setBounds(230, 170, 123, 40);
		frame.getContentPane().add(btnListarClientes);
		
		JButton btnListarContas = new JButton("Listar Contas");
		btnListarContas.setToolTipText("");
		btnListarContas.setBounds(230, 104, 123, 40);
		frame.getContentPane().add(btnListarContas);
		
		JButton button_4 = new JButton("Logout");
		button_4.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(button_4);
	}

}
