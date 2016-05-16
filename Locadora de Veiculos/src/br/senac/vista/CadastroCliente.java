package br.senac.vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CadastroCliente extends CadastroClienteTemplate{
	
	protected JButton btnNovo, btnSalvar, btnLimpar;
	
	public CadastroCliente() {
		super("Dados cadastrais de cliente");
		desabilitaCampos();
		
		btnNovo = new JButton("Novo cadastro");
		btnSalvar = new JButton("Salvar cadastro");
		btnLimpar = new JButton("Limpar campos");
		
		
		painelInferior.setLayout(new GridLayout(1,4));
		
		painelInferior.add(btnNovo);
		painelInferior.add(btnSalvar);
		painelInferior.add(btnLimpar);
		painelInferior.add(btnFechar);
		
		CliqueListener ouvinte = new CliqueListener();
		btnNovo.addActionListener(ouvinte);
		btnSalvar.addActionListener(ouvinte);
		btnLimpar.addActionListener(ouvinte);
		btnFechar.addActionListener(ouvinte);
		
	}//fim do construtor

	private class CliqueListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
