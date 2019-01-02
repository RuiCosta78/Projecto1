import java.util.ArrayList;

/**   
 * Projeto final de Introdução à Programação em Java
 * Classe Carrinho da livraria View Comics Inc 
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_cl_Carrinho {
	
	protected int carrinho_ID;
	protected boolean estado;
	protected ArrayList<VCI_cl_Livro> compras = new ArrayList<>();

	VCI_cl_Carrinho() {
		
	}

	public VCI_cl_Carrinho(int carrinho_ID, boolean estado, ArrayList<VCI_cl_Livro> compras) {
		super();
		this.carrinho_ID = carrinho_ID;
		this.estado = estado;
		this.compras = compras;
	}

	public int getCarrinho_ID() {
		return carrinho_ID;
	}

	public void setCarrinho_ID(int carrinho_ID) {
		this.carrinho_ID = carrinho_ID;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public ArrayList<VCI_cl_Livro> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<VCI_cl_Livro> compras) {
		this.compras = compras;
	}
	
}
