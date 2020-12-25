package br.com.faesa.modelo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.faesa.arvore.Arvore;
import br.com.faesa.hashing.Hashing;

public class Gravacao {

	public void gravaArquivo(Cliente[] clientes, String[] listaCPF, Pesquisa tipo,String nomeArq) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArq));
		double saldoTotal = 0;
		int posicao;		
		for (int i = 0; i < listaCPF.length; i++) {
			posicao = tipo.pesqBinaria(clientes, 0, clientes.length, listaCPF[i]);			
			if(posicao != -1) {				
				bw.write(String.format("CPF %s \t NOME %s", clientes[posicao].getCPF()
														  , clientes[posicao].getNome()));
				bw.newLine();
				
				if(i > 0 && clientes[posicao-1].getCPF().compareTo(listaCPF[i]) == 0) {
					int posicaoProcurada = posicao-1;
					while (clientes[posicaoProcurada].getCPF().compareTo(listaCPF[i]) == 0) {
						bw.write(String.format("Ag: %s \t %s: %s \t Saldo: %s"	, clientes[posicaoProcurada].getAgencia()
																				, clientes[posicaoProcurada].getTipoConta()
																				, clientes[posicaoProcurada].getConta()
																				, clientes[posicaoProcurada].getSaldo()));
						bw.newLine();
						saldoTotal +=clientes[posicao].getSaldo();	
						posicaoProcurada--;
					}
				}
				
				bw.write(String.format("Ag: %s \t %s: %s \t Saldo: %s"	, clientes[posicao].getAgencia()
																		, clientes[posicao].getTipoConta()
																		, clientes[posicao].getConta()
																		, clientes[posicao].getSaldo()));
				bw.newLine();
				saldoTotal +=clientes[posicao].getSaldo();
				
				if((i < listaCPF.length-2) && (clientes[posicao+1].getCPF().compareTo(listaCPF[i]) == 0)) {
					int posicaoProcurada = posicao+1;
					while (clientes[posicaoProcurada].getCPF().compareTo(listaCPF[i]) == 0) {
						bw.write(String.format("Ag: %s \t %s: %s \t Saldo: %s"	, clientes[posicaoProcurada].getAgencia()
																				, clientes[posicaoProcurada].getTipoConta()
																				, clientes[posicaoProcurada].getConta()
																				, clientes[posicaoProcurada].getSaldo()));
						bw.newLine();
						saldoTotal +=clientes[posicao].getSaldo();	
						posicaoProcurada++;
					}
				}
				
				bw.write("Saldo Total: " + saldoTotal);
				saldoTotal = 0;
				bw.newLine();
				bw.newLine();				
			}else {				
				bw.write("CPF " + listaCPF[i]);
				bw.newLine();
				bw.write("NÃO HÁ NENHUMA CONTA COM O CPF");
				bw.newLine();
				bw.newLine();						
			}
		}
		bw.close();
	}
	
	public void gravaArquivo(Arvore arvoreCPF, Arvore arvoreCliente,List<Cliente> clientes ,List<Cliente> listaCPF, Pesquisa tipo,String nomeArq) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArq));				
		boolean validador;
		boolean validador2=false;
		int posicao=0;
		Cliente aux = new Cliente();
		List<Cliente> listAux = new LinkedList<Cliente>();
		
		for (int i = 0; i < listaCPF.size(); i++) {
			aux = new Cliente(listaCPF.get(i).getCPF());			
			listAux.add(aux);					
		}		
		
		for (int i = 0; i < listaCPF.size(); i++) {
			validador = tipo.pesquisaArvore(arvoreCliente, listaCPF.get(i));
							
			if(validador) {
				bw.write(String.format("CPF %s \t NOME %s",  clientes.get(i).getCPF()
						,  clientes.get(i).getNome()));
				bw.newLine();
				bw.write(String.format("Ag: %s \t %s: %s \t Saldo: %s",  clientes.get(i).getAgencia()
						,  clientes.get(i).getTipoConta()
						,  clientes.get(i).getConta()
						,  clientes.get(i).getSaldo()));
				bw.newLine();
				bw.write("Saldo Total: " +  clientes.get(i).getSaldo());
				bw.newLine();					
				bw.newLine();				
			}else {
				bw.write("CPF " + listaCPF.get(i).getCPF());
				bw.newLine();
				bw.write("NÃO HÁ NENHUMA CONTA COM O CPF");
				bw.newLine();
				bw.newLine();
			}

		}	

		bw.close();
	}
	
	public void gravaArquivo(String[] vetCpf,Hashing hashingCliente,String nomeArq) throws IOException{
		double saldoTotal = 0;
		List<Cliente> aux2;
		BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArq));
		for (int i = 0; i < vetCpf.length; i++) {			
			aux2 = hashingCliente.pesquisarNaListaContinua(vetCpf[i]);			
			if(!aux2.isEmpty()) {
				for (int j = 0; j < aux2.size(); j++) {
					if (j == 0) {
						bw.write(String.format("CPF %s \t NOME %s"	, aux2.get(j).getCPF()
																	, aux2.get(j).getNome()));
						bw.newLine();
					}
					bw.write(String.format("Ag: %s \t %s: %s \t Saldo: %s"	, aux2.get(j).getAgencia()
																			, aux2.get(j).getTipoConta()
																			, aux2.get(j).getConta()
																			, aux2.get(j).getSaldo()));
					bw.newLine();
					saldoTotal +=aux2.get(j).getSaldo();
					if(j == aux2.size()-1) {
						bw.write("Saldo Total: " + saldoTotal);
						saldoTotal = 0;
						bw.newLine();
						bw.newLine();
					}					
				}
			}else {
				bw.write("CPF " + vetCpf[i]);
				bw.newLine();
				bw.write("NÃO HÁ NENHUMA CONTA COM O CPF");
				bw.newLine();
				bw.newLine();
			}
		}
		bw.close();
	}
	
	
	
	
	
	
	
	
	
	//public void gravaArquivo(Cliente[] vetCliente, Hashing hashingCPF,Pesquisa tipo,String nomeArq) throws IOException
//	public void gravaArquivo(String[] vetCpf, Hashing hashingClientes,Pesquisa tipo,String nomeArq) throws IOException{
//		double saldoTotal = 0;
//		Cliente aux;
//		ArrayList<Cliente> lista = new ArrayList<Cliente>();
//		BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArq));
//		for (int i = 0; i < vetCpf.length; i++) {
//			aux = tipo.pesquisaHashing(hashingClientes, vetCpf[i]);
//			lista.add(aux);
//			if(aux != null) {
//				
//				bw.write(String.format("CPF %s \t NOME %s"	, aux.getCPF()
//						  									, aux.getNome()));
//				bw.newLine();
//			
//				bw.write(String.format("CPF %s \t NOME %s"	, aux.getCPF()
//							, aux.getNome()));
//				bw.newLine();
//				
//				bw.write(String.format("Ag: %s \t %s: %s \t Saldo: %s"	, aux.getAgencia()
//																		, aux.getTipoConta()
//																		, aux.getConta()
//																		, aux.getSaldo()));
//				bw.newLine();
//				saldoTotal +=aux.getSaldo();
//				
//								
//				
//				bw.write("Saldo Total: " + saldoTotal);
//				saldoTotal = 0;
//				bw.newLine();
//				bw.newLine();
//				
//				
//			}else {
//				bw.write("CPF " + vetCpf[i]);
//				bw.newLine();
//				bw.write("NÃO HÁ NENHUMA CONTA COM O CPF");
//				bw.newLine();
//				bw.newLine();	
//			}
//		}
//		bw.close();
//	}
	
	
	
}
