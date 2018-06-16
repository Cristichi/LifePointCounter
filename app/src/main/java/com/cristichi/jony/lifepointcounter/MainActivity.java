package com.cristichi.jony.lifepointcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = findViewById(R.id.linLay);

        Button btnMultiusos = new Button(this);
        btnMultiusos.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        btnMultiusos.setText(R.string.nombre_ygo);
        btnMultiusos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentado(ContadorActivity.class, getResources().getInteger(R.integer.lp_yugi));
            }
        });
        ll.addView(btnMultiusos);

        btnMultiusos = new Button(this);
        btnMultiusos.setText(R.string.nombre_fow);
        btnMultiusos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentado(ContadorActivity.class, getResources().getInteger(R.integer.lp_fow));
            }
        });
        ll.addView(btnMultiusos);

        btnMultiusos = new Button(this);
        btnMultiusos.setText(R.string.nombre_magic);
        btnMultiusos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentado(ContadorActivity.class, getResources().getInteger(R.integer.lp_magic));
            }
        });
        ll.addView(btnMultiusos);
    }

    private void intentado(Class clase, int vidaInicial){
        Intent intento = new Intent(this, clase);
        intento.putExtra("vida_inicial", vidaInicial);
        startActivity(intento);
    }
}
