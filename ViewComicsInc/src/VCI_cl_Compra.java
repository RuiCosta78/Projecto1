import java.io.Serializable;
import java.util.GregorianCalendar;

/**   
 * Projeto final de Introdução à Programação em Java
 * Classe Compra da livraria View Comics Inc 
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_cl_Compra implements Serializable {
	
	protected int nif;
	protected VCI_cl_Carrinho carrinho;
	protected GregorianCalendar data;
	protected double valor;
	
	/**
	 * @param nif NIF do cliente.
	 * @param carrinho compras do cliente.
	 * @param data data da compra.
	 * @param valor valor da compra.
	 */
	public VCI_cl_Compra(int nif, VCI_cl_Carrinho carrinho, GregorianCalendar data, double valor) {
		super();
		this.nif = nif;
		this.carrinho = carrinho;
		this.data = data;
		this.valor = valor;
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
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
