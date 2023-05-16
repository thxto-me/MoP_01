package kr.ac.gachon.mop_01;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText userinput, passinput;
    Button submit, exit;
    String username, password;
    SharedPreferences sh_pref;
    SharedPreferences.Editor toEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submit);
        exit = findViewById(R.id.exit);
        userinput = findViewById(R.id.userinput);
        passinput = findViewById(R.id.passinput);
        submit.setOnClickListener(view -> {
            username = userinput.getText().toString();
            password = passinput.getText().toString();
            sharedPreferences();
            Toast.makeText(getApplicationContext(), "Details are saved", Toast.LENGTH_LONG).show();
        });
        exit.setOnClickListener(view -> finish());
        applySharedPreference();
    }

    private void sharedPreferences() {
        sh_pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        toEdit = sh_pref.edit();
        toEdit.putString("Username", username);
        toEdit.putString("Password", password);
        toEdit.commit();
    }

    private void applySharedPreference() {
        sh_pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        if (sh_pref != null && sh_pref.contains("Username")) {
            String name = sh_pref.getString("Username", "noname");
            userinput.setText(name);
        }
    }

}