package view;
import java.awt.BorderLayout;
import model.*;
import java.awt.CardLayout;
import javax.swing.*;
import controller.*;

/**
 * Classe Principal responsável por gerar a Tela de Login e Registro, além de se comunicar com outras classes que geram os JPanels
 * @author Pedro Henrique
 * @version 1.0
 */


public class Principal {
	//Instanciando Objetos
	private static JFrame framePrincipal;
	public Cadastro controle;
	public static BancoUsuarios banco = new BancoUsuarios();
	public static Registro reg = new Registro();
	public static ListaTarefas listaTarefas;

	public static void main(String[] args) {

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
		
		//Ação do botão login 
		loginButton.addActionListener(e -> {
			String user , senha;
			user = userT.getText();
			senha = passwordText.getText();
			if(loginD.mostraUsuario(banco , user , senha)) {
				criaFrame(banco.retornaUsuario());
			}else {
				JOptionPane.showMessageDialog(null, "Erro no Login , digite novamente ou se registre.", null , JOptionPane.ERROR_MESSAGE);
				
			}
			

		});
		
		//Ação do botão Registrar
		registerButton.addActionListener(e -> {
			
			try {
				reg.criaFrameR(banco);
			} catch (Exception e2) {
				System.out.print(e2);
			}
		});
		

		frameLogin.setVisible(true);
	}
	
	
	/**
	 * Método que cria o frame após a autenticação do Login.
	 * @param usuario cadastrado
	 * @return nenhum
	 */ 
	public static void criaFrame(Usuario user) {
		framePrincipal = new JFrame("Gerenciador");
		JPanel container = new JPanel();

		container.setLayout(null);
		framePrincipal.setSize(500 , 500);
		
		JButton botaoVerTarefas = new JButton("Ver Tarefas");
		botaoVerTarefas.setBounds(170 , 150 , 150 , 25);
		container.add(botaoVerTarefas);
		
		
		JButton botao2 = new JButton("Cadastrar Tarefas");
		botao2.setBounds(170 , 250 , 150 , 25);
		container.add(botao2);

		JLabel imagem = new JLabel();
		imagem.setBounds(175 ,15 , 250 , 60);
		imagem.setIcon(new ImageIcon(Principal.class.getResource("/imagens/sunb.png")));
		container.add(imagem);
		
		JLabel nomeUser = new JLabel("Seja Bem Vindo(a) , " + user.getNome());
		nomeUser.setBounds(175 , 80 , 250 , 60);
		container.add(nomeUser);
		

		
		
	
		framePrincipal.setVisible(true);
		
		framePrincipal.add(container);
		
		botaoVerTarefas.addActionListener(e -> {

			listaTarefas = new ListaTarefas(user);
			
		});
		
		
		botao2.addActionListener(e -> {
			CadastroTarefas cadastro = new CadastroTarefas();
			container.setVisible(false);
			framePrincipal.add(cadastro.criaPanel(user));
		});
		
	}
	
	/**
	 * Método responsávelpor trocar o panel do JFrame
	 * @param recebe o JPanel no qual se deseja mostrar
	 * @return nenhum
	 */
	public static void trocaPanel(JPanel panel) {
		framePrincipal.add(panel);
	}
	

}