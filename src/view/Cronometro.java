package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.*;	
import java.util.*;
import java.util.Timer;

public class Cronometro {

	private JLabel contagemTempo;
	private Timer tm;
	private int contador = 0;
	public boolean rodando = false;
	
	public void init() {
		JFrame frame = new JFrame("Cronometro");
		frame.setSize(300 , 200);
		frame.setLayout(new BorderLayout());
		
		contagemTempo = new JLabel("00:00");
		contagemTempo.setFont(new Font(contagemTempo.getName() , Font.PLAIN , 80));
		frame.add(contagemTempo , BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		
		JButton btnIniciar = new JButton("Iniciar");
		
		btnIniciar.addActionListener(e -> {
			if(!rodando) {
				tm = new Timer();
				rodando = true;
				tm.scheduleAtFixedRate( new TimerTask() {
					@Override
					public void run() {
						contador++;
						int seg = contador % 60;
						int min = contador / 60;
						min %= 60;
						
						contagemTempo.setText(String.format("%02d:%02d" , min , seg));	
					}
					
				} , 1000 , 1000);
			}
		});
		
		JButton btnParar = new JButton("Parar");
		btnParar.addActionListener(e -> {
			if(rodando) {
				tm.cancel();
				rodando = false;
				contador = 0;
			}
		});
		
		panel.add(btnIniciar);
		panel.add(btnParar);
		frame.add(panel , BorderLayout.EAST);
		frame.setVisible(true);
	
	}
	
}