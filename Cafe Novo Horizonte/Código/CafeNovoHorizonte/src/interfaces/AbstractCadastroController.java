package interfaces;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import views.FrameHome;
import views.FramePrincipal;

public abstract class AbstractCadastroController {

	public static final int CADASTRAR = 0;
	public static final int LIMPAR = 1;
	public static final int CANCELAR = 2;
	
	private Container [] containers;
	
	public AbstractCadastroController(Container... containers) {
		
		this.containers = containers;
	}
	
	public ActionListener getActionListener(int id){
		return new AddActionListener(id);
	}
	
	protected void cadastrar(){
		JOptionPane.showMessageDialog(null, "btnCadastrar clickado", "cadastrar", 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	protected void limpar(){
		
		for(int i = 0; i < containers.length; i++){
			if (containers[i] instanceof JTextField){
				
				resetarTextField((JTextField) containers[i]);
				
			} else if (containers[i] instanceof JComboBox){

				resetarComboBox((JComboBox<?>) containers[i]);
				
			} else if (containers[i] instanceof JCheckBox){

				resetarChecBox((JCheckBox) containers[i]);
			}
		}
	}
	
	protected void cancelar(){
		int result = JOptionPane.showConfirmDialog(null, "Você realmente deseja cancelar esse cadastro?", 
				"Cancelar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (result == JOptionPane.YES_OPTION){

			FramePrincipal.setPanel(new FrameHome());
		}	
	}
	
	private void resetarTextField(JTextField textField){
		textField.setText("");
	}
	
	private void resetarComboBox(JComboBox<?> comboBox){
		comboBox.setSelectedIndex(0);
	}
	
	private void resetarChecBox(JCheckBox checkBox){
		checkBox.setSelected(false);
	}
	
	private class AddActionListener implements ActionListener{
		
		private int id;
		
		public AddActionListener(int id) {
			this.id = id;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			switch (id){
				case CADASTRAR:{
					
					cadastrar();
					break;
					
				} case LIMPAR:{
					
					limpar();
					break;
					
				} case CANCELAR:{
					
					cancelar();
					break;
				}
			}
		}
	}
}
