package br.com.shalom.model;

public enum Situacao {
	
	BATIZADO("Batizado"),
	ASSISTENTE("Assitente"),
	MEMBRO("Membro"),
	VISISTANTE("Visitante");
	
	private String descricao;
	
	Situacao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public String getDescricao(){
		return descricao;
	}

}
