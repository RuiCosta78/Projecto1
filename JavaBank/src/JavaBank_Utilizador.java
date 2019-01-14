import java.io.Serializable;

/**Classe do objecto Utilizador
 * 
 * @author Rui Costa
 *
 */
public class JavaBank_Utilizador implements Serializable{
	
	protected String primeiro_nome;
	protected String sobrenome;
	protected String data_nascimento;
	protected String tipo_id;
	protected int n_id;
	protected String endereco;
	protected String n_contacto;
	protected String login;
	protected String password;
	
	/**
	 * @param primeiro_nome primeiro nome do utilizador
	 * @param sobrenome sobrenome do uitlizador
	 * @param data_nascimento data de nascimento do utilizador
	 * @param tipo_id tipo do documento de identificação do utilizador
	 * @param n_id nº do documento de identificação do utilizador
	 * @param endereco morada de residência do utilizador
	 * @param n_contacto contacto telefónico do utilizador
	 * @param login email do utilizador
	 * @param password password do utilizador
	 */
	public JavaBank_Utilizador(String primeiro_nome, String sobrenome, String data_nascimento,
			String tipo_id, int n_id, String endereco, String n_contacto, String login, String password) {
		super();
		this.primeiro_nome = primeiro_nome;
		this.sobrenome = sobrenome;
		this.data_nascimento = data_nascimento;
		this.tipo_id = tipo_id;
		this.n_id = n_id;
		this.endereco = endereco;
		this.n_contacto = n_contacto;
		this.login = login;
		this.password = password;
	}

	public JavaBank_Utilizador(String primeiro_nome, String sobrenome, String login, String password) {
		super();
		this.primeiro_nome = primeiro_nome;
		this.sobrenome = sobrenome;
		this.login = login;
		this.password = password;
	}

	public String getPrimeiro_nome() {
		return primeiro_nome;
	}

	public void setPrimeiro_nome(String primeiro_nome) {
		this.primeiro_nome = primeiro_nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getTipo_id() {
		return tipo_id;
	}

	public void setTipo_id(String tipo_id) {
		this.tipo_id = tipo_id;
	}

	public int getN_id() {
		return n_id;
	}

	public void setN_id(int n_id) {
		this.n_id = n_id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getN_contacto() {
		return n_contacto;
	}

	public void setN_contacto(String n_contacto) {
		this.n_contacto = n_contacto;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
