import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

/**
 * Breve descrição do código
 *
 * @sid 2002
 * @aid 1.1
 */
public class Window_JavaBank_TransferenciaInterna extends JFrame {

	private JPanel contentPane;
	private JTextField txtDestino;
	private JTextField txtMontante;
	private int dest;
	private double mont;
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
			mont = Double.parseDouble(montanteInput);
			double saldoOrigem = 0.0;
			double saldoDestino = 0.0;
			for (JavaBank_Conta c : gestao.getContas()) {
				if (c.getN_conta() == aux) {
					saldoOrigem = c.getSaldo();
					saldoOrigem -= mont;
					c.setSaldo(saldoOrigem);
					gestao.movimento(montanteInput, aux, "Transferência para " + destinoInput);
				}
				if (c.getN_conta() == dest) {
					saldoDestino = c.getSaldo();
					saldoDestino += mont;
					c.setSaldo(saldoDestino);
					gestao.movimento(montanteInput, dest, "Transferência de " + aux);
				}
			}
			JOptionPane.showMessageDialog(getParent(), "Operação efectuada com sucesso.");
		}
	}

}
