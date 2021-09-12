package br.fiap.entidade;

import java.util.Random;

public class Usuario {
	private int id_usuario;
	private String nome;
	private String email;
	private String senha;
	private TipoNavegador navegador;
	private TipoDeficiencia deficiencia_visual;
	
	
	public Usuario(int id_usuario, String nome, String email, String senha, TipoNavegador navegador,
			TipoDeficiencia deficiencia_visual) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.navegador = navegador;
		this.deficiencia_visual = deficiencia_visual;
	}
	
	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario() {
		Random random = new Random();
		int numero = random.nextInt(10000);
		this.id_usuario = numero;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public TipoNavegador getNavegador() {
		return navegador;
	}


	public void setNavegador(TipoNavegador navegador) {
		this.navegador = navegador;
	}


	public TipoDeficiencia getDeficiencia_visual() {
		return deficiencia_visual;
	}


	public void setDeficiencia_visual(TipoDeficiencia deficiencia_visual) {
		this.deficiencia_visual = deficiencia_visual;
	}
	
	
}
