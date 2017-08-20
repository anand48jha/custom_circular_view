package com.libraryprojects.json_parsing.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.StringRequest;
import com.libraryprojects.json_parsing.R;
import com.libraryprojects.json_parsing.utils.AppDataStore;

public class VolleyActivity extends AppCompatActivity
{
    private RequestQueue mRequestQueue;
    private StringRequest mRequest;
    private static final String REQUEST_TAG="STRING_REQUEST_ONE";
    private String url="http://www.mocky.io/v2/5997d8db1300004c048b7998";
    private DiskBasedCache mCache;
    private Network mNetwork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
    }
    public void startvolley(View v)
    {
        sendRequest();
    }

    private void sendRequest()
    {
//        mRequestQueue= Volley.newRequestQueue(this);
//        mCache=new DiskBasedCache(getCacheDir(),4*1024*1024);
//        mNetwork=new BasicNetwork(new HurlStack());
//        mRequestQueue=new RequestQueue(mCache,mNetwork);
//        mRequestQueue.start();
        mRequestQueue= AppDataStore.getInstance(this.getApplicationContext()).getRequestQueue(this);
        mRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                Log.e("Volley Response",response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e("Volley Error",error.toString());
            }
        });
        mRequest.setTag(REQUEST_TAG);

        mRequestQueue.add(mRequest);
    }

    @Override
    protected void onStop() {
        if(mRequestQueue!=null){
            mRequestQueue.cancelAll(REQUEST_TAG);
        }
        super.onStop();
    }
}
