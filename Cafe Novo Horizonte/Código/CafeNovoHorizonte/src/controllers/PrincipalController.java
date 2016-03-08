package controllers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import views.FrameCadastroCliente;
import views.FrameCadastroProduto;
import views.FrameHome;
import views.FrameMenuLateral;
import views.FramePrincipal;

public class PrincipalController {
	
	public static final String CLIENTE = "Cliente";
	public static final String TRANSPORTADORA = "Transportadora";
	public static final String FORNECEDOR = "Fornecedor";
	public static final String PRODUTO = "Produto";
	
	public static final String PAGAMENTO = "Pagamento";
	public static final String RECEBIMENTO = "Recebimento";
	public static final String BALANCO = "Balanco";
	
	public static final String REALIZAR_VENDA = "Realizar venda";
	public static final String LISTAR_VENDAS_A_VISTA = "Listar vendas à vista";
	public static final String LISTAR_VENDAS_DUPLICATA = "Listar vendas por duplicata";
	public static final String LISTAR_VENDAS = "Listar todas as vendas";
	
	private JFrame frame;
	private FrameMenuLateral menuLateral;
	
	public PrincipalController(JFrame frame) {
		this.frame = frame;
	}
	
	public WindowListener getWindowListener(){
		return new AddWindowListener();
	}
	
	public ActionListener getAcitonListener(String id){
		return new AddActionListner(id);
	}
	
	public MouseListener getMouseListener(String id){
		return new AddMouseListener(id);
	}
		
	private void exibirMenuLateral(String menu[]){
		
		if (menuLateral == null){
			menuLateral = new FrameMenuLateral(new Dimension(20,20), menu);
			menuLateral.setVisible(true);
		}
	}
	
	private void atualizarTela(String titulo){
		frame.setTitle(titulo);
	}
	
	private void atualizarTela(String titulo, JPanel panel){

		atualizarTela(titulo);
		
		FramePrincipal.setPanel(panel);
		frame.setMinimumSize(new Dimension(840, 510));
		frame.repaint();
	}
	
	private void salvar(String titulo) {
		atualizarTela(titulo);
	}
	
	private void abrir() {
		atualizarTela("Abrir novo documento");
	}
	
	private void home(){
		JPanel panel = new FrameHome(Color.WHITE).getPanel();
		atualizarTela("home", panel);
	}
	
	private void cliente(){

		JPanel panel = new FrameCadastroCliente(Color.WHITE).getPanel();
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
	
	private void cadastrar() {
		atualizarTela("cadastrar" );
		String menuCadastrar[] = {CLIENTE, FORNECEDOR, TRANSPORTADORA, PRODUTO};
		exibirMenuLateral(menuCadastrar);
	}

	private void listar() {
		atualizarTela("listar");
		String menuListar[] = {CLIENTE, FORNECEDOR, TRANSPORTADORA, PRODUTO};
		exibirMenuLateral(menuListar);
	}

	private void relatorios() {
		atualizarTela("relatorios");
		String menuRelatorios[] = {PAGAMENTO, RECEBIMENTO, BALANCO};
		exibirMenuLateral(menuRelatorios);
	}

	private void estoque() {
		atualizarTela("estoque");
	}
	
	private void vendas() {
		atualizarTela("vendas");
		String menuVendas[] = {REALIZAR_VENDA, LISTAR_VENDAS_A_VISTA, LISTAR_VENDAS_DUPLICATA, LISTAR_VENDAS};
		exibirMenuLateral(menuVendas);
	}
	
	private void sair() {
		
		JPanel panel = new FrameHome(Color.CYAN).getPanel();
		atualizarTela("Café Novo Horizonte", panel);
		
		int result = JOptionPane.showConfirmDialog(frame, "Você realmente deseja sair do aplicativo?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (result == JOptionPane.YES_OPTION){
			System.exit(0);
		} else {
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
		}
	}
	
	public class AddWindowListener extends WindowAdapter{

		public void windowClosing(WindowEvent e){
			sair();
		}
	}
	
	public class AddActionListner implements ActionListener{

		private String id;
		
		public AddActionListner(String id) {
			this.id = id;
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			if (id.equals(FramePrincipal.ABRIR)){
				
				abrir();
				
			} else if (id.equals(FramePrincipal.SALVAR)){
				
				salvar("Salvando documento");
				
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

	public class AddMouseListener implements MouseListener{

		private String id;
		
		public AddMouseListener(String id) {
			this.id = id;
		}
				
		@Override
		public void mouseClicked(MouseEvent event) {
			
			if (id.equals(FramePrincipal.HOME)){
			
				home();

			}  else if (id.equals(FramePrincipal.ESTOQUE)){

				estoque();
				
			} else if (id.equals(FramePrincipal.SAIR)){

				sair();
			} else if (FramePrincipal.CADASTRAR.equals(id)){
				 
				cadastrar();

			} else if (id.equals(FramePrincipal.LISTAR)){
				
				listar();

			} else if (id.equals(FramePrincipal.RELATORIOS)){

				relatorios();
				
			}  else if (id.equals(FramePrincipal.VENDAS)){

				vendas();
			} else {
				
				if (menuLateral != null && menuLateral.isVisible()){
	
					menuLateral.dispose();
					menuLateral = null;
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent event) { }

		@Override
		public void mouseExited(MouseEvent event) {
			
			
		}

		@Override
		public void mousePressed(MouseEvent event) { }

		@Override
		public void mouseReleased(MouseEvent event) { }
	}
}
