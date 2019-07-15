package com.example.grammarhelp;
import android.view.View;
import android.widget.*;

import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.Toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class homofonasList extends AppCompatActivity {

    DBAdapter db;

    long dbId=0;
    String dbWord="";
    String dbMean="";
    String dbEjemplo="";
    String dbcounter="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homofonas_list);
        db = new DBAdapter(this);
        Intent intent = getIntent();
        String Query = intent.getStringExtra("wTQ");
        QueryPalabras(Query);
        //getOneContact();

        TextView palabra = (TextView) findViewById(R.id.textView11);
        palabra.setText(dbWord);



        //Toast.makeText(this, Query, Toast.LENGTH_LONG).show();
    }

    public void toHomofonaWord (View view) {
        Intent intent = new Intent(this, homofonasWord1.class);
        startActivity(intent);
    }

    public void toHomofonasSearch (View view) {
        Intent intent = new Intent(this, homofonasSearch.class);
        startActivity(intent);
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







    //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public void getOneContact () {
        db.open();
        Cursor c = db.getContact(dbId);
        if (c.moveToFirst())
            //DisplayContact(c)
            ;
        else
            Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();
        db.close();
    }

    public void DisplayContact(Cursor c)
    {
        Toast.makeText(this,
                "id: " + c.getString(0) + "\n" +
                        "Name: " + c.getString(1) + "\n" +
                        "Email: " + c.getString(2)+ "\n" +
                        " ",
                Toast.LENGTH_LONG).show();

    }


    public void showToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }
    
}
