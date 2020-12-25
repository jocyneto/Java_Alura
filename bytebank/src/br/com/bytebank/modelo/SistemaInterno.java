package br.com.bytebank.modelo;

public class SistemaInterno {
	private int senha = 123;
	
	public boolean autentica(Autenticavel au) {
		boolean aut = au.autentica(senha);
		if(aut) {
			return true;
		}
		return false;
	}
}
