package br.fiap.entidade;

public class Alimento extends Doacao{
	private double quantidade;
	private TipoAlimentos alimento;
	
	public Alimento(int idTransacao,double quantidade,  int cpnjInstituicao, TipoAlimentos alimento) {
		super(idTransacao, cpnjInstituicao);
		this.quantidade = quantidade;
		this.alimento = alimento;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public TipoAlimentos getAlimento() {
		return alimento;
	}

	public void setAlimento(TipoAlimentos alimento) {
		this.alimento = alimento;
	}

}