package com.example.lab_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        EditText returnMessage = findViewById(R.id.returnText);
        Button replyButton = findViewById(R.id.returnButton);

        Intent intent = getIntent();

        if (intent != null && intent.hasExtra("Key Message"))
        {
            String message = intent.getStringExtra("Key Message");
            returnMessage.setText(message);
        }

        replyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent replyIntent = new Intent();
                String text = returnMessage.getText().toString();
                replyIntent.putExtra("Return Message",text + " from second");
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
    }
}