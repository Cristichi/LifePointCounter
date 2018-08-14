package com.cristichi.jony.lifepointcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Random;

public class UtilidadesActivity extends AppCompatActivity {

    Random rng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilidades);

        rng = new Random();

    }
}
