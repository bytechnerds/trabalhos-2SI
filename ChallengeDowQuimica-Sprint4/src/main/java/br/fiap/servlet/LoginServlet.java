package br.fiap.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.UsuarioDAO;
import br.fiap.entidade.Usuario;

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

		UsuarioDAO dao = new UsuarioDAO();

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		int id = Integer.parseInt(userId);
		Usuario checkId = dao.consultarPorId(id);
		Usuario checkPassword = dao.consultarSenha(id);

		if (checkId.getId_usuario() == id && checkPassword.getSenha().equalsIgnoreCase(password)) {
			if (checkId.getId_usuario() == 4193) {
				request.setAttribute("usuario", checkId);

				RequestDispatcher dispatcher = request.getRequestDispatcher("paginaAdmin.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("usuario", checkId);

				RequestDispatcher dispatcher = request.getRequestDispatcher("paginaUser.jsp");
				dispatcher.forward(request, response);
			}
		}

	}

}