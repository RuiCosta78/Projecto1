import java.util.GregorianCalendar;

/**   
 * Projeto final de Introdução à Programação em Java
 * Classe Compra da livraria View Comics Inc 
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_cl_Compra {
	
	protected int nif;
	protected VCI_cl_Carrinho carrinho;
	protected GregorianCalendar data;
	
	VCI_cl_Compra() {
		
	}

	public VCI_cl_Compra(int nif, VCI_cl_Carrinho carrinho, GregorianCalendar data) {
		super();
		this.nif = nif;
		this.carrinho = carrinho;
		this.data = data;
	}

	public int getNif() {
		return nif;
	}

	public void setNif(int nif) {
		this.nif = nif;
	}

	public VCI_cl_Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(VCI_cl_Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}

}
