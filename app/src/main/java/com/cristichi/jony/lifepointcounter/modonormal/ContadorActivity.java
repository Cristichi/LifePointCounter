package com.cristichi.jony.lifepointcounter.modonormal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cristichi.jony.lifepointcounter.Ajustes;
import com.cristichi.jony.lifepointcounter.R;
import com.cristichi.jony.lifepointcounter.Tema;

public class ContadorActivity extends AppCompatActivity {

    SharedPreferences sp;

    int vidaInicial, LP1=-1, LP2=-1; //Probablemente cambie en un futuro, o no

    Button btnVolver;
    int tema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);
        sp = getSharedPreferences(Ajustes.archivo, MODE_PRIVATE);

        setTheme(sp.getInt(Ajustes.ajuste_tema, Tema.temaDiurno.getTema()));

        Intent intento = getIntent();
        if (intento.hasExtra("vida_inicial")) {
            vidaInicial= LP1 = LP2 =intento.getIntExtra("vida_inicial", -1);
        }else{
            Toast.makeText(this, "ERROR: No starting LP", Toast.LENGTH_LONG).show();
            finish();
        }

        btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
