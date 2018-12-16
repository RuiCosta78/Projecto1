import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.Toolkit;

/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class VerContaCliente {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerContaCliente window = new VerContaCliente();
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
	public VerContaCliente() {
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
		
		JLabel lblInformaoDeConta = new JLabel("INFORMA\u00C7\u00C3O DE CONTA");
		lblInformaoDeConta.setOpaque(true);
		lblInformaoDeConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformaoDeConta.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblInformaoDeConta.setBackground(Color.GRAY);
		lblInformaoDeConta.setBounds(10, 11, 414, 40);
		frame.getContentPane().add(lblInformaoDeConta);
		
		JLabel lblContaN = new JLabel("Conta n\u00BA");
		lblContaN.setBounds(20, 62, 46, 14);
		frame.getContentPane().add(lblContaN);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(76, 59, 183, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblDataDeCriao = new JLabel("Data de cria\u00E7\u00E3o");
		lblDataDeCriao.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDataDeCriao.setBounds(20, 89, 75, 14);
		frame.getContentPane().add(lblDataDeCriao);
		
		JLabel lblJuros = new JLabel("Juros");
		lblJuros.setHorizontalAlignment(SwingConstants.TRAILING);
		lblJuros.setBounds(20, 114, 75, 14);
		frame.getContentPane().add(lblJuros);
		
		JLabel lblSaldo = new JLabel("Saldo");
		lblSaldo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSaldo.setBounds(20, 139, 75, 14);
		frame.getContentPane().add(lblSaldo);
		
		JLabel lblHistrico = new JLabel("Hist\u00F3rico");
		lblHistrico.setBounds(20, 164, 75, 14);
		frame.getContentPane().add(lblHistrico);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(76, 164, 284, 86);
		frame.getContentPane().add(textArea);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(343, 164, 17, 86);
		frame.getContentPane().add(scrollBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(105, 90, 255, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(105, 114, 255, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(105, 139, 255, 14);
		frame.getContentPane().add(label_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(370, 227, 62, 23);
		frame.getContentPane().add(btnVoltar);
	}
}
