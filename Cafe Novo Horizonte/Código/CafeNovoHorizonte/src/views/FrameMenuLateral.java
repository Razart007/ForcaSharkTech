package views;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;

public class FrameMenuLateral {
	
	private static final int LARGURA = 150;
	private static final int ALTURA = 50;
	private static final int GAP = 10;
	
	private JDialog dialog;
	private JLabel menus[];
//	private Dimension posicao;
	private String tituloMenus[];
	
	public FrameMenuLateral(Dimension posicao, String[] tituloMenus)  {
		
		this.dialog = new JDialog();
//		this.posicao = posicao;
		this.tituloMenus = tituloMenus;
		
		iniciarBotoes();		
		iniciarComponentes();
	}

	public void setVisible(boolean flag){
		this.dialog.setVisible(flag);
	}
	
	public boolean isVisible(){
		return this.dialog.isVisible();
	}
	
	public void dispose(){
		this.dialog.dispose();
	}
	
	private void iniciarBotoes(){
		
		menus = new JLabel[tituloMenus.length];
		
		for(int i = 0; i < tituloMenus.length; i++){
			menus[i] = new JLabel(tituloMenus[i]);
			iniciarEventos(menus[i]);
		}
	}

	private void iniciarComponentes() {

		dialog.getContentPane().setLayout(getLayout());
		dialog.setUndecorated(true); //Oculta a barra de titulos e borda do JFrame 
		dialog.setResizable(false);
		dialog.pack();
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setLocationRelativeTo(null);
	}
	
	private void iniciarEventos(JLabel menus) {
		
		menus.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(menus, menus.getText() + " clickado", 
						menus.getText(), JOptionPane.INFORMATION_MESSAGE );	
			}

			@Override
			public void mouseEntered(MouseEvent arg0) { }

			@Override
			public void mouseExited(MouseEvent arg0) { }

			@Override
			public void mousePressed(MouseEvent arg0) { }

			@Override
			public void mouseReleased(MouseEvent arg0) { }
			
		});
	}

	private LayoutManager getLayout(){
		
		GroupLayout layout = new GroupLayout(dialog.getContentPane());
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
