package br.com.sharktech.forca;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static final int PORTA = 6789;

	private static int codClientes = 0;
	private ServerSocket serverSocket = null;
	
	public Servidor() throws IOException {
		serverSocket = new ServerSocket(PORTA);
	}
	
	public static int getCodNovoCliente() {
		return ++codClientes;
	}
	
	public void aceitarClientes() throws IOException{
		
		if(serverSocket != null){

			while(true){
				Socket conexao = serverSocket.accept();
				new ThreadConexao(conexao).start();
				System.out.println("Nova conexao");
			}
		}
	}
	
	public static void main(String[] args) {
		
		try {
			
			System.out.println("Server running");
			Servidor server = new Servidor();
			server.aceitarClientes();
						
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
