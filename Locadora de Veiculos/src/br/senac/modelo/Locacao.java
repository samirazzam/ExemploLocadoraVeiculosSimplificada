package br.senac.modelo;

import java.util.Calendar;
import java.util.Date;


public class Locacao {

	//Atributos da classe
	private int idLocacao;
	private Calendar dataLocacao; //usando formato data de Calendar
	private Calendar dataDevolucao;
	Cliente cliente;
	Veiculo veiculo;
	
	//Métodos getters & setters
	public Calendar getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(Calendar dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	
	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	public int getIdLocacao() {
		return idLocacao;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	//Método para alugar veiculo
	public void alugarVeiculo(Calendar dataLocacao, Cliente cliente, Veiculo veiculo){
		this.dataLocacao = dataLocacao;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.veiculo.setAlugado(true);

	}
	
	//Método para devolução do veículo
	public void devolverVeiculo(Calendar dataDevolucao, Cliente cliente, Veiculo veiculo){
		this.dataDevolucao = dataDevolucao;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.veiculo.setAlugado(false);
	};
	

	
}//fim da classe
