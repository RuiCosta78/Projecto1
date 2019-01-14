import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**JPanel para a confirmação de transferência
 * 
 * @author Rui Costa
 *
 */
public class Window_JavaBank_TransferenciaInterna extends JFrame {

	private JPanel contentPane;
	private JTextField txtDestino;
	private JTextField txtMontante;
	private int dest;
	private JFrame frame;
	private int aux;
	private JavaBank_Gestao gestao;

	public Window_JavaBank_TransferenciaInterna(JavaBank_Gestao gestao, int aux) throws HeadlessException {
		super();
		this.gestao = gestao;
		this.aux = aux;
		initialize();
	}

	public void initialize() {
		frame = new JFrame("Transferência Interna");

		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0, 2, 2, 2));
		frame.getContentPane().add(contentPane);

		txtDestino = new JTextField(5);
		txtMontante = new JTextField(5);

		JLabel lblDestino = new JLabel("Nº da conta destino:");
		lblDestino.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblDestino);
		contentPane.add(txtDestino);

		JLabel lblMontante = new JLabel("Montante:");
		lblMontante.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(lblMontante);
		contentPane.add(txtMontante);

		Object[] opcoes = { "Confirmar", "Cancelar" };
		int opcao = JOptionPane.showOptionDialog(this, contentPane, "Transferência Interna",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[1]);

		if (opcao == JOptionPane.OK_OPTION) {
			String destinoInput = txtDestino.getText();
			String montanteInput = txtMontante.getText();
			dest = Integer.parseInt(destinoInput);
			for (JavaBank_Conta c : gestao.getContas()) {
				if (c.getN_conta() == aux) {
					try {
						gestao.movimento(montanteInput, aux, "Transferência para " + destinoInput);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (c.getN_conta() == dest) {
					try {
						gestao.movimento(montanteInput, dest, "Transferência de " + aux);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			JOptionPane.showMessageDialog(getParent(), "Operação efectuada com sucesso.");
		}
	}

}
