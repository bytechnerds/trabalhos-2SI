package br.fiap.servlet;

import static java.lang.Integer.parseInt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fiap.dao.UsuarioDAO;
import br.fiap.entidade.Usuario;

/**
 * Servlet implementation class AdministrarUsuario
 */
@WebServlet("/administrarusuario")
public class AdministrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idUser = request.getParameter("idUser");
		UsuarioDAO usuario = new UsuarioDAO();

		int id_usuario = parseInt(idUser);

		try {
			Usuario u = usuario.consultarPorId(id_usuario);
			PrintWriter out = response.getWriter();
			out.println("<html><body><h1>Usuario: " + u.getNome() + "</h1><br><br><h3>Id: " + u.getId_usuario() + "</h3>"
					+ "<br><h3>E-mail: " + u.getEmail() + "</h3><br><h3>Deficiencia: " + u.getDeficiencia_visual() + "</h3><br><h3>Navegador Padrão: "
					+ u.getNavegador() + "</h3></body></html>");
		} catch (NullPointerException e) {
			System.out.println("Não foi possível consultar" + e);
			PrintWriter out = response.getWriter();
			out.println("<html><body><h1>Usuário não cadastrado</h1></body></html>");
		}
	}

}
