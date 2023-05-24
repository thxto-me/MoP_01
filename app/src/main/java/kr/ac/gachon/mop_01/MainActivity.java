package kr.ac.gachon.mop_01;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager SM = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> arSensor = SM.getSensorList(Sensor.TYPE_ALL);

        StringBuilder rst = new StringBuilder(" 갯수 : " + arSensor.size() + "\n\n");

        for (Sensor s : arSensor) {
            rst.append(" 이름 = ").append(s.getName()).append(",\n 형식 = ").append(s.getType()).append(",\n 제조사 = ").append(s.getVendor()).append(",\n 전원 = ").append(s.getPower()).append(",\n 해상도 = ").append(s.getResolution()).append(",\n 범위 = ").append(s.getMaximumRange()).append("\n\n");
        }
        TextView txtResult = findViewById(R.id.result);
        txtResult.setText(rst.toString());
    }
}
