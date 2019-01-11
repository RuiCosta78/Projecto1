import java.util.GregorianCalendar;

/**   
 * Projeto final de Introdução à Programação em Java
 * Subclasse Cartao da classe Compr da livraria View Comics Inc 
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_cl_Cartao extends VCI_cl_Compra {
	
	private int numCartao;

	public VCI_cl_Cartao(int nif, VCI_cl_Carrinho carrinho, GregorianCalendar data, double valor, int numCartao) {
		super(nif, carrinho, data, valor);
		this.numCartao = numCartao;
	}

	public int getNumCartao() {
		return numCartao;
	}

	public void setNumCartao(int numCartao) {
		this.numCartao = numCartao;
	}
}
