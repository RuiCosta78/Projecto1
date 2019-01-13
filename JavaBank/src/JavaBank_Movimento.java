import java.io.Serializable;

/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class JavaBank_Movimento implements Serializable{
	
	protected String data_movimento;
	protected String tipo_movimento;
	protected double quantia;
	protected double saldoInst;
	protected int id_funcionario;
	protected int id_cliente;
	
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
