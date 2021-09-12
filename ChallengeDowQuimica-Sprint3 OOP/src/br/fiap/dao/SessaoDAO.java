package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.fiap.conexao.Conexao;
import br.fiap.entidade.Sessao;

public class SessaoDAO {
	private Connection connection;
	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;

	// insere no banco de dados a sessão iniciada
	public void inserir(Sessao s) {
		connection = Conexao.conectar();
		sql = "insert into sessao(id_sessao, data_acesso, duracao, funcoes, sites_id_site, usuario_id_usuario) values(?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, s.getId_sessao());
			ps.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
			ps.setInt(3, s.getDuracao());
			ps.setString(4, s.getFuncoes());
			ps.setInt(5, s.getId_site());
			ps.setInt(6, s.getId_usuario());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao registrar sessão!\n" + e);
		}
	}

	// consulta no banco de dados uma sessão, a partir de um id.
	public Sessao consultar(int id_sessao) {
		Sessao s = null;

		connection = Conexao.conectar();
		sql = "select * from sessao where id_sessao = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id_sessao);

			rs = ps.executeQuery();

			if (rs.next()) {
				//arrumar esse data_acesso
				Date data_acesso = rs.getDate("data_acesso");
				int duracao = rs.getInt("duracao");
				String funcoes = rs.getString("funcoes");
				int id_site = rs.getInt("sites_id_site");
				int id_usuario = rs.getInt("usuario_id_usuario");
			
				s = new Sessao(id_sessao, data_acesso, duracao, funcoes, id_site, id_usuario);
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar sessao!   " + e + "\n");
		}

		return s;
	}
}
