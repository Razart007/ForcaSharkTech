package controllers;

import javax.swing.JTable;
import javax.swing.JTextField;

import entidades.Transportadora;
import interfaces.AbstractListarController;
import interfaces.AbstractTabelaCrud;

public class ListarTransportadoraController extends AbstractListarController <Transportadora>{
	
	public ListarTransportadoraController(JTextField text, JTable tabela, AbstractTabelaCrud<Transportadora> modelo) {
		super(text, tabela, modelo);
	}
}
