/**
 * Breve descrição do código
 *
 * @sid 2002
 * @aid 1.1
 */
public class JavaBank_Cliente extends JavaBank_Utilizador {

	private String nif;
	private int n_conta;

	public JavaBank_Cliente(String primeiro_nome, String sobrenome, String data_nascimento, String tipo_id,
			int n_id, String endereco, String n_contacto, String login, String password, String nif) {
		super(primeiro_nome, sobrenome, data_nascimento, tipo_id, n_id, endereco, n_contacto, login, password);
		this.nif = nif;
	}

	public JavaBank_Cliente(String primeiro_nome, String sobrenome, String data_nascimento, String tipo_id, int n_id,
			String endereco, String n_contacto, String login, String password, String nif, int n_conta) {
		super(primeiro_nome, sobrenome, data_nascimento, tipo_id, n_id, endereco, n_contacto, login, password);
		this.nif = nif;
		this.n_conta = n_conta;
	}
	
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public int getN_conta() {
		return n_conta;
	}

	public void setN_conta(int n_conta) {
		this.n_conta = n_conta;
	}

}
