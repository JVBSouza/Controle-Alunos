package controle;

import Repositorio.AlunoRepository;
import Repositorio.ResponsavelRepository;
import modelo.Aluno;

public class AlunoController {

	public void persist(Aluno aluno) {
		System.out.println("imprimindo");
		System.out.println(aluno.toString());
		AlunoRepository rep = new AlunoRepository();
		rep.persist(aluno);
	}

	public Aluno find(int matricula) {
		AlunoRepository rep = new AlunoRepository();
		Aluno aluno = rep.find(matricula);
		return aluno;
	}
	
	public void update(int id, Aluno aluno) {
		AlunoRepository rep = new AlunoRepository();
		rep.update(id, aluno);
	}
	
	public void delete(int id) {
		AlunoRepository rep = new AlunoRepository();
		rep.delete(id);
	}

}
