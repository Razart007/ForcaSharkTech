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
    private String nome, email;
    private int pontuacaoGeral;
    private int pontuacaoDiaria;
    private int pontuacaoDesafios;
    private RealmList<Palavra> palavrasEnviadas;
    private RealmList<Usuario> amigosUsuario;
    private RealmList<Palavra> palavrasRespondidas;

    public RealmList<Palavra> getPalavrasRespondidas() {
        return palavrasRespondidas;
    }

    public void setPalavrasRespondidas(RealmList<Palavra> palavrasRespondidas) {
        this.palavrasRespondidas = palavrasRespondidas;
    }

    public RealmList<Usuario> getAmigosUsuario() {
        return amigosUsuario;
    }

    public void setAmigosUsuario(RealmList<Usuario> amigosUsuario) {
        this.amigosUsuario = amigosUsuario;
    }

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

    public RealmList<Palavra> getPalavrasEnviadas() {
        return palavrasEnviadas;
    }

    public void setPalavrasEnviadas(RealmList<Palavra> palavrasEnviadas) {
        this.palavrasEnviadas = palavrasEnviadas;
    }

    public int getPontuacaoDesafios() {
        return pontuacaoDesafios;
    }

    public void setPontuacaoDesafios(int pontuacaoDesafios) {
        this.pontuacaoDesafios = pontuacaoDesafios;
    }

}
