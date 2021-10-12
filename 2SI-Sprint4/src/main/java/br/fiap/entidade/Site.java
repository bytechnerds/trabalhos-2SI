package br.fiap.entidade;

import java.util.Random;

public class Site {
	private int id_site;
	private String uri;
	private int numero_de_acessos;
	
	
	public Site(int id_site, String uri, int numero_de_acessos) {
		super();
		this.id_site = id_site;
		this.uri = uri;
		this.numero_de_acessos = numero_de_acessos;
	}


	public int getId_site() {
		return id_site;
	}


	public void setId_site() {
		Random random = new Random();
		int numero = random.nextInt(10000);
		this.id_site = numero;
	}


	public String getUri() {
		return uri;
	}


	public void setUri(String uri) {
		this.uri = uri;
	}


	public int getNumero_de_acessos() {
		return numero_de_acessos;
	}


	public void setNumero_de_acessos(int numero_de_acessos) {
		this.numero_de_acessos = numero_de_acessos;
	}
	
	
}
