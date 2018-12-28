

/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class JavaBank_Funcionario extends JavaBank_Utilizador {
	private int id;
	private String estado;
	
	public JavaBank_Funcionario(String primeiro_nome, String sobrenome, String login, String password, int id,
			String estado) {
		super(primeiro_nome, sobrenome, login, password);
		this.id = id;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
