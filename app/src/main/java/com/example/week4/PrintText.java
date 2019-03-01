package com.example.week4;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;


public class PrintText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_text);

        Intent intent = getIntent();
        String text = (String) intent.getSerializableExtra("typed_story");
        // Show the the whole story
        TextView textView = findViewById(R.id.textView);
        textView.setText(fromHtml(text));
    }
    // Start the onBackPressed method
    public void resetStory(View view){
        onBackPressed();
    }
    // Go to the ChooseStory page to make another story
    public void onBackPressed() {
        Intent intent = new Intent(PrintText.this, ChooseStory.class);
        startActivity(intent);
    }
    public static Spanned fromHtml(String text){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(text);
        }
    }
}
