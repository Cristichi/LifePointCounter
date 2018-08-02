package com.cristichi.jony.lifepointcounter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cristichi.jony.lifepointcounter.modonormal.ContadorActivity;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;

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
        btnAjustes.setText(getResources().getString(R.string.ajustes));
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

        //AJUSTEEEEEEEEEEEEEEEEES, PREFERENCIAS, OPCIONES O LO QUE HAGA FALTA

        Resources res = getResources();
        Ajustes.ajuste_tema = res.getString(R.string.stt_tema);
        Ajustes.ajuste_modo_notas = res.getString(R.string.stt_notes_mode);
        Ajustes.ajuste_nombre_j1 = res.getString(R.string.stt_p1_name);
        Ajustes.ajuste_nombre_j1_defecto = res.getString(R.string.stt_p1_name_default_value);

        Tema.temaDiurno = new Tema(res.getString(R.string.tema_diurno), R.style.TemaDiurno);
        Tema.temaNocturno = new Tema(res.getString(R.string.tema_nocturno), R.style.TemaNocturno);

        sp = getSharedPreferences(Ajustes.archivo, MODE_PRIVATE);
        if (!sp.contains(Ajustes.archivo)){
            SharedPreferences.Editor editSp = sp.edit();
            editSp.putBoolean(Ajustes.ajuste_modo_notas, false);
            editSp.putInt(Ajustes.ajuste_tema, Tema.temaDiurno.getTema());
            editSp.putString(Ajustes.ajuste_nombre_j1, Ajustes.ajuste_nombre_j1_defecto);
            editSp.apply();
        }

        setTheme(sp.getInt(Ajustes.ajuste_tema, Tema.temaDiurno.getTema()));
    }

    private void abrirJuego(int vidaInicial){
        Resources res = getResources();
        Intent intento;
        if (sp.getBoolean(res.getString(R.string.stt_notes_mode), false)){
            intento = new Intent(this, ContadorActivity.class);
        }else{
            intento = new Intent(this, ContadorActivity.class);
        }
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
