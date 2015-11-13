package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

import Views.FrameCadastroProduto;

public class CadastroClienteController implements ActionListener{
	private JDialog dialog;
	private JTextField tfNomeFantasia, tfEmail, tfTelefone, tfRua, tfNumero, tfBairro, 
	   tfCidade, tfCep, tfCpfCnpj, tfNInscricao;
	private JComboBox cbEstado, cbTipoImposto;
	
	
	public CadastroClienteController(JDialog dialog, JTextField tfNomeFantasia, JTextField tfEmail, 
									 JTextField tfTelefone, JTextField tfRua, JTextField tfNumero,
									 JTextField tfBairro, JTextField tfCidade, JTextField tfCep,
									 JTextField tfCpfCnpj, JTextField tfNInscricao, 
									 JComboBox cbEstado, JComboBox cbTipoImposto){
		
		this.dialog = dialog;
		this.tfNomeFantasia = tfNomeFantasia;
		this.tfEmail = tfEmail;
		this.tfTelefone = tfTelefone;
		this.tfRua = tfRua;
		this.tfNumero = tfNumero;
		this.tfBairro = tfBairro;
		this.tfCidade = tfCidade;
		this.tfCep = tfCep;
		this.tfCpfCnpj = tfCpfCnpj;
		this.tfNInscricao = tfNInscricao;
		this.cbEstado = cbEstado;
		this.cbTipoImposto = cbTipoImposto;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(FrameCadastroProduto.CADASTRAR.equals(e.getActionCommand())){
			
			cadastrar();
			
		} else if(FrameCadastroProduto.LIMPAR.equals(e.getActionCommand())){
			
			limpar();
			
		} else if(FrameCadastroProduto.CANCELAR.equals(e.getActionCommand())){
			
			cancelar();
		}			
	}
	
	private void cadastrar(){
		
	}
	
	
	
	private void limpar() {
		tfNomeFantasia.setText("");
		tfEmail.setText("");
		tfTelefone.setText("");
		tfRua.setText("");
		tfNumero.setText("");
		tfBairro.setText("");
		tfCidade.setText("");
		tfCep.setText("");
		tfCpfCnpj.setText("");
		tfNInscricao.setText("");
		cbEstado.setSelectedIndex(0);
		cbTipoImposto.setSelectedIndex(0);	
	}

	private void cancelar() {	
		dialog.dispose();
	}

	
}
