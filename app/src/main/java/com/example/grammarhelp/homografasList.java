package com.example.grammarhelp;
import android.view.View;
import android.widget.*;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class homografasList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homografas_list);
        Intent intent = getIntent();
    }

    public void toHomografaWord (View view) {
        Intent intent = new Intent(this, homografasWord1.class);
        startActivity(intent);
    }


}
