package view;

import java.awt.BorderLayout;
import model.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ListaTarefas extends JFrame {

	//Construtor que rece User e Inicia método listaTarefas
	public ListaTarefas(Usuario user) {
		listaTarefas(user);

	}


	public void listaTarefas(Usuario user) {
		//Criando componentes
		setTitle("Lista");
		setSize(335 , 210);
		setLocationRelativeTo(null);
		setVisible(true);
		String[] tarefas =user.retornaTarefa(); //Adiconando as tarefas salvas no array
		JList lista = new JList(tarefas);
		lista.setLocation(50, 0);
		getContentPane().add(BorderLayout.CENTER , lista);
		
		//Criando ação que ao clicar na tarefa, abre o temporizador
		lista.addListSelectionListener(e -> {
			if(!e.getValueIsAdjusting()) {
				Cronometro cron = new Cronometro();
				cron.init();
			}
			//user.testaTarefa(lista.getSelectedIndex());
		});
	}

}
