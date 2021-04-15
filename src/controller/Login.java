package controller;
import java.util.*;
import model.*;

public class Login {

	public boolean mostraUsuario(BancoUsuarios banco , String usuario , String senha) {
		boolean entrar = false;
		if(banco.autenticaUsuario(usuario , senha) == 1) {
			entrar = true;
		}else {
			entrar = false;
		}
		
		return entrar;
	}

}
