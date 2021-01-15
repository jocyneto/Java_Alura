package br.com.bytebank.modelo;

public class ContaCorrente extends Conta implements Tributavel {
	
	
	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);
	}
	
	@Override
	public void saca(double valor) throws SaldoInsuficienteException {
		double totalASacr = valor+0.2;
		super.saca(totalASacr);
	}

	@Override
	public double getValorImposto() {
		return 10;
	}
	
}
