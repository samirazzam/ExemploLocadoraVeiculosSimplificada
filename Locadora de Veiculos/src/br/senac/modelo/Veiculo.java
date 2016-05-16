package br.senac.modelo;

public class Veiculo {
	
	//Atributos da classe
	private String placa;
	private String modelo;
	private int ano;
	private boolean alugado;
	
	//M�todo construtor 1- vazio
	public Veiculo() {
		//Para instanciar um objeto vazio quando necess�rio
	}
	
	//M�todo construtor 2 - por par�metro
	public Veiculo(String placa, String modelo, int ano){
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
	}
	
	//M�todos getters & setters
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}

	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}

}//fim da classe
