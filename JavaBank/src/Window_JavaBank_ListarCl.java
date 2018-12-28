import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class Window_JavaBank_ListarCl extends JPanel {

	private JavaBank_Gestao gestao = new JavaBank_Gestao();

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
		btnVoltar.setBounds(335, 227, 89, 23);
		add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 414, 135);
		add(scrollPane);

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) getParent().getLayout();
				removeAll();
				initialize();
				card.show(getParent(), "mainf");
			}
		});

		String col[] = { "NIF", "Nome", "Sobrenome", "Data de Nascimento", "Nº Identificação", "Endereço", "Contacto", "Email" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		JTable table = new JTable(tableModel);
		ArrayList<JavaBank_Utilizador> clientes = gestao.listar_clientes();

		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		
		for (JavaBank_Utilizador c : clientes) {
			String nif = ((JavaBank_Cliente) c).getNif();
			String pNome = c.getPrimeiro_nome();
			String sNome = c.getSobrenome();
			String data = c.getData_nascimento();
			int nId = c.getN_id();
			String endereco = c.getEndereco();
			String contacto = c.getN_contacto();
			String email = c.getLogin();
			Object dados[] = { nif, pNome, sNome, data, nId, endereco, contacto, email};
			tableModel.addRow(dados);
		}
		scrollPane.setViewportView(table);

	}

}
