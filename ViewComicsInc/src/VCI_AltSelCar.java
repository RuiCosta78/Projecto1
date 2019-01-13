import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**   
 * Breve descrição do código
 *  
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_AltSelCar {

	private JFrame frame;
	private VCI_cl_Gestao g;
	private int linha;
		/**
	 * Create the application.
	 */
	public VCI_AltSelCar(VCI_cl_Gestao g, int linha) {
		this.g = g;
		this.linha = linha;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\rmmi7\\git\\Projecto1\\VC_Logotipo.jpg"));
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
		
		JLabel label_1 = new JLabel("Alterar itens do carrinho");
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_1.setBounds(10, 30, 416, 20);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Selecionou o livro");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		label_2.setBounds(10, 61, 242, 23);
		panel.add(label_2);
		
		String titulo = VCI_cl_Gestao.cliente.getListaCompras().get(linha).getTitulo();
		JLabel label_3 = new JLabel(titulo);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		label_3.setBounds(10, 85, 416, 23);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Para o qual reservou ");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		label_4.setBounds(10, 114, 138, 23);
		panel.add(label_4);
		
		String num = String.valueOf(VCI_cl_Gestao.cliente.getQuantLivros().get(linha));
		JLabel label_5 = new JLabel(num);
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		label_5.setBounds(151, 114, 41, 23);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("exemplares.");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		label_6.setBounds(196, 114, 138, 23);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Pretende:");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		label_7.setBounds(10, 144, 117, 23);
		panel.add(label_7);
		
		JRadioButton radioButton = new JRadioButton("Eliminar o livro da lista de compras");
		radioButton.setBounds(116, 146, 230, 23);
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Modificar a quantidade");
		radioButton_1.setBounds(116, 178, 230, 23);
		panel.add(radioButton_1);
		
		// VOLTAR
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				VCI_Carrinho window = new VCI_Carrinho(g);
				window.getFrame().setVisible(true);
			}
		});
		button.setBounds(10, 222, 83, 30);
		panel.add(button);
		
		//CONFIRMAR
		JButton button_1 = new JButton("Confirmar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (radioButton.isSelected()) {
					VCI_cl_Gestao.cliente.getListaCompras().remove(linha);
					VCI_cl_Gestao.cliente.getQuantLivros().remove(linha);
				} else if (radioButton_1.isSelected()) {
					String nLivros = JOptionPane.showInputDialog(frame, "Quantos exemplares pretende adquirir?");
					int num = Integer.parseInt(nLivros);
					if (num != VCI_cl_Gestao.cliente.getQuantLivros().get(linha)) {
						VCI_cl_Gestao.cliente.getQuantLivros().set(linha, num);
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Não foram efetuadas alterações.");
				}
				frame.dispose();
				VCI_Carrinho window = new VCI_Carrinho(g);
				window.getFrame().setVisible(true);
			}
		});
		button_1.setBounds(288, 222, 138, 30);
		panel.add(button_1);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public VCI_cl_Gestao getG() {
		return g;
	}

	public void setG(VCI_cl_Gestao g) {
		this.g = g;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}
	
}
