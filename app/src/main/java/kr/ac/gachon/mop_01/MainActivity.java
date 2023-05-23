package kr.ac.gachon.mop_01;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String url = "https://upload.wikimedia.org/wikipedia/commons/3/33/Klaviersonate_Nr._24_Fis-Dur_A_Therese_-_Adagio_cantabile_-_Allegro_ma_non_troppo.ogg";
    MediaPlayer player;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Play
        Button button1 = findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio();
            }
        });

        //Stop
        Button button2 = findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAudio();
            }
        });

        //Pause
        Button button3 = findViewById(R.id.btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseAudio();
            }
        });

        //Restart
        Button button4 = findViewById(R.id.btn4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartAudio();
            }
        });

    }

    private void restartAudio() {
        showToast("음악 파일 재생 다시 시작됨");
        if (player != null && !player.isPlaying()) {
            try {
                player.start();
                player.seekTo(position);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void pauseAudio() {
        showToast("음악 파일 재생 일시 중지됨");
        if (player != null) {
            try {
                position = player.getCurrentPosition();
                player.pause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void stopAudio() {
        showToast("음악 파일 재생 중지됨");
        if (player != null) {
            try {
                player.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void playAudio() {
        showToast("음악 파일 재생 호출됨");

        killPlayer();

        player = new MediaPlayer();
        try {
            player.setDataSource(url);
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void killPlayer() {
        if (player != null) {
            try {
                player.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

