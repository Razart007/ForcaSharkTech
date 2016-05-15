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
/*
    public static ArrayList<Palavra> getPalavras() {
        return palavras;
    }

    //private static ArrayList<Palavra> palavras;
*/
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
    public static void inserePalavra(int idCategoria, int idUsuarioCriador, String palavraDescricao){
        if(!verificaPalavraExisteServidor(palavraDescricao)){
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

            inserePalavraNaCategoria(palavra, idCategoria);
        }
        else {
            Realm realm = Realm.getDefaultInstance();

            Palavra palavra = (Palavra) realm.where(Palavra.class).equalTo(ValuesConstantes.PALAVRA,palavraDescricao).findFirst();

            inserePalavraNaCategoria(palavra, idCategoria);
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
            realm.beginTransaction();
            palavras.add(palavra);
            categoria.setPalavras(palavras);

            realm.copyToRealmOrUpdate(categoria);
            realm.commitTransaction();
        }
    }

    //Útil para o projeto de SD
    public static void inserePalavrasDoServidor(){
        ArrayList<Palavra> palavrasArray = new ArrayList<Palavra>();
        ArrayList<Categoria> categoriaArray = new ArrayList<Categoria>();

        insereCategoria("Alimentos");
        insereCategoria("Animais");
        insereCategoria("Eletrônicos");

        int idAlimentos = buscaCategoriaID("Alimentos");

        inserePalavra(idAlimentos, -1,"rocambole");
        inserePalavra(idAlimentos, -1,"estrogonofe");
        inserePalavra(idAlimentos, -1,"feijao tropeiro");
        inserePalavra(idAlimentos, -1,"mousse de brigadeiro");
        inserePalavra(idAlimentos, -1,"frango grelhado");
        inserePalavra(idAlimentos, -1,"bolo de morango");
        inserePalavra(idAlimentos, -1,"arroz temperado");
        inserePalavra(idAlimentos, -1,"salada de frutas");
        inserePalavra(idAlimentos, -1,"hamburguer");
        inserePalavra(idAlimentos, -1,"sorvete");

        int idAnimais = buscaCategoriaID("Animais");

        inserePalavra(idAnimais, -1,"ouriço do mar");
        inserePalavra(idAnimais, -1,"peixe palhaço");
        inserePalavra(idAnimais, -1,"lemure");
        inserePalavra(idAnimais, -1,"ornitorrinco");
        inserePalavra(idAnimais, -1,"caracal");
        inserePalavra(idAnimais, -1,"aguia");
        inserePalavra(idAnimais, -1,"enguia");
        inserePalavra(idAnimais, -1,"coruja");
        inserePalavra(idAnimais, -1,"tubarao");
        inserePalavra(idAnimais, -1,"coelho");


        int idEletronicos = buscaCategoriaID("Eletrônicos");

        inserePalavra(idEletronicos, -1, "roteador");
        inserePalavra(idEletronicos, -1, "switch");
        inserePalavra(idEletronicos, -1, "hub");
        inserePalavra(idEletronicos, -1, "multimetro");
        inserePalavra(idEletronicos, -1, "celular");
        inserePalavra(idEletronicos, -1, "televisao");
        inserePalavra(idEletronicos, -1, "notebook");
        inserePalavra(idEletronicos, -1, "playstation");
        inserePalavra(idEletronicos, -1, "mouse");
        inserePalavra(idEletronicos, -1, "processador");
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

    public static String buscaDescricaoCategoria(int id){
        Realm realm = Realm.getDefaultInstance();
        Categoria categoria = (Categoria) realm.where(Categoria.class).equalTo(ValuesConstantes.ID_GENERICO,id).findFirst();
        if(categoria != null){
            return categoria.getDescricao();
        }
        else {
            return "";
        }
    }

    //Útil para o projeto de SD
    public static void inserePalavraRespondida(Palavra palavra){
        Usuario usuario = buscarUsuario();

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        usuario.getPalavrasRespondidas().add(palavra);

        realm.copyToRealmOrUpdate(usuario);
        realm.commitTransaction();
    }

    //Útil para o projeto de SD
    public static boolean verificaPalavraExisteServidor(String palavraDescricao){
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

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        usuario.setPontuacaoDesafios(usuario.getPontuacaoDesafios() + 1);

        realm.copyToRealmOrUpdate(usuario);
        realm.commitTransaction();
    }

    //Usado apenas para o projeto de SD
    public static void buscaPalarasAleatoriasNaoRespondida(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults results;

        RealmList<Palavra> retorno = new RealmList<Palavra>();
        Random aleatorio = new Random();
        results = realm.where(Palavra.class).findAll();
        int contador = 0;
        boolean tem = false;
        if(results.size() < 5){
            for(int i = 0; i < results.size();contador++){
                Palavra aux = ((Palavra) results.get(aleatorio.nextInt(results.size())));
                if(!verificarUsuarioRespondeu(aux.getPalavra())){
                    for(int j = 0; j < retorno.size();j++){
                        if(retorno.get(j).getPalavra().equalsIgnoreCase(aux.getPalavra())){
                            tem = true;
                            break;
                        }
                    }
                    if(!tem){
                        retorno.add(aux);
                        i++;
                    }
                    tem = false;
                }
                if(contador >= results.size()){
                    break;
                }
            }
        }
        else {
            for(int i = 0; i < 5; contador++){
                Palavra aux = ((Palavra) results.get(aleatorio.nextInt(results.size())));
                if(!verificarUsuarioRespondeu(aux.getPalavra())){
                    for(int j = 0; j < retorno.size();j++){
                        if(retorno.get(j).getPalavra().equalsIgnoreCase(aux.getPalavra())){
                            tem = true;
                            break;
                        }
                    }
                    if(!tem){
                        retorno.add(aux);
                        i++;
                    }
                    tem = false;
                }
                if(contador >= results.size()){
                    break;
                }
            }
        }

        atualizarPalavrasDesafio(retorno);
    }

    private static void atualizarPalavrasDesafio(RealmList<Palavra> palavras){
        PalavrasDesafio palavrasDesafio = buscarPalavrasDesafio();

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        palavrasDesafio.setPalavrasDesafio(palavras);

        realm.copyToRealmOrUpdate(palavrasDesafio);
        realm.commitTransaction();
    }

    private static PalavrasDesafio buscarPalavrasDesafio() {
        Realm realm = Realm.getDefaultInstance();
        PalavrasDesafio palavras = (PalavrasDesafio) realm.where(PalavrasDesafio.class).findFirst();

        if(palavras == null){
            palavras = new PalavrasDesafio();
            palavras.setPalavrasDesafio(new RealmList<Palavra>());

            realm.beginTransaction();

            realm.copyToRealmOrUpdate(palavras);
            realm.commitTransaction();

            palavras = (PalavrasDesafio) realm.where(PalavrasDesafio.class).findFirst();
        }

        return palavras;
    }

    public static RealmList<Palavra> buscarPalavrasDesafioList(){
        Realm realm = Realm.getDefaultInstance();
        PalavrasDesafio palavras = (PalavrasDesafio) realm.where(PalavrasDesafio.class).findFirst();

        if(palavras == null){
            palavras = new PalavrasDesafio();
            palavras.setPalavrasDesafio(new RealmList<Palavra>());

            realm.beginTransaction();

            realm.copyToRealmOrUpdate(palavras);
            realm.commitTransaction();

            palavras = (PalavrasDesafio) realm.where(PalavrasDesafio.class).findFirst();
        }

        return palavras.getPalavrasDesafio();
    }

    public static void removePrimeiraPalavra(RealmList<Palavra> palavras){
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        palavras.remove(0);

        realm.commitTransaction();
    }

    public static void limparPalavrasDesafio(){
        atualizarPalavrasDesafio(new RealmList<Palavra>());
    }

    //Usado apenas para o projeto de SD
    public static Palavra buscaPalavraAleatoriaNaoRespondida(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults results;

        Palavra retorno = new Palavra();
        retorno.setPalavra("");
        results = realm.where(Palavra.class).findAll();
        Random aleatorio = new Random();

        if(results.size() > 0){
            for(int i = 0; i < results.size(); i++){
                Palavra aux = ((Palavra) results.get(aleatorio.nextInt(results.size())));
                if(!verificarUsuarioRespondeu(aux.getPalavra())){
                    retorno = aux;
                    break;
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
