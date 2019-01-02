/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class JavaBank_Conta_Poupanca extends JavaBank_Conta {
	
	private double juros;
	private double limite_mensal;
	
	public JavaBank_Conta_Poupanca(int n_conta, String data_criacao, double saldo, String estado) {
		super(n_conta, data_criacao, saldo, estado);
		this.juros = 6;
		this.limite_mensal = 1000.00;
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
		this.limite_mensal = limite_mensal;
	}
	
}
