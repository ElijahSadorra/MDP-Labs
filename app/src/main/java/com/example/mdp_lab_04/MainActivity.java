package com.example.mdp_lab_04;

import static com.example.mdp_lab_04.MsgMethods.decryptMsg;
import static com.example.mdp_lab_04.MsgMethods.encryptMsg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.util.Base64;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class MainActivity extends AppCompatActivity {

    private EncryptService.MyBinder myService = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView = findViewById(R.id.encryptOutput);


        Log.d("COMP3018", "Starting bound service");
        this.bindService(new Intent(this, EncryptService.class), serviceConnection,
                Context.BIND_AUTO_CREATE);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView view = findViewById(R.id.encrypInput);
                String output = myService.encrypt(view.getText().toString());
                TextView outputView = findViewById(R.id.encryptOutput);
                outputView.setText(output);

                Log.d("COMP3018", myService.decrypt(output));
            }
        });

    }

    private ServiceConnection serviceConnection = new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("comp3018", "MainActivity onServiceConnected");
            myService = (EncryptService.MyBinder) service;
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("comp3018", "MainActivity onServiceDisconnected");
            myService = null;
        }
    };

    @Override
    protected void onDestroy() {
        if(serviceConnection!=null) {
            unbindService(serviceConnection);
            serviceConnection = null;
        }
    }
}