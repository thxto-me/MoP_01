package kr.ac.gachon.mop_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    CheckBox chkCream;
    CheckBox chkSugar;
    Button btnPay;
    RadioGroup radCoffeeType;
    RadioButton radDecaf;
    RadioButton radEspresso;
    RadioButton radColombian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkCream = findViewById(R.id.chkCream);
        chkSugar = findViewById(R.id.chkSugar);
        btnPay = findViewById(R.id.btnPay);
        radCoffeeType = findViewById(R.id.radGroupCoffeeType);
        radDecaf = findViewById(R.id.radDecaf);
        radEspresso = findViewById(R.id.radExpresso);
        radColombian = findViewById(R.id.radColombian);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Coffee ";
                if (chkCream.isChecked()) {
                    message += " & cream ";
                }
                if (chkSugar.isChecked()) {
                    message += " & Sugar";
                }
                int radioId =
                        radCoffeeType.getCheckedRadioButtonId();
                if (radDecaf.getId() == radioId)
                    message = "Decaf " + message;
                if (radColombian.getId() == radioId)
                    message = "Colombian " + message;
                if (radEspresso.isChecked())
                    message = "Espresso " + message;
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}