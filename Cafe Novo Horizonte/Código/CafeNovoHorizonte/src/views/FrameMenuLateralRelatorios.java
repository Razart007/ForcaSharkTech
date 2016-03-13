package views;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controllers.MenuLateralController;
import interfaces.AbstractMenuLateral;

public class FrameMenuLateralRelatorios extends AbstractMenuLateral {
		
	private JLabel menus[];	
	private MenuLateralController controller;
	
	private static final int PAGAMENTO = 0;
	private static final int RECEBIMENTO = 1;
	private static final int BALANCO = 2;

	private static final int[] ID_MENUS = {PAGAMENTO, RECEBIMENTO, BALANCO}; 
	
	public FrameMenuLateralRelatorios(JFrame frame, Point posicao) {

		super(posicao, ID_MENUS);
		this.menus = getMenus();
		this.controller = new MenuLateralController(frame);
		configurarMenusLaterais();
		iniciarEventos();
	}
	
	@Override
	public void configurarMenusLaterais() {
		
		menus[PAGAMENTO].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/pagamento.png"));
		menus[RECEBIMENTO].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/recebimento.png"));
		menus[BALANCO].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/balanco.png"));
	}

	@Override
	public void iniciarEventos() {
		menus[PAGAMENTO].addMouseListener(controller.getMouseListener(FramePrincipal.PAGAMENTO, this));
		menus[RECEBIMENTO].addMouseListener(controller.getMouseListener(FramePrincipal.RECEBIMENTO, this));
		menus[BALANCO].addMouseListener(controller.getMouseListener(FramePrincipal.BALANCO, this));
	}	
}
