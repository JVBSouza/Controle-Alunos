import java.time.LocalDate;
import java.time.LocalDateTime;

import controle.AlunoController;
import controle.RegistroController;
import controle.ResponsavelController;
import modelo.Aluno;
import modelo.Registro;
import modelo.Responsavel;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//executarAluno();
//		executarResponsavel(); 
//		pesquisaResponsavel(1);
//		updateResponsavel(1);
//		pesquisaResponsavel(1);
//		deleteResponsavel(1);
		executarRegistro();
		findRegistro(1);
	}
	
	public static void pesquisaAluno() {
		
	}
	
	public static void pesquisaResponsavel(int id) {
		ResponsavelController controle = new ResponsavelController();
		controle.find(id);
	}
	
	public static void updateResponsavel(int id) {
		ResponsavelController controle = new ResponsavelController();
		//controle.update(id);
	}
	
	public static void deleteResponsavel(int id) {
		ResponsavelController controle = new ResponsavelController();
		controle.delete(id);
	}

	public static void executarResponsavel() {
		// criar objeto Responsavel
		Responsavel responsavel = new Responsavel("Diferente", "99988877766", 123456789, "988887777", LocalDate.of(2019, 02, 05),"Rua responsavel", "Pai"); 
		ResponsavelController controle = new ResponsavelController();
		controle.persist(responsavel);
	}
	
	public static void executarAluno() {
		// criar objeto Aluno
		Aluno aluno = new Aluno("Vínicius", "00187645512", 56434567, "(48) 98752-3567",LocalDate.of(1997, 05, 20),"Rua dos bobos numero 0");
		//Aluno aluno = new Aluno("Maria", 123456789, 1234567, 999998888, 12,"Rua do aluno"); 
		AlunoController controle = new AlunoController();
		controle.persist(aluno);
	}
	
	public static void executarRegistro() {
		Registro reg = new Registro(1, 1, 12346789, LocalDateTime.now(), "Entrada");
		RegistroController controle = new RegistroController();
		controle.persist(reg);
	}
	
	public static void findRegistro(int id) {
		RegistroController controle = new RegistroController();
		controle.find(id);
		}

	public static void buscarAluno(int matricula) {
		AlunoController controle = new AlunoController();
		controle.find(matricula);
	}
	
	public static void deletarAluno(int matricula) {
		AlunoController controle = new AlunoController();
		controle.delete(matricula);

	}
	
}
