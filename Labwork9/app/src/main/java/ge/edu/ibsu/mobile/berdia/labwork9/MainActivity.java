package ge.edu.ibsu.mobile.berdia.labwork9;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final String MUSIC_TAG = "MUSIC_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        (new Handler()).postDelayed(this::launchMusicService, 1000);
    }

    private void launchMusicService() {
        Intent intent = new Intent(this, MusicService.class);
        intent.putExtra(MUSIC_TAG, "Berdia");
        startService(intent);
    }
}
