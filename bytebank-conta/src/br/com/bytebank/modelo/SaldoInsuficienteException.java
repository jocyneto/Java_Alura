package br.com.bytebank.modelo;

public class SaldoInsuficienteException extends Exception {
	public SaldoInsuficienteException(String mensagem) {
		super(mensagem);
	}
}
