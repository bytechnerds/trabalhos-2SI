package br.fiap.entidade;

public class Sessao {
	private int id_sessao;
	private String data_acesso;
	private String duracao;
	private TipoFuncoes funcoes;
	
	
	public Sessao(int id_sessao, String data_acesso, String duracao, TipoFuncoes funcoes) {
		super();
		this.id_sessao = id_sessao;
		this.data_acesso = data_acesso;
		this.duracao = duracao;
		this.funcoes = funcoes;
	}


	public int getId_sessao() {
		return id_sessao;
	}


	public void setId_sessao(int id_sessao) {
		this.id_sessao = id_sessao;
	}


	public String getData_acesso() {
		return data_acesso;
	}


	public void setData_acesso(String data_acesso) {
		this.data_acesso = data_acesso;
	}


	public String getDuracao() {
		return duracao;
	}


	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}


	public TipoFuncoes getFuncoes() {
		return funcoes;
	}


	public void setFuncoes(TipoFuncoes funcoes) {
		this.funcoes = funcoes;
	}	
}
