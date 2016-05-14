package br.com.sharktech.forca.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import br.com.sharktech.forca.R;

public class PerdeuDesafioActivity extends Activity implements View.OnClickListener{
    Button btnIniciarOutroDesafio;
    TextView txvPontuacao;
    int pontuacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdeu_desafio);


        btnIniciarOutroDesafio = (Button) findViewById(R.id.btnIniciaroutroDesafioPerdeuDesafio);
        txvPontuacao = (TextView) findViewById(R.id.txvPontuacaoPerdeuDesafio);

        Bundle bundle = getIntent().getBundleExtra("bundle");
        pontuacao = bundle.getInt("pontuacao");

        txvPontuacao.setText("Sua pontuação: "+pontuacao);

        btnIniciarOutroDesafio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(PerdeuDesafioActivity.this, DesafioActivitySD.class);

        finish();
        startActivity(intent);
    }
}
