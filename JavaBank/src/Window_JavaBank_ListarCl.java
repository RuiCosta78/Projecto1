import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

/**
 * Breve descrição do código
 *
 * @sid 2002
 * @aid 1.1
 */
public class Window_JavaBank_ListarCl extends JPanel {

	private JavaBank_Gestao gestao;
	private JTextField textFieldNome;
	private JTextField textFieldSobrenome;
	private JTextField textFieldNif;
	private JTextField textFieldData;
	private JTextField textFieldNid;
	private JTextField textFieldEndereco;
	private JTextField textFieldContacto;
	private JTextField textFieldEmail;

	public Window_JavaBank_ListarCl(JavaBank_Gestao gestao) {
		this.gestao = gestao;
		initialize();
	}

	/**
	 * Create the panel.
	 */
	public void initialize() {
		setLayout(null);
		JLabel lblListaDeClientes = new JLabel("LISTA DE CLIENTES");
		lblListaDeClientes.setOpaque(true);
		lblListaDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeClientes.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblListaDeClientes.setBackground(Color.GRAY);
		lblListaDeClientes.setBounds(0, 0, 424, 40);
		add(lblListaDeClientes);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(335, 266, 89, 23);
		add(btnVoltar);

		JLabel lblNomeDoCliente = new JLabel("Nome do cliente");
		lblNomeDoCliente.setBounds(96, 53, 76, 14);
		add(lblNomeDoCliente);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(182, 50, 126, 20);
		add(comboBox);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(62, 96, 28, 14);
		add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setEditable(false);
		textFieldNome.setBounds(95, 93, 86, 20);
		add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setBounds(191, 96, 54, 14);
		add(lblSobrenome);

		textFieldSobrenome = new JTextField();
		textFieldSobrenome.setEditable(false);
		textFieldSobrenome.setBounds(249, 93, 86, 20);
		add(textFieldSobrenome);
		textFieldSobrenome.setColumns(10);

		JLabel lblNif = new JLabel("NIF");
		lblNif.setBounds(62, 139, 28, 14);
		add(lblNif);

		textFieldNif = new JTextField();
		textFieldNif.setEditable(false);
		textFieldNif.setBounds(95, 136, 86, 20);
		add(textFieldNif);
		textFieldNif.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setBounds(191, 139, 95, 14);
		add(lblDataDeNascimento);

		textFieldData = new JTextField();
		textFieldData.setEditable(false);
		textFieldData.setBounds(293, 136, 86, 20);
		add(textFieldData);
		textFieldData.setColumns(10);

		JLabel lblNIdentificao = new JLabel("N\u00BA Identifica\u00E7\u00E3o");
		lblNIdentificao.setBounds(62, 183, 86, 14);
		add(lblNIdentificao);

		textFieldNid = new JTextField();
		textFieldNid.setEditable(false);
		textFieldNid.setBounds(144, 180, 86, 20);
		add(textFieldNid);
		textFieldNid.setColumns(10);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(240, 183, 46, 14);
		add(lblEndereo);

		textFieldEndereco = new JTextField();
		textFieldEndereco.setEditable(false);
		textFieldEndereco.setBounds(293, 180, 86, 20);
		add(textFieldEndereco);
		textFieldEndereco.setColumns(10);

		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(62, 226, 46, 14);
		add(lblContacto);

		textFieldContacto = new JTextField();
		textFieldContacto.setEditable(false);
		textFieldContacto.setBounds(114, 223, 86, 20);
		add(textFieldContacto);
		textFieldContacto.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(210, 226, 28, 14);
		add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		textFieldEmail.setBounds(240, 223, 86, 20);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) getParent().getLayout();
				removeAll();
				initialize();
				card.show(getParent(), "mainf");
			}
		});

		ArrayList<JavaBank_Utilizador> clientes = gestao.listar_clientes();
		HashSet<Object> existe = new HashSet<>();
		clientes.removeIf(c -> !existe.add(c.getN_id()));

		comboBox.addItem("---Escolha o cliente---");
		for (JavaBank_Utilizador c : clientes) {
			String pNome = c.getPrimeiro_nome();
			String sNome = c.getSobrenome();
			String nome_completo = pNome + " " + sNome;
			comboBox.addItem(nome_completo);
		}

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cliente = (String) comboBox.getSelectedItem();
				String[] partes = cliente.split(" ");
				for (JavaBank_Utilizador u : gestao.getUtilizadores()) {
					if (u instanceof JavaBank_Cliente && u.getPrimeiro_nome().equals(partes[0])
							&& u.getSobrenome().equals(partes[1])) {
						textFieldNome.setText(partes[0]);
						textFieldSobrenome.setText(partes[1]);
						textFieldContacto.setText(u.getN_contacto());
						textFieldData.setText(u.getData_nascimento());
						textFieldEmail.setText(u.getLogin());
						textFieldEndereco.setText(u.getEndereco());
						textFieldNid.setText(String.valueOf(u.getN_id()));
						textFieldNif.setText(((JavaBank_Cliente) u).getNif());
					}
				}
			}
		});
	}
}
