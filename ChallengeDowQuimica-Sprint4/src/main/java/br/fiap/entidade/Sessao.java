package br.fiap.entidade;

import java.util.Date;
import java.util.Random;

public class Sessao {
	private int id_sessao;
	private Date data_acesso;
	private int duracao;
	private String funcoes;
	private int id_site;

//	public Sessao(int id_sessao, Date data_acesso, int duracao, String funcoes) {
//		this.id_sessao = id_sessao;
//		this.data_acesso = data_acesso;
//		this.duracao = duracao;
//		this.funcoes = funcoes;
//	}

	public Sessao(int id_sessao, Date data_acesso, int duracao, String funcoes, int id_site) {
		this.id_sessao = id_sessao;
		this.data_acesso = data_acesso;
		this.duracao = duracao;
		this.funcoes = funcoes;
		this.id_site = id_site;
	}

	public int getId_sessao() {
		return id_sessao;
	}

	public void setId_sessao() {
		Random random = new Random();
		int id_sessao = random.nextInt(10000) + 1000;
		this.id_sessao = id_sessao;
	}

	public Date getData_acesso() {
		return data_acesso;
	}

	public void setData_acesso() {
		Date data = new Date();

		this.data_acesso = data;
	}

	public int getDuracao() {
		return duracao;
	}

	public String getDuracaoFormatada(int duracao) {
		String tempo = "";

		int segundos = duracao;
		int seg = segundos % 60;
		int minutos = segundos / 60;
		int min = minutos % 60;
		int hora = minutos / 60;

		tempo = "A sessão durou:  " + hora + " horas, " + min + " minutos, " + seg + " segundos.";
		return tempo;
	}

	public void setDuracao() {
		Random random = new Random();
		int numero = random.nextInt(86401);

		this.duracao = numero;
	}

	public String contaFuncoes(int cont1, int cont2, int cont3, int cont4, int cont5, int cont6, int cont7) {
		String contagem = "";

		contagem += "CONTAGEM DE FUNÇÕES\n\n";
		contagem += "FUNÇÃO DESCREVER 			 			-  " + cont1 + "\n";
		contagem += "FUNÇÃO NARRAÇÃO        		 		-  " + cont2 + "\n";
		contagem += "FUNÇÃO NAVEGAÇÃO POR BLOCOS  			-  " + cont3 + "\n";
		contagem += "FUNÇÃO NAVEGAÇÃO POR BOTÕES  			-  " + cont4 + "\n";
		contagem += "FUNÇÃO NAVEGAÇÃO POR MÍDIAS  			-  " + cont5 + "\n";
		contagem += "FUNÇÃO NAVEGAÇÃO POR IMAGENS 			-  " + cont6 + "\n";
		contagem += "FUNÇÃO NAVEGAÇÃO POR ENTRADA DE DADOS	-  " + cont7 + "\n";

		return contagem;
	}

	public String getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(String contagem) {
		this.funcoes = contagem;
	}

	public int getId_site() {
		return id_site;
	}

	public void setId_site(Site id_site) {
		this.id_site = id_site.getId_site();
	}

	public int setFuncNumber() {
		Random random = new Random();
		int cont = random.nextInt(50);
		
		return cont;
	}

}
