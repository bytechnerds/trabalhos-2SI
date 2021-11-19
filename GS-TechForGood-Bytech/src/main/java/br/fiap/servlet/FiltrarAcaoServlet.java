package br.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.AcaoDAO;
import br.fiap.entidade.Acao;
import br.fiap.entidade.TipoTag;

/**
 * Servlet implementation class FiltrarAcaoServlet
 */
@WebServlet("/filtraracao")
public class FiltrarAcaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AcaoDAO aDAO = new AcaoDAO();
		TipoTag tipoTag = null;
		
		String tag = request.getParameter("tag");
		switch (tag) {
		case ("CRIANCAS"):
			tipoTag = TipoTag.CRIANCAS;
			break;
		case ("MULHERES"):
			tipoTag = TipoTag.MULHERES;
			break;
		case ("FAMILIAS"):
			tipoTag = TipoTag.FAMILIAS;
			break;
		case ("SEMTETO"):
			tipoTag = TipoTag.SEMTETO;
			break;
		case ("BAIXARENDA"):
			tipoTag = TipoTag.BAIXARENDA;
			break;
		}
		
		List<Acao> lista = aDAO.filtrarAcoes(tipoTag);
		request.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request.getRequestDispatcher("selecionarAcao.jsp");
		dispatcher.forward(request, response);
	}

}
