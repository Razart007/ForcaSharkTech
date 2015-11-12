package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.*;

public class PrincipalController implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (FramePrincipal.CLIENTE.equals(e.getActionCommand())){
			
			new FrameCadastroCliente();
			
		} else if(FramePrincipal.FORNECEDOR.equals(e.getActionCommand())){

		} else if(FramePrincipal.TRANSPORTADORA.equals(e.getActionCommand())){

		} else if(FramePrincipal.PRODUTOS.equals(e.getActionCommand())){
			
			new FrameCadastroProduto();

		} else if(FramePrincipal.PAGAMENTO.equals(e.getActionCommand())){

		} else if(FramePrincipal.RECEBIMENTO.equals(e.getActionCommand())){

		} else if(FramePrincipal.BALANCO.equals(e.getActionCommand())){

		} else if(FramePrincipal.REALIZAR_VENDA.equals(e.getActionCommand())){

		} else if(FramePrincipal.VENDAS_A_VISTA.equals(e.getActionCommand())){

		} else if(FramePrincipal.VENDAS_DUPLICATAS.equals(e.getActionCommand())){

		} else if(FramePrincipal.TODAS_AS_VENDAS.equals(e.getActionCommand())){

		}
	}

	
	
}
