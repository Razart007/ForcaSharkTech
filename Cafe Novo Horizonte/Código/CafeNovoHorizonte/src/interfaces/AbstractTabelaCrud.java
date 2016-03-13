package interfaces;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public abstract class AbstractTabelaCrud <E> extends AbstractTableModel{
	
	public static final ImageIcon ICON_EDITAR = new ImageIcon("Imagens/edit-user-icon-32.png");
	public static final ImageIcon ICON_EXCLUIR = new ImageIcon("Imagens/remove-user-icon-32.png");
	
	private static final long serialVersionUID = 1L;

	@Override
	public abstract int getColumnCount();
	@Override
	public abstract int getRowCount();
	@Override
	public abstract Object getValueAt(int linha, int coluna);
	@Override
	public abstract void setValueAt(Object valor, int linha, int coluna);
	@Override
	public abstract Class<?> getColumnClass(int coluna) ;
	@Override
	public abstract String getColumnName(int coluna) ;
	@Override
	public abstract boolean isCellEditable(int linha, int coluna);

	public abstract E get(int linha);
	public abstract void salvar(E e);
	public abstract void salvar(ArrayList<E> e);
	public abstract E alterar (int linha, E e);
	public abstract E excluir (int indice);
	
	public static class IconTableRenderer extends DefaultTableCellRenderer  {  
		 
		private static final long serialVersionUID = 1L;

		protected void setValue(Object value){  
	  
	        if (value instanceof ImageIcon){  
	  
	            if (value != null){  
	                ImageIcon d = (ImageIcon) value;  
	                setIcon(d);  
	            }  
	              
	        } else {  
	            super.setValue(value);  
	        }     
	    }
	}

	
}
