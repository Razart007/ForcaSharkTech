package views;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FrameMenuLateralVendas extends FrameMenuLateral {
	
	private static final int TOTAL = 4;
	
	private static JLabel menus[] = new JLabel[TOTAL];
	
	public FrameMenuLateralVendas(Point posicao) {

		super(menus, posicao);
	}
	
	@Override
	public void configurarMenusLaterais() {
		
		menus[REALIZAR_VENDA].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/realizar_vendas.png"));
		menus[LISTAR_VENDAS_A_VISTA].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/listar_a_vista.png"));
		menus[LISTAR_VENDAS_DUPLICATA].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/listar_duplicata.png"));
		menus[LISTAR_VENDAS].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/listar_todas.png"));
	}
}
