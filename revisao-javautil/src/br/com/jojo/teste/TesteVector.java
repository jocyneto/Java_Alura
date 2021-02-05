package br.com.jojo.teste;

import java.util.Vector;

import br.com.bytebank.modelo.Conta;
import br.com.bytebank.modelo.ContaCorrente;

public class TesteVector {
	public static void main(String[] args) {
		Conta cc1 = new ContaCorrente(11, 22);
		Conta cc2 = new ContaCorrente(11, 33);
		Conta cc3 = new ContaCorrente(11, 44);
		
		//Threadsafe --> Vector s�o utilizados em opera��es multi-threads, pois � a �nica lista que se comporta de maneira certo em aplica��es multi-thread
		
		//Collection<Conta> listaVector = new Vector<Conta>();
		Vector<Conta> listaVector = new Vector<Conta>();
		listaVector.add(cc1);
		listaVector.add(cc2);
		listaVector.add(cc3);
		
		for (Conta conta : listaVector) {
			System.out.println(conta.getNumero());
		}
	}
}
