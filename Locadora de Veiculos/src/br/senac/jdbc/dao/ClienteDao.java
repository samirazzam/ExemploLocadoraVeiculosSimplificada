package br.senac.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import br.senac.jdbc.FabricaConexao;
import br.senac.modelo.Cliente;

public class ClienteDao {
	
	private Connection conexaoBD;
	
	public ClienteDao() {
		conexaoBD = new FabricaConexao().getConexao();
	}//fim do construtor
	
	//M�todo para gravar dados do cliente no banco de dados
	//telaChamada � um par�metro para ver quem chamou o m�todo e centralizar o JOptionPane
	public void gravarCliente(Cliente cliente, JInternalFrame telaChamada){
		
		String comandoSQL = "insert into tbCliente (CNH, nomeCliente, anoValidadeCNH) values (?,?,?)";
		
		try {
			PreparedStatement stmt = conexaoBD.prepareStatement(comandoSQL);
			stmt.setString(1, cliente.getCNH());
			stmt.setString(2, cliente.getNome());
			stmt.setInt(3, cliente.getAnoValidadeCNH());
			stmt.executeUpdate();
			stmt.close();
			JOptionPane.showMessageDialog(telaChamada, "Dados gravados com sucesso");
			fecharBanco();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(telaChamada, "Erro ao inserir um novo cliente no cadastro" +e.getMessage());
		}
		
	}//fim do m�todo gravarCliente
	
	public void fecharBanco(){
		
		try {
			conexaoBD.close();
		} catch (SQLException e) {
			System.out.println("N�o foi poss�vel fechar a conex�o com o banco de dados: " +e.getMessage());
		}
	}//fim do m�todo fecharBanco

}//fim da classe
