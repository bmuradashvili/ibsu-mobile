package ge.edu.ibsu.mobile.labwork11;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import ge.edu.ibsu.mobile.labwork11.activities.LoginActivity;
import ge.edu.ibsu.mobile.labwork11.utils.SharedPreferenceUtils;

public class InputService extends IntentService {
    public static final String ACTION_START_MAIN_ACTIVITY = "ge.edu.ibsu.mobile.labwork11.action.START_MAIN_ACTIVITY";

    public InputService() {
        super("InputService");
    }

    public InputService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (InputService.ACTION_START_MAIN_ACTIVITY.equals(action)) {

                String email = intent.getStringExtra(LoginActivity.EMAIL_TAG);
                SharedPreferenceUtils.getInstance(this).putString(LoginActivity.EMAIL_TAG, email);

                Intent broadcastIntent = new Intent(InputService.ACTION_START_MAIN_ACTIVITY);
                sendBroadcast(broadcastIntent);
            }
        }
    }
}
