package br.com.sharktech.forca.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.sharktech.forca.R;
import br.com.sharktech.forca.tratamentos.TratamentoDeBancoDeDados;

public class EmpatouActivity extends Activity implements View.OnClickListener{
    Button btnIniciarOutroDesafio;
    TextView txvPontuacao;
    int pontuacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empatou);

        btnIniciarOutroDesafio = (Button) findViewById(R.id.btnIniciaroutroDesafioEmpatouDesafio);
        txvPontuacao = (TextView) findViewById(R.id.txvPontuacaoEmpatouDesafio);

        Bundle bundle = getIntent().getExtras();
        pontuacao = bundle.getInt("pontuacao");

        txvPontuacao.setText("Sua pontuação: "+pontuacao);

        btnIniciarOutroDesafio.setOnClickListener(this);

        TratamentoDeBancoDeDados.aumentaNumerosDesafio();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(EmpatouActivity.this, DesafioActivitySD.class);

        finish();
        startActivity(intent);
    }



}
