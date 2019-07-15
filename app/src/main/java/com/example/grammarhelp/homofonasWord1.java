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

    long dbId=0;
    String dbWord="";
    String dbMean="";
    String dbEjemplo="";
    String dbcounter="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homofonas_word1);
        db = new DBAdapter(this);
        Intent intent = getIntent();
        String Query = intent.getStringExtra("wS1");
                //dbWord = Query;
        QueryPalabras(Query);
        asignarVariables();
    }

    public void toHomofonaWord2 (View view) {
        Intent intent = new Intent(this, homofonasWord2.class);
        String wordS2 = dbcounter;
        intent.putExtra("wS2", wordS2);
        startActivity(intent);


    }

    public void asignarVariables() {
        TextView palabra = (TextView) findViewById(R.id.textView2);
        TextView significado = (TextView) findViewById(R.id.textView3);
        TextView ejemplo = (TextView) findViewById(R.id.textView4);
        TextView contraparte = (TextView) findViewById(R.id.textView5);

        palabra.setText(dbWord);
        significado.setText("Significado: "+dbMean);
        ejemplo.setText("Ejemplo de uso: "+dbEjemplo);
        contraparte.setText("Contraparte: "+dbcounter);

/*
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
        */
    }

    public void QueryPalabras (String query){
        //String query="Haremos";
        String idWord="";
        String match="no match";
        String tV="";
        db.open();
        Cursor c = db.getAllContacts();
        if (c.moveToFirst())
        {
            do {
                //query=getPalabra(c);
                if (query.equalsIgnoreCase(getPalabra(c))){
                    idWord=getID(c);
                    dbId = Long.parseLong(idWord);
                    Constructor(dbId);
                }
            } while (c.moveToNext());
        }
        db.close();
    }



    public void Constructor(long rowid){
        dbId= rowid;
        Cursor c = db.getContact(dbId);
        if (c.moveToFirst())
        {
            dbWord= getPalabra(c);
            dbMean=getMean(c);
            dbEjemplo=getEjm(c);
            dbcounter=getCounter(c);

            //showToast(dbWord + " " +dbMean+dbEjemplo+dbcounter);
        }
        else
            Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();
        db.close();
        //showToast(String.valueOf(dbId));
    }

    public void showToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }


    public String getID(Cursor c){
        return c.getString(0);
    }
    public String getPalabra(Cursor c){
        return c.getString(1);
    }
    public String getMean(Cursor c){
        return c.getString(2);
    }
    public String getEjm(Cursor c){ return c.getString(3); }
    public String getCounter(Cursor c){ return c.getString(5); }


}
