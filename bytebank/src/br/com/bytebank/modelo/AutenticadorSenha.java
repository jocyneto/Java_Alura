package br.com.bytebank.modelo;

public class AutenticadorSenha {
	private int senha;
	
	
	public void setSenha(int senha)  {
		this.senha = senha;
	}

	
	public boolean autentica(int senha) {
		if(senha == this.senha) {
			return true;
		}
		return false;
	}
}
