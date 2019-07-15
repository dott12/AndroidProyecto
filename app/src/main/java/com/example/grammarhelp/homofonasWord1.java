package com.example.grammarhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;




public class homofonasWord1 extends AppCompatActivity {

    DBAdapter db;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homofonas_word1);
        Intent intent = getIntent();
        asignarVariables();
    }

    public void toHomofonaWord2 (View view) {
        Intent intent = new Intent(this, homofonasWord2.class);
        startActivity(intent);

    }

    public void asignarVariables(){
        TextView palabra = (TextView) findViewById(R.id.textView2);
        TextView signficado = (TextView) findViewById(R.id.textView3);
        TextView ejemplo = (TextView) findViewById(R.id.textView4);
        TextView contraparte = (TextView) findViewById(R.id.textView5);

        palabra.setText("PalabraP");
        signficado.setText("SignificadoP");


    }





}
