package controller;
import java.util.*;
import model.*;

public class Login {

	// M�todo que verifica se o Usuario est� no Banco, caso 1 (Sim), ele entra no sistema
	public boolean mostraUsuario(BancoUsuarios banco , String usuario , String senha) {
		boolean entrar = false;
		if(banco.autenticaUsuario(usuario , senha) == true) {
			entrar = true;
		}else {
			entrar = false;
		}
		
		return entrar;
	}

}
