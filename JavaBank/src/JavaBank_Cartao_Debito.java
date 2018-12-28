/**
* Breve descrição do código
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

}
