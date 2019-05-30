package modelo;

import java.time.LocalDate;
import java.util.Date;

public class Aluno extends Pessoa {

	protected int matricula; //cod aluno
	protected Responsavel responsavel1;
	protected Responsavel responsavel2;
	
	public Aluno(String nome, String cpf, int rg, String telefone, LocalDate dataNasc, String endereco) {
//		this.nome = nome;
//		this.cpf = cpf; //cpf tem mais que 11 numeros ver isso
//		this.rg = rg;
//		this.telefone = telefone;
//		this.dataNasc = dataNasc;
//		this.endereco = endereco;
		this.matricula = 1;  //Why?
		this.setNome(nome);
		this.setCpf(cpf);
		this.setDatanasc(dataNasc);
		this.setRg(rg);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		
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

	@Override
	public String toString() {
		return "Aluno " + this.getNome()+ ", CPF: "+ this.getCpf();
	}
	
	
}

