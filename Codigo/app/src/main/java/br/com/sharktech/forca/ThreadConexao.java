package br.com.sharktech.forca;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ThreadConexao extends Thread{
	
	private Socket conexao;
	
	public ThreadConexao (Socket conexao){
		this.conexao = conexao;
	}
	
	@Override
	public void run() {
		super.run();

		try {
			
			int codCliente = Servidor.getCodNovoCliente();
			
			BufferedReader recebidoDoCliente = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			DataOutputStream enviarParaCliente = new DataOutputStream(conexao.getOutputStream());

			enviarParaCliente.writeBytes("Ola cliente! Sua id eh " + codCliente + '\n');
			System.out.println("Mensagem: " + recebidoDoCliente.readLine());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}