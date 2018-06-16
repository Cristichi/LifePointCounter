package com.cristichi.jony.lifepointcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class ContadorActivity extends AppCompatActivity {

    int LP1=-1, LP2=-1; //Probablemente cambie en un futuro, o no

    Button btnVolver;
    Switch swTema;
    public boolean temaNocturno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        temaNocturno = intent.getBooleanExtra("temaOscuro", false);
        if (temaNocturno)
            setTheme(R.style.TemaNocturno);
        else
            setTheme(R.style.TemaDiurno);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);

        Bundle extras = getIntent().getExtras();
        LP1 = LP2 = extras.getInt("vida_inicial", -1);

        swTema = findViewById(R.id.swTema);
        if (temaNocturno)
            swTema.performClick();
        swTema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarTema();
            }
        });

        btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void cambiarTema(){
        Intent intent = new Intent(this, getClass());
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.putExtra("temaOscuro", !temaNocturno);
        intent.putExtra("LP1", LP1);
        intent.putExtra("LP2", LP2);
        startActivity(intent);
        finish();
    }
}
