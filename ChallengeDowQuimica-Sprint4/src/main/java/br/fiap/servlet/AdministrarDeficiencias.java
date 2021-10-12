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

/**
 * Servlet implementation class AdministrarUsuario
 */
@WebServlet("/administrardeficiencias")
public class AdministrarDeficiencias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsuarioDAO usuario = new UsuarioDAO();

		TipoDeficiencia def = null;
		String deficiencia = request.getParameter("deficiencia");
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

		try {
			int total = usuario.contarDeficiencia(deficiencia);
			PrintWriter out = response.getWriter();
			out.println("<html><body><h1>DEFICIÊNCIA: " + def + "</h1><br><br><h3>Número de usuários: " + total
					+ "</h3></body></html>");
		} catch (NullPointerException e) {
			System.out.println("Não foi possível consultar" + e);
			PrintWriter out = response.getWriter();
			out.println("<html><body><h1>Dados não encontrados</h1></body></html>");

		}
	}

}
