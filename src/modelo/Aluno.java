package modelo;

import java.util.Date;

public class Aluno extends Pessoa {

	protected int matricula; //cod aluno
	protected Responsavel responsavel1;
	protected Responsavel responsavel2;
	
	public Aluno(String nome, int cpf, int rg, int telefone, int dataNasc, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.dataNasc = dataNasc;
		this.endereco = endereco;
		this.matricula = 123;
	}

	public int getMatricula() {
		return matricula;
	}

	public Responsavel getResponsavel1() {
		return responsavel1;
	}

	public Responsavel getResponsavel2() {
		return responsavel2;
	}
	
	
}

