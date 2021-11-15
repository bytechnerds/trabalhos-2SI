package br.fiap.entidade;

import java.util.ArrayList;
import java.util.Random;

public class Parceiro {
	private int id;
	private String nome;
	private int cnpj;
	private String endereco;
	private String email;
	private String senha;
	private ArrayList<Acao> acoes;
	private boolean centroDeColeta;
	
	public Parceiro(int id, String nome, int cnpj, String endereco, String email, String senha, ArrayList<Acao> acoes,
			boolean centroDeColeta) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.email = email;
		this.senha = senha;
		this.acoes = acoes;
		this.centroDeColeta = centroDeColeta;
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

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
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

	public ArrayList<Acao> getAcoes() {
		return acoes;
	}

	public void setAcoes(ArrayList<Acao> acoes) {
		this.acoes = acoes;
	}

	public boolean isCentroDeColeta() {
		return centroDeColeta;
	}

	public void setCentroDeColeta(boolean centroDeColeta) {
		this.centroDeColeta = centroDeColeta;
	}	
}
