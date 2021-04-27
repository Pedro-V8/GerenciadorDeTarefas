package model;

import java.util.Date;

/**
 * Classe responsável por gerar objeto Tarefa
 * @author Pedro Vieira
 * @version 1.0
 */	
public class Tarefa {
	//Declarando Atributos
	private String descricao;
	private String status;
	private String tipo;
	private String dataInicial;
	private Date dataFinal;
	
	//Construtor
	public Tarefa(String d , String s , String t , String dI) {
		descricao = d;
		status = s;
		tipo = t;
		dataInicial = dI;
	}
	//Getters e Setters
	public String getDescricao(){
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
}