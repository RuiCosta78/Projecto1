import java.util.ArrayList;

/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class JavaBank_Conta_Poupanca extends JavaBank_Conta {
	
	private double juros;
	private double limite_mensal;
	
	public JavaBank_Conta_Poupanca(int n_conta, String data_criacao, double saldo,
			ArrayList<JavaBank_Movimento> historico_movimentos, String estado) {
		super(n_conta, data_criacao, saldo, historico_movimentos, estado);
		this.juros = 0.06;
		this.limite_mensal = 1000.00;
	}
	
}
