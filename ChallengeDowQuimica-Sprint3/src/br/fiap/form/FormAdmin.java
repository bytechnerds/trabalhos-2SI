package br.fiap.form;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;

import javax.swing.JOptionPane;

import br.fiap.dao.SessaoDAO;
import br.fiap.dao.UsuarioDAO;
import br.fiap.entidade.Sessao;
import br.fiap.entidade.Usuario;

public class FormAdmin {
	public static void menu() {
		int op;

		do {
			op = parseInt(showInputDialog(gerarMenu()));
			switch (op) {
			case 1:
				consultarUsuario();
				break;
			case 2:
				consultarSessao();
				break;
			case 3:
				consultarDeficiencias();
				break;
			case 4:
				consultarNavegadores();
				break;
			default:
				break;
			}
		} while (op != 5);
	}

	public static String gerarMenu() {
		String aux = "Escolha uma opera��o \n";
		aux += "1. Consultar Usu�rio\n";
		aux += "2. Consultar Sess�o\n";
		aux += "3. Estatisticas - Defici�ncias\n";
		aux += "4. Estat�sticas - Navegadores\n";
		aux += "5. Sair\n";

		return aux;
	}

	private static void consultarUsuario() {
		UsuarioDAO usuario = new UsuarioDAO();
		String saida = "";

		int id_usuario = parseInt(showInputDialog("ID DO USU�RIO:"));

		try {
			Usuario u = usuario.consultarPorId(id_usuario);
			saida += "ID: 				 " + u.getId_usuario() + "\n";
			saida += "NOME:  			 " + u.getNome() + "\n";
			saida += "EMAIL: 			 " + u.getEmail() + "\n";
			saida += "NAVEGADOR PADR�O:  " + u.getNavegador() + "\n";
			saida += "DEFICIENCIA: 		 " + u.getDeficiencia_visual() + "\n";
			showMessageDialog(null, saida);
		} catch (NullPointerException e) {
			System.out.println("N�o foi poss�vel consultar" + e);
			showMessageDialog(null, "Usu�rio n�o cadastrado");
		}
	}

	private static void consultarSessao() {
		SessaoDAO sessao = new SessaoDAO();
		String saida = "";

		int id_sessao = parseInt(showInputDialog("ID DA SESS�O: "));
		Sessao s = sessao.consultar(id_sessao);
		int duracao = s.getDuracao();
		
		saida += "ID: 				 " + id_sessao + "\n";
		saida += "ID DA P�GINA ACESSADA:	 "+  s.getId_site()+"\n";
		saida += "DATA DE ACESSO: 	 " + s.getData_acesso() + "\n";
		saida += "DURA��O: 			 " + s.getDuracaoFormatada(duracao)+ "\n";
		saida += "FUN��ES: 			 " + s.getFuncoes();
		showMessageDialog(null, saida);
	}

	private static void consultarDeficiencias() {
		UsuarioDAO usuario = new UsuarioDAO();
		String saida = "";

		String deficiencia = "";
		String[] deficiencias = { "Cegueira", "Baixa Vis�o", "Daltonismo" };
		int nav = JOptionPane.showOptionDialog(null, "Selecione uma defici�ncia para exibir estat�sticas: ",
				"Consultar Estat�sticas", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
				deficiencias, 0);
		switch (nav) {
		case 0:
			deficiencia = "CEGUEIRA";
			break;
		case 1:
			deficiencia = "BAIXAVISAO";
			break;
		case 2:
			deficiencia = "DALTONISMO";
			break;
		}

		int total = usuario.contarDeficiencia(deficiencia);
		saida += "TOTAL DE USU�RIOS COM A DEFICI�NCIA " + deficiencia + ":\n" + total;

		showMessageDialog(null, saida);
	}

	private static void consultarNavegadores() {
		UsuarioDAO usuario = new UsuarioDAO();
		String saida = "";

		String navegador = "";
		String[] navegadores = { "Chrome", "Firefox", "Edge", "Opera", "Safari", "Brave", "Internet Explorer" };

		int nav = JOptionPane.showOptionDialog(null, "Escolha uma op��o:", "Cadastro de Usu�rio",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, navegadores, 0);
		switch (nav) {
		case 0:
			navegador = "CHROME";
			break;
		case 1:
			navegador = "FIREFOX";
			break;
		case 2:
			navegador = "EDGE";
			break;
		case 3:
			navegador = "OPERA";
			break;
		case 4:
			navegador = "SAFARI";
			break;
		case 5:
			navegador = "BRAVE";
			break;
		case 6:
			navegador = "INTERNETEXPLORER";
			break;
		}

		int total = usuario.contarNavegador(navegador);
		saida += "TOTAL DE USU�RIOS COM O NAVEGADOR "+navegador+" COMO PADR�O:\n" + total;

		showMessageDialog(null, saida);

	}
}
