package br.com.bytebank.modelo;

public class ContaCorrente extends Conta implements Tributavel {
	
	
	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);
	}
	
	@Override
	public boolean saca(double valor) {
		double totalASacr = valor+0.2;
		return super.saca(totalASacr);
	}

	@Override
	public double getValorImposto() {
		return 10;
	}
	
}
