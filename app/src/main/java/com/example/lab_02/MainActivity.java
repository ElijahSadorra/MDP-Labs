package com.example.lab_02;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    public static final int MY_REQUEST_CODE = 1;

    EditText editText;
    ActivityResultLauncher<Intent> resultLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendButton = findViewById(R.id.sendButton);
        editText = findViewById(R.id.diceSideInput);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                    String number = getNumFromUser(editText.getText().toString());
                    if (number != "None"){
                        int num = Integer.parseInt(number);
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("sides",num);
                        startActivityForResult(intent,MY_REQUEST_CODE);
                    }
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EditText etResult = (EditText) findViewById(R.id.resultText);

        if (requestCode == MY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                int rolled = data.getIntExtra("rolled", -1);
                etResult.setText(Integer.toString(rolled));
            } else if (resultCode == Activity.RESULT_CANCELED) {
                etResult.setText(Integer.toString(-1));
            }
        }
    }

    private String getNumFromUser(String message){

        // Define a regular expression pattern to match numbers
        Pattern pattern = Pattern.compile("\\d+");

        // Create a Matcher object
        Matcher matcher = pattern.matcher(message);

        // Find and print the first number in the input
        if (matcher.find()) {
            String number = matcher.group();
            return number;
        }

        return "None";
    }
}