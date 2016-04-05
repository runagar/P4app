package com.android.mta16435.p4app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BatmanComic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batman_comic);
    }

    public void mainMenu(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
