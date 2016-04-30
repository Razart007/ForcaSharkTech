package br.com.sharktech.forca.bancodados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Script;

public class BancoDeDados extends SQLiteOpenHelper{
    public BancoDeDados(Context context) {
        super(context, "FORCA", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ScriptsSQL.getCreateTableCategoria());
        db.execSQL(ScriptsSQL.getCreateTableUsuario());
        db.execSQL(ScriptsSQL.getCreateTablePalavra());
        db.execSQL(ScriptsSQL.getCreateTableUsuarioAmigos());
        db.execSQL(ScriptsSQL.getCreateTablePalavrasAcertadasPorUsuario());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ScriptsSQL.getDropTableAmigosUsuario());
        db.execSQL(ScriptsSQL.getDropTablePalavrasAcertadasUsuario());
        db.execSQL(ScriptsSQL.getDropTablePalavra());
        db.execSQL(ScriptsSQL.getDropTableUsuario());
        db.execSQL(ScriptsSQL.getDropTableCategoria());
        onCreate(db);
    }
}
