package br.com.shalom.model;

import javax.persistence.Embeddable;


@Embeddable
public class Telefone {

	
	private String celular;
	
	private String fixo;

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFixo() {
		return fixo;
	}

	public void setFixo(String fixo) {
		this.fixo = fixo;
	}


	
}
