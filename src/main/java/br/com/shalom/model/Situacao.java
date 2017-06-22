package br.com.shalom.model;

public enum Situacao {
	
	MEMBRO("Membro"),
	ASSISTENTE("Assitente"),
	VISISTANTE("Visitante");
	
	private String descricao;
	
	Situacao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public String getDescricao(){
		return descricao;
	}

}
