import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**JPanel para lista e dados dos funcionários
 * 
 * @author Rui Costa
 *
 */
public class Window_JavaBank_ListarF extends JPanel {

	private JavaBank_Gestao gestao;
	private JTextField textFieldNome;
	private JTextField textFieldSobrenome;
	private JTextField textFieldEmail;
	private JTextField textFieldEstado;

	public Window_JavaBank_ListarF(JavaBank_Gestao gestao) throws IOException {
		this.gestao = gestao;
		initialize();
	}

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public void initialize() throws IOException {
		setLayout(null);
		JLabel lblListaDeFuncionrios = new JLabel("LISTA DE FUNCION\u00C1RIOS");
		lblListaDeFuncionrios.setOpaque(true);
		lblListaDeFuncionrios.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeFuncionrios.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblListaDeFuncionrios.setBackground(Color.GRAY);
		lblListaDeFuncionrios.setBounds(0, 0, 424, 40);
		add(lblListaDeFuncionrios);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(335, 227, 89, 23);
		add(btnVoltar);
		
		JLabel lblNId = new JLabel("N\u00BA ID");
		lblNId.setBounds(164, 53, 26, 14);
		add(lblNId);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(194, 50, 89, 20);
		add(comboBox);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNome.setBounds(33, 110, 79, 14);
		add(lblNome);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSobrenome.setBounds(33, 135, 79, 14);
		add(lblSobrenome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setBounds(236, 110, 33, 14);
		add(lblEmail);
		
		textFieldNome = new JTextField();
		textFieldNome.setEditable(false);
		textFieldNome.setBounds(122, 107, 86, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldSobrenome = new JTextField();
		textFieldSobrenome.setEditable(false);
		textFieldSobrenome.setBounds(122, 132, 86, 20);
		add(textFieldSobrenome);
		textFieldSobrenome.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		textFieldEmail.setBounds(279, 107, 86, 20);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(236, 138, 33, 14);
		add(lblEstado);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setEditable(false);
		textFieldEstado.setBounds(279, 135, 86, 20);
		add(textFieldEstado);
		textFieldEstado.setColumns(10);

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) getParent().getLayout();
				removeAll();
				try {
					initialize();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				card.show(getParent(), "mainf");
			}
		});

		comboBox.addItem("---Escolha---");
		ArrayList<JavaBank_Utilizador> funcionarios = gestao.listar_funcionarios();
		for (JavaBank_Utilizador u : funcionarios) {
			int id = ((JavaBank_Funcionario) u).getId();
			comboBox.addItem(String.valueOf(id));
		}
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id_sel = (String) comboBox.getSelectedItem();
				for (JavaBank_Utilizador u : funcionarios) {
					if (((JavaBank_Funcionario) u).getId() == Integer.parseInt(id_sel)) {
						textFieldNome.setText(u.getPrimeiro_nome());
						textFieldSobrenome.setText(u.getSobrenome());
						textFieldEmail.setText(u.getLogin());
						textFieldEstado.setText(((JavaBank_Funcionario)u).getEstado());
					}
				}
			}
		});
	}
}
