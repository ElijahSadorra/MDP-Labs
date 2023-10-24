package com.example.lab_01;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab_01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    int counter = 0;
    ActivityResultLauncher<Intent> resultLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        CountingClass c =  new CountingClass();
        c.setCountNum(500);
        binding.setCounterXML(c);

//        // Example 2:
//        Button sendButton = findViewById(R.id.sendButton);
//        editText = findViewById(R.id.enterText);
//
//        sendButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v){
//                String message = editText.getText().toString();
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                intent.putExtra("Key Message",message);
//                resultLauncher.launch(intent);
//            }
//        });
//
//        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
//                result ->{
//            if (result.getResultCode() == RESULT_OK && result.getData() != null)
//            {
//                String returnedData = result.getData().getStringExtra("Return Message");
//                editText.setText(returnedData);
//            }
//        }
//        );
    }

//    /**
//     * Example 1: Used to add the two numbers
//     * @param v
//     */
//    public void onButtonClick(View v) {
//        Log.d(" COMP3018mdp ", " button pressed !") ;
//
//        final EditText numberOne = (EditText) findViewById(R.id.editTextNumber);
//        int one = Integer.parseInt(numberOne.getText().toString());
//
//        final EditText numberTwo = (EditText) findViewById(R.id.editTextNumber2);
//        int two = Integer.parseInt(numberTwo.getText().toString());
//
//        EditText numberThree = (EditText) findViewById(R.id.editTextNumber3);
//        int three = one + two;
//        numberThree.setText(Integer.toString(three));
//    }


//    /**
//     * Example 3: Button counter
//     */
//    public void onButtonClick(View v){
//
//        counter++;
//
//        TextView counter = (TextView) findViewById(R.id.counterView);
//        counter.setText("Counter: " + this.counter);
//    }
}