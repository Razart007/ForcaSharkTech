package views;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;

import controllers.PrincipalController;

public class FramePrincipal {
	
	private static final int LARGURA = 150;
	private static final int ALTURA = 50;
	private static final int GAP = 10;
	
	public static final String ARQUIVO = "Arquivo";
	public static final String USUARIO = "Usuario";
	public static final String ABRIR = "Abrir";
	public static final String SALVAR = "Salvar";
	public static final String HOME = "Home";
	public static final String CADASTRAR = "Cadastrar";
	public static final String LISTAR = "Listar";
	public static final String RELATORIOS = "Relatorios";
	public static final String ESTOQUE = "Estoque";
	public static final String VENDAS = "Vendas";
	public static final String SAIR = "Sair";
	
	private PrincipalController controller;
	private JFrame frame;
	private JMenuBar menuBar;
	private static JScrollPane scrTelaPrincipal;
	private JPanel pnlMenuLateral;
	private static JPanel pnlPrincipal;
	private JLabel lblHome, lblCadastrar, lblListar, lblRelatorios, lblEstoque, lblVendas, 
			lblSair;
	private JMenuItem mItemSalvar, mItemAbrir, mItemSair;
	
	
	public FramePrincipal(String s) {
		
		frame = new JFrame(s);
		controller = new PrincipalController(frame);
		
		menuBar = new JMenuBar();
		mItemAbrir = new JMenuItem(ABRIR);
		mItemSalvar = new JMenuItem(SALVAR);
		mItemSair = new JMenuItem(SAIR, new ImageIcon("Imagens/icon_sair.png"));
		
		scrTelaPrincipal = new JScrollPane();
		pnlMenuLateral = new JPanel();
		pnlMenuLateral = new FrameHome(Color.WHITE).getPanel();
		
		lblHome = new JLabel(new ImageIcon("Imagens/home.png"));
		lblCadastrar = new JLabel(new ImageIcon("Imagens/cadastrar.png"));
		lblListar = new JLabel(new ImageIcon("Imagens/listar.png"));
		lblRelatorios = new JLabel(new ImageIcon("Imagens/relatorios.png"));
		lblEstoque = new JLabel(new ImageIcon("Imagens/estoque.png"));
		lblVendas = new JLabel(new ImageIcon("Imagens/vendas.png"));
		lblSair = new JLabel(new ImageIcon("Imagens/sair.png"));

		iniciarLookAndFeel();
		iniciarMenu();
		iniciarComponentes();
		iniciarPopoupMenus();
		iniciarEventos();
	}

	public void setVisible(boolean flag){
		frame.setVisible(flag);
	}
	
	public static void setPanel(JPanel panel){
		pnlPrincipal = panel;
		scrTelaPrincipal.setViewportView(pnlPrincipal);
	}
	
	private void iniciarLookAndFeel(){
		try { //Exce��o para utilizar ou n�o o tema Ninbus do java  
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
	}
	
	private void iniciarMenu(){

		JMenu menuArquivo = new JMenu("Arquivo");
		JMenu menUsuario = new JMenu("Usuario");

		menuArquivo.add(mItemAbrir);
		menuArquivo.add(mItemSalvar);
		menUsuario.add(mItemSair);
		
		menuBar.add(menuArquivo);
		menuBar.add(menUsuario);

		frame.setJMenuBar(menuBar);
	}

	private void iniciarComponentes(){
				
		scrTelaPrincipal.setViewportView(pnlPrincipal);
        scrTelaPrincipal.setBorder(BorderFactory.createEtchedBorder());

		pnlMenuLateral.setLayout(getLayoutMenuLateral());
        pnlMenuLateral.setBorder(BorderFactory.createEtchedBorder());
        pnlMenuLateral.setBackground(Color.WHITE);

        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(getLayoutFrame());
		frame.pack();
		frame.setMinimumSize(new Dimension(900, 600));
		frame.setSize(1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
	
	private GroupLayout getLayoutFrame(){

		GroupLayout layout = new GroupLayout(frame.getContentPane());
		
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(pnlMenuLateral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(GAP)
						.addComponent(scrTelaPrincipal)
						.addContainerGap()
				)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(scrTelaPrincipal, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
								.addComponent(pnlMenuLateral, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()
				)
		);

		return layout;
	}
	
	private LayoutManager getLayoutMenuLateral(){

		GroupLayout layout = new GroupLayout(pnlMenuLateral);
		
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(GAP)
	                .addGroup(
	                		
	                		layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
	                		.addComponent(lblHome, GroupLayout.DEFAULT_SIZE, LARGURA, Short.MAX_VALUE)
	        				.addComponent(lblCadastrar, GroupLayout.DEFAULT_SIZE, LARGURA, Short.MAX_VALUE)
	        				.addComponent(lblListar, GroupLayout.DEFAULT_SIZE, LARGURA, Short.MAX_VALUE)
	        				.addComponent(lblRelatorios, GroupLayout.DEFAULT_SIZE, LARGURA, Short.MAX_VALUE)
	        				.addComponent(lblEstoque, GroupLayout.DEFAULT_SIZE, LARGURA, Short.MAX_VALUE)
	        				.addComponent(lblVendas, GroupLayout.DEFAULT_SIZE, LARGURA, Short.MAX_VALUE)
	        				.addComponent(lblSair, GroupLayout.DEFAULT_SIZE, LARGURA, Short.MAX_VALUE)
	        				
            		).addGap(GAP)
                )
        );
				
		layout.setVerticalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(
				layout.createSequentialGroup()
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGap(GAP)
				.addComponent(lblHome, GroupLayout.PREFERRED_SIZE, ALTURA, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGap(GAP)
				.addComponent(lblCadastrar, GroupLayout.PREFERRED_SIZE, ALTURA, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGap(GAP)
				.addComponent(lblListar, GroupLayout.PREFERRED_SIZE, ALTURA, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGap(GAP)
				.addComponent(lblRelatorios, GroupLayout.PREFERRED_SIZE, ALTURA, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGap(GAP)
				.addComponent(lblEstoque, GroupLayout.PREFERRED_SIZE, ALTURA, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGap(GAP)
				.addComponent(lblVendas, GroupLayout.PREFERRED_SIZE, ALTURA, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGap(GAP)
				.addComponent(lblSair, GroupLayout.PREFERRED_SIZE, ALTURA, GroupLayout.PREFERRED_SIZE)
			)
		);

		return layout;
	}
	
	private void iniciarPopoupMenus(){
		
		JPopupMenu menuCadastrar = new JPopupMenu();
		
		JMenuItem mItemCliente = new JMenuItem("Cliente");
		JMenuItem mItemFornecedor = new JMenuItem("Fornecedor");
		JMenuItem mItemTransportadora = new JMenuItem("Transportadora");
		JMenuItem mItemProduto = new JMenuItem("Produto");
		
		mItemCliente.addActionListener(controller.getAcitonListener("Cliente"));
		mItemFornecedor.addActionListener(controller.getAcitonListener("Fornecedor"));
		mItemTransportadora.addActionListener(controller.getAcitonListener("Transportadora"));
		mItemProduto.addActionListener(controller.getAcitonListener("Produto"));
		
		menuCadastrar.add(mItemCliente);
		menuCadastrar.add(mItemFornecedor);
		menuCadastrar.add(mItemTransportadora);
		menuCadastrar.add(mItemProduto);
		
		lblCadastrar.setComponentPopupMenu(menuCadastrar);
		
	}

	private void iniciarEventos(){

		frame.addWindowListener(controller.getWindowListener());
		
		//Itens da barra de menus prinicipal
		mItemSalvar.addActionListener(controller.getAcitonListener(SALVAR));
		mItemAbrir.addActionListener(controller.getAcitonListener(ABRIR));
		mItemSair.addActionListener(controller.getAcitonListener(SAIR));
		
		//Itens no menu lateral
		
		frame.addMouseListener(controller.getMouseListener("FRAME"));
		
		
		lblHome.addMouseListener(controller.getMouseListener(HOME));
		lblCadastrar.addMouseListener(controller.getMouseListener(CADASTRAR));
		lblListar.addMouseListener(controller.getMouseListener(LISTAR));
		lblRelatorios.addMouseListener(controller.getMouseListener(RELATORIOS));
		lblEstoque.addMouseListener(controller.getMouseListener(ESTOQUE));
		lblVendas.addMouseListener(controller.getMouseListener(VENDAS));
		lblSair.addMouseListener(controller.getMouseListener(SAIR));
	}	
}
