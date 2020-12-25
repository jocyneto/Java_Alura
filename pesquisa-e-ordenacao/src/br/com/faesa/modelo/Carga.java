package br.com.faesa.modelo;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import br.com.faesa.arvore.Arvore;
import br.com.faesa.hashing.Hashing;

public class Carga {
	Cliente[] clientes;
	Hashing hashCliente;
	Cliente pessoa;
	Arvore arvore;
	
	
	public Cliente[] cargaVetorConta(String nomeArq, int tamanho) throws FileNotFoundException {
		String aux;
		String linha;		
		int posicaoIncial = 0;
		clientes = new Cliente[tamanho];
		Scanner scan = new Scanner(new FileReader(nomeArq));	
		Scanner linhaScan;
		
		
		while(scan.hasNextLine()) {				
			linha = scan.nextLine();
			linhaScan = new Scanner(linha);
			linhaScan.useLocale(Locale.US);
			linhaScan.useDelimiter(";");		
				
			clientes[posicaoIncial] = new Cliente();
			clientes[posicaoIncial].setCpf(linhaScan.next());
			clientes[posicaoIncial].setNome(linhaScan.next());			
			clientes[posicaoIncial].setAgencia(linhaScan.nextInt());
			clientes[posicaoIncial].setConta(linhaScan.nextInt());			
			clientes[posicaoIncial].setSaldo(linhaScan.nextDouble());
			aux = this.difinirTipoConta(clientes[posicaoIncial].getConta());
			clientes[posicaoIncial].setTipoConta(aux);
			posicaoIncial++;			
			
			linhaScan.close();			
		}
		scan.close();		
		return clientes;
	}


	private String difinirTipoConta(int conta) {			
		String contaStr = String.format("%08d", conta);
		switch (contaStr.charAt(2)) {
		case '0':
			return "Conta Poupanca";
		case '1':
			return "Conta Comum";
		case '2':
			return "Conta Especial";
		default:
			return "";
		}
		
	}
	
	public String[] cargaCPF() throws FileNotFoundException {
		String[] pessoa = new String[400];
		String linha;		
		int posicaoIncial = 0;
		Scanner scan = new Scanner(new FileReader("arq/Conta.txt"));	
		Scanner linhaScan;	
		
		while(scan.hasNextLine()) {			
			linha = scan.nextLine();
			linhaScan = new Scanner(linha);
			linhaScan.useLocale(Locale.US);
			linhaScan.useDelimiter(";");			
			
			
			pessoa[posicaoIncial] = linhaScan.next();	
			posicaoIncial++;			
			
			linhaScan.close();			
		}
		scan.close();
		this.ordena(pessoa, 0, pessoa.length);		
		return pessoa;
	}
	
	
	
	private int particiona(String[] cpf, int inicio, int termino) {
		String pivo = cpf[termino-1];
		int menores = 0;
		for (int analise = 0; analise < termino-1; analise++) {
			if (cpf[analise].compareTo(pivo) <= 0) {
				troca(cpf, analise, menores);
				menores++;
			}			
		}
		troca(cpf, termino-1, menores);
		return menores;
	}
	
	private void ordena(String[] cpf, int de, int ate) {
		int elementos = ate - de;
		int posicaoPivo;
		if (elementos > 1) {
			posicaoPivo = particiona(cpf, de, ate);
			ordena(cpf, de, posicaoPivo);
			ordena(cpf, posicaoPivo+1, ate);
		}		
	}
	
	private void troca(String[] cpf, int de, int para){
		String nota1 = cpf[de];
		String nota2 = cpf[para];
		cpf[de] = nota2;
		cpf[para] = nota1;
	}
	
	
	public Hashing CargaHash(String nomeArq, int tamanho) throws FileNotFoundException {
		String aux;
		String linha;		
		hashCliente = new Hashing(tamanho);
		Cliente c;
		Scanner scan = new Scanner(new FileReader(nomeArq));	
		Scanner linhaScan;
		
		
		while(scan.hasNextLine()) {				
			linha = scan.nextLine();
			linhaScan = new Scanner(linha);
			linhaScan.useLocale(Locale.US);
			linhaScan.useDelimiter(";");		
				
			c = new Cliente();
			c.setCpf(linhaScan.next());
			c.setNome(linhaScan.next());			
			c.setAgencia(linhaScan.nextInt());
			c.setConta(linhaScan.nextInt());			
			c.setSaldo(linhaScan.nextDouble());
			aux = this.difinirTipoConta(c.getConta());
			c.setTipoConta(aux);
			hashCliente.insere(c);
			
			linhaScan.close();			
		}
		scan.close();		
		return hashCliente;
	}
	
	public Hashing CargaHashCPF(String nomeArq) throws FileNotFoundException {		
		String linha;		
		hashCliente = new Hashing(400);
		Cliente c;
		Scanner scan = new Scanner(new FileReader(nomeArq));	
		Scanner linhaScan;
		
		
		while(scan.hasNextLine()) {				
			linha = scan.nextLine();
			linhaScan = new Scanner(linha);
			linhaScan.useLocale(Locale.US);		
				
			c = new Cliente();
			c.setCpf(linhaScan.next());			
			hashCliente.insere(c);
			
			linhaScan.close();			
		}
		scan.close();		
		return hashCliente;
	}
	
	
	public Arvore cargaArvore(String nomeArq) throws FileNotFoundException {
		String aux;
		String linha;		
		arvore = new Arvore();
		Cliente c;
		Scanner scan = new Scanner(new FileReader(nomeArq));	
		Scanner linhaScan;
		
		
		while(scan.hasNextLine()) {				
			linha = scan.nextLine();
			linhaScan = new Scanner(linha);
			linhaScan.useLocale(Locale.US);
			linhaScan.useDelimiter(";");		
				
			c = new Cliente();
			c.setCpf(linhaScan.next());
			c.setNome(linhaScan.next());			
			c.setAgencia(linhaScan.nextInt());
			c.setConta(linhaScan.nextInt());			
			c.setSaldo(linhaScan.nextDouble());
			aux = this.difinirTipoConta(c.getConta());
			c.setTipoConta(aux);
			arvore.insere(c);
			
			linhaScan.close();			
		}
		scan.close();		
		return arvore;
	}
	
	public Arvore cargaArvoreCPF() throws FileNotFoundException {
		String aux;
		String linha;		
		arvore = new Arvore();
		Cliente c;
		Scanner scan = new Scanner(new FileReader("arq/Conta.txt"));	
		Scanner linhaScan;
		
		
		while(scan.hasNextLine()) {				
			linha = scan.nextLine();
			linhaScan = new Scanner(linha);
			linhaScan.useLocale(Locale.US);
			linhaScan.useDelimiter(";");		
				
			c = new Cliente();
			c.setCpf(linhaScan.next());			
			arvore.insere(c);
			
			linhaScan.close();			
		}
		scan.close();		
		return arvore;
	}
	
}
