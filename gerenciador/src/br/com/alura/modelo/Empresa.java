package br.com.alura.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Empresa {
	
	private long id;
	private String nome;
	private Date dataAbertura = new Date();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	

}
