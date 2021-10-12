package br.fiap.servlet;

import static java.lang.Integer.parseInt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.SessaoDAO;
import br.fiap.entidade.Sessao;


/**
 * Servlet implementation class AdministrarUsuario
 */
@WebServlet("/administrarsessao")
public class AdministrarSessao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessaoDAO sessao = new SessaoDAO();
		String idSessao = request.getParameter("idSessao");

		int id_sessao = parseInt(idSessao);

		try {
			Sessao s = sessao.consultar(id_sessao);
			int duracao = s.getDuracao();
			PrintWriter out = response.getWriter();
			out.println("<html><body><h1>Id da Sess�o: " + s.getId_sessao() + "</h1><br><br><h3>Dura��o: " + s.getDuracaoFormatada(duracao)
					+ "</h3>" + "<br><h3>Data de Acesso: " + s.getData_acesso() + "</h3><br><h3>P�gina Acessada: " + s.getId_site() + "</h3><br><h3>"
					+ s.getFuncoes() + "</h3></body></html>");
		} catch (NullPointerException e) {
			System.out.println("N�o foi poss�vel consultar" + e);
			PrintWriter out = response.getWriter();
			out.println("<html><body><h1>Sess�o n�o encontrada</h1></body></html>");
		}
	}

}
