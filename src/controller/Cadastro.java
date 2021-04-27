package controller;
import model.*;

/**
 * Classe respons�vel por criar Objeto Usu�rios
 * @author Pedro Henrique
 * @version 1.0
 */
public class Cadastro {
	
	/**
	 * M�todo respons�vel por pegar os dados digitados e criar o objeto Usu�rio
	 * @param n , nome
	 * @param i , idade
	 * @param u , usuario
	 * @param s , senha
	 * @param banco , Banco de Dados para salvar
	 * @return nenhum
	 */
	public void criaUsuario(String n , String i , String u , String s , BancoUsuarios banco) {
		Usuario usuario = new Usuario(n , i , u , s);
		banco.cadastraUsuario(usuario);
	}
	
}
