package modelo;

import java.time.LocalDate;
import java.util.Date;

import controle.ResponsavelController;

public class Aluno extends Pessoa {

	protected int matricula; //cod aluno
	protected int responsavel1;
	protected int responsavel2;
	
	public Aluno(String nome, String cpf, String rg, String telefone, LocalDate dataNasc, String endereco, int resp1, int resp2) {
//		this.matricula = 0;  //Why?
		this.setNome(nome);
		this.setCpf(cpf);
		this.setDatanasc(dataNasc);
		this.setRg(rg);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		
		this.responsavel1 = resp1;
		this.responsavel2 = resp2;
	}

	public int getMatricula() {
		return matricula;
	}

	public int getResponsavel1() {
		return responsavel1;
	}

	public int getResponsavel2() {
		return responsavel2;
	}

	@Override
	public String toString() {
		return "Aluno " + this.getNome()+ ", CPF: "+ this.getCpf();
	}

	public void setResponsavel1(int responsavel1) {
		this.responsavel1 = responsavel1;
	}

	public void setResponsavel2(int responsavel2) {
		this.responsavel2 = responsavel2;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	
}

