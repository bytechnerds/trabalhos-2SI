package br.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.UsuarioDAO;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/paginaAdmin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		UsuarioDAO dao = new UsuarioDAO();
//		
//		String consultarUsuario = request.getParameter("consultarUsuario");
//		String consultarSessao = request.getParameter("consultarSessao");
//		String estDeficiencias = request.getParameter("estDeficiencias");
//		String estNavegadores = request.getParameter("estNavegadores");
//		String encerrar = request.getParameter("encerrar");
//		
//		
	}

}
