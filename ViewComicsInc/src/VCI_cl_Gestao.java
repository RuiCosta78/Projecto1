import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Window;

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

	// Abertura da lista de livros.
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

	// Abertura do ficheiro com os números de contas do JavaBank e execução da
	// compra.
	@SuppressWarnings("unchecked")
	public String compraCartao(String nC, double p) {
		String compra = "saldo";
		boolean aux = false;
		ArrayList<JavaBank_Conta> contas = null;
		try {
			File f = new File("Lista de Contas.dat");
			if (f.exists()) {
				FileInputStream ficheiro = new FileInputStream("Lista de Contas.dat");
				ObjectInputStream in = new ObjectInputStream(ficheiro);
				contas = (ArrayList<JavaBank_Conta>) in.readObject();
				in.close();
				ficheiro.close();
				aux = true;
			}
		} catch (Exception e) {
			compra = "cartao";
		}
		if (aux) {
			for (int i = 0; i < contas.size(); i++) {
				if (contas.get(i) instanceof JavaBank_Conta_Ordem) {
					if (nC == ((JavaBank_Conta_Ordem) contas.get(i)).getCartao().getNumero()) {
						if (p <= ((JavaBank_Conta_Ordem) contas.get(i)).getSaldo()) {
							double novoSaldo = ((JavaBank_Conta_Ordem) contas.get(i)).getSaldo() - p;
							((JavaBank_Conta_Ordem) contas.get(i)).setSaldo(novoSaldo);
							compra = "efetuada";
							JavaBank_Gestao jb = new JavaBank_Gestao();
							jb.movimento(Double.toString(p),
									Integer.parseInt(((JavaBank_Conta_Ordem) contas.get(i)).getCartao().getNumero()),
									"Compra ViewComics");
						}
					}
				}
			}
		}
		return compra;
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
					// JFrame caixa = new JFrame();
					// JOptionPane.showMessageDialog(caixa, "Nome do vendedor corrigido.");
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
					// JFrame caixa = new JFrame();
					// JOptionPane.showMessageDialog(caixa, "Estado do vendedor alterado.");
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
				JOptionPane.showMessageDialog(caixa, "Histórico do livro "+ s + " não encontrado.");
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
	public void criarHistorico (String s, GregorianCalendar d, double p) throws IOException {
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
		} catch	(NumberFormatException e) {
			valor = false;
		} catch (NullPointerException e) {
			valor = false;
		} if (valor == true) { // Sendo convertível em inteiro,
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
		} catch	(NumberFormatException e) {
			valor = false;
		} catch (NullPointerException e) {
			valor = false;
		} if (valor == true) { // Sendo convertível em double,
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
