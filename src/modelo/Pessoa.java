package modelo;

import java.time.LocalDate;

public class Pessoa {

	private String nome;
	private String cpf; //CPF com 11 números - mudar pra outro tipo
	private int rg;
	private String telefone;
	private LocalDate datanasc;
	private String endereco;
	
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public int getRg() {
		return rg;
	}
	public String getTelefone() {
		return telefone;
	}
	public LocalDate getDatanasc() {
		return datanasc;
	}
	public String getEndereco() {
		return endereco;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public void setDatanasc(LocalDate datanasc) {
		this.datanasc = datanasc;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
	
}

