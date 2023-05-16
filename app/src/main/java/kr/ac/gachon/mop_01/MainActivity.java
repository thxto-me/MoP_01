package kr.ac.gachon.mop_01;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textview0;
    ProgressBar bar;
    Handler handler;
    ProgressRunnable runnable;
    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview0 = findViewById(R.id.TextView01);
        bar = findViewById(R.id.progress);
        handler = new Handler();
        runnable = new ProgressRunnable();
    }

    @Override
    protected void onStart() {
        super.onStart();
        bar.setProgress(0);
        Thread thread1 = new Thread(() -> {
            try {
                for (int i = 0; i < 20 && isRunning; i++) {
                    Thread.sleep(1000);
                    handler.post(runnable);
                }
            } catch (Exception e) {
                Log.e("MainActivity", "Exception in processing Message", e);
            }
        });

        isRunning = true;
        thread1.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        isRunning = false;
    }


    public class ProgressRunnable implements Runnable {

        @SuppressLint("SetTextI18n")
        public void run() {
            bar.incrementProgressBy(5);
            if (bar.getProgress() == bar.getMax()) {
                textview0.setText("Done");
            } else {
                textview0.setText("Working..." + bar.getProgress());
            }
        }
    }
}

