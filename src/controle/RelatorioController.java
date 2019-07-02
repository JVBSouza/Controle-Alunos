package controle;

import java.io.File;

import Repositorio.RelatorioRepository;

public class RelatorioController {

	public void gravarAluno(File file) {
		RelatorioRepository rep = new RelatorioRepository();
		rep.gravarAluno(file);
	}

	public void gravarIrregular(File file, int matricula) {
		RelatorioRepository rep = new RelatorioRepository();
		rep.gravarIrregular(file, matricula);
	}

	public void gravarTurma(File file, int turma) {
		RelatorioRepository rep = new RelatorioRepository();
		rep.gravarTurma(file, turma);
	}

	public void gravarMes(File file, int mes) {
		RelatorioRepository rep = new RelatorioRepository();
		rep.gravarMes(file, mes);
	}

	public void gravarUser(File file, int user) {
		RelatorioRepository rep = new RelatorioRepository();
		rep.gravarUser(file, user);
	}

}
