package com.example.ahmed.volleytest;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
final String url="https://ahmedmh.000webhostapp.com/Capture.PNG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Button button = (Button)  findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        imageView.setImageBitmap(response);
                        Toast.makeText(getApplicationContext(),"image loaded",Toast.LENGTH_SHORT).show();
                    }
                },0,0, Bitmap.Config.RGB_565,new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        imageView.setImageResource(R.mipmap.ic_launcher);
                    }
                });
                Volley.newRequestQueue(getApplicationContext()).add(imageRequest);
            }
        });

    }
}
