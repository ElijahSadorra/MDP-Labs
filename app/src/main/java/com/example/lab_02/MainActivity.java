package com.example.lab_02;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

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
                int num = Integer.parseInt(editText.getText().toString());
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle () ;
                bundle.putInt("sides", num ) ;
                intent.putExtra("Key Message",message);
                resultLauncher.launch(intent);
            }
        });

        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result ->{
            if (result.getResultCode() == RESULT_OK && result.getData() != null)
            {
                String returnedData = result.getData().getStringExtra("Return Message");
                editText.setText(returnedData);
            }
        }
        );

    }
}