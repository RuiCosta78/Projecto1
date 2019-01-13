import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.EventQueue;

/**
 * Projeto final de Introdução à Programação em Java Gestão da livraria View
 * Comics Inc
 * 
 * @sid 2001
 * @aid 1.1
 */

public class VCI_cl_Gestao implements Serializable {

	protected ArrayList<VCI_cl_Livro> listaLivros = new ArrayList<>();
	protected ArrayList<VCI_cl_Utilizador> listaUtilizadores = new ArrayList<>();
	protected ArrayList<VCI_cl_Compra> listaCompras = new ArrayList<>();
	public static VCI_cl_Utilizador utilizador;
	public static VCI_cl_Carrinho cliente;

	public VCI_cl_Gestao() {

	}

	// Ativação da 1.ª janela do programa
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VCI_N1 window = new VCI_N1();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Gravação da lista de utilizadores
	public void gravarUtilizadores() throws IOException {
		FileOutputStream fileOut = new FileOutputStream("Lista de Utilizadores.dat");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(this.listaUtilizadores);
		out.close();
		fileOut.close();
	}

	// Gravação da lista de livros
	public void gravarLivros() throws IOException {
		FileOutputStream fileOut = new FileOutputStream("Lista de Livros.dat");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(this.listaLivros);
		out.close();
		fileOut.close();
	}

	// Gravação da lista de compras
	public void gravarCompras() throws IOException {
		FileOutputStream fileOut = new FileOutputStream("Lista de Compras.dat");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(this.listaCompras);
		out.close();
		fileOut.close();
	}

	// Abertura da lista de utilizadores.
	@SuppressWarnings("unchecked")
	public void abrirUtilizadores() throws IOException {
		try {
			File f = new File("Lista de Utilizadores.dat");
			if (f.exists()) {
				FileInputStream ficheiro = new FileInputStream(f);
				ObjectInputStream in = new ObjectInputStream(ficheiro);
				this.listaUtilizadores = (ArrayList<VCI_cl_Utilizador>) in.readObject();
				in.close();
				ficheiro.close();
			}
		} catch (Exception e) {
			JFrame caixa = new JFrame();
			JOptionPane.showMessageDialog(caixa, "Ficheiro de utilizadores não encontrado.");
		}
	}

	// Abertura da lista de livros.
	@SuppressWarnings("unchecked")
	public void abrirLivros() {
		try {
			File f = new File("Lista de Livros.dat");
			if (f.exists()) {
				FileInputStream ficheiro = new FileInputStream(f);
				ObjectInputStream in = new ObjectInputStream(ficheiro);
				this.listaLivros = (ArrayList<VCI_cl_Livro>) in.readObject();
				in.close();
				ficheiro.close();
			}
		} catch (Exception e) {
			JFrame caixa = new JFrame();
			JOptionPane.showMessageDialog(caixa, "Não existem livros na base de dados.");
		}
	}

	// Abertura da lista de compras.
	@SuppressWarnings("unchecked")
	public void abrirCompras() {
		try {
			File f = new File("Lista de Compras.dat");
			if (f.exists()) {
				FileInputStream ficheiro = new FileInputStream(f);
				ObjectInputStream in = new ObjectInputStream(ficheiro);
				this.listaCompras = (ArrayList<VCI_cl_Compra>) in.readObject();
				in.close();
				ficheiro.close();
			}
		} catch (Exception e) {
			//
		}
	}

	// Login para utilizadores Admin e Vendedor.
	// Recebe as strings email e password do login
	public String login(String u, String s) throws IOException, ClassNotFoundException {
		String resultadoLogin = "errado"; // resultado do login por defeito
		boolean Admin = false;
		boolean Vendedor = false;
		// Procura do email e da password no ficheiro listaUtilizadores:
		abrirUtilizadores();
		if (listaUtilizadores.size() == 0) {
			JFrame caixa = new JFrame();
			JOptionPane.showMessageDialog(caixa, "Primeiro acesso ao sistema. Criação de Admin por defeito.");
			listaUtilizadores.add(new VCI_cl_Admin("Rui Inácio", "rmmi@sapo.pt", "12345678", 1));
			gravarUtilizadores();
		}
		for (VCI_cl_Utilizador ut : listaUtilizadores) { // Percorre os utilizadores
			if (ut.getEmail().equals(u) && ut.getSenha().equals(s) && ut instanceof VCI_cl_Admin) {
				Admin = true; // É Admin se o email e senha corresponde a um utilizador do tipo Admin
				utilizador = ut; // Define a variável utilizador de atributo desta classe para consulta ao longo
									// do programa
			} else if (ut.getEmail().equals(u) && ut.getSenha().equals(s) && ut instanceof VCI_cl_Vendedor) {
				Vendedor = true; // É Vendedor se o email e senha corresponde a um utilizador do tipo Vendedor
				utilizador = ut; // Define a variável utilizador de atributo desta classe para consulta ao longo
									// do programa
			}
		}
		if (Admin == true) {
			resultadoLogin = "Admin";
		} else if (Vendedor == true) {
			resultadoLogin = "Vendedor";
		}
		return resultadoLogin; // Se o email e senha não corresponderem a nenhum utilizador devolve por defeito
								// "errado".
	}

	// Alteração dos dados de login para Admin e Vendedor
	// Recebe o novo email e a nova senha para substituir na memória.
	// O novo email e a nova senha são recebidos já validados.
	public void alterarLogin(String u, String s) throws IOException {
		VCI_cl_Gestao.utilizador.setEmail(u);
		VCI_cl_Gestao.utilizador.setSenha(s);
		gravarUtilizadores();
	}

	// Validação do formato do email.
	public boolean validarEmail(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	// Novo cliente no sistema (criação do carrinho).
	public void novoCliente(String s) {
		// Criação do carrinho para o cliente com estado false (compra não finalizada) e
		// lista de compras vazia.
		ArrayList<VCI_cl_Livro> listaCompras = new ArrayList<VCI_cl_Livro>();
		ArrayList<Integer> nLivros = new ArrayList<Integer>();
		cliente = new VCI_cl_Carrinho(s, listaCompras, nLivros);
	}

	// Registo de vendedor com nome, email (já validado), senha (já validada) e
	// estado do vendedor.
	public VCI_cl_Vendedor registarVendedor(String n, String e, String s, boolean est) throws IOException {
		VCI_cl_Vendedor novoU = new VCI_cl_Vendedor(n, e, s, est);
		listaUtilizadores.add(novoU);
		gravarUtilizadores();
		return novoU;
	}

	// Corrigir o nome de um vendedor
	public void corrigirNome(String nOrig, String nNovo) throws IOException {
		for (VCI_cl_Utilizador u : listaUtilizadores) {
			if (u instanceof VCI_cl_Vendedor) {
				if (((VCI_cl_Vendedor) u).getNome().equals(nOrig)) {
					((VCI_cl_Vendedor) u).setNome(nNovo);
					gravarUtilizadores();
				}
			}
		}
	}

	// Alterar estado do vendedor
	public void alterarEstado(String n, boolean b) throws IOException {
		for (VCI_cl_Utilizador u : listaUtilizadores) {
			if (u instanceof VCI_cl_Vendedor) {
				if (((VCI_cl_Vendedor) u).getNome().equals(n)) {
					((VCI_cl_Vendedor) u).setEstado(b);
					gravarUtilizadores();
				}
			}
		}
	}

	// Adicionar novo livro à lista de livros
	public VCI_cl_Livro adicionarLivro(String t, String a, String e, String i, int an, double p, int q)
			throws IOException {
		abrirLivros();
		VCI_cl_Livro novoL = new VCI_cl_Livro(t, a, e, i, an, p, q);
		listaLivros.add(novoL);
		gravarLivros();
		return novoL;
	}

	// Abertura da lista de utilizadores.
	public VCI_cl_Historico abrirHistorico(String s) throws IOException {
		VCI_cl_Historico h = null;
		try {
			File f = new File(s + ".dat");
			if (f.exists()) {
				FileInputStream ficheiro = new FileInputStream(f);
				ObjectInputStream in = new ObjectInputStream(ficheiro);
				h = (VCI_cl_Historico) in.readObject();
				in.close();
				ficheiro.close();
			}
		} catch (Exception e) {
			JFrame caixa = new JFrame();
			JOptionPane.showMessageDialog(caixa, "Histórico do livro " + s + " não encontrado.");
		}
		return h;
	}

	// Gravação da lista de livros
	public void gravarHistorico(VCI_cl_Historico h) throws IOException {
		File f = new File(h.getIsbn() + ".dat");
		FileOutputStream fileOut = new FileOutputStream(f);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(h);
		out.close();
		fileOut.close();
	}

	// Criação do 1.º histórico de preços dos livros.
	public void criarHistorico(String s, GregorianCalendar d, double p) throws IOException {
		// Criação do objeto VCI_cl_Historico:
		ArrayList<GregorianCalendar> datas = new ArrayList<GregorianCalendar>();
		datas.add(d);
		ArrayList<Double> precos = new ArrayList<Double>();
		precos.add(p);
		VCI_cl_Historico h = new VCI_cl_Historico(s, datas, precos);
		// Criação do ficheiro:
		FileOutputStream fileOut = new FileOutputStream(s + ".dat");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(h);
		out.close();
		fileOut.close();
	}

	// Verificar se um dado de input recebido como string é um inteiro.
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

	// Verificar se um dado de input recebido como string é um double com
	// máximo de duas casas decimais.
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

	public String obterLivros(ArrayList<VCI_cl_Livro> lis, ArrayList<Integer> quant) {
		String livros = "";
		for (int i = 0; i < lis.size(); i++) {
			livros = lis.get(i).getTitulo() + " - " + quant.get(i) + "; " + livros;
		}
		return livros;
	}

	// Abertura do ficheiro com os números de contas do JavaBank e execução da
	public void compraCartao(String nC, double p) throws NumberFormatException, IOException {
		//String resposta = "";
		String[] pedido = { nC, String.valueOf(p) }; // Ficheiro para o banco.
		FileOutputStream fileOut = new FileOutputStream("pedido.dat");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(pedido);
		out.close();
		fileOut.close();
		System.out.println("compraCartao   " + pedido[0] + " " + pedido[1]);
	}

	// Recebe o ficheiro do banco
	public String respostaBanco() {
		String[] resposta = { " " };
		while (resposta[0].equals(" ")) {
			JFrame caixa = new JFrame();
			JOptionPane.showMessageDialog(caixa, "Aguarda comunicação...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				File f = new File("resposta.dat");
				if (f.exists()) {
					FileInputStream ficheiro = new FileInputStream(f);
					ObjectInputStream in = new ObjectInputStream(ficheiro);
					resposta[0] = (String) in.readObject();
					in.close();
					ficheiro.close();
				}
			} catch (Exception e) {
				//
			}
			caixa.dispose();
		}
		return resposta[0];
	}

	// Apagar ficheiro (aplicado aos ficheiros entre livraria e banco).
	public void apagarFicheiro(String s) {
		File f = new File(s + ".dat");
		try {
			if (f.exists()) {
				f.delete();
			}
		} catch (Exception e) {
			//
		}
	}

	// EXECUÇÃO DO PEDIDO PELO BANCO.
	public static String[] show(ArrayList<JavaBank_Conta> contas) throws IOException {
		JavaBank_Gestao gestao = new JavaBank_Gestao();
		String resp = "";
		String[] dados = new String[2];
		String[] resposta = new String[1];
			dados = abrirPedido();
			System.out.println("show - dados   " + dados[0] + " " + dados[1]); // SHOW DADOS
			int aux = 0;
				for (JavaBank_Conta c : contas) {
				System.out.println("show - n.º conta  " + c.getN_conta());
				if (c instanceof JavaBank_Conta_Ordem) {
					for (JavaBank_Cartao_Debito car : ((JavaBank_Conta_Ordem) c).getCartoes_associados()) {
						if (car.getNumero().equals(dados[0])) {
							aux = c.n_conta;
							System.out.println("show - cartao   " + car.getNumero()); // SHOW CARTAO
							if (c.getEstado().equals("Inactiva")) {
								resposta[0] = "inativo";
							}
						} else {
							resposta[0] = "errado";
						}
					}
				}
			}
			System.out.println("show - conta   " + aux); // SHOW CONTA
			resp = gestao.movimento(dados[1], aux, "Compra");
			if (resp.equals("Saldo insuficiente.")) {
				resposta[0] = "sem saldo";
			} else if (resp.equals("Operação efectuada com sucesso.")) {
				resposta[0] = "sucesso";
			}
			System.out.println("show - resposta   " + resposta[0]); // SHOW RESPOSTA
		return resposta;
	}
	
	// Gravação da lista de contas
		public void gravarContas(ArrayList<JavaBank_Conta> c) throws IOException {
			FileOutputStream fileOut = new FileOutputStream("JavaBank_Contas.dat");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(c);
			out.close();
			fileOut.close();
		}


	// Gravação da resposta.
	public static void gravarResposta(ArrayList<JavaBank_Conta> c) throws IOException {
		File f = new File("resposta.dat");
		FileOutputStream fileOut = new FileOutputStream(f);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		String[] resposta = show(c);
		out.writeObject(resposta);
		out.close();
		fileOut.close();
	}

	@SuppressWarnings("unchecked")
	public static String[] abrirPedido() throws IOException {
		String[] dados = new String[2];
		try {
			File f = new File("pedido.dat");
			if (f.exists()) {
				FileInputStream ficheiro = new FileInputStream(f);
				ObjectInputStream in = new ObjectInputStream(ficheiro);
				dados = (String[]) in.readObject();
				in.close();
				ficheiro.close();
			}
		} catch (Exception e) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Ficheiro de contas não encontrado.");
		}
		return dados;
	}

	public ArrayList<VCI_cl_Livro> getListaLivros() {
		return listaLivros;
	}

	public void setListaLivros(ArrayList<VCI_cl_Livro> listaLivros) {
		this.listaLivros = listaLivros;
	}

	public ArrayList<VCI_cl_Utilizador> getListaUtilizadores() {
		return listaUtilizadores;
	}

	public void setListaUtilizadores(ArrayList<VCI_cl_Utilizador> listaUtilizadores) {
		this.listaUtilizadores = listaUtilizadores;
	}

	public ArrayList<VCI_cl_Compra> getListaCompras() {
		return listaCompras;
	}

	public VCI_cl_Utilizador getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(VCI_cl_Utilizador utilizador) {
		this.utilizador = utilizador;
	}

	public void setListaCompras(ArrayList<VCI_cl_Compra> listaCompras) {
		this.listaCompras = listaCompras;
	}

}
