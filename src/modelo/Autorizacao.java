package modelo;

import java.time.LocalDateTime;
import java.util.Date;

public class Autorizacao {

	private int codAutoriza;
	private int matricula; //cod aluno
	private int codResponsavel;
	private int codUsuario;
	private LocalDateTime data;
	//private String tipo; // Entrada ou saída sair passado para o registro;
	private String desc; // Descrição
	private boolean ativo;
	private String descCancel;
	
	public Autorizacao(int matricula, int codResponsavel, int codUsuario, LocalDateTime data, String desc) {
		this.matricula = matricula;
		this.codResponsavel = codResponsavel;
		this.codUsuario = codUsuario;
		this.data = data;
		this.desc = desc;
		this.ativo = true;
		
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getDescCancel() {
		return descCancel;
	}

	public void setDescCancel(String descCancel) {
		this.descCancel = descCancel;
	}

	public int getCodAutoriza() {
		return codAutoriza;
	}

	public int getMatricula() {
		return matricula;
	}

	public int getCodResponsavel() {
		return codResponsavel;
	}

	public int getCodUsuario() {
		return codUsuario;
	}

	public LocalDateTime getData() {
		return data;
	}

	public String getDesc() {
		return desc;
	}
	
}
