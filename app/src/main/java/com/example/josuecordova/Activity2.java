package com.example.josuecordova;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    int ACTIVITY_3 = 1;
    EditText etNombre;
    EditText etBase;
    Button btCerrar_Activity2;

    String nombre = "", apellido, base = "", exponente, numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        etNombre = findViewById(R.id.editText_nombre2);
        etBase = findViewById(R.id.editText_base2);
        btCerrar_Activity2 = findViewById(R.id.button_cerrar2);

        if(nombre.equals(""))
            btCerrar_Activity2.setEnabled(false);

    }

    public void AbrirActivity3(View view){
        Intent intent = new Intent(this, Activity3.class);
        intent.putExtra("nombre", etNombre.getText().toString());
        intent.putExtra("base", etBase.getText().toString());
        startActivityForResult(intent, ACTIVITY_3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ACTIVITY_3){
            if(resultCode == Activity.RESULT_OK){
                nombre = data.getStringExtra("nombre");
                apellido = data.getStringExtra("apellido");
                base = data.getStringExtra("base");
                exponente = data.getStringExtra("exponente");
                numero = data.getStringExtra("numero");


                if(!nombre.equals(""))
                    btCerrar_Activity2.setEnabled(true);

            }

            if(resultCode == Activity.RESULT_CANCELED){

            }
        }
    }


    public void CerrarActivity2(View view){
        Intent intent = new Intent();
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);
        intent.putExtra("base", base);
        intent.putExtra("exponente", exponente);
        intent.putExtra("numero", numero);

        setResult(Activity.RESULT_OK, intent);

        this.finish();;
    }
}