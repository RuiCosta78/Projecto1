import java.io.Serializable;


/**Classe para o objecto Conta Poupança
 * 
 * @author Rui Costa
 *
 */
public class JavaBank_Conta_Poupanca extends JavaBank_Conta implements Serializable{
	
	private double juros;
	public static double limite_mensal;
	
	/**
	 * @param n_conta nº da conta
	 * @param data_criacao data de criação da conta
	 * @param saldo saldo da conta
	 * @param estado estado da conta (Activa/Inactiva)
	 */
	public JavaBank_Conta_Poupanca(int n_conta, String data_criacao, double saldo, String estado) {
		super(n_conta, data_criacao, saldo, estado);
		this.juros = 2;//taxa de juros anual da conta em percentagem
		JavaBank_Conta_Poupanca.limite_mensal = 1000.00;//limita para a soma de levantamntos para um determinado mês
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

	public double getLimite_mensal() {
		return limite_mensal;
	}

	public void setLimite_mensal(double limite_mensal) {
		JavaBank_Conta_Poupanca.limite_mensal = limite_mensal;
	}
	
}
