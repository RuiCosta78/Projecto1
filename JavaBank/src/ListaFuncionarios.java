import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class ListaFuncionarios {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaFuncionarios window = new ListaFuncionarios();
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
	public ListaFuncionarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblListaDeFuncionrios = new JLabel("LISTA DE FUNCION\u00C1RIOS");
		lblListaDeFuncionrios.setOpaque(true);
		lblListaDeFuncionrios.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeFuncionrios.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblListaDeFuncionrios.setBackground(Color.GRAY);
		lblListaDeFuncionrios.setBounds(10, 11, 414, 40);
		frame.getContentPane().add(lblListaDeFuncionrios);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEstado.setBounds(20, 62, 46, 14);
		frame.getContentPane().add(lblEstado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Activo", "Inactivo"}));
		comboBox.setBounds(76, 59, 127, 20);
		frame.getContentPane().add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 414, 135);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Sobrenome", "Estado"
			}
		));
		scrollPane.setViewportView(table);
	}
}
