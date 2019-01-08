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
	private JavaBank_Cartao_Debito cartao;
	
	public JavaBank_Conta_Ordem(int n_conta, String data_criacao, double saldo,  String estado, JavaBank_Cartao_Debito cartao) {
		super(n_conta, data_criacao, saldo, estado);
		this.limite_diario = 200.00;
		this.limite_levantamento = 1000.00;
		this.cartao = cartao;
	}
	
	

	public JavaBank_Conta_Ordem(int n_conta, String data_criacao, double saldo, String estado) {
		super(n_conta, data_criacao, saldo, estado);
		this.limite_diario = 200.00;
		this.limite_levantamento = 1000.00;
	}



	public void setCartao(JavaBank_Cartao_Debito cartao) {
		this.cartao = cartao;
	}

	public JavaBank_Cartao_Debito getCartao() {
		return cartao;
	}
}
