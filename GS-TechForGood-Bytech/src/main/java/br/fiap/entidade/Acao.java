package br.fiap.entidade;

import java.util.Random;

public class Acao {
	private int id;
	private String titulo;
	private String descricao;
	private String tag;
	private int duracao;
	private int cnpjInstituicao;
	private int inscritos;

	public Acao(int id, String titulo, String descricao, String tag, int duracao, int cnpjInstituicao, int inscritos) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.duracao = duracao;
		this.cnpjInstituicao = cnpjInstituicao;
		this.inscritos = inscritos;
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
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
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

}
