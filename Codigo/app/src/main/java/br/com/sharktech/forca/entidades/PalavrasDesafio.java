package br.com.sharktech.forca.entidades;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Rafael on 14/05/2016.
 */
public class PalavrasDesafio extends RealmObject{
    @PrimaryKey
        private int id;
    private RealmList<Palavra> palavrasDesafio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RealmList<Palavra> getPalavrasDesafio() {
        return palavrasDesafio;
    }

    public void setPalavrasDesafio(RealmList<Palavra> palavrasDesafio) {
        this.palavrasDesafio = palavrasDesafio;
    }
}
