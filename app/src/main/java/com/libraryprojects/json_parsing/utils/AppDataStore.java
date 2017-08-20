package com.libraryprojects.json_parsing.utils;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by anand-trisys on 19/8/17.
 */

public class AppDataStore
{
    private static RequestQueue requestQueue;
    private static AppDataStore mInstance;

    public static AppDataStore getInstance(Context context){
     if(mInstance==null){
         mInstance=new AppDataStore(context);
     }
     return mInstance;
    }

    private AppDataStore(Context context){
    requestQueue=getRequestQueue(context);
    }
    public  RequestQueue getRequestQueue(Context context)
    {
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(context);
        }
        return requestQueue;
    }
}
