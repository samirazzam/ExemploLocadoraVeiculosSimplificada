package br.senac.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import br.senac.jdbc.FabricaConexao;
import br.senac.modelo.Veiculo;



public class VeiculoDao {

	private Connection conexaoBD;
	
	public VeiculoDao() {
		conexaoBD = new FabricaConexao().getConexao();
	}//fim do construtor
	
	//M�todo para gravar dados do Ve�culo
	//telaChamada � par�metro para verificar qual janela fez a chamada e centralizar o JOptionPane
	public void gravarVeiculo(Veiculo veiculo, JInternalFrame telaChamada){
		
		String comandoSQL = "insert into tbVeiculo (placa, modeloVeiculo, anoFabricacao) values (?,?,?)";
		
		try {
			PreparedStatement stmt = conexaoBD.prepareStatement(comandoSQL);
			stmt.setString(1, veiculo.getPlaca());
			stmt.setString(2, veiculo.getModelo());
			stmt.setInt(3, veiculo.getAno());
			stmt.executeUpdate();
			stmt.close();
			JOptionPane.showMessageDialog(telaChamada, "Dados gravados com sucesso");
			fecharBanco();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(telaChamada, "Erro ao inserir um novo cliente no cadastro" +e.getMessage());
		}
	}//fim do m�todo gravarVeiculo
	
	public void fecharBanco(){
		try {
			conexaoBD.close();
		} catch (SQLException e) {
			System.out.println("N�o foi poss�vel fechar a conex�o com o banco de dados: " +e.getMessage());
		}
	}
}
