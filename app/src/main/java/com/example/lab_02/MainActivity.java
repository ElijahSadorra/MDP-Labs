package com.example.lab_02;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Observable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    Button incrementButton;
    TextView incrementText;

    CounterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(CounterViewModel.class);
        incrementButton = (Button) findViewById(R.id.incrementButton);
        incrementText = (TextView) findViewById(R.id.incrementText);

        incrementText.setText(String.valueOf(viewModel.getCounter()));

        viewModel.getCounter().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                incrementText.setText(String.valueOf(integer));
            }
        });

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.incrementCounter();
            }
        });

        /**
         *  Lab 02: Part 2
         */
//        ArrayList<CatCard> catList = new ArrayList<CatCard>();
//        String[] catNames = getResources().getStringArray(R.array.cat_names);
//
//        for (int i = 0; i < 3; i++) {
//            CatCard catCard = new CatCard();
//            catCard.resID = getResources().getIdentifier("@drawable/cat" + i, "drawable", getPackageName());
//            catCard.catName = catNames[i];
//            catList.add(catCard);
//        }
//
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        CatRecyclerViewAdapter adapter = new CatRecyclerViewAdapter(this, catList);
//        recyclerView.setAdapter(adapter);

        /**
         * Lab 02: Part 1
         */
//        Button sendButton = findViewById(R.id.sendButton);
//        editText = findViewById(R.id.diceSideInput);
//
//        sendButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v){
//                    String number = getNumFromUser(editText.getText().toString());
//                    if (number != "None"){
//                        int num = Integer.parseInt(number);
//                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//                        intent.putExtra("sides",num);
//                        startActivityForResult(intent,MY_REQUEST_CODE);
//                    }
//            }
//        });

    }
    /**
     * Lab 02: Part 1
     */
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        EditText etResult = (EditText) findViewById(R.id.resultText);
//
//        if (requestCode == MY_REQUEST_CODE) {
//            if (resultCode == Activity.RESULT_OK) {
//                int rolled = data.getIntExtra("rolled", -1);
//                etResult.setText(Integer.toString(rolled));
//            } else if (resultCode == Activity.RESULT_CANCELED) {
//                etResult.setText(Integer.toString(-1));
//            }
//        }
//    }
//
//    private String getNumFromUser(String message){
//
//        // Define a regular expression pattern to match numbers
//        Pattern pattern = Pattern.compile("\\d+");
//
//        // Create a Matcher object
//        Matcher matcher = pattern.matcher(message);
//
//        // Find and print the first number in the input
//        if (matcher.find()) {
//            String number = matcher.group();
//            return number;
//        }
//
//        return "None";
//    }
}