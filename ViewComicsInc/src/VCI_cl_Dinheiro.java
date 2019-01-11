import java.io.Serializable;
import java.util.GregorianCalendar;

/**   
 * Projeto final de Introdução à Programação em Java
 * Subclasse Dinheiro da classe Compra da livraria View Comics Inc 
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_cl_Dinheiro extends VCI_cl_Compra implements Serializable {
	
	//private double valor;
	
	public VCI_cl_Dinheiro(int nif, VCI_cl_Carrinho carrinho, GregorianCalendar data, double valor) {
		super(nif, carrinho, data, valor);
		// TODO Auto-generated constructor stub
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
