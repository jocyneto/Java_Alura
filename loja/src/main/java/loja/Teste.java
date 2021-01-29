package loja;

import br.com.bytebank.modelo.Conta;
import br.com.bytebank.modelo.ContaCorrente;

public class Teste {

	public static void main(String[] args) {
		Conta c = new ContaCorrente(111,11);
		c.getAgencia();

	}

}
