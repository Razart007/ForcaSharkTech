package views;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FrameMenuLateralListar extends FrameMenuLateral {

private static final int TOTAL = 4;
	
	private static JLabel menus[] = new JLabel[TOTAL];
	
	public FrameMenuLateralListar(Point posicao) {

		super(menus, posicao);
	}
	
	@Override
	public void configurarMenusLaterais() {		
		
		menus[CLIENTE].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/cliente.png"));
		menus[TRANSPORTADORA].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/transportadora.png"));
		menus[FORNECEDOR].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/fornecedor.png"));
		menus[PRODUTO].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/produto.png"));
	}

}
