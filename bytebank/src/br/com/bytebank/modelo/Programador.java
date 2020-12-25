package br.com.bytebank.modelo;

public class Programador extends Funcionario{
	
	@Override
	public double getBonificacao() {
		return super.getSalario() * 0.3;
	}
}
