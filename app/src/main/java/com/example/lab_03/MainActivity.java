package com.example.lab_03;

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

public class MainActivity extends AppCompatActivity {

    public static final int MY_REQUEST_CODE = 1;
    ActivityResultLauncher<Intent> resultLauncher;
    String[] catArray = {"cat1.jpg","cat2.jpg","cat3.jpg"};
    int randomNum = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText text = findViewById(R.id.textInput);
        Button sendButton = findViewById(R.id.button);
        Button catButton = findViewById(R.id.viewCats);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DiceActivity.class);

                String getUserInput = text.getText().toString();
                if (getUserInput.length() > 0)
                {
                    int num = Integer.parseInt(getUserInput);
                    intent.putExtra("sides",num);
                    resultLauncher.launch(intent);
                }

            }
        });

        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result ->{
            if (result.getResultCode() == RESULT_OK && result.getData() != null)
            {
                Intent intent = result.getData();
                randomNum = intent.getIntExtra("rolled",-1);
                randomNum = randomNum % 3;
                Log.d("COMP3018", "Recieved");
            }
        }
        );

        catButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (randomNum != -1)
                {
                    Intent intent = new Intent(MainActivity.this, CatViewer.class);
                    String catName = catArray[randomNum];
                    intent.putExtra("picture",catName);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MY_REQUEST_CODE){
            if (requestCode == Activity.RESULT_OK)
            {

            }
            else if (requestCode == Activity.RESULT_CANCELED)
            {

            }
        }
    }
}