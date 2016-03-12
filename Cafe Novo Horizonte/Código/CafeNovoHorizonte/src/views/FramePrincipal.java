package views;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;

import controllers.PrincipalController;

public class FramePrincipal{
	
	public static final int LARGURA = 150;
	public static final int ALTURA = 50;
	public static final int GAP = 10;
	
	public static final String URL_IMAGENS = "Imagens";
	public static final int ARQUIVO = 1;
	public static final int USUARIO = 2;
	public static final int ABRIR = 3;
	public static final int SALVAR = 4;
	public static final int HOME = 5;
	public static final int CADASTRAR = 6;
	public static final int LISTAR = 7;
	public static final int RELATORIOS = 8;
	public static final int ESTOQUE = 9;
	public static final int VENDAS = 10;
	public static final int CLIENTE = 11;
	public static final int TRANSPORTADORA = 12;
	public static final int FORNECEDOR = 13;
	public static final int PRODUTO = 14;
	public static final int LISTAR_CLIENTE = 15;
	public static final int LISTAR_TRANSPORTADORA = 16;
	public static final int LISTAR_FORNECEDOR = 17;
	public static final int LISTAR_PRODUTO = 18;
	public static final int PAGAMENTO = 19;
	public static final int RECEBIMENTO = 20;
	public static final int BALANCO = 21;
	public static final int REALIZAR_VENDA = 22;
	public static final int LISTAR_VENDAS_A_VISTA  = 23;
	public static final int LISTAR_VENDAS_DUPLICATA  = 24;
	public static final int LISTAR_VENDAS = 25;
	public static final int SAIR = 26;
	
	private PrincipalController controller;
	private JFrame frame;
	private JMenuBar menuBar;
	private static JScrollPane scrTelaPrincipal;
	private JPanel pnlMenuLateral;
	private static JPanel pnlPrincipal;	
	private JLabel lblHome, lblCadastrar, lblListar, lblRelatorios, lblEstoque, 
			lblVendas, lblSair;
	private JMenuItem mItemSalvar, mItemAbrir, mItemSair;
	
	
	public FramePrincipal(String s) {
		
		frame = new JFrame(s);
		controller = new PrincipalController(frame);
		
		menuBar = new JMenuBar();
		mItemAbrir = new JMenuItem("Abrir");
		mItemSalvar = new JMenuItem("Salvar");
		mItemSair = new JMenuItem("Sair", new ImageIcon("Imagens/icon_sair.png"));
		
		pnlMenuLateral = new JPanel();
		pnlPrincipal = new FrameHome().getPanel();
		scrTelaPrincipal = new JScrollPane();
		
		lblHome = new JLabel(new ImageIcon(URL_IMAGENS + "/home.png"));
		lblCadastrar = new JLabel(new ImageIcon(URL_IMAGENS + "/cadastrar.png"));
		lblListar = new JLabel(new ImageIcon(URL_IMAGENS + "/listar.png"));
		lblRelatorios = new JLabel(new ImageIcon(URL_IMAGENS + "/relatorios.png"));
		lblEstoque = new JLabel(new ImageIcon(URL_IMAGENS + "/estoque.png"));
		lblVendas = new JLabel(new ImageIcon(URL_IMAGENS + "/vendas.png"));
		lblSair = new JLabel(new ImageIcon(URL_IMAGENS + "/sair.png"));

		iniciarLookAndFeel();
		iniciarMenu();
		iniciarComponentes();
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
		try { //Exceção para utilizar ou não o tema Ninbus do java  
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
      
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(FramePrincipal.URL_IMAGENS + "/CafeIcone.png"));
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
	
	private void iniciarEventos(){

//		frame.addFocusListener(controller.getFocusListener());
		frame.addWindowListener(controller.getWindowListener());
		frame.addWindowStateListener(controller.getWindowStateListener());
	
		//Itens da barra de menus prinicipal
		mItemSalvar.addActionListener(controller.getAcitonListener(SALVAR));
		mItemAbrir.addActionListener(controller.getAcitonListener(ABRIR));
		mItemSair.addActionListener(controller.getAcitonListener(SAIR));
		
		//Itens no menu lateral		
		lblHome.addMouseListener(controller.getMouseListener(HOME));
		lblCadastrar.addMouseListener(controller.getMouseListener(CADASTRAR));
		lblListar.addMouseListener(controller.getMouseListener(LISTAR));
		lblRelatorios.addMouseListener(controller.getMouseListener(RELATORIOS));
		lblEstoque.addMouseListener(controller.getMouseListener(ESTOQUE));
		lblVendas.addMouseListener(controller.getMouseListener(VENDAS));
		lblSair.addMouseListener(controller.getMouseListener(SAIR));
	}	
}
