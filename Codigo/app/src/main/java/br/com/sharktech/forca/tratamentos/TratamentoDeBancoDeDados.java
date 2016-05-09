package br.com.sharktech.forca.tratamentos;

import android.content.Context;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Rafael on 09/05/2016.
 */

public class TratamentoDeBancoDeDados {

    private TratamentoDeBancoDeDados (){ }

    public static void criarBanco(Context context){
        RealmConfiguration configuration = new RealmConfiguration.Builder(context).build();
        Realm.setDefaultConfiguration(configuration);

        Realm realm = Realm.getDefaultInstance();
    }
}
