package com.example.grammarhelp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class homofonasWord2 extends AppCompatActivity {

    DBAdapter db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homofonas_word2);
        Intent intent = getIntent();
        db = new DBAdapter(this);
        String idC = intent.getStringExtra("idCounter");
        int idWord=0;
        idWord = SToInt(idC);

    }

    public void toHomofonaWord1 (View view) {
        Intent intent = new Intent(this, homofonasWord1.class);
        startActivity(intent);
    }

    public int SToInt(String s){
        int i = Integer.parseInt(s);
        return i;
    }

    public void asignarVariables(){
        TextView palabra = (TextView) findViewById(R.id.textView2);
        TextView significado = (TextView) findViewById(R.id.textView3);
        TextView ejemplo = (TextView) findViewById(R.id.textView4);
        TextView contraparte = (TextView) findViewById(R.id.textView5);



        db.open();
        Cursor c = db.getContact(7);
        if (c.moveToFirst()){
            //DisplayContact2(c);
            palabra.setText(getPalabra(c));
            significado.setText(getSignificado(c));
            ejemplo.setText(getEjemplo(c));


        }

        else
            Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();
        db.close();

    }


    public String getPalabra(Cursor c){
        return c.getString(1);
    }
    public String getSignificado(Cursor c){
        return c.getString(2);
    }

    public String getEjemplo(Cursor c){
        return c.getString(3);
    }



}
