import java.util.*;

import javax.swing.JOptionPane;

/**
 * Breve descrição do código
 *
 * @sid 2002
 * @aid 1.1
 */
public class JavaBank_Gestao {

	protected ArrayList<JavaBank_Utilizador> utilizadores = new ArrayList<>();
	protected ArrayList<JavaBank_Conta> contas = new ArrayList<>();

	public JavaBank_Gestao() {
		super();
		utilizadores.add(new JavaBank_Admin("Rui", "Costa", new GregorianCalendar(1978, 8, 29), "Cartão de cidadão",
				123456789, "Rua Maria Vitória Bourbon Bobone, Lote 15.7, 3030-502 Coimbra", 987654321,
				"rdrmdc@student.dei.uc.pt", "SuperBread1978"));
	}

	public void menu() {

	}

	// Método para iniciar o processo de login
	public void login(String login, String password) {
		JavaBank_Gestao gestao = new JavaBank_Gestao();
		Login log = new Login(gestao);
		for (JavaBank_Utilizador u : getUtilizadores()) {
			if (login.equals(u.getLogin()) && password.equals(u.getPassword()) && u instanceof JavaBank_Admin) {
				JOptionPane.showMessageDialog(log.getFrmLogin(), "Login com sucesso");
				log.getFrmLogin().dispose();
				HomepageAdmin.main(null);
			} else {
				JOptionPane.showMessageDialog(log.getFrmLogin(), "Login inválido");
			}
		}
	}

	// Método para iniciar o processo de logout
	public void logout() {

	}

	// Método para alteração de senha da conta
	public String alterar_senha() {

	}

	// Método para alteração do email da conta
	public String alterar_mail() {

	}

	// Método para registo de novo funcionário
	public void resgistar_funcionario(String nome, String sobrenome, String email, String password, String estado) {
		JavaBank_Gestao gestao = new JavaBank_Gestao();
		RegistarFuncionario registar_func = new RegistarFuncionario(gestao);
		int cont = 0;
		for (JavaBank_Utilizador u : getUtilizadores()) {
			if (u instanceof JavaBank_Funcionario) {
				cont++;
			}
		}
		if (nome.equals(null) || sobrenome.equals(null) || email.equals(null) || password.equals(null)) {
			JOptionPane.showMessageDialog(registar_func.getFrame(), "Registo inválido. Campos por preencher.");
		} else if (!email.contains("@") || !email.contains(".com") || !email.contains(".pt")) {
			JOptionPane.showMessageDialog(registar_func.getFrame(), "Registo inválido. Email inválido.");
		} else if (!registar_func.getPasswordField_1().getText().equals(password)) {
			JOptionPane.showMessageDialog(registar_func.getFrame(),
					"Registo inválido. Password não confirmada correctamente..");
		} else if (password.length() < 8) {
			JOptionPane.showMessageDialog(registar_func.getFrame(), "Registo inválido. Passowrd tem de conter no mínimo 8 caractceres.");
		} else {
			JOptionPane.showMessageDialog(registar_func.getFrame(), "Registo concluído com sucesso.");
			utilizadores.add(new JavaBank_Funcionario(nome, sobrenome, email, password, cont++, estado));
		}
	}

	// Método para listagem de clientes
	public ArrayList<JavaBank_Cliente> listar_clientes() {

	}

	// Método para listagem de funcionários
	public void listar_funcionarios() {
		for(JavaBank_Utilizador f : getUtilizadores()) {
			if(f instanceof JavaBank_Funcionario) {
				
			}
		}
	}

	// Método para listagem de contas
	public ArrayList<JavaBank_Conta> listar_contas() {

	}

	// Método para abertura de nova conta
	public JavaBank_Conta abrir_nova_conta() {

	}

	// Método para modifcar dados de conta
	public JavaBank_Conta modificar_conta() {

	}

	// Método para realizar depósito de determinado valor em determinada conta
	public double depositar_valor() {

	}

	// Método para lenvatamento de determinado valor de determinada conta public
	double levantar_valor() {

	}

	// Método para associar cartão de débito em determinada conta
	public void associar_cartao() {

	}

	public ArrayList<JavaBank_Utilizador> getUtilizadores() {
		return utilizadores;
	}

	public void setUtilizadores(ArrayList<JavaBank_Utilizador> utilizadores) {
		this.utilizadores = utilizadores;
	}

	public ArrayList<JavaBank_Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<JavaBank_Conta> contas) {
		this.contas = contas;
	}

}
