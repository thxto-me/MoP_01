package kr.ac.gachon.mop_01;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tvCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.tv_counter);
        new CountDownTask().execute();
    }

    private class CountDownTask extends AsyncTask<Void, Integer, Void> {
        @SuppressLint("SetTextI18n")
        @Override
        protected void onPreExecute() {
            tvCounter.setText("*start*");
        }

        @Override
        protected Void doInBackground(Void... params) {
            for (int i = 15; i >= 0; i--) {
                try {
                    Thread.sleep(1000);
                    publishProgress(i);
                } catch (Exception ignored) {
                }
            }
            return null;
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onProgressUpdate(Integer... values) {
            tvCounter.setText(Integer.toString(values[0]));
        }

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(Void aVoid) {
            tvCounter.setText("*Done*");
        }
    }
}

