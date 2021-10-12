package br.fiap.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/paginaAdmin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String consultarUsuario = request.getParameter("consultarUsuario");
		String consultarSessao = request.getParameter("consultarSessao");
		String estDeficiencias = request.getParameter("estDeficiencias");
		String estNavegadores = request.getParameter("estNavegadores");
		String encerrar = request.getParameter("encerrar");

		if (consultarUsuario != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("consultaUsuario.jsp");
			dispatcher.forward(request, response);
		} else if (consultarSessao != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("consultaSessao.jsp");
			dispatcher.forward(request, response);
		} else if (estDeficiencias != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("consultaDeficiencia.jsp");
			dispatcher.forward(request, response);
		} else if (estNavegadores != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("consultaNavegador.jsp");
			dispatcher.forward(request, response);
		} else if (encerrar != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.forward(request, response);
		}
	}
}