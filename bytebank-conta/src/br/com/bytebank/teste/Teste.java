package br.com.bytebank.teste;

import br.com.bytebank.modelo.*;

public class Teste {
	public static void main(String[] args) {
		Conta acc = new ContaCorrente(1, 123);
		acc.getPessoa().setNome("Robson");
		acc.getPessoa().setIdade(77);
		acc.getPessoa().setCpf("789.546.132-54");
		System.out.println(acc);
		System.out.println();
		
		Conta acc2 = new ContaCorrente(5, 852);
		acc2.getPessoa().setNome("Thiago");
		acc2.getPessoa().setIdade(40);
		acc2.getPessoa().setCpf("852.426.582-66");		
		
		
		
		Conta acc3 = new ContaPoupanca(7, 468);
		acc3.getPessoa().setNome("Ana");
		acc3.getPessoa().setIdade(25);
		acc3.getPessoa().setCpf("111.989.745-24");
		
		
		
		acc2.deposita(200);
		acc2.transfere(acc3, 10);
		
		System.out.println(acc2);
		System.out.println();
		System.out.println(acc3);
		
		
	}
}
