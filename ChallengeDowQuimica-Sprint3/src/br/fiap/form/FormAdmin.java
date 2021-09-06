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
		String aux = "Escolha uma operação \n";
		aux += "1. Consultar Usuário\n";
		aux += "2. Consultar Sessão\n";
		aux += "3. Estatisticas - Deficiências\n";
		aux += "4. Estatísticas - Funções\n";
		aux += "5. Sair\n";

		return aux;
	}
}
