package br.com.jojomaster.modelo;

import java.util.ArrayList;

public class BancoDados {
	
	private static ArrayList<Chamado> listaDeChamados = new ArrayList<Chamado>();
	
	
	public void adicionar(Chamado chamado) {
		if(chamado != null) {
			BancoDados.listaDeChamados.add(chamado);
			Chamado.setId(Chamado.getId()+1);
		}		
	}

}
