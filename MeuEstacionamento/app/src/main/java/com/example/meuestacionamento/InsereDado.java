package com.example.meuestacionamento;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bancoDeDados.BancoController;

public class InsereDado extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao = (Button)findViewById(R.id.btnRegistrar);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText marca = (EditText)findViewById(R.id.textoMarca);
                EditText modelo = (EditText)findViewById((R.id.textoModelo));
                EditText cor = (EditText)findViewById(R.id.textoCor);
                EditText placa = (EditText)findViewById(R.id.textoPlaca);
                String marcaString = marca.getText().toString();
                String modeloString = modelo.getText().toString();
                String corString = cor.getText().toString();
                String placaString = placa.getText().toString();
                String resultado;

                resultado = crud.insereDados(marcaString, modeloString, corString, placaString, "genérico");

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}
