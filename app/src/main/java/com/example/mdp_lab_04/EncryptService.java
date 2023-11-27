package com.example.mdp_lab_04;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Base64;
import android.util.Log;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EncryptService extends Service {
    private final IBinder binder = new MyBinder();
    private SecretKey mSecretKey;
    private Messenger mMessenger;

    public EncryptService() {
        try{
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            keygen.init(256);
            mSecretKey = keygen.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        mMessenger = new Messenger(new MyHandler());
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return mMessenger.getBinder();
    }

    public class MyBinder extends Binder {
        String encrypt(String input)
        {
            try{
                byte[] encryptedMessage = MsgMethods.encryptMsg(input, mSecretKey);
                Log.d("COMP3018", "Encrypt");
                return (encryptedMessage.toString());
            }catch (Exception e){
                Log.d("COMP3018", "Error");
                return "";
            }
        }

        String decrypt(String input)
        {
            try{
                byte[] decodedBytes = Base64.decode(input, Base64.NO_WRAP);

                String decryptedMessage = MsgMethods.decryptMsg(decodedBytes, mSecretKey);
                Log.d("COMP3018", "Decrypt");
                return (decryptedMessage.toString());
            }catch (Exception e){
                Log.d("COMP3018", "Error");
                return "";
            }
        }
    }

    private class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {

        }
    }

}