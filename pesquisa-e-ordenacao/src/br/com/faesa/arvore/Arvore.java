package br.com.faesa.arvore;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import br.com.faesa.modelo.Cliente;

public class Arvore {
	protected NoArvore raiz;	

	public Arvore(){
		this.raiz = null;
	} //métodos (inclusive os de inserção, remoção e pesquisa)


	public boolean pesquisa (Cliente cliente){
		NoArvore temp;

		temp = this.pesquisa (cliente, this.raiz);
		if (temp != null)
			return true;
		else
			return false;
	}

	private NoArvore pesquisa (Cliente cliente, NoArvore no){
		NoArvore temp;
		temp = no;

		if (temp != null){
			if (cliente.getCPF().compareTo(temp.getInfo().getCPF()) < 0)
				temp = this.pesquisa (cliente, temp.getEsq());
			else{
				if (cliente.getCPF().compareTo(temp.getInfo().getCPF()) > 0)
					temp = this.pesquisa (cliente, temp.getDir());
			}
		}
		return temp;
	}


	public void insere (Cliente cliente){
		boolean existe;

		existe = this.pesquisa (cliente);
		if (existe)
			return;
		else{
			this.raiz = this.insere (cliente, this.raiz);
			return;
		}
	}
	
	private NoArvore insere (Cliente cliente, NoArvore no){
		NoArvore novo;

		if (no == null){
			novo = new NoArvore(cliente);
			return novo;
		}
		else {
			if (cliente.getCPF().compareTo(no.getInfo().getCPF()) < 0){
				no.setEsq(this.insere (cliente, no.getEsq()));
				return no;
			}
			else{
				no.setDir(this.insere (cliente, no.getDir()));
				return no;
			}
		}
	}

	
	public List<Cliente> CamCentral (List<Cliente> vetOrdenado){
		return (this.FazCamCentral (this.raiz, vetOrdenado));
	}
	
	private List<Cliente> FazCamCentral (NoArvore arv, List<Cliente> vetOrdenado){
		if (arv != null) {
			vetOrdenado = this.FazCamCentral (arv.getEsq(), vetOrdenado);
			vetOrdenado.add (arv.getInfo());
			vetOrdenado = this.FazCamCentral (arv.getDir(), vetOrdenado);
		}
		return vetOrdenado;
	}
	
	
	public Arvore arvoreBalanceada (List<Cliente> listOrdenado){
		Arvore temp = new Arvore();
		this.balancear (listOrdenado, temp, 0, listOrdenado.size()-1);
		return temp;
	}


	private void balancear (List<Cliente> list, Arvore temp, int inic, int fim){
		int meio;
		if (fim >= inic){
			meio = (inic+fim)/2;
			temp.insere(list.get(meio));
			this.balancear (list, temp, inic, meio - 1);
			this.balancear (list, temp, meio + 1, fim);
		}
	}




}
