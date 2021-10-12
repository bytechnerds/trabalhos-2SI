package br.fiap.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.UsuarioDAO;
import br.fiap.entidade.TipoNavegador;

/**
 * Servlet implementation class AdministrarUsuario
 */
@WebServlet("/administrarnavegadores")
public class AdministrarNavegadores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsuarioDAO usuario = new UsuarioDAO();

		TipoNavegador nav = null;
		String navegador = request.getParameter("navegador");
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

		try {
			int total = usuario.contarNavegador(navegador);
			PrintWriter out = response.getWriter();
			out.println("<html><body><h1>NAVEGADOR: " + nav + "</h1><br><br><h3>Número de usuários: " + total
					+ "</h3></body></html>");
		} catch (NullPointerException e) {
			System.out.println("Não foi possível consultar" + e);
			PrintWriter out = response.getWriter();
			out.println("<html><body><h1>Dados não encontrados</h1></body></html>");

		}
	}

}
