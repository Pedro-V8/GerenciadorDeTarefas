package view;
import java.awt.BorderLayout;
import model.*;
import java.awt.CardLayout;
import javax.swing.*;
import controller.*;

public class Principal {
	//Instanciando Objetos
	private static JFrame framePrincipal;
	public Cadastro controle;
	public static BancoUsuarios banco = new BancoUsuarios();
	public static Registro reg = new Registro();
	public static ListaTarefas listaTarefas;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Login loginD = new Login(); //Objeto Login para entrar no sistema
		JFrame frameLogin = new JFrame("Login");

		//Colcando os componentes
		frameLogin.setSize(300,150);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		
		panel.setLayout(null);
		
		JLabel userL = new JLabel("Usuário");
		userL.setBounds(10 , 10 , 80 , 25);
		panel.add(userL);
		
		JTextField userT = new JTextField(20);
		userT.setBounds(100 , 10 , 160 , 25);
		panel.add(userT);
		
		JLabel passwordLable = new JLabel("Senha");
		passwordLable.setBounds(10 , 40 , 80 , 25);
		panel.add(passwordLable);
		
		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100 , 40 , 160 , 25);
		panel.add(passwordText);
		
		JButton loginButton = new JButton("Entrar");
		loginButton.setBounds(10 , 80 , 90 , 25);
		panel.add(loginButton);
		
		JButton registerButton = new JButton("Registrar");
		registerButton.setBounds(180 , 80 , 90 , 25);
		panel.add(registerButton);
		
		
		frameLogin.add(panel);
		
		//Ação do botão Login
		loginButton.addActionListener(e -> {
			String user , senha;
			user = userT.getText();
			senha = passwordText.getText();
			if(loginD.mostraUsuario(banco , user , senha)) {
				criaFrame(banco.retornaUsuario());
			}else {
				JFrame frameE = new JFrame("Erro");
				frameE.setSize(300 , 150);
				JLabel fraseErro = new JLabel("Erro no Login , digite novamente ou se registre.");
				frameE.add(fraseErro);
				frameE.setVisible(true);
			}
			

		});
		
		//Ação do botão Registrar
		registerButton.addActionListener(e -> {
			
			reg.criaFrameR(banco);
		});
		


		frameLogin.setVisible(true);
	}
	
	
	public static void criaFrame(Usuario user) {
		framePrincipal = new JFrame("Heelo doido");
		JPanel container = new JPanel();

		container.setLayout(null);
		framePrincipal.setSize(500 , 500);
		JButton botaoVerTarefas = new JButton("Ver Tarefas");
		JButton botao2 = new JButton("Cadastrar Tarefas");
		JButton botao3 = new JButton("Realizar Tarefas");
		
		botaoVerTarefas.setBounds(170 , 110 , 150 , 25);
		botao2.setBounds(170 , 210 , 150 , 25);
		botao3.setBounds(170 , 310 , 150 , 25);
		
		container.add(botaoVerTarefas);
		container.add(botao2);
		container.add(botao3);
		
		
	
		framePrincipal.setVisible(true);
		
		framePrincipal.add(container);
		
		botaoVerTarefas.addActionListener(e -> {

			//container.setVisible(false);
			listaTarefas = new ListaTarefas(user);
			
			//frameP.add(); 
		});
		
		
		botao2.addActionListener(e -> {
			CadastroTarefas cadastro = new CadastroTarefas();
			container.setVisible(false);
			framePrincipal.add(cadastro.criaPanel(user));
		});
		
	}
	
	public static void trocaPanel(JPanel panel) {
		framePrincipal.add(panel);
	}
	

}