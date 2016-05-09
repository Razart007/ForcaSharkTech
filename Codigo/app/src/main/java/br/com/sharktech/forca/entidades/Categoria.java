package br.com.sharktech.forca.entidades;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Rafael on 09/05/2016.
 */
public class Categoria extends RealmObject{
    @PrimaryKey
        private int id;
    private String descricao;
    private RealmList<Palavra> palavras;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RealmList<Palavra> getPalavras() {
        return palavras;
    }

    public void setPalavras(RealmList<Palavra> palavras) {
        this.palavras = palavras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
