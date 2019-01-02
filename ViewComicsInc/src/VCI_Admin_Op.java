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

public class VCI_Admin_Op {

	private JFrame frame;


	/**
	 * Create the application.
	 */
	public VCI_Admin_Op() {
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
		
		JLabel lblBenvindo = new JLabel("Benvindo!");
		lblBenvindo.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblBenvindo.setBounds(20, 41, 111, 24);
		panel.add(lblBenvindo);
		
		JLabel lblSelecioneUmaOpo = new JLabel("Selecione uma op\u00E7\u00E3o:");
		lblSelecioneUmaOpo.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblSelecioneUmaOpo.setBounds(20, 74, 196, 24);
		panel.add(lblSelecioneUmaOpo);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose(); // Fecha a janela (fecha o programa)
			}
		});
		btnLogout.setBounds(293, 229, 133, 23);
		panel.add(btnLogout);
		
		JButton btnAlterarLogin = new JButton("Alterar login");
		btnAlterarLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				VCI_LoginAlt window = new VCI_LoginAlt();
				window.getFrame(); // Ativa a janela a que o botão dá acesso;
			}
		});
		btnAlterarLogin.setBounds(10, 109, 133, 23);
		panel.add(btnAlterarLogin);
		
		JButton btnRegistarVendedor = new JButton("Registar Vendedor");
		btnRegistarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				VCI_ADMIN1 window = new VCI_ADMIN1();
				window.getFrame(); // Ativa a janela a que o botão dá acesso;
			}
		});
		btnRegistarVendedor.setBounds(10, 151, 133, 23);
		panel.add(btnRegistarVendedor);
		
		JButton btnAtualizarVendedor = new JButton("Atualizar Vendedor");
		btnAtualizarVendedor.setBounds(10, 194, 133, 23);
		panel.add(btnAtualizarVendedor);
		
		JButton btnListarLivros = new JButton("Listar livros");
		btnListarLivros.setBounds(293, 109, 133, 23);
		panel.add(btnListarLivros);
		
		JButton btnPesquisarLivros = new JButton("Pesquisar livros");
		btnPesquisarLivros.setBounds(293, 151, 133, 23);
		panel.add(btnPesquisarLivros);
		
		JButton btnListarVendas = new JButton("Listar vendas");
		btnListarVendas.setBounds(293, 194, 133, 23);
		panel.add(btnListarVendas);
		
		JButton btnAdicionarLivro = new JButton("Adicionar livro");
		btnAdicionarLivro.setBounds(150, 109, 133, 23);
		panel.add(btnAdicionarLivro);
		
		JButton btnEditarLivro = new JButton("Editar livro");
		btnEditarLivro.setBounds(150, 151, 133, 23);
		panel.add(btnEditarLivro);
		
		JButton btnAtualizarStock = new JButton("Atualizar stock");
		btnAtualizarStock.setBounds(150, 194, 133, 23);
		panel.add(btnAtualizarStock);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose(); // desliga a janela ativa;
				VCI_Login window = new VCI_Login();
				window.getFrame().setVisible(true);

			}
		});
		btnVoltar.setBounds(10, 229, 133, 23);
		panel.add(btnVoltar);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
