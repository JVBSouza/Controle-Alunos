package controle;

import Repositorio.UsuarioRepository;
import modelo.Usuario;

public class UsuarioController {

	public Usuario find(int idUser) {
		UsuarioRepository rep = new UsuarioRepository();
		return rep.find(idUser);
	}

}
