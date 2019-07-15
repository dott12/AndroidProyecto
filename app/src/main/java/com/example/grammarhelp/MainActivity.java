package com.example.grammarhelp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import android.database.Cursor;

public class MainActivity extends AppCompatActivity {

    DBAdapter db;
    ProcesosHF Procesos = new ProcesosHF();
    int numberID=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBAdapter(this);
       // InicializarBD();
        //getOneContact();



    }

    public void botonGetData(View view){
        //InicializarBD();
       // getOneContact();
        getAllContacts();
        //Palabra();

    }


    public void getAllContacts (){
        db.open();
        Cursor c = db.getAllContacts();
        if (c.moveToFirst())
        {
            do {
                DisplayContact(c);
            } while (c.moveToNext());
        }
        db.close();
    }

    public void toHomofonas (View view) {
        Intent intent = new Intent(this, homofonasList.class);
        startActivity(intent);
    }

    public void toHomografas (View view) {
        Intent intent = new Intent(this, homografasList.class);
        startActivity(intent);
    }


    public void InicializarBD(){
        // String name,  String meaning, String example, String counterpart
        db.open();
        long _id = db.insertContact("Aremos","Forma del verbo arar","Aremos la tierra para que crezca",2);
        long _id2 = db.insertContact("HAremos","Forma del verbo hacer","Haremos un mundo mejor",2);
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

    public void getOneContact () {
        db.open();

        Cursor c = db.getContact(1);
        if (c.moveToFirst())
            DisplayContact(c);
        else
            Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();
        db.close();
    }

    public void Palabra() {
        db.open();
        String word = "aremos";

        Cursor c = db.getWord(word);
        if (c.moveToFirst())
            DisplayContact(c);
        else
            Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();
        db.close();
    }

}
