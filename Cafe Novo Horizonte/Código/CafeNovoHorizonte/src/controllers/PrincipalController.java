package controllers;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import views.FrameCadastroCliente;
import views.FrameCadastroProduto;
import views.FrameHome;
import views.FrameMenuLateral;
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
	private FrameMenuLateral menuLateral;
	
	public PrincipalController(JFrame frame) {
		this.frame = frame;
	}
	
	public WindowListener getWindowListener(){
		return new AddWindowListener();
	}
	
	public WindowStateListener getWindowStateListener(){
		return new AddWindowStateListener();
	}
	
	public ActionListener getAcitonListener(String id){
		return new AddActionListner(id);
	}
	
	public MouseListener getMouseListener(String menu){
		return new AddMouseListener(menu);
	}
		
	private void exibirMenuLateral(Point posicao, int menu){
		
		if(menuLateral == null){
			
			switch (menu){
				case CADASTRAR:{

					menuLateral = new FrameMenuLateralCadastrar(posicao);
					break;
					
				} case LISTAR:{
					
					menuLateral = new FrameMenuLateralListar(posicao);
					break;
					
				} case RELATORIOS:{
					menuLateral = new FrameMenuLateralRelatorios(posicao);
					break;
					
				} case VENDAS: {
					menuLateral = new FrameMenuLateralVendas(posicao);
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
	
	private void atualizarTela(String titulo){
		frame.setTitle(titulo);
	}
	
	private void atualizarTela(JPanel panel){
		
		FramePrincipal.setPanel(panel);
		frame.setMinimumSize(new Dimension(840, 510));
		frame.repaint();
	}
	
	private void atualizarTela(String titulo, JPanel panel){

		atualizarTela(titulo);
		atualizarTela(panel);		
	}
	
	private void salvar() {
		atualizarTela("Salvar documento");
	}
	
	private void abrir() {
		atualizarTela("Abrir novo documento");
	}
	
	private void home(){
		JPanel panel = new FrameHome().getPanel();
		atualizarTela("home", panel);
	}
	
	private void cliente(){

		JPanel panel = new FrameCadastroCliente().getPanel();
		atualizarTela("Cliente", panel);
	}
	
	private void fornecedor(){
		atualizarTela("Fornecedor");
	}
	
	private void transportadora(){
		atualizarTela("Transportadora");
	}
	
	private void produto(){
		JPanel panel = new FrameCadastroProduto().getPanel();
		atualizarTela("Produto", panel);
	}
	
	private void cadastrar(Point p) {
		
		atualizarTela("cadastrar" );
		exibirMenuLateral(p, CADASTRAR);
	}

	private void listar(Point p) {
		atualizarTela("listar");
		exibirMenuLateral(p, LISTAR);

	}

	private void relatorios(Point p) {
		atualizarTela("relatorios");
		exibirMenuLateral(p, RELATORIOS);
	}

	private void estoque() {
		atualizarTela("estoque");
	}
	
	private void vendas(Point p) {
		atualizarTela("vendas");
		exibirMenuLateral(p, VENDAS);
	}
	
	private void sair() {
		
		JPanel panel = new FrameHome().getPanel();
		atualizarTela(panel);
		
		int result = JOptionPane.showConfirmDialog(frame, "Você realmente deseja sair do aplicativo?", 
				"Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (result == JOptionPane.YES_OPTION){
			System.exit(0);
		} else {
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
			sair();
		}
	}
	
	private class AddActionListner implements ActionListener{

		private String menu;
		
		public AddActionListner(String menu) {
			this.menu = menu;
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			if (menu.equals(FramePrincipal.ABRIR)){
				
				abrir();
				
			} else if (menu.equals(FramePrincipal.SALVAR)){
				
				salvar();
				
			} else if (event.getActionCommand().equals("Cliente")){

				cliente();
				
			} else if (event.getActionCommand().equals("Fornecedor")){
				
				fornecedor();
				
			} else if (event.getActionCommand().equals("Transportadora")){

				transportadora();
				
			} else if (event.getActionCommand().equals("Produto")){

				produto();
			} 
		}
	}

	private class AddMouseListener implements MouseListener{

		private String menu;

		public AddMouseListener(String menu) {
			this.menu = menu;
		}
		
		@Override
		public void mouseClicked(MouseEvent event) {}

		@Override
		public void mousePressed(MouseEvent event) {
			
			removerMenuLateral();
			JLabel label = (JLabel) event.getSource();
			
			if (menu.equals(FramePrincipal.HOME)){
				
				label.setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/home_press.png"));
				home();

			} else if (menu.equals(FramePrincipal.ESTOQUE)){
				
				label.setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/estoque_press.png"));
				estoque();

			} else if (menu.equals(FramePrincipal.SAIR)){
				
				label.setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/sair_press.png"));
				sair();
			}
		}

		@Override
		public void mouseReleased(MouseEvent event) {
			
			removerMenuLateral();
			JLabel label = (JLabel) event.getSource();
			
			if (menu.equals(FramePrincipal.HOME)){

				label.setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/home.png"));

			} else if (menu.equals(FramePrincipal.ESTOQUE)){

				label.setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/estoque.png"));

			} else if (menu.equals(FramePrincipal.SAIR)){

				label.setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/sair.png"));
			}
		}

		@Override
		public void mouseEntered(MouseEvent event) {

			JLabel label = (JLabel) event.getSource();
			Point p = label.getLocationOnScreen();
			
			 if (menu.equals(FramePrincipal.CADASTRAR)){
				
				label.setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/cadastrar_press.png"));
				cadastrar(p);
				
			}  else if (menu.equals(FramePrincipal.LISTAR)){
				
				label.setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/listar_press.png"));
				listar(p);

			} else if (menu.equals(FramePrincipal.RELATORIOS)){
				
				label.setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/relatorios_press.png"));
				relatorios(p);
								
			} else if (menu.equals(FramePrincipal.VENDAS)){
				
				label.setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/vendas_press.png"));
				vendas(p);
			}
		}

		@Override
		public void mouseExited(MouseEvent event) {
			
			removerMenuLateral();
			JLabel label = (JLabel) event.getSource();
			
			if (menu.equals(FramePrincipal.CADASTRAR)){
				
				label.setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/cadastrar.png"));
				
			}  else if (menu.equals(FramePrincipal.LISTAR)){

				label.setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/listar.png"));	
				
			} else if (menu.equals(FramePrincipal.RELATORIOS)){
				
				label.setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/relatorios.png"));
				
			} else if (menu.equals(FramePrincipal.VENDAS)){
				
				label.setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/vendas.png"));				
			}
		}
	}
}
