package com.example.josuecordova;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    TextView tvNombre;
    TextView tvBase;

    EditText etApellido;
    EditText etExponente;
    EditText etNumero;

    String nombre, base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        tvNombre = findViewById(R.id.editText_nombre3);
        tvBase = findViewById(R.id.editText_base3);
        etApellido = findViewById(R.id.editText_apellido3);
        etExponente = findViewById(R.id.editText_exponente3);
        etNumero = findViewById(R.id.editText_factorial3);

        nombre = getIntent().getExtras().getString("nombre");
        base = getIntent().getExtras().getString("base");

        tvNombre.setText(nombre);
        tvBase.setText(base);

    }

    public void CerrarActivity3(View view){
        String apellido, exponente, numero;

        apellido = etApellido.getText().toString();
        exponente = etExponente.getText().toString();
        numero = etNumero.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);
        intent.putExtra("base", base);
        intent.putExtra("exponente", exponente);
        intent.putExtra("numero", numero);

        setResult(Activity.RESULT_OK, intent);
        this.finish();
    }
}