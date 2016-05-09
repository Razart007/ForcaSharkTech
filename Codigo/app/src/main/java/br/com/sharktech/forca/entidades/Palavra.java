package br.com.sharktech.forca.entidades;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Rafael on 09/05/2016.
 */

public class Palavra extends RealmObject{
    @PrimaryKey
        private int id;
    private int pontuacaoGeral, pontuacaoDiaria, idCategoria, idUsuarioCriador;
    private String palavra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPontuacaoGeral() {
        return pontuacaoGeral;
    }

    public void setPontuacaoGeral(int pontuacaoGeral) {
        this.pontuacaoGeral = pontuacaoGeral;
    }

    public int getPontuacaoDiaria() {
        return pontuacaoDiaria;
    }

    public void setPontuacaoDiaria(int pontuacaoDiaria) {
        this.pontuacaoDiaria = pontuacaoDiaria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdUsuarioCriador() {
        return idUsuarioCriador;
    }

    public void setIdUsuarioCriador(int idUsuarioCriador) {
        this.idUsuarioCriador = idUsuarioCriador;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }
}
