package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.fiap.conexao.Conexao;
import br.fiap.entidade.Sessao;

public class SessaoDAO {
	private Connection connection;
	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;

	public void inserir(Sessao s) {
		connection = Conexao.conectar();
		sql = "insert into awave_sessao(id_sessao, data_acesso, duracao, funcoes), values (?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, s.getId_sessao());
			ps.setString(2, s.getData_acesso());
			ps.setString(3, s.getDuracao());
			ps.setString(4, s.getFuncoes().name());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao registrar sessão!\n" + e);
		}
	}

	
	//ARRUMAR O SESSÃO, PRECISAMOS CRIAR UM CONTADOR.
//	public Sessao consulta(int id_sessao) {
//		Sessao s = null;
//
//		connection = Conexao.conectar();
//		sql = "select * from awave_sessao where id_sessao = ?";
//		try {
//			ps = connection.prepareStatement(sql);
//			ps.setInt(1, id_sessao);
//
//			rs = ps.executeQuery();
//
//			if (rs.next()) {
//				String data_acesso = rs.getString("data_acesso");
//				String duracao = rs.getString("duracao");
//				String funcoes = rs.getString("funcoes");
//
//				s.setId_sessao(id_sessao);
//				s.setData_acesso(data_acesso);
//				s.setDuracao(duracao);
//				s.setFuncoes(funcoes);
//			}
//		} catch (SQLException e) {
//			System.out.println("Erro ao pesquisar sessao!   " + e + "\n");
//		}
//		return s;
//	}
}
