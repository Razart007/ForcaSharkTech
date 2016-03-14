package models;

import java.util.ArrayList;

import entidades.Cliente;
import interfaces.InterfaceCliente;

public class CadastroClienteModel  implements InterfaceCliente {

	@Override
	public boolean inserir(Cliente c) {
		
		return false;
	}

	@Override
	public void remover(Cliente c) {
		
	}

	@Override
	public void pesquisar(Cliente c) {
		
	}

	@Override
	public ArrayList<Cliente> pesquisar() {
		return null;
	}

	@Override
	public void alterar(Cliente c) {
		
	}
}
