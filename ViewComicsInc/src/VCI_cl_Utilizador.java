import java.io.Serializable;

/**   
 * Projeto final de Introdução à Programação em Java
 * Classe Utilizador da livraria View Comics Inc 
 * @sid 2001
 * @aid 1.1   
 */

public class VCI_cl_Utilizador implements Serializable {
	
	protected String nome;
	protected String email;
	protected String senha;
	
	VCI_cl_Utilizador() {
		
	}

	public VCI_cl_Utilizador(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}

	
	

}
