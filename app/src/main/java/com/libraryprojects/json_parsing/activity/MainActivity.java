package com.libraryprojects.json_parsing.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.libraryprojects.json_parsing.R;
import com.libraryprojects.json_parsing.models.colors;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2;
    colors colors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgets();


    }
    private void getWidgets(){
        tv1=(TextView) findViewById(R.id.tv_1);
        tv2=(TextView) findViewById(R.id.tv_2);
    }

    public void showjson(View view) throws IOException {
        String jsonString=readFromString();
        Gson gson=new Gson();
        colors=new colors();
        colors=gson.fromJson(jsonString,colors.getClass());
        tv1.setText(colors.getColors().get(0).getColor());
        tv2.setText(colors.getColors().get(0).getCategory());


    }
    private String readFromString() throws IOException {
        StringBuffer sb=new StringBuffer();
        int character;
        InputStream is=getResources().openRawResource(R.raw.color_json);
        while((character=is.read())!=-1){
            sb.append((char) character);
        }
        return sb.toString();
    }
}
