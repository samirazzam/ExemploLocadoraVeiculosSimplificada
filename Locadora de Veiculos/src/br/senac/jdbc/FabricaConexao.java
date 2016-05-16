package br.senac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	public Connection getConexao(){
		
		try{
			Connection driverConexao = DriverManager.getConnection("jdbc:mysql://localhost/locadoraveiculos?autoReconnect=false&useSSL=false", "javaUser", "senac");
			System.out.println("Conex�o com o banco de dados bem sucedida");
			return driverConexao;
		}catch(SQLException e){
			System.out.println("Erro ao conectar com o banco de dados: " +e.getMessage());
			return null;
		}
	}//fim do m�todo getConexao
	
}//fim da classe
