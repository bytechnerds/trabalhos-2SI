package br.fiap.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.ParceiroDAO;
import br.fiap.dao.VoluntarioDAO;
import br.fiap.entidade.Parceiro;
import br.fiap.entidade.Voluntario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ParceiroDAO pDAO = new ParceiroDAO();
		VoluntarioDAO vDAO = new VoluntarioDAO();

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		int id = Integer.parseInt(userId);
		Parceiro checkIdParceiro = pDAO.consultarPorId(id);
		Voluntario checkIdVoluntario = vDAO.consultarPorId(id);

		if (pDAO.isParceiro(id) == true) {

			if (checkIdParceiro.getId() == id && checkIdParceiro.getSenha().equalsIgnoreCase(password)) {
				request.setAttribute("usuario", checkIdParceiro);

				RequestDispatcher dispatcher = request.getRequestDispatcher("paginaParceiro.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			if (checkIdVoluntario.getId() == id && checkIdVoluntario.getSenha().equalsIgnoreCase(password)) {
				request.setAttribute("usuario", checkIdVoluntario);

				RequestDispatcher dispatcher = request.getRequestDispatcher("paginaVoluntario.jsp");
				dispatcher.forward(request, response);

			}
		}
	}
}