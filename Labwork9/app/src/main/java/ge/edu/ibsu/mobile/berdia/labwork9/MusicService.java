package ge.edu.ibsu.mobile.berdia.labwork9;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class MusicService extends IntentService {
    public static final String TAG = "INTENT_TAG";

    public MusicService() {
        super("music-service");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            String message = intent.getStringExtra(MainActivity.MUSIC_TAG);
            Log.e(TAG, "onHandleIntent: " + message);
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }

        MediaPlayer player = MediaPlayer.create(MusicService.this, R.raw.best_intro);
        player.start();
    }
}
