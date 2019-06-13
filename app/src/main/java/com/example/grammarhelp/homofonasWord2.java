package com.example.grammarhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class homofonasWord2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homofonas_word2);
        Intent intent = getIntent();
    }

    public void toHomofonaWord1 (View view) {
        Intent intent = new Intent(this, homofonasWord1.class);
        startActivity(intent);
    }

}
