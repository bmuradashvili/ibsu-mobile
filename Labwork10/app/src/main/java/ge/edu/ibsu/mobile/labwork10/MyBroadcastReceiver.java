package ge.edu.ibsu.mobile.labwork10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Technology technology = (Technology) intent.getSerializableExtra(MyIntentService.EXTRA_TECHNOLOGY);
        MainActivity.getInstance().updateTextViews(technology);
    }
}
