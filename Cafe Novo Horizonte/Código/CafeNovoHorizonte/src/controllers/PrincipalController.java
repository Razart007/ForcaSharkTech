package controllers;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interfaces.AbstractMenuLateral;
import views.FrameHome;
import views.FrameLogin;
import views.FrameMenuLateralCadastrar;
import views.FrameMenuLateralListar;
import views.FrameMenuLateralRelatorios;
import views.FrameMenuLateralVendas;
import views.FramePrincipal;

public class PrincipalController {
	
	private static final int CADASTRAR = 0;
	private static final int LISTAR = 1;
	private static final int RELATORIOS = 2;
	private static final int VENDAS = 3;
	
	private JFrame frame;
	private AbstractMenuLateral menuLateral;
	
	public PrincipalController(JFrame frame) {
		this.frame = frame;
	}
	
	public FocusListener getFocusListener(){
		return new AddFocusListener();
	}
	
	public WindowListener getWindowListener(){
		return new AddWindowListener();
	}
	
	public WindowStateListener getWindowStateListener(){
		return new AddWindowStateListener();
	}
	
	public ActionListener getAcitonListener(int id){
		return new AddActionListner(id);
	}
	
	public MouseListener getMouseListener(int menu){
		return new AddMouseListener(menu);
	}
		
	private void exibirMenuLateral(Point posicao, int menu){
		
		if(menuLateral == null){
			
			switch (menu){
				case CADASTRAR:{

					menuLateral = new FrameMenuLateralCadastrar(frame, posicao);
					break;
					
				} case LISTAR:{

					menuLateral = new FrameMenuLateralListar(frame, posicao);
					break;
					
				} case RELATORIOS:{
					menuLateral = new FrameMenuLateralRelatorios(frame, posicao);
					break;
					
				} case VENDAS: {
					menuLateral = new FrameMenuLateralVendas(frame, posicao);
					break;
				}
			}
			menuLateral.setVisible(true);
		}
	}
	
	private void removerMenuLateral(){
		if (menuLateral != null){
			menuLateral.dispose();
			menuLateral = null;
		}
	}
	
	private void atualizarTela(JPanel panel, String titulo) {
		
		if(panel != null){
			FramePrincipal.setPanel(panel);	
		}
		frame.setTitle(titulo);
		frame.setMinimumSize(new Dimension(840, 510));
		frame.repaint();
	}
	
	private void alterarIcone(JLabel label, String urlIcone){
		label.setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + urlIcone));
	}
	
	private void salvar() {
		atualizarTela(null, "Salvar documento");
	}
	
	private void abrir() {
		atualizarTela(null, "Abrir novo documento");
	}
	
	private void imprimir(){
		atualizarTela(null, "Imprimir documento");
	}
	
	private void sobre(){

		atualizarTela(null, "Sobre o aplicativo");
	}
	
	private void home(){
		JPanel panel = new FrameHome().getPanel();
		atualizarTela(panel, "Café Novo Horizonte");
	}

	private void estoque() {
		atualizarTela(null, "Verificar estoque");
	}	
	
	private void sair() {
		
		int result = JOptionPane.showConfirmDialog(frame, "Você realmente deseja sair do aplicativo?", 
				"Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (result == JOptionPane.YES_OPTION){
			frame.dispose();
			new FrameLogin();
		} else {
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
	}
	
	private class AddFocusListener implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {	}

		@Override
		public void focusLost(FocusEvent e) {
			removerMenuLateral();			
		}		
	}
	
	private class AddWindowStateListener implements WindowStateListener{

		@Override
		public void windowStateChanged(WindowEvent arg0) {
			removerMenuLateral();
		}
	}
	
	private class AddWindowListener extends WindowAdapter{

		public void windowClosing(WindowEvent e){
			removerMenuLateral();
			sair();
		}	
	}
	
	private class AddActionListner implements ActionListener{

		private int menu;
		
		public AddActionListner(int menu) {
			this.menu = menu;
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			switch(menu){
				case FramePrincipal.ABRIR: {
					
					abrir();
					break;
					
				} case FramePrincipal.SALVAR: {
					
					salvar();
					break;
					
				} case FramePrincipal.IMPRIMIR: {
					
					imprimir();
					break;
					
				} case FramePrincipal.SAIR: {

					sair();
					break;
					
				} case FramePrincipal.SOBRE: {
					
					sobre();
					break;					
				}
			}
		}
	}

	private class AddMouseListener implements MouseListener{

		private int menu;

		public AddMouseListener(int menu) {
			this.menu = menu;
		}
		
		@Override
		public void mouseClicked(MouseEvent event) { }

		@Override
		public void mousePressed(MouseEvent event) {
			
			removerMenuLateral();
			JLabel label = (JLabel) event.getSource();
			
			switch(menu){
				case FramePrincipal.HOME: {
					
					alterarIcone(label, "/home_press.png");
					break;
					
				} case FramePrincipal.ESTOQUE: {
	
					alterarIcone(label, "/estoque_press.png");
					break;
					
				} case FramePrincipal.SAIR: {
	
					alterarIcone(label, "/sair_press.png");
					break;					
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent event) {
			
			JLabel label = (JLabel) event.getSource();
			
			switch(menu){
				case FramePrincipal.HOME: {
					
					alterarIcone(label, "/home_item.png");
					home();
					break;
					
				} case FramePrincipal.ESTOQUE: {

					alterarIcone(label, "/estoque_item.png");
					estoque();
					break;
					
				} case FramePrincipal.SAIR: {

					alterarIcone(label, "/sair_item.png");
					sair();					
					break;
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent event) {

			JLabel label = (JLabel) event.getSource();
			Point p = label.getLocationOnScreen();
			removerMenuLateral();
			
			switch(menu){
				case FramePrincipal.HOME: {
					
					alterarIcone(label, "/home_item.png");
					break;
					
				} case FramePrincipal.ESTOQUE: {
					
					alterarIcone(label, "/estoque_item.png");
					break;
					
				} case FramePrincipal.CADASTRAR: {
					
					alterarIcone(label, "/cadastrar_item.png");
					exibirMenuLateral(p, CADASTRAR);
					break;
					
				} case FramePrincipal.LISTAR: {
					
					alterarIcone(label, "/listar_item.png");
					exibirMenuLateral(p, LISTAR);
					break;
					
				} case FramePrincipal.RELATORIOS: {
					
					alterarIcone(label, "/relatorios_item.png");
					exibirMenuLateral(p, RELATORIOS);
					break;
									
				} case FramePrincipal.VENDAS: {
					
					alterarIcone(label, "/vendas_item.png");
					exibirMenuLateral(p, VENDAS);
					break;
					
				} case FramePrincipal.SAIR: {
					
					alterarIcone(label, "/sair_item.png");	
					break;
				}
			}
		}

		@Override
		public void mouseExited(MouseEvent event) {
			
			JLabel label = (JLabel) event.getSource();
			switch(menu){
				case FramePrincipal.HOME: {
					
					alterarIcone(label, "/home.png");	
					break;
					
				} case FramePrincipal.CADASTRAR: {
					
					alterarIcone(label, "/cadastrar.png");	
					break;
					
				} case FramePrincipal.LISTAR: {

					alterarIcone(label, "/listar.png");
					break;
					
				} case FramePrincipal.RELATORIOS: {

					alterarIcone(label, "/relatorios.png");	
					break;
					
				} case FramePrincipal.ESTOQUE: {

					alterarIcone(label, "/estoque.png");
					break;	
					
				} case FramePrincipal.VENDAS: {

					alterarIcone(label, "/vendas.png");
					break;
					
				} case FramePrincipal.SAIR: {

					alterarIcone(label, "/sair.png");	
					break;
				}
			}
		}
	}
}
