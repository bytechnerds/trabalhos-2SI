package br.fiap.form;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import javax.swing.JOptionPane;
import br.fiap.dao.UsuarioDAO;
import br.fiap.entidade.TipoDeficiencia;
import br.fiap.entidade.TipoNavegador;
import br.fiap.entidade.Usuario;

public class FormUsuario {
	public static void menu(int id) {

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
		aux += "1. Iniciar Sessão\n";
		aux += "2. Iniciar Navegação\n";
		aux += "3. Sair\n";

		return aux;
	}

	public static void cadastroUsuario() {
		String[] deficiencias = { "Cegueira", "Baixa Visão", "Daltonismo" };
		String[] navegadores = { "Chrome", "Firefox", "Edge", "Opera", "Safari", "Brave", "Internet Explorer" };
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario u = new Usuario(0, null, null, null, null, null);
		TipoNavegador navegador;
		TipoDeficiencia deficiencia_visual;

		String nome = showInputDialog("NOME:");
		String email = showInputDialog("EMAIL:");
		String senha = showInputDialog("SENHA:");
		int nav = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastro de Usuário",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, deficiencias, 0);
		switch (nav) {
		case 1:
			navegador = TipoNavegador.CHROME;
			break;
		case 2:
			navegador = TipoNavegador.FIREFOX;
			break;
		case 3:
			navegador = TipoNavegador.EDGE;
			break;
		case 4:
			navegador = TipoNavegador.OPERA;
			break;
		case 5:
			navegador = TipoNavegador.SAFARI;
			break;
		case 6:
			navegador = TipoNavegador.BRAVE;
			break;
		default:
			navegador = TipoNavegador.INTERNETEXPLORER;
		}
		int def = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastro de Usuário",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, navegadores, 0);
		switch (def) {
		case 1:
			deficiencia_visual = TipoDeficiencia.CEGUEIRA;
			break;
		case 2:
			deficiencia_visual = TipoDeficiencia.BAIXAVISAO;
			break;
		default:
			deficiencia_visual = TipoDeficiencia.DALTONISMO;
		}

		int id = u.gerarId_usuario();
		u.setId_usuario(id);
		u.setNome(nome);
		u.setEmail(email);
		u.setSenha(senha);
		u.setNavegador(navegador);
		u.setDeficiencia_visual(deficiencia_visual);

		usuarioDao.cadastrarUsuario(u);
	}
}
