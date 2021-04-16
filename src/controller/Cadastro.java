package controller;
import model.*;

public class Cadastro {
	
	public void criaUsuario(String n , String i , String u , String s , BancoUsuarios banco) {
		Usuario usuario = new Usuario(n , i , u , s);
		banco.cadastraUsuario(usuario);
	}
	
}
