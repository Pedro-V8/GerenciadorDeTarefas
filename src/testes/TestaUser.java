package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.BancoUsuarios;
import controller.VerificaDados;
import model.Usuario;

class TestaUser {

	Usuario usuario = new Usuario("Pedro" , "19" , "PedroV9" , "123");
	BancoUsuarios banco = new BancoUsuarios();
	VerificaDados verificaDados = new VerificaDados();
	
	@Test
	void testCadastraUsuario() {
		assertTrue(verificaDados.verifica("Pedro", "20", "PedroV10", "123123"));
		
	}
	
	

	@Test
	void testAutenticaUsuario() {
		banco.cadastraUsuario(usuario);
		assertTrue(banco.autenticaUsuario(usuario.getUsuario(), usuario.getSenha()));
	}
	

}
