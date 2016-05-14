package br.com.sharktech.forca.tratamentos;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
            usuario.setPontuacaoDesafios(0);
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

    public static void atualizaUsuario(Usuario usuario){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

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
    public static Palavra inserePalavra(int idCategoria, int idUsuarioCriador, String palavraDescricao){
        if(!verficaPalavraExisteServidor(palavraDescricao)){
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();

            Palavra palavra = new Palavra();
            palavra.setIdCategoria(idCategoria);
            palavra.setIdUsuarioCriador(idUsuarioCriador);
            palavra.setPalavra(palavraDescricao);
            palavra.setPontuacaoDiaria(0);
            palavra.setPontuacaoGeral(0);
            palavra.setId(getNextKeyPalavra());

            realm.copyToRealm(palavra);
            realm.commitTransaction();

            return palavra;
        }
        else {
            Realm realm = Realm.getDefaultInstance();

            Palavra palavra = (Palavra) realm.where(Palavra.class).equalTo(ValuesConstantes.PALAVRA,palavraDescricao).findFirst();

            return palavra;
        }
    }

    //Útil para o projeto de SD
    public static void insereCategoria(String descricao){
        if(!verficaCategoriaExisteServidor(descricao)){
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();

            Categoria categoria = new Categoria();

            categoria.setDescricao(descricao);
            categoria.setPalavras(new RealmList<Palavra>());
            categoria.setId(getNextKeyCategoria());

            realm.copyToRealm(categoria);
            realm.commitTransaction();
        }
    }

    private static int getNextKeyCategoria()
    {
        Realm realm = Realm.getDefaultInstance();
        RealmResults results = realm.where(Categoria.class).findAll();

        if(results.size() > 0){
            return realm.where(Categoria.class).max(ValuesConstantes.ID_GENERICO).intValue() + 1;
        }
        else {
         return 0;
        }
    }

    private static int getNextKeyPalavra()
    {
        Realm realm = Realm.getDefaultInstance();
        RealmResults results = realm.where(Palavra.class).findAll();

        if(results.size() > 0){
            return realm.where(Palavra.class).max(ValuesConstantes.ID_GENERICO).intValue() + 1;
        }
        else {
            return 0;
        }
    }

    private static void inserePalavraNaCategoria(Palavra palavra, int idCategoria){
        Realm realm = Realm.getDefaultInstance();
        Categoria categoria = (Categoria) realm.where(Categoria.class).equalTo(ValuesConstantes.ID_GENERICO,idCategoria).findFirst();

        if(categoria != null){
            RealmList<Palavra> palavras = categoria.getPalavras();
            palavras.add(palavra);
            categoria.setPalavras(palavras);

            realm.beginTransaction();
            realm.copyToRealmOrUpdate(categoria);
            realm.commitTransaction();
        }
    }

    //Útil para o projeto de SD
    public static void inserePalavrasDoServidor(){
        ArrayList<Palavra> palavrasArray = new ArrayList<Palavra>();
        ArrayList<Categoria> categoriaArray = new ArrayList<Categoria>();

        Log.d("Mensagem","Entrou no étodo de inserir da classe de tratamento");

        insereCategoria("Alimentos");
        insereCategoria("Animais");
        insereCategoria("Eletrônicos");

        Log.d("Mensagem","Criou as categorias");

        int idAlimentos = buscaCategoriaID("Alimentos");

        Log.d("Mensagem","Pegou o valor do idAlimento");
        //Palavra palavra1 =


        inserePalavra(idAlimentos, -1,"rocambole");
        //inserePalavraNaCategoria(palavra1, idAlimentos);

        //Palavra palavra2 =
        inserePalavra(idAlimentos, -1,"estrogonofe");
        //inserePalavraNaCategoria(palavra2, idAlimentos);

        //Palavra palavra3 =
        inserePalavra(idAlimentos, -1,"feijão tropeiro");
        //inserePalavraNaCategoria(palavra3, idAlimentos);

        //Palavra palavra4 =
        inserePalavra(idAlimentos, -1,"mousse de brigadeiro");
        //inserePalavraNaCategoria(palavra4,idAlimentos);

        //Palavra palavra5 =
        inserePalavra(idAlimentos, -1,"frango grelhado");
        //inserePalavraNaCategoria(palavra5, idAlimentos);

        int idAnimais = buscaCategoriaID("Animais");
/*
        palavra1 = new Palavra();
        palavra2 = new Palavra();
        palavra3 = new Palavra();
        palavra4 = new Palavra();
        palavra5 = new Palavra();
*/
        //palavra1 =
        inserePalavra(idAnimais, -1,"ouriço do mar");
        //inserePalavraNaCategoria(palavra1, idAnimais);

        //palavra2 =
        inserePalavra(idAnimais, -1,"peixe palhaço");
        //inserePalavraNaCategoria(palavra2, idAnimais);

        //palavra3 =
        inserePalavra(idAnimais, -1,"lemure");
        //inserePalavraNaCategoria(palavra3,idAnimais);

        //palavra4 =
        inserePalavra(idAnimais, -1,"ornitorrinco");
        //inserePalavraNaCategoria(palavra4, idAnimais);

        //palavra5 =
        inserePalavra(idAnimais, -1,"caracal");
        //inserePalavraNaCategoria(palavra5,idAnimais);

        int idEletronicos = buscaCategoriaID("Eletrônicos");
/*
        palavra1 = new Palavra();
        palavra2 = new Palavra();
        palavra3 = new Palavra();
        palavra4 = new Palavra();
        palavra5 = new Palavra();
*/
        //palavra1 =
        inserePalavra(idEletronicos, -1, "roteador");
        //inserePalavraNaCategoria(palavra1,idEletronicos);

        //palavra2 =
        inserePalavra(idEletronicos, -1, "switch");
        //inserePalavraNaCategoria(palavra2, idEletronicos);

        //palavra3 =
        inserePalavra(idEletronicos, -1, "hub");
        //inserePalavraNaCategoria(palavra3,idEletronicos);

        //palavra4 =
        inserePalavra(idEletronicos, -1, "multimetro");
        //inserePalavraNaCategoria(palavra4,idEletronicos);

        //palavra5 =
        inserePalavra(idEletronicos, -1, "celular");
        //inserePalavraNaCategoria(palavra5,idEletronicos);
    }

    private static int buscaCategoriaID(String descricao){
        Realm realm = Realm.getDefaultInstance();
        Categoria categoria = (Categoria) realm.where(Categoria.class).equalTo(ValuesConstantes.DESCRICAO_CATEGORIA,descricao).findFirst();
        if(categoria != null){
            return categoria.getId();
        }
        else {
            return -1;
        }

    }


    //Útil para o projeto de SD
    public static void inserePalavraRespondida(Palavra palavra){
        Usuario usuario = buscarUsuario();

        usuario.getPalavrasRespondidas().add(palavra);

        atualizaUsuario(usuario);
    }

    //Útil para o projeto de SD
    public static boolean verficaPalavraExisteServidor(String palavraDescricao){
        Realm realm = Realm.getDefaultInstance();
        Palavra palavra;

        palavra = realm.where(Palavra.class).equalTo(ValuesConstantes.PALAVRA,palavraDescricao).findFirst();
        if(palavra == null){
            return false;
        }
        else {
            return true;
        }
    }

    //Útil para o projeto de SD
    public static boolean verficaCategoriaExisteServidor(String categoriaDescricao){
        Realm realm = Realm.getDefaultInstance();
        Categoria categoria;

        categoria = realm.where(Categoria.class).equalTo(ValuesConstantes.DESCRICAO_CATEGORIA,categoriaDescricao).findFirst();
        if(categoria == null){
            return false;
        }
        else {
            return true;
        }
    }


    //Útil para o projeto de SD
    public static void aumentaNumerosDesafio(){
        Usuario usuario = buscarUsuario();

        usuario.setPontuacaoDesafios(usuario.getPontuacaoDesafios() + 1);

        atualizaUsuario(usuario);
    }

    //Usado apenas para o projeto de SD
    public static ArrayList<Palavra> buscaPalarasAleatoriasNaoRespondida(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults results;

        ArrayList<Palavra> retorno = new ArrayList<Palavra>();
        Random aleatorio = new Random();
        results = realm.where(Palavra.class).findAll();
        if(results.size() < 5){
            for(int i = 0; i < results.size();){
                Palavra aux = ((Palavra) results.get(aleatorio.nextInt(results.size())));
                if(!verificarUsuarioRespondeu(aux.getPalavra())){
                    retorno.add(aux);
                    i++;
                }
            }
        }
        else {
            for(int i = 0; i < 5;){
                Palavra aux = ((Palavra) results.get(aleatorio.nextInt(results.size())));
                if(!verificarUsuarioRespondeu(aux.getPalavra())){
                    retorno.add(aux);
                    i++;
                }
            }
        }

        return retorno;
    }

    //Usado apenas para o projeto de SD
    public static void limpaPalavrasRespondidas(){
        Usuario usuario = buscarUsuario();

        RealmList<Palavra> palavras = new RealmList<Palavra>();

        usuario.setPalavrasRespondidas(palavras);

        atualizaUsuario(usuario);
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
