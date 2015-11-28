package views;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import controllers.PrincipalController;

public class FramePrincipal {

	private static int count = 0;
	
	public static final String CLIENTE = "Cliente";
	public static final String FORNECEDOR = "Fornecedor";
	public static final String TRANSPORTADORA = "Transportadora";
	public static final String PRODUTOS = "Produto";
	public static final String LISTAR_CLIENTE = "Clientes";
	public static final String LISTAR_FORNECEDOR = "Fornecedores";
	public static final String LISTAR_TRANSPORTADORA = "Transportadoras";
	public static final String LISTAR_PRODUTOS = "Produtos";
	public static final String PAGAMENTO = "Pagamento";
	public static final String RECEBIMENTO = "Recebimento";
	public static final String BALANCO = "Balanço";
	public static final String REALIZAR_VENDA = "Realizar venda";
	public static final String VENDAS_A_VISTA = "Listar vendas à vista";
	public static final String VENDAS_DUPLICATAS = "Listar vendas duplicatas";
	public static final String TODAS_AS_VENDAS = "Listar todas as vendas";
	public static final String SAIR = "Sair";
	
						
	private JFrame frame;
	private JPanel painel;
	private JMenuBar menuBar;
	private JMenuItem itemCliente, itemFornecedor, itemTransportadora, itemListarCliente, itemListarFornecedor, 
			itemListarTransportadora, itemListarProdutos, itemProdutos, itemPagamento, itemRecebimento, itemBalanco, 
			itemRealizarVendas, itemVendasAVista, itemVendasDuplicatas, itemTodasVendas, itemSair;
	private JLabel label;
	
	public FramePrincipal(){
		instanciarFrame();
		iniciarComponentes();
		instanciarEventos();
	}

	private void iniciarComponentes() {
		
		menuBar = new JMenuBar();
		
		JMenu menuCadastrar = new JMenu("Cadastrar");
		JMenu menuListar = new JMenu("Listar");
		JMenu menuRelatorios = new JMenu("Relatórios");
		JMenu menuEstoque = new JMenu("Estoque");
		JMenu menuVendas = new JMenu("Vendas");
		JMenu menuSair = new JMenu("Usuario");
		
		menuCadastrar.add(itemCliente = new JMenuItem(CLIENTE));
		menuCadastrar.add(itemFornecedor = new JMenuItem(FORNECEDOR));
		menuCadastrar.add(itemTransportadora = new JMenuItem(TRANSPORTADORA));
		menuCadastrar.add(itemProdutos = new JMenuItem(PRODUTOS));
		
		menuListar.add(itemListarCliente = new JMenuItem(LISTAR_CLIENTE));
		menuListar.add(itemListarFornecedor = new JMenuItem(LISTAR_FORNECEDOR));
		menuListar.add(itemListarTransportadora = new JMenuItem(LISTAR_TRANSPORTADORA));
		menuListar.add(itemListarProdutos = new JMenuItem(LISTAR_PRODUTOS));
		
		menuRelatorios.add(itemPagamento = new JMenuItem(PAGAMENTO));
		menuRelatorios.add(itemRecebimento = new JMenuItem(RECEBIMENTO));
		menuRelatorios.add(itemBalanco = new JMenuItem(BALANCO));
		
		menuVendas.add(itemRealizarVendas = new JMenuItem(REALIZAR_VENDA));
		menuVendas.add(itemVendasAVista = new JMenuItem(VENDAS_A_VISTA));
		menuVendas.add(itemVendasDuplicatas = new JMenuItem(VENDAS_DUPLICATAS));
		menuVendas.add(itemTodasVendas = new JMenuItem(TODAS_AS_VENDAS));
		
		menuSair.add(itemSair = new JMenuItem(SAIR));
		
		menuBar.add(menuCadastrar);
		menuBar.add(menuListar);
		menuBar.add(menuRelatorios);
		menuBar.add(menuEstoque);
		menuBar.add(menuVendas);
		menuBar.add(menuSair);
		
		painel.setLayout(painelLayout());
		frame.setJMenuBar(menuBar);
	}	
	


	private void instanciarEventos(){
		
		PrincipalController principalCont = new PrincipalController(frame);
		
		itemCliente.addActionListener(principalCont);
		itemFornecedor.addActionListener(principalCont);
		itemTransportadora.addActionListener(principalCont);
		itemProdutos.addActionListener(principalCont);
		itemListarCliente.addActionListener(principalCont);
		itemListarFornecedor.addActionListener(principalCont);
		itemListarTransportadora.addActionListener(principalCont);
		itemListarProdutos.addActionListener(principalCont);
		itemPagamento.addActionListener(principalCont);
		itemRecebimento.addActionListener(principalCont);
		itemBalanco.addActionListener(principalCont);
		itemRealizarVendas.addActionListener(principalCont);
		itemVendasAVista.addActionListener(principalCont);
		itemVendasDuplicatas.addActionListener(principalCont);
		itemTodasVendas.addActionListener(principalCont);
		itemSair.addActionListener(principalCont);

	}
	
	private void instanciarFrame(){
		try { //Exceção para utilizar ou não o tema Ninbus do java  
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  
		} catch (Exception e) {  
			e.printStackTrace();  
		}

		frame = new JFrame();
		painel = new JPanel();
		label = new JLabel();
		
//		frame.getContentPane().setLayout(frameLayout());
		frame.setTitle("Café Novo Horizonte");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Imagens/CafeIcone.png")); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
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
	
	private GroupLayout painelLayout(){
		label.setText("contador " + ++count);
		GroupLayout layout = new GroupLayout(painel);
		
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
                .addContainerGap().addComponent(label)
                .addContainerGap(336, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label)
                .addContainerGap(282, Short.MAX_VALUE)));
	
		return layout;
	}
	
	private GroupLayout frameLayout(){
		
		GroupLayout layout = new GroupLayout(frame.getContentPane());
		
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(painel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(painel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        frame.pack();
	
		return layout;
	}
}

