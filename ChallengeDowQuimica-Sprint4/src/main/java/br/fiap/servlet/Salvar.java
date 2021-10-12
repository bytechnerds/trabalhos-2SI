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
 * Servlet implementation class Salvar
 */
@WebServlet("/salvar")
public class Salvar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuarioDAO dao = new UsuarioDAO();
		
		String idUser = request.getParameter("idUser");
		String novoEmail = request.getParameter("novoEmail");
		String novaSenha = request.getParameter("novaSenha");

		int id = Integer.parseInt(idUser);
		Usuario checkId = dao.consultarPorId(id);
		
		if (novoEmail == null) {			
			dao.alterarSenha(checkId.getId_usuario(), novaSenha);
			checkId = dao.consultarPorId(id);
		}
		else if (novaSenha == null) {			
			dao.alterarEmail(checkId.getId_usuario(), novoEmail);
			checkId = dao.consultarPorId(id);
		}
		else if (novoEmail != null && novaSenha != null) {
			dao.alterarSenha(checkId.getId_usuario(), novaSenha);
			dao.alterarEmail(checkId.getId_usuario(), novoEmail);
			checkId = dao.consultarPorId(id);
		} else {
			request.setAttribute("usuario", checkId);

			RequestDispatcher dispatcher = request.getRequestDispatcher("paginaUser.jsp");
			dispatcher.forward(request, response);
		}

		request.setAttribute("usuario", checkId);

		RequestDispatcher dispatcher = request.getRequestDispatcher("paginaUser.jsp");
		dispatcher.forward(request, response);
	}

}