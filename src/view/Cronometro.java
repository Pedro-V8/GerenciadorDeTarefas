package view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.*;	
import java.util.*;
import java.util.Timer;

/**
 * Classe respons�vel por gerar o JFrame com o Cron�metro
 * @author Pedro Henrique
 * @version 1.0
 */
public class Cronometro {

	//Iniciando atributos necess�rios para a constru��o do Cron�metro
	private JLabel contagemTempo;
	private Timer tm;
	private int contador = 0;
	public boolean rodando = false;
	
	/**
	 * M�todo respons�vel por criar o JFrame com os componentes do Cron�metro
	 * @param nenhum
	 * @return nenhum
	 */
	public void init() {
		//Criando o frame e componentes
		JFrame frame = new JFrame("Cronometro");
		frame.setSize(300 , 200);
		frame.setLayout(new BorderLayout());
		
		contagemTempo = new JLabel("00:00");
		contagemTempo.setFont(new Font(contagemTempo.getName() , Font.PLAIN , 80));
		frame.add(contagemTempo , BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		
		JButton btnIniciar = new JButton("Iniciar");
		
		//A��o do bot�o Iniciar
		btnIniciar.addActionListener(e -> {
			if(!rodando) {
				tm = new Timer(); //Instanciando Timer
				rodando = true;
				//M�todo sobreescrito para mostar segundos e minutos
				tm.scheduleAtFixedRate( new TimerTask() {
					@Override
					public void run() {
						contador++;
						int seg = contador % 60;
						int min = contador / 60;
						min %= 60;
						
						contagemTempo.setText(String.format("%02d:%02d" , min , seg)); //Mostrando o tempo na tela
					}
					
				} , 1000 , 1000);
			}
		});
		
		//A��o do bot�o Parar
		JButton btnParar = new JButton("Parar");
		btnParar.addActionListener(e -> {
			if(rodando) {
				tm.cancel();
				rodando = false;
				contador = 0;
			}
		});
		
		//Adicionando componentes no JFrame
		panel.add(btnIniciar);
		panel.add(btnParar);
		frame.add(panel , BorderLayout.EAST);
		frame.setVisible(true);
	
	}
	
}