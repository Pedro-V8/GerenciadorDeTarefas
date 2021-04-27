package view;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import model.*;
import controller.*;

/**
 * Classe responsável por cadastrar usuário
 * @author Pedro Henrique
 * @version 1.0
 */

public class Registro {
	
	Cadastro cadastro = new Cadastro(); // Instancia objeto que está presente em Controller
	
	/**
	 * Método responsável por criar o frame registro e salvar no Banco de Dados
	 * @param um objeto instanciado da Classe BancoUsuarios, para salvar o Usuário Registrado
	 * @return nenhum
	 */
	public void criaFrameR(BancoUsuarios banco) throws ParseException{
		
		//Inciando JFrame e componentes
		JFrame frame = new JFrame("Registro");
		frame.setSize(500 , 500);
		JPanel panelRegistro = new JPanel();
		panelRegistro.setLayout(null);
		
		JLabel frase = new JLabel("Nome");
		frase.setBounds(100 , 70 , 150 , 20);
		panelRegistro.add(frase);
		
		JTextField nomeT = new JTextField(20);
		nomeT.setBounds(150 , 70 , 170, 23);
		panelRegistro.add(nomeT);
		
		JLabel idadeL  = new JLabel("Idade");
		idadeL.setBounds(100, 120, 150, 20);
		panelRegistro.add(idadeL);
		
		
		
		JFormattedTextField idadeT;
		MaskFormatter formatoIdade = new MaskFormatter("##");
		
		idadeT = new JFormattedTextField(formatoIdade);
		idadeT.setBounds(150 , 120 , 45 , 23);
		panelRegistro.add(idadeT);
		
		
		JLabel usuarioL = new JLabel("Usuário");
		usuarioL.setBounds(100 , 170 , 150 , 20);
		panelRegistro.add(usuarioL);
		
		JTextField usuarioT = new JTextField(20);
		usuarioT.setBounds(150 , 170 , 170 , 23);
		panelRegistro.add(usuarioT);
		
		
		JLabel senhaL = new JLabel("Senha");
		senhaL.setBounds(100 , 220 , 150 , 20);
		panelRegistro.add(senhaL);
		
		JPasswordField senhaT = new JPasswordField(20);
		senhaT.setBounds(150 , 220 , 170 , 23);
		panelRegistro.add(senhaT);
		
		JButton botaoRegistro = new JButton("Registrar");
		botaoRegistro.setBounds(170 , 270 , 100 , 30);
		panelRegistro.add(botaoRegistro);
		
		
		//Ação botão Registro
		botaoRegistro.addActionListener(e -> {
			VerificaDados verificaDados = new VerificaDados();
			String nome = nomeT.getText();
			String idade = idadeT.getText();
			String usuario = usuarioT.getText();
			String senha = senhaT.getText();
			if(verificaDados.verifica(nome , idade , usuario , senha) == false) {

				JOptionPane.showMessageDialog(null, "Foram encontrados erros", null , JOptionPane.ERROR_MESSAGE);

			}else {
				cadastro.criaUsuario(nomeT.getText(), idadeT.getText(), usuarioT.getText(),  senhaT.getText() , banco);

				JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");

				
			}
			
		});
		
		
		frame.add(panelRegistro);
		frame.setVisible(true);
	}
}
