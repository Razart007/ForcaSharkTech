package views;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public abstract class FrameMenuLateral {
	
	private static final int LARGURA = 150;
	private static final int ALTURA = 50;
	private static final int GAP = 10;	
	
	private JDialog dialog;
	private JPanel panel;
	private JLabel menus[];
	private Point posicao;
	
	public FrameMenuLateral(Point posicao, int idMenus[])  {

		this.dialog = new JDialog();
		this.panel = new JPanel();
		this.posicao = posicao;
			
		iniciarMenus(idMenus);
		iniciarComponentes();
	}

	public void setVisible(boolean flag){
		this.dialog.setVisible(flag);
	}
	
	public void dispose(){
		this.dialog.dispose();
	}
	
	public JLabel[] getMenus(){
		return this.menus;
	}
	
	public abstract void configurarMenusLaterais();
	public abstract void iniciarEventos();
	
	private void iniciarMenus(int[] idMenus){
		
		int total = idMenus.length;
		menus = new JLabel[total];
		
		for (int i = 0; i < total; i++){
			menus[i] = new JLabel();
		}
	}
	
	private void iniciarComponentes() {		
	
		
		panel.setBackground(Color.WHITE);
		panel.setLayout(getLayout());
		panel.setBorder(BorderFactory.createEtchedBorder());
		
		dialog.getContentPane().add(panel);
		dialog.setUndecorated(true); //Oculta a barra de titulos e borda do JFrame 
		dialog.setResizable(false);
		dialog.pack();
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setAlwaysOnTop(true);
		
		configurarPosicaoRelativa();
		
	}
	
	private void configurarPosicaoRelativa(){
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		double larguraTela = toolkit.getScreenSize().getWidth();
		double alturaTela = toolkit.getScreenSize().getHeight();
		double larguraMenu = dialog.getWidth();
		double alturaMenu = dialog.getHeight();
		
		int x = posicao.x + FramePrincipal.LARGURA + FramePrincipal.GAP / 2;
		int y = posicao.y;
		
		if((x + larguraMenu) > larguraTela){
			x = (int) (larguraTela - larguraMenu);
		}
		if( (y + alturaMenu) > alturaTela){
			y = (int) (alturaTela - alturaMenu);
		}
		
		dialog.setLocation(x, y);
	}

	private LayoutManager getLayout(){
		
		GroupLayout layout = new GroupLayout(panel);
		Groups groups = new Groups(layout);
		
		layout.setHorizontalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(GAP)
                .addGroup(groups.getParallel())
                .addGap(GAP)
            )
        );
		
		layout.setVerticalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(groups.getSequential())
		);
		
		return layout;		
	}
	
	private class Groups{
		
		private ParallelGroup parallel;
		private SequentialGroup sequential;
		
		public Groups(GroupLayout layout){
						
			parallel = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);
			sequential = layout.createSequentialGroup();
			
			gerarGroups();
		}
		
		public ParallelGroup getParallel() {
			return parallel;
		}
		
		public SequentialGroup getSequential() {
			return sequential;
		}
		
		private void gerarGroups(){

			sequential.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
			sequential.addGap(GAP);
			
			for(int i = 0; i < menus.length; i++){
				
				parallel.addComponent(menus[i], GroupLayout.DEFAULT_SIZE, LARGURA, Short.MAX_VALUE);
				
				sequential.addComponent(menus[i], GroupLayout.PREFERRED_SIZE, ALTURA, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGap(GAP);
			}
		}
	}
}