package br.com.sharktech.forca.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import br.com.sharktech.forca.R;


public class InicialLogadoActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnEntrarJogo, btnConfiguracoes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial_logado);

        btnEntrarJogo = (Button) findViewById(R.id.btnEntrarjogoTelaInicialLogado);
        btnConfiguracoes = (Button) findViewById(R.id.btnConfiguracoesTelaInicialLogado);

        btnEntrarJogo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnEntrarJogo){
            Intent intent = new Intent(InicialLogadoActivity.this, MenuLateralActivity.class);
            finish();
            startActivity(intent);
        }
        else {

        }
    }
}
