package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import views.*;

public class PrincipalController implements ActionListener{
	
	private JFrame frame;
	
	public PrincipalController(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (FramePrincipal.CLIENTE.equals(e.getActionCommand())){
			
			new FrameCadastroCliente(frame);
			
		} else if(FramePrincipal.FORNECEDOR.equals(e.getActionCommand())){

		} else if(FramePrincipal.TRANSPORTADORA.equals(e.getActionCommand())){
			
			new FrameCadastroTransportadora(frame);
			
		} else if(FramePrincipal.PRODUTOS.equals(e.getActionCommand())){
			
			new FrameCadastroProduto(frame);

		}if (FramePrincipal.LISTAR_CLIENTE.equals(e.getActionCommand())){
			
			new FrameListarCliente(frame);
			
		} else if(FramePrincipal.LISTAR_FORNECEDOR.equals(e.getActionCommand())){

		} else if(FramePrincipal.LISTAR_TRANSPORTADORA.equals(e.getActionCommand())){
			
		} else if(FramePrincipal.LISTAR_PRODUTOS.equals(e.getActionCommand())){

		} else if(FramePrincipal.PAGAMENTO.equals(e.getActionCommand())){

		} else if(FramePrincipal.RECEBIMENTO.equals(e.getActionCommand())){

		} else if(FramePrincipal.BALANCO.equals(e.getActionCommand())){

		} else if(FramePrincipal.REALIZAR_VENDA.equals(e.getActionCommand())){

		} else if(FramePrincipal.VENDAS_A_VISTA.equals(e.getActionCommand())){

		} else if(FramePrincipal.VENDAS_DUPLICATAS.equals(e.getActionCommand())){

		} else if(FramePrincipal.TODAS_AS_VENDAS.equals(e.getActionCommand())){
			
		} else if(FramePrincipal.SAIR.equals(e.getActionCommand())){
			
			int result = JOptionPane.showConfirmDialog(frame, "Você realmente deseja sair do aplicativo?", "SAIR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (result == JOptionPane.YES_OPTION){
				frame.dispose();
				new FrameLogin();	
			}
		}
	}

	
	
}
