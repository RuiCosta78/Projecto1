import java.io.Serializable;


/**Classe do utilizador Admin
 * 
 * @author Rui Costa
 *
 */
public class JavaBank_Admin extends JavaBank_Utilizador implements Serializable {

	/**
	 * @param primeiro_nome primeiro nome do utilizador
	 * @param sobrenome sobrenome do utilizador
	 * @param data_nascimento data de nascimento do utilizador
	 * @param tipo_id tipo de documento identificativo
	 * @param n_id nº de identificação do documento
	 * @param endereco morada de residência do utilizador
	 * @param n_contacto contacto telefónico do utilizador
	 * @param login email do utilizador
	 * @param password password do utilizador
	 */
	public JavaBank_Admin(String primeiro_nome, String sobrenome, String data_nascimento, String tipo_id,
			int n_id, String endereco, String n_contacto, String login, String password) {
		super(primeiro_nome, sobrenome, data_nascimento, tipo_id, n_id, endereco, n_contacto, login, password);
		// TODO Auto-generated constructor stub
	}

}
