package com.example.grammarhelp;
import android.view.View;
import android.widget.*;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class homofonasList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homofonas_list);
        Intent intent = getIntent();
    }

    public void toHomofonaWord (View view) {
        Intent intent = new Intent(this, homofonasWord1.class);
        startActivity(intent);
    }

    public void toHomofonasSearch (View view) {
        Intent intent = new Intent(this, homofonasSearch.class);
        startActivity(intent);
    }

    
}
