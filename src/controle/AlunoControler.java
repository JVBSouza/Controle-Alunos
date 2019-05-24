package controle;

import Repositorio.AlunoRepository;
import modelo.Aluno;

public class AlunoControler {

	public void persistir(Aluno aluno) {
		System.out.println("imprimindo");
		AlunoRepository rep = new AlunoRepository();
		rep.persist(aluno);
	}

	public Aluno consultar(int id) {

		return null;

	}

	public void remover(int id) {

	}

}
