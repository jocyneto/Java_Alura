package br.com.jojo.modelo;

import br.com.bytebank.modelo.ContaCorrente;

public class ListaSimples {
	
	private Object[] lista;
	private int tamanho;
	
	public ListaSimples() {
		this.lista = new Object[100];
		this.tamanho = 0;
	}

	public void adiciona(Object cc1) {
		lista[tamanho] = cc1;
		tamanho++;
	}
	
	public int tamanho() {
		return this.tamanho;
	}

	public Object getConta(int i) {
		return lista[i];
	}
	
	
}
