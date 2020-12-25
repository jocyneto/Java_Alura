package br.com.faesa.arvore;

import br.com.faesa.modelo.Cliente;

public class NoArvore {
	private NoArvore dir, esq;
	private Cliente info;
		
	public NoArvore (Cliente info){
		this.info = info;
	}
	
	public NoArvore getDir() {
		return dir;
	}
	
	public void setDir(NoArvore dir) {
		this.dir = dir;
	}
	
	public NoArvore getEsq() {
		return esq;
	}
	
	public void setEsq(NoArvore esq) {
		this.esq = esq;
	}
	
	public Cliente getInfo() {
		return info;
	}
	
	public void setInfo(Cliente novo) {
		this.info = novo;
	}	
	
	
}
