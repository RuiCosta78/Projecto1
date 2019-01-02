import java.io.Serializable;
import java.util.*;

/**
 * Breve descrição do código
 * 
 * @sid 2001
 * @aid 1.1
 */

public class Teste implements Serializable {

	protected ArrayList<VCI_cl_Livro> listaLivros = new ArrayList<VCI_cl_Livro>();
	protected ArrayList<VCI_cl_Utilizador> listaUtilizadores = new ArrayList<VCI_cl_Utilizador>();
	protected ArrayList<VCI_cl_Compra> listaCompras = new ArrayList<VCI_cl_Compra>();

	public Teste() {
		listaLivros.add(new VCI_cl_Livro("Os dez Espelhos de Benjamim Zarco", "Richard Zimler", "Porto Editora",
				"978-972-0-03129-7", 2018, 19.99, 50));
	}
/*
	public Teste(ArrayList<VCI_cl_Livro> listaLivros, ArrayList<VCI_cl_Utilizador> listaUtilizadores,
			ArrayList<VCI_cl_Compra> listaCompras) {
		super();
		this.listaLivros = listaLivros;
		this.listaUtilizadores = listaUtilizadores;
		this.listaCompras = listaCompras;
	}

	// Lista de livros:
	public void listaLivros() {
		listaLivros.add(new VCI_cl_Livro("Os dez Espelhos de Benjamim Zarco", "Richard Zimler", "Porto Editora",
				"978-972-0-03129-7", 2018, 19.99, 50));
	}
/*
	// Lista de utilizadores:
	public void listaUtilizadores() {
		listaUtilizadores.add(new VCI_cl_Admin("Rui Inácio", "rmmi@sapo.pt", "12345678", 1));
		listaUtilizadores.add(new VCI_cl_Vendedor("Zé Mãozinhas", "zem@sapo.pt", "abcdefgh", false));	}

	// Lista de compras:
	public void listaCompras() {
		ArrayList<VCI_cl_Livro> compra1 = new ArrayList<VCI_cl_Livro>();
		compra1.add(listaLivros.get(0));
		listaCompras.add(new VCI_cl_Compra(123456789, new VCI_cl_Carrinho(1, true, compra1)));
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

	public void setListaCompras(ArrayList<VCI_cl_Compra> listaCompras) {
		this.listaCompras = listaCompras;
	}

	@Override
	public String toString() {
		return "Teste [listaLivros=" + listaLivros + ", listaUtilizadores=" + listaUtilizadores + ", listaCompras="
				+ listaCompras + "]";
	}
	
}
