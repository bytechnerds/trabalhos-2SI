package br.fiap.servlet;

import java.io.IOException;

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
 * Servlet implementation class CriarAcaoServlet
 */
@WebServlet("/criaracao")
public class CriarAcaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Acao acao = new Acao(0, null, null, null, 0, 0, null);
		TipoTag tipoTag = null;

		String titulo = request.getParameter("titulo");
		String duracao = request.getParameter("duracao");
		String descricao = request.getParameter("descricao");
		String tag = request.getParameter("tag");

		String cnpj = request.getParameter("cnpj");
		int cnpjNum = Integer.parseInt(cnpj);

		acao.setId();
		int id = acao.getId();

		int inscritos = 0;
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
		acao = new Acao(id, titulo, descricao, duracao, cnpjNum, inscritos, tipoTag);
		AcaoDAO dao = new AcaoDAO();
		dao.cadastrarAcao(acao);

		RequestDispatcher dispatcher = request.getRequestDispatcher("outputAcao.jsp");
		dispatcher.forward(request, response);
	}

}
