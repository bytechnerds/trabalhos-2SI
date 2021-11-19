package br.fiap.entidade;

import java.util.Random;

public class Acao {
	private int id;
	private String titulo;
	private String descricao;
	private String duracao;
	private int cnpjInstituicao;
	private int inscritos;
	private TipoTag tipoTag;

	public Acao(int id, String titulo, String descricao, String duracao, int cnpjInstituicao, int inscritos,TipoTag tipoTag) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.duracao = duracao;
		this.cnpjInstituicao = cnpjInstituicao;
		this.inscritos = inscritos;
		this.tipoTag = tipoTag;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		Random random = new Random();
		int numero = random.nextInt(10000);
		this.id = numero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public int getCnpjInstituicao() {
		return cnpjInstituicao;
	}

	public void setCnpjInstituicao(int cnpjInstituicao) {
		this.cnpjInstituicao = cnpjInstituicao;
	}

	public int getInscritos() {
		return inscritos;
	}

	public void setInscritos(int inscritos) {
		this.inscritos = inscritos;
	}

	public TipoTag getTipoTag() {
		return tipoTag;
	}

	public void setTipoTag(TipoTag tipoTag) {
		this.tipoTag = tipoTag;
	}
}
