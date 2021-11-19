package br.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.ParceiroDAO;
import br.fiap.entidade.Parceiro;

/**
 * Servlet implementation class ListarCentrosColeta
 */
@WebServlet("/listarcentroscoleta")
public class ListarCentrosColeta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParceiroDAO pDAO = new ParceiroDAO();
		
		List<Parceiro> lista = pDAO.listarPontosColeta();
		request.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request.getRequestDispatcher("outputCentrosColeta.jsp");
		dispatcher.forward(request, response);
	}

}
