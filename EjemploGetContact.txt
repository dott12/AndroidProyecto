package utp.fisc.dpc.ds6.basededatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class VerContacto extends AppCompatActivity {

    DBAdapter db;

    int numberID=3;
    String name="io";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_contacto);
        db = new DBAdapter(this);
        Intent intent = getIntent();
    }

    public void buttonPressed(View view){
        //AsignarVariables();
        getOneContact();
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
        Cursor c = db.getContact(numberID);
        if (c.moveToFirst())
            DisplayContact(c);
        else
            Toast.makeText(this, "No contact found", Toast.LENGTH_LONG).show();
        db.close();
    }

    public void AsignarVariables(){
        EditText idCampo = (EditText) findViewById(R.id.editText4);
        name = idCampo.getText().toString();
    }

}
