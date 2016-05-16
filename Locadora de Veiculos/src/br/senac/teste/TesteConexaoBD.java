package br.senac.teste;

import java.sql.Connection;
import br.senac.jdbc.FabricaConexao;


public class TesteConexaoBD {
	
	public static void main(String[] args) {
		
		Connection conexao = new FabricaConexao().getConexao();
	}
}
