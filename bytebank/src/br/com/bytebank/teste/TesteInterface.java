package br.com.bytebank.teste;

import br.com.bytebank.modelo.*;

public class TesteInterface {

	public static void main(String[] args) {
		Gerente g = new Gerente();
		Administrador a = new Administrador();
		Cliente c = new Cliente();
		SistemaInterno si = new SistemaInterno();
		
		//TENTAR AUTENTICAR GERENTE
		g.setSenha(2322);
		boolean gerenteAutenticavel = si.autentica(g);
		System.out.println("Autenticou? " + gerenteAutenticavel);
		
		//TENTAR AUTENTETICAR ADMINISTRADOR
		a.setSenha(333);
		boolean administradorAutenticavel = si.autentica(a);
		System.out.println("Autenticou? " + administradorAutenticavel);
		
		//TENTAR AUTENTICAR CLIENTE
		c.setSenha(123);
		boolean clienteAutenticavel = si.autentica(c);
		System.out.println("Autenticou? " + clienteAutenticavel);
	}

}
