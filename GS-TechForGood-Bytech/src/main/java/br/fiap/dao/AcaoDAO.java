package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.conexao.Conexao;
import br.fiap.entidade.Acao;
import br.fiap.entidade.TipoTag;

public class AcaoDAO {
	private Connection connection;
	private String sql, sql1, sql2;
	private PreparedStatement ps;
	private ResultSet rs;

	public void cadastrarAcao(Acao a) {
		connection = Conexao.conectar();
		sql = "insert into acao(id_acao, titulo,descricao, duracao, cnpj_instituicao, qtd_inscritos,categorias) values(?, ?, ?, ?, ?, ?,?)";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, a.getId());
			ps.setString(2, a.getTitulo());
			ps.setString(3, a.getDescricao());
			ps.setString(4, a.getDuracao());
			ps.setInt(5, a.getCnpjInstituicao());
			ps.setInt(6, a.getInscritos());
			ps.setString(7, a.getTipoTag().name());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir usuário!\n" + e);
		}
	}
	
	public void removerAcao(int idAcao) {
		connection = Conexao.conectar();
		
		sql = "delete from acao where id_acao = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idAcao);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao excluir ação!\n" + e);
		}
	}
	
	public void inscreverCandidato(int idAcao) {
		int qtd_inscritos = 0;
		connection = Conexao.conectar();
		
		sql1 = "select qtd_inscritos from acao where id_acao=?";
		try {
			ps = connection.prepareStatement(sql1);
			ps.setInt(1, idAcao);
			rs = ps.executeQuery();
			while (rs.next()) {
				qtd_inscritos = rs.getInt("qtd_inscritos");
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir usuário!\n" + e);
		}
		
		qtd_inscritos++;
		
		sql2 = "update acao set qtd_inscritos = ? where id_acao = ?";
		try {
			ps = connection.prepareStatement(sql2);
			ps.setInt(1, qtd_inscritos);
			ps.setInt(2, idAcao);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir usuário!\n" + e);
		}
	}
	public List<Acao> listar(int cnpj_instituicao) {
		connection = Conexao.conectar();
		List<Acao> lista = new ArrayList<Acao>();
		TipoTag tipoTag = null;
		
		
		sql = "select * from acao where cnpj_instituicao=?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cnpj_instituicao);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id_acao");
				String titulo = rs.getString("titulo");
				String descricao = rs.getString("descricao");
				String duracao = rs.getString("duracao");
				int cnpj = rs.getInt("cnpj_instituicao");
				int inscritos = rs.getInt("qtd_inscritos");
				String categoria = rs.getString("categorias");
				switch (categoria) {
				case ("CRIANCAS"):
					tipoTag = TipoTag.CRIANCAS;
					break;
				case ("MULHERES"):
					tipoTag = TipoTag.MULHERES;
					break;
				case ("FAMILIAS"):
					tipoTag = TipoTag.FAMILIAS;
					break;
				case ("SEMTETO"):
					tipoTag = TipoTag.SEMTETO;
					break;
				case ("BAIXARENDA"):
					tipoTag = TipoTag.BAIXARENDA;
					break;
				}
				lista.add(new Acao(id, titulo, descricao, duracao, cnpj, inscritos, tipoTag));
			}
		} catch (Exception e) {
			System.out.println("ERRO AO LISTAR! \n" + e);

		}
		return lista;
	}
	
	public List<Acao> filtrarAcoes(TipoTag tipoTag){
		String tag = tipoTag.name();
		List<Acao> listaAcoes = new ArrayList<Acao>();
		
		connection = Conexao.conectar();
		sql = "select * from acao where categorias= ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, tag);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id_acao");
				String titulo = rs.getString("titulo");
				String descricao = rs.getString("descricao");
				String duracao = rs.getString("duracao");
				int cnpj = rs.getInt("cnpj_instituicao");
				int inscritos = rs.getInt("qtd_inscritos");
				String categoria = rs.getString("categorias");
				switch (categoria) {
				case ("CRIANCAS"):
					tipoTag = TipoTag.CRIANCAS;
					break;
				case ("MULHERES"):
					tipoTag = TipoTag.MULHERES;
					break;
				case ("FAMILIAS"):
					tipoTag = TipoTag.FAMILIAS;
					break;
				case ("SEMTETO"):
					tipoTag = TipoTag.SEMTETO;
					break;
				case ("BAIXARENDA"):
					tipoTag = TipoTag.BAIXARENDA;
					break;

				}
				listaAcoes.add(new Acao(id, titulo, descricao, duracao, cnpj, inscritos, tipoTag));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir usuário!\n" + e);
		}
		return listaAcoes;
	}
}
