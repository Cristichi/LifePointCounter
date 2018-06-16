package com.cristichi.jony.lifepointcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    int LP1, LP2; //Probablemente cambie en un futuro, o no

    Switch swTema;
    boolean temaNocturno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        temaNocturno = intent.getBooleanExtra("temaOscuro", false);
        if (temaNocturno)
            setTheme(R.style.TemaNocturno);
        else
            setTheme(R.style.TemaDiurno);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LP1 = LP2 = getResources().getInteger(R.integer.lp_yugi); //Se cambiará en un futuro XD

        swTema = findViewById(R.id.swTema);
        if (temaNocturno)
            swTema.performClick();
        swTema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambiarTema();
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
