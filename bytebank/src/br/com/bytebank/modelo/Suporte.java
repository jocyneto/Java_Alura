package br.com.bytebank.modelo;

public class Suporte extends Funcionario {
	
	
	@Override
	public double getBonificacao() {
		return super.getSalario() * 0.1;
	}
}
