package com.example.week4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SetWordsActivity extends AppCompatActivity {

    Story story;
    TextView emptyPlaceholders;
    TextView kindOfWord;
    EditText newWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_words);

        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("clicked_story");

        emptyPlaceholders = findViewById(R.id.emptyPlaceholders);
        emptyPlaceholders.setText(Integer.toString(story.getPlaceholderRemainingCount()) + " word(s) left");
        kindOfWord = findViewById(R.id.textView4);
        kindOfWord.setText("Please place a/an " + story.getNextPlaceholder().toLowerCase());
        newWord = findViewById(R.id.newWord);
        newWord.setHint(story.getNextPlaceholder().toLowerCase());
    }
    // Show the ChooseStoryActivity page by pressing on the back button
    @Override
    public void onBackPressed() {
        story.clear();
        Intent intent = new Intent(SetWordsActivity.this, ChooseStoryActivity.class);
        startActivity(intent);
    }

    // Place the typed word in the placeholder when the button ADD is clicked
    public void addWord(View view){
        // Check if the input is not empty
        if (newWord.getText().toString().equals("")){
            Toast.makeText(this, "Please type a word", Toast.LENGTH_SHORT).show();
        }
        else {
            // Fill the typed word in the placeholder
            story.fillInPlaceholder( newWord.getText().toString());
            //story.htmlMode = false;
            // Go to next page when all placeholders are filled in
            if (story.isFilledIn()) {
                Intent intent = new Intent();
                intent.setClass(SetWordsActivity.this, PrintTextActivity.class);
                String text = story.toString();
                intent.putExtra("typed_story", text);
                startActivity(intent);
            }
            // Show the "next screen" with properties of the new placeholder
            else {
                Toast.makeText(this, "Great! Keep going", Toast.LENGTH_SHORT).show();
                newWord.setText("");
                emptyPlaceholders.setText(Integer.toString(story.getPlaceholderRemainingCount()) + " word(s) left");
                kindOfWord.setText("Please place a/an " + story.getNextPlaceholder().toLowerCase());
                newWord.setHint(story.getNextPlaceholder().toLowerCase());
            }
        }
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("story", story);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // restore story object
        story = (Story) savedInstanceState.getSerializable("story");

        emptyPlaceholders.setText(Integer.toString(story.getPlaceholderRemainingCount()) + " word(s) left");
        kindOfWord.setText("Please place a/an " + story.getNextPlaceholder());
        newWord.setHint(story.getNextPlaceholder());
    }
}
