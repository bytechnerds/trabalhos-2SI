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
 * Servlet implementation class InscreverVoluntario
 */
@WebServlet("/inscrevervoluntario")
public class InscreverVoluntario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AcaoDAO aDAO = new AcaoDAO();
		
		String escolha = request.getParameter("escolha");
		int idEscolha = Integer.parseInt(escolha);
		
		aDAO.inscreverCandidato(idEscolha);

		RequestDispatcher dispatcher = request.getRequestDispatcher("outputCadastroAcao.jsp");
		dispatcher.forward(request, response);
	}

}
