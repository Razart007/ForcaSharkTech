package controllers;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import interfaces.AbstractCadastroController;

public class CadastroClienteController extends AbstractCadastroController{
		
	public CadastroClienteController (JTextField tfNomeFantasia, JTextField tfEmail, 
			JTextField tfTelefone,JTextField tfRua, JTextField tfNumero, JTextField tfBairro,
			JTextField tfCidade, JTextField tfCep, JTextField tfCpfCnpj, JTextField tfNInscricao, 
			JComboBox<String> cbEstado,	JComboBox<String> cbTipoImposto) {
		
		super(tfNomeFantasia, tfEmail, tfTelefone, tfRua, tfNumero, tfBairro, tfCidade,
				tfCep, tfCpfCnpj, tfNInscricao, cbEstado, cbTipoImposto);
	}
}
