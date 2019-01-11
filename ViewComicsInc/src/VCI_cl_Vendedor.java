import java.io.Serializable;

/**   
 * Projeto final de Introdução à Programação em Java
 * Subclasse Vendedor da classe Utilizador da livraria View Comics Inc 
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_cl_Vendedor extends VCI_cl_Utilizador  implements Serializable {
	
	private boolean estado;
	
	public VCI_cl_Vendedor(String nome, String email, String senha, boolean estado) {
		super(nome, email, senha);
		this.estado = estado;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
