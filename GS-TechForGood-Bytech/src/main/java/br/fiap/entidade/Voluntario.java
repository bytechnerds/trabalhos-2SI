package br.fiap.entidade;

import java.util.Random;

public class Voluntario {
	private int id;
	private String nome;
	private int cpf;
	private String endereco;
	private String email;
	private String senha;
	
	public Voluntario(int id, String nome, int cpf, String endereco, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId() {
		Random random = new Random();
		int numero = random.nextInt(10000);
		this.id = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
	
	
}
