package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.fiap.conexao.Conexao;
import br.fiap.entidade.Voluntario;

public class VoluntarioDAO {
	private Connection connection;
	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;

	public void cadastrarParceiro(Voluntario v) {
		connection = Conexao.conectar();
		sql = "insert into voluntario(id_voluntario, nome,cpf, email, senha) values(?, ?, ?, ?, ?)";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, v.getId());
			ps.setString(2, v.getNome());
			ps.setInt(3, v.getCpf());
			ps.setString(4, v.getEmail());
			ps.setString(5, v.getSenha());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir usuário!\n" + e);
		}
	}
	
	public Voluntario consultarPorId(int id_usuario) {
		Voluntario v = null;

		connection = Conexao.conectar();
		sql = "select * from voluntario where id_voluntario = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id_usuario);
			rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id_voluntario");
				String nome = rs.getString("nome");
				int cpf = rs.getInt("cpf");
				String email = rs.getString("email");
				String senha = rs.getString("senha");

				v = new Voluntario(id, nome, cpf, email, senha);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar por id:\n " + e);
		}

		return v;
	}
}
