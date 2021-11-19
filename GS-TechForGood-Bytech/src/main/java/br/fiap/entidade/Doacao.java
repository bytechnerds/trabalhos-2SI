package br.fiap.entidade;

import java.util.Random;

public class Doacao {
	private int idTransacao;
	private int cpnjInstituicao;

	public Doacao(int idTransacao, int cpnjInstituicao) {
		super();
		this.idTransacao = idTransacao;
		this.cpnjInstituicao = cpnjInstituicao;
	}

	public int getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao() {
		Random random = new Random();
		int numero = random.nextInt(10000);
		this.idTransacao = numero;
	}

	public int getCpnjInstituicao() {
		return cpnjInstituicao;
	}

	public void setCpnjInstituicao(int cpnjInstituicao) {
		this.cpnjInstituicao = cpnjInstituicao;
	} 
}
