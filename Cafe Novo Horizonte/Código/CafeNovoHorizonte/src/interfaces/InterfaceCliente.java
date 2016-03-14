package interfaces;

import java.util.ArrayList;

import entidades.Cliente;

public interface InterfaceCliente {
	
	public boolean inserir(Cliente c);
	public void remover(Cliente c);
	public void pesquisar(Cliente c);
	public ArrayList<Cliente> pesquisar();
	public void alterar(Cliente c);	
}

