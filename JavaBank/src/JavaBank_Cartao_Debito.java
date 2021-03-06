import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;


/**Classe para o objecto Cart�o de D�bito
 * @author Rui Costa
 *
 */
public class JavaBank_Cartao_Debito implements Serializable {

	protected String nome_titular;
	protected String numero;
	protected String data_vencimento;
	protected String codigo_verificacao;

	/**
	 * @param nome_titular titular do cart�o
	 * @param numero n� do cart�o
	 */
	public JavaBank_Cartao_Debito(String nome_titular, String numero) {
		super();
		Calendar cal = Calendar.getInstance();
		this.nome_titular = nome_titular;
		this.numero = numero;
		this.data_vencimento = String.valueOf(cal.get(Calendar.MONTH) + 1) + "/"
				+ String.valueOf(cal.get(Calendar.YEAR) + 5);//data de vencimento do cart�o (validade de 5 anos)
		Random r = new Random();
		int cinf = 0;
		int csup = 1000;
		this.codigo_verificacao = String.format("%03d", r.nextInt(csup - cinf) + cinf);// c�digo de verifica��o de 3
																						// d�gitos gerado
																						// automaticamente
	}

	public JavaBank_Cartao_Debito(String nome_titular, String numero, String data_vencimento, String codigo_verificacao) {
		super();
		this.nome_titular = nome_titular;
		this.numero = numero;
		this.data_vencimento = data_vencimento;
		this.codigo_verificacao = codigo_verificacao;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getData_vencimento() {
		return data_vencimento;
	}

	public void setData_vencimento(String data_vencimento) {
		this.data_vencimento = data_vencimento;
	}

	public String getCodigo_verificacao() {
		return codigo_verificacao;
	}

	public void setCodigo_verificacao(String codigo_verificacao) {
		this.codigo_verificacao = codigo_verificacao;
	}

}
