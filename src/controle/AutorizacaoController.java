package controle;

import Repositorio.AutorizacaoRepository;
import modelo.Autorizacao;

public class AutorizacaoController {

	public void persist(Autorizacao autorizacao) {
		AutorizacaoRepository rep = new AutorizacaoRepository();
		rep.persist(autorizacao);
	}
	
	public Autorizacao find(int idAutoriza) {
		AutorizacaoRepository rep = new AutorizacaoRepository();
		Autorizacao autoriza = rep.find(idAutoriza);
		return autoriza;
	}
	
	public void update(int idAutoriza, String descrCancel) {
		AutorizacaoRepository rep = new AutorizacaoRepository();
		rep.update(idAutoriza, descrCancel);
	}
	
}
