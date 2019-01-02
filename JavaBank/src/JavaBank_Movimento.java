/**
* Breve descrição do código
*
* @sid 2002
* @aid 1.1
*/
public class JavaBank_Movimento {
	
	protected String data_movimento;
	protected String tipo_movimento;
	protected double quantia;
	protected int id_funcionario;
	protected int id_cliente;
	
	public JavaBank_Movimento(String data_movimento, String tipo_movimento, double quantia, int id_funcionario,
			int id_cliente) {
		super();
		this.data_movimento = data_movimento;
		this.tipo_movimento = tipo_movimento;
		this.quantia = quantia;
		this.id_funcionario = id_funcionario;
		this.id_cliente = id_cliente;
	}
	
}
