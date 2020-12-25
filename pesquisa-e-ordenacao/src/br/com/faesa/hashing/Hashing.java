package br.com.faesa.hashing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.faesa.modelo.Cliente;

public class Hashing {
	private List<Cliente>[] tabela;
	private int tamanho;
	List<Cliente> lista = new LinkedList<Cliente>();
	
	public Hashing(int tamanhoLista) {
		this.tamanho = this.calcularTamanhoColunaHashing(tamanhoLista);
		this.tabela = new LinkedList[tamanho];
	}
		
	public void insere(Cliente elemento) {		
		int posicaoDeInsercao = this.calcularInsercao(elemento.getCPF());//elemento mod tamanho
		if(tabela[posicaoDeInsercao] == null) {
			tabela[posicaoDeInsercao] = new LinkedList<Cliente>();
			tabela[posicaoDeInsercao].add(elemento);
		}else {
			tabela[posicaoDeInsercao].add(elemento);
		}		
	}
	
	private int calcularInsercao(String cpf) {
		int valorDoHashing = this.insereCaracter(cpf);
		return valorDoHashing % this.tamanho;
	}
	
	private int insereCaracter (String cpf){
		char carac;
		int i, soma=0;
		for (i=0; i<cpf.length(); i++){
			carac = cpf.charAt(i);
			soma += Character.getNumericValue(carac);
		}
		return soma;
	}
	
	//fazer tratamento de null
	public int pesquisarNaTabela(String cpf) {
		if(cpf == null) {
			return -1;
		}
		int posicaoDeInsercao = calcularInsercao(cpf);
		return posicaoDeInsercao;
	}
	//fazer tratamento de null
	public int pesquisarNaLista(String cpf) {		
		int index = this.pesquisarNaTabela(cpf);
		if(tabela[index] == null) {
			return -1;
		}
		for (int i = 0; i < tabela[index].size(); i++) {			
			if(cpf.compareTo(tabela[index].get(i).getCPF()) == 0) {
				return i;
			}
		}
		return -1;//caso nao encontrar
	}
	
	public List<Cliente> pesquisarNaListaContinua(String cpf) {		
		int contador = 0;
		int index = this.pesquisarNaTabela(cpf);
		List<Cliente> c = new LinkedList<Cliente>();
		if(tabela[index] == null) {
			return c;
		}
		while ( contador < tabela[index].size()) {			
			if(cpf.compareTo(tabela[index].get(contador).getCPF()) == 0) {
				c.add(tabela[index].get(contador));
			}
			contador++;
		}
		
		return c;
	}
	
	
	
	public int tamanho() {
		return this.tamanho;
	}
	
	public Cliente getCliente(String cpf) {
		int posicaoTabela = this.pesquisarNaTabela(cpf);
		int posicaoLista = this.pesquisarNaLista(cpf);	
		if(posicaoLista == -1 || posicaoTabela == -1) {
			return null;
		}
		return tabela[posicaoTabela].get(posicaoLista);				
	}
	
	public Cliente getCliente(String cpf, int inicio, int fim) {
		int posicaoTabela = this.pesquisarNaTabela(cpf);
		int posicaoLista = this.pesquisarNaLista(cpf);	
		if(posicaoLista == -1 || posicaoTabela == -1) {
			return null;
		}
		return tabela[posicaoTabela].get(posicaoLista);				
	}
	
	
	
	/*
	 * calcularTamanhoColunaHashing e ehPrimo faz o calculo do tamanho do Hashing
	 * */
	private int calcularTamanhoColunaHashing(int tamanhoLista) {
		int numeroPrimo = ((int) (tamanhoLista*1.1));
		while(!this.ehPrimo(numeroPrimo)) {			
			numeroPrimo++;
		}
		return	numeroPrimo;
	}
	
	private boolean ehPrimo(int numero) {
	    for (int j = 2; j < numero; j++) {	    	
	        if (numero % j == 0)
	            return false;   
	    }
	    return true;
	}
}
