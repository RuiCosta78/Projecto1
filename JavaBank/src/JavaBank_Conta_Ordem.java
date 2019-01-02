import java.util.ArrayList;

/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class JavaBank_Conta_Ordem extends JavaBank_Conta {
	
	private double limite_diario;
	private double limite_levantamento;
	
	public JavaBank_Conta_Ordem(int n_conta, String data_criacao, double saldo,  String estado) {
		super(n_conta, data_criacao, saldo, estado);
		this.limite_diario = 200.00;
		this.limite_levantamento = 1000.00;
	}

	
}
