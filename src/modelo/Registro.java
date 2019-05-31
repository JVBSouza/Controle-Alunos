package modelo;

import java.time.LocalDateTime;

public class Registro {

	private int codRegistro;
	private int codOperador;
	private int codAutoriza;
	private int matricula; //cod aluno?
	private LocalDateTime data;
	private String tipo;
	
	public Registro(int codOperador, int codAutoriza, int matricula, LocalDateTime data, String tipo) {
		this.codAutoriza = codAutoriza;
		this.codOperador = codOperador;
		this.matricula = matricula;
		this.data = data;
		this.tipo = tipo;		
	}

	public int getCodRegistro() {
		return codRegistro;
	}

	public int getCodOperador() {
		return codOperador;
	}

	public int getCodAutoriza() {
		return codAutoriza;
	}

	public int getMatricula() {
		return matricula;
	}

	public LocalDateTime getData() {
		return data;
	}

	public String getTipo() {
		return tipo;
	}

	
	
}
