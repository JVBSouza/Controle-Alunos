package modelo;

import java.time.LocalDate;

public class Operador extends Pessoa {

	private int codUsuario;
	private String turno; // Matutino e Vespertino
	private String setor; //
	
	public Operador(String nome, String cpf, String rg, String telefone, LocalDate datanasc, String endereco, String parentesco, String turno, String setor) {
		this.setNome(nome);
		this.setRg(rg);
		this.setCpf(cpf); //cpf tem mais que 11 numeros ver isso
		this.setDatanasc(datanasc);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		
		this.setor = setor;
		this.turno = turno;
	}
	
}
