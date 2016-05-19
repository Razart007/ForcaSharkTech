package exercicio_3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private static int codClientes = 0;

	public static final String IP = "localhost";
	public static final int PORTA = 6789;

	private ServerSocket serverSocket = null;

	public Servidor() throws IOException {
		serverSocket = new ServerSocket(PORTA);
		System.out.println("Server running");
	}

	public static int getCodNovoCliente() {
		return ++codClientes;
	}

	public void aceitarClientes() throws IOException {

		ThreadConexao primeiroUsuario = null;
		boolean flag = true;

		while (flag) {

			if (primeiroUsuario == null) {

				Socket conexao = serverSocket.accept();
				primeiroUsuario = new ThreadConexao(conexao, true);
				primeiroUsuario.start();

			} else {
				Socket conexao = serverSocket.accept();
				ThreadConexao segundoUsuario = new ThreadConexao(conexao, primeiroUsuario.getIp(), primeiroUsuario.getCod());
				segundoUsuario.start();
				
				primeiroUsuario.setIpDesafiante(segundoUsuario.getIp());
				primeiroUsuario.setCodDesafiante(segundoUsuario.getCod());
				primeiroUsuario.setAguardar(false);
				primeiroUsuario = null;
			}
		}
		serverSocket.close();
	}

	public static void main(String[] args) {

		try {
			
			new Servidor().aceitarClientes();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
