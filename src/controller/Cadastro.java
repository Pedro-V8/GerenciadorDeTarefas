package controller;
import model.*;

public class Cadastro {
	
	//M�todo para criar Usu�rio e Salvar no Banco
	public void criaUsuario(String n , String i , String u , String s , BancoUsuarios banco) {
		Usuario usuario = new Usuario(n , i , u , s);
		banco.cadastraUsuario(usuario);
	}
	
}
