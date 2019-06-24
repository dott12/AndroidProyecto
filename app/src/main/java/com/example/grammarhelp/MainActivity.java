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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBAdapter(this);
        //InicializarBD();


    }

    public void getAllContacts (View view){
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
        //long _id = db.insertContact("Aremos","Forma del verbo arar","Aremos la tierra para que crezca",2);
        //long _id2 = db.insertContact("Aremos","Forma del verbo arar","Aremos la tierra para que crezca",2);
        db.close();
    }


    public void DisplayContact(Cursor c)
    {
        Toast.makeText(this,
                "id: " + c.getString(0) + "\n",
                Toast.LENGTH_LONG).show();

    }

}
