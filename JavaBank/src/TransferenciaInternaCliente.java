import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;

/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class TransferenciaInternaCliente {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferenciaInternaCliente window = new TransferenciaInternaCliente();
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
	public TransferenciaInternaCliente() {
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
		
		JLabel lblTransfernciaInterna = new JLabel("TRANSFER\u00CANCIA INTERNA");
		lblTransfernciaInterna.setOpaque(true);
		lblTransfernciaInterna.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransfernciaInterna.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblTransfernciaInterna.setBackground(Color.GRAY);
		lblTransfernciaInterna.setBounds(10, 11, 414, 40);
		frame.getContentPane().add(lblTransfernciaInterna);
		
		JLabel lblContaOrigem = new JLabel("Conta Origem");
		lblContaOrigem.setHorizontalAlignment(SwingConstants.TRAILING);
		lblContaOrigem.setBounds(94, 81, 68, 14);
		frame.getContentPane().add(lblContaOrigem);
		
		JLabel lblContaDestino = new JLabel("Conta Destino");
		lblContaDestino.setHorizontalAlignment(SwingConstants.TRAILING);
		lblContaDestino.setBounds(94, 122, 68, 14);
		frame.getContentPane().add(lblContaDestino);
		
		JLabel lblMontante = new JLabel("Montante");
		lblMontante.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMontante.setBounds(94, 166, 68, 14);
		frame.getContentPane().add(lblMontante);
		
		textField = new JTextField();
		textField.setBounds(172, 78, 157, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(172, 119, 157, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(172, 163, 86, 20);
		frame.getContentPane().add(textField_2);
		
		JLabel label = new JLabel("\u20AC");
		label.setBounds(261, 166, 6, 14);
		frame.getContentPane().add(label);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnCancelar);
	}
}
