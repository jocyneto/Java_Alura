package br.com.bytebank.modelo;

public interface Autenticavel {
	
	public void setSenha(int senha);
	
	
	public boolean autentica(int senha);
}
