package br.fiap.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.VoluntarioDAO;
import br.fiap.entidade.Voluntario;

/**
 * Servlet implementation class CadastroVoluntarioServlet
 */
@WebServlet("/cadastrovoluntario")
public class CadastroVoluntarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Voluntario v = new Voluntario(0, null, 0, null, null);

		String nome = request.getParameter("nome");
		String documento = request.getParameter("documento");
		String email = request.getParameter("email");
		String senha = request.getParameter("password");

		v.setId();
		int id = v.getId();
		int doc = Integer.parseInt(documento);
		Voluntario voluntario = new Voluntario(id, nome, doc, email, senha);
		VoluntarioDAO dao = new VoluntarioDAO();

		dao.cadastrarParceiro(voluntario);

		RequestDispatcher dispatcher = request.getRequestDispatcher("outputCadastro.jsp");
		dispatcher.forward(request, response);
	}

}
