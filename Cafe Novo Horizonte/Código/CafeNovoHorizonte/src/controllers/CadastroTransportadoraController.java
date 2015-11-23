package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

import views.FrameCadastroTransportadora;

public class CadastroTransportadoraController implements ActionListener, ItemListener{

	private JDialog dialog;
	private JTextField txNome, txDocumento, txInscricaoEstadual, txRua, txNumero,
			txComplemento, txBairro, txCep, txPais, txMunicipio, txTelefone;
	private JComboBox<String> cmbTipoDocumento, cmbUf;
	private JCheckBox chbIsentoIcms;

	
	public CadastroTransportadoraController(JDialog dialog, JTextField txNome, JTextField txDocumento,
			JTextField txInscricaoEstadual, JTextField txRua, JTextField txNumero, JTextField txComplemento,
			JTextField txBairro, JTextField txCep, JTextField txPais, JTextField txMunicipio, JTextField txTelefone,
			JComboBox<String> cmbTipoDocumento, JComboBox<String> cmbUf, JCheckBox chbIsentoIcms) {
	
		this.dialog = dialog;
		this.txNome = txNome;
		this.txDocumento = txDocumento;
		this.txInscricaoEstadual = txInscricaoEstadual;
		this.txRua = txRua;
		this.txNumero = txNumero;
		this.txComplemento = txComplemento;
		this.txBairro = txBairro;
		this.txCep = txCep;
		this.txPais = txPais;
		this.txMunicipio = txMunicipio;
		this.txTelefone = txTelefone;
		this.cmbTipoDocumento = cmbTipoDocumento;
		this.cmbUf = cmbUf;
		this.chbIsentoIcms = chbIsentoIcms;
	}

	@Override
	public void actionPerformed(ActionEvent actEvt) {
		
		if (FrameCadastroTransportadora.CADASTRAR.equals(actEvt.getActionCommand())){

			cadastrar();
			
		} else if (FrameCadastroTransportadora.LIMPAR.equals(actEvt.getActionCommand())){
			
			limpar();
			
		} else if (FrameCadastroTransportadora.CANCELAR.equals(actEvt.getActionCommand())){
			
			cancelar();
		}		
	}

	@Override
	public void itemStateChanged(ItemEvent actEvt) {
		
		if(actEvt.getSource().equals(cmbTipoDocumento)){
			
			tipoDocumentoAlterado(cmbTipoDocumento.getSelectedIndex());
			
		} else if(actEvt.getSource().equals(cmbUf)){
			
			ufAlterado(cmbUf.getSelectedIndex());			
		}		
	}

	private void cadastrar(){
		dialog.dispose();
	}
	
	private void limpar() {
		
		txNome.setText("");
		txTelefone.setText("");
		txRua.setText("");
		txNumero.setText("");
		txComplemento.setText("");
		txBairro.setText("");
		txMunicipio.setText("");
		txCep.setText("");
		txPais.setText("");
		txDocumento.setText("");
		txInscricaoEstadual.setText("");
		chbIsentoIcms.setSelected(false);
	}
	
	private void cancelar() {
		dialog.dispose();
	}
	
	private void tipoDocumentoAlterado(int index){
		
		if(index != 0){
			txDocumento.setEnabled(true);
		} else {
			txDocumento.setEnabled(false);
		}
	}
	
	private void ufAlterado(int index){
		if(cmbUf.getSelectedIndex() != 0){
			txMunicipio.setEnabled(true);
		} else {
			txMunicipio.setEnabled(false);
		}
	}
}
