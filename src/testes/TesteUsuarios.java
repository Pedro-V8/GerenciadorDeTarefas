package testes;

import static org.junit.jupiter.api.Assertions.*;

import controller.*;
import model.*;

import org.junit.jupiter.api.Test;

class TesteUsuarios {
	
	Usuario usuario = new Usuario("Pedro" , "19" , "PedroV9" , "123");
	BancoUsuarios banco = new BancoUsuarios();
	VerificaDados verificaDados = new VerificaDados();
	@Test
	void testCadastraUsuario() {
		assertTrue(verificaDados.verifica("Pedro", "20", "PedroV10", "123123"));
	}
	
	@Test
	void testSalvaUsuario() {
		assertTrue(banco.autenticaUsuario(usuario.getUsuario(), usuario.getSenha()));
	}

}
