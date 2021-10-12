package br.fiap.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.SessaoDAO;
import br.fiap.dao.SiteDAO;
import br.fiap.entidade.Sessao;
import br.fiap.entidade.Site;

/**
 * Servlet implementation class EncerraNav
 */
@WebServlet("/encerranav")
public class EncerraNav extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessaoDAO sessao = new SessaoDAO();
		Sessao s = new Sessao(0, null, 0, null, 0);

		SiteDAO site = new SiteDAO();
		Site p = new Site(0, null, 0);
		
		int cont= 0;
		int cont1 = s.setFuncNumber();
		int cont2 = s.setFuncNumber();
		int cont3 = s.setFuncNumber();
		int cont4 = s.setFuncNumber();
		int cont5 = s.setFuncNumber();
		int cont6 = s.setFuncNumber();
		int cont7 = s.setFuncNumber();
		String contagem = s.contaFuncoes(cont1, cont2, cont3, cont4, cont5, cont6, cont7);
		
		
		p.setId_site();
		String url = request.getParameter("url");
		p.setUri(url);
		p.setNumero_de_acessos(cont++);
		site.inserirSite(p);

		s.setId_sessao();
		int id_sessao = s.getId_sessao();
		s.setData_acesso();
		s.setDuracao();
		s.setFuncoes(contagem);
		s.setId_site(p);

		sessao.inserir(s);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>Id da sessão: "+id_sessao+"</h1><br><br><h3> Obrigado por utilizar nossa aplicação!</h3></body></html>");
	}

}
