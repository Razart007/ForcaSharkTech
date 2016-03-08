package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class FrameHome {

	private JPanel panel;
	private JLabel lblImagem; 
	private ImageIcon icon;

	public FrameHome(Color c) {
		
		panel = new JPanel();
		icon = new ImageIcon("imgs/logo.png");
		lblImagem = new JLabel(icon, SwingConstants.RIGHT);
		
		configurarComponentes(c);
	}
	
	private void configurarComponentes(Color c){

		panel.setBackground(c);
		panel.setMinimumSize(new Dimension(840, 510));
		panel.setLayout(getLayoutTelaPrincipal());

	}
	
	private LayoutManager getLayoutTelaPrincipal(){
		
		GroupLayout layout = new GroupLayout(panel);

		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addComponent(lblImagem, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
        );
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(lblImagem))
        );
		return layout;
	}
	
	public JPanel getPanel(){

		return panel;
	}
}
