package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.fiap.conexao.Conexao;
import br.fiap.entidade.Alimento;
import br.fiap.entidade.Dinheiro;

public class DoacaoDAO {
	private Connection connection;
	private String sql;
	private PreparedStatement ps;
	
	public void cadastrarDoacaoDinheiro(Dinheiro d) {
		connection = Conexao.conectar();
		sql = "insert into doacao_dinheiro(id_transacao, cnpj_instituicao, valor) values(?,?,?) ";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, d.getIdTransacao());
			ps.setInt(2, d.getCpnjInstituicao());
			ps.setDouble(3, d.getValor());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir usuário!\n" + e);
		}
	}
	
	public void cadastrarDoacaoAlimentos(Alimento a) {
		connection = Conexao.conectar();
		sql = "insert into doacao_alimento(id_doacao, quantidade, cnpj_instituicao, tipo) values(?,?,?,?)";
		

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, a.getIdTransacao());
			ps.setDouble(2, a.getQuantidade());
			ps.setInt(3, a.getCpnjInstituicao());
			ps.setString(4, a.getAlimento().name());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir usuário!\n" + e);
		}
	}
}
