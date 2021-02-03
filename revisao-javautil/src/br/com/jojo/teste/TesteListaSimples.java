package br.com.jojo.teste;

import br.com.bytebank.modelo.ContaCorrente;
import br.com.jojo.modelo.ListaSimples;

public class TesteListaSimples {
	public static void main(String[] args) {
		
		ContaCorrente cc1 = new ContaCorrente(11, 22);
		ContaCorrente cc2 = new ContaCorrente(11, 33);
		ContaCorrente cc3 = new ContaCorrente(11, 44);
		ListaSimples lista = new ListaSimples();
		
		System.out.println("Tamanho: " + lista.tamanho());
		
		lista.adiciona(cc1);
		lista.adiciona(cc2);
		lista.adiciona(cc3);
		
		System.out.println("Tamanho: " + lista.tamanho());
		
		ContaCorrente ccc = (ContaCorrente) lista.getConta(0);
		ContaCorrente ccc2 = (ContaCorrente) lista.getConta(1);
		ContaCorrente ccc3 = (ContaCorrente) lista.getConta(2);
		
		System.out.println("CC1: " + ccc.getNumero());
		System.out.println("CC2: " + ccc2.getNumero());
		System.out.println("CC3: " + ccc3.getNumero());
		

	}
}
