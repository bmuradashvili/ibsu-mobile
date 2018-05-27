package ge.edu.ibsu.mobile.labwork11.activities;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ge.edu.ibsu.mobile.labwork11.InputBroadcastReceiver;
import ge.edu.ibsu.mobile.labwork11.InputService;
import ge.edu.ibsu.mobile.labwork11.R;
import ge.edu.ibsu.mobile.labwork11.utils.SharedPreferenceUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EMAIL_TAG = "EMAIL";
    private static final String CANCEL_TAG = "CANCEL_BUTTON";

    private final InputBroadcastReceiver mBroadcastReceiver = new InputBroadcastReceiver();

    private EditText etEmail;
    private EditText etPassword;
    private Button bSignIn;
    private Button bCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        checkSharedPreferences();
        viewInit();
        eventListenerInit();

        registerReceiver(mBroadcastReceiver, new IntentFilter(InputService.ACTION_START_MAIN_ACTIVITY));
    }

    @Override
    protected void onResume() {
        super.onResume();

        checkSharedPreferences();
    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(mBroadcastReceiver);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        registerReceiver(mBroadcastReceiver, new IntentFilter(InputService.ACTION_START_MAIN_ACTIVITY));
    }

    private void checkSharedPreferences() {
        if (SharedPreferenceUtils.getInstance(this).getString(LoginActivity.EMAIL_TAG) != null) {
            sendBroadcast(new Intent(InputService.ACTION_START_MAIN_ACTIVITY));
        }
    }

    private void viewInit() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        bSignIn = findViewById(R.id.bSignIn);
        bCancel = findViewById(R.id.bCancel);
    }

    private void eventListenerInit() {
        bSignIn.setOnClickListener(this);
        bCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int vId = v.getId();

        if (vId == bSignIn.getId()) {
            bSignInClick();
        } else if (vId == bCancel.getId()) {
            bCancelClick();
        }
    }

    private void bSignInClick() {
        Intent intent = new Intent(LoginActivity.this, InputService.class);
        intent.setAction(InputService.ACTION_START_MAIN_ACTIVITY);
        intent.putExtra(LoginActivity.EMAIL_TAG, etEmail.getText().toString());
        startService(intent);
    }

    private void bCancelClick() {
        Log.i(CANCEL_TAG, "bCancelClick has been clicked");
    }
}
