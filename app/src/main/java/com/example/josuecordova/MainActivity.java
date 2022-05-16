package com.example.josuecordova;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int ACTIVITY_2 = 1;
    String nombre = "",
            apellido = "",
            base = "",
            exponente = "",
            numero = "";

    TextView tvNombre;
    TextView tvApellido;
    TextView tvBase;
    TextView tvExponente;
    TextView tvFactorial;
    TextView tvPotencia;
    Button btResultados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNombre = findViewById(R.id.editText_nombre);
        tvApellido = findViewById(R.id.editText_apellido);
        tvBase = findViewById(R.id.editText_base);
        tvExponente = findViewById(R.id.editText_exponente);
        tvFactorial = findViewById(R.id.editText_factorial);
        tvPotencia = findViewById(R.id.editText_potencia);

        btResultados = findViewById(R.id.button_mostrar);


        if(nombre.equals(""))
            btResultados.setEnabled(false);

    }

    public void AbrirActivity2(View view){
        Intent intent = new Intent(this, Activity2.class);
        startActivityForResult(intent, ACTIVITY_2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ACTIVITY_2){
            if(resultCode == Activity.RESULT_OK){
                nombre = data.getStringExtra("nombre");
                apellido = data.getStringExtra("apellido");
                base = data.getStringExtra("base");
                exponente = data.getStringExtra("exponente");
                numero = data.getStringExtra("numero");

                if(!nombre.equals(""))
                    btResultados.setEnabled(true);

            }

            if(resultCode == Activity.RESULT_CANCELED){

            }
        }
    }

    public int Potencia(int base, int exponente){
        return (int)Math.pow(base, exponente);
    }

    public int factorial (double numero) {
        if (numero==0)
            return 1;
        else
            return (int)(numero * factorial(numero-1));
    }

    public void MostrarResultados(View view){
        tvNombre.setText(nombre);
        tvApellido.setText(apellido);
        tvBase.setText(base);
        tvExponente.setText(exponente);
        tvFactorial.setText(String.valueOf(factorial(Integer.parseInt(numero))));
        tvPotencia.setText(String.valueOf(Potencia(Integer.parseInt(base), Integer.parseInt(exponente))));
    }
}