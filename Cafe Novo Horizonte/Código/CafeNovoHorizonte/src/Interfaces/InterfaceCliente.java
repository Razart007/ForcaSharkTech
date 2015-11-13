package Interfaces;

import Entidades.Cliente;

public interface InterfaceCliente {
	public boolean inserir(Cliente c);
	public void remover(int id);
	public void pesquisar(int id);
	public void alterar(Cliente c);

}
