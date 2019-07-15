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

    DBAdapter db;

    long dbId=0;
    String dbWord="";
    String dbMean="";
    String dbEjemplo="";
    String dbcounter="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homofonas_word2);
        db = new DBAdapter(this);
        Intent intent = getIntent();
        String Query = intent.getStringExtra("wS2");
            //dbWord = Query;
        QueryPalabras(Query);
        asignarVariables();
    }

    public void toHomofonaWord1 (View view) {
        Intent intent = new Intent(this, homofonasWord1.class);
        String wordS1 = dbcounter;
        intent.putExtra("wS1", wordS1);
        startActivity(intent);

    }

    public void asignarVariables() {
        TextView palabra = (TextView) findViewById(R.id.textView22);
        TextView significado = (TextView) findViewById(R.id.textView23);
        TextView ejemplo = (TextView) findViewById(R.id.textView24);
        TextView contraparte = (TextView) findViewById(R.id.textView25);

        palabra.setText(dbWord);
        significado.setText("Significado: "+dbMean);
        ejemplo.setText("Ejemplo de uso: "+dbEjemplo);
        contraparte.setText("Contrparte: "+dbcounter);
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

            showToast(dbWord + " " +dbMean+dbEjemplo+dbcounter);
        }
        else
            Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();
        db.close();
        showToast(String.valueOf(dbId));
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
