package kr.ac.gachon.mop_01;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button1);

        button.setOnClickListener(v -> {
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);
            imageView1.startAnimation(anim);
            editText.append("Animation Started\n");
        });
    }
}