import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**JPanel da homepage do Admin
 * 
 * @author Rui Costa
 *
 */
public class Window_JavaBank_HomepageAdmin extends JFrame {

	private JPanel main_panel;
	private JavaBank_Gestao gestao;

	public Window_JavaBank_HomepageAdmin(JavaBank_Gestao gestao) throws HeadlessException {
		this.gestao = gestao;
		initialize();
		setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		// instanciar paineis
		JPanel hpadmin_panel = new JPanel();

		// grafismo e propriedades
		setIconImage(Toolkit.getDefaultToolkit().getImage("../Projecto1/JB_Logotipo.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		main_panel = new JPanel();
		main_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(main_panel);
		main_panel.setLayout(new CardLayout(0, 0));

		main_panel.add(hpadmin_panel, "mainf");
		hpadmin_panel.setLayout(null);

		JLabel benvindo = new JLabel("BENVINDO " + JavaBank_Gestao.utilizador_logado.primeiro_nome.toUpperCase());
		benvindo.setOpaque(true);
		benvindo.setHorizontalAlignment(SwingConstants.CENTER);
		benvindo.setFont(new Font("Arial Black", Font.PLAIN, 17));
		benvindo.setBackground(Color.GRAY);
		benvindo.setBounds(0, 0, 424, 40);
		hpadmin_panel.add(benvindo);

		JLabel opcao = new JLabel("Escolha a op\u00E7\u00E3o");
		opcao.setFont(new Font("Arial", Font.PLAIN, 12)); 
		opcao.setBounds(10, 79, 92, 14);
		hpadmin_panel.add(opcao);

		JButton alterar_login = new JButton("Alterar Login");
		alterar_login.setBounds(20, 104, 123, 40);
		hpadmin_panel.add(alterar_login);

		JButton btnRegistarFuncionrio = new JButton("Registar Funcion\u00E1rio");
		btnRegistarFuncionrio.setToolTipText("Registar Funcion\u00E1rio");
		btnRegistarFuncionrio.setBounds(20, 170, 123, 40);
		hpadmin_panel.add(btnRegistarFuncionrio);

		JButton btnListarClientes = new JButton("Listar Clientes");
		btnListarClientes.setToolTipText("");
		btnListarClientes.setBounds(153, 170, 123, 40);
		hpadmin_panel.add(btnListarClientes);

		JButton btnListarContas = new JButton("Listar Contas");
		btnListarContas.setToolTipText("");
		btnListarContas.setBounds(153, 104, 123, 40);
		hpadmin_panel.add(btnListarContas);

		JButton btnListarFuncionrios = new JButton("Listar Funcion\u00E1rios");
		btnListarFuncionrios.setBounds(286, 104, 123, 40);
		hpadmin_panel.add(btnListarFuncionrios);

		JButton logout = new JButton("Logout");
		logout.setBounds(335, 227, 89, 23);
		hpadmin_panel.add(logout);

		// listeners e listas
		btnRegistarFuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window_JavaBank_RegistarFunc reg = new Window_JavaBank_RegistarFunc(gestao);
				main_panel.add(reg, "registof");
				CardLayout card = (CardLayout) main_panel.getLayout();
				card.show(main_panel, "registof");
			}
		});

		btnListarFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window_JavaBank_ListarF list = null;
				try {
					list = new Window_JavaBank_ListarF(gestao);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				main_panel.add(list, "listaf");
				CardLayout card = (CardLayout) main_panel.getLayout();
				card.show(main_panel, "listaf");
			}
		});

		alterar_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window_JavaBank_AlterarLogin alt = new Window_JavaBank_AlterarLogin(gestao);
				main_panel.add(alt, "alterarf");
				CardLayout card = (CardLayout) main_panel.getLayout();
				card.show(main_panel, "alterarf");
			}
		});

		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Window_JavaBank_Login login = new Window_JavaBank_Login(gestao);
				login.getFrmLogin().setVisible(true);
			}
		});

		btnListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window_JavaBank_ListarCl listac = null;
				try {
					listac = new Window_JavaBank_ListarCl(gestao);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				main_panel.add(listac, "listarc");
				CardLayout card = (CardLayout) main_panel.getLayout();
				card.show(main_panel, "listarc");
			}
		});

		btnListarContas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] opcoes = { "Confirmar", "Cancelar" };
				JPanel panel = new JPanel();
				panel.add(new JLabel("Nome "));
				JComboBox<String> combo = new JComboBox<>();
				combo.addItem("---Escolha a conta---");
				for (JavaBank_Conta c : gestao.getContas()) {
					combo.addItem(String.valueOf(c.getN_conta()));
				}
				panel.add(combo);
				int i = JOptionPane.showOptionDialog(getParent(), panel, "Lista de contas",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, null);
				int n_conta = 0;
				double saldo = 0.0;
				if (i == JOptionPane.OK_OPTION) {
					n_conta = Integer.parseInt(combo.getSelectedItem().toString());
					for (JavaBank_Conta c : gestao.getContas()) {
						if (c.getN_conta() == n_conta) {
							saldo = c.getSaldo();
						}
					}
					Window_JavaBank_DadosConta dados = new Window_JavaBank_DadosConta(gestao, n_conta, saldo);
					main_panel.add(dados, "dados");
					CardLayout card = (CardLayout) main_panel.getLayout();
					card.show(main_panel, "dados");
				}
			}
		});
	}
}
