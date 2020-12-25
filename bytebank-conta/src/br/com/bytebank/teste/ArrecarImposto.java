package br.com.bytebank.teste;

import br.com.bytebank.modelo.*;

public class ArrecarImposto {

	public static void main(String[] args) {
		CalculadorImposto ci = new CalculadorImposto();
		
		Tributavel cc = new ContaCorrente(111, 123456);
		Tributavel ab = new AcaoBolsa();
		Tributavel sv = new SeguroDeVida();
		
		
		ci.arrecadarImposto(cc);
		ci.arrecadarImposto(ab);
		ci.arrecadarImposto(sv);
		
		System.out.println("Total de imposto arrecadado: " + ci.getTotalImposto());
		
		
		

	}

}
