import controle.AlunoControler;
import modelo.Aluno;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		executarAluno();
		
		
	}

	
	public static void executarAluno() {
		// criar objeto Aluno
		Aluno aluno = new Aluno("Maria", 123456789, 1234567, 999998888, 12,"Rua"); 
		AlunoControler controle = new AlunoControler();
		controle.persistir(aluno);
	}
	
}
