package controllers;

import javax.swing.JTable;
import javax.swing.JTextField;

import entidades.Produto;
import interfaces.AbstractListarController;
import interfaces.AbstractTabelaCrud;

public class ListarProdutoController extends AbstractListarController <Produto>{

	public ListarProdutoController(JTextField text, JTable tabela, AbstractTabelaCrud<Produto> modelo) {
		super(text, tabela, modelo);
	}
}
