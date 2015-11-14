package Interfaces;

import Entidades.Cliente;

public interface InterfaceCliente {
	
	public boolean inserir(Cliente c);
	public void remover(Cliente c);
	public void pesquisar(Cliente c);
	public void alterar(Cliente c);

}
