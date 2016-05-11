package br.com.sharktech.forca.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.sharktech.forca.R;
import br.com.sharktech.forca.tratamentos.TratamentoDeBancoDeDados;

public class InicialActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtNome;
    private Button btnEntrarJogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);


        edtNome = (EditText) findViewById(R.id.etNomeTelaInicial);
        btnEntrarJogo = (Button) findViewById(R.id.btEntrarJogoTelaInicial);

        //edtNome.setOnClickListener(this);
        btnEntrarJogo.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == btnEntrarJogo){
            finish();
            TratamentoDeBancoDeDados.criarOuAtualizarUsuario(edtNome.getText().toString(),"",true);
            Intent intent = new Intent(InicialActivity.this, DesafioActivitySD.class);
            startActivity(intent);
        }
        else {
               //edtNome.setFocusable(true);
        }
    }
}
