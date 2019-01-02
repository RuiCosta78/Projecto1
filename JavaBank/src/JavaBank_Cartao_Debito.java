/**
* Breve descri��o do c�digo
*
* @sid 2002
* @aid 1.1
*/
public class JavaBank_Cartao_Debito {
	
	protected String nome_titular;
	protected int numero;
	protected String data_vencimento;
	protected int codigo_verificacao;
	
	public JavaBank_Cartao_Debito(String nome_titular, int numero, String data_vencimento, int codigo_verificacao) {
		super();
		this.nome_titular = nome_titular;
		this.numero = numero;
		this.data_vencimento = data_vencimento;
		this.codigo_verificacao = codigo_verificacao;
	}
	
	public JavaBank_Cartao_Debito(String nome_titular, int numero) {
		super();
		this.nome_titular = nome_titular;
		this.numero = numero;
	}

	public JavaBank_Cartao_Debito(String nome_titular) {
		super();
		this.nome_titular = nome_titular;
	}

	public JavaBank_Cartao_Debito() {
		super();
	}

	public String getNome_titular() {
		return nome_titular;
	}

	public void setNome_titular(String nome_titular) {
		this.nome_titular = nome_titular;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getData_vencimento() {
		return data_vencimento;
	}

	public void setData_vencimento(String data_vencimento) {
		this.data_vencimento = data_vencimento;
	}

	public int getCodigo_verificacao() {
		return codigo_verificacao;
	}

	public void setCodigo_verificacao(int codigo_verificacao) {
		this.codigo_verificacao = codigo_verificacao;
	}

}
