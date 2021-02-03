package br.com.jojo.teste;

import java.util.ArrayList;

import br.com.bytebank.modelo.Conta;
import br.com.bytebank.modelo.ContaCorrente;

public class TesteArrayList {

	public static void main(String[] args) {
		
		ArrayList<Conta> lista = new ArrayList<Conta>();
		Conta cc1 = new ContaCorrente(11, 22);
		Conta cc2 = new ContaCorrente(11, 33);
		Conta cc3 = new ContaCorrente(11, 44);
		
		System.out.println("Tamanho: " + lista.size());
		
		lista.add(cc1);
		lista.add(cc2);
		lista.add(cc3);
		
		System.out.println("Tamanho: " + lista.size());
		
		for (Conta conta : lista) {
			System.out.println(conta.getNumero());
		}
		
		lista.remove(0);
		
		System.out.println("Tamanho: " + lista.size());
		
		for (Object conta : lista) {
			ContaCorrente cc = (ContaCorrente) conta;
			System.out.println(cc.getNumero());
		}
		
		System.out.println("------------");
		
		System.out.println(lista.get(0).getNumero());
		
		for(int i = 0; i < args.length; i++ ) {
			System.out.println(args[i]);
		}
		
		
	}
}
