import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * Breve descrição do código
 *
 * @sid 2002
 * @aid 1.1
 */
public class Window_JavaBank_HomepageFunc extends JFrame {

	private JPanel main_panel;
	private JavaBank_Gestao gestao;

	public Window_JavaBank_HomepageFunc(JavaBank_Gestao gestao) throws HeadlessException {
		this.gestao = gestao;
		initialize();
		setVisible(true);
	}

	public void initialize() {
		// instanciar paineis
		JPanel hpfunc_panel = new JPanel();

		// grafismo e propriedades
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		main_panel = new JPanel();
		main_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(main_panel);
		main_panel.setLayout(new CardLayout(0, 0));

		main_panel.add(hpfunc_panel, "mainf");
		hpfunc_panel.setLayout(null);

		JLabel benvindo = new JLabel("BENVINDO " + JavaBank_Gestao.utilizador_logado.primeiro_nome.toUpperCase());
		benvindo.setOpaque(true);
		benvindo.setHorizontalAlignment(SwingConstants.CENTER);
		benvindo.setFont(new Font("Arial Black", Font.PLAIN, 17));
		benvindo.setBackground(Color.GRAY);
		benvindo.setBounds(0, 0, 424, 40);
		hpfunc_panel.add(benvindo);

		JButton btnAbrirNovaConta = new JButton("Abrir Nova Conta");
		btnAbrirNovaConta.setBounds(30, 99, 150, 23);
		hpfunc_panel.add(btnAbrirNovaConta);

		JButton btnRegistarNovoCliente = new JButton("Registar Novo Cliente");
		btnRegistarNovoCliente.setBounds(30, 133, 150, 23);
		hpfunc_panel.add(btnRegistarNovoCliente);

		JButton btnAlterarLogin = new JButton("Alterar Login");
		btnAlterarLogin.setBounds(244, 99, 150, 23);
		hpfunc_panel.add(btnAlterarLogin);

		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(244, 167, 150, 23);
		hpfunc_panel.add(btnLogout);

		JButton btnListarClientes = new JButton("Listar Clientes");
		btnListarClientes.setBounds(244, 133, 150, 23);
		hpfunc_panel.add(btnListarClientes);
		
		JButton btnListarContas = new JButton("Listar Contas");
		btnListarContas.setBounds(30, 167, 150, 23);
		hpfunc_panel.add(btnListarContas);

		btnRegistarNovoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window_JavaBank_RegistarCl reg = new Window_JavaBank_RegistarCl(gestao);
				main_panel.add(reg, "registoc");
				CardLayout card = (CardLayout) main_panel.getLayout();
				card.show(main_panel, "registoc");
			}
		});

		btnAlterarLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window_JavaBank_AlterarLogin alt = new Window_JavaBank_AlterarLogin(gestao);
				main_panel.add(alt, "alterarf");
				CardLayout card = (CardLayout) main_panel.getLayout();
				card.show(main_panel, "alterarf");
			}
		});

		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Window_JavaBank_Login login = new Window_JavaBank_Login(gestao);
				login.getFrmLogin().setVisible(true);
			}
		});

		btnListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window_JavaBank_ListarCl listac = new Window_JavaBank_ListarCl(gestao);
				main_panel.add(listac, "listarc");
				CardLayout card = (CardLayout) main_panel.getLayout();
				card.show(main_panel, "listarc");
			}
		});

		btnAbrirNovaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window_JavaBank_AbrirConta abrir = new Window_JavaBank_AbrirConta(gestao);
				main_panel.add(abrir, "abrirconta");
				CardLayout card = (CardLayout) main_panel.getLayout();
				card.show(main_panel, "abrirconta");
			}
		});
		
		btnListarContas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window_JavaBank_ListarContas listaconta = new Window_JavaBank_ListarContas(gestao);
				main_panel.add(listaconta, "listarconta");
				CardLayout card = (CardLayout) main_panel.getLayout();
				card.show(main_panel, "listarconta");
			}
		});
		
	}
}
