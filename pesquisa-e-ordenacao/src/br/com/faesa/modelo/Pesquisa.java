package br.com.faesa.modelo;

import java.util.List;
import java.util.Set;

import br.com.faesa.arvore.Arvore;
import br.com.faesa.hashing.Hashing;

public class Pesquisa {	
	
//	public int pesqBinariaRecursisva (Cliente[] clientes, int de, int ate, String buscando){
//		int meio = (de+ate)/2;
//		String cpf = clientes[meio].getCPF();
//		if(buscando.compareTo(cpf) == 0) {
//			return meio;
//		}
//		if (buscando.compareTo(cpf) < 0) {
//			return pesqBinariaRecursisva(clientes, de, meio -1, buscando);
//		}else if (buscando.compareTo(cpf) > 0) {
//			return pesqBinariaRecursisva(clientes, meio+1, ate, buscando);
//		}
//		
//		return -1;
//	}
	
//	public int pesqBinaria (String[] cpfs, int de, int ate, String buscando){
//		int meio, esq, dir;
//		esq = 0;
//		dir = ate-1;
//		while (esq <= dir){
//			meio = (esq + dir)/2;
//			if (buscando.compareTo(cpfs[meio]) == 0)
//				return meio;
//			else{
//				if (buscando.compareTo(cpfs[meio]) < 0)
//					dir = meio - 1;
//				else
//					esq = meio + 1;
//			}
//		}
//		return -1;
//	}
	
	public int pesqBinaria (Cliente[] clientes, int de, int ate, String buscando){
		int meio, esq, dir;
		esq = 0;
		dir = ate-1;
		while (esq <= dir){
			meio = (esq + dir)/2;
			if (buscando.equals(clientes[meio].getCPF()))
				return meio;
			else if (buscando.compareTo(clientes[meio].getCPF()) < 0){
				dir = meio - 1;
			}else {
				esq = meio + 1;
			}
			
		}
		return -1;
	}
		
	public boolean pesquisaArvore(Arvore arvore, Cliente outroCliente){
		return arvore.pesquisa(outroCliente);
	}
	
	public Cliente pesquisaHashing(Hashing hash, String cpf) {
		return hash.getCliente(cpf);
	}
	
	
}
