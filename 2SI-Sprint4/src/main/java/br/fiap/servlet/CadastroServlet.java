package br.fiap.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.fiap.dao.UsuarioDAO;
import br.fiap.entidade.TipoDeficiencia;
import br.fiap.entidade.TipoNavegador;
import br.fiap.entidade.Usuario;

/**
 * Servlet implementation class CadastroServlet
 */
@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = new Usuario(0, null, null, null, null, null);
		TipoNavegador nav = null;
		TipoDeficiencia def = null;

		String nome = request.getParameter("name");
		String email = request.getParameter("email");
		String senha = request.getParameter("password");
		String navegador = request.getParameter("navegador");
		String deficiencia = request.getParameter("deficiencia");

		usuario.setId_usuario();
		int id = usuario.getId_usuario();

		switch (navegador) {
		case ("CHROME"):
			nav = TipoNavegador.CHROME;
			break;
		case ("FIREFOX"):
			nav = TipoNavegador.FIREFOX;
			break;
		case ("EDGE"):
			nav = TipoNavegador.EDGE;
			break;
		case ("OPERA"):
			nav = TipoNavegador.OPERA;
			break;
		case ("SAFARI"):
			nav = TipoNavegador.SAFARI;
			break;
		case ("BRAVE"):
			nav = TipoNavegador.BRAVE;
			break;
		case ("INTERNETEXPLORER"):
			nav = TipoNavegador.INTERNETEXPLORER;
			break;
		}

		switch (deficiencia) {
		case ("CEGUEIRA"):
			def = TipoDeficiencia.CEGUEIRA;
			break;
		case ("BAIXAVISAO"):
			def = TipoDeficiencia.BAIXAVISAO;
			break;
		case ("DALTONISMO"):
			def = TipoDeficiencia.DALTONISMO;
			break;
		}
		usuario = new Usuario(id, nome, email, senha, nav, def);
		UsuarioDAO dao = new UsuarioDAO();
		dao.cadastrarUsuario(usuario);

		PrintWriter out = response.getWriter();
		out.println("<html>" + "<body>" + "<h1> Dados cadastrados com sucesso! </h1>" + "<h3>" + id + "</h3><br>"
				+ "<h3>" + nome + "</h3><br>" + "<h3>" + email + "</h3><br>" + "<h3>" + senha + "</h3><br>" + "<h3>"
				+ nav + "</h3><br>" + "<h3>" + def + "</h3><br>" + "</body>" + "</html>");
	}

}
