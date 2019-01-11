import java.io.Serializable;
import java.util.ArrayList;

/**   
 * Projeto final de Introdução à Programação em Java
 * Classe Carrinho da livraria View Comics Inc 
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_cl_Carrinho  implements Serializable {
	
	protected String nome;
	protected ArrayList<VCI_cl_Livro> listaCompras;
	protected ArrayList<Integer> quantLivros;

	VCI_cl_Carrinho() {
		
	}

	public VCI_cl_Carrinho(String nome, ArrayList<VCI_cl_Livro> listaCompras, ArrayList<Integer> quantLivros) {
		super();
		this.nome = nome;
		this.listaCompras = listaCompras;
		this.quantLivros = quantLivros;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Integer> getQuantLivros() {
		return quantLivros;
	}

	public void setQuantLivros(ArrayList<Integer> quantLivros) {
		this.quantLivros = quantLivros;
	}

	public ArrayList<VCI_cl_Livro> getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(ArrayList<VCI_cl_Livro> listaCompras) {
		this.listaCompras = listaCompras;
	}
	
}
