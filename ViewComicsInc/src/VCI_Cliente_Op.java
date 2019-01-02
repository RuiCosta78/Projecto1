import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**   
 * Breve descrição do código
 *  
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_Cliente_Op {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public VCI_Cliente_Op() {
		initialize();
		frame.setVisible(true);
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
		
		JLabel label_1 = new JLabel("Selecione uma op\u00E7\u00E3o:");
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_1.setBounds(33, 56, 196, 24);
		panel.add(label_1);
		
		// LISTAR LIVROS
		JButton btnListarTodosOs = new JButton("Listar livros");
		btnListarTodosOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				VCI_ListarLivros window = new VCI_ListarLivros();
				window.getFrame().setVisible(true);;
			}
		});
		btnListarTodosOs.setBounds(125, 107, 148, 23);
		panel.add(btnListarTodosOs);
		
		// PESQUISAR LIVROS
		JButton btnPesquisarLivros = new JButton("Pesquisar livros");
		btnPesquisarLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				VCI_PesLivro window = new VCI_PesLivro();
				window.getFrame().setVisible(true);;
			}
		});
		btnPesquisarLivros.setBounds(125, 154, 148, 23);
		panel.add(btnPesquisarLivros);
		
		// VOLTAR
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				VCI_N1 window = new VCI_N1();
				window.getFrame().setVisible(true);;
			}
		});
		btnVoltar.setBounds(343, 229, 83, 23);
		panel.add(btnVoltar);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
