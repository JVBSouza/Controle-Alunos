package controle;

import Repositorio.AlunoRepositorio;
import modelo.Aluno;

public class AlunoControler {

	
	public void persistir(Aluno aluno) {
		System.out.println("imprimindo");
		AlunoRepositorio rep = new AlunoRepositorio();
		rep.persist(aluno);
	}
	
	public Aluno consultar(int id) {
		return null;
		
	}
	
	public void remover(int id) {
		
	}
	
}
