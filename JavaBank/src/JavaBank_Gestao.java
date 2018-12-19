import java.util.*;

import javax.swing.JOptionPane;

/**
 * Breve descri��o do c�digo
 *
 * @sid 2002
 * @aid 1.1
 */
public class JavaBank_Gestao {

	protected ArrayList<JavaBank_Utilizador> utilizadores = new ArrayList<>();
	protected ArrayList<JavaBank_Conta> contas = new ArrayList<>();

	public JavaBank_Gestao() {
		super();
		utilizadores.add(new JavaBank_Admin("Rui", "Costa", new GregorianCalendar(1978, 8, 29), "Cart�o de cidad�o",
				123456789, "Rua Maria Vit�ria Bourbon Bobone, Lote 15.7, 3030-502 Coimbra", 987654321,
				"rdrmdc@student.dei.uc.pt", "SuperBread1978"));
	}

	public void menu() {

	}

	// M�todo para iniciar o processo de login
	public void login(String login, String password) {
		JavaBank_Gestao gestao = new JavaBank_Gestao();
		Login log = new Login(gestao);
		for (JavaBank_Utilizador u : getUtilizadores()) {
			if (login.equals(u.getLogin()) && password.equals(u.getPassword()) && u instanceof JavaBank_Admin) {
				JOptionPane.showMessageDialog(log.getFrmLogin(), "Login com sucesso");
				log.getFrmLogin().dispose();
				HomepageAdmin.main(null);
			} else {
				JOptionPane.showMessageDialog(log.getFrmLogin(), "Login inv�lido");
			}
		}
	}

	// M�todo para iniciar o processo de logout
	public void logout() {

	}

	// M�todo para altera��o de senha da conta
	public String alterar_senha() {

	}

	// M�todo para altera��o do email da conta
	public String alterar_mail() {

	}

	// M�todo para registo de novo funcion�rio
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
			JOptionPane.showMessageDialog(registar_func.getFrame(), "Registo inv�lido. Campos por preencher.");
		} else if (!email.contains("@") || !email.contains(".com") || !email.contains(".pt")) {
			JOptionPane.showMessageDialog(registar_func.getFrame(), "Registo inv�lido. Email inv�lido.");
		} else if (!registar_func.getPasswordField_1().getText().equals(password)) {
			JOptionPane.showMessageDialog(registar_func.getFrame(),
					"Registo inv�lido. Password n�o confirmada correctamente..");
		} else if (password.length() < 8) {
			JOptionPane.showMessageDialog(registar_func.getFrame(), "Registo inv�lido. Passowrd tem de conter no m�nimo 8 caractceres.");
		} else {
			JOptionPane.showMessageDialog(registar_func.getFrame(), "Registo conclu�do com sucesso.");
			utilizadores.add(new JavaBank_Funcionario(nome, sobrenome, email, password, cont++, estado));
		}
	}

	// M�todo para listagem de clientes
	public ArrayList<JavaBank_Cliente> listar_clientes() {

	}

	// M�todo para listagem de funcion�rios
	public void listar_funcionarios() {
		for(JavaBank_Utilizador f : getUtilizadores()) {
			if(f instanceof JavaBank_Funcionario) {
				
			}
		}
	}

	// M�todo para listagem de contas
	public ArrayList<JavaBank_Conta> listar_contas() {

	}

	// M�todo para abertura de nova conta
	public JavaBank_Conta abrir_nova_conta() {

	}

	// M�todo para modifcar dados de conta
	public JavaBank_Conta modificar_conta() {

	}

	// M�todo para realizar dep�sito de determinado valor em determinada conta
	public double depositar_valor() {

	}

	// M�todo para lenvatamento de determinado valor de determinada conta public
	double levantar_valor() {

	}

	// M�todo para associar cart�o de d�bito em determinada conta
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
