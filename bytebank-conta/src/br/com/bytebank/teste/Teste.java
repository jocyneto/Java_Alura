package br.com.bytebank.teste;

import br.com.bytebank.modelo.*;

public class Teste {
	public static void main(String[] args) {
		Conta acc = new ContaCorrente(1, 123);
		acc.getPessoa().setNome("Samira");
		acc.getPessoa().setIdade(27);
		acc.getPessoa().setCpf("789.546.132-54");
	
		
		Conta acc2 = new ContaCorrente(5, 852);
		acc2.getPessoa().setNome("Lucia");
		acc2.getPessoa().setIdade(40);
		acc2.getPessoa().setCpf("852.426.582-66");				
		
		
		Conta acc3 = new ContaPoupanca(7, 468);
		acc3.getPessoa().setNome("Joao");
		acc3.getPessoa().setIdade(25);
		acc3.getPessoa().setCpf("111.989.745-24");
		
		acc.deposita(200);
		
		try {
			acc.saca(300);
		} catch (SaldoInsuficienteException e) {
			e.printStackTrace();
		}
		
		System.out.println(acc);
		
	}
}
