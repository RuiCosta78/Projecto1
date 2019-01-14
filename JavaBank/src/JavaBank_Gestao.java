import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Classe principal onde estão agregadas as listas de utilizadores e de contas
 * do banco Também estão introduzidos os métodos relativos a validação de
 * valores inseridos e operações matemáticas
 * 
 * @author Rui Costa
 *
 */
public class JavaBank_Gestao implements Serializable {

	protected ArrayList<JavaBank_Utilizador> utilizadores = new ArrayList<>();// Lista de utilizadores
	protected ArrayList<JavaBank_Conta> contas = new ArrayList<>();// Lista de contas
	public static JavaBank_Utilizador utilizador_logado;// Informaçao do utilizador logado no momento

	public JavaBank_Gestao() {
		super();

		// JavaBank_Conta conta1 = new JavaBank_Conta_Ordem(1, "1/jan/2001", 250.00,
		// "Activa", null);
		// JavaBank_Conta conta2 = new JavaBank_Conta_Ordem(2, "1/jan/2001", 150.00,
		// "Activa", null);
		// JavaBank_Conta conta3 = new JavaBank_Conta_Poupanca(3, "1/1/2001", 5000.00,
		// "Activa");
		// contas.add(conta1);
		// contas.add(conta2);
		// contas.add(conta3);
		utilizadores.add(new JavaBank_Admin("Rui", "Costa", "29/08/1978", "Cartão de cidadão", 123456789,
				"Rua Maria Vitória Bourbon Bobone, Lote 15.7, 3030-502 Coimbra", "987654321", "rdrmdc",
				"SuperBread1978"));
		utilizadores.add(new JavaBank_Admin("José", "Costa", "29/08/1978", "Cartão de cidadão", 123456789,
				"Rua Maria Vitória Bourbon Bobone, Lote 15.7, 3030-502 Coimbra", "987654321", "qwerty", "asdfghjk"));
		utilizadores.add(new JavaBank_Funcionario("Rui", "Inácio", "rmmi@gmail.com", "12345678", 1, "Inactivo"));
		utilizadores.add(new JavaBank_Cliente("Bruno", "Escada", "1/jan/1980", "Passaporte", 456, "asdf", "234",
				"asdfg@gmail.com", "87654321", "987", new ArrayList<>()));
		utilizadores.add(new JavaBank_Cliente("Nuno", "Pratas", "1/mar/1980", "Cartão de Cidadão", 789, "asdf", "234",
				"asdfg@gmail.com", "12345678", "345", new ArrayList<>()));

	}

	/**
	 * Método mais para carregar o programa de gestão do banco
	 */
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
<<<<<<< HEAD
				JavaBank_Thread.thread();	
=======
				// JavaBank_Thread.thread();
>>>>>>> branch 'master' of https://github.com/RuiCosta78/Projecto1
			}
		});
	}

	/**
	 * Método para confirmar login
	 * 
	 * @param login    login do utilizador inserido. Este atributo é o mail do
	 *                 utilizador
	 * @param password password do utilizador inserido
	 * @return mensagem de confirmação ou erro para ser usada n classe da frame do
	 *         Login
	 * @throws IOException
	 */
	public String login(String login, String password) throws IOException {
		abrirUtilizadores();
		abrirContas();
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
			janela_confirmacao = "Login de Funcionário com sucesso";
		} else if (confirm_cliente == true) {
			janela_confirmacao = "Login de Cliente com sucesso";
		} else {
			janela_confirmacao = "Login inválido";
		}
		gravarContas();
		gravarUtilizadores();
		return janela_confirmacao;
	}

	/**
	 * Método para alteração de dados de login
	 * 
	 * @param username        novo username
	 * @param userConfirm     confirmação do novo username
	 * @param password        nova password
	 * @param passwordConfirm confirmação da nova password
	 * @return
	 * @throws IOException
	 */
	public String alterar_login(String username, String userConfirm, String password, String passwordConfirm)
			throws IOException {
		abrirUtilizadores();
		String janela_confirmacao = "";
		if (!username.equals(userConfirm) || !password.equals(passwordConfirm)) {
			janela_confirmacao = "Alteração não concluída. Dados não confirmados";
		} else if (username.equals(null) || userConfirm.equals(null) || password.equals(null)
				|| passwordConfirm.equals(null)) {
			janela_confirmacao = "Alteração não concluída. Campos em falta.";
		} else {
			janela_confirmacao = "Alteração concluída com sucesso";
			utilizador_logado.setLogin(username);
			utilizador_logado.setPassword(password);
		}
		gravarUtilizadores();
		return janela_confirmacao;
	}

	/**
	 * Método para registo de novo funcionário
	 * 
	 * @param nome            nome do funcionário a ser registado
	 * @param sobrenome       sobrenome do funcionário a ser registado
	 * @param email           email/login do funcionário a ser registado
	 * @param password        password do funcionário a ser registado
	 * @param passwordConfirm confirmação de password
	 * @param estado          estado do funcionário (Activo/Inactivo)
	 * @return mensagem de confirmação ou alerta de registo
	 * @throws IOException
	 */
	public String registar_funcionario(String nome, String sobrenome, String email, String password,
			String passwordConfirm, String estado) throws IOException {
		abrirUtilizadores();
		String janela_confirm = "";
		int cont = 0;// contador de referência para introduzir novo ID de funcionário
		for (JavaBank_Utilizador u : getUtilizadores()) {
			if (u instanceof JavaBank_Funcionario) {
				cont++;
			}
		}

		for (JavaBank_Utilizador u : getUtilizadores()) {
			if (u.getLogin().equals(email)) {
				janela_confirm = "Registo inválido. Email já registado.";
			}
		}

		if (nome.equals(null) || sobrenome.equals(null) || email.equals(null) || password.equals(null)) {
			janela_confirm = "Registo inválido. Campos por preencher.";
		} else if (!isValidEmailAddress(email)) {
			janela_confirm = "Registo inválido. Email inválido.";
		} else if (!password.equals(passwordConfirm)) {
			janela_confirm = "Registo inválido. Password não confirmada correctamente.";
		} else if (password.length() < 8) {
			janela_confirm = "Registo inválido. Password tem de conter no mínimo 8 caractceres.";
		} else {
			janela_confirm = "Registo concluído com sucesso.";
			utilizadores.add(new JavaBank_Funcionario(nome, sobrenome, email, password, cont + 1, estado));
		}
		gravarUtilizadores();
		return janela_confirm;
	}

	/**
	 * Método para registo de novo cliente
	 * 
	 * @param nome            nome do novo cliente
	 * @param sobrenome       sobrenome do novo cliente
	 * @param data            data de nascimento do novo cliente
	 * @param tipoId          tipo de documento de identificação do novo cliente(CC,
	 *                        BI, Passaporte, Outro)
	 * @param numId           número do documento de identificação do novo cliente
	 * @param endereco        morada de residência do novo cliente
	 * @param contacto        contacto telefónico do novo cliente
	 * @param nif             NIF do novo cliente
	 * @param email           email/login do novo cliente
	 * @param password        password do novo cliente
	 * @param passwordConfirm confirmação de password
	 * @return mensagem de confirmação ou alerta de registo
	 * @throws IOException
	 */
	public String registar_cliente(String nome, String sobrenome, String data, String tipoId, int numId,
			String endereco, String contacto, String nif, String email, String password, String passwordConfirm)
			throws IOException {
		abrirUtilizadores();
		String janela_confirm = "";
		for (JavaBank_Utilizador u : getUtilizadores()) {
			if (u.getLogin().equals(email)) {
				janela_confirm = "Registo inválido. Email já registado.";
			}
		}
		if (nome.equals(null) || sobrenome.equals(null) || data.equals(null) || numId == 0 || endereco.equals(null)
				|| contacto.equals(null) || nif.equals(null) || email.equals(null) || password.equals(null)) {
			janela_confirm = "Registo inválido. Campos por preencher.";
		} else if (!isValidEmailAddress(email)) {
			janela_confirm = "Registo inválido. Email inválido.";
		} else if (!password.equals(passwordConfirm)) {
			janela_confirm = "Registo inválido. Password não confirmada correctamente.";
		} else if (password.length() < 8) {
			janela_confirm = "Registo inválido. Password tem de conter no mínimo 8 caracteres.";
		} else if (!validarInteiro(String.valueOf(numId))) {
			janela_confirm = "Registo inválido. Identificação tem de ser um valor numérico.";
		} else if (!validarInteiro(String.valueOf(contacto))) {
			janela_confirm = "Registo inválido. Nº de contacto tem de ser um valor numérico.";
		} else if (!validarInteiro(String.valueOf(nif))) {
			janela_confirm = "Registo inválido. NIF tem de ser um valor numérico.";
		} else {
			janela_confirm = "Registo concluído com sucesso.";
			utilizadores.add(new JavaBank_Cliente(nome, sobrenome, data, tipoId, numId, endereco, contacto, email,
					password, nif, new ArrayList<>()));
		}

		gravarUtilizadores();
		return janela_confirm;
	}

	/**
	 * Método de validação de email; importado jar file para validação
	 * 
	 * @param email email para ser validado
	 * @return boolen true se passa a validação ou false caso contrário
	 */
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

	/**
	 * Método para filtrar os clientes
	 * 
	 * @return lista de clientes sem admins ou funcionários
	 * @throws IOException
	 */
	public ArrayList<JavaBank_Utilizador> listar_clientes() throws IOException {
		abrirUtilizadores();
		ArrayList<JavaBank_Utilizador> clientes = new ArrayList<>();
		for (JavaBank_Utilizador c : getUtilizadores()) {
			if (c instanceof JavaBank_Cliente) {
				clientes.add(c);
			}
		}
		gravarUtilizadores();
		return clientes;
	}

	/**
	 * Método para filtrar os funcionários
	 * 
	 * @return lista de funcionários sem admins ou clientes
	 * @throws IOException
	 */
	public ArrayList<JavaBank_Utilizador> listar_funcionarios() throws IOException {
		abrirUtilizadores();
		ArrayList<JavaBank_Utilizador> funcionarios = new ArrayList<>();
		for (JavaBank_Utilizador f : getUtilizadores()) {
			if (f instanceof JavaBank_Funcionario) {
				funcionarios.add(f);
			}
		}
		gravarUtilizadores();
		return funcionarios;
	}

	/**
	 * Método para abertura de nova conta
	 * 
	 * @param n_conta   número de conta a ser aberta gerado automaticamente
	 * @param nome      nome do cliente que irá ser titular da conta
	 * @param sobrenome sobrenome do cliente que irá ser titular da conta
	 * @param data      data de criação da conta
	 * @param estado    estado da conta (Activa/Inactiva)
	 * @param deposito  depósito inicial da conta opcional
	 * @param tipo      tipo da conta (Poupança/Ordem)
	 * @return mensagem de confirmação ou alerta de registo da nova conta
	 * @throws IOException
	 */
	public String abrir_nova_conta(int n_conta, String nome, String sobrenome, String data, String estado,
			double deposito, String tipo) throws IOException {
		abrirContas();
		abrirUtilizadores();
		String janela_confirm = "";
		int id_cliente = 0;
		int cont = 0, cont_poup = 0;// cont contador para conta à ordem; cont_poup contador para conta poupança
		if (!validarDouble(String.valueOf(deposito))) {
			janela_confirm = "Valor do depósito tem de ser um valor numérico com duas casas decimais separadas por ponto.";
		}
		for (JavaBank_Utilizador u : utilizadores) {
			if (u.getPrimeiro_nome().equals(nome) && u.getSobrenome().equals(sobrenome)
					&& u instanceof JavaBank_Cliente) {
				id_cliente = u.getN_id();
			}
			for (JavaBank_Conta conta : contas) {
				if (conta instanceof JavaBank_Conta_Poupanca
						&& ((JavaBank_Conta_Poupanca) conta).getN_conta() == n_conta) {
					cont_poup++;
				} else if (conta instanceof JavaBank_Conta_Ordem
						&& ((JavaBank_Conta_Ordem) conta).getN_conta() == n_conta) {
					cont++;
				}
			}
		}
		if (cont == 0) {
			janela_confirm = "Registo inválido. Cliente não registado";
		}
		if (nome.equals(null) || sobrenome.equals(null) || data.equals(null) || estado.equals("---Escolha a opção---")
				|| deposito < 0 || tipo.equals("---Escolha a opção---")) {
			janela_confirm = "Registo inválido. Campos por preencher.";
		} else {
			janela_confirm = "Registo concluído com sucesso.";
			JavaBank_Conta conta = new JavaBank_Conta();
			if (tipo.equals("Conta à Ordem")) {
				JavaBank_Movimento mov = new JavaBank_Movimento(data, "Depósito", deposito,
						JavaBank_Gestao.utilizador_logado.getN_id(), id_cliente, deposito);
				conta = new JavaBank_Conta_Ordem(n_conta, data, deposito, estado);
				conta.getHistorico_movimentos().add(mov);
				contas.add(conta);
				for (JavaBank_Utilizador u : utilizadores) {
					if (u.getPrimeiro_nome().equals(nome) && u.getSobrenome().equals(sobrenome)) {
						((JavaBank_Cliente) u).getContas_associadas().add(conta);
					}
				}
			} else if (tipo.equals("Conta Poupança")) {
				if (cont_poup >= 1) {
					janela_confirm = "Máximo de uma conta poupança por cliente.";
				} else {
					JavaBank_Movimento mov = new JavaBank_Movimento(data, "Depósito", deposito,
							JavaBank_Gestao.utilizador_logado.getN_id(), id_cliente, deposito);
					conta = new JavaBank_Conta_Poupanca(n_conta, data, deposito, estado);
					conta.getHistorico_movimentos().add(mov);
					contas.add(conta);
					for (JavaBank_Utilizador u : utilizadores) {
						if (u.getPrimeiro_nome().equals(nome) && u.getSobrenome().equals(sobrenome)) {
							((JavaBank_Cliente) u).getContas_associadas().add(conta);
						}
					}
				}
			}
		}
		gravarUtilizadores();
		gravarContas();
		return janela_confirm;
	}

	/**
	 * Método para realizar movimento de determinado valor em determinada conta
	 * 
	 * @param montante  montante do movimento
	 * @param aux       número da conta que vai ser afectada
	 * @param movimento tipo de movimento
	 *                  (depósito/levantamento/transferência/compra)
	 * @return mensagem de confirmação ou alerta para o movimento efectuado
	 * @throws IOException
	 */
	public String movimento(String montante, int aux, String movimento) throws IOException {
		abrirContas();
		abrirUtilizadores();
		double saldoInst = 0;// saldo referente a cada movimento efectuado
		String mensagem = "";
		if (!validarDouble(montante)) {
			mensagem = "Valor do movimento tem de ser um valor numérico com duas casas decimais separadas por ponto.";
		}
		for (JavaBank_Utilizador u : getUtilizadores()) {
			if (u instanceof JavaBank_Cliente) {
				for (JavaBank_Conta c : ((JavaBank_Cliente) u).getContas_associadas()) {
					if (c.getEstado().equals("Inactiva")) {
						mensagem = "A conta encontra-se fechada. Por favor contace o balcão mais próximo.";
					} else if (c.getN_conta() == aux && c.getEstado().equals("Activa")) {
						Calendar cal = Calendar.getInstance();
						String dia = String.valueOf(cal.get(Calendar.DATE));
						String mes = String.valueOf(cal.get(Calendar.MONTH) + 1);
						String ano = String.valueOf(cal.get(Calendar.YEAR));
						String data_movimento = dia + "/" + mes + "/" + ano;
						double quantia = Double.parseDouble(montante);
						double limite = 200;
						double limite_diario = 1000;
						double limite_mensal = 1000;
						double quantia_diaria = 0.0;
						double quantia_mensal = 0.0;
						String[] data = null;
						double juros = 0;
						int mes_num = 0;
						switch (mes) {
						case "jan":
							mes_num = 1;
							break;
						case "fev":
							mes_num = 2;
							break;
						case "mar":
							mes_num = 3;
							break;
						case "abr":
							mes_num = 4;
							break;
						case "mai":
							mes_num = 5;
							break;
						case "jun":
							mes_num = 6;
							break;
						case "jul":
							mes_num = 7;
							break;
						case "ago":
							mes_num = 8;
							break;
						case "set":
							mes_num = 9;
							break;
						case "out":
							mes_num = 10;
							break;
						case "nov":
							mes_num = 11;
							break;
						case "dez":
							mes_num = 12;
							break;
						default:
							break;
						}
						if (c instanceof JavaBank_Conta_Poupanca) {
							mes = String.valueOf(mes_num);
							juros = calculoJuros(c, dia, mes, ano);
						}
						for (JavaBank_Movimento m : c.getHistorico_movimentos()) {
							if (m.getData_movimento().equals(data_movimento)
									&& m.getTipo_movimento().equals("Levantamento")) {
								quantia_diaria += m.getQuantia();
							}
							data = m.getData_movimento().split("/");
							if (data[1].equals(mes) && data[2].equals(ano)
									&& m.getTipo_movimento().equals("Levantamento")) {
								quantia_mensal += m.getQuantia();
							}
						}
						if (c instanceof JavaBank_Conta_Ordem && movimento.equals("Levantamento")) {
							if (limite_diario < quantia_diaria + quantia) {
								mensagem = "Montante máximo diário excedido. Por favor faça um levantamento para um total diário de valor inferior a "
										+ limite_diario + "€.";
								return mensagem;
							}
							if (limite < quantia) {
								mensagem = "Montante máximo excedido. Por favor faça um levantamento de valor inferior a "
										+ limite + "€.";
								return mensagem;
							}
						} else if (c instanceof JavaBank_Conta_Poupanca && movimento.equals("Levantamento")) {
							if (limite_mensal < quantia_mensal + quantia) {
								mensagem = "Montante máximo mensal excedido. Por favor faça um levantamento para um total mensal de valor inferior a "
										+ limite_mensal + "€.";
								return mensagem;
							}
						}

						if (movimento.equals("Depósito") || movimento.contains("Transferência de")) {
							saldoInst = c.getSaldo() + quantia;
							mensagem = "Operação efectuada com sucesso.";
							c.setSaldo(saldoInst);
						} else if (movimento.equals("Levantamento") || movimento.contains("Transferência para")
								|| movimento.contains("Compra")) {
							if (quantia > c.getSaldo()) {
								mensagem = "Saldo insuficiente.";
							} else {
								saldoInst = c.getSaldo() - quantia;
								mensagem = "Operação efectuada com sucesso.";
								c.setSaldo(saldoInst);
							}
						}
						if (c instanceof JavaBank_Conta_Poupanca && juros != 0) {
							saldoInst = c.getSaldo() + juros;
							mensagem = "Juros vencidos. Depósito de " + saldoInst + "€.";
						}
						int id_funcionario = 0, id_cliente = 0;
<<<<<<< HEAD
						if ((mensagem.equals("Operação efectuada com sucesso.") || mensagem.contains("Depósito")) && !movimento.equals("Compra")) {
							c.setSaldo(saldoInst);
=======
						if ((mensagem.equals("Operação efectuada com sucesso.") || mensagem.contains("Depósito"))
								&& !movimento.equals("Compra")) {
>>>>>>> branch 'master' of https://github.com/RuiCosta78/Projecto1
							id_funcionario = JavaBank_Gestao.utilizador_logado.getN_id();
							id_cliente = u.getN_id();

						}
						JavaBank_Movimento mov = new JavaBank_Movimento(data_movimento, movimento, quantia,
								id_funcionario, id_cliente, saldoInst);
						c.getHistorico_movimentos().add(mov);
						for (JavaBank_Conta conta : contas) {
							if (conta.getN_conta() == c.getN_conta()) {
								conta.getHistorico_movimentos().add(mov);
								conta.setSaldo(c.getSaldo());
							}
						}
					}
				}
			}
		}
		if (!movimento.equals("Compra")) {
<<<<<<< HEAD
		gravarContas();
		gravarUtilizadores();
=======
			gravarContas();
			gravarUtilizadores();
>>>>>>> branch 'master' of https://github.com/RuiCosta78/Projecto1
		}
		return mensagem;
	}

	/**
	 * Cálculo dos juros para uma determinada conta criada numa determinada data
	 * 
	 * @param c          conta a ser validada
	 * @param dia_actual dia da data actual
	 * @param mes_actual mês da data actual
	 * @param ano_actual ano da data actual
	 * @return valor da quantia a ser adicionada à conta c
	 */
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
			if (m.getTipo_movimento().equals("Depósito")) {
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

	/**
	 * Verificar se um dado de input recebido como string é um inteiro.
	 * 
	 * @param s valor em String a ser validado
	 * @return true se s é inteiro, false caso contrário
	 */
	public boolean validarInteiro(String s) {
		boolean inteiro = false, valor = true;
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			valor = false;
		} catch (NullPointerException e) {
			valor = false;
		}
		if (valor == true) { // Sendo convertível em inteiro,
			int i = Integer.parseInt(s);
			if (i % 1 == 0) { // Se o resto da divisão por 1 for inteiro, o n.º é inteiro.
				inteiro = true;
			}
		}
		return inteiro;
	}

	/**
	 * Verificar se um dado de input recebido como string é um double com máximo de
	 * duas casas decimais.
	 * 
	 * @param s valor em String a ser validado
	 * @return true se s é inteiro, false caso contrário
	 */
	public boolean validarDouble(String s) {
		boolean decimal = false, valor = true;
		try { // tenta a conversão:
			Double.parseDouble(s);
		} catch (NumberFormatException e) {
			valor = false;
		} catch (NullPointerException e) {
			valor = false;
		}
		if (valor == true) { // Sendo convertível em double,
			double d = Double.parseDouble(s) * 100;
			if (d % 1 == 0) { // Se o valor *100 for inteiro, tem no máx. duas casas decimais.
				decimal = true;
			}
		}
		return decimal;
	}

	/**Gravação da lista de utilizadores
	 * 
	 * @throws IOException
	 */
	public void gravarUtilizadores() throws IOException {
		FileOutputStream fileOut = new FileOutputStream("JavaBank_Utilizadores.dat");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(utilizadores);
		out.close();
		fileOut.close();
	}

	/**Abertura da lista de utilizadores.
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void abrirUtilizadores() throws IOException {
		try {
			File f = new File("JavaBank_Utilizadores.dat");
			if (f.exists()) {
				FileInputStream ficheiro = new FileInputStream(f);
				ObjectInputStream in = new ObjectInputStream(ficheiro);
				utilizadores = (ArrayList<JavaBank_Utilizador>) in.readObject();
				in.close();
				ficheiro.close();
			} else {
				utilizadores.add(new JavaBank_Admin("Rui", "Costa", "29/08/1978", "Cartão de cidadão", 123456789,
						"Rua Maria Vitória Bourbon Bobone, Lote 15.7, 3030-502 Coimbra", "987654321", "rdrmdc",
						"SuperBread1978"));
			}
		} catch (Exception e) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Ficheiro de utilizadores não encontrado.");
		}
	}

	/**Gravação da lista de contas
	 * 
	 * @throws IOException
	 */
	public void gravarContas() throws IOException {
		FileOutputStream fileOut = new FileOutputStream("JavaBank_Contas.dat");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(contas);
		out.close();
		fileOut.close();
	}

	/**Abertura da lista de contas.
	 * 
	 * @return lista de contas para ser comunicada
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<JavaBank_Conta> abrirContas() throws IOException {
<<<<<<< HEAD
		ArrayList<JavaBank_Conta> contas = new ArrayList<>();
=======
>>>>>>> branch 'master' of https://github.com/RuiCosta78/Projecto1
		try {
			File f = new File("JavaBank_Contas.dat");
			if (f.exists()) {
				FileInputStream ficheiro = new FileInputStream(f);
				ObjectInputStream in = new ObjectInputStream(ficheiro);
				contas = (ArrayList<JavaBank_Conta>) in.readObject();
				in.close();
				ficheiro.close();
			}
		} catch (Exception e) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Ficheiro de contas não encontrado.");
		}
		return contas;
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
