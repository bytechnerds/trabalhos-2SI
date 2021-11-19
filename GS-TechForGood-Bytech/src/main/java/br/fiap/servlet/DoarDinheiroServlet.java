package br.fiap.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.DoacaoDAO;
import br.fiap.entidade.Dinheiro;

/**
 * Servlet implementation class DoarDinheiroServlet
 */
@WebServlet("/doardinheiro")
public class DoarDinheiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dinheiro d = new Dinheiro(0, 0, 0);
		DoacaoDAO dDAO = new DoacaoDAO();
		
		d.setIdTransacao();
		int id = d.getIdTransacao();
		
		String valor = request.getParameter("valor");
		double valorNum = Double.parseDouble(valor);
		String cnpj = request.getParameter("cnpj");
		int cnpjNum = Integer.parseInt(cnpj);
		
		d = new Dinheiro(id, cnpjNum, valorNum);
		dDAO.cadastrarDoacaoDinheiro(d);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("outputDoacao.jsp");
		dispatcher.forward(request, response);
	}

}
