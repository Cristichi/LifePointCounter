package com.cristichi.jony.lifepointcounter;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cristichi.jony.lifepointcounter.modonormal.ContadorActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MainActivity este = this;

    LinearLayout ll;
    Juego[] juegos = Juego.values();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = findViewById(R.id.linLay);

        for (final Juego juego : juegos) {
            Button nuevo = new Button(this);
            nuevo.setText(juego.getNombre());
            nuevo.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            nuevo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    abrirJuego(juego.getVidaInicial());
                }
            });
            ll.addView(nuevo,1);
        }

        Button btnAjustes = new Button(this);
        btnAjustes.setText(getResources().getString(R.string.btn_ajustes));
        btnAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(este, SettingsActivity.class);
                startActivity(intento);
            }
        });
        ll.addView(btnAjustes);

        Button btnAcercaDe = new Button(this);
        btnAcercaDe.setText(getResources().getString(R.string.btn_acerca_de));
        btnAcercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarToast("Todavia no disponible");
            }
        });
        ll.addView(btnAcercaDe);

        Resources res = getResources();
        Ajuste.ajustesString = new ArrayList<>();
        Ajuste.ajustesString.add(new Ajuste<>(res.getString(R.string.stt_p1_name),
                res.getString(R.string.stt_p1_name_default_value)));

        Ajuste.ajustesBoolean = new ArrayList<>();
        Ajuste.ajustesBoolean.add(new Ajuste<>(res.getString(R.string.stt_notes_mode),
                false));
        Ajuste.ajustesBoolean.add(new Ajuste<>(res.getString(R.string.stt_modo_nocturno),
                false));

    }

    private void abrirJuego(int vidaInicial){
        Resources res = getResources();
        Intent intento;
        if (Ajuste.getAjusteBooleano(res.getString(R.string.stt_notes_mode))){
            intento = new Intent(this, ContadorActivity.class);
        }else{
            intento = new Intent(this, ContadorActivity.class);
        }
        intento.putExtra("tema_oscuro", Ajuste.getAjusteBooleano(res.getString(R.string.stt_modo_nocturno)));
        intento.putExtra("vida_inicial", vidaInicial);
        intento.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intento);
    }

    Toast tostada;
    private void mostrarToast(String texto){
        tostada = Toast.makeText(this, texto, Toast.LENGTH_LONG);
        tostada.show();
    }
}
