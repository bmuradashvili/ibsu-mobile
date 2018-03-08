package ge.edu.ibsu.mobile.berdia.labwork3;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private static final String TAG = "MainActivity";

    private EditText etEmail;

    private EditText etPhone;

    private CheckBox cbRemember;

    private Button bLogin;

    private Button bCancel;

    private WebView wvContainer;

    private int bCancelClickCount;

    private Activity self;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        self = this;

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPhone = (EditText) findViewById(R.id.etPhone);
        cbRemember = (CheckBox) findViewById(R.id.cbRemember);
        bLogin = (Button) findViewById(R.id.bLogin);
        bCancel = (Button) findViewById(R.id.bCancel);
        wvContainer = (WebView) findViewById(R.id.wvContainer);

        bCancelClickCount = 0;

        bLogin.setOnClickListener(this);
        bCancel.setOnClickListener(this);

        cbRemember.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bLogin:
                bLoginOnClick();
                break;
            case R.id.bCancel:
                bCancelOnClick();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.cbRemember:
                cbRememberCheckedChange(b);
                break;
        }
    }

    private void bLoginOnClick() {
        Log.e(TAG, etEmail.getText().toString());
        cbRemember.setVisibility(View.VISIBLE);
    }

    private void bCancelOnClick() {
        bCancelClickCount += 1;

        if (bCancelClickCount % 3 == 1) {
            wvContainer.getSettings().setJavaScriptEnabled(true);
            wvContainer.loadUrl("file:///android_asset/index.html");
        } else if (bCancelClickCount % 3 == 2) {
            wvContainer.getSettings().setJavaScriptEnabled(false);

            wvContainer.setWebViewClient(new WebViewClient() {
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    Toast.makeText(self, description, Toast.LENGTH_SHORT).show();
                }
            });

            wvContainer.loadUrl("https://www.ibsu.edu.ge/en/");
        } else {
            wvContainer.loadUrl("about:blank");
        }
    }

    private void cbRememberCheckedChange(boolean checked) {
        if (checked)
            Toast.makeText(self, etEmail.getText().toString(), Toast.LENGTH_LONG).show();
    }

}
