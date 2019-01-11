import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * Breve descrição do código
 *
 * @sid 2002
 * @aid 1.1
 */
public class Window_JavaBank_ListarF extends JPanel {

	private JavaBank_Gestao gestao;

	public Window_JavaBank_ListarF(JavaBank_Gestao gestao) {
		this.gestao = gestao;
		initialize();
	}

	/**
	 * Create the panel.
	 */
	public void initialize() {
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 414, 171);
		add(scrollPane);

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) getParent().getLayout();
				removeAll();
				initialize();
				card.show(getParent(), "mainf");
			}
		});

		String col[] = { "ID", "Nome", "Sobrenome", "Email", "Estado" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable table = new JTable(tableModel);
		ArrayList<JavaBank_Utilizador> funcionarios = gestao.listar_funcionarios();

		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
	}

}
