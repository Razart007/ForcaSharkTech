package br.com.sharktech.forca.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

import br.com.sharktech.forca.Cliente;
import br.com.sharktech.forca.R;
import br.com.sharktech.forca.tratamentos.TratamentoDeBancoDeDados;

public class DesafioActivitySD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio_sd);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                Cliente c = new Cliente(DesafioActivitySD.this);
                while(c.isAguardar()){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Intent intent = new Intent();
                intent.setClass(DesafioActivitySD.this, JogoActivity.class);

                TratamentoDeBancoDeDados.buscaPalarasAleatoriasNaoRespondida();
                //Pedir um novo desafio ao servidor e esperar o desafiante, quando encontrar o servidor o mesmo envia as palavras
                //para os dois clientes e o ip do outro, assim fecha a conexão, e a comunicação fica entre os dois clientes
                Bundle bundle = new Bundle();
                bundle.putInt("pontuacao",0);
                bundle.putInt("desafios",5);
                intent.putExtras(bundle);
                TratamentoDeBancoDeDados.inserePalavrasDoServidor(c.getPalavras());

                startActivityForResult(intent, 1);
            }
        }, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1){

        }
    }
}
