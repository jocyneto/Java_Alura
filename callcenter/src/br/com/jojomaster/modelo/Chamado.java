package br.com.jojomaster.modelo;

import java.util.Date;

public class Chamado {
	
	private Integer id=0;
	private String nome;
	private String email;
	private String telefone;
	private String servico;
	private String status;
	private Date dataAbertura;
	private Date dataConclusao;
	private String observacao;
	
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String descricao) {
		this.observacao = descricao;
	}
	
	@Override
	public String toString() {
		return String.format("Id: %s"
							+ " - Nome: %s"
							+ " - Email: %s"
							+ " - telefone: %s"
							+ " - servico: %s"
							+ " - status: %s"
							+ " - dt abertura: %s"
							+ " - dt conclusao: %s"
							+ " - observacao: %s", this.id, this.nome, this.email, this.telefone, this.servico, this.status, this.dataAbertura, this.dataConclusao, this.observacao );
	}
	

}
