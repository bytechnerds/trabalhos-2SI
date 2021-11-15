package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.conexao.Conexao;
import br.fiap.entidade.Usuario;
import br.fiap.entidade.TipoDeficiencia;
import br.fiap.entidade.TipoNavegador;

public class UsuarioDAO {
	private Connection connection;
	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;
	private int total;

	public void cadastrarUsuario(Usuario u) {
		connection = Conexao.conectar();
		sql = "insert into usuario(id_usuario, nome, email, senha, navegador, deficiencia_visual) values(?, ?, ?, ?, ?, ?)";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, u.getId_usuario());
			ps.setString(2, u.getNome());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSenha());
			ps.setString(5, u.getNavegador().name());
			ps.setString(6, u.getDeficiencia_visual().name());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir usuário!\n" + e);
		}
	}

	public void alterarEmail(int id_usuario, String email) {
		connection = Conexao.conectar();
		sql = "update usuario set email = ? where id_usuario = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setInt(2, id_usuario);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar email! \n" + e);
		}
	}

	public void alterarSenha(int id_usuario, String senha) {
		connection = Conexao.conectar();
		sql = "update usuario set senha = ? where id_usuario = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, senha);
			ps.setInt(2, id_usuario);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar senha! \n" + e);
		}
	}

	// consultar cadastro
	public boolean consultarCadastro(int id) {
		boolean aux = false;
		connection = Conexao.conectar();
		sql = "select * from usuario where id_usuario = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			aux = rs.next();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar usuário!   " + e + "\n");
		}
		return aux;
	}

	// consultar por id
	public Usuario consultarPorId(int id_usuario) {
		Usuario u = null;

		connection = Conexao.conectar();
		sql = "select * from usuario where id_usuario = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id_usuario);
			rs = ps.executeQuery();
			if (rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				TipoNavegador navegador;
				String aux = rs.getString("navegador");
				// CHROME, FIREFOX, EDGE, OPERA, SAFARI, BRAVE, INTERNETEXPLORER;

				if (aux.equalsIgnoreCase("CHROME")) {
					navegador = TipoNavegador.CHROME;
				} else if (aux.equalsIgnoreCase("FIREFOX")) {
					navegador = TipoNavegador.FIREFOX;
				} else if (aux.equalsIgnoreCase("EDGE")) {
					navegador = TipoNavegador.EDGE;
				} else if (aux.equalsIgnoreCase("OPERA")) {
					navegador = TipoNavegador.OPERA;
				} else if (aux.equalsIgnoreCase("SAFARI")) {
					navegador = TipoNavegador.SAFARI;
				} else if (aux.equalsIgnoreCase("BRAVE")) {
					navegador = TipoNavegador.BRAVE;
				} else {
					navegador = TipoNavegador.INTERNETEXPLORER;
				}

				TipoDeficiencia deficiencia;
				aux = rs.getString("deficiencia_visual");
				if (aux.equalsIgnoreCase("CEGUEIRA")) {
					deficiencia = TipoDeficiencia.CEGUEIRA;
				} else if (aux.equalsIgnoreCase("BAIXAVISAO")) {
					deficiencia = TipoDeficiencia.BAIXAVISAO;
				} else {
					deficiencia = TipoDeficiencia.DALTONISMO;
				}

				u = new Usuario(id_usuario, nome, email, senha, navegador, deficiencia);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar por id:\n " + e);
		}

		return u;
	}

	// Contar por Deficiência
	public int contarDeficiencia(String deficiencia_visual) {
		total = 0;
		connection = Conexao.conectar();
		sql = "select * from usuario where deficiencia_visual = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, deficiencia_visual);
			rs = ps.executeQuery();
			while (rs.next())
				total++;
		} catch (SQLException e) {
			System.out.println("Erro ao contar usuários por deficiência! \n" + e);
		}

		return total;
	}

	// Contar por Navegador
	public int contarNavegador(String navegador) {
		total = 0;
		connection = Conexao.conectar();
		sql = "select * from usuario where navegador = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, navegador);
			rs = ps.executeQuery();
			while (rs.next())
				total++;
		} catch (SQLException e) {
			System.out.println("Erro ao contar usuários por navegador! \n" + e);
		}
		return total;
	}

}