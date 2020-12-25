package br.com.faesa.modelo;

public class Cliente {
	private String cpf;
	private String nome;
	private int conta;
	private int agencia;
	private double saldo;
	private String tipoConta;	
	
	public Cliente(String cpf, String nome, int conta, int agencia, double saldo, String tipoConta) {		
		this.cpf = cpf;
		this.nome = nome;
		this.conta = conta;
		this.agencia = agencia;
		this.saldo = saldo;
		this.tipoConta = tipoConta;
	}

	public Cliente(String cpf) {
		this.cpf = cpf;
	}
	
	public Cliente() {	}

	public String getTipoConta() {
		return tipoConta;
	}
	
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public String getCPF() {
		return cpf;
	}
	public String getNome() {
		return nome;
	}
	public int getConta() {
		return conta;
	}
	public int getAgencia() {
		return agencia;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public boolean equals(Object obj) {
		Cliente c = (Cliente) obj;
		if(c.cpf != null) {
			return this.cpf.equals(c.cpf);
		}
		return false;		
	}	
	
	@Override
	public int hashCode() {
		return this.cpf.hashCode();
	}
	
	
	@Override
	public String toString() {
		return String.format("%s;%s;%s;%08d;%s", this.cpf, this.nome, this.agencia, this.conta, this.saldo);
	}
	
}
