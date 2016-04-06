package com.android.mta16435.p4app;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager mSensorManager;
    private Sensor mSensor;
    TextView tv1, tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null)
            mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        tv1 = (TextView) findViewById(R.id.axisX);
        tv2 = (TextView) findViewById(R.id.axisY);
        tv3 = (TextView) findViewById(R.id.axisZ);
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int Accuracy){

    }

    @Override
    public final void onSensorChanged(SensorEvent event){

        float axisX = event.values[0];
        float axisY = event.values[1];
        float axisZ = event.values[2];

        tv1.setText(String.valueOf(axisX));
        tv2.setText(String.valueOf(axisY));
        tv3.setText(String.valueOf(axisZ));
    }

    @Override
    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);
    }


}
