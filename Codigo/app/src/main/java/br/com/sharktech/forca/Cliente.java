package br.com.sharktech.forca;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Cliente implements Serializable{

    private static final String IP = "192.168.0.102";
    private static final int PORTA = 6789;

    private Context context;
    private String ip, ipDesafiante;
    private int cod, codDesafiante;
    private boolean server = false;
    private BufferedReader receptor;
    private DataOutputStream emissor;
    private Socket conexao;
    private ArrayList<CharSequence> palavras;
    private boolean aguardar = true;

    public Cliente(Context context){
        this.context = context;
        new ConexaoServidor().execute();
    }

    public boolean isAguardar(){
        return aguardar;
    }

    public ArrayList<CharSequence> getPalavras() {
        return palavras;
    }

    public int getCod() {
        return cod;
    }

    private void shakHand() throws IOException {

        codDesafiante = cod = -1;
        ipDesafiante = "-";
        server = false;
        palavras = null;
        conexao = new Socket(IP, PORTA);
        receptor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        emissor = new DataOutputStream(conexao.getOutputStream());
    }

    private void boasVindas() throws IOException {

        WifiManager wm = (WifiManager) context.getSystemService(context.WIFI_SERVICE);
        ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());

        emissor.writeBytes(ip + "\n");

        cod = Integer.parseInt(receptor.readLine());
        Log.e("Mensagem do servidor", cod + "");
    }

    private void aguardandoDesafiante() throws IOException {
        ArrayList<CharSequence> palavrasEnviadas = new ArrayList<>();

        ipDesafiante = receptor.readLine();
        codDesafiante = Integer.parseInt(receptor.readLine());
        server = Boolean.parseBoolean(receptor.readLine());
        int totalPalavras = Integer.parseInt(receptor.readLine());

        for(int i = 0; i < totalPalavras; i++){
            String palavra = receptor.readLine();
            palavrasEnviadas.add(palavra);
            Log.e("#" + (i + 1), palavra);
        }

        palavras = palavrasEnviadas;
        Log.e("Local >", "[Cod: " + cod + "][IP: " + ip + "][Server: " + server + "]");
        Log.e("Desafiante > ", "[Cod: " + codDesafiante + "][IP: " + ipDesafiante + "] ");
    }

    private void iniciarJogo(){

        int porta = -1;

        try {

            if(server){

                porta = PORTA + cod;
                conexao = new ServerSocket(porta).accept();

                emissor = new DataOutputStream(conexao.getOutputStream());
                receptor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

                emissor.writeBytes(cod + " realizou desafio!\n");
                Toast.makeText(context, receptor.readLine(), Toast.LENGTH_SHORT).show();

            } else{

                porta = PORTA + codDesafiante;

                Socket conexaoDesafiante = new Socket(ipDesafiante, porta);
                DataOutputStream emissorDesafiante = new DataOutputStream(conexaoDesafiante.getOutputStream());
                BufferedReader receptorDesafiante = new BufferedReader(new InputStreamReader(conexaoDesafiante.getInputStream()));

                emissorDesafiante.writeBytes(cod + " aceitou o desafio \n");
                Toast.makeText(context, receptorDesafiante.readLine(), Toast.LENGTH_SHORT).show();
            }

            while(true){}

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ConexaoServidor extends AsyncTask<Void, Void, Boolean>{

        @Override
        protected Boolean doInBackground(Void... voids) {

            try {
                shakHand();
                boasVindas();
                aguardandoDesafiante();
//                iniciarJogo();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return aguardar = false;
        }
    }
}