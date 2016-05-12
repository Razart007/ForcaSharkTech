package br.com.sharktech.forca.tratamentos;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import br.com.sharktech.forca.ValuesConstantes;
import br.com.sharktech.forca.entidades.*;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.Sort;

public class TratamentoDeBancoDeDados {

    private TratamentoDeBancoDeDados (){ }

    //Útil para o projeto de SD
    public static void criarBanco(Context context){
        RealmConfiguration configuration = new RealmConfiguration.Builder(context).build();
        Realm.setDefaultConfiguration(configuration);
    }

    //Útil para o projeto de SD
    public static Usuario buscarUsuario() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Usuario usuario = (Usuario) realm.where(Usuario.class).findFirst();
        if(usuario == null){
            usuario = new Usuario();
            usuario.setNome("");
            usuario.setEmail("");
        }
        return usuario;
    }

    //Útil para o projeto de SD
    public static void criarOuAtualizarUsuario(String nome, String email, boolean criarUsuario){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Usuario usuario;
        if(criarUsuario){
            usuario = new Usuario();
            RealmList<Palavra> palavrasEnviadas = new RealmList<Palavra>();
            RealmList<Usuario> amigosUsuario = new RealmList<Usuario>();
            usuario.setPontuacaoDiaria(0);
            usuario.setPontuacaoGeral(0);
            usuario.setPalavrasEnviadas(palavrasEnviadas);
            usuario.setAmigosUsuario(amigosUsuario);
        }
        else {
            usuario = buscarUsuario();
        }

        usuario.setNome(nome);
        usuario.setEmail(email);

        realm.copyToRealmOrUpdate(usuario);
        realm.commitTransaction();
    }

    //Útil para o projeto de SD
    public static boolean verificarUsuarioRespondeu(String palavra){
        Usuario usuario = buscarUsuario();
        for(int i = 0; i < usuario.getPalavrasRespondidas().size(); i++){
            if(usuario.getPalavrasRespondidas().get(i).getPalavra().equalsIgnoreCase(palavra)){
                return true;
            }
        }
        return false;
    }

    //Útil para o projeto de SD
    public static void inserePalavra(Palavra palavra){

    }

    //Usado apenas para o projeto de SD
    public static List<Palavra> buscaPalarasAleatoriasNaoRespondida(){


        return null;
    }

    //Não é útil para o projeto de SD apenas para depois para implementa-lo
    public static List<Usuario> buscarAmigos(int id){
        Usuario usuario = buscarUsuario();
        return usuario.getAmigosUsuario();
    }

    //Não é útil para o projeto de SD apenas para depois para implementa-lo
    public static List<Categoria> buscarCategorias(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults results;

        results = realm.where(Categoria.class).findAll();

        return  results;
    }

    //Não é útil para o projeto de SD apenas para depois e implementa-lo e jogá-lo na googlePlay
    public static void inserirPalavra(String descricao, int idUsuarioCriador, int idCategoria){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Palavra palavra = new Palavra();
        palavra.setPontuacaoGeral(0);
        palavra.setPontuacaoDiaria(0);
        palavra.setIdCategoria(idCategoria);
        palavra.setIdUsuarioCriador(idUsuarioCriador);
        palavra.setPalavra(descricao);

        realm.copyToRealm(palavra);
        realm.commitTransaction();
    }

    //Não é útil para o projeto de SD apenas para depois e implementa-lo e jogá-lo na googlePlay
    public static List<Palavra> buscarPalavrasMaisDificeisGeralOuDiario(boolean geral){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Palavra> results;
        List<Palavra> palavrasMaisDificeis = new ArrayList<Palavra>();
        int palavraMaisDificil;

        if(geral){
            palavraMaisDificil = (int) realm.where(Palavra.class).max(ValuesConstantes.PONTUACAO_GERAL_GENERICO);
        }
        else {
            palavraMaisDificil = (int) realm.where(Palavra.class).max(ValuesConstantes.PONTUACAO_DIARIA_GENERICO);
        }

        if(palavraMaisDificil > 0){
            results = realm.where(Palavra.class).lessThan(ValuesConstantes.PONTUACAO_GERAL_GENERICO,palavraMaisDificil).findAllSorted(ValuesConstantes.PONTUACAO_GERAL_GENERICO, Sort.DESCENDING);
            int contador = 0;
            for (int i = 0; i < results.size() && contador < 15; i++){
                if(!verificarUsuarioRespondeu(results.get(i).getPalavra())){
                    palavrasMaisDificeis.add((Palavra)results.get(i));
                    contador++;
                }
            }
        }
        return palavrasMaisDificeis;
    }
}
