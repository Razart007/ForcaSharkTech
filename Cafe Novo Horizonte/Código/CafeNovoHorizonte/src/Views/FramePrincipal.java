package Views;

import java.awt.Color;
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
	
	public static final String CLIENTE = "Cliente";
	public static final String FORNECEDOR = "Fornecedor";
	public static final String TRANSPORTADORA = "Transportadora";
	public static final String PRODUTOS = "Produtos";
	public static final String PAGAMENTO = "Pagamento";
	public static final String RECEBIMENTO = "Recebimento";
	public static final String BALANCO = "Balanço";
	public static final String REALIZAR_VENDA = "Realizar venda";
	public static final String VENDAS_A_VISTA = "Listar vendas à vista";
	public static final String VENDAS_DUPLICATAS = "Listar vendas duplicatas";
	public static final String TODAS_AS_VENDAS = "Listar todas as vendas";
	
						
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenuItem itemCliente, itemFornecedor, itemTransportadora, itemProdutos, itemPagamento, itemRecebimento, 
		itemBalanco, itemRealizarVendas, itemVendasAVista, itemVendasDuplicatas, itemTodasVendas;
	
	public FramePrincipal(){
		instanciarFrame();
		iniciarComponentes();
		instanciarEventos();
	}

	private void iniciarComponentes() {
		menuBar = new JMenuBar();
		
		JMenu menuCadastrar = new JMenu("Cadastrar");
		JMenu menuRelatorios = new JMenu("Relatórios");
		JMenu menuEstoque = new JMenu("Estoque");
		JMenu menuVendas = new JMenu("Vendas");
		
		menuCadastrar.add(itemCliente = new JMenuItem(CLIENTE));
		menuCadastrar.add(itemFornecedor = new JMenuItem(FORNECEDOR));
		menuCadastrar.add(itemTransportadora = new JMenuItem(TRANSPORTADORA));
		menuCadastrar.add(itemProdutos = new JMenuItem(PRODUTOS));
		
		menuRelatorios.add(itemPagamento = new JMenuItem(PAGAMENTO));
		menuRelatorios.add(itemRecebimento = new JMenuItem(RECEBIMENTO));
		menuRelatorios.add(itemBalanco = new JMenuItem(BALANCO));
		
		menuVendas.add(itemRealizarVendas = new JMenuItem(REALIZAR_VENDA));
		menuVendas.add(itemVendasAVista = new JMenuItem(VENDAS_A_VISTA));
		menuVendas.add(itemVendasDuplicatas = new JMenuItem(VENDAS_DUPLICATAS));
		menuVendas.add(itemTodasVendas = new JMenuItem(TODAS_AS_VENDAS));
		
		menuBar.add(menuCadastrar);
		menuBar.add(menuRelatorios);
		menuBar.add(menuEstoque);
		menuBar.add(menuVendas);
		
		frame.setJMenuBar(menuBar);
	}	
	


	private void instanciarEventos(){
		
		PrincipalController principalCont = new PrincipalController();
		
		itemCliente.addActionListener(principalCont);
		itemFornecedor.addActionListener(principalCont);
		itemTransportadora.addActionListener(principalCont);
		itemProdutos.addActionListener(principalCont);
		itemPagamento.addActionListener(principalCont);
		itemRecebimento.addActionListener(principalCont);
		itemBalanco.addActionListener(principalCont);
		itemRealizarVendas.addActionListener(principalCont);
		itemVendasAVista.addActionListener(principalCont);
		itemVendasDuplicatas.addActionListener(principalCont);
		itemTodasVendas.addActionListener(principalCont);
		
	}
	
	private void instanciarFrame(){
		try { //Exceção para utilizar ou não o tema Ninbus do java  
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  
		} catch (Exception e) {  
			e.printStackTrace();  
		}
		
		frame = new JFrame();
		frame.setTitle("Café Novo Horizonte");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens/CafeIcone.png")); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setLayout(null); 
		frame.setSize(1000, 700); 
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
		
		
		frame.addWindowListener(new WindowAdapter() {  
			public void windowClosing(WindowEvent e){
				int i = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema?");
				if (i == JOptionPane.OK_OPTION){
					System.exit(0);
				}
				else{
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
				}
			}
		} );
	}
}

