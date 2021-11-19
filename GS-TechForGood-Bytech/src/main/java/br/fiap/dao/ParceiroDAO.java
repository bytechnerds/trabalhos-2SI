package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.conexao.Conexao;
import br.fiap.entidade.Parceiro;

public class ParceiroDAO {
	private Connection connection;
	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;

	public void cadastrarParceiro(Parceiro p) {
		connection = Conexao.conectar();
		sql = "insert into instituicao(id_instituicao, nome,cnpj, email, senha, centro_coleta, endereco) values(?, ?, ?, ?, ?, ?,?)";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNome());
			ps.setInt(3, p.getCnpj());
			ps.setString(4, p.getEmail());
			ps.setString(5, p.getSenha());
			ps.setString(6, "false");
			ps.setString(7, p.getEndereco());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir usuário!\n" + e);
		}
	}

	public Boolean isParceiro(int id) {
		boolean aux = false;
		connection = Conexao.conectar();
		sql = "select * from instituicao where id_instituicao = ?";
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
	
	public Parceiro consultarPorId(int id_usuario) {
		Parceiro p = null;

		connection = Conexao.conectar();
		sql = "select * from instituicao where id_instituicao = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id_usuario);
			rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id_instituicao");
				String nome = rs.getString("nome");
				int cnpj = rs.getInt("cnpj");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				String endereco = rs.getString("endereco");
				String centro_coleta = rs.getString("centro_coleta");

				boolean centro;
				if (centro_coleta.equalsIgnoreCase("false")) {
					centro = false;
				} else {
					centro = true;
				}
				p = new Parceiro(id, nome, cnpj, endereco, email, senha, null, centro);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar por id:\n " + e);
		}

		return p;
	}

	public Parceiro consultarPorCnpj(int cnpj_instituicao) {
		Parceiro p = null;

		connection = Conexao.conectar();
		sql = "select * from instituicao where cnpj_instituicao = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cnpj_instituicao);
			rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id_instituicao");
				String nome = rs.getString("nome");
				int cnpj = rs.getInt("cnpj_instituicao");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				String endereco = rs.getString("endereco");
				String centro_coleta = rs.getString("centro_coleta");

				boolean centro;
				if (centro_coleta.equalsIgnoreCase("false")) {
					centro = false;
				} else {
					centro = true;
				}
				p = new Parceiro(id, nome, cnpj, endereco, email, senha, null, centro);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar por id:\n " + e);
		}

		return p;
	}
	
	public void habilitarColeta(int id_usuario) {
		connection = Conexao.conectar();

		sql = "update instituicao set centro_coleta = ? where id_instituicao = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "true");
			ps.setInt(2, id_usuario);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir usuário!\n" + e);
		}
	}
	
	public List<Parceiro> listarPontosColeta(){
		List<Parceiro> lista = new ArrayList<Parceiro>();
		
		connection = Conexao.conectar();

		sql = "select * from instituicao where centro_coleta = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, "true");
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id_instituicao");
				String nome = rs.getString("nome"); 
				int cnpj = rs.getInt("cnpj");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				boolean centro_coleta = rs.getBoolean("centro_coleta");
				String endereco = rs.getString("endereco");
				lista.add(new Parceiro(id, nome, cnpj, endereco, email, senha, null, centro_coleta));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir usuário!\n" + e);
		}

		
		return lista;
	}
}
