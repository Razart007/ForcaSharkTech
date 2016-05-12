package br.com.sharktech.forca.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;
import br.com.sharktech.forca.R;
import br.com.sharktech.forca.entidades.Usuario;
import br.com.sharktech.forca.tratamentos.TratamentoDeBancoDeDados;


public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TratamentoDeBancoDeDados.criarBanco(this);

        //efetuar o update das palavras do servidor caso haja alguma que não existe no telefone

        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                Intent intent = new Intent();
                if(TratamentoDeBancoDeDados.buscarUsuario().getNome().equalsIgnoreCase("")){
                    intent.setClass(SplashActivity.this, InicialActivity.class);
                }
                else {
                    intent.setClass(SplashActivity.this, InicialLogadoActivity.class);
                }
                finish();
                startActivity(intent);
            }
        }, 6000);
    }
}
