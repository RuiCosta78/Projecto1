import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Breve descri��o do c�digo
 *
 * @sid 2002
 * @aid 1.1
 */
public class JavaBank_Gestao implements Serializable {

	protected ArrayList<JavaBank_Utilizador> utilizadores = new ArrayList<>();
	protected ArrayList<JavaBank_Conta> contas = new ArrayList<>();
	public static JavaBank_Utilizador utilizador_logado;

	public JavaBank_Gestao() {
		super();
		JavaBank_Conta conta1 = new JavaBank_Conta_Ordem(1, "1/jan/2001", 250.00, "Activa", null);
		JavaBank_Conta conta2 = new JavaBank_Conta_Ordem(2, "1/jan/2001", 150.00, "Activa",
				new JavaBank_Cartao_Debito("Nuno Pratas", "0001", "1/2024", "001"));
		JavaBank_Conta conta3 = new JavaBank_Conta_Poupanca(3, "1/1/2001", 5000.00, "Activa");
		contas.add(conta1);
		contas.add(conta2);
		contas.add(conta3);
		utilizadores.add(new JavaBank_Admin("Rui", "Costa", "29/08/1978", "Cart�o de cidad�o", 123456789,
				"Rua Maria Vit�ria Bourbon Bobone, Lote 15.7, 3030-502 Coimbra", "987654321", "rdrmdc",
				"SuperBread1978"));
		utilizadores.add(new JavaBank_Admin("Jos�", "Costa", "29/08/1978", "Cart�o de cidad�o", 123456789,
				"Rua Maria Vit�ria Bourbon Bobone, Lote 15.7, 3030-502 Coimbra", "987654321", "qwerty", "asdfghjk"));
		utilizadores.add(new JavaBank_Funcionario("Rui", "In�cio", "rmmi@gmail.com", "12345678", 1, "Inactivo"));
		utilizadores.add(new JavaBank_Cliente("Bruno", "Escada", "1/jan/1980", "Passaporte", 456, "asdf", "234",
				"asdfg@gmail.com", "12345678", "345", conta1));
		utilizadores.add(new JavaBank_Cliente("Nuno", "Pratas", "1/mar/1980", "Cart�o de Cidad�o", 789, "asdf", "234",
				"asdfg@gmail.com", "12345678", "345", conta2));
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window_JavaBank_Login window = new Window_JavaBank_Login();
					window.getFrmLogin().setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// M�todo para iniciar o processo de login
	public String login(String login, String password) {

		String janela_confirmacao = "";
		boolean confirm_admin = false, confirm_func = false, confirm_cliente = false;
		for (JavaBank_Utilizador u : utilizadores) {
			if (login.equals(u.getLogin()) && password.equals(u.getPassword()) && u instanceof JavaBank_Admin) {
				confirm_admin = true;
				utilizador_logado = u;
			} else if (login.equals(u.getLogin()) && password.equals(u.getPassword())
					&& u instanceof JavaBank_Funcionario) {
				confirm_func = true;
				utilizador_logado = u;
			} else if (login.equals(u.getLogin()) && password.equals(u.getPassword())
					&& u instanceof JavaBank_Cliente) {
				confirm_cliente = true;
				utilizador_logado = u;
			}
		}
		if (confirm_admin == true) {
			janela_confirmacao = "Login de Admin com sucesso";
		} else if (confirm_func == true) {
			janela_confirmacao = "Login de Funcion�rio com sucesso";
		} else if (confirm_cliente == true) {
			janela_confirmacao = "Login de Cliente com sucesso";
		} else {
			janela_confirmacao = "Login inv�lido";
		}
		return janela_confirmacao;
	}

	// M�todo para altera��o de dados de login
	public String alterar_login(String username, String userConfirm, String password, String passwordConfirm) {
		String janela_confirmacao = "";
		if (!username.equals(userConfirm) || !password.equals(passwordConfirm)) {
			janela_confirmacao = "Altera��o n�o conclu�da. Dados n�o confirmados";
		} else if (username.equals(null) || userConfirm.equals(null) || password.equals(null)
				|| passwordConfirm.equals(null)) {
			janela_confirmacao = "Altera��o n�o conclu�da. Campos em falta.";
		} else {
			janela_confirmacao = "Altera��o conclu�da com sucesso";
			utilizador_logado.setLogin(username);
			utilizador_logado.setPassword(password);
		}
		return janela_confirmacao;
	}

	// M�todo para registo de novo funcion�rio
	public String registar_funcionario(String nome, String sobrenome, String email, String password,
			String passwordConfirm, String estado) {
		String janela_confirm = "";
		int cont = 0;
		for (JavaBank_Utilizador u : getUtilizadores()) {
			if (u instanceof JavaBank_Funcionario) {
				cont++;
			}
		}

		for (JavaBank_Utilizador u : getUtilizadores()) {
			if (u.getLogin().equals(email)) {
				janela_confirm = "Registo inv�lido. Email j� registado.";
			}
		}

		if (nome.equals(null) || sobrenome.equals(null) || email.equals(null) || password.equals(null)) {
			janela_confirm = "Registo inv�lido. Campos por preencher.";
		} else if (!isValidEmailAddress(email)) {
			janela_confirm = "Registo inv�lido. Email inv�lido.";
		} else if (!password.equals(passwordConfirm)) {
			janela_confirm = "Registo inv�lido. Password n�o confirmada correctamente.";
		} else if (password.length() < 8) {
			janela_confirm = "Registo inv�lido. Password tem de conter no m�nimo 8 caractceres.";
		} else {
			janela_confirm = "Registo conclu�do com sucesso.";
			utilizadores.add(new JavaBank_Funcionario(nome, sobrenome, email, password, cont + 1, estado));
		}
		return janela_confirm;
	}

	public String registar_cliente(String nome, String sobrenome, String data, String tipoId, int numId,
			String endereco, String contacto, String nif, String email, String password, String passwordConfirm) {
		String janela_confirm = "";
		for (JavaBank_Utilizador u : getUtilizadores()) {
			if (u.getLogin().equals(email)) {
				janela_confirm = "Registo inv�lido. Email j� registado.";
			}
		}
		if (nome.equals(null) || sobrenome.equals(null) || data.equals(null) || numId == 0 || endereco.equals(null)
				|| contacto.equals(null) || nif.equals(null) || email.equals(null) || password.equals(null)) {
			janela_confirm = "Registo inv�lido. Campos por preencher.";
		} else if (!isValidEmailAddress(email)) {
			janela_confirm = "Registo inv�lido. Email inv�lido.";
		} else if (!password.equals(passwordConfirm)) {
			janela_confirm = "Registo inv�lido. Password n�o confirmada correctamente.";
		} else if (password.length() < 8) {
			janela_confirm = "Registo inv�lido. Password tem de conter no m�nimo 8 caractceres.";
		} else {
			janela_confirm = "Registo conclu�do com sucesso.";
			utilizadores.add(new JavaBank_Cliente(nome, sobrenome, data, tipoId, numId, endereco, contacto, email,
					password, nif));
		}
		return janela_confirm;
	}

	// M�todo de valida��o de email; importado jar file para valida��o
	public static boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	// M�todo para listagem de clientes
	public ArrayList<JavaBank_Utilizador> listar_clientes() {
		ArrayList<JavaBank_Utilizador> clientes = new ArrayList<>();
		for (JavaBank_Utilizador c : getUtilizadores()) {
			if (c instanceof JavaBank_Cliente) {
				clientes.add(c);
			}
		}
		return clientes;
	}

	// M�todo para listagem de funcion�rios
	public ArrayList<JavaBank_Utilizador> listar_funcionarios() {
		ArrayList<JavaBank_Utilizador> funcionarios = new ArrayList<>();
		for (JavaBank_Utilizador f : getUtilizadores()) {
			if (f instanceof JavaBank_Funcionario) {
				funcionarios.add(f);
			}
		}
		return funcionarios;
	}

	// M�todo para abertura de nova conta
	public String abrir_nova_conta(int n_conta, String nome, String sobrenome, String data, String estado,
			double deposito, String tipo) {
		String janela_confirm = "";
		int id_cliente = 0;
		int cont = 0, cont_poup = 0;
		for (JavaBank_Utilizador c : getUtilizadores()) {
			if (c.getPrimeiro_nome().equals(nome) && c.getSobrenome().equals(sobrenome)
					&& c instanceof JavaBank_Cliente) {
				id_cliente = c.getN_id();
				cont++;
			}
			for (JavaBank_Conta conta : getContas()) {
				if (c instanceof JavaBank_Cliente
						&& ((JavaBank_Cliente) c).getConta().getN_conta() == conta.getN_conta()
						&& conta instanceof JavaBank_Conta_Poupanca) {
					cont_poup++;
				}
			}
		}
		if (cont == 0) {
			janela_confirm = "Registo inv�lido. Cliente n�o registado";
		}
		if (nome.equals(null) || sobrenome.equals(null) || data.equals(null) || estado.equals("---Escolha a op��o---")
				|| deposito < 0 || tipo.equals("---Escolha a op��o---")) {
			janela_confirm = "Registo inv�lido. Campos por preencher.";
		} else {
			janela_confirm = "Registo conclu�do com sucesso.";
			if (tipo.equals("Conta � Ordem")) {
				JavaBank_Movimento mov = new JavaBank_Movimento(data, "Dep�sito", deposito,
						JavaBank_Gestao.utilizador_logado.getN_id(), id_cliente, deposito);
				JavaBank_Conta conta = new JavaBank_Conta_Ordem(n_conta, data, deposito, estado);
				conta.getHistorico_movimentos().add(mov);
				contas.add(conta);
			} else if (tipo.equals("Conta Poupan�a")) {
				if (cont_poup >= 1) {
					janela_confirm = "M�ximo de uma conta poupan�a por cliente.";
				} else {
					JavaBank_Movimento mov = new JavaBank_Movimento(data, "Dep�sito", deposito,
							JavaBank_Gestao.utilizador_logado.getN_id(), id_cliente, deposito);
					JavaBank_Conta conta = new JavaBank_Conta_Poupanca(n_conta, data, deposito, estado);
					conta.getHistorico_movimentos().add(mov);
					contas.add(conta);
				}
			}
		}
		return janela_confirm;
	}

	// M�todo para realizar movimento de determinado valor em determinada conta
	public String movimento(String montante, int aux, String movimento) {
		double saldoInst = 0;
		String mensagem = "";
		for (JavaBank_Conta c : getContas()) {
			if (c.getN_conta() == aux && c.getEstado().equals("Activa")) {
				Calendar cal = Calendar.getInstance();
				String dia = String.valueOf(cal.get(Calendar.DATE));
				String mes = String.valueOf(cal.get(Calendar.MONTH) + 1);
				String ano = String.valueOf(cal.get(Calendar.YEAR));
				String data_movimento = dia + "/" + mes + "/" + ano;
				double quantia = Double.parseDouble(montante);
				double limite = JavaBank_Conta_Ordem.limite_levantamento;
				double limite_diario = JavaBank_Conta_Ordem.limite_diario;
				double limite_mensal = JavaBank_Conta_Poupanca.limite_mensal;
				double quantia_diaria = 0.0;
				double quantia_mensal = 0.0;
				String[] data = null;
				double juros = 0;
				if(c instanceof JavaBank_Conta_Poupanca) {
					juros = calculoJuros(c, dia, mes, ano);
				}
				for (JavaBank_Movimento m : c.getHistorico_movimentos()) {
					if (m.getData_movimento().equals(data_movimento)) {
						quantia_diaria += m.getQuantia();
					}
					data = m.getData_movimento().split("/");
					if (data[1].equals(mes) && data[2].equals(ano)) {
						quantia_mensal += m.getQuantia();
					}
				}
				if (c instanceof JavaBank_Conta_Ordem) {
					if (limite_diario < quantia_diaria + quantia) {
						mensagem = "Montante m�ximo di�rio excedido. Por favor fa�a um levantamento para um total di�rio de valor inferior a "
								+ limite_diario + "�.";
						return mensagem;
					}
					if (limite < quantia) {
						mensagem = "Montante m�ximo excedido. Por favor fa�a um levantamento de valor inferior a "
								+ limite + "�.";
						return mensagem;
					}
				} else if (c instanceof JavaBank_Conta_Poupanca) {
					if (limite_mensal < quantia_mensal + quantia) {
						mensagem = "Montante m�ximo mensal excedido. Por favor fa�a um levantamento para um total mensal de valor inferior a "
								+ limite_mensal + "�.";
						return mensagem;
					}
				}

				if (movimento.equals("Dep�sito") || movimento.contains("Transfer�ncia de")) {
					saldoInst = c.getSaldo() + quantia;
					mensagem = "Opera��o efectuada com sucesso.";
				} else if (movimento.equals("Levantamento") || movimento.contains("Transfer�ncia para")
						|| movimento.contains("Compra")) {
					if (quantia > c.getSaldo()) {
						mensagem = "Saldo insuficiente.";
					} else {
						saldoInst = c.getSaldo() - quantia;
						mensagem = "Opera��o efectuada com sucesso.";
					}
				} else if (c instanceof JavaBank_Conta_Poupanca && juros != 0) {
					saldoInst = c.getSaldo() + juros;
					mensagem = "Juros vencidos. Dep�sito de " + saldoInst + "�.";
				}
				if (mensagem.equals("Opera��o efectuada com sucesso.") || mensagem.contains("Dep�sito")) {
					c.setSaldo(saldoInst);
					int id_funcionario = JavaBank_Gestao.utilizador_logado.getN_id();
					int id_cliente = 0;
					for (JavaBank_Utilizador u : getUtilizadores()) {
						if (u instanceof JavaBank_Cliente
								&& ((JavaBank_Cliente) u).getConta().getN_conta() == c.getN_conta()) {
							id_cliente = u.getN_id();
						}
					}
					JavaBank_Movimento mov = new JavaBank_Movimento(data_movimento, movimento, quantia, id_funcionario,
							id_cliente, saldoInst);
					c.getHistorico_movimentos().add(mov);
				}
			}
		}
		return mensagem;
	}

	public double calculoJuros(JavaBank_Conta c, String dia_actual, String mes_actual, String ano_actual) {
		String[] data_criacao = c.getData_criacao().split("/");
		int dia = Integer.parseInt(data_criacao[0]);
		int mes = Integer.parseInt(data_criacao[1]);
		int ano = Integer.parseInt(data_criacao[2]);
		int dia_hoje = Integer.parseInt(dia_actual);
		int mes_hoje = Integer.parseInt(mes_actual);
		int ano_hoje = Integer.parseInt(ano_actual);
		double quantia = 0.0, soma_depositos = 0.0;
		for (JavaBank_Movimento m : c.getHistorico_movimentos()) {
			if (m.getTipo_movimento().equals("Dep�sito")) {
				soma_depositos += m.getQuantia();
			}
		}
		if (c instanceof JavaBank_Conta_Poupanca && dia == dia_hoje && mes == mes_hoje && ano == ano_hoje + 1) {
			quantia = soma_depositos * (1 + ((JavaBank_Conta_Poupanca) c).getJuros() / 100);
			dia_hoje = dia;
			mes_hoje = mes;
			ano_hoje = ano;
			soma_depositos = 0;
		}
		return quantia;
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

	public static JavaBank_Utilizador getUtilizador_logado() {
		return utilizador_logado;
	}
}
