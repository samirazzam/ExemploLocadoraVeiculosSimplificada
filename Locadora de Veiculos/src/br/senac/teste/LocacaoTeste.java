package br.senac.teste;

import br.senac.modelo.Cliente;
import br.senac.modelo.Locacao;
import br.senac.modelo.Veiculo;
import br.senac.utilidades.ConversorData;

public class LocacaoTeste {

	public static void main(String[] args) {

		Cliente cliente = new Cliente("Samir", "159357", 2019);
		Veiculo veiculo = new Veiculo("KOG 8722", "Renault Duster", 2015);
		Locacao locacao1 = new Locacao();
		String dataAluguel = "01/05/2016";

		locacao1.alugarVeiculo(ConversorData.stringToCalendar(dataAluguel), cliente, veiculo);

		System.out.println("Nome: " +locacao1.getCliente().getNome());
		System.out.println("Modelo: " +locacao1.getVeiculo().getModelo());
		System.out.println("Placa: " +locacao1.getVeiculo().getPlaca());
		System.out.println("Data locação: " +ConversorData.calendarToString(locacao1.getDataLocacao()));
		System.out.println("Status do carro - Alugado? " +locacao1.getVeiculo().isAlugado());


		System.out.println("------------------------------------");

		String dataDevolucao = "16/05/2016";

		locacao1.devolverVeiculo(ConversorData.stringToCalendar(dataDevolucao), cliente, veiculo);

		System.out.println("Nome: " +locacao1.getCliente().getNome());
		System.out.println("Modelo: " +locacao1.getVeiculo().getModelo());
		System.out.println("Placa: " +locacao1.getVeiculo().getPlaca());
		System.out.println("Data devolução: " +ConversorData.calendarToString(locacao1.getDataDevolucao()));
		System.out.println("Status do carro - Alugado? " +locacao1.getVeiculo().isAlugado());
	}

}
