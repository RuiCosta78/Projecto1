import java.util.GregorianCalendar;

/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class JavaBank_Funcionario extends JavaBank_Utilizador {
	private int id;
	private boolean estado;
	
	public JavaBank_Funcionario(String primeiro_nome, String sobrenome, GregorianCalendar data_nascimento,
			String tipo_id, int n_id, String endereco, int n_contacto, String login, String password, int id,
			boolean estado) {
		super(primeiro_nome, sobrenome, data_nascimento, tipo_id, n_id, endereco, n_contacto, login, password);
		this.id = id;
		this.estado = estado;
	}

	

}
