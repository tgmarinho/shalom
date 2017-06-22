package br.com.shalom.repository.filter;

import java.util.List;

import br.com.shalom.model.Situacao;

public class MembroFilter {

	private String nome;
	
	private String mes;
	
	private List<Situacao> situacao;
	
	private String status;
	
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public List<Situacao> getSituacao() {
		return situacao;
	}

	public void setSituacao(List<Situacao> situacao) {
		this.situacao = situacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
