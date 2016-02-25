package com.paraonensk.tests;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ParaOneNSK on 2/25/2016.
 */
public class AccelerometerTest extends Activity implements SensorEventListener {
    TextView textView;
    StringBuilder builder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        setContentView(textView);

        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() == 0){
            textView.setText("No accelerometer installed");
        }else{
            Sensor accelerometer = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
            if(!manager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME)){
                textView.setText("Couldn't register sensor listener");
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        builder.setLength(0);
        builder.append("x: ");
        builder.append(sensorEvent.values[0]);
        builder.append(", y: ");
        builder.append(sensorEvent.values[1]);
        builder.append(", z: ");
        builder.append(sensorEvent.values[2]);
        textView.setText(builder.toString());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        // do nothing
    }
}
