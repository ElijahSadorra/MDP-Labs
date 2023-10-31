package com.example.lab_02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class MainActivity2 extends AppCompatActivity {

    int sides;
    int rolled;
    Random rand = new Random () ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Bundle bundle = getIntent().getExtras();
        sides = bundle.getInt("sides");

        TextView sideOutput = (TextView) findViewById(R.id.sideText);
        sideOutput.setText("sides: "+ sides);

    }

    public void onRoll(View v){
        rolled = rand.nextInt(sides) + 1;
        TextView res = (TextView) findViewById(R.id.rolledText);
        res.setText("rolled: "+ rolled);
    }

    public void onButtonClicked(View v){
        Intent intent = new Intent();
        intent.putExtra("rolled",rolled);
        setResult(Activity.RESULT_OK ,intent);
        finish();
    }
}
