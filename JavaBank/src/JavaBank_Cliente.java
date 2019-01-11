import java.io.Serializable;

/**
 * Breve descrição do código
 *
 * @sid 2002
 * @aid 1.1
 */
public class JavaBank_Cliente extends JavaBank_Utilizador implements Serializable {

	private String nif;
	private JavaBank_Conta conta;

	public JavaBank_Cliente(String primeiro_nome, String sobrenome, String data_nascimento, String tipo_id,
			int n_id, String endereco, String n_contacto, String login, String password, String nif) {
		super(primeiro_nome, sobrenome, data_nascimento, tipo_id, n_id, endereco, n_contacto, login, password);
		this.nif = nif;
	}

	public JavaBank_Cliente(String primeiro_nome, String sobrenome, String data_nascimento, String tipo_id, int n_id,
			String endereco, String n_contacto, String login, String password, String nif, JavaBank_Conta conta) {
		super(primeiro_nome, sobrenome, data_nascimento, tipo_id, n_id, endereco, n_contacto, login, password);
		this.nif = nif;
		this.conta = conta;
	}
	
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public JavaBank_Conta getConta() {
		return conta;
	}

	public void setConta(JavaBank_Conta conta) {
		this.conta = conta;
	}

}
