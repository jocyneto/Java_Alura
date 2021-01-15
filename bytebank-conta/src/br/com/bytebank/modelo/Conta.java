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
	
	public void saca(double valor) throws SaldoInsuficienteException {
		if(valor > this.saldo) {
			throw new SaldoInsuficienteException("Saldo insuficiente! " + "Saldo: " + this.saldo + " Valor querendo ser sacado: " + valor);
		}
		
		this.saldo -= valor;		
	}
	
	public void transfere(Conta destino, double valor) throws SaldoInsuficienteException {
		this.saca(valor);
		destino.deposita(valor);
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
