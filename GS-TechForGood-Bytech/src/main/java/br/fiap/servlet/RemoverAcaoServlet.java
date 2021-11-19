package br.fiap.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.AcaoDAO;

/**
 * Servlet implementation class RemoverAcaoServlet
 */
@WebServlet("/removeracao")
public class RemoverAcaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AcaoDAO aDAO = new AcaoDAO();

		String idAcao = request.getParameter("idAcao");
		int id = Integer.parseInt(idAcao);
		
		aDAO.removerAcao(id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("outputRemocao.jsp");
		dispatcher.forward(request, response);
	}

}
