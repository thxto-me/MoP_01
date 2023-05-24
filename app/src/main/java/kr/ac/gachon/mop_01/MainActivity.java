package kr.ac.gachon.mop_01;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView gravityView;
    SensorManager SMgr;
    Sensor GSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gravityView = findViewById(R.id.gravityView);
        SMgr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        GSensor = SMgr.getDefaultSensor(Sensor.TYPE_GRAVITY);
        SMgr.registerListener(SL, GSensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onStart() {
        super.onStart();
        SMgr.registerListener(SL, GSensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SMgr.unregisterListener(SL);
    }

    public SensorEventListener SL = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_GRAVITY) {
                gravityView.setText(Float.toString(event.values[0]));
                Log.i("TAG", Float.toString(event.values[0]));
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
}

