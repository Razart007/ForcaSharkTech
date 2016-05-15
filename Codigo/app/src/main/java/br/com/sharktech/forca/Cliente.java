package br.com.sharktech.forca;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

public class Cliente extends AsyncTask<Void, Void, Void> {


    private static final String IP = "192.168.0.100";

	public Cliente(){
		Log.e("Client", "runing");
        this.execute();
    }

    @Override
	protected Void doInBackground(Void... voids) {

		boasVindas("Olá servidor!");
		return null;
	}

    private void boasVindas(String mensagem) {

		try {

			Socket clientSocket = new Socket(IP, Servidor.PORTA);
			BufferedReader recebidoDoServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			DataOutputStream enviarParaServer = new DataOutputStream(clientSocket.getOutputStream());

			Log.e("Recebido do servidor", recebidoDoServer.readLine());
			enviarParaServer.writeBytes(mensagem + '\n');

			clientSocket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
