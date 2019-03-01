package com.example.week4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.InputStream;

public class ChooseStory extends AppCompatActivity {

    private InputStream simple;
    private InputStream tarzan;
    private InputStream university;
    private InputStream clothes;
    private InputStream dance;

    private InputStream retrievedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_story);

        //Initial the texts
        simple = getResources().openRawResource(R.raw.madlib0_simple);
        tarzan = getResources().openRawResource(R.raw.madlib1_tarzan);
        university = getResources().openRawResource(R.raw.madlib2_university);
        clothes = getResources().openRawResource(R.raw.madlib3_clothes);
        dance = getResources().openRawResource(R.raw.madlib4_dance);
    }

    // Retrieve the text of the story which the user has chosen
    public void setText(View view){
        switch(view.getId()) {
            case R.id.simpleText:
                retrievedText = simple;
                break;
            case R.id.tarzanText:
                retrievedText = tarzan;
                break;
            case R.id.universityText:
                retrievedText =university;
                break;
            case R.id.clothesText:
                retrievedText = clothes;
                break;
            case R.id.danceText:
                retrievedText = dance;
                break;
        }
        // Go to the SetWord page with the story with the retrieved text
        Story story = new Story(retrievedText);
        Intent intent = new Intent();
        intent.setClass(ChooseStory.this, SetWords.class);
        intent.putExtra("clicked_story", story);
        startActivity(intent);
    }

    // Go back to the welcome screen
    public void onBackPressed() {
        Intent intent = new Intent(ChooseStory.this, MainActivity.class);
        startActivity(intent);
    }
}
