package controle;

import Repositorio.RegistroRepository;
import modelo.Registro;

public class RegistroController {

	public void persist(Registro registro) {
		RegistroRepository rep = new RegistroRepository();
		rep.persist(registro);
	}
	
	public void find(int id) {
		RegistroRepository rep = new RegistroRepository();
		rep.find(id);
	}
	
}
