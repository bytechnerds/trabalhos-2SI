package br.fiap.form;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.showOptionDialog;

import javax.swing.JOptionPane;

import br.fiap.dao.SessaoDAO;
import br.fiap.dao.SiteDAO;
import br.fiap.dao.UsuarioDAO;
import br.fiap.entidade.Sessao;
import br.fiap.entidade.Site;
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
				iniciarSessao(id);
				break;
			case 2:
				alterarCadastro(id);
				break;
			default:
				break;
			}
		} while (op != 3);
	}

	public static String gerarMenu() {
		String aux = "Escolha uma operação \n";
		aux += "1. Iniciar Sessão\n";
		aux += "2. Alterar Cadastro\n";
		aux += "3. Sair\n";

		return aux;
	}

	public static void cadastroUsuario() {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario u = new Usuario(0, null, null, null, null, null);

		String[] deficiencias = { "Cegueira", "Baixa Visão", "Daltonismo" };
		String[] navegadores = { "Chrome", "Firefox", "Edge", "Opera", "Safari", "Brave", "Internet Explorer" };
		TipoNavegador navegador;
		TipoDeficiencia deficiencia_visual;

		String nome = showInputDialog("NOME:");
		String email = showInputDialog("EMAIL:");
		String senha = showInputDialog("SENHA:");
		int nav = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastro de Usuário",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, navegadores, 0);
		switch (nav) {
		case 0:
			navegador = TipoNavegador.CHROME;
			u.setNavegador(navegador);
			break;
		case 1:
			navegador = TipoNavegador.FIREFOX;
			u.setNavegador(navegador);
			break;
		case 2:
			navegador = TipoNavegador.EDGE;
			u.setNavegador(navegador);
			break;
		case 3:
			navegador = TipoNavegador.OPERA;
			u.setNavegador(navegador);
			break;
		case 4:
			navegador = TipoNavegador.SAFARI;
			u.setNavegador(navegador);
			break;
		case 5:
			navegador = TipoNavegador.BRAVE;
			u.setNavegador(navegador);
			break;
		case 6:
			navegador = TipoNavegador.INTERNETEXPLORER;
			u.setNavegador(navegador);
			break;
		}

		int def = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastro de Usuário",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, deficiencias, 0);
		switch (def) {
		case 0:
			deficiencia_visual = TipoDeficiencia.CEGUEIRA;
			u.setDeficiencia_visual(deficiencia_visual);
			break;
		case 1:
			deficiencia_visual = TipoDeficiencia.BAIXAVISAO;
			u.setDeficiencia_visual(deficiencia_visual);
			break;
		case 2:
			deficiencia_visual = TipoDeficiencia.DALTONISMO;
			u.setDeficiencia_visual(deficiencia_visual);
			break;
		}

		u.setId_usuario();
		u.setNome(nome);
		u.setEmail(email);
		u.setSenha(senha);

		showMessageDialog(null, "ID DO USUÁRIO CADASTRADO\n" + u.getId_usuario());
		usuarioDao.cadastrarUsuario(u);
	}

	private static void iniciarSessao(int id) {
		UsuarioDAO usuario = new UsuarioDAO();
		Usuario u = new Usuario(id, null, null, null, null, null);

		SessaoDAO sessao = new SessaoDAO();
		Sessao s = new Sessao(0, null, 0, null, 0, 0);

		SiteDAO site = new SiteDAO();
		Site page = new Site(0, null, 0);

		int cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0, cont5 = 0, cont6 = 0, cont7 = 0;
		int cont = 0;

		String uri = showInputDialog("Informe a url da página que deseja acessar:");
		page.setId_site();
		page.setUri(uri);
		page.setNumero_de_acessos(cont++);

		site.inserirSite(page);

		String[] funcoes = { "Descrever", "Narrar", "Navegar - Blocos", "Navegar - Botões", "Navegar - Mídias",
				"Navegar - Imagens", "Navegar - Entrada de Dados", "Encerrar Navegação" };

		s.setId_sessao();
		int id_sessao = s.getId_sessao();
		showMessageDialog(null, "ID DA SESSÃO\n" + id_sessao);

		int func;
		do {
			func = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Cadastro de Usuário",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, funcoes, 0);
			switch (func) {
			case 0:
				cont1++;
				break;
			case 1:
				cont2++;
				break;
			case 2:
				cont3++;
				break;
			case 3:
				cont5++;
				break;
			case 4:
				cont5++;
				break;
			case 5:
				cont6++;
				break;
			case 6:
				cont7++;
				break;
			default:
				break;
			}
		} while (func != 7);

		s.setData_acesso();
		s.setDuracao();
		String contagem = s.contaFuncoes(cont1, cont2, cont3, cont4, cont5, cont6, cont7);
		s.setFuncoes(contagem);
		s.setId_site(page);
		usuario.consultarPorId(id);
		u = new Usuario(u.getId_usuario(), u.getNome(), u.getEmail(), u.getSenha(), u.getNavegador(),
				u.getDeficiencia_visual());
		s.setId_usuario(u);
		sessao.inserir(s);
	}

	private static void alterarCadastro(int id_usuario) {
		UsuarioDAO usuario = new UsuarioDAO();
		Usuario u = usuario.consultarPorId(id_usuario);

		String[] options = { "EMAIL", "SENHA" };
		int op = showOptionDialog(null, "O que deseja alterar?", "Alteração de Dados", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, options, 0);
		if (op == 0) {
			String novoEmail = showInputDialog(
					"O email atual é:\n" + u.getEmail() + "\nPor favor informe o novo email:");
			usuario.alterarEmail(id_usuario, novoEmail);
			showMessageDialog(null, "Email alterado com sucesso!\n" + u.getEmail());
		} else {
			String novaSenha = showInputDialog("A senha atual é:\n" + u.getSenha() + "Por favor informe a nova senha:");
			usuario.alterarSenha(id_usuario, novaSenha);
			showMessageDialog(null, "Senha alterada com sucesso!" + u.getSenha());
		}
	}
}
