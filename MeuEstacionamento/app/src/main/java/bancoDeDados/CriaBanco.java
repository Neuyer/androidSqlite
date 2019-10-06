package bancoDeDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {
    private  static final String NOME_BANCO = "banco.db";
    protected static final String TABELA = "veiculos";
    protected static final String PLACA = "_placa";
    protected static final String MODELO = "modelo";
    protected static final String TIPO = "tipo";
    protected static final String MARCA = "marca";
    protected static final String COR = "cor";
    private static final int VERSAO = 1;

    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =" CREATE TABLE "+TABELA+" ( "+PLACA+" text, "+MODELO+" text, "+TIPO+" text, "+MARCA+" text,"+COR+ "text)";
            db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABELA);
            onCreate(db);
    }
}
