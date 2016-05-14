package br.com.sharktech.forca.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import br.com.sharktech.forca.R;
import br.com.sharktech.forca.entidades.Palavra;
import br.com.sharktech.forca.tratamentos.TratamentoDeBancoDeDados;

public class JogoActivity extends Activity implements View.OnClickListener {
    private Button btnQJogo, btnWJogo, btnEJogo, btnRJogo, btnTJogo, btnYJogo, btnUJogo, btnIJogo, btnOJogo,
            btnPJogo, btnAJogo, btnSJogo, btnDJogo, btnFJogo, btnGJogo, btnHJogo, btnJJogo, btnKJogo, btnLJogo,
            btnÇJogo, btnZJogo, btnXJogo, btnCJogo, btnVJogo, btnBJogo, btnNJogo, btnMJogo;
    private TextView txvPalavra;
    private ImageView imgForca;
    private String palavra;
    private int pontuacao, acertosPalavra, errosPalavra, acertoTotal;
    private ArrayList<Palavra> palavras;
    private boolean palavraDescoberta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        btnQJogo = (Button) findViewById(R.id.btnJogoQ);
        btnWJogo = (Button) findViewById(R.id.btnJogoW);
        btnEJogo = (Button) findViewById(R.id.btnJogoE);
        btnRJogo = (Button) findViewById(R.id.btnJogoR);
        btnTJogo = (Button) findViewById(R.id.btnJogoT);
        btnYJogo = (Button) findViewById(R.id.btnJogoY);
        btnUJogo = (Button) findViewById(R.id.btnJogoU);
        btnIJogo = (Button) findViewById(R.id.btnJogoI);
        btnOJogo = (Button) findViewById(R.id.btnJogoO);
        btnPJogo = (Button) findViewById(R.id.btnJogoP);
        btnAJogo = (Button) findViewById(R.id.btnJogoA);
        btnSJogo = (Button) findViewById(R.id.btnJogoS);
        btnDJogo = (Button) findViewById(R.id.btnJogoD);
        btnFJogo = (Button) findViewById(R.id.btnJogoF);
        btnGJogo = (Button) findViewById(R.id.btnJogoG);
        btnHJogo = (Button) findViewById(R.id.btnJogoH);
        btnJJogo = (Button) findViewById(R.id.btnJogoJ);
        btnKJogo = (Button) findViewById(R.id.btnJogoK);
        btnLJogo = (Button) findViewById(R.id.btnJogoL);
        btnÇJogo = (Button) findViewById(R.id.btnJogoÇ);
        btnZJogo = (Button) findViewById(R.id.btnJogoZ);
        btnXJogo = (Button) findViewById(R.id.btnJogoX);
        btnCJogo = (Button) findViewById(R.id.btnJogoC);
        btnVJogo = (Button) findViewById(R.id.btnJogoV);
        btnBJogo = (Button) findViewById(R.id.btnJogoB);
        btnNJogo = (Button) findViewById(R.id.btnJogoN);
        btnMJogo = (Button) findViewById(R.id.btnJogoM);

        btnQJogo.setOnClickListener(this);
        btnWJogo.setOnClickListener(this);
        btnEJogo.setOnClickListener(this);
        btnRJogo.setOnClickListener(this);
        btnTJogo.setOnClickListener(this);
        btnYJogo.setOnClickListener(this);
        btnUJogo.setOnClickListener(this);
        btnIJogo.setOnClickListener(this);
        btnOJogo.setOnClickListener(this);
        btnPJogo.setOnClickListener(this);
        btnAJogo.setOnClickListener(this);
        btnSJogo.setOnClickListener(this);
        btnDJogo.setOnClickListener(this);
        btnFJogo.setOnClickListener(this);
        btnGJogo.setOnClickListener(this);
        btnHJogo.setOnClickListener(this);
        btnJJogo.setOnClickListener(this);
        btnKJogo.setOnClickListener(this);
        btnLJogo.setOnClickListener(this);
        btnÇJogo.setOnClickListener(this);
        btnZJogo.setOnClickListener(this);
        btnXJogo.setOnClickListener(this);
        btnCJogo.setOnClickListener(this);
        btnVJogo.setOnClickListener(this);
        btnBJogo.setOnClickListener(this);
        btnNJogo.setOnClickListener(this);
        btnMJogo.setOnClickListener(this);

        txvPalavra = (TextView) findViewById(R.id.txvPalavraJogo);
        imgForca = (ImageView) findViewById(R.id.imgForcaJogo);

        Bundle bundle = getIntent().getBundleExtra("bundle");

        palavras = (ArrayList<Palavra>) bundle.getSerializable("palavras");
        palavra = palavras.get(0).getPalavra();
        pontuacao = bundle.getInt("pontuacao");

        acertosPalavra = 0;
        errosPalavra = 0;

        acertoTotal = palavra.length();

        txvPalavra.setText("");
        esquemativaPalavra("");

        palavraDescoberta = false;
    }

    @Override
    public void onClick(View v) {
        if (v == btnQJogo) {
            adicionaLetraNaPalavra("Q");
            btnQJogo.setEnabled(false);
        } else if (v == btnWJogo) {
            adicionaLetraNaPalavra("W");
            btnWJogo.setEnabled(false);
        } else if (v == btnEJogo) {
            adicionaLetraNaPalavra("E");
            btnEJogo.setEnabled(false);
        } else if (v == btnRJogo) {
            adicionaLetraNaPalavra("R");
            btnRJogo.setEnabled(false);
        } else if (v == btnTJogo) {
            adicionaLetraNaPalavra("T");
            btnTJogo.setEnabled(false);
        } else if (v == btnYJogo) {
            adicionaLetraNaPalavra("Y");
            btnYJogo.setEnabled(false);
        } else if (v == btnUJogo) {
            adicionaLetraNaPalavra("U");
            btnUJogo.setEnabled(false);
        } else if (v == btnIJogo) {
            adicionaLetraNaPalavra("I");
            btnIJogo.setEnabled(false);
        } else if (v == btnOJogo) {
            adicionaLetraNaPalavra("O");
            btnOJogo.setEnabled(false);
        } else if (v == btnPJogo) {
            adicionaLetraNaPalavra("P");
            btnPJogo.setEnabled(false);
        } else if (v == btnAJogo) {
            adicionaLetraNaPalavra("A");
            btnAJogo.setEnabled(false);
        } else if (v == btnSJogo) {
            adicionaLetraNaPalavra("S");
            btnSJogo.setEnabled(false);
        } else if (v == btnDJogo) {
            adicionaLetraNaPalavra("D");
            btnDJogo.setEnabled(false);
        } else if (v == btnFJogo) {
            adicionaLetraNaPalavra("F");
            btnFJogo.setEnabled(false);
        } else if (v == btnGJogo) {
            adicionaLetraNaPalavra("G");
            btnGJogo.setEnabled(false);
        } else if (v == btnHJogo) {
            adicionaLetraNaPalavra("H");
            btnHJogo.setEnabled(false);
        } else if (v == btnJJogo) {
            adicionaLetraNaPalavra("J");
            btnJJogo.setEnabled(false);
        } else if (v == btnKJogo) {
            adicionaLetraNaPalavra("K");
            btnKJogo.setEnabled(false);
        } else if (v == btnLJogo) {
            adicionaLetraNaPalavra("L");
            btnLJogo.setEnabled(false);
        } else if (v == btnÇJogo) {
            adicionaLetraNaPalavra("Ç");
            btnÇJogo.setEnabled(false);
        } else if (v == btnZJogo) {
            adicionaLetraNaPalavra("Z");
            btnZJogo.setEnabled(false);
        } else if (v == btnXJogo) {
            adicionaLetraNaPalavra("X");
            btnXJogo.setEnabled(false);
        } else if (v == btnCJogo) {
            adicionaLetraNaPalavra("C");
            btnCJogo.setEnabled(false);
        } else if (v == btnVJogo) {
            adicionaLetraNaPalavra("V");
            btnVJogo.setEnabled(false);
        } else if (v == btnBJogo) {
            adicionaLetraNaPalavra("B");
            btnBJogo.setEnabled(false);
        } else if (v == btnNJogo) {
            adicionaLetraNaPalavra("N");
            btnNJogo.setEnabled(false);
        } else if (v == btnMJogo) {
            adicionaLetraNaPalavra("M");
            btnMJogo.setEnabled(false);
        }
    }

    private class tempoThread implements Runnable {
        @Override
        public void run() {
            int tempo = 80;
            int inicio;
            int fim;
            String tempoAux;
            while(tempo > 0 && (!palavraDescoberta)){
                tempoAux = "";
                inicio = (tempo / 60);
                fim = (tempo % 60);
                if(inicio < 10){
                    tempoAux += "0";
                }
                tempoAux += inicio+":";
                if(fim < 10){
                    tempoAux += "0";
                }
                tempo += fim;

                txvPalavra.setText(tempoAux);
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException ex){
                    System.out.println("Thread não foi realizada - "+ex);
                }
                tempo--;
            }
            if(!palavraDescoberta){
                Toast.makeText(getApplicationContext(), "O tempo acabou!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void adicionaLetraNaPalavra(String letra) {
        if(palavra.contains(letra)){
            acertosPalavra++;
            esquemativaPalavra(letra);

            if(acertosPalavra == acertoTotal - 1){
                TratamentoDeBancoDeDados.inserePalavraRespondida(palavras.get(0));
                palavras.remove(0);
                acertouOuErrouPalavra(true);
            }
        }
        else {
            errosPalavra++;
            //MudarImagem da forca
            if(errosPalavra == 5){
                TratamentoDeBancoDeDados.inserePalavraRespondida(palavras.get(0));
                palavras.remove(0);
                acertouOuErrouPalavra(false);
            }
        }
    }

    private void esquemativaPalavra(String letra){
        if(letra.equalsIgnoreCase("")){
            for(int i = 0; i < palavra.length(); i++){
                if(palavra.substring(i, i+1).equalsIgnoreCase(" ")){
                    txvPalavra.setText(txvPalavra.getText()+" ");
                    acertoTotal--;
                }
                else {
                    if(palavra.substring(i, i+1).equalsIgnoreCase("-")){
                        txvPalavra.setText(txvPalavra.getText()+"-");
                        acertoTotal--;
                    }
                    else {
                        txvPalavra.setText(txvPalavra.getText()+"_ ");
                    }
                }

            }
        }
        else {
            char[] letraAux = letra.toCharArray();
            StringBuilder aux;
            for(int i = 0; i < palavra.length(); i++){
                if(palavra.substring(i, i+1).equalsIgnoreCase(letra)){
                    aux = new StringBuilder(txvPalavra.getText().toString());
                    aux.setCharAt(i,letraAux[0]);
                    txvPalavra.setText(aux.toString());
                }
            }
        }
    }

    private void acertouOuErrouPalavra(boolean acertou){
        if(acertou){
            Toast.makeText(getApplicationContext(), "Você acertou essa palavra!!!", Toast.LENGTH_SHORT).show();

            if(palavras.size() > 0){
                Intent intent = new Intent();
                intent.setClass(JogoActivity.this, JogoActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("palavras",palavras);
                bundle.putInt("pontuacao",pontuacao+1);
                intent.putExtras(bundle);

                finish();
                startActivity(intent);
            }
            else {
                Intent intent = new Intent();

                //Nessa parte aqui é para verificar quem acertou mais palavras
                if(pontuacao >= 5){
                    intent.setClass(JogoActivity.this, VenceuDesafioActivity.class);
                }
                else {
                    intent.setClass(JogoActivity.this, PerdeuDesafioActivity.class);
                }

                Bundle bundle = new Bundle();
                bundle.putInt("pontuacao",pontuacao+1);
                intent.putExtras(bundle);

                finish();
                startActivity(intent);
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Você não acertou a palavra!!!", Toast.LENGTH_SHORT).show();
            if(palavras.size() > 0){
                Intent intent = new Intent();
                intent.setClass(JogoActivity.this, JogoActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("pontuacao",pontuacao);
                intent.putExtras(bundle);

                finish();
                startActivity(intent);
            }
            else{
                Intent intent = new Intent();

                //Nessa parte aqui é para verificar quem acertou mais palavras
                if(pontuacao >= 5){
                    intent.setClass(JogoActivity.this, VenceuDesafioActivity.class);
                }
                else {
                    intent.setClass(JogoActivity.this, PerdeuDesafioActivity.class);
                }

                Bundle bundle = new Bundle();
                bundle.putInt("pontuacao",pontuacao);
                intent.putExtras(bundle);

                finish();
                startActivity(intent);
            }
        }
    }
}
