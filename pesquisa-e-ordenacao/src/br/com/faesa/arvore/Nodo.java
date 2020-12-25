package br.com.faesa.arvore;

import br.com.faesa.modelo.Cliente;

public class Nodo extends NoArvore{
	private byte fatorBalanceamento;
	
	public Nodo(Cliente info) {
		super(info);
		fatorBalanceamento = 0;
	}
	
	public byte getFatorBalanceamento() {
		return this.fatorBalanceamento;
	}
	
	public void setFatorBalanceamento(byte fatorBalanceamento) {
		this.fatorBalanceamento = fatorBalanceamento;
	}

}
