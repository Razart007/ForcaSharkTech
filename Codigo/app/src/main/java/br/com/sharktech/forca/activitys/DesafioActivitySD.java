package br.com.sharktech.forca.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import br.com.sharktech.forca.R;

public class DesafioActivitySD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafio_sd);

        //Inserir a parte de rede aqui
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.setClass(DesafioActivitySD.this, JogoActivity.class);

                //intent.setExtrasClassLoader();

                finish();
                startActivity(intent);
            }
        }, 6000);


    }
}
