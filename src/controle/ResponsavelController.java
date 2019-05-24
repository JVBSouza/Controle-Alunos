package controle;

import Repositorio.ResponsavelRepository;
import modelo.Responsavel;

public class ResponsavelController {

	public void persist(Responsavel responsavel) {
		System.out.println("imprimindo");
		ResponsavelRepository rep = new ResponsavelRepository();
		rep.persist(responsavel);
	}

	public void find(int id) {
		ResponsavelRepository rep = new ResponsavelRepository();
		rep.find(id);
	}
	
	public void update(int id) {
		ResponsavelRepository rep = new ResponsavelRepository();
		rep.update(id);
	}
	
	public void delete(int id) {
		ResponsavelRepository rep = new ResponsavelRepository();
		rep.delete(id);
	}

}
