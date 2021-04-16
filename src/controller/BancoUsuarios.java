package controller;
import java.util.*;

import model.Usuario;
public class BancoUsuarios {
	
	private static Usuario user; //Declarando objeto do tipo Usuario
	ArrayList<Usuario> usuarios = new ArrayList(); //ArrayList para salvar os Usu�rios Registrados
	
	//Salva Usu�rio no ArrayList
	public void cadastraUsuario(Usuario user) {
		usuarios.add(user);

	}
	
	//M�todo para verificar se o Usu�rio est� cadastrado, retornando 1 para sim e 0 para n�o.
	public int autenticaUsuario(String usuario , String senha) {
		int resposta = 0;
		for(Usuario userTeste: usuarios) {
			if(userTeste.getUsuario().equals(usuario) && userTeste.getSenha().equals(senha)) {
				resposta = 1;
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
