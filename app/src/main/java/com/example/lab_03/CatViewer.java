package com.example.lab_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.net.URL;

public class CatViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_viewer);

        String catName = getIntent().getStringExtra("picture");
        String url = "http://www.cs.nott.ac.uk/~pszmdf/comp3018/" + catName;

        ImageView imageView = findViewById(R.id.catImageView);
        Handler h = new Handler(Looper.myLooper());

        new Thread(new Runnable() {
            public void run() {
                // Executed in the new thread
                final Bitmap bmp = loadBitmap(url);
                h.post(new Runnable() {
                    // Executed in the UI thread via the handler
                    public void run() {
                        imageView.setImageBitmap(bmp);
                    }
                });
            }
        }).start();
    }

    public Bitmap loadBitmap(String url) {
        Bitmap bmp = null;
        try {
            URL theUrl = new URL(url);
            bmp = BitmapFactory.decodeStream(theUrl.openConnection().getInputStream());
        } catch (Exception e) {
            Log.d("comp3018", e.toString());
        }
        return bmp;
    }

}
