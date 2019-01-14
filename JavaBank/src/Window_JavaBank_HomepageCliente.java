import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

/**JPanel para a homepage do Cliente
 * 
 * @author Rui Costa
 *
 */
public class Window_JavaBank_HomepageCliente extends JFrame {

	private JPanel main_panel;
	private JavaBank_Gestao gestao;

	public Window_JavaBank_HomepageCliente(JavaBank_Gestao gestao) throws HeadlessException, IOException {
		this.gestao = gestao;
		initialize();
		setVisible(true);
	}

	public void initialize() throws IOException {
		gestao.abrirContas();
		gestao.abrirUtilizadores();
		// instanciar paineis
		JPanel hpcli_panel = new JPanel();

		// grafismo e propriedades
		setIconImage(Toolkit.getDefaultToolkit().getImage("../Projecto1/JB_Logotipo.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		main_panel = new JPanel(); 
		main_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(main_panel);
		main_panel.setLayout(new CardLayout(0, 0));

		main_panel.add(hpcli_panel, "mainf");
		hpcli_panel.setLayout(null);

		JLabel benvindo = new JLabel("BENVINDO " + JavaBank_Gestao.utilizador_logado.primeiro_nome.toUpperCase());
		benvindo.setOpaque(true);
		benvindo.setHorizontalAlignment(SwingConstants.CENTER);
		benvindo.setFont(new Font("Arial Black", Font.PLAIN, 17));
		benvindo.setBackground(Color.GRAY);
		benvindo.setBounds(0, 0, 424, 40);
		hpcli_panel.add(benvindo);

		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(325, 217, 89, 23);
		hpcli_panel.add(btnLogout);

		JButton btnAlterarDadosDe = new JButton("Alterar Dados de Login");
		btnAlterarDadosDe.setBounds(137, 77, 141, 23);
		hpcli_panel.add(btnAlterarDadosDe);

		JButton btnVerConta = new JButton("Ver Conta");
		btnVerConta.setBounds(137, 149, 141, 23);
		hpcli_panel.add(btnVerConta);

		btnAlterarDadosDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window_JavaBank_AlterarLogin alt = new Window_JavaBank_AlterarLogin(gestao);
				main_panel.add(alt, "alterarf");
				CardLayout card = (CardLayout) main_panel.getLayout();
				card.show(main_panel, "alterarf");
			}
		});

		btnVerConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					gestao.abrirContas();
					gestao.abrirUtilizadores();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				double saldo = 0;
				int n_conta_aux = 0;
				Object[] opcoes = { "Confirmar", "Cancelar" };
				JPanel panel = new JPanel();
				panel.add(new JLabel("Nº conta"));
				JComboBox<Object> combo = new JComboBox<>();
				combo.addItem("---Escolha a conta---");
				for (JavaBank_Conta c : ((JavaBank_Cliente) JavaBank_Gestao.utilizador_logado).getContas_associadas()) {
					combo.addItem(String.valueOf(c.getN_conta()));
				}
				panel.add(combo);
				int i = JOptionPane.showOptionDialog(getParent(), panel, "Lista de contas",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, null);
				if (i == JOptionPane.OK_OPTION) {
					n_conta_aux = Integer.parseInt(combo.getSelectedItem().toString());
					for (JavaBank_Conta c : gestao.getContas()) {

						if (c.getN_conta() == n_conta_aux) {
							if (c.getEstado().equals("Inactiva")) {
								JOptionPane.showMessageDialog(getParent(),
										"A conta encontra-se inactiva. Contacte o balcão mais próximo.");
								return;
							} else {
								saldo = c.getSaldo();
								Window_JavaBank_DadosConta listarmov = new Window_JavaBank_DadosConta(gestao, n_conta_aux, saldo);
								main_panel.add(listarmov, "listarmov");
								CardLayout card = (CardLayout) main_panel.getLayout();
								card.show(main_panel, "listarmov");
							}
						}
					}
				}
			}
		});

		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Window_JavaBank_Login login = new Window_JavaBank_Login(gestao);
				login.getFrmLogin().setVisible(true);
			}
		});
	}

}
