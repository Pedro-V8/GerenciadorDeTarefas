package view;
import javax.swing.*;
import model.*;
import controller.*;

public class Registro {
	Cadastro cadastro = new Cadastro();
	
	public void criaFrameR(BancoUsuarios banco) {
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
		
		
		JTextField idadeT = new JTextField(20);
		idadeT.setBounds(150 , 120 , 30 , 23);
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
		
		
		
		botaoRegistro.addActionListener(e -> {
			if(nomeT.getText().isEmpty() || idadeT.getText().isEmpty() || usuarioT.getText().isEmpty() || senhaT.getText().isEmpty()) {
				JFrame frameE = new JFrame("Erro");
				frameE.setSize(300 , 150);
				JLabel fraseErro = new JLabel("Foram encontrados erros");
				frameE.add(fraseErro);
				frameE.setVisible(true);
			}else {

				cadastro.criaUsuario(nomeT.getText(), idadeT.getText(), usuarioT.getText(),  senhaT.getText() , banco);
				JFrame frameS = new JFrame("Sucesso");
				frameS.setSize(300 , 150);
				JLabel fraseSucesso = new JLabel("Cadastrado com Sucesso");
				frameS.add(fraseSucesso);
				frameS.setVisible(true);
				
			}
			
		});
		
		
		frame.add(panelRegistro);
		frame.setVisible(true);
	}
}
