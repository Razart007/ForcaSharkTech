package controllers;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import views.FrameCadastroCliente;
import views.FrameCadastroProduto;
import views.FrameCadastroTransportadora;
import views.FrameListarCliente;
import views.FrameMenuLateral;
import views.FramePrincipal;

public class MenuLateralController {
	
	private JFrame frame;
	
	public MenuLateralController(JFrame frame) {
		this.frame = frame;
	}
	
	public MouseListener getMouseListener(int menu, FrameMenuLateral menuLateral){
		return new AddMouseListener(menu, menuLateral);
	}
	
	private void alterarIcone(JLabel label, String urlIcone){
		label.setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + urlIcone));
	}
	
	private void atualizarTela(JPanel panel, String titulo){
		
		if(panel != null){
			FramePrincipal.setPanel(panel);
		}
		frame.setTitle(titulo);
		frame.setMinimumSize(new Dimension(840, 510));
		frame.repaint();
	}
	
	private void cliente(){
		JPanel panel = new FrameCadastroCliente().getPanel();
		atualizarTela(panel, "Castrar cliente");
	}
	
	private void transportadora(){
		JPanel panel = new FrameCadastroTransportadora().getPanel();
		atualizarTela(panel, "Castrar transportadora");
	}
	
	private void fornecedor(){
		atualizarTela(null, "Castrar fornecedor");
	}
	
	private void produto(){
		JPanel panel = new FrameCadastroProduto().getPanel();
		atualizarTela(panel, "Castrar produto");
	}
	
	private void listarCliente(){
		JPanel panel = new FrameListarCliente().getPanel();
		atualizarTela(panel, "Listar clientes");
	}
	
	private void listarTransportadora(){
		JPanel panel = new FrameCadastroTransportadora().getPanel();
		atualizarTela(panel, "Listar transportadoras");
	}
	
	private void listarFornecedor(){
		atualizarTela(null, "Listar fornecedores");
	}
	
	private void listarProduto(){
		JPanel panel = new FrameCadastroProduto().getPanel();
		atualizarTela(panel, "Listar produtos");
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
	
	private class AddMouseListener implements MouseListener{
		
		private int menu;
		private FrameMenuLateral menuLateral;
		
		public AddMouseListener(int menu, FrameMenuLateral menuLateral) {
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
					cliente();
					break;
					
				} case FramePrincipal.TRANSPORTADORA : {
					
					alterarIcone(label, "/transportadora_item.png");
					transportadora();
					break;
					
				} case FramePrincipal.FORNECEDOR : {
					
					alterarIcone(label, "/fornecedor_item.png");
					fornecedor();
					break;
					
				} case FramePrincipal.PRODUTO : {
					
					alterarIcone(label, "/produto_item.png");
					produto();
					break;
					
				} case FramePrincipal.LISTAR_CLIENTE : {
					
					alterarIcone(label, "/cliente_item.png");
					listarCliente();
					break;
					
				} case FramePrincipal.LISTAR_TRANSPORTADORA : {
					
					alterarIcone(label, "/transportadora_item.png");
					listarTransportadora();
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
