package modelo;

import java.time.LocalDate;

public class Responsavel extends Pessoa {
	
	private int codResponsavel;
	private String parentesco;
	
	public Responsavel(String nome, String cpf, int rg, String telefone, LocalDate datanasc, String endereco, String parentesco) {
		this.setNome(nome);
		this.setRg(rg);
		this.setCpf(cpf); //cpf tem mais que 11 numeros ver isso
		this.setDatanasc(datanasc);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		
		this.parentesco = parentesco;
		//Parentesco.valueOf("PAI") transforma string em enum
		//this.codResponsavel = 123;
	}

	public int getCodResponsavel() {
		return codResponsavel;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
		
}
