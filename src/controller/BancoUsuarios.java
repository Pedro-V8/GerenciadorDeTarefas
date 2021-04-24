package controller;
import java.util.*;

import model.Usuario;
public class BancoUsuarios {
	
	private static Usuario user; //Declarando objeto do tipo Usuario
	ArrayList<Usuario> usuarios = new ArrayList(); //ArrayList para salvar os Usuários Registrados
	
	//Salva Usuário no ArrayList
	public void cadastraUsuario(Usuario user) {
		usuarios.add(user);

	}
	
	//Método para verificar se o Usuário está cadastrado, retornando 1 para sim e 0 para não.
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
	
	
	//Retorna o usuário
	public Usuario retornaUsuario() {
		return this.user;
	}

	
}
