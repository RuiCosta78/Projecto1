
/**   
 * Projeto final de Introdução à Programação em Java
 * Subclasse Cartao da classe Compr da livraria View Comics Inc 
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_cl_Cartao extends VCI_cl_Compra {
	
	private int numCartao;
	private int codCartao;
	
	VCI_cl_Cartao() {
		
	}

	public VCI_cl_Cartao(int numCartao, int codCartao) {
		super();
		this.numCartao = numCartao;
		this.codCartao = codCartao;
	}

	public int getNumCartao() {
		return numCartao;
	}

	public void setNumCartao(int numCartao) {
		this.numCartao = numCartao;
	}

	public int getCodCartao() {
		return codCartao;
	}

	public void setCodCartao(int codCartao) {
		this.codCartao = codCartao;
	}

}
