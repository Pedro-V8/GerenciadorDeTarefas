package model;

import java.util.ArrayList;

/**
 * Classe respons�vel por gerar objeto Usu�rio
 * @author Pedro Vieira
 * @version 1.0
 */	
public class Usuario {
	//Atributos
	private String nome;
	private String idade;
	private String usuario;
	private String senha;
	private ArrayList <Tarefa> tarefa = new ArrayList();
	
	//Construtor
	public Usuario(String n , String i , String u , String s) {
		nome = n;
		idade = i;
		usuario = u;
		senha = s;
	}
	
	//M�todos Getters e Setters
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String vNome) {
		nome = vNome;
	}
	
	
	public String getIdade() {
		return this.idade;
	}
	
	public void setIdade(String vIdade) {
		idade = vIdade;
	}
	
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public void setUsuario(String vUsuario) {
		usuario = vUsuario;
	}
	
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setSenha(String vSenha) {
		senha = vSenha;
	}
	
	
	//M�todo para salvar tarefa no arrayList
	public void salvaTarefa(Tarefa tar) {
		tarefa.add(tar);
	}
	
	/**
	 * M�todo para retornar as tarefas, nesse caso retorna apenas a descri��o
	 * @param nenhum
	 * @return array do tipo string
	 */
	public String[] retornaTarefa() {
		String tarefasD[] = new String[tarefa.size()];
		for(int i = 0; i < tarefa.size(); i++) {
			tarefasD[i] = tarefa.get(i).getDescricao();
		}
		return tarefasD;
	}
	

}