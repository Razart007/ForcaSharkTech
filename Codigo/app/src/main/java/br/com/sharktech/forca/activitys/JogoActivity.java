package br.com.sharktech.forca.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toast;

import br.com.sharktech.forca.R;
import br.com.sharktech.forca.entidades.Palavra;
import br.com.sharktech.forca.tratamentos.TratamentoDeBancoDeDados;
import io.realm.RealmList;

public class JogoActivity extends Activity implements View.OnClickListener {
    private Button btnQJogo, btnWJogo, btnEJogo, btnRJogo, btnTJogo, btnYJogo, btnUJogo, btnIJogo, btnOJogo,
            btnPJogo, btnAJogo, btnSJogo, btnDJogo, btnFJogo, btnGJogo, btnHJogo, btnJJogo, btnKJogo, btnLJogo,
            btnÇJogo, btnZJogo, btnXJogo, btnCJogo, btnVJogo, btnBJogo, btnNJogo, btnMJogo;
    private TextView txvPalavra, txvTempoRestanteJogo, txvCategoriaPalavra;
    private ImageView imgForca;
    private RealmList<Palavra> palavras;
    private Palavra palavra;
    private int pontuacao, acertosPalavra, errosPalavra, acertoTotal, desafios;
    private boolean palavraDescoberta;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        toast = null;

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
        txvTempoRestanteJogo = (TextView) findViewById(R.id.txvTempoRestanteJogo);
        txvCategoriaPalavra = (TextView) findViewById(R.id.txvCategoriaPalavraJogo);
        imgForca = (ImageView) findViewById(R.id.imgForcaJogo);

        Bundle bundle = getIntent().getExtras();

        palavras = TratamentoDeBancoDeDados.buscarPalavrasDesafioList();
        palavra = palavras.get(0);
        //TODO: Remover esse Toast.

        toast = getToast(palavra.getPalavra());
        toast.show();

        txvCategoriaPalavra.setText(TratamentoDeBancoDeDados.buscaDescricaoCategoria(palavra.getIdCategoria()));

        pontuacao = bundle.getInt("pontuacao");
        desafios = bundle.getInt("desafios");

        acertosPalavra = 0;
        errosPalavra = 0;
        acertoTotal = palavra.getPalavra().length();
        txvPalavra.setText("");
        esquemativaPalavra("");

        palavraDescoberta = false;

        Thread tempo = new Thread(new JogoActivity.tempoThread());
        tempo.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        if (v == btnQJogo) {
            adicionaLetraNaPalavra("q");
            btnQJogo.setClickable(false);
            btnQJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnWJogo) {
            adicionaLetraNaPalavra("w");
            btnWJogo.setClickable(false);
            btnWJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnEJogo) {
            adicionaLetraNaPalavra("e");
            btnEJogo.setClickable(false);
            btnEJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnRJogo) {
            adicionaLetraNaPalavra("r");
            btnRJogo.setClickable(false);
            btnRJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnTJogo) {
            adicionaLetraNaPalavra("t");
            btnTJogo.setClickable(false);
            btnTJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnYJogo) {
            adicionaLetraNaPalavra("y");
            btnYJogo.setClickable(false);
            btnYJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnUJogo) {
            adicionaLetraNaPalavra("u");
            btnUJogo.setClickable(false);
            btnUJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnIJogo) {
            adicionaLetraNaPalavra("i");
            btnIJogo.setClickable(false);
            btnIJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnOJogo) {
            adicionaLetraNaPalavra("o");
            btnOJogo.setClickable(false);
            btnOJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnPJogo) {
            adicionaLetraNaPalavra("p");
            btnPJogo.setClickable(false);
            btnPJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnAJogo) {
            adicionaLetraNaPalavra("a");
            btnAJogo.setClickable(false);
            btnAJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnSJogo) {
            adicionaLetraNaPalavra("s");
            btnSJogo.setClickable(false);
            btnSJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnDJogo) {
            adicionaLetraNaPalavra("d");
            btnDJogo.setClickable(false);
            btnDJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnFJogo) {
            adicionaLetraNaPalavra("f");
            btnFJogo.setClickable(false);
            btnFJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnGJogo) {
            adicionaLetraNaPalavra("g");
            btnGJogo.setClickable(false);
            btnGJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnHJogo) {
            adicionaLetraNaPalavra("h");
            btnHJogo.setClickable(false);
            btnHJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnJJogo) {
            adicionaLetraNaPalavra("j");
            btnJJogo.setClickable(false);
            btnJJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnKJogo) {
            adicionaLetraNaPalavra("k");
            btnKJogo.setClickable(false);
            btnKJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnLJogo) {
            adicionaLetraNaPalavra("l");
            btnLJogo.setClickable(false);
            btnLJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnÇJogo) {
            adicionaLetraNaPalavra("ç");
            btnÇJogo.setClickable(false);
            btnÇJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnZJogo) {
            adicionaLetraNaPalavra("z");
            btnZJogo.setClickable(false);
            btnZJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnXJogo) {
            adicionaLetraNaPalavra("x");
            btnXJogo.setClickable(false);
            btnXJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnCJogo) {
            adicionaLetraNaPalavra("c");
            btnCJogo.setClickable(false);
            btnCJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnVJogo) {
            adicionaLetraNaPalavra("v");
            btnVJogo.setClickable(false);
            btnVJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnBJogo) {
            adicionaLetraNaPalavra("b");
            btnBJogo.setClickable(false);
            btnBJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnNJogo) {
            adicionaLetraNaPalavra("n");
            btnNJogo.setClickable(false);
            btnNJogo.setBackgroundColor(R.color.colorGrayBlue);
        } else if (v == btnMJogo) {
            adicionaLetraNaPalavra("m");
            btnMJogo.setClickable(false);
            btnMJogo.setBackgroundColor(R.color.colorGrayBlue);
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
                tempoAux += fim;

                setTextoTextView(tempoAux);
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException ex){
                    System.out.println("Thread não foi realizada - "+ex);
                }
                tempo--;
            }
            if(!palavraDescoberta){
                setToastPassouTempoPalavra();
            }
        }
    }

    private void setTextoTextView(final String tempo){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                txvTempoRestanteJogo.setText("Tempo restante - "+tempo);
            }
        });
    }

    private void setToastPassouTempoPalavra(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                acertouOuErrouPalavra(false);
            }
        });
    }

    private void adicionaLetraNaPalavra(String letra) {
        if(palavra.getPalavra().contains(letra)){
            esquemativaPalavra(letra);
            if(acertosPalavra == acertoTotal){
                acertouOuErrouPalavra(true);
            }
        }
        else {
            errosPalavra++;
            //MudarImagem da forca
            toast = getToast("Errou uma letra");
            toast.show();
            if(errosPalavra == 5){
                acertouOuErrouPalavra(false);
            }
        }
    }

    private void esquemativaPalavra(String letra){
        if(letra.equalsIgnoreCase("")){
            for(int i = 0; i < palavra.getPalavra().length(); i++){
                if(palavra.getPalavra().substring(i, i+1).equalsIgnoreCase(" ")){
                    txvPalavra.setText(txvPalavra.getText()+" ");
                    acertoTotal--;
                }
                else {
                    if(palavra.getPalavra().substring(i, i+1).equalsIgnoreCase("-")){
                        txvPalavra.setText(txvPalavra.getText()+"-");
                        acertoTotal--;
                    }
                    else {
                        txvPalavra.setText(txvPalavra.getText()+"_");
                    }
                }
            }
        }
        else {
            StringBuilder aux = new StringBuilder(txvPalavra.getText().toString());
            for(int i = 0; i < palavra.getPalavra().length(); i++){
                if(palavra.getPalavra().substring(i, i+1).equalsIgnoreCase(letra)){
                    aux.replace(i,i+1,letra);
                    acertosPalavra++;
                }
            }
            txvPalavra.setText(aux.toString());
        }
    }
/*
    private ArrayList<Integer> retornaValoresDoTxView(){
        ArrayList<Integer> retorno = new ArrayList<Integer>();
        for(int i = 0; i < txvPalavra.getText().toString().length(); i++){
            if((!(txvPalavra.getText().toString().substring(i,i+1).equalsIgnoreCase(" ")) || (!(txvPalavra.getText().toString().substring(i,i+1).equalsIgnoreCase("-"))))){
                retorno.add(i);
            }
        }
        return retorno;
    }
*/
    private void acertouOuErrouPalavra(boolean acertou){
        TratamentoDeBancoDeDados.inserePalavraRespondida(palavra);
        TratamentoDeBancoDeDados.removePrimeiraPalavra(palavras);

        if(acertou){
            toast = getToast("Você acertou essa palavra!!!");
            toast.show();

            if(palavras.size() > 0){
                Intent intent = new Intent();
                intent.setClass(JogoActivity.this, JogoActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("pontuacao",pontuacao+1);
                intent.putExtras(bundle);

                finish();
                startActivity(intent);
            }
            else {
                Intent intent = new Intent();

                TratamentoDeBancoDeDados.limparPalavrasDesafio();
                //Nessa parte aqui é para verificar quem acertou mais palavras
                pontuacao++;
                if(pontuacao >= 4){
                    intent.setClass(JogoActivity.this, VenceuDesafioActivity.class);
                }
                else {
                    intent.setClass(JogoActivity.this, PerdeuDesafioActivity.class);
                }

                Bundle bundle = new Bundle();
                bundle.putInt("pontuacao",pontuacao);
                intent.putExtras(bundle);

                onBackPressed();
//                startActivity(intent);
            }
        }
        else {

            toast = getToast("Você não acertou a palavra!!!");
            toast.show();

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

                TratamentoDeBancoDeDados.limparPalavrasDesafio();

                //Nessa parte aqui é para verificar quem acertou mais palavras
                if(pontuacao >= 4){
                    intent.setClass(JogoActivity.this, VenceuDesafioActivity.class);
                }
                else {
                    intent.setClass(JogoActivity.this, PerdeuDesafioActivity.class);
                }

                Bundle bundle = new Bundle();
                bundle.putInt("pontuacao",pontuacao);
                intent.putExtras(bundle);

                onBackPressed();
//                startActivity(intent);
            }
        }
        palavraDescoberta = true;
    }

    private Toast getToast(String message){

        if(toast == null){
            return Toast.makeText(this, message, Toast.LENGTH_SHORT);
        }

        if(toast.getView().isShown()){
            toast.cancel();
        }
        return Toast.makeText(this, message, Toast.LENGTH_SHORT);
    }
}
