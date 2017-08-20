package com.libraryprojects.json_parsing.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.libraryprojects.json_parsing.R;

public class ImageRequestActivity extends AppCompatActivity
{
    private RequestQueue mRequestQueue;
    private ImageRequest imageRequest;
    private ImageView imageView;
    private String url="http://media1.santabanta.com/full1/Football/Lionel%20Messi/lionel-messi-33a.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_request);
        imageView=(ImageView) findViewById(R.id.image_iv);
    }
    public void showImage(View v){
        getRequestQueue();
        imageRequest=new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response)
            {
                imageView.setImageBitmap(response);
            }
        }, 0, 0, null, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                imageView.setImageResource(R.drawable.failed);
            }
        });
        mRequestQueue.add(imageRequest);
    }
    private void getRequestQueue(){
        mRequestQueue= Volley.newRequestQueue(this.getApplicationContext());

    }
}
