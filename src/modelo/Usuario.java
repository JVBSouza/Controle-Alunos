package modelo;

import java.time.LocalDate;

public class Usuario extends Pessoa {

	private int codUsuario;
	private String turno; 
	private String setor; 
	private String senha;

	public Usuario(String nome, String cpf, String rg, String telefone, LocalDate datanasc, String endereco,
			String turno, String setor) {
		this.setNome(nome);
		this.setRg(rg);
		this.setCpf(cpf); // cpf tem mais que 11 numeros ver isso
		this.setDatanasc(datanasc);
		this.setEndereco(endereco);
		this.setTelefone(telefone);

		this.setor = setor;
		this.turno = turno;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
