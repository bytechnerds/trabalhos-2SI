package br.fiap.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.DoacaoDAO;
import br.fiap.entidade.Alimento;
import br.fiap.entidade.TipoAlimentos;

/**
 * Servlet implementation class DoarAlimentosServlet
 */
@WebServlet("/doaralimentos")
public class DoarAlimentosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DoacaoDAO dDAO = new DoacaoDAO();
		Alimento alimento = new Alimento(0, 0, 0, null);
		TipoAlimentos tipoAlimentos = null;
		
		String cnpj = request.getParameter("cnpj");
		int cnpjNum = Integer.parseInt(cnpj);
		String quantidade = request.getParameter("quantidade");
		double kg = Double.parseDouble(quantidade);
		String tipo = request.getParameter("tipo");
		
		
		alimento.setIdTransacao();
		int id = alimento.getIdTransacao();
		
		switch(tipo) {
		case ("CESTASIMPLES"):
			tipoAlimentos = TipoAlimentos.CESTASIMPLES;
			break;
		case ("CESTACOMPLETA"):
			tipoAlimentos = TipoAlimentos.CESTACOMPLETA;
			break;
		case("ARROZ"):
			tipoAlimentos = TipoAlimentos.ARROZ;
			break;
		case("FEIJAO"):
			tipoAlimentos = TipoAlimentos.FEIJAO;
			break;
		case("OLEO"):
			tipoAlimentos = TipoAlimentos.OLEO;
			break;
		case("SAL"):
			tipoAlimentos = TipoAlimentos.SAL;
			break;
		}
		alimento = new Alimento(id, kg, cnpjNum, tipoAlimentos);
		dDAO.cadastrarDoacaoAlimentos(alimento);
		RequestDispatcher dispatcher = request.getRequestDispatcher("outputDoacao.jsp");
		dispatcher.forward(request, response);
	}

}
