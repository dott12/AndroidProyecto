package com.example.grammarhelp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
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
        cleanAll();


    }

    public void botonGetData(View view){
        //addRegistros();
       // getOneContact();
        //deleteContact();
        //StringToArray();
        //cleanAll();
        getAllContacts();
        //ClonarDato();
        //Palabra();
        //mostrarToast();
        //QueryPalabras("Haremos");

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
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        String wordToQ = editText3.getText().toString();

        Intent intent = new Intent(this, homofonasList.class);
        intent.putExtra("wTQ", wordToQ);
        startActivity(intent);
    }

    public void toPermisos (View view) {


        Intent intent = new Intent(this, permisos.class);
        startActivity(intent);
    }




    public void addRegistros(){
        // String name,  String meaning, String example, String counterpart
        db.open();
        long _id = db.insertContact("Aremos","Forma del verbo arar","Aremos la tierra para que crezca",0, "Haremos");
        long _id2 = db.insertContact("Haremos","Forma del verbo hacer","Haremos un mundo mejor",0, "Aremos");

        long _id3 = db.insertContact("Abrasar","Quemar algo","Abrasa el pollo para servirlo",0, "Abrazar");
        long _id4 = db.insertContact("Abrazar","Dar un abrazo","Los abrazos son buenos",0, "Abrasar");
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



    public void deleteContact (int c) {

        db.open();
        if (db.deleteContact(c)) {
            //Toast.makeText(this, "Delete successful.", Toast.LENGTH_LONG).show();
        }else
            Toast.makeText(this, "Delete failed. " + String.valueOf(c), Toast.LENGTH_LONG).show();
        db.close();

    }

    public void mostrarToast(String str){

        //Toast.makeText(this, StringToArray("Ana"), Toast.LENGTH_LONG).show();

    }

    public String StringToArray(String palabra){
        String testString = "Ana";
        palabra = palabra.toUpperCase();
        String result="";
        char[] sToChar = palabra.toCharArray();

        for (int s=0;s<sToChar.length;s++){

            char c = sToChar[s];

            switch(c) {
                case 'A':
                    result = result + "1";
                    break;
                case 'N':
                    result = result + "14";
                    break;
                default:
                    // code block
                    }
        }
        return result;
    }

    public void QueryPalabras (String query){
        //String query="Haremos";
        String idWord="";
        String match="no match";
        db.open();
        Cursor c = db.getAllContacts();
        if (c.moveToFirst())
        {
            do {
                //query=getPalabra(c);
                if (query.equalsIgnoreCase(getPalabra(c))){
                    idWord=getID(c);
                    match = idWord+ " = "+ "match";
                }

                Toast.makeText(this, match, Toast.LENGTH_LONG).show();
            } while (c.moveToNext());
        }
        db.close();
    }

    public String getPalabra(Cursor c){
        return c.getString(1);
    }

    public String getID(Cursor c){
        return c.getString(0);
    }

    public void cleanAll(){
        int n=0;
        db.open();
        Cursor c = db.getAllContacts();
        if (c.moveToFirst())
        {
            do {
                n=Integer.parseInt(getID(c));
                //showToast(String.valueOf(n));
                deleteContact(n);
            } while (c.moveToNext());
        }
        db.close();
        addRegistros();
    }

    public void showToast(String str){

        Toast.makeText(this, str, Toast.LENGTH_LONG).show();

    }


}
