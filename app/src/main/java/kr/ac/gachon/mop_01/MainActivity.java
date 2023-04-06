package kr.ac.gachon.mop_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView labelUserName;
    EditText txtUserName;
    Button btnBegin;
    private Context context;
    private int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        labelUserName = findViewById(R.id.TextView1);
        txtUserName = findViewById(R.id.txtUserName);
        btnBegin = findViewById(R.id.btn1);
        btnBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = txtUserName.getText().toString();
                if (userName.compareTo("Michael Han") == 0) {
                    labelUserName.setText("OK, Please wait..");
                    Toast.makeText(context, "Hi!, Mr." + userName, duration).show();
                } else {
                    Toast.makeText(context, userName + " is not a valid User", duration).show();
                }
            }
        });
    }
}