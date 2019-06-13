package com.example.grammarhelp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class homofonasSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homofonas_search);
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
