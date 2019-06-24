package com.example.grammarhelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    DBAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBAdapter(this);
    }

    public void toHomofonas (View view) {
        Intent intent = new Intent(this, homofonasList.class);
        startActivity(intent);
    }

    public void toHomografas (View view) {
        Intent intent = new Intent(this, homografasList.class);
        startActivity(intent);
    }


}
