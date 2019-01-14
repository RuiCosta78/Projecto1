import java.io.Serializable;

/**Classe para o utilizador Funcionário
 * 
 * @author Acer
 *
 */
public class JavaBank_Funcionario extends JavaBank_Utilizador implements Serializable {
	private int id;
	private String estado;
	
	/**
	 * @param primeiro_nome primeiro nome do utilizador
	 * @param sobrenome sobrenome do utilizador
	 * @param login email do utilizador
	 * @param password password do utilizador
	 * @param id identificação no banco do funcionário
	 * @param estado estado do funcionário (Activo/Inactivo)
	 */
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
