/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class JavaBank_Conta_Ordem extends JavaBank_Conta {
	
	public static double limite_diario;
	public static double limite_levantamento;
	private JavaBank_Cartao_Debito cartao;
	
	public JavaBank_Conta_Ordem(int n_conta, String data_criacao, double saldo,  String estado, JavaBank_Cartao_Debito cartao) {
		super(n_conta, data_criacao, saldo, estado);
		JavaBank_Conta_Ordem.limite_diario = 1000.00;
		JavaBank_Conta_Ordem.limite_levantamento = 200.00;
		this.cartao = cartao;
	}
	
	public JavaBank_Conta_Ordem(int n_conta, String data_criacao, double saldo, String estado) {
		super(n_conta, data_criacao, saldo, estado);
		JavaBank_Conta_Ordem.limite_diario = 1000.00;
		JavaBank_Conta_Ordem.limite_levantamento = 200.00;
	}

	public JavaBank_Conta_Ordem() {
		// TODO Auto-generated constructor stub
	}

	public void setCartao(JavaBank_Cartao_Debito cartao) {
		this.cartao = cartao;
	}

	public JavaBank_Cartao_Debito getCartao() {
		return cartao;
	}
	
	public double getLimite_levantamento() {
		return limite_levantamento;
	}

	public double getLimite_diario() {
		return limite_diario;
	}
}
