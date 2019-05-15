package modelo;

import java.util.Date;

public class Pessoa {

	protected String nome;
	protected int cpf; //CPF com 11 números - mudar pra outro tipo
	protected int rg;
	protected int telefone;
	protected int dataNasc;
	protected String endereco;
	public String getNome() {
		return nome;
	}
	public int getCpf() {
		return cpf;
	}
	public int getRg() {
		return rg;
	}
	public int getTelefone() {
		return telefone;
	}
	public int getDataNasc() {
		return dataNasc;
	}
	public String getEndereco() {
		return endereco;
	}
	
	
	
}

