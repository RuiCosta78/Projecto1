import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Breve descri��o do c�digo
 *
 * @sid 2002
 * @aid 1.1
 */
public class VCI_cl_Principal {

	public static void main(String[] args) throws IOException {

		VCI_cl_Gestao g = new VCI_cl_Gestao();
		//g.gravarUtilizadores();
		//g.ficheiroLv();
		//Teste t = new Teste();
		
		// Serializa��o dos ficheiros.
		/*FileOutputStream fileOut = new FileOutputStream("Lista de Utilizadores.dat");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(g);
		out.close();
		fileOut.close();
		System.out.println("Ficheiro de dados serializado.");
		
		ArrayList<VCI_cl_Utilizador> novo= new ArrayList<VCI_cl_Utilizador>();
		try {
			File f = new File("Lista de Utilizadores.dat");
			if (f.exists()) {
				FileInputStream ficheiro = new FileInputStream("Lista de Utilizadores.dat");
				ObjectInputStream in = new ObjectInputStream(ficheiro);
				novo = (ArrayList<VCI_cl_Utilizador>) in.readObject();
				in.close();
				ficheiro.close();
			}
		} catch (Exception e) {
			System.out.println("Ficheiro n�o encontrado " + e);
		}
		
		String s = "Lista de Utilizadores";
		g.abrirListaUtilizadores(s);
		for (VCI_cl_Utilizador u: g.getListaUtilizadores()) {
			System.out.println(u.getNome());
		}*/
	}
}
