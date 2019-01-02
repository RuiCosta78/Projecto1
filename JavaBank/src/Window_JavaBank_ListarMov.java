import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class Window_JavaBank_ListarMov extends JFrame {

	private JPanel contentPane;
	private JavaBank_Gestao gestao = new JavaBank_Gestao();

	public Window_JavaBank_ListarMov(JavaBank_Gestao gestao) {
		this.gestao = gestao;
		initialize();
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		setLayout(null);
		JLabel lblListaDeContas = new JLabel("LISTA DE MOVIMENTOS");
		lblListaDeContas.setOpaque(true);
		lblListaDeContas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeContas.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblListaDeContas.setBackground(Color.GRAY);
		lblListaDeContas.setBounds(0, 0, 424, 40);
		add(lblListaDeContas);

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
		
		String col[] = { "Data", "Tipo", "Nº Conta", "Montante", "Saldo"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		JTable table = new JTable(tableModel);

		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		
		Window_JavaBank_ListarContas listcont = new Window_JavaBank_ListarContas(gestao);
		for(JavaBank_Conta c : gestao.getContas()) {
			if(c.getN_conta() == listcont.getN_conta_aux()) {
				
			}
		}
		
		scrollPane.setViewportView(table);
	}

}
