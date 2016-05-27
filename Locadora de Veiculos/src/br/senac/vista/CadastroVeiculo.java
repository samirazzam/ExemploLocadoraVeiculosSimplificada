package br.senac.vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import br.senac.jdbc.dao.ClienteDao;
import br.senac.jdbc.dao.VeiculoDao;
import br.senac.modelo.Cliente;
import br.senac.modelo.Veiculo;

public class CadastroVeiculo extends CadastroVeiculoTemplate{

	protected JButton btnNovo, btnSalvar, btnLimpar, btnCancelar;
	Veiculo novoVeiculo;
	VeiculoDao veiculoDao;
	
	public CadastroVeiculo() {
		super("Dados cadastrais de veiculo");
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
	protected void novoRegistroVeiculo(){
		btnNovo.setEnabled(false);
		novoVeiculo = new Veiculo();
		habilitaCampos();
		limparCampos();
		btnCancelar.setEnabled(true);
	}//fim do método novoRegistroCliente
	
	//Método para salvar registro
	protected void salvarRegistroVeiculo(){
		
		if(cxPlaca.getText().equals("") || cxModelo.getText().equals("") || cxAno.getText().equals("")){
			JOptionPane.showMessageDialog(this, "Os campos do formulário são de preenchimento obrigatório");
		}else{
			novoVeiculo.setPlaca(cxPlaca.getText());
			novoVeiculo.setModelo(cxModelo.getText());
			novoVeiculo.setAno(Integer.parseInt(cxAno.getText()));
		
			veiculoDao = new VeiculoDao();
			veiculoDao.gravarVeiculo(novoVeiculo, this);
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
				salvarRegistroVeiculo();
				break;
			case "Novo cadastro":
				novoRegistroVeiculo();
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
		
	}//fim da inner class

}//fim da classe principal
