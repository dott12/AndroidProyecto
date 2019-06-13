package com.example.grammarhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class homografasWord2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homografas_word2);
        Intent intent = getIntent();
    }

    public void toHomografaWord1 (View view) {
        Intent intent = new Intent(this, homografasWord1.class);
        startActivity(intent);
    }

}
