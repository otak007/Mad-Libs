package com.example.week4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    // Go to the ChooseStoryActivity page after click on the GET STARTED button
    public void startGame(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ChooseStoryActivity.class);
        startActivity(intent);
    }
}
