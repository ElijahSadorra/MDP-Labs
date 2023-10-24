package com.example.lab_01;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {
        Log.d(" COMP3018mdp ", " button pressed !") ;

        final EditText numberOne = (EditText) findViewById(R.id.editTextNumber);
        int one = Integer.parseInt(numberOne.getText().toString());

        final EditText numberTwo = (EditText) findViewById(R.id.editTextNumber2);
        int two = Integer.parseInt(numberTwo.getText().toString());

        EditText numberThree = (EditText) findViewById(R.id.editTextNumber3);
        int three = one + two;
        numberThree.setText(Integer.toString(three));
    }

}