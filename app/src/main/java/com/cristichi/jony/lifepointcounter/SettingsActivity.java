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

        btnVolver = findViewById(R.id.btnVolverAjustes);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();

                editor.apply();
                finish();
            }
        });

        tabla = findViewById(R.id.tabla);

    }
}
