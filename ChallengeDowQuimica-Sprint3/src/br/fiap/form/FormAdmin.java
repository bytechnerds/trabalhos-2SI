package br.fiap.form;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;

public class FormAdmin {
	public static void menu() {
		int op;

		do {
			op = parseInt(showInputDialog(gerarMenu()));
			switch (op) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			}
		} while (op != 4);
	}

	public static String gerarMenu() {
		String aux = "Escolha uma opera��o \n";
		aux += "1. Consultar Usu�rio\n";
		aux += "2. Consultar Sess�o\n";
		aux += "3. Estatisticas - Defici�ncias\n";
		aux += "4. Estat�sticas - Fun��es\n";
		aux += "5. Sair\n";

		return aux;
	}
}
