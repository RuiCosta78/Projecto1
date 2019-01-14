import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**   
 * Breve descrição do código
 *  
 * @sid 2001
 * @aid 1.1   
 */

/**
 * @author rmmi7
 *
 */
public class VCI_cl_Historico implements Serializable {

	private String isbn;
	private ArrayList<GregorianCalendar> datas = new ArrayList<GregorianCalendar>();
	private ArrayList<Double> precos = new ArrayList<Double>();
	
	public VCI_cl_Historico() {
		
	}

	/**
	 * @param isbn ISBN de um livro.
	 * @param datas lista das datas de mudança de preço.
	 * @param precos lista dos preços para cada data.
	 */
	public VCI_cl_Historico(String isbn, ArrayList<GregorianCalendar> datas, ArrayList<Double> precos) {
		super();
		this.isbn = isbn;
		this.datas = datas;
		this.precos = precos;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public ArrayList<GregorianCalendar> getDatas() {
		return datas;
	}

	public void setDatas(ArrayList<GregorianCalendar> datas) {
		this.datas = datas;
	}

	public ArrayList<Double> getPrecos() {
		return precos;
	}

	public void setPrecos(ArrayList<Double> precos) {
		this.precos = precos;
	}

	@Override
	public String toString() {
		return "VCI_cl_Historico [isbn=" + isbn + ", datas=" + datas + ", precos=" + precos + "]";
	}
		
}
