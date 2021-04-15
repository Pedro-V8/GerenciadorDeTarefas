package model;
import java.util.*;
public class BancoUsuarios {
	
	public static Usuario user;
	ArrayList<Usuario> usuarios = new ArrayList();
	
	public void cadastraUsuario(Usuario user) {
		usuarios.add(user);


	}
	
	public void mostraUsuario() {
		for(Usuario userTeste: usuarios) {
			System.out.print(userTeste.getUsuario());
		}
	}
	
	
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
	
	
	public Usuario retornaUsuario() {
		return this.user;
	}

	
}
