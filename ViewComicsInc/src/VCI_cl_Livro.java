import java.io.Serializable;
import java.util.GregorianCalendar;

/**   
 * Projeto final de Introdução à Programação em Java
 * Classe Livro da livraria View Comics Inc 
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_cl_Livro  implements Serializable {
	
	protected String titulo;
	protected String autor;
	protected String editora;
	protected String isbn;
	protected int anoEdicao;
	protected double preco;
	protected int quantidade;
	
	VCI_cl_Livro() {
		
	}

	public VCI_cl_Livro(String titulo, String autor, String editora, String isbn, int anoEdicao,
			double preco, int quantidade) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.isbn = isbn;
		this.anoEdicao = anoEdicao;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		editora = editora;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getAnoEdicao() {
		return anoEdicao;
	}

	public void setanoEdicao(int anoEdicao) {
		this.anoEdicao = anoEdicao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return titulo;
	}
	

}
