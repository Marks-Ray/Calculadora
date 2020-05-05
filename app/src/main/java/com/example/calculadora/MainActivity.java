package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.EGLExt;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText numero1;
    EditText numero2;
    TextView resultado;
    ListView lvLog;
    ArrayList historico;
    int contador = 0;
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = findViewById(R.id.etNum1);
        numero2 = findViewById(R.id.etNum2);
        resultado = findViewById(R.id.tvRes);
        lvLog = findViewById(R.id.lvLog);
        historico = new ArrayList<String>();
        adaptador = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, historico);
        lvLog.setAdapter(adaptador);
    }

    public void adicaoResultado (View v) {
        resultado.setText("");
        String num1St = numero1.getText().toString().trim();
        String num2St = numero2.getText().toString().trim();

        if (num1St.equals("") || num2St.equals("")) {
            Toast.makeText(this, "Por favor, informar os dois números!", Toast.LENGTH_LONG).show();
        } else {
            float res = Float.valueOf(num1St) + Float.valueOf(num2St);
            resultado.setText("Resultado: " + res);
            historico.add(num1St +" + "+ num2St +" = "+ res);
            adaptador.notifyDataSetChanged();
        }
    }

    public void subtracaoResultado (View v) {
        resultado.setText("");
        String num1St = numero1.getText().toString().trim();
        String num2St = numero2.getText().toString().trim();

        if (num1St.equals("") || num2St.equals("")) {
            Toast.makeText(this, "Por favor, informar os dois números!", Toast.LENGTH_LONG).show();
        } else {
            float res = Float.valueOf(num1St) - Float.valueOf(num2St);
            resultado.setText("Resultado: " + res);
            historico.add(num1St +" - "+ num2St +" = "+ res);
            adaptador.notifyDataSetChanged();
        }
    }
    public void multiplicacoResultado (View v) {
        resultado.setText("");
        String num1St = numero1.getText().toString().trim();
        String num2St = numero2.getText().toString().trim();

        if (num1St.equals("") || num2St.equals("")) {
            Toast.makeText(this, "Por favor, informar os dois números!", Toast.LENGTH_LONG).show();
        }else {
            float res = Float.valueOf(num1St) * Float.valueOf(num2St);
            resultado.setText("Resultado: " + res);
            historico.add(num1St +" * "+ num2St +" = "+ res);
            adaptador.notifyDataSetChanged();
        }
    }
    public void divisaoResultado (View v) {
        resultado.setText("");
        String num1St = numero1.getText().toString().trim();
        String num2St = numero2.getText().toString().trim();

        if (num1St.equals("") || num2St.equals("")) {
            Toast.makeText(this, "Por favor, informar os dois números!", Toast.LENGTH_LONG).show();
        }
        else if(num2St.equals("0")){
            Toast.makeText(this,"O segundo numero não pode ser 0!",Toast.LENGTH_LONG).show();
        }else {
            float res = Float.valueOf(num1St) / Float.valueOf(num2St);
            resultado.setText("Resultado: " + res);
            historico.add(num1St +" / "+ num2St +" = "+ res);
            adaptador.notifyDataSetChanged();
        }
    }

    public void apagarLog(View v){
        historico.clear();
        adaptador.notifyDataSetChanged();
    }

}
