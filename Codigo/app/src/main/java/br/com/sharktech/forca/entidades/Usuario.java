package br.com.sharktech.forca.entidades;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Rafael on 09/05/2016.
 */
public class Usuario extends RealmObject{
    @PrimaryKey
    private int id;
    private String nome, email, pontuacaoGeral, pontuacaoDiaria;
    private RealmList<Palavra> palavrasEnviadas;

    public RealmList<Usuario> getAmigosUsuario() {
        return amigosUsuario;
    }

    public void setAmigosUsuario(RealmList<Usuario> amigosUsuario) {
        this.amigosUsuario = amigosUsuario;
    }

    private RealmList<Usuario> amigosUsuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPontuacaoGeral() {
        return pontuacaoGeral;
    }

    public void setPontuacaoGeral(String pontuacaoGeral) {
        this.pontuacaoGeral = pontuacaoGeral;
    }

    public String getPontuacaoDiaria() {
        return pontuacaoDiaria;
    }

    public void setPontuacaoDiaria(String pontuacaoDiaria) {
        this.pontuacaoDiaria = pontuacaoDiaria;
    }

    public RealmList<Palavra> getPalavrasEnviadas() {
        return palavrasEnviadas;
    }

    public void setPalavrasEnviadas(RealmList<Palavra> palavrasEnviadas) {
        this.palavrasEnviadas = palavrasEnviadas;
    }
}
