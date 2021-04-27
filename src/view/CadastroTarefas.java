package view;
import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import controller.*;
import model.*;

import javax.swing.*;

/**
 * Classe respons�vel por criar o JPanel de cadastro de Tarefas
 * @author Pedro Henrique
 * @version 1.0
 */

public class CadastroTarefas {
	
	/**
	 * M�todo Respons�vel por criar o JPanel de registro de Tarefas
	 * @param usu�rio para relacionar as tarefas registradas
	 * @return jpanel para ser adicionado no jframe
	 */
	public JPanel criaPanel(Usuario user) { //Recebe Usuario para ter informa��es necess�rias
		
		//Implementando os componentes
		JPanel panelCadastro = new JPanel();
		panelCadastro.setLayout(null);
		JLabel frase = new JLabel("Digite a Descri��o");
		frase.setBounds(170 , 40 , 200 , 50);
		panelCadastro.add(frase);
		
		
		JTextField texto = new JTextField(40);
		texto.setBounds(150 , 90 , 150, 50);
		panelCadastro.add(texto);
		
		
		JLabel frase2 = new JLabel("Digite o Tipo");
		frase2.setBounds(185 , 150 , 200 , 50);
		panelCadastro.add(frase2);
		
		
		
		JRadioButton opcao1 =new JRadioButton("Baixa");  
		opcao1.setBounds(190 , 190 , 100 , 30); 
		
		JRadioButton opcao2 =new JRadioButton("M�dia");  
		opcao2.setBounds(190 , 220 , 100 , 30);  
		
		JRadioButton opcao3 =new JRadioButton("Alta");  
		opcao3.setBounds(190 , 250 , 100 , 30);  
		
		panelCadastro.add(opcao1);
		panelCadastro.add(opcao2);
		panelCadastro.add(opcao3);
		
		
		JButton botaoCadastro = new JButton("Cadastrar");
		botaoCadastro.setBounds(170 , 300 , 110 , 25);
		panelCadastro.add(botaoCadastro);
		
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setBounds(170 , 340 , 110 , 25);
		panelCadastro.add(botaoVoltar);
		
		
		panelCadastro.setVisible(true);
		
		//A��o do Bot�o Cadastro
		botaoCadastro.addActionListener(e -> {
			
			if(opcao1.isSelected()) {
				// data/hora atual
				LocalDateTime agora = LocalDateTime.now();

				// formatar a data
				DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
				String data = formatterData.format(agora);
				
				
				Tarefa tarefa = new Tarefa(texto.getText() , "aberto" , "Baixa" , data);
				user.salvaTarefa(tarefa);
				
				JFrame frame = new JFrame("Sucesso");
				frame.setSize(300,150);
				JLabel fraseSucesso = new JLabel("Cadastrado com Sucesso1");
				frame.add(fraseSucesso);
				frame.setVisible(true);		
				//user.mostraTarefas();
			}else if(opcao2.isSelected()) {
				// data/hora atual
				LocalDateTime agora = LocalDateTime.now();

				// formatar a data
				DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
				String data = formatterData.format(agora);
				
				
				Tarefa tarefa = new Tarefa(texto.getText() , "aberto" , "M�dia" , data);
				user.salvaTarefa(tarefa);
				

				
				JFrame frame = new JFrame("Sucesso");
				frame.setSize(300,150);
				JLabel fraseSucesso = new JLabel("Cadastrado com Sucesso1");
				frame.add(fraseSucesso);
				frame.setVisible(true);	
			}else if(opcao3.isSelected()) {
				// data/hora atual
				LocalDateTime agora = LocalDateTime.now();

				// formatar a data
				DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
				String data = formatterData.format(agora);
				
				
				Tarefa tarefa = new Tarefa(texto.getText() , "aberto" , "M�dia" , data);
				user.salvaTarefa(tarefa);
				
				
				JFrame frame = new JFrame("Sucesso");
				frame.setSize(300,150);
				JLabel fraseSucesso = new JLabel("Cadastrado com Sucesso");
				frame.add(fraseSucesso);
				frame.setVisible(true);	
			}else {
				JFrame frame = new JFrame("Erro");
				frame.setSize(300,150);
				JLabel fraseErro = new JLabel("Foram Encontrados Erros, tente novamente");
				frame.add(fraseErro);
				frame.setVisible(true);	
			}

			
		});
		
		//A��o do bot�o voltar
		botaoVoltar.addActionListener(e -> {
			Principal princ = new Principal();
			panelCadastro.setVisible(false);
			princ.criaFrame(user);

		});

		return panelCadastro;
		
	}
}