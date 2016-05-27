package br.senac.vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import br.senac.jdbc.dao.ClienteDao;
import br.senac.modelo.Cliente;

public class PesquisaCliente extends CadastroClienteTemplate{
	
	protected JButton btnPesquisar;
	Cliente clientePesquisa;
	ClienteDao clienteDao;
	
	public PesquisaCliente() {
		super("Pesquisa de dados de cliente");
		desabilitaCampos();
		
		btnPesquisar = new JButton("Pesquisar");
		
		painelInferior.setLayout(new GridLayout(1,4));
		painelInferior.add(btnPesquisar);
		painelInferior.add(btnSair);
		
		CliqueListener ouvinte = new CliqueListener();
		btnPesquisar.addActionListener(ouvinte);
		btnSair.addActionListener(ouvinte);
		
	}//fim do construtor
	
	//Método para buscar dados de um cliente
	protected void pesquisarCliente(){
		clientePesquisa = new Cliente();
		clienteDao = new ClienteDao();
		
		String CNHPesquisa = JOptionPane.showInputDialog(this,"Digite o CNH para pesquisa");
		clientePesquisa = clienteDao.buscaPorCNH(this, CNHPesquisa);
		String checarResultado = clientePesquisa.getNome();
		
		if (checarResultado == null){
			cxNome.setText("Cliente inexistente");
			cxCNH.setText("");
			cxValidadeCNH.setText("");
		}else{
			cxCNH.setText(clientePesquisa.getCNH());
			cxNome.setText(clientePesquisa.getNome());
			cxValidadeCNH.setText(String.valueOf(clientePesquisa.getAnoValidadeCNH()));
		}
		
	}//fim método pesquisarCliente
	
	private class CliqueListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnPesquisar){
				pesquisarCliente();
			}else{
				fechar();
			}	
		}
		
	}//fim da inner class

}//fim da classe
