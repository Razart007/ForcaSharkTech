package views;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controllers.MenuLateralController;

public class FrameMenuLateralListar extends FrameMenuLateral {

	private JLabel menus[];
	private MenuLateralController controller;
	
	private static final int CLIENTE = 0;
	private static final int TRANSPORTADORA = 1;
	private static final int FORNECEDOR = 2;
	private static final int PRODUTO = 3;
	private static final int[] ID_MENUS = {CLIENTE, TRANSPORTADORA, FORNECEDOR, PRODUTO};

	public FrameMenuLateralListar(JFrame frame, Point posicao) {
	
		super(posicao, ID_MENUS);
		this.menus = getMenus();
		this.controller = new MenuLateralController(frame);
		configurarMenusLaterais();
		iniciarEventos();
	}
	
	@Override
	public void configurarMenusLaterais() {		
		
		menus[CLIENTE].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/cliente.png"));
		menus[TRANSPORTADORA].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/transportadora.png"));
		menus[FORNECEDOR].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/fornecedor.png"));
		menus[PRODUTO].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/produto.png"));
	}

	@Override
	public void iniciarEventos() {
		menus[CLIENTE].addMouseListener(controller.getMouseListener(FramePrincipal.LISTAR_CLIENTE, this));
		menus[TRANSPORTADORA].addMouseListener(controller.getMouseListener(FramePrincipal.LISTAR_TRANSPORTADORA, this));
		menus[FORNECEDOR].addMouseListener(controller.getMouseListener(FramePrincipal.LISTAR_FORNECEDOR, this));
		menus[PRODUTO].addMouseListener(controller.getMouseListener(FramePrincipal.LISTAR_PRODUTO, this));
	}
}
