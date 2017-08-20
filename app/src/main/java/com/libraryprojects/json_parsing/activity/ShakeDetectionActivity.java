package com.libraryprojects.json_parsing.activity;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.libraryprojects.json_parsing.R;
import com.squareup.seismic.ShakeDetector;

public class ShakeDetectionActivity extends AppCompatActivity implements ShakeDetector.Listener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake_detection);
        SensorManager sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector shakeDetector=new ShakeDetector(this);
        shakeDetector.start(sensorManager);

    }

    @Override
    public void hearShake() {
        //you can open the camera
        //start any service or update the UI
        Toast.makeText(this,"shake has been detected",Toast.LENGTH_LONG).show();
    }
}
