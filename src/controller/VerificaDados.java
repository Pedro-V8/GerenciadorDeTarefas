package controller;

public class VerificaDados {
	
	public boolean verifica(String nome , String idade , String user , String senha) {
		boolean resposta = true;
		if(nome.equals("") || idade.equals("") || user.equals("") || senha.equals("")) {
			resposta = false;
		}
		
		return resposta;
	}

}

