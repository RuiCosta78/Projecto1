
/**   
 * Projeto final de Introdução à Programação em Java
 * Subclasse Dinheiro da classe Compra da livraria View Comics Inc 
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_cl_Dinheiro extends VCI_cl_Compra {
	
	private double valor;
	
	VCI_cl_Dinheiro() {
		
	}

	public VCI_cl_Dinheiro(double valor) {
		super();
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
