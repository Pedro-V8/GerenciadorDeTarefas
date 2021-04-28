package controller;

/**
 * Classe respons�vel por verificar se foi digitado corretamente os campos de texto
 * @author Pedro Henrique
 * @version 1.0
 */
public class VerificaDados {
	
	/**
	 * M�todo de verifica��o dos dados digitados
	 * @param nome
	 * @param idade
	 * @param user
	 * @param senha
	 * @return booleano, onde true representa que o usu�rio digitou corretamente e false que o usu�rio digitou algo errado.
	 */
	public boolean verifica(String nome , String idade , String user , String senha) {
		boolean resposta = true;
		if(nome.equals("") || idade.equals("") || user.equals("") || senha.equals("")) {
			resposta = false;
		}
		
		return resposta;
	}

}

