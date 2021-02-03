package br.com.jojomaster.modelo;

import java.util.ArrayList;
import java.util.Iterator;


public class BancoDados {
	
	private static ArrayList<Chamado> listaDeChamados = new ArrayList<Chamado>();
	private static Integer primarykey =1;
	
	
	public void adicionar(Chamado chamado) {
		if(chamado != null) {
			BancoDados.listaDeChamados.add(chamado);
			chamado.setId(primarykey++);
		}		
	}


	public ArrayList pegaListaDeChamados() {		
		return BancoDados.listaDeChamados;
	}


	public Chamado pegaEmpresaID(Integer id) {
		for (Chamado chamado : BancoDados.listaDeChamados) {
			if(chamado.getId() == id) {
				return chamado;
			}
		}
		return null;
	}
	
	public void removeChamado(Integer id) {
		Iterator<Chamado> it = listaDeChamados.iterator();		
		while(it.hasNext()) {
			Chamado chamado = it.next();
			if(chamado.getId() == id) {
				it.remove();
			}
		}
		
	}

}
