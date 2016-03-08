package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import views.FrameCadastroCliente;

public class CadastroClienteController  {
	
	public CadastroClienteController() { }
	
	public AddActionListener getActionListener(String name){
		return new AddActionListener(name);
	}
	
	private class AddActionListener implements ActionListener{
		

		private String name;
		
		public AddActionListener(String name) {
			this.name = name;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(name.equals(FrameCadastroCliente.CADASTRAR)){
				
				JOptionPane.showMessageDialog(null, "btnCadastrar clickado", name, JOptionPane.INFORMATION_MESSAGE);
				
			} else if(name.equals(FrameCadastroCliente.LIMPAR)){
				
				JOptionPane.showMessageDialog(null, "btnlimpar clickado", name, JOptionPane.INFORMATION_MESSAGE);
		
			} else if(name.equals(FrameCadastroCliente.CANCELAR)){
				
				JOptionPane.showMessageDialog(null, "btncancelar clickado", name, JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

}
