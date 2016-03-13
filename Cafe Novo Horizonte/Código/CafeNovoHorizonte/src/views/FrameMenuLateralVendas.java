package views;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controllers.MenuLateralController;
import interfaces.AbstractMenuLateral;

public class FrameMenuLateralVendas extends AbstractMenuLateral {
	
	private JLabel menus[];
	private MenuLateralController controller;
	
	private static final int REALIZAR_VENDA = 0;
	private static final int LISTAR_VENDAS_A_VISTA  = 1;
	private static final int LISTAR_VENDAS_DUPLICATA  = 2;
	private static final int LISTAR_VENDAS = 3;
	
	private static final int [] ID_MENUS = {REALIZAR_VENDA, LISTAR_VENDAS_A_VISTA, 
			LISTAR_VENDAS_DUPLICATA, LISTAR_VENDAS}; 

	public FrameMenuLateralVendas(JFrame frame, Point posicao) {
	
		super(posicao, ID_MENUS);
		this.menus = getMenus();
		this.controller = new MenuLateralController(frame);
		configurarMenusLaterais();
		iniciarEventos();
	}
	
	@Override
	public void configurarMenusLaterais() {
		
		menus[REALIZAR_VENDA].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/realizar_venda.png"));
		menus[LISTAR_VENDAS_A_VISTA].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/listar_a_vista.png"));
		menus[LISTAR_VENDAS_DUPLICATA].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/listar_duplicata.png"));
		menus[LISTAR_VENDAS].setIcon(new ImageIcon(FramePrincipal.URL_IMAGENS + "/listar_vendas.png"));
	}

	@Override
	public void iniciarEventos() {
		menus[REALIZAR_VENDA].addMouseListener(controller.getMouseListener(FramePrincipal.REALIZAR_VENDA, this));
		menus[LISTAR_VENDAS_A_VISTA].addMouseListener(controller.getMouseListener(FramePrincipal.LISTAR_VENDAS_A_VISTA, this));
		menus[LISTAR_VENDAS_DUPLICATA].addMouseListener(controller.getMouseListener(FramePrincipal.LISTAR_VENDAS_DUPLICATA, this));
		menus[LISTAR_VENDAS].addMouseListener(controller.getMouseListener(FramePrincipal.LISTAR_VENDAS, this));
		
	}
}
