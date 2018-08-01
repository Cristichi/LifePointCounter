package com.cristichi.jony.lifepointcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SettingsActivity extends AppCompatActivity {

    HashMap<String, EditText> textos;
    HashMap<String, ToggleButton> botones;

    Button btnVolver;
    LinearLayout tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        textos = new HashMap<>();
        botones = new HashMap<>();

        btnVolver = findViewById(R.id.btnVolverAjustes);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Ajuste<String>> alas = Ajuste.ajustesString;
                for (int i = 0; i < alas.size(); i++) {
                    String nombre = alas.get(i).getNombre();
                    if (textos.containsKey(nombre)){
                        String txt = textos.get(nombre).getText().toString();
                        if (!txt.isEmpty()){
                            alas.get(i).setValor(txt);
                        }
                    }
                }
                ArrayList<Ajuste<Boolean>> alab = Ajuste.ajustesBoolean;
                for (int i = 0; i < alab.size(); i++) {
                    String nombre = alab.get(i).getNombre();
                    if (botones.containsKey(nombre)){
                        alab.get(i).setValor(botones.get(nombre).isChecked());
                    }
                }

                finish();
            }
        });

        tabla = findViewById(R.id.tabla);

        Iterator<Ajuste<String>> itS = Ajuste.ajustesString.iterator();
        while(itS.hasNext()){
            Ajuste<String> ajuste = itS.next();
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            TextView tv = new TextView(this);
            tv.setText(ajuste.getNombre());
            ll.addView(tv);

            EditText et = new EditText(this);
            et.setHint(ajuste.getValor());
            ll.addView(et);
            tabla.addView(ll);

            textos.put(ajuste.getNombre(), et);
        }

        Iterator<Ajuste<Boolean>> itB = Ajuste.ajustesBoolean.iterator();
        while (itB.hasNext()){
            Ajuste<Boolean> ajuste = itB.next();
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            TextView tv = new TextView(this);
            tv.setText(ajuste.getNombre());
            ll.addView(tv);

            ToggleButton tb = new ToggleButton(this);
            tb.setText(ajuste.getNombre());
            tb.setChecked(ajuste.getValor());
            ll.addView(tb);
            tabla.addView(ll);

            botones.put(ajuste.getNombre(), tb);
        }
    }
}
