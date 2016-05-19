package exercicio_3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadConexao extends Thread {

	private BufferedReader receptor;
	private DataOutputStream emissor;
	
	private Socket conexao;
	private String ip, ipDesafiante;	
	private int cod, codDesafiante;
	private boolean aguardar;
	private boolean server;
	
	public ThreadConexao(Socket conexao, String ipDesafiante, int codDesafiante) {
		
		this(conexao, ipDesafiante, codDesafiante, false);
	}
	
	public ThreadConexao(Socket conexao, boolean aguardar) {
		
		this(conexao, "0.0.0.0", 1000, aguardar);
	}

	public ThreadConexao(Socket conexao, String ipDesafiante, int codDesafiante, boolean aguardar) {
		
		try {
			
			this.conexao = conexao;
			this.receptor = new BufferedReader(new InputStreamReader(this.conexao.getInputStream()));
			this.emissor = new DataOutputStream(this.conexao.getOutputStream());
			
			this.cod = Servidor.getCodNovoCliente();
			this.ip = receptor.readLine();
			this.ipDesafiante = ipDesafiante;
			this.codDesafiante = codDesafiante;
			this.aguardar = server = aguardar;

			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public boolean isServer() {
		return server;
	}
	
	public String getIp(){
		return conexao.getInetAddress().getHostAddress();
	}
	
	public int getCod() {
		return cod;
	}

	public void setCodDesafiante(int codDesafiante) {
		this.codDesafiante = codDesafiante;
	}
	
	public void setIpDesafiante(String ipDesafiante) {
		this.ipDesafiante = ipDesafiante;
	}
	
	public void setAguardar(boolean aguardar) {
		this.aguardar = aguardar;
	}
	
	@Override
	public void run() {
		super.run();
		
		try {
			
			emissor.writeBytes(cod + "\n");			
			aguardaDesafio();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void aguardaDesafio() throws IOException {
		
		ArrayList<String> palavras = new ArrayList<>();
		palavras.add("estrogonofe");
		palavras.add("computador");
		palavras.add("maquina de lavar");
		palavras.add("caderno");
		palavras.add("impressora");
		
		System.out.print("Cliente: ");
		System.out.println("[Cod: " + cod + "][IP: " + conexao.getInetAddress().getHostAddress() + "][Desafiante: " + server +"]");
		while (aguardar) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		emissor.writeBytes(ipDesafiante + "\n");
		emissor.writeBytes(codDesafiante + "\n");
		emissor.writeBytes(server + "\n");
		emissor.writeBytes(palavras.size() + "\n");
		for(String s : palavras){
			emissor.writeBytes(s + "\n");
		}
		conexao.close();
	}
}
