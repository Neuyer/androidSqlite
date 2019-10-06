package bancoDeDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context contexto){
    }

    public String insereDados(String marca, String modelo, String placa, String cor, String tipo){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.MARCA,marca);
        valores.put(CriaBanco.MODELO, modelo);
        valores.put(CriaBanco.TIPO, tipo);
        valores.put(CriaBanco.COR,cor);

        resultado = db.insert(CriaBanco.TABELA,null, valores);
        db.close();

        if(resultado == -1){
            return "Erro ao inserir registro";
        }else{
            return "Registro Inserido com sucesso!";
        }
    }
}
