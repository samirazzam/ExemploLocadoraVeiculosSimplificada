package br.senac.vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class CadastroClienteTemplate extends JInternalFrame{
	
	protected JLabel rotNome, rotCNH, rotValidadeCNH;
	protected JTextField cxNome, cxCNH, cxValidadeCNH;
	protected JButton btnSair;
	protected JPanel painelSuperior, painelInferior;
	
	public CadastroClienteTemplate(String nomeTela) {
		setTitle(nomeTela);
		setSize(650,200);
		setLocation(0, 0);
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		rotNome = new JLabel("Nome completo");
		rotCNH = new JLabel("N� carteira habilita��o");
		rotValidadeCNH = new JLabel("Ano de validade da CNH");
		cxNome = new JTextField("");
		cxCNH = new JTextField("");
		cxValidadeCNH = new JTextField("");
		
		btnSair = new JButton("Sair");
		
		painelSuperior = new JPanel();
		painelInferior = new JPanel();
		getContentPane().add(painelSuperior, BorderLayout.NORTH);
		getContentPane().add(painelInferior, BorderLayout.SOUTH);
		painelSuperior.setLayout(new GridLayout(3,2,5,5));
		painelInferior.setLayout(new GridLayout(1,1));
		
		painelSuperior.add(rotNome);
		painelSuperior.add(cxNome);
		painelSuperior.add(rotCNH);
		painelSuperior.add(cxCNH);
		painelSuperior.add(rotValidadeCNH);
		painelSuperior.add(cxValidadeCNH);
		
	}//fim do construtor

	protected void habilitaCampos(){
		cxNome.setEditable(true);
		cxCNH.setEditable(true);
		cxValidadeCNH.setEditable(true);
	}//fim do m�todo habilitaCampos
	
	protected void desabilitaCampos(){
		cxNome.setEditable(false);
		cxCNH.setEditable(false);
		cxValidadeCNH.setEditable(false);
	}//fim do m�todo desabilitaCampos
	
	protected void limparCampos(){
		cxNome.setText("");
		cxCNH.setText("");
		cxValidadeCNH.setText("");
	}//fim do m�todo limparCampos
	
	protected void fechar(){
		desabilitaCampos();
		this.hide();
	}//fim do m�todo fechar
	
}//fim da classe

