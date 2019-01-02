import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Breve descrição do código
 * 
 * @sid 2001
 * @aid 1.1
 */

public class VCI_ListarLivros {

	private JFrame frame;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the application.
	 */
	public VCI_ListarLivros() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\rmmi7\\OneDrive\\Documentos\\Acertar o Rumo\\Aulas\\Projeto\\Relat\u00F3rio preliminar\\VC_Logotipo.jpg"));
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

		JLabel lblListagemDeLivros = new JLabel("Listagem de conjuntos de livros");
		lblListagemDeLivros.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblListagemDeLivros.setBounds(10, 30, 416, 24);
		panel.add(lblListagemDeLivros);

		JLabel lblListrLivrosPor = new JLabel("Listar livros por:");
		lblListrLivrosPor.setHorizontalAlignment(SwingConstants.LEFT);
		lblListrLivrosPor.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblListrLivrosPor.setBounds(10, 65, 117, 23);
		panel.add(lblListrLivrosPor);

		JRadioButton rdbtnAutor = new JRadioButton("Autor");
		rdbtnAutor.setBounds(133, 67, 90, 23);
		panel.add(rdbtnAutor);

		JRadioButton rdbtnEditora = new JRadioButton("Editora");
		rdbtnEditora.setBounds(262, 67, 111, 23);
		panel.add(rdbtnEditora);

		JRadioButton rdbtnAnoDeEdio = new JRadioButton("Ano de edi\u00E7\u00E3o");
		rdbtnAnoDeEdio.setBounds(133, 93, 117, 23);
		panel.add(rdbtnAnoDeEdio);

		JRadioButton rdbtnPreoMximo = new JRadioButton("Pre\u00E7o m\u00E1ximo");
		rdbtnPreoMximo.setBounds(262, 93, 111, 23);
		panel.add(rdbtnPreoMximo);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 116, 406, 20);
		panel.add(textField);

		// VOLTAR
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				if (VCI_cl_Gestao.utilizador instanceof VCI_cl_Admin) {
					VCI_ADMIN window = new VCI_ADMIN();
					window.getFrames(); // Ativa a janela a que o botão dá acesso;
				} else if (VCI_cl_Gestao.utilizador instanceof VCI_cl_Vendedor) {
					VCI_VENDEDOR window = new VCI_VENDEDOR();
					window.getFrame(); // Ativa a janela a que o botão dá acesso;
				} else {
					VCI_Cliente_Op window = new VCI_Cliente_Op();
					window.getFrame(); // Ativa a janela a que o botão dá acesso;
				}
			}
		});
		button.setBounds(10, 229, 89, 23);
		panel.add(button);

		JButton button_1 = new JButton("Confirmar");
		button_1.setBounds(327, 229, 89, 23);
		panel.add(button_1);

		JLabel lblResultados = new JLabel("Resultados:");
		lblResultados.setHorizontalAlignment(SwingConstants.LEFT);
		lblResultados.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblResultados.setBounds(10, 147, 117, 23);
		panel.add(lblResultados);

		table = new JTable();
		table.setBounds(10, 170, 406, 36);
		panel.add(table);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
