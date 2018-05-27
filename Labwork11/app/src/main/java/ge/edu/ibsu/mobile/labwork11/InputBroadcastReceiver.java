package ge.edu.ibsu.mobile.labwork11;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import ge.edu.ibsu.mobile.labwork11.activities.MainActivity;

public class InputBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        context.startActivity(new Intent(context, MainActivity.class));
    }
}
