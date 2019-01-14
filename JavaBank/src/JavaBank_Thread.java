import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**Classe para utilização de Threads
 * 
 * @author Rui Costa
 *
 */
public class JavaBank_Thread {

<<<<<<< HEAD
	JavaBank_Thread(){
		
	}
	
	public static void thread() {
=======
	/**
	 * @throws IOException
	 */
	public static void thread() throws IOException {
>>>>>>> branch 'master' of https://github.com/RuiCosta78/Projecto1
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				show();
			}
		});
		t1.start();
		show();
		gravarResposta();
	}

	/**
	 * @return
	 */
	public static String[] show() {
		int counter = 1000;
		JavaBank_Gestao gestao = new JavaBank_Gestao();
		String resp = "";
		String[] dados = new String[2];
		String[] resposta = new String[1];
		while (counter-- > 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				dados = abrirPedido();
				int aux = 0;
				for (JavaBank_Conta c : gestao.contas) {
					if (c instanceof JavaBank_Conta_Ordem) {
						for (JavaBank_Cartao_Debito car : ((JavaBank_Conta_Ordem) c).getCartoes_associados()) {
							if (car.getNumero() == dados[0]) {
								aux = c.n_conta;
								if (c.getEstado().equals("Inactiva")) {
									resposta[0] = "inativo";
								}
							} else {
								resposta[0] = "errado";
							}
						}
					}
				}
				resp = gestao.movimento(dados[1], aux, "Compra");
				if (resp.equals("Saldo insuficiente.")) {
					resposta[0] = "sem saldo";
				} else if (resp.equals("Operação efectuada com sucesso.")) {
					resposta[0] = "sucesso";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resposta;
	}

	/**Gravação da lista de contas
	 * 
	 * @throws IOException
	 */
	public static void gravarResposta() throws IOException {
		File f = new File("resposta.dat");
		FileOutputStream fileOut = new FileOutputStream(f);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		String[] resposta = show();
		out.writeObject(resposta);
		out.close();
		fileOut.close();
	}

	/**
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static String[] abrirPedido() throws IOException {
		String[] dados = new String[2];
		try {
			File f = new File("pedido.dat");
			if (f.exists()) {
				FileInputStream ficheiro = new FileInputStream(f);
				ObjectInputStream in = new ObjectInputStream(ficheiro);
				dados = (String[]) in.readObject();
				in.close();
				ficheiro.close();
			}
		} catch (Exception e) {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Ficheiro de contas não encontrado.");
		}
		return dados;
	}

}
