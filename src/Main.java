import controle.AlunoControler;
import controle.ResponsavelControler;
import modelo.Aluno;
import modelo.Parentesco;
import modelo.Responsavel;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		executarAluno();
		executarResponsavel(); 
		pesquisaResponsavel(131);
	}
	
	public static void pesquisaAluno() {
		
	}
	
	public static void pesquisaResponsavel(int id) {
		ResponsavelControler controle = new ResponsavelControler();
		controle.consultar(id);
	}

	public static void executarResponsavel() {
		// criar objeto Responsavel
		Responsavel responsavel = new Responsavel("Diferente", 123456789, 1234567, 999998888, 12,"Rua responsavel", Parentesco.PAI); 
		ResponsavelControler controle = new ResponsavelControler();
		controle.persist(responsavel);
	}
	
	public static void executarAluno() {
		// criar objeto Aluno
		Aluno aluno = new Aluno("Maria", 123456789, 1234567, 999998888, 12,"Rua do aluno"); 
		AlunoControler controle = new AlunoControler();
		controle.persistir(aluno);
	}
	
}
