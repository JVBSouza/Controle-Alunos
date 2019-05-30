package controle;

import Repositorio.AlunoRepository;
import Repositorio.ResponsavelRepository;
import modelo.Aluno;

public class AlunoControler {

	public void persistir(Aluno aluno) {
		System.out.println("imprimindo");
		System.out.println(aluno.toString());
		AlunoRepository rep = new AlunoRepository();
		rep.persist(aluno);
	}

	public void buscar(int matricula) {
		AlunoRepository rep = new AlunoRepository();
		rep.buscar(matricula);
	}
	
	public void atualizar(int id) {
		AlunoRepository rep = new AlunoRepository();
		rep.atualizar(id);
	}
	
	public void deletar(int id) {
		AlunoRepository rep = new AlunoRepository();
		rep.delete(id);
	}

}
