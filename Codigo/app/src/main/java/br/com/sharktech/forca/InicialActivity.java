package br.com.sharktech.forca;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class InicialActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtNome;
    private Button btnEntrarJogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);


        edtNome = (EditText) findViewById(R.id.etNomeTelaInicial);
        btnEntrarJogo = (Button) findViewById(R.id.btEntrarJogoTelaInicial);

        btnEntrarJogo.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == btnEntrarJogo){
            finish();

            Intent intent = new Intent(InicialActivity.this, CategoriaActivity.class);
            startActivity(intent);

        }
    }
}
