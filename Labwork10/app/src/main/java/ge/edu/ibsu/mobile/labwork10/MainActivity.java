package ge.edu.ibsu.mobile.labwork10;

import android.content.IntentFilter;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static MainActivity self;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self = this;

        registerReceiver(new MyBroadcastReceiver(), new IntentFilter(MyIntentService.ACTION_SEND));

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Technology tech = new Technology("Java", 1983, "Sun Micron", "Javascript");
                MyIntentService.startActionSend(MainActivity.this, tech);
            }
        }, 3000);
    }

    public static MainActivity getInstance() {
        return self;
    }

    public void updateTextViews(final Technology t) {
        MainActivity.this.runOnUiThread(new Runnable() {
            public void run() {
                TextView tvName = findViewById(R.id.tvName);
                TextView tvYear = findViewById(R.id.tvYear);
                TextView tvDeveloper = findViewById(R.id.tvDeveloper);
                TextView tvSecondFavourite = findViewById(R.id.tvSecondFavourite);

                tvName.setText(t.getName());
                tvYear.setText(String.valueOf(t.getYear()));
                tvDeveloper.setText(t.getDeveloper());
                tvSecondFavourite.setText(t.getSecondFavourite());
            }
        });
    }
}
