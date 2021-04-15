package view;

import java.awt.BorderLayout;
import model.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ListaTarefas extends JFrame {
	
	public ListaTarefas(Usuario user) {
		listaTarefas(user);

	}

	//private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public void listaTarefas(Usuario user) {
		setTitle("Lista");
		setSize(335 , 210);
		setLocationRelativeTo(null);
		setVisible(true);
		String[] paises =user.retornaTarefa();
		JList lista = new JList(paises);
		lista.setLocation(50, 0);
		getContentPane().add(BorderLayout.CENTER , lista);
		
		lista.addListSelectionListener(e -> {
			if(!e.getValueIsAdjusting()) {
				Cronometro cron = new Cronometro();
				cron.init();
			}
			//user.testaTarefa(lista.getSelectedIndex());
		});
	}
	
	public JList criaLista(Usuario user) {

		JList lista = new JList( user.retornaTarefa());
		return lista;
	}

}
