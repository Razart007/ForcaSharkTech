package controllers;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
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
	
	public MouseListener getMouseListener(String menu){
		return new AddMouseListener(menu);
	}
		
	private void exibirMenuLateral(Point posicao, String menus[]){
		
		if (menuLateral == null){
			menuLateral = new FrameMenuLateral(posicao, menus);
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
		String menuCadastrar[] = {CLIENTE, FORNECEDOR, TRANSPORTADORA, PRODUTO};
		exibirMenuLateral(p, menuCadastrar);
	}

	private void listar(Point p) {
		atualizarTela("listar");
		String menuListar[] = {CLIENTE, FORNECEDOR, TRANSPORTADORA, PRODUTO};
		exibirMenuLateral(p, menuListar);
	}

	private void relatorios(Point p) {
		atualizarTela("relatorios");
		String menuRelatorios[] = {PAGAMENTO, RECEBIMENTO, BALANCO};
		exibirMenuLateral(p, menuRelatorios);
	}

	private void estoque() {
		atualizarTela("estoque");
	}
	
	private void vendas(Point p) {
		atualizarTela("vendas");
		String menuVendas[] = {REALIZAR_VENDA, LISTAR_VENDAS_A_VISTA, LISTAR_VENDAS_DUPLICATA, LISTAR_VENDAS};
		exibirMenuLateral(p, menuVendas);
	}
	
	private void sair() {
		
		JPanel panel = new FrameHome().getPanel();
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

	public class AddMouseListener implements MouseListener{

		private String menu;
		
		public AddMouseListener(String menu) {
			this.menu = menu;
		}
				
		@Override
		public void mouseClicked(MouseEvent event) {}

		@Override
		public void mouseEntered(MouseEvent event) {}

		@Override
		public void mouseExited(MouseEvent event) {}

		@Override
		public void mousePressed(MouseEvent event) { }

		@Override
		public void mouseReleased(MouseEvent event) {
		
			Point p = ((Container) event.getSource()).getLocationOnScreen();
			
			if (menu.equals(FramePrincipal.HOME)){
			
				home();

			}  else if (menu.equals(FramePrincipal.ESTOQUE)){

				estoque();
				
			} else if (menu.equals(FramePrincipal.SAIR)){

				sair();
				
			} else if (menu.equals(FramePrincipal.CADASTRAR)){
				
				cadastrar(p);

			} else if (menu.equals(FramePrincipal.LISTAR)){
				
				listar(p);

			} else if (menu.equals(FramePrincipal.RELATORIOS)){

				relatorios(p);
				
			}  else if (menu.equals(FramePrincipal.VENDAS)){

				vendas(p);
				
			} else {
				
				if (menuLateral != null && menuLateral.isVisible()){
	
					menuLateral.dispose();
					menuLateral = null;
				}
			}
		}
	}
}
