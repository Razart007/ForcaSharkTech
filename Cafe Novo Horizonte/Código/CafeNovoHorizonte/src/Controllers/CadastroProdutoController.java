 package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTextField;

import Views.FrameCadastroProduto;

public class CadastroProdutoController implements ActionListener{

	private JDialog dialog;
	private JTextField txCodigo,  txDescricao, txEan, txEanUnidTrib, txExIpi, txGenero,
			txNcm, txQntTrib, txUnidCom, txUnidTrib, txValorUnidCom, txValorUnidTrib;

	public CadastroProdutoController(JDialog dialog, JTextField txCodigo, JTextField txDescricao, JTextField txEan,
			JTextField txEanUnidTrib, JTextField txExIpi, JTextField txGenero, JTextField txNcm, JTextField txQntTrib,
			JTextField txUnidCom, JTextField txUnidTrib, JTextField txValorUnidCom, JTextField txValorUnidTrib) {
		
		this.dialog = dialog;
		this.txCodigo = txCodigo;
		this.txDescricao = txDescricao;
		this.txEan = txEan;
		this.txEanUnidTrib = txEanUnidTrib;
		this.txExIpi = txExIpi;
		this.txGenero = txGenero;
		this.txNcm = txNcm;
		this.txQntTrib = txQntTrib;
		this.txUnidCom = txUnidCom;
		this.txUnidTrib = txUnidTrib;
		this.txValorUnidCom = txValorUnidCom;
		this.txValorUnidTrib = txValorUnidTrib;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(FrameCadastroProduto.CADASTRAR.equals(e.getActionCommand())){
			
			cadastrar();
			
		} else if(FrameCadastroProduto.LIMPAR.equals(e.getActionCommand())){
			
			limpar();
			
		} else if(FrameCadastroProduto.CANCELAR.equals(e.getActionCommand())){
			
			cancelar();
		}		
	}

	private void cadastrar() {
		//TODO: Criar a tabela de cadastro de produtos no Banco. Usar o SQL para inserir os dados no banco.
		System.out.println("CADASTRAR");
	}

	private void limpar() {
		
		txCodigo.setText("");
		txDescricao.setText("");
		txEan.setText("");
		txEanUnidTrib.setText("");
		txExIpi.setText("");
		txGenero.setText("");
		txNcm.setText("");
		txQntTrib.setText("");
		txUnidCom.setText("");
		txUnidTrib.setText("");
		txValorUnidCom.setText("");
		txValorUnidTrib.setText("");
	}

	private void cancelar() {
		
		dialog.dispose();
	}
}
