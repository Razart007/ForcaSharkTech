package controllers;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.AbstractMenuLateral;
import views.FrameCadastroCliente;
import views.FrameCadastroFornecedor;
import views.FrameCadastroProduto;
import views.FrameCadastroTransportadora;
import views.FrameListarCliente;
import views.FrameListarTransportadora;
import views.FramePrincipal;

public class MenuLateralController {
	
	private static final String CADASTRO_CLIENTE = "Cadastro de cliente";
	private static final String CADASTRO_TRANSPORTADORA = "Cadastro de transportadora";
	private static final String CADASTRO_FORNECEDOR = "Cadastro de fornecedor";
	private static final String CADASTRO_PRODUTO = "Cadastro de produto";
	private static final String LISTAR_CLIENTE = "Lista dos clientes cadastrados";
	private static final String LISTAR_TRANSPORTADORA = "Lista das transportadoras cadastradas";
	
	private JFrame frame;
	
	public MenuLateralController() { }
	
	public MenuLateralController(JFrame frame) {
		this.frame = frame;
	}
	
	public FocusListener getFocusListener(JDialog dialog){
		return new AddFocusListener(dialog);
	}
	
	public MouseListener getMouseListener(int menu, AbstractMenuLateral menuLateral){
		return new AddMouseListener(menu, menuLateral);
	}
	
	private void alterarIcone(JLabel label, String urlIcone){
		label.setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + urlIcone));
	}
	
	private void atualizarTela(JPanel panel, String titulo){
		
		if(panel != null && frame != null){
			FramePrincipal.setPanel(panel);
			frame.setTitle(titulo);
			frame.setMinimumSize(new Dimension(840, 510));
			frame.repaint();
		}
	}
	
	private void cliente(String titulo){
		JPanel panel = new FrameCadastroCliente(titulo).getPanel();
		atualizarTela(panel, titulo);
	}
	
	private void transportadora(String titulo){
		JPanel panel = new FrameCadastroTransportadora(titulo).getPanel();
		atualizarTela(panel, titulo);
	}
	
	private void fornecedor(String titulo){
		JPanel panel = new FrameCadastroFornecedor(titulo).getPanel();
		atualizarTela(panel, titulo);
	}
	
	private void produto(String titulo){
		JPanel panel = new FrameCadastroProduto(titulo).getPanel();
		atualizarTela(panel, titulo);
	}
	
	private void listarCliente(String titulo){
		JPanel panel = new FrameListarCliente(titulo).getPanel();
		atualizarTela(panel, titulo);
	}
	
	private void listarTransportadora(String titulo){
		JPanel panel = new FrameListarTransportadora(titulo).getPanel();
		atualizarTela(panel, titulo);
	}
	
	private void listarFornecedor(){
		atualizarTela(null, "Listar fornecedores");
	}
	
	private void listarProduto(){

		atualizarTela(null, "Listar produtos");
	}
	
	private void pagamento(){
		atualizarTela(null, "Realizar pagamento");
	}
	
	private void recebimento(){
		atualizarTela(null, "Debitar recebimento");
	}
	
	private void balanco(){
		atualizarTela(null, "Verificar balanço");
	}
	
	private void realizarVenda(){
		atualizarTela(null, "Realizar venda");
	}
	
	private void listarVendasAVista(){
		atualizarTela(null, "Listar vendas à vista");
	}
	
	private void listarVendasComDuplicata(){
		atualizarTela(null, "Listar vendas por duplicata");
	}
	
	private void listarTodasVendas(){
		atualizarTela(null, "Listar todas as vendas");
	}
	
	private class AddFocusListener implements FocusListener{

		private JDialog dialog;
		public AddFocusListener(JDialog dialog) {
			this.dialog = dialog;
		}
		
		@Override
		public void focusGained(FocusEvent arg0) { }

		@Override
		public void focusLost(FocusEvent arg0) {
			dialog.dispose();
		}
	}
	
	private class AddMouseListener implements MouseListener{
		
		private int menu;
		private AbstractMenuLateral menuLateral;
		
		public AddMouseListener(int menu, AbstractMenuLateral menuLateral) {
			this.menu = menu;
			this.menuLateral = menuLateral;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) { }

		@Override
		public void mouseEntered(MouseEvent e) {
			
			JLabel label = (JLabel) e.getSource();
			
			switch(menu){
				case FramePrincipal.CLIENTE : {
					
					alterarIcone(label, "/cliente_item.png");
					break;
					
				} case FramePrincipal.TRANSPORTADORA : {
					
					alterarIcone(label, "/transportadora_item.png");
					break;
					
				} case FramePrincipal.FORNECEDOR : {
					
					alterarIcone(label, "/fornecedor_item.png");
					break;
					
				} case FramePrincipal.PRODUTO : {
					
					alterarIcone(label, "/produto_item.png");
					break;
					
				}case FramePrincipal.LISTAR_CLIENTE : {
					
					alterarIcone(label, "/cliente_item.png");
					break;
					
				} case FramePrincipal.LISTAR_TRANSPORTADORA : {
					
					alterarIcone(label, "/transportadora_item.png");
					break;
					
				} case FramePrincipal.LISTAR_FORNECEDOR : {
					
					alterarIcone(label, "/fornecedor_item.png");
					break;
					
				} case FramePrincipal.LISTAR_PRODUTO : {
					
					alterarIcone(label, "/produto_item.png");
					break;
					
				} case FramePrincipal.PAGAMENTO : {
					
					alterarIcone(label, "/pagamento_item.png");
					break;
					
				}  case FramePrincipal.RECEBIMENTO : {
					
					alterarIcone(label, "/recebimento_item.png");
					break;
					
				} case FramePrincipal.BALANCO : {
					
					alterarIcone(label, "/balanco_item.png");
					break;
					
				} case FramePrincipal.REALIZAR_VENDA : {
					
					alterarIcone(label, "/realizar_venda_item.png");
					break;
					
				} case FramePrincipal.LISTAR_VENDAS_A_VISTA : {
					
					alterarIcone(label, "/listar_a_vista_item.png");
					break;
					
				} case FramePrincipal.LISTAR_VENDAS_DUPLICATA : {
					
					alterarIcone(label, "/listar_duplicata_item.png");
					break;
					
				} case FramePrincipal.LISTAR_VENDAS : {
					
					alterarIcone(label, "/listar_vendas_item.png");
					break;
					
				}
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
			JLabel label = (JLabel) e.getSource();
			
			switch(menu){
				case FramePrincipal.CLIENTE : {
					
					alterarIcone(label, "/cliente.png");
					break;
					
				} case FramePrincipal.TRANSPORTADORA : {
					
					alterarIcone(label, "/transportadora.png");
					break;
					
				} case FramePrincipal.FORNECEDOR : {
					
					alterarIcone(label, "/fornecedor.png");
					break;
					
				} case FramePrincipal.PRODUTO : {
					
					alterarIcone(label, "/produto.png");
					break;
					
				} case FramePrincipal.LISTAR_CLIENTE : {
					
					alterarIcone(label, "/cliente.png");
					break;
					
				} case FramePrincipal.LISTAR_TRANSPORTADORA : {
					
					alterarIcone(label, "/transportadora.png");
					break;
					
				} case FramePrincipal.LISTAR_FORNECEDOR : {
					
					alterarIcone(label, "/fornecedor.png");
					break;
					
				} case FramePrincipal.LISTAR_PRODUTO : {
					
					alterarIcone(label, "/produto.png");
					break;
					
				} case FramePrincipal.PAGAMENTO : {
					
					alterarIcone(label, "/pagamento.png");
					break;
					
				}  case FramePrincipal.RECEBIMENTO : {
					
					alterarIcone(label, "/recebimento.png");
					break;
					
				} case FramePrincipal.BALANCO : {
					
					alterarIcone(label, "/balanco.png");
					break;
					
				} case FramePrincipal.REALIZAR_VENDA : {
					
					alterarIcone(label, "/realizar_venda.png");
					break;
					
				} case FramePrincipal.LISTAR_VENDAS_A_VISTA : {
					
					alterarIcone(label, "/listar_a_vista.png");
					break;
					
				} case FramePrincipal.LISTAR_VENDAS_DUPLICATA : {
					
					alterarIcone(label, "/listar_duplicata.png");
					break;
					
				} case FramePrincipal.LISTAR_VENDAS : {
					
					alterarIcone(label, "/listar_vendas.png");
					break;
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) { 
			
			JLabel label = (JLabel) e.getSource();
			
			switch(menu){
				case FramePrincipal.CLIENTE : {
					
					alterarIcone(label, "/cliente_press.png");
					break;
					
				} case FramePrincipal.TRANSPORTADORA : {
					
					alterarIcone(label, "/transportadora_press.png");
					break;
					
				} case FramePrincipal.FORNECEDOR : {
					
					alterarIcone(label, "/fornecedor_press.png");
					break;
					
				} case FramePrincipal.PRODUTO : {
					
					alterarIcone(label, "/produto_press.png");
					break;
					
				}  case FramePrincipal.LISTAR_CLIENTE : {
					
					alterarIcone(label, "/cliente_press.png");
					break;
					
				} case FramePrincipal.LISTAR_TRANSPORTADORA : {
					
					alterarIcone(label, "/transportadora_press.png");
					break;
					
				} case FramePrincipal.LISTAR_FORNECEDOR : {
					
					alterarIcone(label, "/fornecedor_press.png");
					break;
					
				} case FramePrincipal.LISTAR_PRODUTO : {
					
					alterarIcone(label, "/produto_press.png");
					break;
					
				} case FramePrincipal.PAGAMENTO : {
					
					alterarIcone(label, "/pagamento_press.png");
					break;
					
				}  case FramePrincipal.RECEBIMENTO : {
					
					alterarIcone(label, "/recebimento_press.png");
					break;
					
				} case FramePrincipal.BALANCO : {
					
					alterarIcone(label, "/balanco_press.png");
					break;
					
				} case FramePrincipal.REALIZAR_VENDA : {
					
					alterarIcone(label, "/realizar_venda_press.png");
					break;
					
				} case FramePrincipal.LISTAR_VENDAS_A_VISTA : {
					
					alterarIcone(label, "/listar_a_vista_press.png");
					break;
					
				} case FramePrincipal.LISTAR_VENDAS_DUPLICATA : {
					
					alterarIcone(label, "/listar_duplicata_press.png");
					break;
					
				} case FramePrincipal.LISTAR_VENDAS : {
					
					alterarIcone(label, "/listar_vendas_press.png");
					break;
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			JLabel label = (JLabel) e.getSource();
			
			switch(menu){
				case FramePrincipal.CLIENTE : {
					
					alterarIcone(label, "/cliente_item.png");
					cliente(CADASTRO_CLIENTE);
					break;
					
				} case FramePrincipal.TRANSPORTADORA : {
					
					alterarIcone(label, "/transportadora_item.png");
					transportadora(CADASTRO_TRANSPORTADORA);
					break;
					
				} case FramePrincipal.FORNECEDOR : {
					
					alterarIcone(label, "/fornecedor_item.png");
					fornecedor(CADASTRO_FORNECEDOR);
					break;
					
				} case FramePrincipal.PRODUTO : {
					
					alterarIcone(label, "/produto_item.png");
					produto(CADASTRO_PRODUTO);
					break;
					
				} case FramePrincipal.LISTAR_CLIENTE : {
					
					alterarIcone(label, "/cliente_item.png");
					listarCliente(LISTAR_CLIENTE);
					break;
					
				} case FramePrincipal.LISTAR_TRANSPORTADORA : {
					
					alterarIcone(label, "/transportadora_item.png");
					listarTransportadora(LISTAR_TRANSPORTADORA);
					break;
					
				} case FramePrincipal.LISTAR_FORNECEDOR : {
					
					alterarIcone(label, "/fornecedor_item.png");
					listarFornecedor();
					break;
					
				} case FramePrincipal.LISTAR_PRODUTO : {
					
					alterarIcone(label, "/produto_item.png");
					listarProduto();
					break;
					
				}case FramePrincipal.PAGAMENTO : {
					
					alterarIcone(label, "/pagamento_item.png");
					pagamento();
					break;
					
				}  case FramePrincipal.RECEBIMENTO : {
					
					alterarIcone(label, "/recebimento_item.png");
					recebimento();
					break;
					
				} case FramePrincipal.BALANCO : {
					
					alterarIcone(label, "/balanco_item.png");
					balanco();
					break;
					
				} case FramePrincipal.REALIZAR_VENDA : {
					
					alterarIcone(label, "/realizar_venda_item.png");
					realizarVenda();
					break;
					
				} case FramePrincipal.LISTAR_VENDAS_A_VISTA : {
					
					alterarIcone(label, "/listar_a_vista_item.png");
					listarVendasAVista();
					break;
					
				} case FramePrincipal.LISTAR_VENDAS_DUPLICATA : {
					
					alterarIcone(label, "/listar_duplicata_item.png");
					listarVendasComDuplicata();
					break;
					
				} case FramePrincipal.LISTAR_VENDAS : {
					
					alterarIcone(label, "/listar_vendas_item.png");
					listarTodasVendas();
					break;
				}
			}
			menuLateral.dispose();
		}
	}
}
