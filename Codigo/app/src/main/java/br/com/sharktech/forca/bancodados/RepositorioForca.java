package br.com.sharktech.forca.bancodados;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

public class RepositorioForca {
    private SQLiteDatabase conn;
    public RepositorioForca(SQLiteDatabase conn){
        this.conn = conn;
    }


    public ArrayAdapter<String> buscaAmigos(Context context, int id){
        ArrayAdapter<String> amigos = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);

        String[] camposAmigos = {ScriptsSQL.COL_ID_USUARIO_CLI_USUARIO_AMIGOS, ScriptsSQL.COL_ID_USUARIO_1_CLI_USUARIO_AMIGOS};
        String[] camposUsuario = {ScriptsSQL.COL_NOME_TAB_CLI_USUARIO, ScriptsSQL.COL_PONTUACAO_GERAL_TAB_CLI_USUARIO};

        String whereAmigos = ScriptsSQL.COL_ID_USUARIO_CLI_USUARIO_AMIGOS +" = "+id;


        Cursor cursorTabelaAmigos = conn.query(ScriptsSQL.TAB_CLI_AMIGOS_USUARIO,camposAmigos,whereAmigos,null,null,null,null);
        Cursor cursorTabelaUsuarios;
        String whereUsuario;

        if(cursorTabelaAmigos.getCount() > 0){
            do {
                whereUsuario = ScriptsSQL.COL_ID_GERAL +" = "+cursorTabelaAmigos.getInt(0);
                cursorTabelaUsuarios = conn.query(ScriptsSQL.TAB_CLI_USUARIO,camposUsuario,whereUsuario,null,null,null,null);
                if(cursorTabelaUsuarios.getCount() > 0){
                    //amigos.add();
                }
            } while(cursorTabelaAmigos.moveToNext());
        }
        return amigos;
    }

    public ArrayAdapter<String> buscaCategorias(Context context){
        ArrayAdapter<String> categorias = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        return categorias;
    }
}
