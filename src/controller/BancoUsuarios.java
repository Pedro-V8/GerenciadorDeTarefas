package controller;
import java.util.*;

import model.Usuario;

/**
 * Classe respons�vel por simular um banco de dados, podendo registrar e retornando o usu�rio registrado.
 * @author Pedro Henrique
 * @version 1.0
 */

public class BancoUsuarios {
	
	
	private static Usuario user; //Declarando objeto do tipo Usuario
	ArrayList<Usuario> usuarios = new ArrayList(); //ArrayList para salvar os Usu�rios Registrados
	
	//Salva Usu�rio no ArrayList
	public void cadastraUsuario(Usuario user) {
		usuarios.add(user);

	}
	
	/**
	 * M�todo respons�vel por verificar se o usu�rio digitado est� cadastrado
	 * @param usuario
	 * @param senha
	 * @return boolean, true para cadastrado e false para n�o cadastrado
	 */
	public boolean autenticaUsuario(String usuario , String senha) {
		boolean resposta = false;
		for(Usuario userTeste: usuarios) {
			if(userTeste.getUsuario().equals(usuario) && userTeste.getSenha().equals(senha)) {
				resposta = true;
				user = new Usuario(userTeste.getNome() , userTeste.getIdade() , userTeste.getUsuario() , userTeste.getSenha());
			}
		}
		return resposta;
	}
	
	
	//Retorna o usu�rio
	public Usuario retornaUsuario() {
		return this.user;
	}

	
}
