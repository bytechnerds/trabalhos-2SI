package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.fiap.conexao.Conexao;
import br.fiap.entidade.Site;

public class SiteDAO {
	private Connection connection;
	private String sql;
	private PreparedStatement ps;
	
	// Insere os sites acessados naquela seção, no banco de dados
	public void inserirSite(Site s) {
		connection = Conexao.conectar();
		sql = "insert into sites(id_site, uri, numero_de_acessos) values(?, ?, ?)";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, s.getId_site());
			ps.setString(2, s.getUri());
			ps.setInt(3, s.getNumero_de_acessos());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir site!\n" + e);
		}
	}
}
