package ge.edu.ibsu.mobile.labwork10;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // MyIntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String ACTION_SEND = "ge.edu.ibsu.mobile.labwork10.action.SEND";

    public static final String EXTRA_TECHNOLOGY = "ge.edu.ibsu.mobile.labwork10.extra.FAVOURITE_TECHNOLOGY";

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Send with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    public static void startActionSend(Context context, Technology favouriteTechnology) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_SEND);
        intent.putExtra(EXTRA_TECHNOLOGY, favouriteTechnology);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_SEND.equals(action)) {
                final Technology favouriteTechnology = (Technology) intent.getSerializableExtra(EXTRA_TECHNOLOGY);
                handleActionSend(favouriteTechnology);
            }
        }
    }

    /**
     * Handle action Send in the provided background thread with the provided
     * parameters.
     */
    private void handleActionSend(Technology favouriteTechnology) {
        Intent intent = new Intent(ACTION_SEND);
        intent.putExtra(EXTRA_TECHNOLOGY, favouriteTechnology);
        sendBroadcast(intent);
    }
}
