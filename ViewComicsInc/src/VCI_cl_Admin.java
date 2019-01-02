import java.io.Serializable;

/**   
 * Projeto final de Introdução à Programação em Java
 * Subclasse Admin da classe Utilizador da livraria View Comics Inc 
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_cl_Admin extends VCI_cl_Utilizador  implements Serializable {
	
	private int admin_ID;
	
	VCI_cl_Admin() {
		
	}

	public VCI_cl_Admin(String nome, String email, String senha, int admin_ID) {
		super(nome, email, senha);
		this.admin_ID = admin_ID;
	}



	public int getAdmin_ID() {
		return admin_ID;
	}

	public void setAdmin_ID(int admin_ID) {
		this.admin_ID = admin_ID;
	}

	
}
