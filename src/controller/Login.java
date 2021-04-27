package controller;
import java.util.*;
import model.*;

/**
 * Classe responsável por verificar se o Usuário está dentro do Banco de Dados
 * @author Pedro Henrique
 * @version 1.0
 */
public class Login {

	/**
	 * Método responsável
	 * @param banco
	 * @param usuario
	 * @param senha
	 * @return
	 */
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
