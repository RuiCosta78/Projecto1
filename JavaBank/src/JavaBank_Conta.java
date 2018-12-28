import java.util.ArrayList;

/**
 * Breve descrição do código
 *
 * @sid 2002
 * @aid 1.1
 */
public class JavaBank_Conta {

	protected int n_conta;
	protected String data_criacao;
	protected double saldo;
	protected ArrayList<JavaBank_Movimento> historico_movimentos = new ArrayList<>();
	protected String estado;
	
	public JavaBank_Conta(int n_conta, String data_criacao, double saldo,
			ArrayList<JavaBank_Movimento> historico_movimentos, String estado) {
		super();
		this.n_conta = n_conta;
		this.data_criacao = data_criacao;
		this.saldo = saldo;
		this.historico_movimentos = historico_movimentos;
		this.estado = estado;
	}

	public int getN_conta() {
		return n_conta;
	}

	public ArrayList<JavaBank_Movimento> getHistorico_movimentos() {
		return historico_movimentos;
	}

	public void setHistorico_movimentos(ArrayList<JavaBank_Movimento> historico_movimentos) {
		this.historico_movimentos = historico_movimentos;
	}
	
}
