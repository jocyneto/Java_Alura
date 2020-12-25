package br.com.faesa.arvore;

import br.com.faesa.modelo.Cliente;

public class ArvoreVL extends Arvore {
	private boolean h;
	
	public ArvoreVL() {
		super();
		this.h = true;
	}

	@Override
	public void insere (Cliente cliente){
		super.raiz = this.insereRaiz (cliente, (Nodo) super.raiz);
	}	
	
	
	private Nodo insereRaiz (Cliente cliente, Nodo no){
		if (no == null){
			Nodo novo = new Nodo(cliente);
			this.h = true;
			return novo;
		}
		else{
			if (cliente.getCPF().compareTo(no.getInfo().getCPF()) < 0){
				// Insere à esquerda e verifica se precisa balancear à direita
				no.setEsq(this.insereRaiz (cliente,(Nodo) no.getEsq()));//NOTE: INSERI CAST DE NODO
				no = this.balancearDir (no);
				return no;
			}
			else{
				// Insere à direita e verifica se precisa balancear à esquerda
				no.setDir(this.insereRaiz (cliente,(Nodo) no.getDir()));//NOTE: INSERI CAST DE NODO
				no = this.balancearEsq (no);
				return no;
			}
		}
	}
	
	private Nodo balancearDir (Nodo no){
		if (this.h)
			switch (no.getFatorBalanceamento()){
			case 1 : 
				no.setFatorBalanceamento((byte)0);
				this.h = false;
				break;
			case 0 : 
				no.setFatorBalanceamento((byte)-1);
				break;
			case -1: 
				no = this.rotaçãoDireita (no);
			}
		return no;
	}
	
	private Nodo balancearEsq (Nodo no){
		if (this.h)
			switch (no.getFatorBalanceamento()){
			case -1: 
				no.setFatorBalanceamento((byte)0);
				this.h = false;
				break;
			case 0 : 
				no.setFatorBalanceamento((byte)1);
				break;
			case 1 : 
				no = this.rotaçãoEsquerda (no); }
		return no;
	}
	
	private Nodo rotaçãoDireita (Nodo no){
		Nodo temp1, temp2;
		temp1 = (Nodo)no.getEsq();//NOTE: INSERI CAST DE NODO
		if (temp1.getFatorBalanceamento() == -1){
			no.setEsq(temp1.getDir());
			temp1.setDir(no);
			no.setFatorBalanceamento((byte)0);
			no = temp1;
		}
		else {
			temp2 = (Nodo)temp1.getDir();//NOTE: INSERI CAST DE NODO
			temp1.setDir(temp2.getEsq());
			temp2.setEsq(temp1);
			no.setEsq(temp2.getDir());
			temp2.setDir(no);
			if (temp2.getFatorBalanceamento() == -1)
				no.setFatorBalanceamento((byte)1);
			else
				no.setFatorBalanceamento((byte)0);
			if (temp2.getFatorBalanceamento() == 1)
				temp1.setFatorBalanceamento((byte)-1);
			else
				temp1.setFatorBalanceamento((byte)0);
			no = temp2;
		}
		no.setFatorBalanceamento((byte)0);
		this.h = false;
		return no;
	}
	
	private Nodo rotaçãoEsquerda (Nodo no){
		Nodo temp1, temp2;
		temp1 = (Nodo)no.getDir();//NOTE: INSERI CAST DE NODO
		if (temp1.getFatorBalanceamento() == 1){
			no.setDir (temp1.getEsq());
			temp1.setEsq(no);
			no.setFatorBalanceamento((byte)0);
			no = temp1;
		}
		else {
			temp2 = (Nodo)temp1.getEsq();//NOTE: INSERI CAST DE NODO
			temp1.setEsq(temp2.getDir());
			temp2.setDir(temp1);
			no.setDir(temp2.getEsq());
			temp2.setEsq(no);
			if (temp2.getFatorBalanceamento() == 1)
				no.setFatorBalanceamento((byte)-1);
			else
				no. setFatorBalanceamento((byte)0);
			if (temp2. getFatorBalanceamento() == -1)
				temp1. setFatorBalanceamento((byte)1);
			else
				temp1. setFatorBalanceamento((byte)0);
			no = temp2;
		}
		no.setFatorBalanceamento((byte)0);
		this.h = false;
		return no;
	}

	
	



}
