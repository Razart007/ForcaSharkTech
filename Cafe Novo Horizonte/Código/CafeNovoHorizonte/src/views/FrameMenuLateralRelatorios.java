package views;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FrameMenuLateralRelatorios extends FrameMenuLateral {

	private static final int TOTAL = 3;
	
	private static JLabel menus[] = new JLabel[TOTAL];
	
	public FrameMenuLateralRelatorios(Point posicao) {

		super(menus, posicao);
	}
	
	@Override
	public void configurarMenusLaterais() {
		
		menus[PAGAMENTO].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/pagamento.png"));
		menus[RECEBIMENTO].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/recebimento.png"));
		menus[BALANCO].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/balanco.png"));
	}

}
