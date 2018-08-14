package com.cristichi.jony.lifepointcounter;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {

    SharedPreferences sp;

    Button btnVolver;
    LinearLayout tabla;

    Spinner spnnTemas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sp = getSharedPreferences(Ajustes.archivo, MODE_PRIVATE);

        setTheme(sp.getInt(Ajustes.ajuste_tema, Tema.temaDiurno.getTema()));

        btnVolver = findViewById(R.id.btnVolverAjustes);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt(Ajustes.ajuste_tema, ((Tema)spnnTemas.getSelectedItem()).getTema());
                editor.apply();
                finish();
            }
        });

        tabla = findViewById(R.id.tabla);

        spnnTemas = findViewById(R.id.spnnTemas);
        ArrayList<Tema> temas = new ArrayList<>();
        temas.add(Tema.temaDiurno);
        temas.add(Tema.temaNocturno);
        spnnTemas.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, temas));
        int temaId = sp.getInt(Ajustes.ajuste_tema, 0);
        if (temaId==Tema.temaDiurno.getTema()){
            spnnTemas.setSelection(0);
        }else if (temaId==Tema.temaNocturno.getTema()){
            spnnTemas.setSelection(1);
        }else {
            throw new IllegalArgumentException("Theme "+temaId+" not found");
        }
    }
}
