package br.com.bytebank.modelo;

public abstract class Conta {
	private int numero;
	private int agencia;
	private double saldo;
	private Cliente pessoa;
	
	public Conta(int agencia, int numero) {
		this.agencia = agencia;
		this.numero = numero;
		pessoa = new Cliente();
	}
	
	public void deposita(double valor) {
		this.saldo += valor;
	}
	
	public boolean saca(double valor) {
		if(valor > this.saldo) {
			return false;
		}
		
		this.saldo -= valor;
		return true;
	}
	
	public boolean transfere(Conta destino, double valor) {
		if(this.saca(valor)) {
			destino.deposita(valor);
			return true;
		}
		return false;
	}
	
	
	public double getSaldo() {
		return saldo;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public Cliente getPessoa() {
		return pessoa;
	}
	
	@Override
	public String toString() {
		return String.format("Pessoa: %s"
							+"\nConta: Ag.: %s - Nº: %s - Saldo: %s"
							, this.pessoa
							, this.agencia
							,this.numero
							, this.saldo);
	}
	
}
