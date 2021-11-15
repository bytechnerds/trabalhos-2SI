package br.fiap.entidade;

public class Dinheiro extends Doacao{
	private double valor;
	
	public Dinheiro(int cpnjInstituicao, double valor) {
		super(cpnjInstituicao);
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
