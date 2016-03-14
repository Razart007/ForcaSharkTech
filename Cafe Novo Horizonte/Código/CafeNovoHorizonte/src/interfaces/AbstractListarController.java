package interfaces;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import views.FrameListarCliente;

public abstract class AbstractListarController<E> {

	
	public static final int PESQUISAR = 0;
		
	public KeyListener getKeyListener(int id){
		return new AddKeyListener(id);
	}
	
	public MouseListener getMouseListener(int id){
		return new AddMouseListener(id);
	}
	
	public MouseListener getMouseListener(JTable tabela, AbstractTabelaCrud<E> modelo){
		return new AddMouseListener(tabela, modelo);
	}
	
	public ArrayList<E> pesquisar(){
		JOptionPane.showMessageDialog(null, "Pesquisar selecionado", 
				"Pesquisar", JOptionPane.ERROR_MESSAGE);
		return null;
	}
	
	public void editar(E e){
		JOptionPane.showMessageDialog(null, e.toString(), 
				"Editar", JOptionPane.WARNING_MESSAGE);
	}
	
	public void excluir(E e){

		JOptionPane.showMessageDialog(null, e.toString(), 
				"Excluir", JOptionPane.ERROR_MESSAGE);
	}
	
	private class AddKeyListener implements KeyListener{

		private int id;
		
		public AddKeyListener(int id) {
			this.id = id;
		}

		@Override
		public void keyPressed(KeyEvent e) {}

		@Override
		public void keyReleased(KeyEvent e) {}

		@Override
		public void keyTyped(KeyEvent e) {
			
			if(id == PESQUISAR){
				pesquisar();
			}
		}		
	}
	
	private class AddMouseListener implements MouseListener{

		private int id;
		private JTable tabela;
		private AbstractTabelaCrud<E> modelo;
				
		public AddMouseListener(JTable tabela, AbstractTabelaCrud<E> modelo) {
			this.id = -1;
			this.tabela = tabela;
			this.modelo = modelo; 
		}

		public AddMouseListener(int id) {
			this.id = id;
			this.tabela = null;
			this.modelo = null;
		}

		@Override
		public void mouseClicked(MouseEvent event) { }

		@Override
		public void mouseEntered(MouseEvent arg0) {	}

		@Override
		public void mouseExited(MouseEvent arg0) { }

		@Override
		public void mousePressed(MouseEvent arg0) { }

		@Override
		public void mouseReleased(MouseEvent arg0) { 
			
			switch(id){
			
				case -1: {
					
					int linha = tabela.getSelectedRow();
					int coluna = tabela.getSelectedColumn();
					
					E e = modelo.get(linha);
					
					switch(coluna){
						case FrameListarCliente.EDITAR :{
							editar(e);
							break;
						} case FrameListarCliente.EXCLUIR :{
							excluir(e);
							break;
						}
					}
					break;
					
				} default: {
				
					switch(id){
						case PESQUISAR:{
							pesquisar();
							break;
						}
					}
				}
			}
		}
	}
}
