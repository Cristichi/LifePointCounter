package com.cristichi.jony.lifepointcounter.modonormal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cristichi.jony.lifepointcounter.R;

public class ContadorActivity extends AppCompatActivity {

    int vidaInicial, LP1=-1, LP2=-1; //Probablemente cambie en un futuro, o no

    Button btnVolver;
    public boolean temaNocturno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        temaNocturno = intent.getBooleanExtra("tema_oscuro", false);
        if (temaNocturno)
            setTheme(R.style.TemaNocturno);
        else
            setTheme(R.style.TemaDiurno);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

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
