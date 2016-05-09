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
import br.com.sharktech.forca.bancodados.RepositorioForca;

public class SplashActivity extends Activity {
    private BancoDeDados bancoDeDados;
    private SQLiteDatabase conn;
    private RepositorioForca model;
    public static int ID_USUARIO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        try {
            bancoDeDados = new BancoDeDados(this);
            conn = bancoDeDados.getReadableDatabase();
            model = new  RepositorioForca(conn);
            ID_USUARIO = model.getIdBanco();

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
                if(ID_USUARIO == -1){
                    intent.setClass(SplashActivity.this, AmigosActivity.class);
                    startActivity(intent);
                }
                else {
                    intent.setClass(SplashActivity.this, InicialLogadoActivity.class);
                    startActivity(intent);
                }
            }
        }, 6000);
    }
}
