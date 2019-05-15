package modelo;

import java.util.Date;

public class Aluno extends Pessoa {

	protected int matricula; //cod aluno
	protected Responsavel responsavel1;
	protected Responsavel responsavel2;
	
	public Aluno(String nome, int cpf, int rg, int telefone, int dataNasc, String endereço) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.dataNasc = dataNasc;
		this.Endereço = endereço;
		this.matricula = 123;
	}
}
