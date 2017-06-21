package br.com.shalom.repository.filter;

import java.time.LocalDateTime;

import br.com.shalom.model.Status;

public class MembroFilter {

	private String nome;
	
	private LocalDateTime dataNascimento;
	
	private LocalDateTime dataMembresia;
	
	private String situacao;
	
	private Status status;
	
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDateTime getDataMembresia() {
		return dataMembresia;
	}

	public void setDataMembresia(LocalDateTime dataMembresia) {
		this.dataMembresia = dataMembresia;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
