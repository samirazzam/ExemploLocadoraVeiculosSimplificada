package br.senac.vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroVeiculoTemplate extends JInternalFrame {

	protected JLabel rotPlaca, rotModelo, rotAno;
	protected JTextField cxPlaca, cxModelo, cxAno;
	protected JButton btnSair;
	protected JPanel painelSuperior, painelInferior;
	
	public CadastroVeiculoTemplate(String nomeTela) {
		setTitle(nomeTela);
		setSize(650,200);
		setLocation(0, 0);
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		rotPlaca = new JLabel("Placa do veículo");
		rotModelo = new JLabel("Modelo");
		rotAno = new JLabel("Ano de fabricação");
		cxPlaca = new JTextField("");
		cxModelo = new JTextField("");
		cxAno = new JTextField("");
		
		btnSair = new JButton("Sair");
		
		painelSuperior = new JPanel();
		painelInferior = new JPanel();
		getContentPane().add(painelSuperior, BorderLayout.NORTH);
		getContentPane().add(painelInferior, BorderLayout.SOUTH);
		painelSuperior.setLayout(new GridLayout(3,2,5,5));
		painelInferior.setLayout(new GridLayout(1,1));
		
		painelSuperior.add(rotPlaca);
		painelSuperior.add(cxPlaca);
		painelSuperior.add(rotModelo);
		painelSuperior.add(cxModelo);
		painelSuperior.add(rotAno);
		painelSuperior.add(cxAno);
		
	}//fim do construtor

	protected void habilitaCampos(){
		cxPlaca.setEditable(true);
		cxModelo.setEditable(true);
		cxAno.setEditable(true);
	}//fim do método habilitaCampos
	
	protected void desabilitaCampos(){
		cxPlaca.setEditable(false);
		cxModelo.setEditable(false);
		cxAno.setEditable(false);
	}//fim do método desabilitaCampos
	
	protected void limparCampos(){
		cxPlaca.setText("");
		cxModelo.setText("");
		cxAno.setText("");
	}//fim do método limparCampos
	
	protected void fechar(){
		desabilitaCampos();
		this.hide();
	}//fim do método fechar
	
}//Fim da classe
