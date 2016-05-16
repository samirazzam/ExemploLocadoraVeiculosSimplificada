package br.senac.modelo;

public class Cliente {

	//Atributos da classe
	private String nome;
	private String CNH;
	private int anoValidadeCNH;
	
	//M�todo construtor 1 - vazio
	public Cliente() {
		//Para instanciar um objeto vazio quando necess�rio
	}
	
	//M�todo construtor 2 - por par�metro
	public Cliente(String nome, String CNH, int anoValidadeCNH){
		this.nome = nome;
		this.CNH = CNH;
		this.anoValidadeCNH = anoValidadeCNH;
	}
	
	//M�todos getters & setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCNH() {
		return CNH;
	}
	public void setCNH(String cNH) {
		CNH = cNH;
	}
	public int getAnoValidadeCNH() {
		return anoValidadeCNH;
	}
	public void setAnoValidadeCNH(int anoValidadeCNH) {
		this.anoValidadeCNH = anoValidadeCNH;
	}

}//fim da classe
