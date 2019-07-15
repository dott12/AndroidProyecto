package com.example.grammarhelp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class homofonasWord2 extends AppCompatActivity {

    String intentTest="holaaaa";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homofonas_word2);
        Intent intent = getIntent();
        intentTest = intent.getStringExtra("id");
        asignarVariables();
    }

    public void toHomofonaWord1 (View view) {
        Intent intent = new Intent(this, homofonasWord1.class);
        startActivity(intent);

    }

    public void asignarVariables() {
        TextView palabra = (TextView) findViewById(R.id.textView22);
        TextView significado = (TextView) findViewById(R.id.textView23);
        TextView ejemplo = (TextView) findViewById(R.id.textView24);
        TextView contraparte = (TextView) findViewById(R.id.textView25);

        palabra.setText(intentTest);
    }







}
