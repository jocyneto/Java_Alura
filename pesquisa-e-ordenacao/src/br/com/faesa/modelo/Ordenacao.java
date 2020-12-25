package br.com.faesa.modelo;

import java.util.List;

import br.com.faesa.arvore.Arvore;

public class Ordenacao {	
	private static int tam;
	private static Cliente[] vetor;

	//-------------------------------------------> QUICK SORT
	private int particiona(Cliente[] pessoa, int inicio, int termino) {
		Cliente pivo = pessoa[termino-1];
		int menores = 0;
		for (int analise = 0; analise < termino-1; analise++) {
			if (pessoa[analise].getCPF().compareTo(pivo.getCPF()) < 0) {
				troca(pessoa, analise, menores);
				menores++;
			}
			
			if (pessoa[analise].getCPF().compareTo(pivo.getCPF()) == 0 && pessoa[analise].getAgencia() < pivo.getAgencia()) {
				troca(pessoa, analise, menores);
				menores++;
			}
			
			if (pessoa[analise].getCPF().compareTo(pivo.getCPF()) == 0 && pessoa[analise].getAgencia() == pivo.getAgencia() && pessoa[analise].getConta() < pivo.getConta()) {
				troca(pessoa, analise, menores);
				menores++;
			}
			
		}
		troca(pessoa, termino-1, menores);
		return menores;
	}
	
	public void quickSort(Cliente[] pessoa, int de, int ate) {
		int elementos = ate - de;
		int posicaoPivo;
		if (elementos > 1) {
			posicaoPivo = particiona(pessoa, de, ate);
			quickSort(pessoa, de, posicaoPivo);
			quickSort(pessoa, posicaoPivo+1, ate);
		}		
	}
	
	private void troca(Cliente[] pessoa, int de, int para){
		Cliente pessoa1 = pessoa[de];
		Cliente pessoa2 = pessoa[para];
		pessoa[de] = pessoa2;
		pessoa[para] = pessoa1;
	}

	//-------------------------------------------> HEAPSORT
	public void heapSort(Cliente[] array) {
		vetor = array;          
		tam = vetor.length - 1; 

		constroiHeap();
		for (int i = tam; i > 0; i--) {
			troca(0, tam);      
			tam -= 1;           
			maxHeapifica(0);    
		}
	}

	private void constroiHeap() {
		int meio = (int) (tam/2);

		for (int i = meio - 1; i >= 0; i--) {
			maxHeapifica(i);
		}
	}

	private void troca(int i, int j) {
		Cliente aux;

		aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;
	}

	private void maxHeapifica(int pai) {
		int maior = pai,           
				esquerda = 2 * pai + 1,
				direita = 2 * pai + 2;

		if (esquerda <= tam) {
			if(vetor[esquerda].getCPF().compareTo(vetor[maior].getCPF()) > 0) {
				maior = esquerda;
			}else if(vetor[esquerda].getCPF().compareTo(vetor[maior].getCPF()) == 0){
				if(vetor[esquerda].getAgencia() > vetor[maior].getAgencia()) {
					maior = esquerda;
				} else if (vetor[esquerda].getAgencia() == vetor[maior].getAgencia()) {
					if(vetor[esquerda].getConta() > vetor[maior].getConta()) {
						maior = esquerda;
					}
				}
			}
		}
	
		if (direita <= tam) {
			if(vetor[direita].getCPF().compareTo(vetor[maior].getCPF()) > 0) {
				maior = direita;
			}else if(vetor[direita].getCPF().compareTo(vetor[maior].getCPF()) == 0){
				if(vetor[direita].getAgencia() > vetor[maior].getAgencia()) {
					maior = direita;
				} else if (vetor[direita].getAgencia() == vetor[maior].getAgencia()) {
					if(vetor[direita].getConta() > vetor[maior].getConta()) {
						maior = direita;
					}
				}
			}

		}
		
		
		if (maior != pai) {
			troca(pai, maior);
			maxHeapifica(maior);
		}
	}

	//----------------------------------------------------------------------------> ARVORE
	public List<Cliente> caminhamentoArvore(List<Cliente> lista, Arvore arv) {
		lista = arv.CamCentral(lista);		
		return lista;
	}

	public Arvore balancearArvore(List<Cliente> clientes, Arvore arv) {
		return arv.arvoreBalanceada(clientes);
	}
	

}
