package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);

    }

    public void calcularPreco(View view){

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        Boolean camposValidados = verificaCampos(precoAlcool,precoGasolina);
        if(camposValidados){

            double valorAlcool = Double.parseDouble(precoAlcool);
            double valorGasolina = Double.parseDouble(precoGasolina);

            double resultado = valorAlcool / valorGasolina;

            if(resultado >= 0.7){
                textResultado.setText("Melhor utilizar gasolina");
            }else{
                textResultado.setText("Melhor utilizar alcool");
            }


        }else{
            textResultado.setText("Preencha os preços primeiros!");
        }

    }

    public Boolean verificaCampos(String pAlcool, String pGasolina){

        boolean camposValidado = true;
        String campo = "preenchidos";

        if(pAlcool == null || pAlcool.equals("") || pGasolina == null || pGasolina.equals("")){
            camposValidado = false;
            campo = "Não foi tudo preenchido";
        }

        return camposValidado;

    }


}