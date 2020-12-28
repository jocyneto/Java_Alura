package br.com.alura.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Material {
	private String nome;
	private double quantidade;
	private Date dataCadastro;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Material(String nome, double quantidade, Date dataCadastro) {
		this.nome = nome;
		this.setQuantidade(quantidade);
		this.dataCadastro = dataCadastro;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public double getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(double quantidade) {
		if(quantidade > 0) {
			this.quantidade = quantidade;
		}		
	}
	
	public String getRetorna() {
		return String.format("Nome do material: %s | Quantidade: %s | Data de adição: %s"
				, this.getNome()
				, this.getQuantidade()
				, this.sdf.format(this.getDataCadastro()));
	}
	

	

}
