package com.example.lab_03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lab_03.R.id;

import java.util.Random;

public class DiceActivity extends AppCompatActivity {

    int sides;
    int rolled;
    Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button finishButton = findViewById(R.id.returnButton);
        Button roll = findViewById(R.id.rollButton);
        TextView textView = findViewById(id.diceView);

        Bundle bundle = getIntent().getExtras();
        sides = bundle.getInt("sides");

        textView.setText(Integer.toString(sides));

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("rolled", rolled);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rolled = rand.nextInt(sides) + 1;
                TextView random = findViewById(R.id.randomText);
                random.setText(Integer.toString(rolled));
            }
        });
    }
}