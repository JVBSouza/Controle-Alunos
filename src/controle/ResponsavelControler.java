package controle;

import Repositorio.ResponsavelRepositorio;
import modelo.Responsavel;

public class ResponsavelControler {

	public void persist(Responsavel responsavel) {
		System.out.println("imprimindo");
		ResponsavelRepositorio rep = new ResponsavelRepositorio();
		rep.persist(responsavel);
	}
	
	public void consultar(int id) {
		ResponsavelRepositorio rep = new ResponsavelRepositorio();
		rep.find(id);
	}
	
	public void update(int id) {
		ResponsavelRepositorio rep = new ResponsavelRepositorio();
		rep.update(id);
	}
	
	public void delete(int id) {
		ResponsavelRepositorio rep = new ResponsavelRepositorio();
		rep.delete(id);
	}
	
}
