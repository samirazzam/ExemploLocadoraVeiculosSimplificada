package br.senac.vista;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class JanelaPrincipal extends JFrame{

	private JMenuBar barraMenu;
	private JMenu menuCadastro, menuLocacao, menuMais;
	private JMenuItem subMenuCadastroCliente, subMenuCadastroVeiculo, subMenuLocacao, subMenuDevolucao, subMenuSair, subMenuSobre;
	private JDesktopPane painelDesktop;
	private Image imagemFundo;
	private CadastroCliente telaCadastroCliente;
	
	public JanelaPrincipal() {
		setTitle("Sistema de loca��o de ve�culos - LocaF�cil");
		setSize(1024,720);
		setLocale(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Configurando uma imagem de Fundo para a aplica��o
		try{
			imagemFundo = new ImageIcon(getClass().getResource("/img/backgroundcar.jpg")).getImage();
		}catch (Exception e){
			System.out.println("Imagem n�o carregada");
		}
		painelDesktop = new JDesktopPane(){
			@Override
			public void paintComponent(Graphics g){
				g.drawImage(imagemFundo, 0,0,getWidth(),getHeight(), this);
			}
		};
		add(painelDesktop);
		
		//Configurando o menu
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		menuCadastro = new JMenu("Cadastros");
		menuLocacao = new JMenu("Loca��o de ve�culos");
		menuMais = new JMenu("Mais...");
		barraMenu.add(menuCadastro);
		barraMenu.add(menuLocacao);
		barraMenu.add(menuMais);
		
		subMenuCadastroCliente = new JMenuItem("Cadastro de clientes");
		subMenuCadastroVeiculo = new JMenuItem("Cadastro de ve�culos");
		subMenuLocacao = new JMenuItem("Loca��o de ve�culo");
		subMenuDevolucao = new JMenuItem("Devolu��o de ve�culo");
		subMenuSair = new JMenuItem("Sair do programa");
		subMenuSobre = new JMenuItem("Sobre");
		
		menuCadastro.add(subMenuCadastroCliente);
		menuCadastro.addSeparator();
		menuCadastro.add(subMenuCadastroVeiculo);
		menuLocacao.add(subMenuLocacao);
		menuLocacao.addSeparator();
		menuLocacao.add(subMenuDevolucao);
		menuMais.add(subMenuSobre);
		menuMais.addSeparator();
		menuMais.add(subMenuSair);
		
		//Configurando os ouvintes
		CliqueListener ouvinte = new CliqueListener();
		
		subMenuCadastroCliente.addActionListener(ouvinte);
		subMenuCadastroVeiculo.addActionListener(ouvinte);
		subMenuLocacao.addActionListener(ouvinte);
		subMenuDevolucao.addActionListener(ouvinte);
		subMenuSobre.addActionListener(ouvinte);
		subMenuSair.addActionListener(ouvinte);
		
	}//fim do construtor da classe
	
	//M�todo para o menusair
	public void sairPrograma(){
		int resposta = JOptionPane.showConfirmDialog(painelDesktop, "Deseja sair do programa?");
		if (resposta == JOptionPane.YES_OPTION){
			this.dispose();
		}	
	}//fim do m�todo sairPrograma
	
	private class CliqueListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evento) {
			//Fazendo os comandos if simplificados, mas n�o � a forma indicada!
			//1� if
			if(evento.getSource() == subMenuCadastroCliente){
				if(telaCadastroCliente == null){
					telaCadastroCliente = new CadastroCliente();
					painelDesktop.add(telaCadastroCliente);
					telaCadastroCliente.setVisible(true);
				}else{
					telaCadastroCliente.setVisible(true);
					painelDesktop.moveToFront(telaCadastroCliente);
				}
			}
			//2� if
			if(evento.getSource() == subMenuSobre){
					JOptionPane.showMessageDialog(painelDesktop, "Sistema Biblioteca \n" +"Vers�o 1.00");
			}

			//3� if
			if(evento.getSource() == subMenuSair){
				sairPrograma();
			}
		}//fim do actioPerformed
	}//fim da inner class
}//fim da classe
