package br.com.faesa.interfacegrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.faesa.arvore.Arvore;
import br.com.faesa.arvore.ArvoreVL;
import br.com.faesa.hashing.Hashing;
import br.com.faesa.modelo.Carga;
import br.com.faesa.modelo.Cliente;
import br.com.faesa.modelo.Gravacao;
import br.com.faesa.modelo.Ordenacao;
import br.com.faesa.modelo.Pesquisa;

import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Color;

public class FormPrincipal extends JFrame {
	private String[] arrayCPF = new String[400];
	private Cliente[] cliente500 = new Cliente[500];
	private Cliente[] cliente1k = new Cliente[1000];
	private Cliente[] cliente5k = new Cliente[5000];
	private Cliente[] cliente10k = new Cliente[10000];
	private Cliente[] cliente50k = new Cliente[50000];
	private Arvore arv = new Arvore();
	private Arvore arvCPF = new Arvore();
	private List<Cliente> listaClientes = new LinkedList<Cliente>(); 
	private List<Cliente> listaCPF = new LinkedList<Cliente>();
	private Hashing hClientes = new Hashing(500);
	private Carga carga = new Carga();
	private Ordenacao ordem = new Ordenacao();
	private Pesquisa pesq = new Pesquisa();
	private Gravacao grava = new Gravacao();
	private JPanel contentPane;
	//private int valor =0;
	JFrame frame = new JFrame("Mensagem de aviso de geração.");
	
	
	/**
	 * @author jocyn
	 * Create the frame.
	 */
	public FormPrincipal() {
		this.setTitle("Trabalho da Cinthia LPOO/POO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGeral = new JLabel("GERAL");
		lblGeral.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGeral.setBounds(241, 11, 46, 14);
		contentPane.add(lblGeral);
		
		JButton btnImprimirTodos = new JButton("Imprimir todos");
		btnImprimirTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {					
					executaTodosHEAP();
					executaTodosQUICK();
					executaTodosABB();
					executaTodosAVL();
					executaTodosHASHING();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", //mensagem
					        "ERRO", // titulo da janela 
					        JOptionPane.ERROR_MESSAGE);	
				}
				JOptionPane.showMessageDialog(frame,
				        "Concluído", 
				        "Rotina Finalizada", 
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnImprimirTodos.setBounds(198, 29, 131, 23);
		contentPane.add(btnImprimirTodos);
		
		JLabel lblHeapsort = new JLabel("HEAPSORT");
		lblHeapsort.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHeapsort.setBounds(21, 77, 79, 14);
		contentPane.add(lblHeapsort);
		
		JLabel lblQuicksort = new JLabel("QUICKSORT");
		lblQuicksort.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuicksort.setBounds(126, 77, 79, 14);
		contentPane.add(lblQuicksort);
		
		JLabel lblAbb = new JLabel("ABB");
		lblAbb.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAbb.setBounds(227, 77, 66, 14);
		contentPane.add(lblAbb);
		
		JLabel lblAvl = new JLabel("AVL");
		lblAvl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAvl.setBounds(321, 77, 79, 14);
		contentPane.add(lblAvl);
		
		JLabel lblHashingEncadeado = new JLabel("HASHING ENC.");
		lblHashingEncadeado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHashingEncadeado.setBounds(421, 77, 86, 14);
		contentPane.add(lblHashingEncadeado);
		
		JButton btnHeap500 = new JButton("500");
		btnHeap500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					executaProcessoHeap(cliente500, arrayCPF, carga, ordem , pesq, grava
							, "arq/conta500ord.txt"
							, "arq_ger/HEAPORD500.txt");
					
					executaProcessoHeap(cliente500, arrayCPF, carga, ordem, pesq, grava
							, "arq/conta500inv.txt"
							, "arq_ger/HEAPINV500.txt");
					
					executaProcessoHeap(cliente500, arrayCPF, carga, ordem, pesq, grava
							, "arq/conta500alea.txt"
							, "arq_ger/HEAPALE500.txt");
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO", 
					        JOptionPane.ERROR_MESSAGE);	
				}				
				JOptionPane.showMessageDialog(frame,
				        "Arquivos HEAP 500 Gerados", 
				        "Geração concluída",  
				        JOptionPane.INFORMATION_MESSAGE);
				
				
			}
		});
		btnHeap500.setBounds(21, 102, 66, 23);
		contentPane.add(btnHeap500);
		
		JButton btnHeap1000 = new JButton("1000");
		btnHeap1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoHeap(cliente1k, arrayCPF, carga,ordem , pesq, grava
							, "arq/conta1000ord.txt"
							, "arq_ger/HEAPORD1000.txt");
					executaProcessoHeap(cliente1k, arrayCPF, carga,ordem, pesq , grava
							, "arq/conta1000inv.txt"
							, "arq_ger/HEAPINV1000.txt");
					executaProcessoHeap(cliente1k, arrayCPF, carga,ordem, pesq , grava
							, "arq/conta1000alea.txt"
							, "arq_ger/HEAPALE1000.txt");
				}catch(Exception a){
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",  
					        JOptionPane.ERROR_MESSAGE);	
				}	
				JOptionPane.showMessageDialog(frame,
				        "Arquivo HEAP 1000 Gerado", 
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		btnHeap1000.setBounds(21, 130, 66, 23);
		contentPane.add(btnHeap1000);
		
		JButton btnHeap5000 = new JButton("5000");
		btnHeap5000.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoHeap(cliente5k, arrayCPF, carga,ordem , pesq, grava
							, "arq/conta5000ord.txt"
							, "arq_ger/HEAPORD5000.txt");
					executaProcessoHeap(cliente5k, arrayCPF, carga,ordem, pesq , grava
							, "arq/conta5000inv.txt"
							, "arq_ger/HEAPINV5000.txt");
					executaProcessoHeap(cliente5k, arrayCPF, carga,ordem, pesq , grava
							, "arq/conta5000alea.txt"
							, "arq_ger/HEAPALE5000.txt");
				}catch(Exception a){
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(frame,
				        "Arquivo HEAP 5000 Gerado",
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		btnHeap5000.setBounds(21, 158, 66, 23);
		contentPane.add(btnHeap5000);
		
		JButton btnHeap10000 = new JButton("10000");
		btnHeap10000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoHeap(cliente10k, arrayCPF, carga,ordem , pesq, grava
							, "arq/conta10000ord.txt"
							, "arq_ger/HEAPORD10000.txt");
					executaProcessoHeap(cliente10k, arrayCPF, carga,ordem, pesq , grava
							, "arq/conta10000inv.txt"
							, "arq_ger/HEAPINV10000.txt");
					executaProcessoHeap(cliente10k, arrayCPF, carga,ordem, pesq , grava
							, "arq/conta10000alea.txt"
							, "arq_ger/HEAPALE10000.txt");
				}catch(Exception a){
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO", 
					        JOptionPane.ERROR_MESSAGE);	
				}
				
				
				JOptionPane.showMessageDialog(frame,
				        "Arquivo HEAP 10000 Gerado", 
				        "Geração concluída",
				        JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		btnHeap10000.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnHeap10000.setBounds(21, 186, 66, 23);
		contentPane.add(btnHeap10000);
		
		JButton btnHeap50000 = new JButton("50000");
		btnHeap50000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoHeap(cliente50k, arrayCPF, carga,ordem , pesq, grava
							, "arq/conta50000ord.txt"
							, "arq_ger/HEAPORD50000.txt");
					executaProcessoHeap(cliente50k, arrayCPF, carga,ordem, pesq , grava
							, "arq/conta50000inv.txt"
							, "arq_ger/HEAPINV50000.txt");
					executaProcessoHeap(cliente50k, arrayCPF, carga,ordem, pesq , grava
							, "arq/conta50000alea.txt"
							, "arq_ger/HEAPALE50000.txt");
				}catch(Exception a){
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO", 
					        JOptionPane.ERROR_MESSAGE);	
				}
				JOptionPane.showMessageDialog(frame,
				        "Arquivo HEAP 50000 Gerado", 
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		btnHeap50000.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnHeap50000.setBounds(21, 214, 66, 23);
		contentPane.add(btnHeap50000);
		
		JButton btnQuick500 = new JButton("500");
		btnQuick500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoQuick(cliente500, arrayCPF, carga, ordem, pesq , grava
										, "arq/conta500ord.txt"
										, "arq_ger/QUICKORD500.txt");
					
					executaProcessoQuick(cliente500, arrayCPF, carga, ordem, pesq , grava
										, "arq/conta500inv.txt"
										, "arq_ger/QUICKINV500.txt");
					
					executaProcessoQuick(cliente500, arrayCPF, carga, ordem, pesq , grava
										, "arq/conta500alea.txt"
										, "arq_ger/QUICKALE500.txt");
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);	
				}
				JOptionPane.showMessageDialog(frame,
				        "Arquivo QUICK 500 Gerado",
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		btnQuick500.setBounds(126, 102, 66, 23);
		contentPane.add(btnQuick500);
		
		JButton btnQuick1000 = new JButton("1000");
		btnQuick1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoQuick(cliente1k, arrayCPF, carga, ordem, pesq , grava
										, "arq/conta1000ord.txt"
										, "arq_ger/QUICKORD1000.txt");
					
					executaProcessoQuick(cliente1k, arrayCPF, carga, ordem, pesq , grava
										, "arq/conta1000inv.txt"
										, "arq_ger/QUICKINV1000.txt");
					
					executaProcessoQuick(cliente1k, arrayCPF, carga, ordem, pesq , grava
										, "arq/conta1000alea.txt"
										, "arq_ger/QUICKALE1000.txt");
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);	
				}		
				JOptionPane.showMessageDialog(frame,
				        "Arquivo QUICK 1000 Gerado",
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnQuick1000.setBounds(126, 130, 66, 23);
		contentPane.add(btnQuick1000);
		
		JButton btnQuick5000 = new JButton("5000");
		btnQuick5000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoQuick(cliente5k, arrayCPF, carga, ordem, pesq , grava
										, "arq/conta5000ord.txt"
										, "arq_ger/QUICKORD5000.txt");
					
					executaProcessoQuick(cliente5k, arrayCPF, carga, ordem, pesq , grava
										, "arq/conta5000inv.txt"
										, "arq_ger/QUICKINV5000.txt");
					
					executaProcessoQuick(cliente5k, arrayCPF, carga, ordem, pesq , grava
										, "arq/conta5000alea.txt"
										, "arq_ger/QUICKALE5000.txt");
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);	
				}		
				JOptionPane.showMessageDialog(frame,
				        "Arquivo QUICK 5000 Gerado",
				        "Geração concluída",  
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnQuick5000.setBounds(126, 158, 66, 23);
		contentPane.add(btnQuick5000);
		
		JButton btnQuick10000 = new JButton("10000");
		btnQuick10000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoQuick(cliente10k, arrayCPF, carga, ordem, pesq , grava
										, "arq/conta10000ord.txt"
										, "arq_ger/QUICKORD10000.txt");
					
					executaProcessoQuick(cliente10k, arrayCPF, carga, ordem, pesq , grava
										, "arq/conta10000inv.txt"
										, "arq_ger/QUICKINV10000.txt");
					
					executaProcessoQuick(cliente10k, arrayCPF, carga, ordem, pesq , grava
										, "arq/conta10000alea.txt"
										, "arq_ger/QUICKALE10000.txt");
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);	
				}		
				JOptionPane.showMessageDialog(frame,
				        "Arquivo QUICK 10000 Gerado",
				        "Geração concluída",
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnQuick10000.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnQuick10000.setBounds(126, 186, 66, 23);
		contentPane.add(btnQuick10000);
		
		JButton btnQuick50000 = new JButton("50000");
		btnQuick50000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoQuick(cliente50k, arrayCPF, carga, ordem, pesq , grava
										, "arq/conta50000ord.txt"
										, "arq_ger/QUICKORD50000.txt");
					
					executaProcessoQuick(cliente50k, arrayCPF, carga, ordem, pesq , grava
										, "arq/conta50000inv.txt"
										, "arq_ger/QUICKINV50000.txt");
					
					executaProcessoQuick(cliente50k, arrayCPF, carga, ordem, pesq , grava
										, "arq/conta50000alea.txt"
										, "arq_ger/QUICKALE50000.txt");
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);	
				}	
				JOptionPane.showMessageDialog(frame,
				        "Arquivo QUICK 50000 Gerado", 
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnQuick50000.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnQuick50000.setBounds(126, 214, 66, 23);
		contentPane.add(btnQuick50000);
		
		JButton btnAbb500 = new JButton("500");
		btnAbb500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta500ord.txt"
							, "arq_ger/ABBORD500.txt");
					
					executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta500inv.txt"
							, "arq_ger/ABBINV500.txt");
					
					executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta500alea.txt"
							, "arq_ger/ABBALE500.txt");
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(frame,
				        "Arquivo ABB 500 Gerado", 
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAbb500.setBounds(227, 102, 66, 23);
		contentPane.add(btnAbb500);
		
		JButton btnAbb1000 = new JButton("1000");
		btnAbb1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta1000ord.txt"
							, "arq_ger/ABBORD1000.txt");
					
					executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta1000inv.txt"
							, "arq_ger/ABBINV1000.txt");
					
					executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta1000alea.txt"
							, "arq_ger/ABBALE1000.txt");
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);
				}	
				JOptionPane.showMessageDialog(frame,
				        "Arquivo ABB 1000 Gerado", 
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAbb1000.setBounds(227, 130, 66, 23);
		contentPane.add(btnAbb1000);
		
		JButton btnAbb5000 = new JButton("5000");
		btnAbb5000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta5000ord.txt"
							, "arq_ger/ABBORD5000.txt");
					
					executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta5000inv.txt"
							, "arq_ger/ABBINV5000.txt");
					
					executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta5000alea.txt"
							, "arq_ger/ABBALE5000.txt");
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(frame,
				        "Arquivo ABB 5000 Gerado",
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAbb5000.setBounds(227, 158, 66, 23);
		contentPane.add(btnAbb5000);
		
		JButton btnAbb10000 = new JButton("10000");
		btnAbb10000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta10000ord.txt"
							, "arq_ger/ABBORD10000.txt");
					
					executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta10000inv.txt"
							, "arq_ger/ABBINV10000.txt");
					
					executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta10000alea.txt"
							, "arq_ger/ABBALE10000.txt");
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(frame,
				        "Arquivo ABB 10000 Gerado", 
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAbb10000.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAbb10000.setBounds(227, 186, 66, 23);
		contentPane.add(btnAbb10000);
		
		JButton btnAbb50000 = new JButton("50000");
		btnAbb50000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta50000ord.txt"
							, "arq_ger/ABBORD50000.txt");
					
					executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta50000inv.txt"
							, "arq_ger/ABBINV50000.txt");
					
					executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta50000alea.txt"
							, "arq_ger/ABBALE50000.txt");
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(frame,
				        "Arquivo ABB 50000 Gerado", 
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAbb50000.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAbb50000.setBounds(227, 214, 66, 23);
		contentPane.add(btnAbb50000);
		
		JButton btnAvl500 = new JButton("500");
		btnAvl500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta500ord.txt"
							, "arq_ger/AVLORD500.txt");
					
					executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta500inv.txt"
							, "arq_ger/AVLINV500.txt");
					
					executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta500alea.txt"
							, "arq_ger/AVLALE500.txt");
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(frame,
				        "Arquivo AVL 500 Gerado", 
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAvl500.setBounds(321, 102, 66, 23);
		contentPane.add(btnAvl500);
		
		JButton btnAvl1000 = new JButton("1000");
		btnAvl1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta1000ord.txt"
							, "arq_ger/AVLORD1000.txt");
					
					executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta1000inv.txt"
							, "arq_ger/AVLINV1000.txt");
					
					executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta1000alea.txt"
							, "arq_ger/AVLALE1000.txt");
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(frame,
				        "Arquivo AVL 1000 Gerado",
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAvl1000.setBounds(321, 130, 66, 23);
		contentPane.add(btnAvl1000);
		
		JButton btnAvl5000 = new JButton("5000");
		btnAvl5000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta5000ord.txt"
							, "arq_ger/AVLORD5000.txt");
					
					executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta5000inv.txt"
							, "arq_ger/AVLINV5000.txt");
					
					executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta5000alea.txt"
							, "arq_ger/AVLALE5000.txt");
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(frame,
				        "Arquivo AVL 5000 Gerado", 
				        "Geração concluída",
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAvl5000.setBounds(321, 158, 66, 23);
		contentPane.add(btnAvl5000);
		
		JButton btnAvl10000 = new JButton("10000");
		btnAvl10000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta10000ord.txt"
							, "arq_ger/AVLORD10000.txt");
					
					executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta10000inv.txt"
							, "arq_ger/AVLINV10000.txt");
					
					executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta10000alea.txt"
							, "arq_ger/AVLALE10000.txt");
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(frame,
				        "Arquivo AVL 10000 Gerado", 
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAvl10000.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAvl10000.setBounds(321, 186, 66, 23);
		contentPane.add(btnAvl10000);
		
		JButton btnAvl50000 = new JButton("50000");
		btnAvl50000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta50000ord.txt"
							, "arq_ger/AVLORD50000.txt");
					
					executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta50000inv.txt"
							, "arq_ger/AVLINV50000.txt");
					
					executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
							, "arq/conta50000alea.txt"
							, "arq_ger/AVLALE50000.txt");
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(frame,
				        "Arquivo AVL 50000 Gerado", 
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAvl50000.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAvl50000.setBounds(321, 214, 66, 23);
		contentPane.add(btnAvl50000);
		
		JButton btnHash500 = new JButton("500");
		btnHash500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
											,"arq/conta500ord.txt"
											,"arq_ger/HASHORD500.txt", 500);
					executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
											,"arq/conta500inv.txt"
											,"arq_ger/HASHINV500.txt", 500);
					executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
											,"arq/conta500alea.txt"
											,"arq_ger/HASHALE500.txt", 500);
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);
				}	
				JOptionPane.showMessageDialog(frame,
				        "Arquivo Hashing Enc. 500 Gerado", 
				        "Geração concluída",  
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnHash500.setBounds(421, 102, 66, 23);
		contentPane.add(btnHash500);
		
		JButton btnHash1000 = new JButton("1000");
		btnHash1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
											,"arq/conta1000ord.txt"
											,"arq_ger/HASHORD1000.txt",1000);
					executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
											,"arq/conta1000inv.txt"
											,"arq_ger/HASHINV1000.txt",1000);
					executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
											,"arq/conta1000alea.txt"
											,"arq_ger/HASHALE1000.txt",1000);
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(frame,
				        "Arquivo Hashing Enc. 1000 Gerado", 
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnHash1000.setBounds(421, 130, 66, 23);
		contentPane.add(btnHash1000);
		
		JButton btnHash5000 = new JButton("5000");
		btnHash5000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
											,"arq/conta5000ord.txt"
											,"arq_ger/HASHORD5000.txt",5000);
					executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
											,"arq/conta5000inv.txt"
											,"arq_ger/HASHINV5000.txt",5000);
					executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
											,"arq/conta5000alea.txt"
											,"arq_ger/HASHALE5000.txt",5000);
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(frame,
				        "Arquivo Hashing Enc. 5000 Gerado", 
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnHash5000.setBounds(421, 158, 66, 23);
		contentPane.add(btnHash5000);
		
		JButton btnHash10000 = new JButton("10000");
		btnHash10000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
											,"arq/conta10000ord.txt"
											,"arq_ger/HASHORD10000.txt",10000);
					executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
											,"arq/conta10000inv.txt"
											,"arq_ger/HASHINV10000.txt",10000);
					executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
											,"arq/conta10000alea.txt"
											,"arq_ger/HASHALE10000.txt",10000);
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(frame,
				        "Arquivo Hashing Enc. 10000 Gerado", 
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnHash10000.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnHash10000.setBounds(421, 186, 66, 23);
		contentPane.add(btnHash10000);
		
		JButton btnHash50000 = new JButton("50000");
		btnHash50000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					executaProcessoHashing(arrayCPF, hClientes, carga, ordem, grava, pesq
											,"arq/conta50000ord.txt"
											,"arq_ger/HASHORD50000.txt",50000);
					executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
											,"arq/conta50000inv.txt"
											,"arq_ger/HASHINV50000.txt",50000);
					executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
											,"arq/conta50000alea.txt"
											,"arq_ger/HASHALE50000.txt",50000);
				}catch(Exception a) {
					JOptionPane.showMessageDialog(frame,
					        "ERRO NA GERAÇÃO DO ARQUIVO", 
					        "ERRO",
					        JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(frame,
				        "Arquivo Hashing Enc. 50000 Gerado", 
				        "Geração concluída", 
				        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnHash50000.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnHash50000.setBounds(421, 214, 66, 23);
		contentPane.add(btnHash50000);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(219, 258, 89, 23);
		contentPane.add(btnSair);
		
		
		
		
		
		
		
		
		
	}
	
	protected void executaTodosHASHING() {
		
		try {
			
			executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
									,"arq/conta500ord.txt"
									,"arq_ger/HASHORD500.txt",500);
			executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
									,"arq/conta500inv.txt"
									,"arq_ger/HASHINV500.txt",500);
			executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
									,"arq/conta500alea.txt"
									,"arq_ger/HASHALE500.txt",500);
			
			
			executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
									,"arq/conta1000ord.txt"
									,"arq_ger/HASHORD1000.txt",1000);
			executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
									,"arq/conta1000inv.txt"
									,"arq_ger/HASHINV1000.txt",1000);
			executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
									,"arq/conta1000alea.txt"
									,"arq_ger/HASHALE1000.txt",1000);
			
			
			executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
									,"arq/conta5000ord.txt"
									,"arq_ger/HASHORD5000.txt",5000);
			executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
									,"arq/conta5000inv.txt"
									,"arq_ger/HASHINV5000.txt",5000);
			executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
									,"arq/conta5000alea.txt"
									,"arq_ger/HASHALE5000.txt",5000);
			
			
			executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
									,"arq/conta10000ord.txt"
									,"arq_ger/HASHORD10000.txt",10000);
			executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
									,"arq/conta10000inv.txt"
									,"arq_ger/HASHINV10000.txt",10000);
			executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
									,"arq/conta10000alea.txt"
									,"arq_ger/HASHALE10000.txt",10000);
			
			
			executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
									,"arq/conta50000ord.txt"
									,"arq_ger/HASHORD50000.txt",50000);
			executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
									,"arq/conta50000inv.txt"
									,"arq_ger/HASHINV50000.txt",50000);
			executaProcessoHashing( arrayCPF, hClientes, carga, ordem, grava, pesq
									,"arq/conta50000alea.txt"
									,"arq_ger/HASHALE50000.txt",50000);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame,
			        "ERRO NA GERAÇÃO DO ARQUIVO HASHING", 
			        "ERRO", 
			        JOptionPane.ERROR_MESSAGE);
		}
		
	}

	protected void executaTodosAVL() {
		try {
			executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta500ord.txt"
								, "arq_ger/AVLORD500.txt");
			executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta500inv.txt"
								, "arq_ger/AVLINV500.txt");
			executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta500alea.txt"
								, "arq_ger/AVLALE500.txt");
			
			executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta1000ord.txt"
								, "arq_ger/AVLORD1000.txt");
			executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta1000inv.txt"
								, "arq_ger/AVLINV1000.txt");
			executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta1000alea.txt"
								, "arq_ger/AVLALE1000.txt");
			
			executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta5000ord.txt"
								, "arq_ger/AVLORD5000.txt");
			executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta5000inv.txt"
								, "arq_ger/AVLINV5000.txt");
			executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta5000alea.txt"
								, "arq_ger/AVLALE5000.txt");
			
			executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta10000ord.txt"
								, "arq_ger/AVLORD10000.txt");
			executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta10000inv.txt"
								, "arq_ger/AVLINV10000.txt");
			executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta10000alea.txt"
								, "arq_ger/AVLALE10000.txt");
			/*NOTE: PARA NÃO ESTOURAR O STACK OVER FLOW
			executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta50000ord.txt"
								, "arq_ger/AVLORD50000.txt");
			executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta50000inv.txt"
								, "arq_ger/AVLINV50000.txt");
			executaProcessoAVL(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta50000alea.txt"
								, "arq_ger/AVLALE50000.txt");*/
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame,
			        "ERRO NA GERAÇÃO DO ARQUIVO AVL",
			        "ERRO", 
			        JOptionPane.ERROR_MESSAGE);
		}
		
	}

	protected void executaTodosABB() {
		try {
			executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta500ord.txt"
								, "arq_ger/ABBORD500.txt");
			executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta500inv.txt"
								, "arq_ger/ABBINV500.txt");
			executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta500alea.txt"
								, "arq_ger/ABBALE500.txt");
			
			
			executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta1000ord.txt"
								, "arq_ger/ABBORD1000.txt");
			executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta1000inv.txt"
								, "arq_ger/ABBINV1000.txt");
			executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta1000alea.txt"
								, "arq_ger/ABBALE1000.txt");
			
			executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta5000ord.txt"
								, "arq_ger/ABBORD5000.txt");
			executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta5000inv.txt"
								, "arq_ger/ABBINV5000.txt");
			executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta5000alea.txt"
								, "arq_ger/ABBALE5000.txt");
			
			executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta10000ord.txt"
								, "arq_ger/ABBORD10000.txt");
			executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta10000inv.txt"
								, "arq_ger/ABBINV10000.txt");
			executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta10000alea.txt"
								, "arq_ger/ABBALE10000.txt");
			/*NOTE: PARA NÃO ESTOURAR O STACK OVER FLOW
			executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta50000ord.txt"
								, "arq_ger/ABBORD50000.txt");
			executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta50000inv.txt"
								, "arq_ger/ABBINV50000.txt");
			executaProcessoABB(arv, arvCPF, listaClientes, listaCPF, carga, ordem, pesq	, grava
								, "arq/conta50000alea.txt"
								, "arq_ger/ABBALE50000.txt");*/
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame,
			        "ERRO NA GERAÇÃO DO ARQUIVO ABB", 
			        "ERRO",
			        JOptionPane.ERROR_MESSAGE);
		}
		
		
	}

	protected void executaTodosQUICK() {
		try {
			executaProcessoQuick(cliente500, arrayCPF, carga, ordem, pesq , grava
								, "arq/conta500ord.txt"
								, "arq_ger/QUICKORD500.txt");
			executaProcessoQuick(cliente500, arrayCPF, carga, ordem, pesq , grava
								, "arq/conta500inv.txt"
								, "arq_ger/QUICKINV500.txt");
			executaProcessoQuick(cliente500, arrayCPF, carga, ordem, pesq , grava
								, "arq/conta500alea.txt"
								, "arq_ger/QUICKALE500.txt");
			
			executaProcessoQuick(cliente1k, arrayCPF, carga, ordem, pesq , grava
								, "arq/conta1000ord.txt"
								, "arq_ger/QUICKORD1000.txt");
			executaProcessoQuick(cliente1k, arrayCPF, carga, ordem, pesq , grava
								, "arq/conta1000inv.txt"
								, "arq_ger/QUICKINV1000.txt");
			executaProcessoQuick(cliente1k, arrayCPF, carga, ordem, pesq , grava
								, "arq/conta1000alea.txt"
								, "arq_ger/QUICKALE1000.txt");
			
			executaProcessoQuick(cliente5k, arrayCPF, carga, ordem, pesq , grava
								, "arq/conta5000ord.txt"
								, "arq_ger/QUICKORD5000.txt");
			executaProcessoQuick(cliente5k, arrayCPF, carga, ordem, pesq , grava
								, "arq/conta5000inv.txt"
								, "arq_ger/QUICKINV5000.txt");
			executaProcessoQuick(cliente5k, arrayCPF, carga, ordem, pesq , grava
								, "arq/conta5000alea.txt"
								, "arq_ger/QUICKALE5000.txt");
			
			executaProcessoQuick(cliente10k, arrayCPF, carga, ordem, pesq , grava
								, "arq/conta10000ord.txt"
								, "arq_ger/QUICKORD10000.txt");
			executaProcessoQuick(cliente10k, arrayCPF, carga, ordem, pesq , grava
								, "arq/conta10000inv.txt"
								, "arq_ger/QUICKINV10000.txt");
			executaProcessoQuick(cliente10k, arrayCPF, carga, ordem, pesq , grava
								, "arq/conta10000alea.txt"
								, "arq_ger/QUICKALE10000.txt");
			/*NOTE: PARA NÃO ESTOURAR O STACK OVER FLOW
			executaProcessoQuick(cliente50k, arrayCPF, carga, ordem, pesq , grava
								, "arq/conta50000ord.txt"
								, "arq_ger/QUICKORD50000.txt");
			executaProcessoQuick(cliente50k, arrayCPF, carga, ordem, pesq , grava
								, "arq/conta50000inv.txt"
								, "arq_ger/QUICKINV50000.txt");
			executaProcessoQuick(cliente50k, arrayCPF, carga, ordem, pesq , grava
								, "arq/conta50000alea.txt"
								, "arq_ger/QUICKALE50000.txt");*/
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame,
			        "ERRO NA GERAÇÃO DO ARQUIVO QUICK",
			        "ERRO", 
			        JOptionPane.ERROR_MESSAGE);
		}
		
	}

	private void executaTodosHEAP() {
		try {
			executaProcessoHeap(cliente500, arrayCPF, carga,ordem , pesq, grava
								, "arq/conta500ord.txt"
								, "arq_ger/HEAPORD500.txt");					
			executaProcessoHeap(cliente500, arrayCPF, carga,ordem, pesq , grava
								, "arq/conta500inv.txt"
								, "arq_ger/HEAPINV500.txt");
			executaProcessoHeap(cliente500, arrayCPF, carga,ordem, pesq , grava
								, "arq/conta500alea.txt"
								, "arq_ger/HEAPALE500.txt");
			
			executaProcessoHeap(cliente1k, arrayCPF, carga,ordem , pesq, grava
								, "arq/conta1000ord.txt"
								, "arq_ger/HEAPORD1000.txt");
			executaProcessoHeap(cliente1k, arrayCPF, carga,ordem, pesq , grava
								, "arq/conta1000inv.txt"
								, "arq_ger/HEAPINV1000.txt");
			executaProcessoHeap(cliente1k, arrayCPF, carga,ordem, pesq , grava
								, "arq/conta1000alea.txt"
								, "arq_ger/HEAPALE1000.txt");
			
			executaProcessoHeap(cliente5k, arrayCPF, carga,ordem , pesq, grava
								, "arq/conta5000ord.txt"
								, "arq_ger/HEAPORD5000.txt");
			executaProcessoHeap(cliente5k, arrayCPF, carga,ordem, pesq , grava
								, "arq/conta5000inv.txt"
								, "arq_ger/HEAPINV5000.txt");
			executaProcessoHeap(cliente5k, arrayCPF, carga,ordem, pesq , grava
								, "arq/conta5000alea.txt"
								, "arq_ger/HEAPALE5000.txt");
			
			executaProcessoHeap(cliente10k, arrayCPF, carga,ordem , pesq, grava
								, "arq/conta10000ord.txt"
								, "arq_ger/HEAPORD10000.txt");
			executaProcessoHeap(cliente10k, arrayCPF, carga,ordem, pesq , grava
								, "arq/conta10000inv.txt"
								, "arq_ger/HEAPINV10000.txt");
			executaProcessoHeap(cliente10k, arrayCPF, carga,ordem, pesq , grava
								, "arq/conta10000alea.txt"
								, "arq_ger/HEAPALE10000.txt");
			
			executaProcessoHeap(cliente50k, arrayCPF, carga,ordem , pesq, grava
								, "arq/conta50000ord.txt"
								, "arq_ger/HEAPORD50000.txt");
			executaProcessoHeap(cliente50k, arrayCPF, carga,ordem, pesq , grava
								, "arq/conta50000inv.txt"
								, "arq_ger/HEAPINV50000.txt");
			executaProcessoHeap(cliente50k, arrayCPF, carga,ordem, pesq , grava
								, "arq/conta50000alea.txt"
								, "arq_ger/HEAPALE50000.txt");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame,
			        "ERRO NA GERAÇÃO DO ARQUIVO HEAP", 
			        "ERRO", 
			        JOptionPane.ERROR_MESSAGE);
		}		
		
	}

	/**
	 * 
	 * Metodos de geração de arquivo!!
	 * 
	 * 
	 */
	public static void executaProcessoHeap(Cliente[] clientes, String[] listaCPF, Carga carga, Ordenacao ordem, Pesquisa pesq,
			Gravacao grava, String nomeArq, String nomeArqSaida) throws IOException {
		long tempoMedio = 0;
		long inicio;
		long fim;
		long termino=0;
		inicio = System.currentTimeMillis();
		for (int i = 0; i < 1; i++) {			
			clientes = carga.cargaVetorConta(nomeArq, clientes.length);
			listaCPF = carga.cargaCPF();	
			ordem.heapSort(clientes);
			grava.gravaArquivo(clientes, listaCPF, pesq, nomeArqSaida);			
		}
		fim = System.currentTimeMillis();
		termino = fim - inicio;
		tempoMedio = (termino/5);
		System.out.println(String.format("Tempo: %tQ milisegundos", tempoMedio));		
	}
	
	public static void executaProcessoQuick(Cliente[] clientes, String[] listaCPF, Carga carga, Ordenacao ordem, Pesquisa pesq,
			Gravacao grava, String nomeArq, String nomeArqSaida) throws IOException {
		long tempoMedio = 0;
		long inicio;
		long fim;
		long termino;
		inicio = System.currentTimeMillis();
		for (int i = 0; i < 1; i++) {			
			clientes = carga.cargaVetorConta(nomeArq, clientes.length);
			listaCPF = carga.cargaCPF();	
			ordem.quickSort(clientes, 0, clientes.length);
			grava.gravaArquivo(clientes, listaCPF, pesq, nomeArqSaida);		
		}
		fim = System.currentTimeMillis();
		termino = fim - inicio;
		tempoMedio = (termino/5);
		System.out.println(String.format("Tempo: %tQ milisegundos", tempoMedio));	
	}
	
	public static void executaProcessoABB(Arvore arv, Arvore arvCPF, List<Cliente> clientes, List<Cliente> listaCPF, Carga carga, Ordenacao ordem, Pesquisa pesq
																	,Gravacao grava, String nomArq , String nomeArqSaida) throws IOException {
		long tempoMedio = 0;
		long inicio;
		long fim;
		long termino;
		inicio = System.currentTimeMillis();
		for (int i = 0; i < 1; i++) {
			arv = new Arvore();
			arvCPF = new Arvore();
			clientes = new LinkedList<Cliente>(); 
			listaCPF = new LinkedList<Cliente>();
			
			arv = carga.cargaArvore(nomArq);
			arvCPF = carga.cargaArvoreCPF();
			
			clientes = ordem.caminhamentoArvore(clientes, arv);
			arv = ordem.balancearArvore(clientes, arv);
					
			listaCPF = ordem.caminhamentoArvore(listaCPF, arvCPF);
			arvCPF = ordem.balancearArvore(listaCPF, arvCPF);
					
			grava.gravaArquivo(arvCPF, arv,clientes, listaCPF, pesq, nomeArqSaida);
		}
		fim = System.currentTimeMillis();
		termino = fim - inicio;
		tempoMedio = (termino/5);
		System.out.println(String.format("Tempo: %tQ milisegundos", tempoMedio));
	}
	
	public static void executaProcessoAVL(Arvore arv, Arvore arvCPF, List<Cliente> clientes, List<Cliente> listaCPF, Carga carga, Ordenacao ordem, Pesquisa pesq
			,Gravacao grava, String nomArq, String nomeArqSaida) throws IOException {
		long tempoMedio = 0;
		long inicio;
		long fim;
		long termino;
		inicio = System.currentTimeMillis();
		for (int i = 0; i < 1; i++) {
			arv = new ArvoreVL();
			arvCPF = new ArvoreVL();
			clientes = new LinkedList<Cliente>(); 
			listaCPF = new LinkedList<Cliente>();

			arv = carga.cargaArvore(nomArq);
			arvCPF = carga.cargaArvoreCPF();
			
			
			clientes = ordem.caminhamentoArvore(clientes, arv);
			

			listaCPF = ordem.caminhamentoArvore(listaCPF, arvCPF);
			
			grava.gravaArquivo(arvCPF, arv,clientes, listaCPF, pesq, nomeArqSaida);
		}
		fim = System.currentTimeMillis();
		termino = fim - inicio;
		tempoMedio = (termino/5);
		System.out.println(String.format("Tempo: %tQ milisegundos", tempoMedio));
	}
	
	
	public static void executaProcessoHashing(String[] cpfs, Hashing hashingClientes, Carga carga, Ordenacao ordem
			,Gravacao grava, Pesquisa pesq, String nomArq ,String nomeArqSaida, int tamanho) throws IOException{			
		long tempoMedio = 0;
		long inicio;
		long fim;
		long termino;	
		hashingClientes = new Hashing(tamanho);
		//NOTE: PROFESSORA DEIXEI ESTE CÓDIGO DO LADO DE FORA, PARA NÃO POLUIR O RESULTADO EXCLUSIVAMENTE DO HASHING
		cpfs = carga.cargaCPF();	
		//NOTE: ATÉ AQUI!
		
		inicio = System.currentTimeMillis();
		for (int i = 0; i < 1; i++) {					
			hashingClientes = carga.CargaHash(nomArq, tamanho);			
			grava.gravaArquivo(cpfs, hashingClientes, nomeArqSaida);			
		}		
		fim = System.currentTimeMillis();
		termino = fim - inicio;
		tempoMedio = (termino/5);
		System.out.println(String.format("Tempo: %tQ milisegundos", tempoMedio));
	}
}
