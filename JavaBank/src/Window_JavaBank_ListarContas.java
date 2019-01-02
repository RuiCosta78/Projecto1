import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 * Breve descrição do código
 *
 * @sid 2002
 * @aid 1.1
 */
public class Window_JavaBank_ListarContas extends JPanel {

	private JavaBank_Gestao gestao = new JavaBank_Gestao();
	private int n_conta_aux = 0;

	public Window_JavaBank_ListarContas(JavaBank_Gestao gestao) {
		this.gestao = gestao;
		initialize();
	}

	/**
	 * Create the panel.
	 */
	public void initialize() {
		setLayout(null);
		JLabel lblListaDeContas = new JLabel("LISTA DE CONTAS");
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

		String col[] = { "Nº de Conta", "Titular", "Data de Criação", "Tipo de Conta", "Saldo", "Juros(%)","Estado" };
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		JTable table = new JTable(tableModel);

		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);

		String nome_completo = "", tipo = "", nome = "";
		double juros = 0.0;
		for (JavaBank_Conta c : gestao.getContas()) {
			int n_conta = c.getN_conta();
			for (JavaBank_Utilizador u : gestao.getUtilizadores()) {
				if (u instanceof JavaBank_Cliente && ((JavaBank_Cliente) u).getN_conta() == n_conta) {
					nome = u.getPrimeiro_nome();
					String sobrenome = u.getSobrenome();
					nome_completo = nome.concat(" ").concat(sobrenome); 
				}
			}
			String data = c.getData_criacao();
			if (c instanceof JavaBank_Conta_Ordem) {
				tipo = "Conta à Ordem";
				juros = 0.0;
			} else if (c instanceof JavaBank_Conta_Poupanca) {
				tipo = "Conta Poupança";
				juros = ((JavaBank_Conta_Poupanca) c).getJuros();
			}
			double saldo = c.getSaldo();
			String estado = c.getEstado();
			Object dados[] = { n_conta, nome_completo, data, tipo, saldo, juros, estado };
			tableModel.addRow(dados);
		}
		scrollPane.setViewportView(table);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	n_conta_aux = (int) table.getValueAt(table.getSelectedRow(), 0);
				Window_JavaBank_ListarMov listarmov = new Window_JavaBank_ListarMov(gestao);
	        }
	    });

	}

	public int getN_conta_aux() {
		return n_conta_aux;
	}

}
