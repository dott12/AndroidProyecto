package com.example.grammarhelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class ProcesosHF extends AppCompatActivity {

    DBAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DBAdapter(this);
    }

    public void InicializarBD(){
       // String name,  String meaning, String example, String counterpart
        db.open();
        //long _id = db.insertContact("Aremos","Forma del verbo arar","Aremos la tierra para que crezca",2);
        //db.insertContact(2,"Haremos","Forma del verbo hacer","Hoy haremos limpieza",1);
       db.close();
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

    public void DisplayContact(Cursor c)
    {
        Toast.makeText(this,
                "id: " + c.getString(0) + "\n" +
                        "Name: " + c.getString(1) + "\n" +
                        "Email: " + c.getString(2)+ "\n" +
                        " ",
                Toast.LENGTH_LONG).show();

    }

}
