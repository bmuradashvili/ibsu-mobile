package ge.edu.ibsu.mobile.berdia.labwork5_appa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "MainActivity";
    private EditText etMessage;
    private Button bClear;
    private Button bSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewInit();
        eventListenerInit();
    }

    private void viewInit() {
        this.etMessage = (EditText) findViewById(R.id.etMessage);
        this.bClear = (Button) findViewById(R.id.bClear);
        this.bSend = (Button) findViewById(R.id.bSend);
    }

    private void eventListenerInit() {
        bClear.setOnClickListener(this);
        bSend.setOnClickListener(this);

        etMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().length() > 0) {
                    bSend.setText("");
                    bSend.setEnabled(true);
                } else {
                    bSend.setText(R.string.send);
                    bSend.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bClear:
                bClearOnClick();
                break;
            case R.id.bSend:
                bSendOnClick();
                break;
            default:
                break;
        }
    }

    private void bClearOnClick() {
        etMessage.setText("");
        Toast.makeText(MainActivity.this, "Message has been successfully cleaned", Toast.LENGTH_SHORT).show();
    }

    private void bSendOnClick() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, etMessage.getText().toString());
        intent.setType("text/plain");
        startActivity(intent);
    }
}
