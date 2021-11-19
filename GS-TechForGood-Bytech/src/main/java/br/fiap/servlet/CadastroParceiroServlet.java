package br.fiap.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.ParceiroDAO;
import br.fiap.entidade.Parceiro;

/**
 * Servlet implementation class CadastroParceiroServlet
 */
@WebServlet("/cadastroparceiro")
public class CadastroParceiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Parceiro p = new Parceiro(0, null, 0, null, null, null, null, false);

		String nome = request.getParameter("nome");
		String documento = request.getParameter("documento");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String senha = request.getParameter("password");

		p.setId();
		int id = p.getId();
		int doc = Integer.parseInt(documento);
		Parceiro parceiro = new Parceiro(id, nome, doc, endereco, email, senha, null, false);
		ParceiroDAO dao = new ParceiroDAO();

		dao.cadastrarParceiro(parceiro);

		RequestDispatcher dispatcher = request.getRequestDispatcher("outputCadastro.jsp");
		dispatcher.forward(request, response);

	}

}
