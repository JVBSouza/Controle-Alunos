package controle;

import Repositorio.ResponsavelRepository;
import modelo.Responsavel;

public class ResponsavelController {

	public void persist(Responsavel responsavel) {
		System.out.println("imprimindo");
		ResponsavelRepository rep = new ResponsavelRepository();
		rep.persist(responsavel);
	}

	public Responsavel find(int id) {
		ResponsavelRepository rep = new ResponsavelRepository();
		Responsavel resp = rep.find(id);
		return resp;
	}
	
	public void update(int id, Responsavel resp) {
		ResponsavelRepository rep = new ResponsavelRepository();
		rep.update(id, resp);
	}
	
	public void delete(int id) {
		ResponsavelRepository rep = new ResponsavelRepository();
		rep.delete(id);
	}

}
