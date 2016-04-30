package br.com.sharktech.forca;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;
import br.com.sharktech.forca.bancodados.BancoDeDados;

public class SplashActivity extends Activity {
    private BancoDeDados bancoDeDados;
    private SQLiteDatabase conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        try {
            bancoDeDados = new BancoDeDados(this);
            conn = bancoDeDados.getReadableDatabase();

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Conexão criada com sucesso!");
            alert.setNeutralButton("OK",null);
            alert.show();

        } catch (SQLException ex){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("Erro ao conetar com o banco: "+ex.getMessage());
            alert.setNeutralButton("OK",null);
            alert.show();
        }

        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                finish();

                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, RankingActivity.class);
                startActivity(intent);
            }
        }, 6000);
    }
}
