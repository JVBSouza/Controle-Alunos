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
	
}
