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

	public VCI_cl_Gestao() {
		
		// Lista de utilizadores inicial
	/*	listaUtilizadores.add(new VCI_cl_Admin("Rui Inácio", "rmmi@sapo.pt", "12345678", 1));
		listaUtilizadores.add(new VCI_cl_Vendedor("Zé Mãozinhas", "zem@sapo.pt","abcdefgh", false));
	*/	listaLivros.add(new VCI_cl_Livro("Os dez Espelhos de Benjamim Zarco", "Richard Zimler", "Porto Editora", "978-972-0-03129-7", 2018, 19.99 , 50));
		
	}

	public void ficheiroLv() throws IOException {
		FileOutputStream fileOut = new FileOutputStream("Lista de Livros.dat");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(this.listaLivros);
		out.close();
		fileOut.close();
		System.out.println("Gravou");
	}

	/*
	 * // Lista de compras inicial public void comprasZero() {
	 * ArrayList<VCI_cl_Livro> compra1 = new ArrayList<VCI_cl_Livro>();
	 * compra1.add(listaLivros.get(0)); listaCompras.add(new
	 * VCI_cl_Compra(123456789, new VCI_cl_Carrinho(1, true, compra1))); }
	 */
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
		//System.out.println("Gravou");
	}

	// Gravação da lista de livros
	public void gravarLivros() throws IOException {
		FileOutputStream fileOut = new FileOutputStream("Lista de Livros.dat");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(this.listaLivros);
		out.close();
		fileOut.close();
		//System.out.println("Gravou");
	}

	// Abertura da lista de utilizadores.
	public ArrayList<VCI_cl_Utilizador> abrirUtilizadores() {
		try {
			File f = new File("Lista de Utilizadores.dat");
			if (f.exists()) {
				FileInputStream ficheiro = new FileInputStream("Lista de Utilizadores.dat");
				ObjectInputStream in = new ObjectInputStream(ficheiro);
				this.listaUtilizadores = (ArrayList<VCI_cl_Utilizador>) in.readObject();
				in.close();
				ficheiro.close();
			}
		} catch (Exception e) {
			System.out.println("Ficheiro não encontrado " + e);
		}
		return listaUtilizadores;
	}

	// Abertura da lista de livros.
		public ArrayList<VCI_cl_Livro> abrirLivros() {
			try {
				File f = new File("Lista de Livros.dat");
				if (f.exists()) {
					FileInputStream ficheiro = new FileInputStream("Lista de Livros.dat");
					ObjectInputStream in = new ObjectInputStream(ficheiro);
					this.listaLivros = (ArrayList<VCI_cl_Livro>) in.readObject();
					in.close();
					ficheiro.close();
				}
			} catch (Exception e) {
				System.out.println("Ficheiro não encontrado " + e);
			}
			return listaLivros;
		}

	// Login para utilizadores Admin e Vendedor.
	// Recebe as strings email e password do login
	public String login(String u, String s) throws IOException, ClassNotFoundException {
		String resultadoLogin = "errado"; // resultado do login por defeito
		boolean Admin = false;
		boolean Vendedor = false;
		// Procura do email e da password no ficheiro listaUtilizadores:
		for (VCI_cl_Utilizador ut : abrirUtilizadores()) { // Percorre os utilizadores
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
		abrirUtilizadores();
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

	// Registo de vendedor com nome, email (já validado), senha (já validada) e
	// estado do vendedor.
	public VCI_cl_Vendedor registarVendedor(String n, String e, String s, boolean est) throws IOException {
		VCI_cl_Vendedor novoU = new VCI_cl_Vendedor(n, e, s, est);
		listaUtilizadores.add(novoU);
		gravarUtilizadores();
		return novoU;
	}
	
	// Corrigir o nome de um vendedor
	public void corrigirNome (String nOrig, String nNovo) throws IOException {
		abrirUtilizadores();
		for (VCI_cl_Utilizador u : listaUtilizadores) {
			if (u instanceof VCI_cl_Vendedor) {
				if (u.getNome().equals(nOrig)) {
					u.setNome(nNovo);
					gravarUtilizadores();
					JFrame caixa = new JFrame();
					JOptionPane.showMessageDialog(caixa, "Nome do vendedor corrigido.");
				}
			}
		}
	}
	
	// Alterar estado do vendedor
	public void alterarEstado(String n, boolean b) throws IOException {
		abrirUtilizadores();
		for (VCI_cl_Utilizador u : listaUtilizadores) {
			if (u instanceof VCI_cl_Vendedor) {
				if (u.getNome().equals(n)) {
					if (((VCI_cl_Vendedor) u).isEstado() != b) {
						((VCI_cl_Vendedor) u).setEstado(b);
						gravarUtilizadores();
						JFrame caixa = new JFrame();
						JOptionPane.showMessageDialog(caixa, "Estado do vendedor alterado.");
					}
				}
			}
		}
	}
	
	// Adicionar novo livro à lista de livros
	public VCI_cl_Livro adicionarLivro(String t, String a, String e, String i, int an, double p, int q) throws IOException {
		abrirLivros();
		VCI_cl_Livro novoL = new VCI_cl_Livro(t, a, e, i, an, p, q);
		listaLivros.add(novoL);
		gravarLivros();
		return novoL;
	}
/*
	// Registar Admin (início).
	public VCI_cl_Admin registarAdmin(String n, String e, String s, int id) throws IOException {
		VCI_cl_Admin novoA = new VCI_cl_Admin(n, e, s, 1);
		listaUtilizadores.add(novoA);
		gravarFicheiro("Lista de Utilizadores");
		return novoA;
	}
*/
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
