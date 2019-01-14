import java.io.Serializable;
import java.util.ArrayList;


/**Classe para o utlizador Cliente
 * 
 * @author Rui Costa
 *
 */
public class JavaBank_Cliente extends JavaBank_Utilizador implements Serializable {

	private String nif;
	private ArrayList<JavaBank_Conta> contas_associadas = new ArrayList<>();

	/**
	 * @param primeiro_nome primeiro nome do utilizador
	 * @param sobrenome sobrenome do utilizador
	 * @param data_nascimento data de nascimento do utilizador
	 * @param tipo_id tipo de documento de identificação
	 * @param n_id nº do documento identificativo
	 * @param endereco morada de reisdência do utilizador
	 * @param n_contacto contacto telefónico do utilizador
	 * @param login emais do utilizador
	 * @param password password do utilizador
	 * @param nif NIF do utilizador
	 */
	public JavaBank_Cliente(String primeiro_nome, String sobrenome, String data_nascimento, String tipo_id,
			int n_id, String endereco, String n_contacto, String login, String password, String nif) {
		super(primeiro_nome, sobrenome, data_nascimento, tipo_id, n_id, endereco, n_contacto, login, password);
		this.nif = nif;
	}

	public JavaBank_Cliente(String primeiro_nome, String sobrenome, String data_nascimento, String tipo_id, int n_id,
			String endereco, String n_contacto, String login, String password, String nif, ArrayList<JavaBank_Conta> contas_associadas) {
		super(primeiro_nome, sobrenome, data_nascimento, tipo_id, n_id, endereco, n_contacto, login, password);
		this.nif = nif;
		this.contas_associadas = contas_associadas;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public ArrayList<JavaBank_Conta> getContas_associadas() {
		return contas_associadas;
	}

	public void setContas_associadas(ArrayList<JavaBank_Conta> contas_associadas) {
		this.contas_associadas = contas_associadas;
	}

}
