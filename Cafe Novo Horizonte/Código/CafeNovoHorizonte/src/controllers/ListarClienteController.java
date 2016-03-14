package controllers;

import javax.swing.JTable;
import javax.swing.JTextField;

import entidades.Cliente;
import interfaces.AbstractListarController;
import interfaces.AbstractTabelaCrud;

public class ListarClienteController extends AbstractListarController <Cliente>{
	
	public ListarClienteController(JTextField text, JTable tabela, AbstractTabelaCrud<Cliente> modelo) {
		super(text, tabela, modelo);
	}	
}
