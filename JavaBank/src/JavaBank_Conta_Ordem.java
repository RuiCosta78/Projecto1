import java.io.Serializable;
import java.util.ArrayList;


/**Classe para o objecto Conta à Ordem
 * 
 * @author Rui Costa
 *
 */
public class JavaBank_Conta_Ordem extends JavaBank_Conta implements Serializable{
	
	public static double limite_diario;
	public static double limite_levantamento;
	private ArrayList<JavaBank_Cartao_Debito> cartoes_associados = new ArrayList<>();
	
	/**
	 * @param n_conta nº da conta
	 * @param data_criacao data de criação da conta
	 * @param saldo saldo da conta
	 * @param estado estado da conta (Activa/Inactiva)
	 * @param cartoes_associados lista de cartões de débito associados à conta
	 */
	public JavaBank_Conta_Ordem(int n_conta, String data_criacao, double saldo,  String estado, ArrayList<JavaBank_Cartao_Debito> cartoes_associados) {
		super(n_conta, data_criacao, saldo, estado);
		this.limite_diario = 1000.00;//limite da soma dos levantamentos para um determinado dia
		this.limite_levantamento = 200.00;//limite para um levantamento isolado
		this.cartoes_associados = cartoes_associados;
	}
	
	public JavaBank_Conta_Ordem(int n_conta, String data_criacao, double saldo, String estado) {
		super(n_conta, data_criacao, saldo, estado);
		this.limite_diario = 1000.00;
		this.limite_levantamento = 200.00;
	}

	public JavaBank_Conta_Ordem() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<JavaBank_Cartao_Debito> getCartoes_associados() {
		return cartoes_associados;
	}

	public void setCartoes_associados(ArrayList<JavaBank_Cartao_Debito> cartoes_associados) {
		this.cartoes_associados = cartoes_associados;
	}

	public double getLimite_levantamento() {
		return limite_levantamento;
	}

	public double getLimite_diario() {
		return limite_diario;
	}
}
