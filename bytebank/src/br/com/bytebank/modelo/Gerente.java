package br.com.bytebank.modelo;

public class Gerente extends Funcionario implements Autenticavel {

	AutenticadorSenha autentificador = new AutenticadorSenha();
	
	@Override
	public void setSenha(int senha)  {
		this.autentificador.setSenha(senha);
	}

	@Override
	public boolean autentica(int senha) {
		boolean resposta = this.autentificador.autentica(senha);
		return resposta;
	}
	
	@Override
	public double getBonificacao() {
		return super.getSalario();
	}



	
}
