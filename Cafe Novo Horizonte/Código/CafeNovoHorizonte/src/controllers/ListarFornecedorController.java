package controllers;

import javax.swing.JTable;
import javax.swing.JTextField;

import entidades.Fornecedor;
import interfaces.AbstractListarController;
import interfaces.AbstractTabelaCrud;

public class ListarFornecedorController extends AbstractListarController <Fornecedor>{
	
	public ListarFornecedorController(JTextField text, JTable tabela, AbstractTabelaCrud<Fornecedor> modelo) {
		super(text, tabela, modelo);
	}
}
