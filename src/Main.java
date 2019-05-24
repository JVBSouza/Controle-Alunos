import java.time.LocalDate;

import controle.AlunoControler;
import controle.ResponsavelController;
import modelo.Aluno;
import modelo.Responsavel;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//executarAluno();
		executarResponsavel(); 
		pesquisaResponsavel(1);
		updateResponsavel(1);
		pesquisaResponsavel(1);
		deleteResponsavel(1);

	}
	
	public static void pesquisaAluno() {
		
	}
	
	public static void pesquisaResponsavel(int id) {
		ResponsavelController controle = new ResponsavelController();
		controle.find(id);
	}
	
	public static void updateResponsavel(int id) {
		ResponsavelController controle = new ResponsavelController();
		controle.update(id);
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
		Aluno aluno = new Aluno("Maria", 123456789, 1234567, 999998888, 12,"Rua do aluno"); 
		AlunoControler controle = new AlunoControler();
		controle.persistir(aluno);
	}
	
}
