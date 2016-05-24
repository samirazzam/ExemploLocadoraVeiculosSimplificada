package br.senac.vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import br.senac.jdbc.dao.ClienteDao;
import br.senac.modelo.Cliente;

public class CadastroCliente extends CadastroClienteTemplate{
	
	protected JButton btnNovo, btnSalvar, btnLimpar, btnCancelar;
	Cliente novoCliente;
	ClienteDao clienteDao;
	
	public CadastroCliente() {
		super("Dados cadastrais de cliente");
		desabilitaCampos();
		
		btnNovo = new JButton("Novo cadastro");
		btnSalvar = new JButton("Salvar cadastro");
		btnCancelar = new JButton("Cancelar");
		btnLimpar = new JButton("Limpar campos");
		
		
		painelInferior.setLayout(new GridLayout(1,4));
		
		painelInferior.add(btnNovo);
		painelInferior.add(btnSalvar);
		painelInferior.add(btnLimpar);
		painelInferior.add(btnCancelar);
		painelInferior.add(btnSair);
		
		btnCancelar.setEnabled(false);
		
		CliqueListener ouvinte = new CliqueListener();
		btnNovo.addActionListener(ouvinte);
		btnSalvar.addActionListener(ouvinte);
		btnCancelar.addActionListener(ouvinte);
		btnLimpar.addActionListener(ouvinte);
		btnSair.addActionListener(ouvinte);
		
	}//fim do construtor
	
	//Método para criar um novo registro
	protected void novoRegistroCliente(){
		btnNovo.setEnabled(false);
		novoCliente = new Cliente();
		habilitaCampos();
		limparCampos();
		btnCancelar.setEnabled(true);
	}//fim do método novoRegistroCliente
	
	//Método para salvar registro
	protected void salvarRegistroCliente(){
		
		if(cxCNH.getText().equals("") || cxNome.getText().equals("") || cxValidadeCNH.getText().equals("")){
			JOptionPane.showMessageDialog(this, "Os campos do formulário são de preenchimento obrigatório");
		}else{
			novoCliente.setCNH(cxCNH.getText());
			novoCliente.setAnoValidadeCNH(Integer.parseInt(cxValidadeCNH.getText()));
			novoCliente.setNome(cxNome.getText());
			
			clienteDao = new ClienteDao();
			clienteDao.gravarCliente(novoCliente, this);
			limparCampos();
			desabilitaCampos();
			btnNovo.setEnabled(true);
			btnCancelar.setEnabled(false);
		}
	}
	
	@Override
	protected void fechar() {
		btnNovo.setEnabled(true);
		btnCancelar.setEnabled(false);
		super.fechar();
	}
	
	protected void cancelar(){
		btnNovo.setEnabled(true);
		limparCampos();
		desabilitaCampos();
		btnCancelar.setEnabled(false);
	}

	private class CliqueListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//Capturando o botão acionado
			String textoEvento = e.getActionCommand();
			
			switch (textoEvento) {
			case "Sair":
				fechar();
				break;
			case "Salvar cadastro":
				salvarRegistroCliente();
				break;
			case "Novo cadastro":
				novoRegistroCliente();
				break;
			case "Limpar campos":
				limparCampos();
				break;
			case "Cancelar":
				cancelar();
			default:
				break;
			}
			
		}
		
	}
}
