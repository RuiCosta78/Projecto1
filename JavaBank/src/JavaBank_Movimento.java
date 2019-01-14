import java.io.Serializable;

/**Classe para o objecto Movimento
 * 
 * @author Acer
 *
 */
public class JavaBank_Movimento implements Serializable{
	
	protected String data_movimento;
	protected String tipo_movimento;
	protected double quantia;
	protected double saldoInst;
	protected int id_funcionario;
	protected int id_cliente;
	
	/**
	 * @param data_movimento data do movimento
	 * @param tipo_movimento tipo de movimento (Depósito/Levantamento/Compra/Transferência)
	 * @param quantia quantia do movimento
	 * @param id_funcionario identificação do funcionário que registou o movimento
	 * @param id_cliente identificação do cliente que solicitou o movimento
	 * @param saldoInst saldo instantâneo para cálculo do saldo final
	 */
	public JavaBank_Movimento(String data_movimento, String tipo_movimento, double quantia, int id_funcionario,
			int id_cliente, double saldoInst) {
		super();
		this.data_movimento = data_movimento;
		this.tipo_movimento = tipo_movimento;
		this.quantia = quantia;
		this.id_funcionario = id_funcionario;
		this.id_cliente = id_cliente;
		this.saldoInst = saldoInst;
	}

	public JavaBank_Movimento(String data_movimento, String tipo_movimento, double quantia, int id_cliente, double saldoInst) {
		super();
		this.data_movimento = data_movimento;
		this.tipo_movimento = tipo_movimento;
		this.quantia = quantia;
		this.id_cliente = id_cliente;
		this.saldoInst = saldoInst;
	}
	
	public double getSaldoInst() {
		return saldoInst;
	}

	public void setSaldoInst(double saldoInst) {
		this.saldoInst = saldoInst;
	}

	public String getData_movimento() {
		return data_movimento;
	}

	public void setData_movimento(String data_movimento) {
		this.data_movimento = data_movimento;
	}

	public String getTipo_movimento() {
		return tipo_movimento;
	}

	public void setTipo_movimento(String tipo_movimento) {
		this.tipo_movimento = tipo_movimento;
	}

	public double getQuantia() {
		return quantia;
	}

	public void setQuantia(double quantia) {
		this.quantia = quantia;
	}

	public int getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	
}
