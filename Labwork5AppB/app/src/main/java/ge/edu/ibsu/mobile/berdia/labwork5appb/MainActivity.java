package ge.edu.ibsu.mobile.berdia.labwork5appb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMessage = (TextView) findViewById(R.id.tvMessage);

        try {
            Intent intent = getIntent();
            String message = intent.getStringExtra(Intent.EXTRA_TEXT);
            tvMessage.setText(message);
        } catch (NullPointerException e) {
            Log.e(TAG, "onCreate: " + e.getMessage());
            Toast.makeText(this, "Oops, the message got lost", Toast.LENGTH_LONG).show();
        }
    }
}
