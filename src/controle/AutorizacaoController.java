package controle;

import Repositorio.AutorizacaoRepository;
import modelo.Autorizacao;

public class AutorizacaoController {

	public void persist(Autorizacao autorizacao) {
		AutorizacaoRepository rep = new AutorizacaoRepository();
		rep.persist(autorizacao);
	}
	
}
