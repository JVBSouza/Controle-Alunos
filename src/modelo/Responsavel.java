package modelo;

public class Responsavel extends Pessoa {
	
	protected int codResponsavel;
	protected Parentesco parentesco;
	
	public Responsavel(String nome, int cpf, int rg, int telefone, int dataNasc, String endereco, Parentesco parentesco) {
		this.nome = nome;
		this.cpf = cpf; //cpf tem mais que 11 numeros ver isso
		this.rg = rg;
		this.telefone = telefone;
		this.dataNasc = dataNasc;
		this.endereco = endereco;
		this.parentesco = parentesco;
		//this.codResponsavel = 123;
	}

	public int getCodResponsavel() {
		return codResponsavel;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}
	
}
