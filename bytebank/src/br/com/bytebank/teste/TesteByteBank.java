package br.com.bytebank.teste;

import br.com.bytebank.modelo.*;

public class TesteByteBank {
	public static void main(String[] args) {
		Funcionario f = new Suporte();
		f.setNome("Jô");
		f.setCpf("555.478.852-45");
		f.setSalario(2500.8);
		
		Gerente g = new Gerente();
		g.setNome("Ana");
		g.setCpf("941.013.580-01");
		g.setSalario(2500.8);
		
		Programador p = new Programador();
		p.setNome("Lucia");
		p.setCpf("985.740.930-09");
		p.setSalario(2500.8);
		
		Suporte s = new Suporte();
		s.setNome("Carlos");
		s.setCpf("650.004.380-43");
		s.setSalario(2500.8);
		
	}
}
