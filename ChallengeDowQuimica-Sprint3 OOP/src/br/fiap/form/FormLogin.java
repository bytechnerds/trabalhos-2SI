package br.fiap.form;

import static javax.swing.JOptionPane.*;

import br.fiap.dao.UsuarioDAO;

import static java.lang.Integer.parseInt;

public class FormLogin {

	public static void menu() {
		int op;
		int id;
		UsuarioDAO dao = new UsuarioDAO();
		do {
			op = parseInt(showInputDialog("1. Administrador Awave \n2. Usuário Awave\n3. Sair"));
			switch (op) {
			case 1:
				FormAdmin.menu();
				break;
			case 2:
				int op2;
				op2 = parseInt(showInputDialog("1. Cadastrar Novo Usuário \n 2. Fazer Login\n 3.Sair"));
				switch (op2) {
				case 1:
					FormUsuario.cadastroUsuario();
					break;
				case 2:
					id = parseInt(showInputDialog("Id de Usuário"));
					if (dao.consultarCadastro(id)) {
						FormUsuario.menu(id);
					} else {
						showMessageDialog(null, "Usuário não cadastrado");
					}
					break;
				default:
					break;
				}
			}
		} while (op != 3);
	}
}
