package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuLateralController {
	
	public MouseListener getMouseListener(){
		return new AddMouseListener();
	}
	
	private class AddMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) { }

		@Override
		public void mouseEntered(MouseEvent e) { }

		@Override
		public void mouseExited(MouseEvent e) { }

		@Override
		public void mousePressed(MouseEvent e) { }

		@Override
		public void mouseReleased(MouseEvent e) { }
		
	}
}
