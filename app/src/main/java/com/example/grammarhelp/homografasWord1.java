package com.example.grammarhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class homografasWord1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homografas_word1);
        Intent intent = getIntent();
    }

    public void toHomografaWord2 (View view) {
        Intent intent = new Intent(this, homografasWord2.class);
        startActivity(intent);
    }
}
