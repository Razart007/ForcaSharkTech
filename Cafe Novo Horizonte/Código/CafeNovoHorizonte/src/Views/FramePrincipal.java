package Views;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Controllers.PrincipalController;

public class FramePrincipal {
	
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenuItem itemCliente, itemFornecedor, itemTransportadora, itemProdutos, itemPagamento, itemRecebimento, 
		itemBalanco, itemRealizarVendas, itemVendasAVista, itemVendasDuplicatas, itemTodasVendas;
	
	public FramePrincipal(){

		iniciarComponentes();
		instanciarEventos();
		instanciarFrame();
		
	}

	private void iniciarComponentes() {
		
		frame = new JFrame();
		menuBar = new JMenuBar();
		
		JMenu menuCadastrar = new JMenu("Cadastrar");
		JMenu menuRelatorios = new JMenu("Relatórios");
		JMenu menuEstoque = new JMenu("Estoque");
		JMenu menuVendas = new JMenu("Vendas");
		
		menuCadastrar.add(itemCliente = new JMenuItem("Cliente"));
		menuCadastrar.add(itemFornecedor = new JMenuItem("Fornecedor"));
		menuCadastrar.add(itemTransportadora = new JMenuItem("Transportadora"));
		menuCadastrar.add(itemProdutos = new JMenuItem("Produtos"));
		
		menuRelatorios.add(itemPagamento = new JMenuItem("Pagamento"));
		menuRelatorios.add(itemRecebimento = new JMenuItem("Recebimento"));
		menuRelatorios.add(itemBalanco = new JMenuItem("Balanço"));
		
		menuVendas.add(itemRealizarVendas = new JMenuItem("Realizaar venda"));
		menuVendas.add(itemVendasAVista = new JMenuItem("Listar vendas à vista"));
		menuVendas.add(itemVendasDuplicatas = new JMenuItem("Listar vendas de duplicata"));
		menuVendas.add(itemTodasVendas = new JMenuItem("Listar todas as vendas"));
		
		menuBar.add(menuCadastrar);
		menuBar.add(menuRelatorios);
		menuBar.add(menuEstoque);
		menuBar.add(menuVendas);
		
		frame.setJMenuBar(menuBar);
	}	
	


	private void instanciarEventos(){
		
//		itemCliente.addActionListener(new PrincipalController.Cliente());
//		itemFornecedor.addActionListener(l);
//		itemTransportadora.addActionListener(l);
//		itemProdutos.addActionListener(l);
//		itemPagamento.addActionListener(l);
//		itemRecebimento.addActionListener(l);
//		itemBalanco.addActionListener(l);
//		itemRealizarVendas.addActionListener(l);
//		itemVendasAVista.addActionListener(l);
//		itemVendasDuplicatas.addActionListener(l);
//		itemTodasVendas.addActionListener(l);
		
	}
	
	private void instanciarFrame(){
		try { //Exceção para utilizar ou não o tema Ninbus do java  
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  
		} catch (Exception e) {  
			e.printStackTrace();  
		}
		
		
		frame.setTitle("Café Novo Horizonete");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens/CafeIcone.png")); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setLayout(null); 
		frame.setSize(1000, 700); 
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter() {  
			public void windowClosing(WindowEvent e){
				int i = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema?");
				if (i == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		} );
	}
}

