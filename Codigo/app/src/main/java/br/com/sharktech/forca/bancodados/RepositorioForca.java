package br.com.sharktech.forca.bancodados;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
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
        String[] camposUsuario = {ScriptsSQL.COL_NOME_TAB_CLI_USUARIO};

        String whereAmigos = ScriptsSQL.COL_ID_USUARIO_CLI_USUARIO_AMIGOS +" = "+id;


        Cursor cursorTabelaAmigos = conn.query(ScriptsSQL.TAB_CLI_AMIGOS_USUARIO,camposAmigos,whereAmigos,null,null,null,null);
        Cursor cursorTabelaUsuarios;
        String whereUsuario;

        if(cursorTabelaAmigos.getCount() > 0){
            do {
                whereUsuario = ScriptsSQL.COL_ID_GERAL+" = "+cursorTabelaAmigos.getInt(0);
                cursorTabelaUsuarios = conn.query(ScriptsSQL.TAB_CLI_USUARIO,camposUsuario,whereUsuario,null,null,null,null);
                if(cursorTabelaUsuarios.getCount() > 0){
                    amigos.add(cursorTabelaUsuarios.getString(0));
                }
            } while(cursorTabelaAmigos.moveToNext());
        }
        return amigos;
    }

    public int getIdBanco(){
        String[] camposID = {ScriptsSQL.COL_ID_GERAL};
        int idRetorno = -1;
        try {
            Cursor cursorID = conn.query(ScriptsSQL.TAB_CLI_USUARIO, camposID, null, null, null, null, null);
            if (cursorID.getCount() > 0) {
                idRetorno = cursorID.getInt(0);
            }
        }catch(SQLException e){  }
        return idRetorno;
    }

    public ArrayAdapter<String> buscaCategorias(Context context){
        ArrayAdapter<String> categorias = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        return categorias;
    }
}
